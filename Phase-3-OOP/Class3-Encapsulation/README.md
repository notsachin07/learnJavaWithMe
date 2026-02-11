# Class 3: Encapsulation 🔒

Welcome to **Phase 3, Class 3**! In this class, you'll learn about **encapsulation** - one of the four pillars of Object-Oriented Programming. Encapsulation protects your data and controls how it's accessed.

---

## Table of Contents
1. [What is Encapsulation?](#what-is-encapsulation)
2. [Access Modifiers](#access-modifiers)
3. [Getters and Setters](#getters-and-setters)
4. [Why Use Encapsulation?](#why-use-encapsulation)
5. [Validation in Setters](#validation-in-setters)
6. [Read-Only and Write-Only Fields](#read-only-and-write-only-fields)
7. [Best Practices](#best-practices)
8. [Common Mistakes](#common-mistakes)

---

## What is Encapsulation?

**Encapsulation** is the practice of:
1. Making fields **private** (hidden from outside)
2. Providing **public methods** to access and modify them
3. **Controlling** how data is read and written

### Without Encapsulation (Dangerous!)

```java
public class BankAccount {
    public double balance;  // Anyone can access directly!
}

// Problem: No control over data
BankAccount account = new BankAccount();
account.balance = -1000000;  // Invalid! But nothing stops it
account.balance = account.balance * 1000;  // Fraud!
```

### With Encapsulation (Safe!)

```java
public class BankAccount {
    private double balance;  // Hidden from outside
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

// Now: Controlled access
BankAccount account = new BankAccount();
account.deposit(1000);     // ✅ Valid
account.withdraw(500);     // ✅ Valid
account.balance = -1000;   // ❌ Compile error! balance is private
```

### The Concept

```
┌─────────────────────────────────────────────────────────┐
│                    ENCAPSULATION                        │
├─────────────────────────────────────────────────────────┤
│                                                         │
│   ┌───────────────────────────────────────────┐        │
│   │           PRIVATE (Hidden)                │        │
│   │                                           │        │
│   │   - balance                               │        │
│   │   - accountNumber                         │        │
│   │   - password                              │        │
│   │                                           │        │
│   └───────────────────────────────────────────┘        │
│                        ▲                               │
│                        │ (controlled access)           │
│                        ▼                               │
│   ┌───────────────────────────────────────────┐        │
│   │           PUBLIC (Accessible)             │        │
│   │                                           │        │
│   │   + getBalance()                          │        │
│   │   + deposit(amount)                       │        │
│   │   + withdraw(amount)                      │        │
│   │                                           │        │
│   └───────────────────────────────────────────┘        │
│                                                         │
└─────────────────────────────────────────────────────────┘
```

---

## Access Modifiers

Java has four access modifiers that control visibility:

| Modifier | Class | Package | Subclass | World |
|----------|-------|---------|----------|-------|
| `private` | ✅ | ❌ | ❌ | ❌ |
| (default) | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

### private

Only accessible within the same class.

```java
public class Person {
    private String password;  // Only this class can access
    
    private void secretMethod() {
        // Only callable from within Person
    }
}
```

### public

Accessible from anywhere.

```java
public class Person {
    public String name;  // Accessible from anywhere
    
    public void greet() {
        System.out.println("Hello!");
    }
}
```

### default (Package-Private)

No modifier = accessible within the same package.

```java
public class Person {
    String nickname;  // Accessible within same package
    
    void packageMethod() {
        // Callable from same package
    }
}
```

### protected

Accessible within package and by subclasses.

```java
public class Person {
    protected int age;  // Accessible in package and subclasses
    
    protected void familySecret() {
        // Callable from same package and child classes
    }
}
```

---

## Getters and Setters

**Getters** read private field values. **Setters** modify them.

### Basic Getter and Setter

```java
public class Person {
    private String name;
    private int age;
    
    // Getter for name
    public String getName() {
        return name;
    }
    
    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter for age
    public int getAge() {
        return age;
    }
    
    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }
}
```

### Using Getters and Setters

```java
Person person = new Person();

// Using setter
person.setName("Alice");
person.setAge(25);

// Using getter
System.out.println(person.getName());  // Output: Alice
System.out.println(person.getAge());   // Output: 25
```

### Naming Convention

| Type | Field | Getter | Setter |
|------|-------|--------|--------|
| Regular | `name` | `getName()` | `setName()` |
| Boolean | `active` | `isActive()` | `setActive()` |
| Boolean | `valid` | `isValid()` | `setValid()` |

```java
public class User {
    private String username;
    private boolean active;
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public boolean isActive() { return active; }  // Note: is, not get
    public void setActive(boolean active) { this.active = active; }
}
```

---

## Why Use Encapsulation?

### 1. Data Protection

```java
public class Employee {
    private double salary;
    
    public void setSalary(double salary) {
        if (salary >= 0) {  // Validation!
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative!");
        }
    }
}
```

### 2. Flexibility to Change Implementation

```java
// Original: Store temperature in Celsius
public class Temperature {
    private double celsius;
    
    public double getCelsius() {
        return celsius;
    }
    
    public double getFahrenheit() {
        return celsius * 9/5 + 32;  // Convert on the fly
    }
}

// Later: Change internal storage to Fahrenheit
// External code still works the same!
```

### 3. Control Over Data

```java
public class Counter {
    private int count = 0;
    
    public int getCount() {
        return count;
    }
    
    public void increment() {
        count++;  // Controlled way to modify
    }
    
    public void decrement() {
        if (count > 0) {
            count--;
        }
    }
    
    // No setCount() - count can only change through increment/decrement
}
```

### 4. Hide Complexity

```java
public class EmailSender {
    private String smtpServer;
    private int port;
    private String apiKey;
    
    // User doesn't need to know these details
    public void sendEmail(String to, String message) {
        // Complex implementation hidden
        connectToServer();
        authenticate();
        formatMessage(message);
        transmit(to);
        disconnect();
    }
    
    private void connectToServer() { /* ... */ }
    private void authenticate() { /* ... */ }
    private void formatMessage(String msg) { /* ... */ }
    private void transmit(String to) { /* ... */ }
    private void disconnect() { /* ... */ }
}
```

---

## Validation in Setters

One of the biggest benefits of setters is **validation**.

### Age Validation

```java
public class Person {
    private int age;
    
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Invalid age: " + age);
            this.age = 0;  // Default value
        }
    }
    
    public int getAge() {
        return age;
    }
}
```

### Email Validation

```java
public class User {
    private String email;
    
    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("Invalid email format!");
        }
    }
    
    public String getEmail() {
        return email;
    }
}
```

### Grade Validation

```java
public class Student {
    private double grade;
    
    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else if (grade < 0) {
            System.out.println("Grade cannot be negative. Setting to 0.");
            this.grade = 0;
        } else {
            System.out.println("Grade cannot exceed 100. Setting to 100.");
            this.grade = 100;
        }
    }
    
    public double getGrade() {
        return grade;
    }
    
    public String getLetterGrade() {
        if (grade >= 90) return "A";
        if (grade >= 80) return "B";
        if (grade >= 70) return "C";
        if (grade >= 60) return "D";
        return "F";
    }
}
```

### Complete Example: BankAccount

```java
public class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    private boolean isActive;
    
    // Constructor
    public BankAccount(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        setHolderName(holderName);  // Use setter for validation
        this.balance = 0;
        this.isActive = true;
    }
    
    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getHolderName() {
        return holderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    // Setters with validation
    public void setHolderName(String holderName) {
        if (holderName != null && holderName.length() >= 2) {
            this.holderName = holderName;
        } else {
            System.out.println("Invalid name. Must be at least 2 characters.");
        }
    }
    
    public void setActive(boolean active) {
        this.isActive = active;
    }
    
    // No setBalance() - must use deposit/withdraw
    // No setAccountNumber() - should never change
    
    // Business methods
    public void deposit(double amount) {
        if (!isActive) {
            System.out.println("Account is inactive!");
            return;
        }
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }
    
    public void withdraw(double amount) {
        if (!isActive) {
            System.out.println("Account is inactive!");
            return;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            System.out.println("Withdrawal amount must be positive!");
        }
    }
}
```

---

## Read-Only and Write-Only Fields

### Read-Only (Only Getter)

Some fields should only be read, not modified after creation.

```java
public class Employee {
    private final String employeeId;  // final = cannot change
    private String name;
    
    public Employee(String employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }
    
    // Getter only - no setter!
    public String getEmployeeId() {
        return employeeId;
    }
    
    // Both getter and setter
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
```

### Write-Only (Only Setter) - Rare

Sometimes you want to set but not read (like passwords).

```java
public class User {
    private String password;
    
    // Setter only - no getter for security!
    public void setPassword(String password) {
        if (password.length() >= 8) {
            this.password = hashPassword(password);
        } else {
            System.out.println("Password must be at least 8 characters!");
        }
    }
    
    // Instead of getter, provide validation method
    public boolean checkPassword(String attempt) {
        return hashPassword(attempt).equals(this.password);
    }
    
    private String hashPassword(String password) {
        // In real code, use proper hashing
        return password;  // Simplified
    }
}
```

### Computed Properties (Getter Only, No Field)

```java
public class Rectangle {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
    
    // Computed properties - no actual field!
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
```

---

## Best Practices

### 1. Make Fields Private by Default

```java
// ✅ GOOD
public class Person {
    private String name;
    private int age;
}

// ❌ AVOID
public class Person {
    public String name;
    public int age;
}
```

### 2. Use Meaningful Validation

```java
// ✅ GOOD: Validates and gives feedback
public void setAge(int age) {
    if (age >= 0 && age <= 150) {
        this.age = age;
    } else {
        throw new IllegalArgumentException("Age must be between 0 and 150");
    }
}

// ❌ BAD: Silently ignores invalid input
public void setAge(int age) {
    if (age >= 0) {
        this.age = age;
    }
    // What if age is negative? Nothing happens, no feedback!
}
```

### 3. Use Constructors with Setters

```java
public class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        setName(name);  // Use setters for validation
        setAge(age);
    }
    
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
    
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
```

### 4. Return Copies of Mutable Objects

```java
public class Student {
    private int[] grades;
    
    // ❌ BAD: Returns reference to internal array
    public int[] getGrades() {
        return grades;  // Caller can modify internal array!
    }
    
    // ✅ GOOD: Returns a copy
    public int[] getGrades() {
        return grades.clone();  // Caller gets a copy
    }
}
```

### 5. Don't Expose Implementation Details

```java
// ❌ BAD: Exposes HashMap implementation
public class StudentRegistry {
    private HashMap<String, Student> students;
    
    public HashMap<String, Student> getStudents() {
        return students;
    }
}

// ✅ GOOD: Hides implementation
public class StudentRegistry {
    private HashMap<String, Student> students;
    
    public Student getStudent(String id) {
        return students.get(id);
    }
    
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }
    
    public int getStudentCount() {
        return students.size();
    }
}
```

---

## Common Mistakes

### Mistake 1: Public Fields

```java
// ❌ WRONG
public class Person {
    public String name;  // No protection!
}

// ✅ CORRECT
public class Person {
    private String name;
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

### Mistake 2: Getters/Setters Without Private Fields

```java
// ❌ POINTLESS: Field is still public!
public class Person {
    public String name;
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

// Why pointless? Can still do: person.name = "anything";
```

### Mistake 3: No Validation in Setters

```java
// ❌ WEAK: No validation
public void setAge(int age) {
    this.age = age;  // Allows negative ages!
}

// ✅ STRONG: With validation
public void setAge(int age) {
    if (age >= 0 && age <= 150) {
        this.age = age;
    } else {
        throw new IllegalArgumentException("Invalid age: " + age);
    }
}
```

### Mistake 4: Returning Mutable Objects

```java
// ❌ DANGEROUS: Returns reference
public class Team {
    private ArrayList<String> members;
    
    public ArrayList<String> getMembers() {
        return members;  // Caller can modify!
    }
}

// External code can do:
team.getMembers().clear();  // Deletes all members!

// ✅ SAFE: Return copy or unmodifiable view
public ArrayList<String> getMembers() {
    return new ArrayList<>(members);
}
```

### Mistake 5: Forgetting `this` Keyword

```java
// ❌ WRONG: Assigns parameter to itself
public void setName(String name) {
    name = name;  // Does nothing!
}

// ✅ CORRECT: Uses this
public void setName(String name) {
    this.name = name;
}
```

---

## Key Takeaways

✅ **Encapsulation** = Private fields + Public methods
✅ **private** hides data from outside access
✅ **Getters** read values, **Setters** modify values
✅ **Validate** data in setters to maintain integrity
✅ **Read-only** = getter only, **Write-only** = setter only
✅ **Return copies** of mutable objects
✅ **Hide implementation** details, expose only what's needed

---

## Next Steps

Now that you understand encapsulation, you're ready for:
1. **Inheritance** - Create class hierarchies and reuse code
2. **Polymorphism** - Objects behaving differently based on type

Keep your data safe! 🔒
