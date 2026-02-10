/**
 * Class 2: Constructors - Complete Example
 *
 * Demonstrates:
 * - Default constructors
 * - Parameterized constructors
 * - Constructor overloading
 * - The 'this' keyword
 * - Constructor chaining
 *
 * How to compile and run:
 * $ javac ConstructorsDemo.java
 * $ java ConstructorsDemo
 */

public class ConstructorsDemo {

    public static void main(String[] args) {
        System.out.println("========== CONSTRUCTORS DEMO ==========\n");

        // ================================================
        // DEMONSTRATION 1: DEFAULT CONSTRUCTOR
        // ================================================
        System.out.println("1. DEFAULT CONSTRUCTOR");
        System.out.println("─────────────────────────────────────────");

        // Using explicit default constructor
        Person defaultPerson = new Person();
        defaultPerson.displayInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 2: PARAMETERIZED CONSTRUCTOR
        // ================================================
        System.out.println("2. PARAMETERIZED CONSTRUCTOR");
        System.out.println("─────────────────────────────────────────");

        // Create person with values
        Person alice = new Person("Alice", 25, "New York");
        alice.displayInfo();
        System.out.println();

        Person bob = new Person("Bob", 30, "Los Angeles");
        bob.displayInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 3: CONSTRUCTOR OVERLOADING
        // ================================================
        System.out.println("3. CONSTRUCTOR OVERLOADING");
        System.out.println("─────────────────────────────────────────");

        // Different ways to create Student objects
        Student s1 = new Student();
        System.out.println("Student 1 (no args):");
        s1.displayInfo();
        System.out.println();

        Student s2 = new Student("Charlie");
        System.out.println("Student 2 (name only):");
        s2.displayInfo();
        System.out.println();

        Student s3 = new Student("Diana", 20);
        System.out.println("Student 3 (name and age):");
        s3.displayInfo();
        System.out.println();

        Student s4 = new Student("Eve", 22, "Computer Science", 3.9);
        System.out.println("Student 4 (all parameters):");
        s4.displayInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 4: THE 'this' KEYWORD
        // ================================================
        System.out.println("4. THE 'this' KEYWORD");
        System.out.println("─────────────────────────────────────────");

        // Rectangle uses 'this' to distinguish parameters from fields
        Rectangle rect = new Rectangle(10.0, 5.0, "blue");
        rect.displayInfo();
        System.out.println("Area: " + rect.calculateArea());
        System.out.println();


        // ================================================
        // DEMONSTRATION 5: CONSTRUCTOR CHAINING
        // ================================================
        System.out.println("5. CONSTRUCTOR CHAINING");
        System.out.println("─────────────────────────────────────────");

        // All these use constructor chaining
        Product p1 = new Product();
        System.out.println("Product 1 (default):");
        p1.displayInfo();
        System.out.println();

        Product p2 = new Product("Laptop");
        System.out.println("Product 2 (name only):");
        p2.displayInfo();
        System.out.println();

        Product p3 = new Product("Phone", 999.99);
        System.out.println("Product 3 (name and price):");
        p3.displayInfo();
        System.out.println();

        Product p4 = new Product("Tablet", 499.99, 50);
        System.out.println("Product 4 (all parameters):");
        p4.displayInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 6: BANK ACCOUNT EXAMPLE
        // ================================================
        System.out.println("6. BANK ACCOUNT WITH MULTIPLE CONSTRUCTORS");
        System.out.println("─────────────────────────────────────────");

        BankAccount acc1 = new BankAccount("John Smith", 1000.0);
        System.out.println("Account 1 (quick setup):");
        acc1.displayInfo();
        System.out.println();

        BankAccount acc2 = new BankAccount("ACC001", "Jane Doe", 5000.0, 0.05);
        System.out.println("Account 2 (full setup):");
        acc2.displayInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 7: MOVIE CLASS
        // ================================================
        System.out.println("7. MOVIE CLASS WITH OVERLOADED CONSTRUCTORS");
        System.out.println("─────────────────────────────────────────");

        Movie m1 = new Movie("Inception", 2010);
        System.out.println("Movie 1 (minimal):");
        m1.displayInfo();
        System.out.println();

        Movie m2 = new Movie("The Dark Knight", "Christopher Nolan", 2008, "Action");
        System.out.println("Movie 2 (without rating):");
        m2.displayInfo();
        System.out.println();

        Movie m3 = new Movie("Interstellar", "Christopher Nolan", 2014, 8.6, "Sci-Fi");
        System.out.println("Movie 3 (complete):");
        m3.displayInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 8: CONTACT CLASS
        // ================================================
        System.out.println("8. CONTACT CLASS WITH CHAINING");
        System.out.println("─────────────────────────────────────────");

        Contact c1 = new Contact("John", "Doe");
        System.out.println("Contact 1 (name only):");
        c1.displayInfo();
        System.out.println();

        Contact c2 = new Contact("Jane", "Smith", "jane@email.com");
        System.out.println("Contact 2 (with email):");
        c2.displayInfo();
        System.out.println();

        Contact c3 = new Contact("Bob", "Johnson", "bob@email.com", "555-1234", "123 Main St");
        System.out.println("Contact 3 (complete):");
        c3.displayInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 9: CREATING MULTIPLE OBJECTS
        // ================================================
        System.out.println("9. CREATING MULTIPLE OBJECTS");
        System.out.println("─────────────────────────────────────────");

        // Create array of books with different constructors
        Book[] library = new Book[4];
        library[0] = new Book("Java Basics", "John Doe", 300, 29.99);
        library[1] = new Book("Python Guide", "Jane Smith", 250);
        library[2] = new Book("Web Development", "Bob Johnson");
        library[3] = new Book();

        System.out.println("Library Contents:");
        for (int i = 0; i < library.length; i++) {
            System.out.println("\nBook " + (i + 1) + ":");
            library[i].displayInfo();
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 10: EMPLOYEE WITH VALIDATION
        // ================================================
        System.out.println("10. CONSTRUCTOR WITH VALIDATION");
        System.out.println("─────────────────────────────────────────");

        Employee emp1 = new Employee("Alice", "Engineering", 75000, 5);
        System.out.println("Employee 1:");
        emp1.displayInfo();
        System.out.println();

        // Try with invalid salary (will be set to minimum)
        Employee emp2 = new Employee("Bob", "Sales", -5000, 2);
        System.out.println("Employee 2 (invalid salary was corrected):");
        emp2.displayInfo();
        System.out.println();


        System.out.println("========== END OF CONSTRUCTORS DEMO ==========");
        System.out.println("Constructors make object creation clean and safe! 🏗️");
    }
}


// ================================================
// CLASS DEFINITIONS
// ================================================

/**
 * Person class with default and parameterized constructors
 */
class Person {
    String name;
    int age;
    String city;

    // Default constructor
    public Person() {
        name = "Unknown";
        age = 0;
        city = "Unknown";
        System.out.println("✓ Person created with default values");
    }

    // Parameterized constructor
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
        System.out.println("✓ Person created: " + name);
    }

    void displayInfo() {
        System.out.println("  Name: " + name);
        System.out.println("  Age: " + age);
        System.out.println("  City: " + city);
    }
}

/**
 * Student class with constructor overloading
 */
class Student {
    String name;
    int age;
    String major;
    double gpa;

    // Constructor 1: No parameters
    public Student() {
        name = "New Student";
        age = 18;
        major = "Undeclared";
        gpa = 0.0;
    }

    // Constructor 2: Name only
    public Student(String name) {
        this.name = name;
        this.age = 18;
        this.major = "Undeclared";
        this.gpa = 0.0;
    }

    // Constructor 3: Name and age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.major = "Undeclared";
        this.gpa = 0.0;
    }

    // Constructor 4: All parameters
    public Student(String name, int age, String major, double gpa) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.gpa = gpa;
    }

    void displayInfo() {
        System.out.println("  Name: " + name);
        System.out.println("  Age: " + age);
        System.out.println("  Major: " + major);
        System.out.println("  GPA: " + gpa);
    }
}

/**
 * Rectangle class demonstrating 'this' keyword
 */
class Rectangle {
    double width;
    double height;
    String color;

    // Using 'this' to distinguish parameters from fields
    public Rectangle(double width, double height, String color) {
        this.width = width;    // this.width = field, width = parameter
        this.height = height;  // this.height = field, height = parameter
        this.color = color;    // this.color = field, color = parameter
        System.out.println("✓ Rectangle created: " + width + "x" + height + " " + color);
    }

    double calculateArea() {
        return this.width * this.height;
    }

    void displayInfo() {
        System.out.println("  Width: " + this.width);
        System.out.println("  Height: " + this.height);
        System.out.println("  Color: " + this.color);
    }
}

/**
 * Product class with constructor chaining
 */
class Product {
    String name;
    double price;
    int quantity;

    // Main constructor - does all the work
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        System.out.println("✓ Product created: " + name);
    }

    // Chains to main constructor
    public Product() {
        this("Unknown Product", 0.0, 0);
    }

    // Chains to main constructor
    public Product(String name) {
        this(name, 0.0, 0);
    }

    // Chains to main constructor
    public Product(String name, double price) {
        this(name, price, 0);
    }

    void displayInfo() {
        System.out.println("  Name: " + name);
        System.out.println("  Price: $" + price);
        System.out.println("  Quantity: " + quantity);
        System.out.println("  Total Value: $" + (price * quantity));
    }
}

/**
 * BankAccount with multiple constructor options
 */
class BankAccount {
    String accountNumber;
    String holderName;
    double balance;
    double interestRate;

    // Full constructor
    public BankAccount(String accountNumber, String holderName, 
                       double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    // Quick setup (auto-generates account number)
    public BankAccount(String holderName, double initialDeposit) {
        this("ACC" + System.currentTimeMillis() % 100000, holderName, initialDeposit, 0.02);
    }

    void displayInfo() {
        System.out.println("  Account #: " + accountNumber);
        System.out.println("  Holder: " + holderName);
        System.out.println("  Balance: $" + balance);
        System.out.println("  Interest Rate: " + (interestRate * 100) + "%");
    }
}

/**
 * Movie class with overloaded constructors
 */
class Movie {
    String title;
    String director;
    int year;
    double rating;
    String genre;

    // Complete constructor
    public Movie(String title, String director, int year, double rating, String genre) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.genre = genre;
    }

    // Without rating
    public Movie(String title, String director, int year, String genre) {
        this(title, director, year, 0.0, genre);
    }

    // Minimal info
    public Movie(String title, int year) {
        this(title, "Unknown", year, 0.0, "Unknown");
    }

    void displayInfo() {
        System.out.println("  🎬 " + title + " (" + year + ")");
        System.out.println("  Director: " + director);
        System.out.println("  Genre: " + genre);
        System.out.println("  Rating: " + (rating > 0 ? rating + "/10" : "Not rated"));
    }
}

/**
 * Contact class with constructor chaining
 */
class Contact {
    String firstName;
    String lastName;
    String email;
    String phone;
    String address;

    // Full constructor
    public Contact(String firstName, String lastName, String email, 
                   String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Without address
    public Contact(String firstName, String lastName, String email, String phone) {
        this(firstName, lastName, email, phone, "No address");
    }

    // Email only
    public Contact(String firstName, String lastName, String email) {
        this(firstName, lastName, email, "No phone", "No address");
    }

    // Name only
    public Contact(String firstName, String lastName) {
        this(firstName, lastName, "No email", "No phone", "No address");
    }

    String getFullName() {
        return firstName + " " + lastName;
    }

    void displayInfo() {
        System.out.println("  Name: " + getFullName());
        System.out.println("  Email: " + email);
        System.out.println("  Phone: " + phone);
        System.out.println("  Address: " + address);
    }
}

/**
 * Book class with multiple constructors
 */
class Book {
    String title;
    String author;
    int pages;
    double price;

    // Full constructor
    public Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    // Without price
    public Book(String title, String author, int pages) {
        this(title, author, pages, 0.0);
    }

    // Title and author only
    public Book(String title, String author) {
        this(title, author, 0, 0.0);
    }

    // Title only
    public Book(String title) {
        this(title, "Unknown Author", 0, 0.0);
    }

    // Default
    public Book() {
        this("Untitled", "Unknown Author", 0, 0.0);
    }

    void displayInfo() {
        System.out.println("  Title: " + title);
        System.out.println("  Author: " + author);
        System.out.println("  Pages: " + (pages > 0 ? pages : "Unknown"));
        System.out.println("  Price: " + (price > 0 ? "$" + price : "Not set"));
    }
}

/**
 * Employee class with validation in constructor
 */
class Employee {
    String name;
    String department;
    double salary;
    int yearsWorked;

    static final double MIN_SALARY = 25000.0;

    public Employee(String name, String department, double salary, int yearsWorked) {
        this.name = name;
        this.department = department;
        
        // Validation: salary cannot be negative
        if (salary < 0) {
            System.out.println("⚠️ Invalid salary. Setting to minimum: $" + MIN_SALARY);
            this.salary = MIN_SALARY;
        } else {
            this.salary = salary;
        }
        
        // Validation: years cannot be negative
        if (yearsWorked < 0) {
            System.out.println("⚠️ Invalid years. Setting to 0.");
            this.yearsWorked = 0;
        } else {
            this.yearsWorked = yearsWorked;
        }
    }

    public Employee(String name, String department) {
        this(name, department, MIN_SALARY, 0);
    }

    public Employee(String name) {
        this(name, "General", MIN_SALARY, 0);
    }

    void displayInfo() {
        System.out.println("  Name: " + name);
        System.out.println("  Department: " + department);
        System.out.println("  Salary: $" + salary);
        System.out.println("  Years Worked: " + yearsWorked);
    }
}
