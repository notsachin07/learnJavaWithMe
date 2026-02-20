# 🗄️ Class 2: Databases & JDBC - Exercises

Practice database operations from basic queries to advanced patterns!

---

## 📝 Exercise Format

Each exercise includes:
- **Objective**: What you'll accomplish
- **Requirements**: Specific implementation details
- **Hints**: Helpful tips if you get stuck
- **Expected Output**: Sample program output

---

## 🟢 Easy Exercises

### Exercise 1: Simple Database Setup
**Objective:** Create a SQLite database with a students table and insert data.

**Requirements:**
1. Create a connection to `school.db`
2. Create a `students` table with:
   - `id` (INTEGER PRIMARY KEY AUTOINCREMENT)
   - `name` (TEXT NOT NULL)
   - `grade` (INTEGER)
   - `gpa` (REAL)
3. Insert 3 students using PreparedStatement
4. Display all students

**Hints:**
- Use try-with-resources for auto-closing
- Remember to handle SQLException
- Use `setInt()`, `setString()`, `setDouble()` for parameters

**Expected Output:**
```
Database created: school.db
Table 'students' created.

Inserted students:
  [1] Alice - Grade 10, GPA: 3.8
  [2] Bob - Grade 11, GPA: 3.2
  [3] Carol - Grade 10, GPA: 3.9

All students retrieved successfully!
```

---

### Exercise 2: Query with Conditions
**Objective:** Perform various SELECT queries with WHERE clauses.

**Requirements:**
1. Using the students database from Exercise 1
2. Write queries to:
   - Find all Grade 10 students
   - Find students with GPA >= 3.5
   - Find students whose name starts with 'A'
   - Count total students
3. Display results for each query

**Hints:**
- Use PreparedStatement for parameterized queries
- Use `LIKE` for pattern matching: `name LIKE 'A%'`
- Use `COUNT(*)` for counting

**Expected Output:**
```
=== Grade 10 Students ===
  Alice - GPA: 3.8
  Carol - GPA: 3.9

=== Students with GPA >= 3.5 ===
  Alice - GPA: 3.8
  Carol - GPA: 3.9

=== Names starting with 'A' ===
  Alice

=== Total Student Count ===
  3 students
```

---

### Exercise 3: Update and Delete Operations
**Objective:** Practice UPDATE and DELETE SQL operations.

**Requirements:**
1. Create a `books` table (id, title, author, price, in_stock)
2. Insert 5 books
3. Update: Apply 10% discount to all books over $20
4. Update: Set in_stock = false for a specific book
5. Delete: Remove all books with price < $10
6. Show the table state after each operation

**Hints:**
- Use `UPDATE table SET column = value WHERE condition`
- Use `DELETE FROM table WHERE condition`
- Return rows affected from `executeUpdate()`

**Expected Output:**
```
=== Initial Books ===
1. "Java Basics" by Smith - $25.00 (In Stock)
2. "SQL Guide" by Jones - $30.00 (In Stock)
3. "Python 101" by Wilson - $8.00 (In Stock)
4. "Web Dev" by Brown - $22.00 (In Stock)
5. "Data Science" by Lee - $35.00 (In Stock)

=== After 10% discount on books > $20 ===
1. "Java Basics" - $22.50
2. "SQL Guide" - $27.00
4. "Web Dev" - $19.80
5. "Data Science" - $31.50

=== After marking "Python 101" out of stock ===
3. "Python 101" - In Stock: false

=== After deleting books < $10 ===
Deleted 1 book(s)
Remaining: 4 books
```

---

## 🟡 Medium Exercises

### Exercise 4: Employee Management System
**Objective:** Build a complete CRUD system for employees.

**Requirements:**
1. Create `employees` table:
   - id, name, department, salary, hire_date
2. Implement these methods:
   - `addEmployee(name, dept, salary)` - returns generated ID
   - `findById(id)` - returns employee or null
   - `findByDepartment(dept)` - returns list
   - `updateSalary(id, newSalary)` - returns success boolean
   - `delete(id)` - returns success boolean
   - `getAverageSalaryByDept()` - returns map of dept → avg salary
3. Demonstrate all operations

**Hints:**
- Use `Statement.RETURN_GENERATED_KEYS` to get auto-generated IDs
- Use `java.sql.Date` for hire_date
- Use `GROUP BY` for average by department

**Expected Output:**
```
=== Employee Management System ===

Adding employees...
  Added: John (ID: 1) - Engineering
  Added: Jane (ID: 2) - Engineering
  Added: Bob (ID: 3) - Sales
  Added: Alice (ID: 4) - HR

Finding by ID (2):
  Employee: Jane, Engineering, $75000

Finding by Department (Engineering):
  John - $80000
  Jane - $75000

Updating salary for ID 1 to $85000...
  Success: true

Average salary by department:
  Engineering: $80000.00
  Sales: $65000.00
  HR: $70000.00

Deleting employee ID 3...
  Deleted: true
  Remaining employees: 3
```

---

### Exercise 5: Transaction - Order Processing
**Objective:** Implement atomic order processing with transactions.

**Requirements:**
1. Create tables:
   - `inventory` (product_id, product_name, quantity, price)
   - `orders` (order_id, product_id, quantity, total, order_date)
2. Implement `processOrder(productId, quantity, customerName)`:
   - Check if enough stock exists
   - Decrease inventory
   - Create order record
   - All in one transaction (commit/rollback)
3. Test with:
   - Successful order
   - Order with insufficient stock (should rollback)
   - Order for non-existent product (should rollback)

**Hints:**
- Use `conn.setAutoCommit(false)` to start transaction
- Use `conn.commit()` on success
- Use `conn.rollback()` on failure
- Always restore `setAutoCommit(true)` in finally

**Expected Output:**
```
=== Order Processing System ===

Initial Inventory:
  [1] Laptop - 10 units @ $999.99
  [2] Mouse - 50 units @ $29.99
  [3] Keyboard - 30 units @ $79.99

Processing order: 3 Laptops for "John Doe"
  ✓ Order processed! Total: $2999.97
  Laptop inventory: 10 → 7

Processing order: 100 Mice for "Jane Smith"
  ✗ Order failed: Insufficient stock (need 100, have 50)
  Transaction rolled back
  Mouse inventory unchanged: 50

Processing order: Product ID 999
  ✗ Order failed: Product not found
  Transaction rolled back

Final Inventory:
  [1] Laptop - 7 units
  [2] Mouse - 50 units
  [3] Keyboard - 30 units
```

---

### Exercise 6: Batch Import from CSV
**Objective:** Import data from a CSV-like format using batch processing.

**Requirements:**
1. Create a `contacts` table (id, name, email, phone, city)
2. Parse this data (simulate CSV):
   ```
   Alice,alice@email.com,555-0101,New York
   Bob,bob@email.com,555-0102,Los Angeles
   Carol,carol@email.com,555-0103,Chicago
   David,david@email.com,555-0104,Houston
   Eve,eve@email.com,555-0105,Phoenix
   ```
3. Use batch processing to insert all records efficiently
4. Compare time: batch vs individual inserts
5. Handle any duplicate emails gracefully

**Hints:**
- Use `pstmt.addBatch()` to add each insert
- Use `pstmt.executeBatch()` to execute all at once
- Wrap in transaction for atomicity
- Catch `BatchUpdateException` for partial failures

**Expected Output:**
```
=== Batch Import Demo ===

Importing 5 contacts...

Individual inserts:
  Inserted 5 records in 47ms

Clearing table...

Batch insert:
  Inserted 5 records in 8ms

Speedup: 5.9x faster with batch!

Imported Contacts:
  Alice (alice@email.com) - New York
  Bob (bob@email.com) - Los Angeles
  Carol (carol@email.com) - Chicago
  David (david@email.com) - Houston
  Eve (eve@email.com) - Phoenix
```

---

## 🔴 Hard Exercises

### Exercise 7: Generic DAO Framework
**Objective:** Build a reusable generic DAO pattern.

**Requirements:**
1. Create a generic interface:
   ```java
   public interface GenericDao<T, ID> {
       T save(T entity);
       Optional<T> findById(ID id);
       List<T> findAll();
       boolean update(T entity);
       boolean delete(ID id);
       long count();
   }
   ```
2. Create an abstract base implementation with common logic
3. Implement for two entities: `User` and `Product`
4. Each entity needs:
   - Entity class with appropriate fields
   - Concrete DAO extending the base
   - Table name and column mapping
5. Demonstrate with both DAOs

**Hints:**
- Use reflection or abstract methods for mapping
- Abstract methods: `getTableName()`, `mapRow()`, `getInsertSQL()`, etc.
- Consider using annotations for column mapping (advanced)

**Expected Output:**
```
=== Generic DAO Framework Demo ===

--- User DAO ---
Created: User[id=1, name=Alice, email=alice@email.com]
Created: User[id=2, name=Bob, email=bob@email.com]
FindById(1): User[id=1, name=Alice, email=alice@email.com]
Count: 2

--- Product DAO ---
Created: Product[id=1, name=Laptop, price=999.99]
Created: Product[id=2, name=Mouse, price=29.99]
FindAll: [Product[id=1...], Product[id=2...]]
Count: 2

Both DAOs share the same base implementation!
```

---

### Exercise 8: Connection Pool Implementation
**Objective:** Implement a simple connection pool from scratch.

**Requirements:**
1. Create a `ConnectionPool` class:
   - Constructor takes: URL, pool size
   - Pre-creates connections
   - `getConnection()` - returns available connection (blocks if none)
   - `releaseConnection(conn)` - returns connection to pool
   - `shutdown()` - closes all connections
2. Track pool statistics:
   - Connections in use
   - Connections available
   - Total connections created
   - Wait time when pool exhausted
3. Test with concurrent threads requesting connections

**Hints:**
- Use `BlockingQueue<Connection>` for thread-safe pool
- Use `Semaphore` or blocking queue to limit connections
- Track statistics with `AtomicInteger`
- Test with more threads than pool size

**Expected Output:**
```
=== Connection Pool Demo ===

Pool created: 5 connections

Starting 10 threads, each needs a connection for 1 second...

[Thread-1] Got connection, working...
[Thread-2] Got connection, working...
[Thread-3] Got connection, working...
[Thread-4] Got connection, working...
[Thread-5] Got connection, working...
[Thread-6] Waiting for connection...
[Thread-1] Released connection
[Thread-6] Got connection (waited 234ms), working...
...

=== Pool Statistics ===
Total connections: 5
Peak usage: 5
Average wait time: 156ms
Total requests: 10

Pool shutdown complete.
```

---

### Exercise 9: Database Migration System
**Objective:** Build a simple database migration/versioning system.

**Requirements:**
1. Create a `schema_version` table to track applied migrations
2. Create a `Migration` interface:
   ```java
   interface Migration {
       int getVersion();
       String getDescription();
       void up(Connection conn) throws SQLException;
       void down(Connection conn) throws SQLException;
   }
   ```
3. Create a `MigrationRunner` that:
   - Checks current database version
   - Applies pending migrations in order
   - Records each migration
   - Supports rollback
4. Create 3 sample migrations:
   - V1: Create users table
   - V2: Add email column to users
   - V3: Create posts table with foreign key to users
5. Demonstrate upgrade and rollback

**Hints:**
- Store version, description, applied_at in schema_version
- Run migrations in a transaction
- Check version before applying each migration
- Support partial rollback (to specific version)

**Expected Output:**
```
=== Database Migration System ===

Current version: 0 (no migrations applied)

Available migrations:
  V1: Create users table
  V2: Add email column to users
  V3: Create posts table

Applying migrations...
  ✓ V1: Create users table (took 12ms)
  ✓ V2: Add email column to users (took 8ms)
  ✓ V3: Create posts table (took 15ms)

Current version: 3

Tables in database:
  - schema_version
  - users
  - posts

Rolling back to version 1...
  ↓ V3: Dropped posts table
  ↓ V2: Removed email column

Current version: 1

Tables in database:
  - schema_version
  - users
```

---

## 🏆 Bonus Challenge: Library Management System

**Objective:** Build a complete library management database application.

**Requirements:**

### Database Schema:
```sql
-- Books
CREATE TABLE books (
    isbn TEXT PRIMARY KEY,
    title TEXT NOT NULL,
    author TEXT NOT NULL,
    published_year INTEGER,
    copies_total INTEGER DEFAULT 1,
    copies_available INTEGER DEFAULT 1
);

-- Members
CREATE TABLE members (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT UNIQUE,
    membership_date DATE,
    is_active BOOLEAN DEFAULT true
);

-- Loans
CREATE TABLE loans (
    id INTEGER PRIMARY KEY,
    book_isbn TEXT REFERENCES books(isbn),
    member_id INTEGER REFERENCES members(id),
    loan_date DATE NOT NULL,
    due_date DATE NOT NULL,
    return_date DATE,
    fine REAL DEFAULT 0
);
```

### Implement:
1. **Book Management:**
   - Add, update, delete books
   - Search by title, author, ISBN
   - Check availability

2. **Member Management:**
   - Register, update, deactivate members
   - View member history

3. **Loan Operations:**
   - Borrow book (check availability, update copies)
   - Return book (calculate fine if overdue)
   - Extend loan (if not overdue)

4. **Reports:**
   - Currently borrowed books
   - Overdue books with fines
   - Most popular books
   - Active members

5. **Business Rules:**
   - Max 5 books per member
   - Loan period: 14 days
   - Fine: $0.50 per day overdue
   - Can't borrow if outstanding fines > $10

**Expected Output:**
```
╔═══════════════════════════════════════╗
║      LIBRARY MANAGEMENT SYSTEM        ║
╚═══════════════════════════════════════╝

=== Adding Books ===
✓ Added: "Clean Code" by Robert Martin (ISBN: 978-0132350884)
✓ Added: "Effective Java" by Joshua Bloch (ISBN: 978-0134685991)

=== Registering Members ===
✓ Registered: Alice (ID: 1)
✓ Registered: Bob (ID: 2)

=== Borrowing Books ===
Alice borrows "Clean Code"...
✓ Loan created. Due date: 2026-03-06
  Available copies: 3 → 2

Bob borrows "Effective Java"...
✓ Loan created. Due date: 2026-03-06

=== Returning Books ===
Alice returns "Clean Code" (on time)...
✓ Book returned. No fine.

Bob returns "Effective Java" (5 days late)...
✓ Book returned. Fine: $2.50

=== Reports ===

Most Popular Books:
1. Clean Code - 15 loans
2. Effective Java - 12 loans
3. Design Patterns - 8 loans

Overdue Books:
  "Java Concurrency" - Bob - 3 days overdue ($1.50 fine)

Members with Outstanding Fines:
  Bob: $2.50
  Carol: $5.00

=== Library Statistics ===
Total books: 50
Total members: 25
Active loans: 12
Overdue loans: 3
Total fines outstanding: $15.50
```

---

## 📊 Exercise Checklist

| Exercise | Difficulty | Concepts | Completed |
|----------|------------|----------|-----------|
| 1. Database Setup | 🟢 Easy | Connection, CREATE, INSERT | ⬜ |
| 2. Query Conditions | 🟢 Easy | SELECT, WHERE, COUNT | ⬜ |
| 3. Update & Delete | 🟢 Easy | UPDATE, DELETE | ⬜ |
| 4. Employee System | 🟡 Medium | Full CRUD, aggregations | ⬜ |
| 5. Order Processing | 🟡 Medium | Transactions | ⬜ |
| 6. Batch Import | 🟡 Medium | Batch processing | ⬜ |
| 7. Generic DAO | 🔴 Hard | Design patterns, generics | ⬜ |
| 8. Connection Pool | 🔴 Hard | Concurrency, resource management | ⬜ |
| 9. Migration System | 🔴 Hard | Schema versioning | ⬜ |
| 🏆 Library System | Bonus | Complete application | ⬜ |

---

## 💡 Tips for Success

1. **Always use try-with-resources** - Prevents resource leaks
2. **Always use PreparedStatement** - Prevents SQL injection
3. **Test with edge cases** - NULL values, empty results, duplicates
4. **Use transactions** - For multi-step operations
5. **Log SQL errors** - Include the SQL statement in error messages
6. **Index your tables** - For frequently queried columns

---

## 🔧 Common Issues and Solutions

### SQLite Driver Not Found
```bash
# Make sure driver is in classpath
java -cp ".:sqlite-jdbc-3.42.0.0.jar" YourProgram
```

### ResultSet Already Closed
```java
// ❌ Wrong - ResultSet closed when Statement closed
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT ...");
stmt.close();  // This closes rs too!
rs.next();  // Error!

// ✅ Right - Keep Statement open while using ResultSet
try (Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT ...")) {
    while (rs.next()) { ... }
}  // Both closed at end
```

### Deadlock in Transactions
```java
// Always acquire locks in consistent order
// Use timeouts: conn.setNetworkTimeout(executor, 5000);
// Keep transactions short
```

---

**Master database programming to build data-driven applications!** 🗄️
