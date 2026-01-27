# Class 2: Variables and Data Types 📊

Welcome to **Class 2** of the Java Learning Journey! In this class, you'll learn about **variables** - the containers that store data in your programs - and **data types** - the different kinds of data you can store.

---

## 📌 What You'll Learn

- What are variables and why we need them
- How to declare variables
- How to initialize variables
- The 8 primitive data types in Java
- How to use different data types correctly
- Type naming conventions
- Converting between types

---

## 🎯 Why Variables Matter

Imagine you're writing a program that calculates a student's grade average. You need to:
- **Store** the student's name
- **Store** their test scores
- **Store** their final grade
- **Use** these values in calculations

Without variables, you'd have no way to keep this information! Variables are like labeled containers that hold data.

---

## 📋 The Complete Code Example

```java
public class Variables {
    
    public static void main(String[] args) {
        // Integer variables (whole numbers)
        int age = 19;
        int year = 2026;
        
        // Decimal numbers
        double gpa = 3.75;
        float height = 5.9f;
        
        // Text/characters
        String name = "Raghav";
        char grade = 'A';
        
        // True/False values
        boolean isStudent = true;
        
        // Printing the variables
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
        System.out.println("Grade: " + grade);
        System.out.println("Is Student: " + isStudent);
    }
}
```

**Expected Output:**
```
Name: Raghav
Age: 19
GPA: 3.75
Grade: A
Is Student: true
```

---

## 🔍 Line-by-Line Explanation

### Data Types Overview

Java has **8 primitive data types** and **non-primitive types** like String.

---

## **Primitive Data Types (8 Types)**

### 1️⃣ **int** - Integer Numbers

```java
int age = 19;
```

#### **`int`** (Keyword)
- **Meaning:** Integer type
- **Stores:** Whole numbers (no decimals)
- **Range:** -2,147,483,648 to 2,147,483,647
- **Memory:** 4 bytes
- **When to use:** Age, scores, counts, IDs

#### **`age`** (Variable Name)
- **Meaning:** The name of your variable
- **Naming Convention:** camelCase (first word lowercase, each new word capitalized)
- **Examples of good names:** `userAge`, `studentScore`, `totalPoints`
- **Examples of bad names:** `a`, `int1`, `the_age` (use camelCase, not snake_case)

#### **`=`** (Assignment Operator)
- **Meaning:** Assign the value on the right to the variable on the left
- **Does NOT mean:** "equals" (use `==` to compare)
- **Direction:** Always left = right

#### **`19`** (Value)
- **Meaning:** The actual number you're storing
- **Type:** Must be a whole number for `int`
- **Without quotes:** It's a number, not text

---

### 2️⃣ **double** - Decimal Numbers (High Precision)

```java
double gpa = 3.75;
```

#### **`double`** (Keyword)
- **Meaning:** Double precision floating-point
- **Stores:** Decimal numbers with high precision
- **Range:** -1.7e308 to 1.7e308
- **Memory:** 8 bytes
- **Precision:** About 15 decimal digits
- **When to use:** GPAs, prices, measurements, scientific calculations

#### **`gpa`** (Variable Name)
- Same naming rules as `int`
- Clear, descriptive name

#### **`3.75`** (Decimal Value)
- **Type:** Must include a decimal point
- **Examples:** `3.14`, `99.99`, `0.5`
- **Without decimal point:** Java treats it as `int`, not `double`

**Important note:** For decimal numbers, `double` is preferred over `float` because it has better precision.

---

### 3️⃣ **float** - Decimal Numbers (Lower Precision)

```java
float height = 5.9f;
```

#### **`float`** (Keyword)
- **Meaning:** Single precision floating-point
- **Stores:** Decimal numbers with lower precision than `double`
- **Range:** -3.4e38 to 3.4e38
- **Memory:** 4 bytes (half of `double`)
- **Precision:** About 7 decimal digits
- **When to use:** When memory is critical (rarely used in modern Java)

#### **`5.9f`** (The 'f' Suffix)
- **The `f`:** Required to tell Java this is a `float`, not a `double`
- **Why needed:** Without `f`, Java thinks it's a `double`
- **Examples:** `5.9f`, `3.14f`, `99.99f`
- **Without `f`:** This would cause an ERROR: `float height = 5.9;` ❌

---

### 4️⃣ **long** - Very Large Whole Numbers

```java
long population = 1400000000L;
```

#### **`long`** (Keyword)
- **Meaning:** Long integer
- **Stores:** Whole numbers larger than `int` can hold
- **Range:** -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
- **Memory:** 8 bytes
- **When to use:** Population counts, file sizes, very large IDs

#### **`1400000000L`** (The 'L' Suffix)
- **The `L`:** Required to tell Java this is a `long`, not an `int`
- **Why needed:** Without `L`, numbers get stored as `int`, and large numbers overflow
- **Examples:** `1000000L`, `999999999999L`

---

### 5️⃣ **short** - Small Whole Numbers

```java
short temperature = 25;
```

#### **`short`** (Keyword)
- **Meaning:** Short integer
- **Stores:** Whole numbers smaller range than `int`
- **Range:** -32,768 to 32,767
- **Memory:** 2 bytes (saves memory)
- **When to use:** Rarely used (memory savings not usually needed)

---

### 6️⃣ **byte** - Smallest Whole Numbers

```java
byte pixel = 255;
```

#### **`byte`** (Keyword)
- **Meaning:** Byte integer
- **Stores:** Very small whole numbers
- **Memory:** 1 byte (smallest integer type)
- **When to use:** Image processing, binary data, when memory is extremely critical

---

### 7️⃣ **char** - Single Character

```java
char grade = 'A';
```

#### **`char`** (Keyword)
- **Meaning:** Character
- **Stores:** Single character (letter, digit, symbol)
- **Range:** 0 to 65535 (Unicode characters)
- **Memory:** 2 bytes
- **When to use:** Individual letters, digits, symbols

#### **`'A'`** (Single Quotes)
- **Single quotes required:** `'A'` not `"A"`
- **Only one character:** `'A'` ✓ but `'AB'` ❌
- **Numbers as characters:** `char digit = '5';` (the character five, not the number)
- **Special characters:** `'\n'` (newline), `'\t'` (tab)

---

### 8️⃣ **boolean** - True or False

```java
boolean isStudent = true;
```

#### **`boolean`** (Keyword)
- **Meaning:** Boolean (logical) type
- **Stores:** Only two values: `true` or `false`
- **Memory:** 1 byte
- **When to use:** Yes/No questions, conditions, flags

#### **`true`** (The Value)
- **Only values:** `true` or `false` (lowercase!)
- **NOT valid:** `True`, `TRUE`, `1`, `0`
- **Naming convention:** Use `is`, `has`, `can` prefix
  - ✓ `isStudent`, `hasPermission`, `canVote`
  - ✗ `student`, `permission`, `vote`

---

## **Non-Primitive Data Types (Not Primitive)**

### **String** - Text/Words

```java
String name = "Raghav";
```

#### **`String`** (Class Name)
- **Meaning:** Text/sequence of characters
- **Stores:** Any amount of text
- **Memory:** Variable (depends on text length)
- **When to use:** Names, messages, any text data

#### **`"Raghav"`** (Double Quotes)
- **Double quotes required:** `"text"` not `'text'`
- **Multiple characters:** As many as you want
- **Empty string:** `""` (valid)
- **Special characters:** Can include letters, numbers, symbols

---

## 📊 All Primitive Data Types at a Glance

| Type | Size | Range | Example | Use Case |
|------|------|-------|---------|----------|
| **byte** | 1 byte | -128 to 127 | `byte b = 10;` | Image pixels |
| **short** | 2 bytes | -32,768 to 32,767 | `short s = 100;` | Rare usage |
| **int** | 4 bytes | -2.1B to 2.1B | `int age = 25;` | Numbers, counts |
| **long** | 8 bytes | -9.2e18 to 9.2e18 | `long pop = 1000L;` | Large numbers |
| **float** | 4 bytes | ±3.4e38 | `float f = 3.14f;` | Memory-critical |
| **double** | 8 bytes | ±1.7e308 | `double d = 3.14;` | Decimals (preferred) |
| **char** | 2 bytes | 0 to 65535 | `char c = 'A';` | Single character |
| **boolean** | 1 byte | true/false | `boolean b = true;` | Yes/No, conditions |

---

## 🔑 Key Concepts About Variables

### **Declaration vs Initialization**

```java
// Declaration (create variable, no value yet)
int score;

// Initialization (assign first value)
score = 95;

// Declaration + Initialization (both at once) - PREFERRED
int score = 95;
```

**Best Practice:** Always initialize when you declare!

---

### **Variable Naming Convention (camelCase)**

```java
// ✓ CORRECT - camelCase
int studentAge = 19;
double grossDomesticProduct = 3.5;
boolean isWeekend = true;

// ✗ WRONG
int Student_Age = 19;  // snake_case (Python style)
int STUDENTAGE = 19;   // ALL_CAPS (constant style)
int studentage = 19;   // No separation
```

**Rule:** Start lowercase, capitalize each new word, join without spaces

---

### **Multiple Variables in One Line**

```java
// Declare multiple variables of same type
int x = 5, y = 10, z = 15;

// NOT the same type (causes error)
int a = 5; double b = 10.5;  // ✗ Use separate lines
```

---

## 💻 How to Run This Program

### Step 1: Create File
Save this as `Variables.java`

### Step 2: Compile
```bash
javac Variables.java
```

### Step 3: Run
```bash
java Variables
```

### Step 4: See Output
```
Name: Raghav
Age: 19
GPA: 3.75
Grade: A
Is Student: true
```

---

## 🔄 String Concatenation (Combining Strings)

```java
String firstName = "Raghav";
String lastName = "Sharma";

// Method 1: Use + operator
System.out.println("Full name: " + firstName + " " + lastName);

// Method 2: Multiple lines
System.out.println("First: " + firstName);
System.out.println("Last: " + lastName);

// Output:
// Full name: Raghav Sharma
// First: Raghav
// Last: Sharma
```

**How it works:** The `+` operator connects strings together

---

## ⚠️ Common Mistakes

### ❌ Mistake 1: Forgetting Quotes on Strings
```java
String name = Raghav;  // ERROR! Missing quotes
String name = "Raghav";  // ✓ CORRECT
```

### ❌ Mistake 2: Wrong Quotes for Characters
```java
char grade = "A";  // ERROR! Double quotes
char grade = 'A';  // ✓ CORRECT
```

### ❌ Mistake 3: Forgetting Suffixes
```java
float price = 9.99;  // ERROR! Missing 'f'
float price = 9.99f;  // ✓ CORRECT

long population = 1000000000;  // ERROR! Missing 'L'
long population = 1000000000L;  // ✓ CORRECT
```

### ❌ Mistake 4: Using Variables Before Initializing
```java
int score;
System.out.println(score);  // ERROR! Not initialized

int score = 0;
System.out.println(score);  // ✓ CORRECT
```

### ❌ Mistake 5: Wrong Data Type
```java
int age = 19.5;  // ERROR! 19.5 is not an integer
int age = 19;  // ✓ CORRECT

double height = 5;  // Allowed (Java converts 5 to 5.0)
double height = 5.9;  // ✓ CORRECT
```

---

## 📚 Practice Examples

### Example 1: Student Information
```java
String name = "Alice";
int age = 20;
double gpa = 3.85;
char grade = 'A';
boolean isEnrolled = true;

System.out.println("Student: " + name);
System.out.println("Age: " + age);
System.out.println("GPA: " + gpa);
System.out.println("Current Grade: " + grade);
System.out.println("Enrolled: " + isEnrolled);
```

### Example 2: Product Information
```java
String productName = "Laptop";
double price = 999.99;
int quantity = 5;
boolean inStock = true;

System.out.println("Product: " + productName);
System.out.println("Price: $" + price);
System.out.println("In Stock: " + inStock);
System.out.println("Quantity Available: " + quantity);
```

### Example 3: Personal Details
```java
String city = "Amaravati";
String state = "Andhra Pradesh";
String country = "India";
int zipCode = 522001;

System.out.println("Location: " + city + ", " + state);
System.out.println("Country: " + country);
System.out.println("ZIP: " + zipCode);
```

---

## 🎓 Self-Check Questions

Try to answer these without looking back:

1. What's the difference between `int` and `long`?
2. Why do you need to use `f` after a `float` number?
3. What characters must you use for `String` vs `char`?
4. Name all 8 primitive data types
5. What is camelCase naming convention?
6. Can you declare multiple variables of different types in one line?
7. What are the only two valid values for `boolean`?
8. Which type is best for storing decimal numbers - `float` or `double`?

---

## 🔀 Type Conversion (Changing Types)

### Automatic Conversion (Implicit)
```java
int age = 19;
double ageAsDouble = age;  // Automatically converts to 19.0
System.out.println(ageAsDouble);  // Output: 19.0
```

### Manual Conversion (Explicit/Casting)
```java
double price = 99.99;
int priceAsInt = (int) price;  // Manual conversion
System.out.println(priceAsInt);  // Output: 99 (decimals removed!)
```

**Important:** Converting `double` to `int` loses decimal places!

---

## 📖 Key Takeaways

✅ **Variables** store data in labeled containers
✅ **Declaration** creates a variable with a type and name
✅ **Initialization** assigns the first value
✅ **8 Primitive types** exist: byte, short, int, long, float, double, char, boolean
✅ **String** is a non-primitive type for text
✅ **camelCase** is the naming convention for variables
✅ **Quotes matter:** `"string"` for String, `'char'` for char
✅ **Suffixes matter:** `f` for float, `L` for long
✅ Use descriptive names that explain what the variable stores

---

## 💡 Best Practices

1. **Always initialize variables** when you declare them
2. **Use descriptive names** that explain what the variable holds
3. **Use the right data type** for the job (don't use `double` for IDs)
4. **Follow camelCase** naming convention
5. **Group related variables** together
6. **Add comments** for complex or non-obvious variables

---

## 🚀 What's Next?

Now that you understand variables and data types, you're ready for:
- **Class 3:** Operators (doing math and logic with variables)
- **Class 4:** Input/Output (getting data from users)
- **Class 5:** Comments and Documentation

---

## 📚 Further Reading

- [Oracle Java Variables Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html)
- [Java Data Types](https://www.w3schools.com/java/java_data_types.asp)
- [Java Naming Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-136091.html)

---

**Happy Learning! 🎉**

You now understand how to store and work with data in Java. The exercises will help you practice creating variables and using different data types!
