# Class 1: Hello World - Your First Java Program 🚀

Welcome to **Class 1** of the Java Learning Journey! In this class, you'll write and understand your very first Java program. This program will teach you the fundamental structure of every Java application.

---

## 📌 What You'll Learn

- Basic Java program structure
- Class declaration and the `main` method
- How to print output to the console
- Compilation and execution of Java programs

---

## 📋 The Complete Code

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

---

## 🔍 Line-by-Line Explanation

### Line 1: `public class Main {`

Let's break down this line into words:

#### **`public`** (Keyword)
- **Meaning:** Accessibility modifier
- **What it does:** This keyword makes the class accessible from anywhere in your program (and from other programs too)
- **Other options:** You could use `private` (not accessible from outside), `protected` (limited access), or no modifier (default access)
- **Why use it:** For the main class in your program, `public` is required so Java can find and execute it

#### **`class`** (Keyword)
- **Meaning:** Declares a new class
- **What it does:** In Java, everything must be inside a class. A class is a blueprint that defines what an object can do and what data it can hold
- **Think of it as:** A template or cookie cutter that defines the structure
- **Example analogy:** A class is like a blueprint for a house, and objects are the actual houses built from that blueprint

#### **`Main`** (Identifier - Class Name)
- **Meaning:** The name of the class
- **Naming convention:** Class names in Java start with an UPPERCASE letter
- **Important:** The filename must match the class name exactly: `Main.java`
- **Case-sensitive:** `Main`, `main`, and `MAIN` are all different!
- **Why this matters:** When Java runs your program, it looks for a class with a matching filename

#### **`{`** (Opening Curly Brace)
- **Meaning:** Starts the class definition
- **What it does:** Everything between `{` and its matching `}` is part of the class
- **Always pair them:** Every opening `{` must have a closing `}`

---

### Line 2: `public static void main(String[] args) {`

This is the most important line in your Java program. It's the **entry point** where Java starts executing your code.

#### **`public`** (Keyword)
- **Meaning:** Accessibility modifier
- **Why needed here:** The `main` method must be `public` so the Java Runtime Environment (JRE) can access and execute it

#### **`static`** (Keyword)
- **Meaning:** This method belongs to the class itself, not to any specific object/instance
- **Why needed here:** When Java starts, no object of your class exists yet. The `static` keyword allows `main` to run without creating an object first
- **Simple explanation:** You don't need to make a copy/instance of `Main` to run the program; `main` runs directly on the class itself

#### **`void`** (Keyword)
- **Meaning:** Return type - specifies what the method gives back after execution
- **`void` means:** The method doesn't return anything, it just performs actions
- **Other return types:** `int` (returns a number), `String` (returns text), `double` (returns decimal number), etc.
- **In this case:** `main` just runs and doesn't send back a result

#### **`main`** (Method Name)
- **Meaning:** The name of this special method
- **Why this name:** `main` is the conventional name that Java looks for to start your program
- **Must be exactly:** `main` (lowercase) - Java is case-sensitive
- **Reserved name:** You can't use any other name for the entry point of your program

#### **`(String[] args)`** (Method Parameters)
Let's break this down further:

- **`String[]`** (Data type)
  - `String`: Represents text/words
  - `[]`: Square brackets mean it's an ARRAY (a collection of multiple items)
  - `String[]`: An array of text items - can hold multiple strings
  
- **`args`** (Parameter name)
  - Short for "arguments"
  - This is the name we give to the command-line arguments passed to our program
  - **Example:** When you run `java Main hello world`, the words "hello" and "world" are passed as `args`
  - For now, we're not using `args`, but we must include it

- **Why include it:** This is part of the standard `main` method signature. All Java programs must have this exact syntax for the main method

#### **`{`** (Opening Curly Brace)
- **Meaning:** Starts the method body
- **Contains:** All the code that will execute when `main` is called

---

### Line 3: `System.out.println("Hello World");`

This is the line that actually prints output to your screen!

#### **`System`** (Class name)
- **Meaning:** A built-in Java class that represents your computer system
- **Part of:** Java's standard library (comes with Java, you don't need to install it)
- **What it is:** A collection of system-related methods and constants

#### **`.`** (Dot operator)
- **Meaning:** Access operator - connects objects/classes to their properties and methods
- **What it does:** Says "look inside the thing on the left for the thing on the right"
- **Read as:** "dot" or "point to"
- **Example:** `System.out` means "the `out` property of the `System` class"

#### **`out`** (Output stream)
- **Meaning:** Standard output - connected to your console/terminal screen
- **What it represents:** The output destination where text is printed
- **Think of it as:** The printer connected to your computer that writes text to the console

#### **`.`** (Another dot operator)
- **Same as above:** Just accessing the next method within `out`

#### **`println`** (Method name)
- **Meaning:** "print line"
- **What it does:** Prints text to the console AND adds a newline at the end (moves to the next line)
- **Similar method:** `print()` - prints text WITHOUT a newline
- **The difference:** 
  ```
  println("Hello");  // Output: Hello (cursor moves to next line)
  println("World");  // Output: World
  
  print("Hello");    // Output: Hello (cursor stays on same line)
  print("World");    // Output: HelloWorld (no space between)
  ```

#### **`("Hello World")`** (Arguments in parentheses)
- **`()`**: Parentheses indicate we're calling (using) a method
- **`"Hello World"`**: The text we want to print
  - The double quotes `" "` tell Java that this is a string (text)
  - Without quotes, Java would think "Hello World" is a variable name
  - Everything between the quotes is what gets printed: `Hello World`

#### **`;`** (Semicolon)
- **Meaning:** Statement terminator
- **What it does:** Marks the end of a complete statement
- **Rule:** Almost every line of Java code ends with a semicolon
- **If forgotten:** Java will give you an error
- **Exception:** Braces `{ }` don't need semicolons after them

---

### Line 4: `}`

- **Meaning:** Closing curly brace for the `main` method
- **What it does:** Marks the end of the method definition
- **Matches:** The `{` on line 2

---

### Line 5: `}`

- **Meaning:** Closing curly brace for the class
- **What it does:** Marks the end of the class definition
- **Matches:** The `{` on line 1

---

## 🎯 Visual Structure

```
┌─ public class Main {              ← Class starts here
│   ┌─ public static void main() {  ← Method starts here
│   │   System.out.println(...);    ← Method body (code that runs)
│   │ }                             ← Method ends here
│ }                                 ← Class ends here
```

---

## 🛠️ How to Compile and Run

### Step 1: Save the File
Save the code above in a file named **`Main.java`** (must match the class name exactly!)

### Step 2: Compile
Open terminal/command prompt in the directory where you saved the file:
```bash
javac Main.java
```
This creates a file called `Main.class` (compiled bytecode)

### Step 3: Run
```bash
java Main
```

### Step 4: See the Output
```
Hello World
```

---

## 💡 Key Concepts to Remember

| Concept | Explanation |
|---------|-------------|
| **Class** | A blueprint that holds code and data |
| **main() method** | The starting point of every Java program |
| **public** | Makes the class/method accessible from anywhere |
| **static** | Method belongs to the class, not an object |
| **void** | The method doesn't return a value |
| **String[] args** | Can receive command-line arguments |
| **System.out** | The console (where text is printed) |
| **println()** | Print with newline |
| **Semicolon (;)** | Ends a statement |

---

## 🔧 Common Mistakes & Fixes

### ❌ Mistake 1: Wrong filename
```
Error: class Main is public, should be declared in a file named Main.java
```
**Fix:** Save as `Main.java`, not `main.java` or `HelloWorld.java`

### ❌ Mistake 2: Misspelled class name
```
public class Main {  // Class name: Main
    // But try to run with: java main
    // ERROR! Case-sensitive!
}
```
**Fix:** Use exact case: `java Main`

### ❌ Mistake 3: Missing semicolon
```
System.out.println("Hello World")  // Missing ;
```
**Fix:** Add semicolon: `System.out.println("Hello World");`

### ❌ Mistake 4: Wrong method signature
```
public static void main() {  // Missing String[] args
    // ERROR!
}
```
**Fix:** Include exact parameters: `public static void main(String[] args) {`

---

## 🚀 What's Next?

Now that you understand the basic structure, you're ready for:
- **Class 2:** Variables and Data Types
- **Class 3:** Printing multiple lines and basic formatting
- **Class 4:** Taking user input
- **Class 5:** Arithmetic operations

---

## 📚 Further Reading

- [Java Official Documentation](https://docs.oracle.com/javase/tutorial/)
- [Understanding the main method](https://www.baeldung.com/java-main-method)
- [Java Syntax Rules](https://www.w3schools.com/java/java_syntax.asp)

---

## ✅ Self-Check Questions

Try answering these to test your understanding:

1. Why must the filename match the class name?
2. What does the `static` keyword do in the main method?
3. What's the difference between `print()` and `println()`?
4. Why do we need `String[] args` in the main method?
5. What would happen if you removed the `public` keyword?

**Answers:** Check yourself by trying to modify the code and seeing what errors you get!

---

## 🎓 Practice Exercise

Modify the program to:
1. Print your name
2. Print multiple lines (create a small message)
3. Use different text in the println

Example:
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Java!");
        System.out.println("My name is [Your Name]");
        System.out.println("I am learning Java programming!");
    }
}
```

---

**Happy Learning! 🎉**

Feel free to experiment, break things, and ask questions. That's how you learn best!
