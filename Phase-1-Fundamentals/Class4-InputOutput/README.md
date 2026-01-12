# Class 4: Input/Output (Scanner) 📥📤

Welcome to **Class 4**! In this class, you'll learn how to get **user input** from the keyboard using Java's **Scanner** class. This is the bridge between your programs and the outside world!

---

## 📌 What You'll Learn

- Importing the Scanner class
- Creating a Scanner object
- Reading different data types from user input
- Methods: `nextInt()`, `nextDouble()`, `next()`, `nextLine()`
- The **critical newline issue** and how to fix it
- Input validation with `hasNext()` methods
- Closing resources properly
- Building interactive programs

---

## 🎯 Why Scanner Matters

Without input methods, your programs would only work with hardcoded values. Scanner lets you:
- **Ask users** for data
- **Build interactive** programs
- **Create dynamic** experiences
- **Get real-world** data from users

---

## 📋 The Complete Code Example

```java
/**
 * Class 4: Input/Output (Scanner)
 *
 * Demonstrates reading different types of user input:
 * - Strings (words and lines)
 * - Integers
 * - Floating-point numbers
 * - Booleans
 * - Input validation
 *
 * How to run:
 * 1. Save as: InputOutput.java
 * 2. Compile: javac InputOutput.java
 * 3. Run:    java InputOutput
 */

import java.util.Scanner;

public class InputOutput {

    public static void main(String[] args) {

        // Create a Scanner object to read from keyboard (System.in)
        Scanner input = new Scanner(System.in);

        // ================================================
        // BASIC STRING INPUT (next())
        // ================================================
        System.out.println("========== READING A SINGLE WORD ==========");
        System.out.print("Enter your first name (one word): ");
        String firstName = input.next();  // Reads until whitespace
        System.out.println("Hello, " + firstName + "!");


        // ================================================
        // IMPORTANT: Consume the newline after next()
        // ================================================
        // next() doesn't consume the newline, so we clear it
        input.nextLine();  // "Clearing" the buffer


        // ================================================
        // FULL LINE INPUT (nextLine())
        // ================================================
        System.out.println("\n========== READING A FULL LINE ==========");
        System.out.print("Enter your full address: ");
        String address = input.nextLine();  // Reads entire line including spaces
        System.out.println("You live at: " + address);


        // ================================================
        // INTEGER INPUT (nextInt())
        // ================================================
        System.out.println("\n========== READING AN INTEGER ==========");
        System.out.print("Enter your age: ");
        int age = input.nextInt();  // Reads integer only
        System.out.println("You are " + age + " years old.");


        // ================================================
        // Clear newline after nextInt()
        // ================================================
        input.nextLine();  // CRITICAL: Consume the leftover newline


        // ================================================
        // STRING AFTER NUMBER (requires clearing)
        // ================================================
        System.out.println("\n========== READING STRING AFTER NUMBER ==========");
        System.out.print("Enter your city: ");
        String city = input.nextLine();
        System.out.println("You are from: " + city);


        // ================================================
        // FLOATING-POINT INPUT (nextDouble())
        // ================================================
        System.out.println("\n========== READING A DECIMAL NUMBER ==========");
        System.out.print("Enter your height (in meters): ");
        double height = input.nextDouble();
        System.out.println("Your height: " + height + " meters");


        // ================================================
        // Clear newline after nextDouble()
        // ================================================
        input.nextLine();  // Clear the buffer again


        // ================================================
        // BOOLEAN INPUT (nextBoolean())
        // ================================================
        System.out.println("\n========== READING A BOOLEAN ==========");
        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = input.nextBoolean();
        System.out.println("Student status: " + isStudent);


        // ================================================
        // INPUT VALIDATION (hasNextInt())
        // ================================================
        System.out.println("\n========== INPUT VALIDATION ==========");
        System.out.print("Enter a number (with validation): ");
        
        if (input.hasNextInt()) {
            int number = input.nextInt();
            System.out.println("Valid number received: " + number);
        } else {
            System.out.println("Invalid input! Expected an integer.");
            input.nextLine();  // Clear invalid input
        }


        // ================================================
        // MULTI-STEP INPUT EXAMPLE
        // ================================================
        System.out.println("\n========== COMPLETE PROFILE FORM ==========");
        input.nextLine();  // Clear remaining buffer
        
        System.out.print("Enter your username: ");
        String username = input.nextLine();

        System.out.print("Enter your score: ");
        int score = input.nextInt();
        input.nextLine();  // Clear newline

        System.out.print("Enter your email: ");
        String email = input.nextLine();

        System.out.println("\n--- Profile Summary ---");
        System.out.println("Username: " + username);
        System.out.println("Score: " + score);
        System.out.println("Email: " + email);


        // ================================================
        // CLOSING THE SCANNER (Important!)
        // ================================================
        // Always close Scanner when done to free resources
        input.close();
        System.out.println("\nScanner closed. Program ended.");
    }
}
```

**Expected Runtime Interaction:**
```
========== READING A SINGLE WORD ==========
Enter your first name (one word): John
Hello, John!

========== READING A FULL LINE ==========
Enter your full address: 123 Main Street, Amaravati, AP
You live at: 123 Main Street, Amaravati, AP

========== READING AN INTEGER ==========
Enter your age: 19
You are 19 years old.

========== READING STRING AFTER NUMBER ==========
Enter your city: Amaravati
You are from: Amaravati

========== READING A DECIMAL NUMBER ==========
Enter your height (in meters): 1.75
Your height: 1.75 meters

========== READING A BOOLEAN ==========
Are you a student? (true/false): true
Student status: true

========== INPUT VALIDATION ==========
Enter a number (with validation): 42
Valid number received: 42

========== COMPLETE PROFILE FORM ==========
Enter your username: rajesh_dev
Enter your score: 95
Enter your email: rajesh@vit.ac.in

--- Profile Summary ---
Username: rajesh_dev
Score: 95
Email: rajesh@vit.ac.in

Scanner closed. Program ended.
```

---

## 🔍 Line-by-Line Explanation

### **Importing Scanner**

```java
import java.util.Scanner;
```

- **Meaning:** Tells Java to include the Scanner class from the `java.util` package
- **Must be** at the very top of your file
- **Without it:** You'll get a compilation error

### **Creating a Scanner Object**

```java
Scanner input = new Scanner(System.in);
```

- **`Scanner input`** = Variable name (you can call it anything)
- **`new Scanner(System.in)`** = Create a new Scanner connected to keyboard input
- **`System.in`** = Standard input stream (the keyboard)
- **Think of it as:** Opening a "listening channel" to the keyboard

### **Reading a Single Word (`next()`)**

```java
String firstName = input.next();
```

- **What it does:** Reads the next word (token) from input
- **Stops at:** First whitespace (space, tab, newline)
- **Returns:** A String
- **Example input:** `John` (just one word)
- **Does NOT consume:** The newline character after input

**Visual:**
```
User types: John Smith
            ↓
next() reads: "John"
Leftover in buffer: " Smith\n"
```

### **Reading an Entire Line (`nextLine()`)**

```java
String address = input.nextLine();
```

- **What it does:** Reads the entire line, including spaces
- **Stops at:** Newline character (`\n`)
- **Returns:** A String with everything on that line
- **Example input:** `123 Main Street, New York`
- **DOES consume:** The newline character

**Visual:**
```
User types: 123 Main Street, New York
            ↓
nextLine() reads: "123 Main Street, New York"
Buffer cleared: (empty)
```

### **Reading an Integer (`nextInt()`)**

```java
int age = input.nextInt();
```

- **What it does:** Reads the next integer
- **Converts:** Text to int automatically
- **Example input:** `19`
- **Returns:** An int value
- **Does NOT consume:** The newline character

**Visual:**
```
User types: 19
            ↓
nextInt() reads: 19 (as integer)
Leftover in buffer: "\n"
```

### **Reading a Decimal (`nextDouble()`)**

```java
double height = input.nextDouble();
```

- **What it does:** Reads the next decimal number
- **Converts:** Text to double automatically
- **Example input:** `1.75`
- **Returns:** A double value
- **Does NOT consume:** The newline character

### **Reading a Boolean (`nextBoolean()`)**

```java
boolean isStudent = input.nextBoolean();
```

- **What it does:** Reads `true` or `false`
- **Example input:** `true` or `false`
- **Returns:** A boolean value
- **Case-insensitive:** Works with `TRUE`, `True`, `true`

---

## ⚠️ THE CRITICAL NEWLINE ISSUE

This is the **#1 mistake** beginners make with Scanner!

### **The Problem**

```java
Scanner input = new Scanner(System.in);

System.out.print("Age: ");
int age = input.nextInt();  // User enters "19" and presses Enter

System.out.print("Name: ");
String name = input.nextLine();  // ⚠️ GETS SKIPPED! Reads empty line
```

**Why?** `nextInt()` reads `19` but leaves the newline (`\n`) in the buffer. When `nextLine()` runs, it sees that newline and thinks the line is empty!

**Output:**
```
Age: 19
Name: 
(Name field is empty - input skipped!)
```

### **The Solution: Clear the Newline**

```java
Scanner input = new Scanner(System.in);

System.out.print("Age: ");
int age = input.nextInt();
input.nextLine();  // ← ADD THIS LINE to consume the newline

System.out.print("Name: ");
String name = input.nextLine();  // Now it works correctly!
```

**Output:**
```
Age: 19
Name: John
(Works perfectly!)
```

### **Rule of Thumb**

**After EVERY `nextInt()`, `nextDouble()`, `nextBoolean()`, or `next()`, if you're going to use `nextLine()` afterwards, call `input.nextLine()` to clear the buffer.**

---

## 🛡️ Input Validation with `hasNext()` Methods

Always validate before reading!

### **`hasNextInt()`**

```java
System.out.print("Enter age: ");

if (input.hasNextInt()) {
    int age = input.nextInt();
    System.out.println("Age: " + age);
} else {
    System.out.println("Invalid! Please enter a number.");
    input.nextLine();  // Clear invalid input
}
```

- **Meaning:** Check if next input is an integer
- **Returns:** `true` if valid int, `false` otherwise
- **Use case:** Prevent crashes from bad input

### **`hasNextDouble()`**

```java
if (input.hasNextDouble()) {
    double price = input.nextDouble();
}
```

### **`hasNextLine()`**

```java
if (input.hasNextLine()) {
    String line = input.nextLine();
}
```

---

## 📊 Scanner Methods at a Glance

| Method | Input Type | Stops At | Example |
|--------|-----------|----------|---------|
| `next()` | Single word | Whitespace | "John" |
| `nextLine()` | Full line | Newline | "John Doe" |
| `nextInt()` | Integer | Whitespace | 19 |
| `nextDouble()` | Decimal | Whitespace | 3.14 |
| `nextFloat()` | Float | Whitespace | 2.5f |
| `nextBoolean()` | Boolean | Whitespace | true |
| `nextLong()` | Long integer | Whitespace | 1000000000L |

| Validation Method | Checks For |
|-------------------|-----------|
| `hasNextInt()` | Valid integer |
| `hasNextDouble()` | Valid decimal |
| `hasNextBoolean()` | Valid boolean |
| `hasNextLine()` | Another line exists |

---

## 💻 Complete Real-World Example

```java
import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== User Registration Form ===\n");

        System.out.print("Full Name: ");
        String name = input.nextLine();

        System.out.print("Age: ");
        int age = input.nextInt();
        input.nextLine();  // Clear newline

        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("GPA (0.0 - 4.0): ");
        double gpa = input.nextDouble();

        System.out.println("\n=== Registration Summary ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("GPA: " + gpa);

        input.close();
    }
}
```

---

## ✅ Best Practices

1. **Always close Scanner**
   ```java
   input.close();  // Free resources at the end
   ```

2. **Clear newline after nextInt/nextDouble**
   ```java
   int num = input.nextInt();
   input.nextLine();  // Don't forget!
   ```

3. **Validate input before reading**
   ```java
   if (input.hasNextInt()) {
       int num = input.nextInt();
   }
   ```

4. **Use descriptive prompts**
   ```java
   System.out.print("Enter your age (18 or older): ");  // ✓ Clear
   System.out.print("Age: ");  // Too vague
   ```

5. **Don't leave Scanner open**
   ```java
   input.close();  // Always do this before program ends
   ```

---

## 🎓 Self-Check Questions

1. What's the difference between `next()` and `nextLine()`?
2. Why is `input.nextLine()` called after `nextInt()`?
3. What does `hasNextInt()` do?
4. How do you read a decimal number?
5. What happens if you enter "hello" when the program expects an integer?
6. Why is it important to close the Scanner?

---

## 🔑 Key Takeaways

✅ **Scanner** connects your program to keyboard input
✅ **`next()`** reads single words
✅ **`nextLine()`** reads entire lines with spaces
✅ **`nextInt()`, `nextDouble()`** read numbers
✅ **Always clear the newline** after reading numbers
✅ **Validate input** with `hasNext()` methods
✅ **Close Scanner** when done

---

## 🚀 What's Next?

Now that you can get user input, you're ready for:
- **Class 5:** If/Else Statements (making decisions based on input!)
- **Class 6:** Loops (repeating actions)
- **Class 7:** Methods (organizing code)

---

## 📖 Further Reading

- [Oracle Scanner Documentation](https://docs.oracle.com/javase/tutorial/i18n/resbundle/propfile.html)
- [Scanner Best Practices](https://www.programiz.com/java-programming/scanner)
- [Input Validation Patterns](https://www.geeksforgeeks.org/java-user-input-scanner-class/)

---

**Amazing work!** 🎉 You now know how to create interactive programs that respond to user input. This is a huge milestone in your Java journey!
