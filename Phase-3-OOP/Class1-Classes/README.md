# Class 1: Classes & Objects 📦

Welcome to **Phase 3, Class 1**! In this class, you'll learn the fundamentals of **Object-Oriented Programming (OOP)** by creating and using **classes** and **objects**.

---

## Table of Contents
1. [What is a Class?](#what-is-a-class)
2. [Class Syntax](#class-syntax)
3. [Fields and Methods](#fields-and-methods)
4. [Creating Objects](#creating-objects)
5. [Real-World Examples](#real-world-examples)
6. [Common Mistakes](#common-mistakes)

---

## What is a Class?

A **class** is a blueprint for creating objects. Think of it like a cookie cutter - the class defines the shape, and each object is a cookie made from that cutter.

### Class vs Object

```
Class:  Blueprint, template, definition
Object: Instance, actual thing created from the blueprint

Example:
┌─────────────────────────────────────────┐
│ CLASS: Car                              │
│ ─────────────────────────────────────   │
│ Attributes:                             │
│   - color                               │
│   - brand                               │
│   - speed                               │
│ Methods:                                │
│   - accelerate()                        │
│   - brake()                             │
│   - honk()                              │
└─────────────────────────────────────────┘
           ↓ (Blueprint)
┌──────────────────┐  ┌──────────────────┐  ┌──────────────────┐
│ OBJECT: myCar    │  │ OBJECT: yourCar  │  │ OBJECT: taxiCar  │
│ ─────────────────│  │ ─────────────────│  │ ─────────────────│
│ color: red       │  │ color: blue      │  │ color: yellow    │
│ brand: Toyota    │  │ brand: Honda     │  │ brand: Chevy     │
│ speed: 0         │  │ speed: 50        │  │ speed: 80        │
└──────────────────┘  └──────────────────┘  └──────────────────┘
```

### Why Use Classes?

1. **Organization** - Group related data and functionality
2. **Reusability** - Create many objects from one class
3. **Maintainability** - Easier to update and debug
4. **Real-world modeling** - Mirror how we think about the world

---

## Class Syntax

### Basic Class Structure

```java
public class Car {
    // 1. FIELDS (attributes, properties, state)
    String color;
    String brand;
    int speed;
    
    // 2. METHODS (behavior, actions)
    void accelerate() {
        speed += 10;
    }
    
    void brake() {
        speed -= 10;
    }
    
    void honk() {
        System.out.println("Beep beep!");
    }
}
```

### Class Declaration

```java
public class ClassName {
    // Code goes here
}
```

**Rules:**
- Class name starts with **uppercase** letter
- One `public` class per file
- File name matches class name exactly
- Save as `ClassName.java`

### Example: Person Class

```java
public class Person {
    // Fields (instance variables)
    String name;
    int age;
    double height;
    String occupation;
    
    // Methods
    void introduce() {
        System.out.println("Hi, I'm " + name);
    }
    
    void celebrateBirthday() {
        age = age + 1;
        System.out.println("Happy birthday! Now " + age + " years old.");
    }
    
    void changeJob(String newJob) {
        occupation = newJob;
        System.out.println("I'm now a " + occupation);
    }
}
```

---

## Fields and Methods

### Fields (Instance Variables)

Fields store the **state** or **data** of an object.

```java
public class Student {
    String name;        // Field
    int studentID;      // Field
    double gpa;         // Field
    String major;       // Field
}
```

**Types of fields:**
```java
public class DataTypes {
    // Primitive types
    int age;
    double salary;
    boolean isActive;
    char grade;
    
    // Reference types
    String name;
    int[] grades;
    ArrayList<String> hobbies;
}
```

### Methods (Behavior)

Methods define what an object can **do**.

```java
public class Dog {
    String name;
    String breed;
    
    // Method without parameters or return value
    void bark() {
        System.out.println(name + " says: Woof woof!");
    }
    
    // Method with parameter, no return value
    void eat(String food) {
        System.out.println(name + " is eating " + food);
    }
    
    // Method with return value, no parameters
    String getBreed() {
        return breed;
    }
    
    // Method with parameters and return value
    int calculateAge(int dogYears) {
        return dogYears * 7;
    }
    
    // Method accessing fields
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Breed: " + breed);
    }
}
```

### Accessing Fields and Methods

Inside methods, access fields without "this." for simplicity:

```java
public class BankAccount {
    double balance;
    String accountNumber;
    
    // Access fields directly
    void deposit(double amount) {
        balance = balance + amount;  // Access field
    }
    
    double getBalance() {
        return balance;  // Access field
    }
    
    void displayInfo() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}
```

---

## Creating Objects

### Object Declaration and Instantiation

```java
// Step 1: Declare a variable to hold the reference
Car myCar;

// Step 2: Create an object (instantiate)
myCar = new Car();

// Or do both in one line:
Car myCar = new Car();
```

### Understanding `new`

```
new Car()
└─┬──┘
  └─ Creates a new object in memory
    and calls the default constructor

myCar = ...
└─ Assigns the reference to the variable
```

### Creating Multiple Objects

```java
public class Main {
    public static void main(String[] args) {
        // Create first Car object
        Car car1 = new Car();
        car1.color = "red";
        car1.brand = "Toyota";
        
        // Create second Car object
        Car car2 = new Car();
        car2.color = "blue";
        car2.brand = "Honda";
        
        // Each object is separate!
        System.out.println(car1.color);  // Output: red
        System.out.println(car2.color);  // Output: blue
    }
}
```

### Using Object Fields

```java
Car myCar = new Car();

// Set field values
myCar.color = "red";
myCar.brand = "Toyota";
myCar.speed = 0;

// Read field values
System.out.println(myCar.color);    // Output: red
System.out.println(myCar.brand);    // Output: Toyota
System.out.println(myCar.speed);    // Output: 0
```

### Using Object Methods

```java
Dog myDog = new Dog();
myDog.name = "Buddy";
myDog.breed = "Golden Retriever";

// Call methods on the object
myDog.bark();           // Calls the bark() method
myDog.eat("dog food");  // Calls eat() method with parameter
String breed = myDog.getBreed();  // Gets return value
myDog.displayInfo();    // Calls displayInfo() method
```

---

## Real-World Examples

### Example 1: Book Class

```java
public class Book {
    // Fields
    String title;
    String author;
    int pages;
    double price;
    boolean isAvailable;
    
    // Methods
    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Price: $" + price);
    }
    
    void checkout() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " checked out!");
        } else {
            System.out.println(title + " is not available.");
        }
    }
    
    void returnBook() {
        isAvailable = true;
        System.out.println(title + " returned!");
    }
    
    int readingTime() {
        return pages / 50;  // Assuming 50 pages per hour
    }
}
```

**Usage:**
```java
Book book = new Book();
book.title = "Java Programming";
book.author = "John Doe";
book.pages = 500;
book.price = 45.99;
book.isAvailable = true;

book.displayInfo();
System.out.println("Estimated reading time: " + book.readingTime() + " hours");
book.checkout();
book.returnBook();
```

**Output:**
```
Title: Java Programming
Author: John Doe
Pages: 500
Price: $45.99
Estimated reading time: 10 hours
Java Programming checked out!
Java Programming returned!
```

### Example 2: Rectangle Class

```java
public class Rectangle {
    double width;
    double height;
    String color;
    
    void displayDimensions() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Color: " + color);
    }
    
    double calculateArea() {
        return width * height;
    }
    
    double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    boolean isSquare() {
        return width == height;
    }
    
    void resize(double newWidth, double newHeight) {
        width = newWidth;
        height = newHeight;
    }
}
```

**Usage:**
```java
Rectangle rect = new Rectangle();
rect.width = 10;
rect.height = 5;
rect.color = "blue";

rect.displayDimensions();
System.out.println("Area: " + rect.calculateArea());
System.out.println("Perimeter: " + rect.calculatePerimeter());
System.out.println("Is square? " + rect.isSquare());

rect.resize(8, 8);
System.out.println("Is square now? " + rect.isSquare());
```

**Output:**
```
Width: 10.0
Height: 5.0
Color: blue
Area: 50.0
Perimeter: 30.0
Is square? false
Is square now? true
```

### Example 3: BankAccount Class

```java
public class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;
    
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }
    
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
    
    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
    
    double getBalance() {
        return balance;
    }
    
    boolean hasEnoughFunds(double amount) {
        return amount <= balance;
    }
}
```

**Usage:**
```java
BankAccount account = new BankAccount();
account.accountHolder = "Alice";
account.accountNumber = "123456789";
account.balance = 1000;

account.displayBalance();
account.deposit(500);
account.withdraw(300);
account.displayBalance();

if (account.hasEnoughFunds(100)) {
    System.out.println("You can withdraw $100");
} else {
    System.out.println("Insufficient funds!");
}
```

**Output:**
```
Account Holder: Alice
Account Number: 123456789
Balance: $1000.0
Deposited: $500.0
New balance: $1500.0
Withdrew: $300.0
New balance: $1200.0
Account Holder: Alice
Account Number: 123456789
Balance: $1200.0
You can withdraw $100
```

---

## Common Mistakes

### Mistake 1: Forgetting to Create an Object

```java
// ❌ WRONG: Using a class name instead of an object
Car.color = "red";  // Error!

// ✅ CORRECT: Create an object first
Car myCar = new Car();
myCar.color = "red";
```

### Mistake 2: Confusing Class and Object

```java
// ❌ WRONG: Treating them the same
Car myCar;
myCar.color = "red";  // Error! myCar is null

// ✅ CORRECT: Create the object
Car myCar = new Car();
myCar.color = "red";  // OK!
```

### Mistake 3: Modifying One Object Affects Another

```java
// ❌ WRONG: Thinking objects are linked
Car car1 = new Car();
car1.color = "red";

Car car2 = car1;  // This references the same object!
car2.color = "blue";

System.out.println(car1.color);  // Output: blue (not red!)
```

### Mistake 4: Empty Classes Without Purpose

```java
// ❌ NOT USEFUL: Class with no fields or methods
public class EmptyClass {
}

// ✅ BETTER: Class with meaningful content
public class Student {
    String name;
    int studentID;
    
    void enrollCourse(String course) {
        System.out.println(name + " enrolled in " + course);
    }
}
```

### Mistake 5: Method Doesn't Match Intended Behavior

```java
// ❌ CONFUSING: Method name doesn't match what it does
public class Car {
    int speed;
    
    void honk() {  // Wrong! This should accelerate
        speed += 20;
    }
}

// ✅ CLEAR: Method names describe what they do
public class Car {
    int speed;
    
    void accelerate() {
        speed += 20;
    }
    
    void honk() {
        System.out.println("Beep!");
    }
}
```

---

## Key Takeaways

✅ **Classes are blueprints** - They define the structure for objects
✅ **Objects are instances** - Created from a class using `new`
✅ **Fields store data** - The state of an object
✅ **Methods define behavior** - What an object can do
✅ **Each object is independent** - Changes to one don't affect others
✅ **Use meaningful names** - Class, field, and method names should be clear

---

## Next Steps

Now that you understand classes and objects, you're ready to learn about:
1. **Constructors** - Initialize objects when they're created
2. **Encapsulation** - Control how objects are used
3. **Inheritance** - Reuse code across multiple classes
4. **Polymorphism** - Objects that behave differently based on context

Happy coding! 🚀
