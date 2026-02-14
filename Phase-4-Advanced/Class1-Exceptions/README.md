# Class 1: Exception Handling 🛡️

Welcome to **Phase 4, Class 1**! In this class, you'll learn how to handle errors gracefully using **exception handling** - a critical skill for writing robust, production-quality code.

---

## Table of Contents
1. [What are Exceptions?](#what-are-exceptions)
2. [Try-Catch Blocks](#try-catch-blocks)
3. [Multiple Catch Blocks](#multiple-catch-blocks)
4. [The Finally Block](#the-finally-block)
5. [Throwing Exceptions](#throwing-exceptions)
6. [Checked vs Unchecked Exceptions](#checked-vs-unchecked-exceptions)
7. [Custom Exceptions](#custom-exceptions)
8. [Try-With-Resources](#try-with-resources)
9. [Best Practices](#best-practices)
10. [Common Mistakes](#common-mistakes)
11. [Summary](#summary)

---

## What are Exceptions?

An **exception** is an event that disrupts the normal flow of a program. Without handling, exceptions crash your program.

### Common Exceptions

| Exception | Cause |
|-----------|-------|
| `NullPointerException` | Accessing a method/field on `null` |
| `ArrayIndexOutOfBoundsException` | Invalid array index |
| `ArithmeticException` | Division by zero |
| `NumberFormatException` | Invalid number conversion |
| `FileNotFoundException` | File doesn't exist |
| `IOException` | General I/O failure |

### Without Exception Handling

```java
int result = 10 / 0;  // ArithmeticException - Program crashes!
System.out.println("This never runs");
```

### With Exception Handling

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero!");
}
System.out.println("Program continues...");
```

---

## Try-Catch Blocks

The `try` block contains code that might throw an exception. The `catch` block handles it.

### Basic Syntax

```java
try {
    // Code that might throw an exception
} catch (ExceptionType e) {
    // Handle the exception
}
```

### Example: Handling Division by Zero

```java
public static int safeDivide(int a, int b) {
    try {
        return a / b;
    } catch (ArithmeticException e) {
        System.out.println("Error: Cannot divide by zero");
        return 0;  // Return a default value
    }
}
```

### Accessing Exception Information

```java
try {
    int[] arr = {1, 2, 3};
    System.out.println(arr[10]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Message: " + e.getMessage());
    System.out.println("Type: " + e.getClass().getName());
    e.printStackTrace();  // Print full stack trace
}
```

---

## Multiple Catch Blocks

Handle different exception types differently.

```java
try {
    String str = null;
    int num = Integer.parseInt(str);
} catch (NullPointerException e) {
    System.out.println("Value was null!");
} catch (NumberFormatException e) {
    System.out.println("Invalid number format!");
}
```

### Multi-Catch (Java 7+)

```java
try {
    // risky code
} catch (NullPointerException | NumberFormatException e) {
    System.out.println("Either null or bad format: " + e.getMessage());
}
```

### Catch Order Matters

```java
// ❌ WRONG: Parent exception first
try {
    // code
} catch (Exception e) {           // Catches everything!
    // ...
} catch (ArithmeticException e) { // Never reached
    // ...
}

// ✅ CORRECT: Specific exceptions first
try {
    // code
} catch (ArithmeticException e) { // Specific
    // ...
} catch (Exception e) {           // General fallback
    // ...
}
```

---

## The Finally Block

Code in `finally` **always runs**, whether an exception occurs or not. Use it for cleanup.

```java
try {
    System.out.println("Trying...");
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Caught exception");
} finally {
    System.out.println("Finally always runs!");
}
```

Output:
```
Trying...
Caught exception
Finally always runs!
```

### Use Cases for Finally

- Closing files
- Closing database connections
- Releasing resources
- Cleanup operations

---

## Throwing Exceptions

Use `throw` to create and throw exceptions manually.

### Throwing Built-in Exceptions

```java
public void setAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("Age cannot be negative");
    }
    this.age = age;
}
```

### The `throws` Keyword

Declare that a method might throw an exception.

```java
public void readFile(String path) throws FileNotFoundException {
    FileReader reader = new FileReader(path);
    // ... read file
}
```

---

## Checked vs Unchecked Exceptions

### Checked Exceptions

- **Must** be handled or declared
- Compiler enforces handling
- Examples: `IOException`, `SQLException`, `FileNotFoundException`

```java
// Must handle or declare throws
public void readFile() throws IOException {
    FileReader fr = new FileReader("file.txt");
}
```

### Unchecked Exceptions (RuntimeException)

- Handling is optional
- Usually indicate programming bugs
- Examples: `NullPointerException`, `ArrayIndexOutOfBoundsException`

```java
// No requirement to handle
String s = null;
s.length();  // NullPointerException at runtime
```

### Exception Hierarchy

```
Throwable
├── Error (serious problems, don't catch)
│   ├── OutOfMemoryError
│   └── StackOverflowError
└── Exception
    ├── IOException (checked)
    ├── SQLException (checked)
    └── RuntimeException (unchecked)
        ├── NullPointerException
        ├── ArithmeticException
        └── IllegalArgumentException
```

---

## Custom Exceptions

Create your own exception types for domain-specific errors.

### Creating a Custom Exception

```java
public class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(double amount) {
        super("Insufficient funds. Short by: $" + amount);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
```

### Using the Custom Exception

```java
public class BankAccount {
    private double balance;

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
    }
}
```

### Catching the Custom Exception

```java
BankAccount account = new BankAccount(100);
try {
    account.withdraw(150);
} catch (InsufficientFundsException e) {
    System.out.println(e.getMessage());
    System.out.println("You need: $" + e.getAmount());
}
```

---

## Try-With-Resources

Automatically close resources when done (Java 7+).

### Old Way

```java
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader("file.txt"));
    String line = reader.readLine();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Modern Way (Try-With-Resources)

```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    String line = reader.readLine();
} catch (IOException e) {
    e.printStackTrace();
}
// reader is automatically closed!
```

### Multiple Resources

```java
try (
    FileReader fr = new FileReader("input.txt");
    FileWriter fw = new FileWriter("output.txt")
) {
    // Use both resources
} catch (IOException e) {
    e.printStackTrace();
}
```

---

## Best Practices

### ✅ Do

1. **Catch specific exceptions** - Not just `Exception`
2. **Log exceptions** - Don't swallow them silently
3. **Use try-with-resources** - For any `Closeable` resource
4. **Throw early, catch late** - Validate inputs early
5. **Include context** - Helpful error messages

### ❌ Don't

1. **Don't catch `Throwable`** - Includes `Error` types
2. **Don't ignore exceptions** - Empty catch blocks are bad
3. **Don't use exceptions for flow control** - They're expensive
4. **Don't expose internal exceptions** - Wrap them appropriately

### Example: Good vs Bad

```java
// ❌ BAD: Empty catch block
try {
    riskyOperation();
} catch (Exception e) {
    // silently ignored
}

// ✅ GOOD: Proper handling
try {
    riskyOperation();
} catch (SpecificException e) {
    logger.error("Operation failed: " + e.getMessage(), e);
    throw new ServiceException("Could not complete operation", e);
}
```

---

## Common Mistakes

### ❌ Catching Too Broadly

```java
// BAD
try {
    doSomething();
} catch (Exception e) {  // Catches everything!
    System.out.println("Error");
}
```

### ❌ Ignoring Exceptions

```java
// BAD
try {
    Integer.parseInt("abc");
} catch (NumberFormatException e) {
    // Do nothing - BAD!
}
```

### ❌ Not Using Finally for Cleanup

```java
// BAD
Connection conn = getConnection();
try {
    useConnection(conn);
} catch (SQLException e) {
    e.printStackTrace();
}
// Connection never closed if exception occurs!
```

### ✅ Correct Version

```java
Connection conn = getConnection();
try {
    useConnection(conn);
} catch (SQLException e) {
    e.printStackTrace();
} finally {
    conn.close();
}
```

---

## Summary

| Concept | Description |
|---------|-------------|
| `try` | Block containing risky code |
| `catch` | Handles specific exception types |
| `finally` | Always executes (cleanup) |
| `throw` | Create and throw an exception |
| `throws` | Declare method may throw exception |
| Checked | Must be handled (compiler enforces) |
| Unchecked | RuntimeException - optional handling |
| Custom | Extend `Exception` for domain errors |
| Try-with-resources | Auto-close `Closeable` resources |

---

**Congratulations!** You now know how to write resilient code that handles errors gracefully. Next up: **Collections** - dynamic data structures! 🚀
