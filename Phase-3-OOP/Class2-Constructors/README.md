# Class 2: Constructors 🏗️

Welcome to **Phase 3, Class 2**! In this class, you'll learn about **constructors** - special methods that initialize objects when they're created.

---

## Table of Contents
1. [What is a Constructor?](#what-is-a-constructor)
2. [Default Constructor](#default-constructor)
3. [Parameterized Constructors](#parameterized-constructors)
4. [Constructor Overloading](#constructor-overloading)
5. [The `this` Keyword](#the-this-keyword)
6. [Constructor Chaining](#constructor-chaining)
7. [Common Mistakes](#common-mistakes)

---

## What is a Constructor?

A **constructor** is a special method that is automatically called when you create an object. It initializes the object's fields with starting values.

### Without Constructor (Manual Initialization)

```java
// ❌ Tedious: Must set each field manually
Car myCar = new Car();
myCar.brand = "Toyota";
myCar.color = "Red";
myCar.speed = 0;
```

### With Constructor (Automatic Initialization)

```java
// ✅ Better: Constructor handles initialization
Car myCar = new Car("Toyota", "Red", 0);
```

### Constructor Characteristics

```
┌─────────────────────────────────────────────────────────┐
│ CONSTRUCTOR RULES                                       │
├─────────────────────────────────────────────────────────┤
│ 1. Same name as the class                               │
│ 2. No return type (not even void)                       │
│ 3. Called automatically when object is created          │
│ 4. Can have parameters                                  │
│ 5. Can be overloaded (multiple constructors)            │
└─────────────────────────────────────────────────────────┘
```

---

## Default Constructor

If you don't write any constructor, Java provides a **default constructor** automatically.

### Implicit Default Constructor

```java
public class Person {
    String name;
    int age;
    
    // Java provides this automatically if you don't write any constructor:
    // public Person() { }
}

// Usage
Person p = new Person();  // Calls the default constructor
// name = null (default for String)
// age = 0 (default for int)
```

### Explicit Default Constructor

```java
public class Person {
    String name;
    int age;
    
    // Explicit default constructor
    public Person() {
        name = "Unknown";
        age = 0;
        System.out.println("Person created!");
    }
}

// Usage
Person p = new Person();  // Prints: Person created!
// name = "Unknown"
// age = 0
```

### Default Values by Type

| Type | Default Value |
|------|---------------|
| `int`, `long`, `short`, `byte` | `0` |
| `float`, `double` | `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` (null character) |
| Object references (`String`, arrays, etc.) | `null` |

---

## Parameterized Constructors

Constructors can accept **parameters** to initialize objects with specific values.

### Basic Parameterized Constructor

```java
public class Car {
    String brand;
    String color;
    int speed;
    
    // Constructor with parameters
    public Car(String carBrand, String carColor, int startSpeed) {
        brand = carBrand;
        color = carColor;
        speed = startSpeed;
    }
}

// Usage
Car car1 = new Car("Toyota", "Red", 0);
Car car2 = new Car("Honda", "Blue", 50);
```

### Line-by-Line Explanation

```java
public Car(String carBrand, String carColor, int startSpeed) {
//     └── Constructor name = Class name
//         └── Parameters: values passed when creating object
    
    brand = carBrand;   // Assign parameter value to field
    color = carColor;   // Assign parameter value to field
    speed = startSpeed; // Assign parameter value to field
}
```

### Example: Book Class

```java
public class Book {
    String title;
    String author;
    int pages;
    double price;
    
    // Constructor
    public Book(String bookTitle, String bookAuthor, int bookPages, double bookPrice) {
        title = bookTitle;
        author = bookAuthor;
        pages = bookPages;
        price = bookPrice;
    }
    
    void displayInfo() {
        System.out.println(title + " by " + author);
        System.out.println("Pages: " + pages + ", Price: $" + price);
    }
}

// Usage
Book book1 = new Book("Java Basics", "John Doe", 300, 29.99);
Book book2 = new Book("Python Guide", "Jane Smith", 250, 24.99);

book1.displayInfo();
book2.displayInfo();
```

**Output:**
```
Java Basics by John Doe
Pages: 300, Price: $29.99
Python Guide by Jane Smith
Pages: 250, Price: $24.99
```

---

## Constructor Overloading

You can have **multiple constructors** in a class, each with different parameters. This is called **constructor overloading**.

### Multiple Constructors

```java
public class Student {
    String name;
    int age;
    String major;
    double gpa;
    
    // Constructor 1: No parameters (default values)
    public Student() {
        name = "Unknown";
        age = 18;
        major = "Undeclared";
        gpa = 0.0;
    }
    
    // Constructor 2: Only name
    public Student(String studentName) {
        name = studentName;
        age = 18;
        major = "Undeclared";
        gpa = 0.0;
    }
    
    // Constructor 3: Name and age
    public Student(String studentName, int studentAge) {
        name = studentName;
        age = studentAge;
        major = "Undeclared";
        gpa = 0.0;
    }
    
    // Constructor 4: All parameters
    public Student(String studentName, int studentAge, String studentMajor, double studentGpa) {
        name = studentName;
        age = studentAge;
        major = studentMajor;
        gpa = studentGpa;
    }
    
    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
        System.out.println("Major: " + major + ", GPA: " + gpa);
    }
}
```

### Using Different Constructors

```java
// All valid ways to create Student objects
Student s1 = new Student();                              // Uses constructor 1
Student s2 = new Student("Alice");                       // Uses constructor 2
Student s3 = new Student("Bob", 20);                     // Uses constructor 3
Student s4 = new Student("Charlie", 22, "CS", 3.8);      // Uses constructor 4

s1.displayInfo();  // Name: Unknown, Age: 18, Major: Undeclared, GPA: 0.0
s2.displayInfo();  // Name: Alice, Age: 18, Major: Undeclared, GPA: 0.0
s3.displayInfo();  // Name: Bob, Age: 20, Major: Undeclared, GPA: 0.0
s4.displayInfo();  // Name: Charlie, Age: 22, Major: CS, GPA: 3.8
```

### How Java Chooses the Constructor

Java looks at:
1. **Number** of arguments
2. **Types** of arguments
3. **Order** of arguments

```java
// These call different constructors
new Rectangle(10)           // Rectangle(int side)
new Rectangle(10, 20)       // Rectangle(int width, int height)
new Rectangle(10.5, 20.5)   // Rectangle(double width, double height)
```

---

## The `this` Keyword

The `this` keyword refers to the **current object**. It's especially useful when parameter names match field names.

### Problem: Name Collision

```java
public class Person {
    String name;
    int age;
    
    // ❌ PROBLEM: Parameters hide the fields!
    public Person(String name, int age) {
        name = name;  // This assigns parameter to itself, not the field!
        age = age;    // Same problem here!
    }
}
```

### Solution: Use `this`

```java
public class Person {
    String name;
    int age;
    
    // ✅ SOLUTION: Use 'this' to refer to fields
    public Person(String name, int age) {
        this.name = name;  // this.name = field, name = parameter
        this.age = age;    // this.age = field, age = parameter
    }
}
```

### Visual Explanation

```
this.name = name;
  │         │
  │         └── Parameter (passed to constructor)
  │
  └── Field (belongs to the object)
```

### Complete Example with `this`

```java
public class Rectangle {
    double width;
    double height;
    String color;
    
    public Rectangle(double width, double height, String color) {
        this.width = width;     // Field = Parameter
        this.height = height;   // Field = Parameter
        this.color = color;     // Field = Parameter
    }
    
    double calculateArea() {
        return this.width * this.height;  // 'this' optional here but clear
    }
    
    void displayInfo() {
        System.out.println("Rectangle: " + this.width + " x " + this.height);
        System.out.println("Color: " + this.color);
        System.out.println("Area: " + this.calculateArea());
    }
}
```

### When to Use `this`

| Situation | Use `this`? | Example |
|-----------|-------------|---------|
| Parameter name = field name | ✅ Required | `this.name = name;` |
| Calling another constructor | ✅ Required | `this("default");` |
| Clarity in methods | 👍 Recommended | `return this.value;` |
| No name collision | 🤷 Optional | `return value;` |

---

## Constructor Chaining

One constructor can call another constructor using `this()`. This reduces code duplication.

### Without Chaining (Duplicate Code)

```java
public class Product {
    String name;
    double price;
    int quantity;
    
    // ❌ Repeated code in each constructor
    public Product() {
        name = "Unknown";
        price = 0.0;
        quantity = 0;
    }
    
    public Product(String name) {
        this.name = name;
        price = 0.0;      // Repeated!
        quantity = 0;     // Repeated!
    }
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        quantity = 0;     // Still repeated!
    }
    
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
```

### With Chaining (DRY Code)

```java
public class Product {
    String name;
    double price;
    int quantity;
    
    // ✅ Main constructor - does all the work
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Chains to main constructor
    public Product() {
        this("Unknown", 0.0, 0);
    }
    
    // Chains to main constructor
    public Product(String name) {
        this(name, 0.0, 0);
    }
    
    // Chains to main constructor
    public Product(String name, double price) {
        this(name, price, 0);
    }
}
```

### Constructor Chaining Rules

```
1. this() must be the FIRST statement in the constructor
2. Can only call ONE other constructor
3. Cannot create circular chains (A calls B, B calls A)
```

### Example: Employee with Chaining

```java
public class Employee {
    String name;
    String department;
    double salary;
    int yearsWorked;
    
    // Main constructor
    public Employee(String name, String department, double salary, int yearsWorked) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.yearsWorked = yearsWorked;
        System.out.println("Employee created: " + name);
    }
    
    // New employee (default department and salary)
    public Employee(String name) {
        this(name, "General", 30000.0, 0);
    }
    
    // Employee with department only
    public Employee(String name, String department) {
        this(name, department, 35000.0, 0);
    }
    
    // Default employee
    public Employee() {
        this("New Hire", "Unassigned", 25000.0, 0);
    }
}
```

---

## Real-World Examples

### Example 1: BankAccount

```java
public class BankAccount {
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
    
    // New account with zero balance
    public BankAccount(String accountNumber, String holderName) {
        this(accountNumber, holderName, 0.0, 0.02);  // 2% default rate
    }
    
    // Quick account (generates account number)
    public BankAccount(String holderName, double initialDeposit) {
        this("ACC" + System.currentTimeMillis(), holderName, initialDeposit, 0.02);
    }
    
    void displayInfo() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }
}
```

### Example 2: Movie

```java
public class Movie {
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
    
    // Without rating (new movie)
    public Movie(String title, String director, int year, String genre) {
        this(title, director, year, 0.0, genre);
    }
    
    // Minimal info
    public Movie(String title, int year) {
        this(title, "Unknown", year, 0.0, "Unknown");
    }
    
    void displayInfo() {
        System.out.println("🎬 " + title + " (" + year + ")");
        System.out.println("   Director: " + director);
        System.out.println("   Genre: " + genre);
        System.out.println("   Rating: " + (rating > 0 ? rating + "/10" : "Not rated"));
    }
}
```

### Example 3: Contact

```java
public class Contact {
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
        System.out.println("Contact: " + getFullName());
        System.out.println("  Email: " + email);
        System.out.println("  Phone: " + phone);
        System.out.println("  Address: " + address);
    }
}
```

---

## Common Mistakes

### Mistake 1: Adding Return Type

```java
// ❌ WRONG: Constructor cannot have a return type
public void Person(String name) {
    this.name = name;
}

// ✅ CORRECT: No return type
public Person(String name) {
    this.name = name;
}
```

### Mistake 2: Wrong Constructor Name

```java
// ❌ WRONG: Constructor name must match class name exactly
public class Person {
    public person(String name) {  // Lowercase 'p' - this is a method, not constructor!
        this.name = name;
    }
}

// ✅ CORRECT: Exact match
public class Person {
    public Person(String name) {  // Capital 'P' - matches class name
        this.name = name;
    }
}
```

### Mistake 3: Forgetting `this`

```java
// ❌ WRONG: Parameter shadows field
public Person(String name) {
    name = name;  // Does nothing useful!
}

// ✅ CORRECT: Use this to distinguish
public Person(String name) {
    this.name = name;  // Field = parameter
}
```

### Mistake 4: `this()` Not First

```java
// ❌ WRONG: this() must be first statement
public Person(String name) {
    System.out.println("Creating person...");
    this(name, 0);  // Error! Must be first line
}

// ✅ CORRECT: this() is first
public Person(String name) {
    this(name, 0);  // First line
    System.out.println("Creating person...");  // After this()
}
```

### Mistake 5: No Default Constructor After Adding Parameterized

```java
public class Person {
    String name;
    
    // Adding this constructor removes the default!
    public Person(String name) {
        this.name = name;
    }
}

// ❌ ERROR: No default constructor exists anymore
Person p = new Person();

// ✅ FIX: Add explicit default constructor
public class Person {
    String name;
    
    public Person() {
        this.name = "Unknown";
    }
    
    public Person(String name) {
        this.name = name;
    }
}
```

---

## Key Takeaways

✅ **Constructors initialize objects** - Called automatically when using `new`
✅ **Same name as class, no return type** - How Java identifies constructors
✅ **Default constructor** - Provided if you don't write any
✅ **Parameterized constructors** - Accept values to set fields
✅ **Constructor overloading** - Multiple constructors with different parameters
✅ **The `this` keyword** - Refers to current object, resolves name conflicts
✅ **Constructor chaining** - Use `this()` to call another constructor

---

## Next Steps

Now that you understand constructors, you're ready to learn:
1. **Encapsulation** - Control access to class members with private/public
2. **Inheritance** - Create class hierarchies and reuse code
3. **Polymorphism** - Objects that behave differently based on type

Happy coding! 🚀
