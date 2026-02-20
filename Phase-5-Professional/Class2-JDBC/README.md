# 🗄️ Class 2: Databases & JDBC

## Introduction

Welcome to **Databases & JDBC** - the essential skill for building data-driven Java applications! JDBC (Java Database Connectivity) is the standard API that allows Java programs to interact with relational databases like MySQL, PostgreSQL, SQLite, and Oracle.

Think of JDBC as a universal translator between your Java code and any database. Write once, connect to any database!

---

## 📚 Table of Contents

1. [What is JDBC?](#what-is-jdbc)
2. [Database Basics](#database-basics)
3. [Setting Up a Database](#setting-up-a-database)
4. [JDBC Architecture](#jdbc-architecture)
5. [Connecting to a Database](#connecting-to-a-database)
6. [Executing SQL Statements](#executing-sql-statements)
7. [PreparedStatement](#preparedstatement)
8. [ResultSet Processing](#resultset-processing)
9. [CRUD Operations](#crud-operations)
10. [Transactions](#transactions)
11. [Connection Pooling](#connection-pooling)
12. [DAO Pattern](#dao-pattern)
13. [Best Practices](#best-practices)
14. [Summary](#summary)

---

## What is JDBC?

**JDBC (Java Database Connectivity)** is a Java API that enables Java applications to:
- Connect to relational databases
- Execute SQL queries
- Retrieve and process results
- Manage transactions

### JDBC Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                     Java Application                         │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                       JDBC API                               │
│      (java.sql.Connection, Statement, ResultSet, etc.)       │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                   JDBC Driver Manager                        │
└─────────────────────────────────────────────────────────────┘
                              │
        ┌─────────────────────┼─────────────────────┐
        ▼                     ▼                     ▼
┌──────────────┐     ┌──────────────┐     ┌──────────────┐
│ MySQL Driver │     │ PostgreSQL   │     │ SQLite       │
│              │     │ Driver       │     │ Driver       │
└──────────────┘     └──────────────┘     └──────────────┘
        │                     │                     │
        ▼                     ▼                     ▼
┌──────────────┐     ┌──────────────┐     ┌──────────────┐
│    MySQL     │     │  PostgreSQL  │     │   SQLite     │
│   Database   │     │   Database   │     │  Database    │
└──────────────┘     └──────────────┘     └──────────────┘
```

### Key JDBC Interfaces

| Interface | Description |
|-----------|-------------|
| `Connection` | Represents a connection to a database |
| `Statement` | Executes static SQL statements |
| `PreparedStatement` | Executes parameterized SQL (prevents SQL injection) |
| `ResultSet` | Represents the result of a query |
| `DriverManager` | Manages database drivers and connections |

---

## Database Basics

Before diving into JDBC, let's review essential SQL concepts:

### SQL Fundamentals

```sql
-- CREATE: Define table structure
CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL,
    age INTEGER,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- INSERT: Add new records
INSERT INTO users (username, email, age) VALUES ('john_doe', 'john@email.com', 25);

-- SELECT: Retrieve records
SELECT * FROM users;                          -- All columns
SELECT username, email FROM users;            -- Specific columns
SELECT * FROM users WHERE age > 21;           -- With condition
SELECT * FROM users ORDER BY username ASC;    -- Sorted

-- UPDATE: Modify existing records
UPDATE users SET age = 26 WHERE username = 'john_doe';

-- DELETE: Remove records
DELETE FROM users WHERE id = 5;
```

### Common Data Types

| SQL Type | Java Type | Description |
|----------|-----------|-------------|
| `INTEGER` / `INT` | `int` / `Integer` | Whole numbers |
| `BIGINT` | `long` / `Long` | Large whole numbers |
| `REAL` / `FLOAT` | `float` / `Float` | Floating point |
| `DOUBLE` | `double` / `Double` | Double precision |
| `VARCHAR(n)` | `String` | Variable-length text |
| `TEXT` | `String` | Large text |
| `BOOLEAN` | `boolean` | True/false |
| `DATE` | `java.sql.Date` | Date only |
| `TIMESTAMP` | `java.sql.Timestamp` | Date and time |
| `BLOB` | `byte[]` | Binary data |

---

## Setting Up a Database

We'll use **SQLite** for learning - it's lightweight, requires no server, and stores the database in a single file.

### SQLite JDBC Driver

For a Maven project, add this dependency:

```xml
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.42.0.0</version>
</dependency>
```

For manual setup, download the JAR from [SQLite JDBC](https://github.com/xerial/sqlite-jdbc/releases) and add to classpath:

```bash
# Compile with driver
javac -cp ".:sqlite-jdbc-3.42.0.0.jar" YourProgram.java

# Run with driver
java -cp ".:sqlite-jdbc-3.42.0.0.jar" YourProgram
```

### Other Popular Databases

| Database | Driver Dependency | Connection URL |
|----------|-------------------|----------------|
| SQLite | `sqlite-jdbc` | `jdbc:sqlite:database.db` |
| MySQL | `mysql-connector-java` | `jdbc:mysql://localhost:3306/dbname` |
| PostgreSQL | `postgresql` | `jdbc:postgresql://localhost:5432/dbname` |
| H2 (Embedded) | `h2` | `jdbc:h2:./data/mydb` |

---

## Connecting to a Database

### Basic Connection

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        // SQLite connection URL (creates file if doesn't exist)
        String url = "jdbc:sqlite:myapp.db";
        
        // Try-with-resources ensures connection is closed
        try (Connection conn = DriverManager.getConnection(url)) {
            
            if (conn != null) {
                System.out.println("Connected to database!");
                System.out.println("Database: " + conn.getMetaData().getDatabaseProductName());
                System.out.println("Driver: " + conn.getMetaData().getDriverName());
            }
            
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}
```

**Line-by-line breakdown:**

```java
String url = "jdbc:sqlite:myapp.db";
```
- JDBC URL format: `jdbc:<subprotocol>:<subname>`
- For SQLite, the subname is the database file path

```java
try (Connection conn = DriverManager.getConnection(url)) {
```
- `DriverManager.getConnection()` establishes the connection
- Try-with-resources automatically closes the connection
- For other databases, you'd pass username and password too

```java
conn.getMetaData().getDatabaseProductName()
```
- `DatabaseMetaData` provides information about the database

### Connection with Username/Password

For databases requiring authentication:

```java
public class MySQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/myapp";
        String username = "root";
        String password = "password123";
        
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to MySQL!");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}
```

### Connection Properties

```java
import java.util.Properties;

public class ConnectionWithProperties {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/myapp";
        
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "password123");
        props.setProperty("useSSL", "true");
        props.setProperty("serverTimezone", "UTC");
        
        try (Connection conn = DriverManager.getConnection(url, props)) {
            System.out.println("Connected with properties!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

## Executing SQL Statements

### Statement Interface

`Statement` is used for simple, static SQL queries:

```java
import java.sql.*;

public class StatementExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:example.db";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            
            // CREATE TABLE
            String createSQL = """
                CREATE TABLE IF NOT EXISTS products (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    price REAL NOT NULL,
                    quantity INTEGER DEFAULT 0
                )
                """;
            stmt.execute(createSQL);
            System.out.println("Table created!");
            
            // INSERT - returns number of rows affected
            String insertSQL = "INSERT INTO products (name, price, quantity) VALUES ('Laptop', 999.99, 10)";
            int rowsInserted = stmt.executeUpdate(insertSQL);
            System.out.println("Rows inserted: " + rowsInserted);
            
            // SELECT - returns ResultSet
            String selectSQL = "SELECT * FROM products";
            ResultSet rs = stmt.executeQuery(selectSQL);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int qty = rs.getInt("quantity");
                
                System.out.printf("Product: %d - %s ($%.2f) x%d%n", id, name, price, qty);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### Execute Methods

| Method | Use Case | Returns |
|--------|----------|---------|
| `execute(sql)` | DDL (CREATE, ALTER, DROP) | `boolean` (true if ResultSet) |
| `executeQuery(sql)` | SELECT queries | `ResultSet` |
| `executeUpdate(sql)` | INSERT, UPDATE, DELETE | `int` (rows affected) |

---

## PreparedStatement

**PreparedStatement** is the preferred way to execute SQL - it prevents SQL injection and improves performance!

### Why PreparedStatement?

```java
// ❌ DANGEROUS - SQL Injection vulnerability!
String username = "admin'; DROP TABLE users; --";
String badSQL = "SELECT * FROM users WHERE username = '" + username + "'";
// Results in: SELECT * FROM users WHERE username = 'admin'; DROP TABLE users; --'

// ✅ SAFE - PreparedStatement handles escaping
String safeSQL = "SELECT * FROM users WHERE username = ?";
PreparedStatement pstmt = conn.prepareStatement(safeSQL);
pstmt.setString(1, username);  // Safely escaped
```

### Using PreparedStatement

```java
import java.sql.*;

public class PreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:store.db";
        
        try (Connection conn = DriverManager.getConnection(url)) {
            
            // Create table
            String createSQL = """
                CREATE TABLE IF NOT EXISTS customers (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    email TEXT UNIQUE,
                    balance REAL DEFAULT 0.0
                )
                """;
            conn.createStatement().execute(createSQL);
            
            // INSERT with PreparedStatement
            String insertSQL = "INSERT INTO customers (name, email, balance) VALUES (?, ?, ?)";
            
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                // First customer
                pstmt.setString(1, "Alice Smith");      // Parameter 1
                pstmt.setString(2, "alice@email.com");  // Parameter 2
                pstmt.setDouble(3, 1500.00);            // Parameter 3
                pstmt.executeUpdate();
                
                // Second customer (reuse PreparedStatement)
                pstmt.setString(1, "Bob Johnson");
                pstmt.setString(2, "bob@email.com");
                pstmt.setDouble(3, 2300.50);
                pstmt.executeUpdate();
                
                System.out.println("Customers inserted!");
            }
            
            // SELECT with PreparedStatement
            String selectSQL = "SELECT * FROM customers WHERE balance > ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                pstmt.setDouble(1, 1000.00);
                
                try (ResultSet rs = pstmt.executeQuery()) {
                    System.out.println("\nCustomers with balance > $1000:");
                    while (rs.next()) {
                        System.out.printf("  %s - %s ($%.2f)%n",
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getDouble("balance"));
                    }
                }
            }
            
            // UPDATE with PreparedStatement
            String updateSQL = "UPDATE customers SET balance = balance + ? WHERE email = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                pstmt.setDouble(1, 500.00);           // Add $500
                pstmt.setString(2, "alice@email.com");
                int updated = pstmt.executeUpdate();
                System.out.println("\nRows updated: " + updated);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### PreparedStatement Setter Methods

| Method | Java Type | SQL Type |
|--------|-----------|----------|
| `setInt(index, value)` | `int` | INTEGER |
| `setLong(index, value)` | `long` | BIGINT |
| `setDouble(index, value)` | `double` | DOUBLE |
| `setString(index, value)` | `String` | VARCHAR/TEXT |
| `setBoolean(index, value)` | `boolean` | BOOLEAN |
| `setDate(index, value)` | `java.sql.Date` | DATE |
| `setTimestamp(index, value)` | `java.sql.Timestamp` | TIMESTAMP |
| `setNull(index, sqlType)` | null | Any |
| `setBytes(index, value)` | `byte[]` | BLOB |

### Batch Processing

Insert multiple records efficiently:

```java
public class BatchInsertExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:batch.db";
        
        try (Connection conn = DriverManager.getConnection(url)) {
            conn.setAutoCommit(false);  // Start transaction
            
            String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                // Add multiple inserts to batch
                String[] products = {"Keyboard", "Mouse", "Monitor", "Webcam", "Headset"};
                double[] prices = {79.99, 29.99, 299.99, 89.99, 149.99};
                
                for (int i = 0; i < products.length; i++) {
                    pstmt.setString(1, products[i]);
                    pstmt.setDouble(2, prices[i]);
                    pstmt.addBatch();  // Add to batch
                }
                
                // Execute all at once
                int[] results = pstmt.executeBatch();
                conn.commit();  // Commit transaction
                
                System.out.println("Batch inserted " + results.length + " rows!");
                
            } catch (SQLException e) {
                conn.rollback();  // Rollback on error
                throw e;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

## ResultSet Processing

### Navigating ResultSet

```java
import java.sql.*;

public class ResultSetExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:example.db";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");
            
            // Get metadata
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();
            
            // Print column names
            System.out.println("Columns:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("  %d. %s (%s)%n", 
                    i, 
                    meta.getColumnName(i),
                    meta.getColumnTypeName(i));
            }
            
            // Iterate through rows
            System.out.println("\nData:");
            while (rs.next()) {
                // Access by column index (1-based)
                int id = rs.getInt(1);
                
                // Access by column name (preferred)
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                
                // Check for NULL values
                int qty = rs.getInt("quantity");
                if (rs.wasNull()) {
                    System.out.println("  " + name + " - quantity is NULL");
                } else {
                    System.out.printf("  %s: $%.2f x%d%n", name, price, qty);
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### ResultSet Getter Methods

| Method | Returns | For SQL Types |
|--------|---------|---------------|
| `getInt(col)` | `int` | INTEGER |
| `getLong(col)` | `long` | BIGINT |
| `getDouble(col)` | `double` | DOUBLE, REAL |
| `getString(col)` | `String` | VARCHAR, TEXT |
| `getBoolean(col)` | `boolean` | BOOLEAN |
| `getDate(col)` | `java.sql.Date` | DATE |
| `getTimestamp(col)` | `Timestamp` | TIMESTAMP |
| `getBytes(col)` | `byte[]` | BLOB |
| `getObject(col)` | `Object` | Any |

### Scrollable ResultSet

By default, ResultSet is forward-only. Create a scrollable one:

```java
Statement stmt = conn.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE,  // Scrollable, snapshot
    ResultSet.CONCUR_READ_ONLY          // Read-only
);

ResultSet rs = stmt.executeQuery("SELECT * FROM products");

// Navigation methods
rs.first();      // Move to first row
rs.last();       // Move to last row
rs.previous();   // Move to previous row
rs.absolute(5);  // Move to row 5
rs.relative(-2); // Move 2 rows back

// Position checks
rs.isFirst();
rs.isLast();
rs.getRow();     // Current row number
```

---

## CRUD Operations

Complete example of Create, Read, Update, Delete:

```java
import java.sql.*;

public class CRUDExample {
    private static final String URL = "jdbc:sqlite:crud_demo.db";
    
    public static void main(String[] args) {
        createTable();
        
        // CREATE
        int id1 = createUser("alice", "alice@email.com", 25);
        int id2 = createUser("bob", "bob@email.com", 30);
        System.out.println("Created users with IDs: " + id1 + ", " + id2);
        
        // READ
        System.out.println("\nAll users:");
        readAllUsers();
        
        System.out.println("\nUser with ID " + id1 + ":");
        readUserById(id1);
        
        // UPDATE
        updateUserEmail(id1, "alice.smith@email.com");
        System.out.println("\nAfter update:");
        readUserById(id1);
        
        // DELETE
        deleteUser(id2);
        System.out.println("\nAfter deleting user " + id2 + ":");
        readAllUsers();
    }
    
    // CREATE TABLE
    private static void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL UNIQUE,
                email TEXT NOT NULL,
                age INTEGER,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            )
            """;
        
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // CREATE (Insert)
    private static int createUser(String username, String email, int age) {
        String sql = "INSERT INTO users (username, email, age) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql, 
                 Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
            
            // Get the auto-generated ID
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    // READ (Select All)
    private static void readAllUsers() {
        String sql = "SELECT * FROM users ORDER BY id";
        
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                System.out.printf("  [%d] %s (%s) - Age: %d%n",
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getInt("age"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // READ (Select By ID)
    private static void readUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.printf("  [%d] %s (%s) - Age: %d%n",
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getInt("age"));
                } else {
                    System.out.println("  User not found!");
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // UPDATE
    private static void updateUserEmail(int id, String newEmail) {
        String sql = "UPDATE users SET email = ? WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, id);
            
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // DELETE
    private static void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

## Transactions

Transactions ensure multiple operations succeed or fail together (ACID properties).

### Transaction Basics

```java
import java.sql.*;

public class TransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";
        
        try (Connection conn = DriverManager.getConnection(url)) {
            // Setup
            setupAccounts(conn);
            
            System.out.println("Before transfer:");
            showBalances(conn);
            
            // Transfer $500 from Alice to Bob
            boolean success = transferMoney(conn, "Alice", "Bob", 500.00);
            
            System.out.println("\nTransfer " + (success ? "successful!" : "failed!"));
            System.out.println("\nAfter transfer:");
            showBalances(conn);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static boolean transferMoney(Connection conn, String from, String to, double amount) {
        String withdrawSQL = "UPDATE accounts SET balance = balance - ? WHERE name = ? AND balance >= ?";
        String depositSQL = "UPDATE accounts SET balance = balance + ? WHERE name = ?";
        
        try {
            // Disable auto-commit (start transaction)
            conn.setAutoCommit(false);
            
            // Withdraw from sender
            try (PreparedStatement withdrawStmt = conn.prepareStatement(withdrawSQL)) {
                withdrawStmt.setDouble(1, amount);
                withdrawStmt.setString(2, from);
                withdrawStmt.setDouble(3, amount);  // Check sufficient balance
                
                int withdrawn = withdrawStmt.executeUpdate();
                if (withdrawn == 0) {
                    System.out.println("Insufficient funds or account not found!");
                    conn.rollback();  // Cancel transaction
                    return false;
                }
            }
            
            // Deposit to receiver
            try (PreparedStatement depositStmt = conn.prepareStatement(depositSQL)) {
                depositStmt.setDouble(1, amount);
                depositStmt.setString(2, to);
                
                int deposited = depositStmt.executeUpdate();
                if (deposited == 0) {
                    System.out.println("Recipient account not found!");
                    conn.rollback();  // Cancel transaction
                    return false;
                }
            }
            
            // Both operations successful - commit!
            conn.commit();
            return true;
            
        } catch (SQLException e) {
            // Error occurred - rollback all changes
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
            
        } finally {
            // Restore auto-commit
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void setupAccounts(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute("DROP TABLE IF EXISTS accounts");
        stmt.execute("""
            CREATE TABLE accounts (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT UNIQUE,
                balance REAL
            )
            """);
        stmt.execute("INSERT INTO accounts (name, balance) VALUES ('Alice', 1000.00)");
        stmt.execute("INSERT INTO accounts (name, balance) VALUES ('Bob', 500.00)");
    }
    
    private static void showBalances(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name, balance FROM accounts");
        while (rs.next()) {
            System.out.printf("  %s: $%.2f%n", rs.getString("name"), rs.getDouble("balance"));
        }
    }
}
```

### Transaction Isolation Levels

```java
// Set isolation level before starting transaction
conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

// Available levels:
// TRANSACTION_READ_UNCOMMITTED - Lowest isolation, dirty reads possible
// TRANSACTION_READ_COMMITTED   - No dirty reads
// TRANSACTION_REPEATABLE_READ  - No non-repeatable reads
// TRANSACTION_SERIALIZABLE     - Highest isolation, no phantom reads
```

### Savepoints

Partial rollbacks within a transaction:

```java
conn.setAutoCommit(false);

// Do some work
stmt.execute("INSERT INTO log (message) VALUES ('Step 1')");

// Create savepoint
Savepoint savepoint = conn.setSavepoint("afterStep1");

try {
    // More work that might fail
    stmt.execute("INSERT INTO log (message) VALUES ('Step 2')");
    riskyOperation();  // Might throw exception
    stmt.execute("INSERT INTO log (message) VALUES ('Step 3')");
    
} catch (Exception e) {
    // Rollback to savepoint (keeps Step 1)
    conn.rollback(savepoint);
}

conn.commit();  // Commits Step 1 (and Step 2-3 if no error)
```

---

## Connection Pooling

Creating connections is expensive. Connection pools reuse connections:

### HikariCP (Recommended)

```xml
<!-- Maven dependency -->
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>5.0.1</version>
</dependency>
```

```java
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.*;

public class ConnectionPoolExample {
    private static HikariDataSource dataSource;
    
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlite:pooled.db");
        config.setMaximumPoolSize(10);          // Max connections
        config.setMinimumIdle(2);               // Min idle connections
        config.setIdleTimeout(300000);          // 5 minutes
        config.setConnectionTimeout(20000);     // 20 seconds
        config.setMaxLifetime(1200000);         // 20 minutes
        
        dataSource = new HikariDataSource(config);
    }
    
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    
    public static void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
    
    public static void main(String[] args) {
        // Use connections from pool
        try (Connection conn = getConnection()) {
            // Connection is automatically returned to pool when closed
            System.out.println("Got connection from pool!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Shutdown pool when app exits
        close();
    }
}
```

### Simple Connection Pool (Without External Library)

```java
import java.sql.*;
import java.util.concurrent.*;

public class SimpleConnectionPool {
    private final BlockingQueue<Connection> pool;
    private final String url;
    private final int poolSize;
    
    public SimpleConnectionPool(String url, int poolSize) throws SQLException {
        this.url = url;
        this.poolSize = poolSize;
        this.pool = new LinkedBlockingQueue<>(poolSize);
        
        // Pre-create connections
        for (int i = 0; i < poolSize; i++) {
            pool.add(DriverManager.getConnection(url));
        }
    }
    
    public Connection getConnection() throws InterruptedException {
        return pool.take();  // Blocks if no connections available
    }
    
    public void releaseConnection(Connection conn) {
        if (conn != null) {
            pool.offer(conn);
        }
    }
    
    public void shutdown() throws SQLException {
        for (Connection conn : pool) {
            conn.close();
        }
    }
}
```

---

## DAO Pattern

**Data Access Object (DAO)** pattern separates database logic from business logic.

### Entity Class (Model)

```java
public class User {
    private int id;
    private String username;
    private String email;
    private int age;
    
    // Constructors
    public User() {}
    
    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
    
    public User(int id, String username, String email, int age) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    @Override
    public String toString() {
        return String.format("User[id=%d, username=%s, email=%s, age=%d]",
            id, username, email, age);
    }
}
```

### DAO Interface

```java
import java.util.List;
import java.util.Optional;

public interface UserDao {
    // Create
    User save(User user);
    
    // Read
    Optional<User> findById(int id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    
    // Update
    boolean update(User user);
    
    // Delete
    boolean delete(int id);
    
    // Count
    int count();
}
```

### DAO Implementation

```java
import java.sql.*;
import java.util.*;

public class UserDaoImpl implements UserDao {
    private final String url;
    
    public UserDaoImpl(String url) {
        this.url = url;
        createTable();
    }
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
    
    private void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL UNIQUE,
                email TEXT NOT NULL,
                age INTEGER
            )
            """;
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table", e);
        }
    }
    
    @Override
    public User save(User user) {
        String sql = "INSERT INTO users (username, email, age) VALUES (?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,
                 Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setInt(3, user.getAge());
            pstmt.executeUpdate();
            
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    user.setId(keys.getInt(1));
                }
            }
            
            return user;
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save user", e);
        }
    }
    
    @Override
    public Optional<User> findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find user", e);
        }
        
        return Optional.empty();
    }
    
    @Override
    public Optional<User> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find user", e);
        }
        
        return Optional.empty();
    }
    
    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users ORDER BY id";
        List<User> users = new ArrayList<>();
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                users.add(mapRow(rs));
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find users", e);
        }
        
        return users;
    }
    
    @Override
    public boolean update(User user) {
        String sql = "UPDATE users SET username = ?, email = ?, age = ? WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setInt(3, user.getAge());
            pstmt.setInt(4, user.getId());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update user", e);
        }
    }
    
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete user", e);
        }
    }
    
    @Override
    public int count() {
        String sql = "SELECT COUNT(*) FROM users";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getInt(1);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to count users", e);
        }
        
        return 0;
    }
    
    // Helper method to map ResultSet row to User object
    private User mapRow(ResultSet rs) throws SQLException {
        return new User(
            rs.getInt("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getInt("age")
        );
    }
}
```

### Using the DAO

```java
public class DaoUsageExample {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl("jdbc:sqlite:dao_demo.db");
        
        // Create users
        User alice = userDao.save(new User("alice", "alice@email.com", 25));
        User bob = userDao.save(new User("bob", "bob@email.com", 30));
        
        System.out.println("Created: " + alice);
        System.out.println("Created: " + bob);
        
        // Find by ID
        userDao.findById(alice.getId())
            .ifPresent(u -> System.out.println("Found: " + u));
        
        // Find all
        System.out.println("\nAll users:");
        userDao.findAll().forEach(System.out::println);
        
        // Update
        alice.setAge(26);
        userDao.update(alice);
        System.out.println("\nUpdated: " + userDao.findById(alice.getId()).orElse(null));
        
        // Delete
        userDao.delete(bob.getId());
        System.out.println("\nCount after delete: " + userDao.count());
    }
}
```

---

## Best Practices

### 1. Always Use Try-With-Resources

```java
// ✅ Good - auto-closes resources
try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement pstmt = conn.prepareStatement(sql);
     ResultSet rs = pstmt.executeQuery()) {
    // Process results
}

// ❌ Bad - manual resource management (error-prone)
Connection conn = null;
try {
    conn = DriverManager.getConnection(url);
    // ...
} finally {
    if (conn != null) conn.close();  // Easy to forget!
}
```

### 2. Always Use PreparedStatement

```java
// ✅ Good - prevents SQL injection
String sql = "SELECT * FROM users WHERE username = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, userInput);

// ❌ Bad - SQL injection vulnerability!
String sql = "SELECT * FROM users WHERE username = '" + userInput + "'";
Statement stmt = conn.createStatement();
```

### 3. Use Connection Pools in Production

```java
// ❌ Bad for production - creates new connection each time
Connection conn = DriverManager.getConnection(url);

// ✅ Good - reuses connections from pool
Connection conn = connectionPool.getConnection();
```

### 4. Handle Exceptions Properly

```java
try {
    // Database operations
} catch (SQLException e) {
    // Log the error
    logger.error("Database error: " + e.getMessage(), e);
    
    // Check specific error codes if needed
    if (e.getErrorCode() == 1062) {  // MySQL duplicate key
        throw new DuplicateKeyException("Record already exists");
    }
    
    // Re-throw or handle appropriately
    throw new DataAccessException("Failed to perform operation", e);
}
```

### 5. Use Transactions for Multiple Operations

```java
conn.setAutoCommit(false);
try {
    // Multiple operations
    conn.commit();
} catch (SQLException e) {
    conn.rollback();
    throw e;
} finally {
    conn.setAutoCommit(true);
}
```

### 6. Close Resources in Reverse Order

```java
// Open: Connection → Statement → ResultSet
// Close: ResultSet → Statement → Connection
```

---

## Summary

### Key Concepts Learned

| Concept | Description |
|---------|-------------|
| **JDBC** | Java API for database connectivity |
| **Connection** | Represents database connection |
| **Statement** | Executes static SQL |
| **PreparedStatement** | Executes parameterized SQL (safe!) |
| **ResultSet** | Holds query results |
| **Transaction** | Groups operations atomically |
| **Connection Pool** | Reuses connections efficiently |
| **DAO Pattern** | Separates data access logic |

### JDBC Workflow

```
1. Load driver (automatic in modern JDBC)
2. Get connection from DriverManager or pool
3. Create Statement or PreparedStatement
4. Execute query (executeQuery) or update (executeUpdate)
5. Process ResultSet if applicable
6. Close resources (use try-with-resources!)
```

### Quick Reference

```java
// Connect
Connection conn = DriverManager.getConnection(url);

// Query
PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
pstmt.setInt(1, userId);
ResultSet rs = pstmt.executeQuery();

// Process results
while (rs.next()) {
    String name = rs.getString("name");
}

// Insert/Update/Delete
int rows = pstmt.executeUpdate();

// Transaction
conn.setAutoCommit(false);
// ... operations ...
conn.commit();  // or conn.rollback();
```

---

## 🎯 What's Next?

Now that you can persist data, you're ready for:
- **Class 3: Design Patterns** - Architectural best practices

---

## 📚 Additional Resources

- [JDBC Tutorial (Oracle)](https://docs.oracle.com/javase/tutorial/jdbc/)
- [SQLite JDBC Driver](https://github.com/xerial/sqlite-jdbc)
- [HikariCP Connection Pool](https://github.com/brettwooldridge/HikariCP)
- [SQL Tutorial](https://www.w3schools.com/sql/)

---

**Practice makes perfect! Complete the exercises in `Exercises.md` to master database programming!** 🗄️
