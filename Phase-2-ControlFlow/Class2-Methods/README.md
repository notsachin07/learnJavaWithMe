# Class 2: Methods - Organizing Your Code 🔧

Welcome to **Phase 2, Class 2**! In this class, you'll learn how to organize your code into **methods** - reusable blocks of code that perform specific tasks. Methods make your programs cleaner, easier to understand, and easier to maintain!

---

## 📌 What You'll Learn

- What methods are and why we use them
- How to define and call methods
- Parameters and arguments
- Return values and return types
- Method overloading
- Variable scope
- Best practices for writing methods

---

## 🎯 Why Methods Matter

Without methods, you'd have to write the same code over and over. With methods:
- **Reuse code** - Write once, use many times
- **Organize code** - Break complex problems into smaller pieces
- **Improve readability** - Give meaningful names to blocks of code
- **Easier debugging** - Fix bugs in one place
- **Collaboration** - Different people can work on different methods

---

## 📋 The Complete Code Example

```java
/**
 * Class 2: Methods
 *
 * Demonstrates:
 * - Method definition and calling
 * - Parameters and arguments
 * - Return values
 * - Method overloading
 * - Variable scope
 *
 * How to run:
 * 1. Save as: Methods.java
 * 2. Compile: javac Methods.java
 * 3. Run:    java Methods
 */

public class Methods {

    public static void main(String[] args) {
        // ... (see Methods.java for complete code)
    }
    
    // Method definitions go here
}
```

---

## 🔍 Method Anatomy

### Basic Method Structure

```java
accessModifier returnType methodName(parameters) {
    // method body
    // code to execute
    return value;  // if returnType is not void
}
```

### Breaking Down Each Part

```java
public static int add(int a, int b) {
    int sum = a + b;
    return sum;
}
```

| Part | Code | Description |
|------|------|-------------|
| **Access Modifier** | `public` | Who can access this method (public = everyone) |
| **Static Keyword** | `static` | Method belongs to the class, not an object |
| **Return Type** | `int` | What type of value the method gives back |
| **Method Name** | `add` | The name used to call this method |
| **Parameters** | `(int a, int b)` | Input values the method needs |
| **Method Body** | `{ ... }` | The code that runs when method is called |
| **Return Statement** | `return sum;` | Sends the result back to the caller |

---

## 1️⃣ Methods Without Parameters or Return (void)

The simplest type of method - just performs an action.

```java
public static void sayHello() {
    System.out.println("Hello, World!");
}

public static void printLine() {
    System.out.println("========================");
}

public static void main(String[] args) {
    sayHello();      // Output: Hello, World!
    printLine();     // Output: ========================
    sayHello();      // Output: Hello, World!
}
```

### Key Points:
- `void` means the method returns nothing
- No parameters in the parentheses `()`
- Called by using the method name followed by `()`

---

## 2️⃣ Methods With Parameters

Parameters let you pass data INTO a method.

```java
public static void greet(String name) {
    System.out.println("Hello, " + name + "!");
}

public static void printSum(int a, int b) {
    System.out.println(a + " + " + b + " = " + (a + b));
}

public static void main(String[] args) {
    greet("Alice");           // Output: Hello, Alice!
    greet("Bob");             // Output: Hello, Bob!
    
    printSum(5, 3);           // Output: 5 + 3 = 8
    printSum(10, 20);         // Output: 10 + 20 = 30
}
```

### Parameters vs Arguments

| Term | Definition | Example |
|------|------------|---------|
| **Parameter** | Variable in method definition | `String name` in `greet(String name)` |
| **Argument** | Actual value passed when calling | `"Alice"` in `greet("Alice")` |

### Multiple Parameters

```java
public static void printPersonInfo(String name, int age, String city) {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("City: " + city);
}

// Calling with multiple arguments
printPersonInfo("Alice", 25, "New York");
```

---

## 3️⃣ Methods With Return Values

Return values let you get data OUT of a method.

```java
public static int add(int a, int b) {
    return a + b;
}

public static double calculateArea(double radius) {
    return Math.PI * radius * radius;
}

public static boolean isEven(int number) {
    return number % 2 == 0;
}

public static void main(String[] args) {
    // Store the returned value
    int sum = add(5, 3);
    System.out.println("Sum: " + sum);           // Output: Sum: 8
    
    // Use directly in expression
    System.out.println("10 + 20 = " + add(10, 20));  // Output: 10 + 20 = 30
    
    double area = calculateArea(5.0);
    System.out.println("Area: " + area);         // Output: Area: 78.539...
    
    if (isEven(4)) {
        System.out.println("4 is even");         // This prints
    }
}
```

### Common Return Types

| Return Type | Description | Example Return |
|-------------|-------------|----------------|
| `int` | Integer number | `return 42;` |
| `double` | Decimal number | `return 3.14;` |
| `boolean` | True or false | `return true;` |
| `String` | Text | `return "Hello";` |
| `void` | Nothing | (no return needed) |

### The `return` Statement

```java
public static int max(int a, int b) {
    if (a > b) {
        return a;    // Exits method and returns a
    } else {
        return b;    // Exits method and returns b
    }
}

// Or more concisely:
public static int max(int a, int b) {
    return (a > b) ? a : b;
}
```

**Important:** `return` immediately exits the method!

```java
public static void checkAge(int age) {
    if (age < 0) {
        System.out.println("Invalid age!");
        return;  // Exit early - code below won't run
    }
    System.out.println("Age is valid: " + age);
}
```

---

## 4️⃣ Method Overloading

**Overloading** means having multiple methods with the **same name** but **different parameters**.

```java
// Same method name, different parameter types/counts
public static int add(int a, int b) {
    return a + b;
}

public static int add(int a, int b, int c) {
    return a + b + c;
}

public static double add(double a, double b) {
    return a + b;
}

public static void main(String[] args) {
    System.out.println(add(5, 3));           // Calls int version: 8
    System.out.println(add(5, 3, 2));        // Calls 3-param version: 10
    System.out.println(add(5.5, 3.2));       // Calls double version: 8.7
}
```

### Overloading Rules

✅ **Can differ by:**
- Number of parameters
- Type of parameters
- Order of parameter types

❌ **Cannot differ only by:**
- Return type
- Parameter names

```java
// VALID overloads
void print(int x) { }
void print(double x) { }
void print(int x, int y) { }
void print(String s, int x) { }
void print(int x, String s) { }  // Order matters!

// INVALID - can't differ only by return type
int getValue() { return 1; }
double getValue() { return 1.0; }  // ERROR!
```

---

## 5️⃣ Variable Scope

**Scope** determines where a variable can be accessed.

### Local Variables

Variables declared inside a method only exist within that method.

```java
public static void methodA() {
    int x = 10;  // x only exists in methodA
    System.out.println(x);
}

public static void methodB() {
    // System.out.println(x);  // ERROR! x doesn't exist here
    int x = 20;  // This is a DIFFERENT x
    System.out.println(x);
}
```

### Parameter Scope

Parameters are local to the method.

```java
public static void greet(String name) {
    // 'name' only exists inside this method
    System.out.println("Hello, " + name);
}

public static void main(String[] args) {
    greet("Alice");
    // System.out.println(name);  // ERROR! 'name' doesn't exist here
}
```

### Block Scope

Variables declared in a block `{ }` only exist in that block.

```java
public static void main(String[] args) {
    int a = 5;  // Exists in entire main method
    
    if (a > 0) {
        int b = 10;  // Only exists inside this if block
        System.out.println(a + b);  // OK
    }
    
    // System.out.println(b);  // ERROR! b doesn't exist here
}
```

### Static Variables (Class Level)

Variables declared at class level can be accessed by all methods.

```java
public class Example {
    static int counter = 0;  // Class-level variable
    
    public static void increment() {
        counter++;  // Can access counter
    }
    
    public static void printCounter() {
        System.out.println(counter);  // Can access counter
    }
    
    public static void main(String[] args) {
        increment();
        increment();
        printCounter();  // Output: 2
    }
}
```

---

## 6️⃣ Practical Examples

### Example 1: Calculator Methods

```java
public static int add(int a, int b) {
    return a + b;
}

public static int subtract(int a, int b) {
    return a - b;
}

public static int multiply(int a, int b) {
    return a * b;
}

public static double divide(int a, int b) {
    if (b == 0) {
        System.out.println("Error: Cannot divide by zero!");
        return 0;
    }
    return (double) a / b;
}
```

### Example 2: Validation Methods

```java
public static boolean isValidAge(int age) {
    return age >= 0 && age <= 120;
}

public static boolean isValidEmail(String email) {
    return email.contains("@") && email.contains(".");
}

public static boolean isStrongPassword(String password) {
    return password.length() >= 8;
}

// Usage
if (isValidAge(25) && isValidEmail("test@email.com")) {
    System.out.println("Valid input!");
}
```

### Example 3: Formatting Methods

```java
public static String formatName(String firstName, String lastName) {
    return lastName + ", " + firstName;
}

public static String formatCurrency(double amount) {
    return String.format("$%.2f", amount);
}

public static String formatPhone(String phone) {
    // Assumes 10 digit phone number
    return "(" + phone.substring(0, 3) + ") " + 
           phone.substring(3, 6) + "-" + 
           phone.substring(6);
}

// Usage
System.out.println(formatName("John", "Doe"));     // Doe, John
System.out.println(formatCurrency(1234.5));        // $1234.50
System.out.println(formatPhone("1234567890"));     // (123) 456-7890
```

### Example 4: Mathematical Methods

```java
public static long factorial(int n) {
    long result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}

public static boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return false;
    }
    return true;
}

public static int findMax(int a, int b, int c) {
    int max = a;
    if (b > max) max = b;
    if (c > max) max = c;
    return max;
}
```

---

## 🔄 Method Calling Methods

Methods can call other methods!

```java
public static double calculateCircleArea(double radius) {
    return Math.PI * radius * radius;
}

public static double calculateCircleCircumference(double radius) {
    return 2 * Math.PI * radius;
}

public static void printCircleInfo(double radius) {
    System.out.println("Circle with radius: " + radius);
    System.out.println("Area: " + calculateCircleArea(radius));
    System.out.println("Circumference: " + calculateCircleCircumference(radius));
}

public static void main(String[] args) {
    printCircleInfo(5.0);
}
```

Output:
```
Circle with radius: 5.0
Area: 78.53981633974483
Circumference: 31.41592653589793
```

---

## ⚠️ Common Mistakes to Avoid

### 1. Forgetting to Return a Value
```java
// WRONG
public static int add(int a, int b) {
    int sum = a + b;
    // Forgot to return!
}

// CORRECT
public static int add(int a, int b) {
    int sum = a + b;
    return sum;
}
```

### 2. Wrong Return Type
```java
// WRONG
public static int divide(int a, int b) {
    return a / b;  // Integer division! 5/2 = 2
}

// CORRECT (for decimal results)
public static double divide(int a, int b) {
    return (double) a / b;  // 5/2 = 2.5
}
```

### 3. Ignoring Return Values
```java
// The returned value is lost!
add(5, 3);  // Result is discarded

// BETTER - use the result
int result = add(5, 3);
System.out.println(result);
```

### 4. Mismatched Parameters
```java
public static void greet(String name, int times) { ... }

// WRONG - wrong order
greet(3, "Hello");

// CORRECT
greet("Hello", 3);
```

---

## 📝 Best Practices

### 1. Use Descriptive Names
```java
// BAD
public static int calc(int x, int y) { ... }

// GOOD
public static int calculateSum(int number1, int number2) { ... }
```

### 2. One Task Per Method
```java
// BAD - does too much
public static void processUserAndSendEmail(String name, String email) { ... }

// GOOD - separate concerns
public static void processUser(String name) { ... }
public static void sendEmail(String email) { ... }
```

### 3. Keep Methods Short
- A method should fit on one screen
- If it's too long, break it into smaller methods

### 4. Use Comments for Complex Logic
```java
/**
 * Calculates the factorial of a number.
 * @param n the number to calculate factorial for
 * @return the factorial of n
 */
public static long factorial(int n) {
    // ... implementation
}
```

### 5. Handle Edge Cases
```java
public static double divide(int a, int b) {
    if (b == 0) {
        System.out.println("Error: Division by zero!");
        return 0;  // Or throw an exception
    }
    return (double) a / b;
}
```

---

## 📊 Methods vs No Methods Comparison

### Without Methods (Repetitive)
```java
public static void main(String[] args) {
    // Calculate area of circle 1
    double radius1 = 5.0;
    double area1 = 3.14159 * radius1 * radius1;
    System.out.println("Area: " + area1);
    
    // Calculate area of circle 2
    double radius2 = 7.0;
    double area2 = 3.14159 * radius2 * radius2;
    System.out.println("Area: " + area2);
    
    // Calculate area of circle 3
    double radius3 = 3.0;
    double area3 = 3.14159 * radius3 * radius3;
    System.out.println("Area: " + area3);
}
```

### With Methods (Clean & Reusable)
```java
public static double calculateArea(double radius) {
    return Math.PI * radius * radius;
}

public static void main(String[] args) {
    System.out.println("Area: " + calculateArea(5.0));
    System.out.println("Area: " + calculateArea(7.0));
    System.out.println("Area: " + calculateArea(3.0));
}
```

---

## 📝 Key Takeaways

1. **Methods** are reusable blocks of code
2. **`void`** means the method doesn't return anything
3. **Parameters** pass data INTO methods
4. **Return values** pass data OUT of methods
5. **Overloading** = same name, different parameters
6. **Scope** determines where variables can be accessed
7. **Keep methods focused** on one task
8. **Name methods clearly** to describe what they do
9. **Call methods** using `methodName(arguments)`

---

## 🔗 What's Next?

In **Class 3**, you'll learn about **Arrays** - how to store and work with collections of data efficiently!

---

**Keep practicing!** 🔧  
Methods are the building blocks of well-organized code!
