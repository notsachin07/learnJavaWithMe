/**
 * Class 3: Encapsulation - Complete Example
 *
 * Demonstrates:
 * - Private fields
 * - Getters and setters
 * - Validation in setters
 * - Read-only and write-only properties
 * - Encapsulation benefits
 *
 * How to compile and run:
 * $ javac EncapsulationDemo.java
 * $ java EncapsulationDemo
 */

public class EncapsulationDemo {

    public static void main(String[] args) {
        System.out.println("========== ENCAPSULATION DEMO ==========\n");

        // ================================================
        // DEMONSTRATION 1: BASIC ENCAPSULATION
        // ================================================
        System.out.println("1. BASIC ENCAPSULATION");
        System.out.println("─────────────────────────────────────────");

        Person person = new Person("Alice", 25);
        person.displayInfo();

        // Access through getters
        System.out.println("\nAccessing via getters:");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        // Modify through setters
        System.out.println("\nModifying via setters:");
        person.setName("Alice Smith");
        person.setAge(26);
        person.displayInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 2: VALIDATION IN SETTERS
        // ================================================
        System.out.println("2. VALIDATION IN SETTERS");
        System.out.println("─────────────────────────────────────────");

        Student student = new Student("Bob", 101);
        
        System.out.println("Setting valid grade (85):");
        student.setGrade(85);
        System.out.println("Grade: " + student.getGrade());

        System.out.println("\nTrying invalid grade (-10):");
        student.setGrade(-10);
        System.out.println("Grade: " + student.getGrade());

        System.out.println("\nTrying invalid grade (150):");
        student.setGrade(150);
        System.out.println("Grade: " + student.getGrade());
        System.out.println();


        // ================================================
        // DEMONSTRATION 3: BANK ACCOUNT (COMPREHENSIVE)
        // ================================================
        System.out.println("3. BANK ACCOUNT WITH ENCAPSULATION");
        System.out.println("─────────────────────────────────────────");

        BankAccount account = new BankAccount("ACC001", "John Doe", 1000);
        account.displayInfo();

        System.out.println("\nDepositing $500:");
        account.deposit(500);
        System.out.println("Balance: $" + account.getBalance());

        System.out.println("\nWithdrawing $300:");
        account.withdraw(300);
        System.out.println("Balance: $" + account.getBalance());

        System.out.println("\nTrying to withdraw $2000 (insufficient):");
        account.withdraw(2000);
        System.out.println("Balance: $" + account.getBalance());

        System.out.println("\nTrying to deposit -$100 (invalid):");
        account.deposit(-100);
        System.out.println("Balance: $" + account.getBalance());
        System.out.println();


        // ================================================
        // DEMONSTRATION 4: READ-ONLY PROPERTIES
        // ================================================
        System.out.println("4. READ-ONLY PROPERTIES");
        System.out.println("─────────────────────────────────────────");

        Employee emp = new Employee("EMP001", "Charlie", 50000);
        System.out.println("Employee ID: " + emp.getEmployeeId());
        System.out.println("Name: " + emp.getName());
        System.out.println("Salary: $" + emp.getSalary());

        System.out.println("\nEmployee ID is read-only (no setter exists)");
        System.out.println("Changing name to 'Charlie Brown':");
        emp.setName("Charlie Brown");
        System.out.println("New Name: " + emp.getName());
        System.out.println();


        // ================================================
        // DEMONSTRATION 5: COMPUTED PROPERTIES
        // ================================================
        System.out.println("5. COMPUTED PROPERTIES");
        System.out.println("─────────────────────────────────────────");

        Rectangle rect = new Rectangle(10, 5);
        System.out.println("Rectangle: " + rect.getWidth() + " x " + rect.getHeight());
        System.out.println("Area: " + rect.getArea() + " (computed, no field)");
        System.out.println("Perimeter: " + rect.getPerimeter() + " (computed, no field)");
        System.out.println("Is Square: " + rect.isSquare());

        System.out.println("\nChanging to 8 x 8:");
        rect.setWidth(8);
        rect.setHeight(8);
        System.out.println("Area: " + rect.getArea());
        System.out.println("Is Square: " + rect.isSquare());
        System.out.println();


        // ================================================
        // DEMONSTRATION 6: EMAIL VALIDATION
        // ================================================
        System.out.println("6. EMAIL VALIDATION");
        System.out.println("─────────────────────────────────────────");

        User user = new User("diana");
        
        System.out.println("Setting valid email:");
        user.setEmail("diana@example.com");
        System.out.println("Email: " + user.getEmail());

        System.out.println("\nTrying invalid email (no @):");
        user.setEmail("invalid-email");
        System.out.println("Email: " + user.getEmail());

        System.out.println("\nTrying invalid email (no domain):");
        user.setEmail("test@");
        System.out.println("Email: " + user.getEmail());
        System.out.println();


        // ================================================
        // DEMONSTRATION 7: PASSWORD (WRITE-ONLY)
        // ================================================
        System.out.println("7. PASSWORD (WRITE-ONLY CONCEPT)");
        System.out.println("─────────────────────────────────────────");

        SecureUser secureUser = new SecureUser("admin");
        
        System.out.println("Setting password (minimum 8 characters)...");
        secureUser.setPassword("mySecret123");
        
        System.out.println("\nNote: No getPassword() method exists!");
        System.out.println("Instead, use checkPassword():");
        System.out.println("Checking 'wrongpass': " + secureUser.checkPassword("wrongpass"));
        System.out.println("Checking 'mySecret123': " + secureUser.checkPassword("mySecret123"));
        System.out.println();


        // ================================================
        // DEMONSTRATION 8: TEMPERATURE CONVERTER
        // ================================================
        System.out.println("8. TEMPERATURE WITH MULTIPLE VIEWS");
        System.out.println("─────────────────────────────────────────");

        Temperature temp = new Temperature(25);  // 25 Celsius
        System.out.println("Internal storage: Celsius");
        System.out.println("Celsius: " + temp.getCelsius() + "°C");
        System.out.println("Fahrenheit: " + temp.getFahrenheit() + "°F");
        System.out.println("Kelvin: " + temp.getKelvin() + "K");

        System.out.println("\nSetting via Fahrenheit (212°F):");
        temp.setFahrenheit(212);
        System.out.println("Celsius: " + temp.getCelsius() + "°C");
        System.out.println("Fahrenheit: " + temp.getFahrenheit() + "°F");
        System.out.println();


        // ================================================
        // DEMONSTRATION 9: PRODUCT INVENTORY
        // ================================================
        System.out.println("9. PRODUCT INVENTORY");
        System.out.println("─────────────────────────────────────────");

        Product product = new Product("Laptop", 999.99, 50);
        product.displayInfo();

        System.out.println("\nSelling 10 units:");
        product.sell(10);
        product.displayInfo();

        System.out.println("\nTrying to sell 100 units (insufficient stock):");
        product.sell(100);

        System.out.println("\nApplying 20% discount:");
        product.applyDiscount(20);
        product.displayInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 10: COUNTER (CONTROLLED ACCESS)
        // ================================================
        System.out.println("10. COUNTER (CONTROLLED MODIFICATION)");
        System.out.println("─────────────────────────────────────────");

        Counter counter = new Counter();
        System.out.println("Initial count: " + counter.getCount());

        System.out.println("Incrementing 5 times...");
        for (int i = 0; i < 5; i++) {
            counter.increment();
        }
        System.out.println("Count: " + counter.getCount());

        System.out.println("Decrementing 2 times...");
        counter.decrement();
        counter.decrement();
        System.out.println("Count: " + counter.getCount());

        System.out.println("Trying to decrement below 0...");
        for (int i = 0; i < 5; i++) {
            counter.decrement();
        }
        System.out.println("Count: " + counter.getCount() + " (can't go below 0)");

        System.out.println("Resetting...");
        counter.reset();
        System.out.println("Count: " + counter.getCount());
        System.out.println();


        System.out.println("========== END OF ENCAPSULATION DEMO ==========");
        System.out.println("Keep your data safe with encapsulation! 🔒");
    }
}


// ================================================
// CLASS DEFINITIONS
// ================================================

/**
 * Basic Person class with encapsulation
 */
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        setAge(age);  // Use setter for validation
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age with validation
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Invalid age: " + age);
        }
    }

    public void displayInfo() {
        System.out.println("Person: " + name + ", Age: " + age);
    }
}

/**
 * Student with grade validation
 */
class Student {
    private String name;
    private int studentId;
    private double grade;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grade = 0;
    }

    public String getName() { return name; }
    public int getStudentId() { return studentId; }
    
    public double getGrade() { return grade; }

    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
            System.out.println("✓ Grade set to " + grade);
        } else if (grade < 0) {
            System.out.println("✗ Grade cannot be negative!");
        } else {
            System.out.println("✗ Grade cannot exceed 100!");
        }
    }

    public String getLetterGrade() {
        if (grade >= 90) return "A";
        if (grade >= 80) return "B";
        if (grade >= 70) return "C";
        if (grade >= 60) return "D";
        return "F";
    }
}

/**
 * BankAccount with comprehensive encapsulation
 */
class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    private int transactionCount;

    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance > 0 ? initialBalance : 0;
        this.transactionCount = 0;
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public int getTransactionCount() { return transactionCount; }

    // No setBalance() - must use deposit/withdraw
    // No setAccountNumber() - never changes

    public void setHolderName(String holderName) {
        if (holderName != null && holderName.length() >= 2) {
            this.holderName = holderName;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionCount++;
            System.out.println("✓ Deposited: $" + amount);
        } else {
            System.out.println("✗ Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("✗ Withdrawal amount must be positive!");
        } else if (amount > balance) {
            System.out.println("✗ Insufficient funds! Balance: $" + balance);
        } else {
            balance -= amount;
            transactionCount++;
            System.out.println("✓ Withdrew: $" + amount);
        }
    }

    public void displayInfo() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: $" + balance);
        System.out.println("Transactions: " + transactionCount);
    }
}

/**
 * Employee with read-only ID
 */
class Employee {
    private final String employeeId;  // final = can't change
    private String name;
    private double salary;

    public Employee(String employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary > 0 ? salary : 0;
    }

    // Getter only for employeeId (no setter!)
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }
}

/**
 * Rectangle with computed properties
 */
class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width > 0 ? width : 1;
        this.height = height > 0 ? height : 1;
    }

    public double getWidth() { return width; }
    public void setWidth(double width) {
        if (width > 0) this.width = width;
    }

    public double getHeight() { return height; }
    public void setHeight(double height) {
        if (height > 0) this.height = height;
    }

    // Computed properties (no actual fields)
    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean isSquare() {
        return width == height;
    }
}

/**
 * User with email validation
 */
class User {
    private String username;
    private String email;

    public User(String username) {
        this.username = username;
        this.email = "";
    }

    public String getUsername() { return username; }
    
    public String getEmail() { return email; }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.indexOf("@") < email.lastIndexOf(".")) {
            this.email = email;
            System.out.println("✓ Email set to: " + email);
        } else {
            System.out.println("✗ Invalid email format!");
        }
    }
}

/**
 * SecureUser with write-only password
 */
class SecureUser {
    private String username;
    private String passwordHash;

    public SecureUser(String username) {
        this.username = username;
        this.passwordHash = "";
    }

    public String getUsername() { return username; }

    // Setter only - no getPassword()!
    public void setPassword(String password) {
        if (password != null && password.length() >= 8) {
            this.passwordHash = hashPassword(password);
            System.out.println("✓ Password set successfully");
        } else {
            System.out.println("✗ Password must be at least 8 characters!");
        }
    }

    // Verify password instead of exposing it
    public boolean checkPassword(String attempt) {
        return hashPassword(attempt).equals(passwordHash);
    }

    private String hashPassword(String password) {
        // Simplified - real code would use proper hashing
        return "HASH:" + password.hashCode();
    }
}

/**
 * Temperature with multiple views of same data
 */
class Temperature {
    private double celsius;  // Internal storage

    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    // Direct access to internal storage
    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    // Computed from internal storage
    public double getFahrenheit() {
        return celsius * 9 / 5 + 32;
    }

    public void setFahrenheit(double fahrenheit) {
        this.celsius = (fahrenheit - 32) * 5 / 9;
    }

    public double getKelvin() {
        return celsius + 273.15;
    }

    public void setKelvin(double kelvin) {
        this.celsius = kelvin - 273.15;
    }
}

/**
 * Product with inventory management
 */
class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price > 0 ? price : 0;
        this.quantity = quantity > 0 ? quantity : 0;
    }

    public String getName() { return name; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price >= 0) this.price = price;
    }

    public int getQuantity() { return quantity; }
    
    // No direct setQuantity - use sell/restock
    public void sell(int amount) {
        if (amount <= 0) {
            System.out.println("✗ Amount must be positive!");
        } else if (amount > quantity) {
            System.out.println("✗ Insufficient stock! Available: " + quantity);
        } else {
            quantity -= amount;
            System.out.println("✓ Sold " + amount + " units");
        }
    }

    public void restock(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println("✓ Restocked " + amount + " units");
        }
    }

    public void applyDiscount(double percent) {
        if (percent > 0 && percent <= 100) {
            price = price * (1 - percent / 100);
            System.out.println("✓ Applied " + percent + "% discount");
        }
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public void displayInfo() {
        System.out.println("Product: " + name);
        System.out.println("Price: $" + String.format("%.2f", price));
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Value: $" + String.format("%.2f", getTotalValue()));
    }
}

/**
 * Counter with controlled modification
 */
class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    // Getter only - no setCount!
    public int getCount() {
        return count;
    }

    // Controlled modification methods
    public void increment() {
        count++;
    }

    public void decrement() {
        if (count > 0) {
            count--;
        }
    }

    public void reset() {
        count = 0;
    }
}
