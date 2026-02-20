/**
 * ============================================
 * DATABASES & JDBC DEMONSTRATION
 * ============================================
 * 
 * This file demonstrates all major JDBC concepts:
 * 1. Connecting to SQLite database
 * 2. Creating tables
 * 3. CRUD operations with PreparedStatement
 * 4. ResultSet processing
 * 5. Transactions
 * 6. Batch processing
 * 7. DAO pattern implementation
 * 
 * Prerequisites:
 * - Download sqlite-jdbc JAR from: https://github.com/xerial/sqlite-jdbc/releases
 * - Compile: javac -cp ".:sqlite-jdbc-3.42.0.0.jar" JDBCDemo.java
 * - Run: java -cp ".:sqlite-jdbc-3.42.0.0.jar" JDBCDemo
 * 
 * @author Learn Java With Me
 */

import java.sql.*;
import java.util.*;

public class JDBCDemo {
    
    // Database URL - creates file in current directory
    private static final String DB_URL = "jdbc:sqlite:demo_database.db";
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║           DATABASES & JDBC DEMONSTRATION                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
        
        // Run demonstrations
        demo1_BasicConnection();
        demo2_CreateTable();
        demo3_InsertData();
        demo4_SelectData();
        demo5_PreparedStatement();
        demo6_UpdateDelete();
        demo7_Transaction();
        demo8_BatchProcessing();
        demo9_ResultSetMetadata();
        demo10_DAOPattern();
        
        System.out.println("\n✅ All demonstrations completed!");
        System.out.println("📁 Database file created: demo_database.db");
    }
    
    /**
     * DEMO 1: Basic Database Connection
     */
    public static void demo1_BasicConnection() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 1: Basic Database Connection");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                
                System.out.println("✓ Connected to database!");
                System.out.println("  Database: " + meta.getDatabaseProductName());
                System.out.println("  Version: " + meta.getDatabaseProductVersion());
                System.out.println("  Driver: " + meta.getDriverName());
                System.out.println("  URL: " + meta.getURL());
            }
            
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 2: Creating Tables
     */
    public static void demo2_CreateTable() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 2: Creating Tables");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Drop existing tables for clean demo
        String dropProducts = "DROP TABLE IF EXISTS products";
        String dropOrders = "DROP TABLE IF EXISTS orders";
        
        // Create products table
        String createProducts = """
            CREATE TABLE IF NOT EXISTS products (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                category TEXT,
                price REAL NOT NULL,
                quantity INTEGER DEFAULT 0,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            )
            """;
        
        // Create orders table
        String createOrders = """
            CREATE TABLE IF NOT EXISTS orders (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                product_id INTEGER,
                customer_name TEXT NOT NULL,
                quantity INTEGER NOT NULL,
                total REAL,
                order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                FOREIGN KEY (product_id) REFERENCES products(id)
            )
            """;
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            
            // Execute DDL statements
            stmt.execute(dropProducts);
            stmt.execute(dropOrders);
            stmt.execute(createProducts);
            stmt.execute(createOrders);
            
            System.out.println("✓ Tables created successfully!");
            System.out.println("  - products (id, name, category, price, quantity, created_at)");
            System.out.println("  - orders (id, product_id, customer_name, quantity, total, order_date)");
            
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
        }
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 3: Inserting Data
     */
    public static void demo3_InsertData() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 3: Inserting Data");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        String insertSQL = "INSERT INTO products (name, category, price, quantity) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL, 
                 Statement.RETURN_GENERATED_KEYS)) {
            
            // Product data to insert
            Object[][] products = {
                {"Laptop", "Electronics", 999.99, 50},
                {"Mouse", "Electronics", 29.99, 200},
                {"Keyboard", "Electronics", 79.99, 150},
                {"Coffee Maker", "Appliances", 89.99, 30},
                {"Desk Chair", "Furniture", 249.99, 25}
            };
            
            System.out.println("Inserting products:");
            
            for (Object[] product : products) {
                pstmt.setString(1, (String) product[0]);      // name
                pstmt.setString(2, (String) product[1]);      // category
                pstmt.setDouble(3, (Double) product[2]);      // price
                pstmt.setInt(4, (Integer) product[3]);        // quantity
                
                int rowsAffected = pstmt.executeUpdate();
                
                // Get generated ID
                try (ResultSet keys = pstmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        int id = keys.getInt(1);
                        System.out.printf("  ✓ Inserted: %s (ID: %d)%n", product[0], id);
                    }
                }
            }
            
            System.out.println("\nTotal products inserted: " + products.length);
            
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 4: Selecting Data
     */
    public static void demo4_SelectData() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 4: Selecting Data");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            
            // Select all products
            System.out.println("All Products:");
            System.out.println("─".repeat(70));
            System.out.printf("%-4s %-15s %-12s %10s %8s%n", 
                "ID", "Name", "Category", "Price", "Qty");
            System.out.println("─".repeat(70));
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM products ORDER BY id");
            
            while (rs.next()) {
                System.out.printf("%-4d %-15s %-12s $%9.2f %8d%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"));
            }
            
            // Select with condition
            System.out.println("\n\nElectronics only (price > $50):");
            System.out.println("─".repeat(40));
            
            String query = "SELECT name, price FROM products WHERE category = 'Electronics' AND price > 50";
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                System.out.printf("  %s: $%.2f%n", 
                    rs.getString("name"), 
                    rs.getDouble("price"));
            }
            
            // Aggregate queries
            System.out.println("\n\nStatistics:");
            rs = stmt.executeQuery("SELECT COUNT(*) as count, AVG(price) as avg_price, SUM(quantity) as total_qty FROM products");
            
            if (rs.next()) {
                System.out.printf("  Total products: %d%n", rs.getInt("count"));
                System.out.printf("  Average price: $%.2f%n", rs.getDouble("avg_price"));
                System.out.printf("  Total inventory: %d units%n", rs.getInt("total_qty"));
            }
            
        } catch (SQLException e) {
            System.err.println("Error selecting data: " + e.getMessage());
        }
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 5: PreparedStatement with Parameters
     */
    public static void demo5_PreparedStatement() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 5: PreparedStatement (Safe Parameterized Queries)");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Safe way to handle user input
        String userInput = "Electronics";  // Could come from user
        double minPrice = 50.0;
        
        String sql = "SELECT * FROM products WHERE category = ? AND price >= ? ORDER BY price DESC";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Set parameters (1-indexed)
            pstmt.setString(1, userInput);
            pstmt.setDouble(2, minPrice);
            
            System.out.println("Query: SELECT * FROM products WHERE category = ? AND price >= ?");
            System.out.println("Parameters: [" + userInput + ", " + minPrice + "]");
            System.out.println("\nResults:");
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("  %s - $%.2f%n",
                        rs.getString("name"),
                        rs.getDouble("price"));
                }
            }
            
            // Demonstrate SQL injection prevention
            System.out.println("\n\n--- SQL Injection Prevention Demo ---");
            String maliciousInput = "'; DROP TABLE products; --";
            
            pstmt.setString(1, maliciousInput);  // This is safely escaped!
            pstmt.setDouble(2, 0);
            
            System.out.println("Malicious input: " + maliciousInput);
            System.out.println("PreparedStatement safely escapes it - no injection possible!");
            
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Results: " + (rs.next() ? "Found" : "None (as expected)"));
            }
            
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 6: Update and Delete Operations
     */
    public static void demo6_UpdateDelete() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 6: Update and Delete Operations");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            
            // Show before state
            System.out.println("Before updates:");
            showProduct(conn, 1);
            
            // UPDATE
            String updateSQL = "UPDATE products SET price = price * 0.9, quantity = quantity + 10 WHERE id = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                pstmt.setInt(1, 1);
                int rowsUpdated = pstmt.executeUpdate();
                System.out.println("\nApplied 10% discount and added 10 to stock.");
                System.out.println("Rows updated: " + rowsUpdated);
            }
            
            // Show after update
            System.out.println("\nAfter update:");
            showProduct(conn, 1);
            
            // INSERT a product to delete
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("INSERT INTO products (name, category, price, quantity) VALUES ('Test Product', 'Test', 9.99, 1)");
            }
            
            // Count before delete
            int countBefore = countProducts(conn);
            System.out.println("\n\nProducts before delete: " + countBefore);
            
            // DELETE
            String deleteSQL = "DELETE FROM products WHERE category = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
                pstmt.setString(1, "Test");
                int rowsDeleted = pstmt.executeUpdate();
                System.out.println("Deleted 'Test' category products. Rows deleted: " + rowsDeleted);
            }
            
            // Count after delete
            int countAfter = countProducts(conn);
            System.out.println("Products after delete: " + countAfter);
            
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 7: Transactions
     */
    public static void demo7_Transaction() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 7: Transactions (Atomic Operations)");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            
            // Show initial state
            System.out.println("Initial inventory:");
            showProduct(conn, 1);
            showProduct(conn, 2);
            
            System.out.println("\n--- Simulating Order Transaction ---");
            System.out.println("Customer orders 5 Laptops and 10 Mice");
            
            // Start transaction
            conn.setAutoCommit(false);
            
            try {
                // Check stock
                String checkSQL = "SELECT quantity FROM products WHERE id = ?";
                String updateSQL = "UPDATE products SET quantity = quantity - ? WHERE id = ?";
                String orderSQL = "INSERT INTO orders (product_id, customer_name, quantity, total) VALUES (?, ?, ?, ?)";
                
                try (PreparedStatement checkStmt = conn.prepareStatement(checkSQL);
                     PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
                     PreparedStatement orderStmt = conn.prepareStatement(orderSQL)) {
                    
                    // Order 5 Laptops (product_id = 1)
                    checkStmt.setInt(1, 1);
                    ResultSet rs = checkStmt.executeQuery();
                    if (rs.next() && rs.getInt("quantity") >= 5) {
                        updateStmt.setInt(1, 5);
                        updateStmt.setInt(2, 1);
                        updateStmt.executeUpdate();
                        
                        orderStmt.setInt(1, 1);
                        orderStmt.setString(2, "John Doe");
                        orderStmt.setInt(3, 5);
                        orderStmt.setDouble(4, 999.99 * 5);
                        orderStmt.executeUpdate();
                        System.out.println("  ✓ Laptop order processed");
                    }
                    
                    // Order 10 Mice (product_id = 2)
                    checkStmt.setInt(1, 2);
                    rs = checkStmt.executeQuery();
                    if (rs.next() && rs.getInt("quantity") >= 10) {
                        updateStmt.setInt(1, 10);
                        updateStmt.setInt(2, 2);
                        updateStmt.executeUpdate();
                        
                        orderStmt.setInt(1, 2);
                        orderStmt.setString(2, "John Doe");
                        orderStmt.setInt(3, 10);
                        orderStmt.setDouble(4, 29.99 * 10);
                        orderStmt.executeUpdate();
                        System.out.println("  ✓ Mouse order processed");
                    }
                }
                
                // All successful - commit
                conn.commit();
                System.out.println("\n✓ Transaction committed successfully!");
                
            } catch (SQLException e) {
                // Error - rollback all changes
                conn.rollback();
                System.out.println("\n✗ Transaction rolled back due to error: " + e.getMessage());
            } finally {
                conn.setAutoCommit(true);
            }
            
            // Show final state
            System.out.println("\nFinal inventory:");
            showProduct(conn, 1);
            showProduct(conn, 2);
            
            // Show orders
            System.out.println("\nOrders placed:");
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM orders")) {
                while (rs.next()) {
                    System.out.printf("  Order #%d: %s ordered %d units, Total: $%.2f%n",
                        rs.getInt("id"),
                        rs.getString("customer_name"),
                        rs.getInt("quantity"),
                        rs.getDouble("total"));
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 8: Batch Processing
     */
    public static void demo8_BatchProcessing() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 8: Batch Processing (Efficient Bulk Operations)");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        String insertSQL = "INSERT INTO products (name, category, price, quantity) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            conn.setAutoCommit(false);
            
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                
                // Batch data
                String[] names = {"Headphones", "Webcam", "USB Hub", "Monitor Stand", "Mousepad"};
                double[] prices = {149.99, 89.99, 39.99, 59.99, 19.99};
                
                System.out.println("Adding batch of " + names.length + " products...");
                
                long startTime = System.currentTimeMillis();
                
                for (int i = 0; i < names.length; i++) {
                    pstmt.setString(1, names[i]);
                    pstmt.setString(2, "Electronics");
                    pstmt.setDouble(3, prices[i]);
                    pstmt.setInt(4, 100);
                    pstmt.addBatch();  // Add to batch
                }
                
                // Execute entire batch at once
                int[] results = pstmt.executeBatch();
                conn.commit();
                
                long endTime = System.currentTimeMillis();
                
                System.out.println("\nBatch execution results:");
                for (int i = 0; i < results.length; i++) {
                    System.out.printf("  %s: %s%n", names[i], 
                        results[i] >= 0 ? "✓ Inserted" : "✗ Failed");
                }
                
                System.out.println("\nTotal time: " + (endTime - startTime) + "ms");
                System.out.println("Products in database: " + countProducts(conn));
                
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
            
        } catch (SQLException e) {
            System.err.println("Batch error: " + e.getMessage());
        }
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 9: ResultSet Metadata
     */
    public static void demo9_ResultSetMetadata() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 9: ResultSet Metadata");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {
            
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();
            
            System.out.println("Table Structure (from ResultSet):");
            System.out.println("─".repeat(60));
            System.out.printf("%-4s %-15s %-15s %-10s %-10s%n", 
                "#", "Column Name", "Type", "Nullable", "Display Size");
            System.out.println("─".repeat(60));
            
            for (int i = 1; i <= columnCount; i++) {
                String nullable = meta.isNullable(i) == ResultSetMetaData.columnNullable 
                    ? "Yes" : "No";
                
                System.out.printf("%-4d %-15s %-15s %-10s %-10d%n",
                    i,
                    meta.getColumnName(i),
                    meta.getColumnTypeName(i),
                    nullable,
                    meta.getColumnDisplaySize(i));
            }
            
            // Database metadata
            System.out.println("\n\nDatabase Tables:");
            DatabaseMetaData dbMeta = conn.getMetaData();
            ResultSet tables = dbMeta.getTables(null, null, "%", new String[]{"TABLE"});
            
            while (tables.next()) {
                System.out.println("  - " + tables.getString("TABLE_NAME"));
            }
            
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 10: DAO Pattern
     */
    public static void demo10_DAOPattern() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 10: DAO Pattern (Data Access Object)");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Create DAO instance
        ProductDAO productDAO = new ProductDAO(DB_URL);
        
        // Find all
        System.out.println("All Products (via DAO):");
        List<Product> allProducts = productDAO.findAll();
        for (Product p : allProducts) {
            System.out.println("  " + p);
        }
        
        // Find by ID
        System.out.println("\nFind by ID (1):");
        productDAO.findById(1).ifPresent(p -> System.out.println("  " + p));
        
        // Find by category
        System.out.println("\nFind by Category (Electronics):");
        List<Product> electronics = productDAO.findByCategory("Electronics");
        System.out.println("  Found " + electronics.size() + " products");
        
        // Create new product
        System.out.println("\nCreating new product...");
        Product newProduct = new Product("Tablet", "Electronics", 599.99, 20);
        Product saved = productDAO.save(newProduct);
        System.out.println("  Created: " + saved);
        
        // Update
        System.out.println("\nUpdating product...");
        saved.setPrice(549.99);
        saved.setQuantity(25);
        productDAO.update(saved);
        System.out.println("  Updated: " + productDAO.findById(saved.getId()).orElse(null));
        
        // Statistics
        System.out.println("\nStatistics:");
        System.out.println("  Total products: " + productDAO.count());
        System.out.println("  Total value: $" + String.format("%.2f", productDAO.getTotalInventoryValue()));
        
        System.out.println("\n✓ DAO pattern provides clean separation of concerns!");
    }
    
    // ============ HELPER METHODS ============
    
    private static void showProduct(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.printf("  Product #%d: %s - $%.2f (Stock: %d)%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"));
                }
            }
        }
    }
    
    private static int countProducts(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM products")) {
            return rs.next() ? rs.getInt(1) : 0;
        }
    }
}

// ============================================
// PRODUCT ENTITY CLASS
// ============================================

class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;
    
    public Product() {}
    
    public Product(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Product(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    @Override
    public String toString() {
        return String.format("Product[id=%d, name=%s, category=%s, price=%.2f, qty=%d]",
            id, name, category, price, quantity);
    }
}

// ============================================
// PRODUCT DAO (DATA ACCESS OBJECT)
// ============================================

class ProductDAO {
    private final String url;
    
    public ProductDAO(String url) {
        this.url = url;
    }
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
    
    public Product save(Product product) {
        String sql = "INSERT INTO products (name, category, price, quantity) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getCategory());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());
            pstmt.executeUpdate();
            
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    product.setId(keys.getInt(1));
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save product", e);
        }
        
        return product;
    }
    
    public Optional<Product> findById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find product", e);
        }
        
        return Optional.empty();
    }
    
    public List<Product> findAll() {
        String sql = "SELECT * FROM products ORDER BY id";
        List<Product> products = new ArrayList<>();
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                products.add(mapRow(rs));
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find products", e);
        }
        
        return products;
    }
    
    public List<Product> findByCategory(String category) {
        String sql = "SELECT * FROM products WHERE category = ? ORDER BY name";
        List<Product> products = new ArrayList<>();
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, category);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    products.add(mapRow(rs));
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find products by category", e);
        }
        
        return products;
    }
    
    public boolean update(Product product) {
        String sql = "UPDATE products SET name = ?, category = ?, price = ?, quantity = ? WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getCategory());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());
            pstmt.setInt(5, product.getId());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update product", e);
        }
    }
    
    public boolean delete(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete product", e);
        }
    }
    
    public int count() {
        String sql = "SELECT COUNT(*) FROM products";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            return rs.next() ? rs.getInt(1) : 0;
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to count products", e);
        }
    }
    
    public double getTotalInventoryValue() {
        String sql = "SELECT SUM(price * quantity) FROM products";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            return rs.next() ? rs.getDouble(1) : 0.0;
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to calculate inventory value", e);
        }
    }
    
    private Product mapRow(ResultSet rs) throws SQLException {
        return new Product(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("category"),
            rs.getDouble("price"),
            rs.getInt("quantity")
        );
    }
}
