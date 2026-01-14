# Class 5: Conditional Statements (if/else/switch) 🎯

Welcome to **Class 5**! In this class, you'll learn how to make your programs **make decisions** using conditional statements. Your programs can now respond differently based on different inputs!

---

## 📌 What You'll Learn

- The `if` statement (single decision)
- The `if-else` statement (two paths)
- The `else if` statement (multiple paths)
- Nested `if` statements (decisions within decisions)
- The `switch` statement (exact value matching)
- The ternary operator (shorthand `if-else`)
- Best practices and common mistakes

---

## 🎯 Why Conditional Statements Matter

Without conditionals, your programs run the same way every time. With them:
- **Make decisions** based on user input
- **Validate** user data
- **Change behavior** based on conditions
- **Build interactive** programs
- **Create logic** that responds to situations

---

## 📋 The Complete Code Example

```java
/**
 * Class 5: Conditional Statements
 *
 * Demonstrates:
 * - if statement
 * - if-else statement
 * - else if statement
 * - nested if
 * - switch statement
 * - ternary operator
 *
 * How to run:
 * 1. Save as: ConditionalStatements.java
 * 2. Compile: javac ConditionalStatements.java
 * 3. Run:    java ConditionalStatements
 */

import java.util.Scanner;

public class ConditionalStatements {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ================================================
        // IF STATEMENT (one path)
        // ================================================
        System.out.println("========== IF STATEMENT ==========");
        System.out.print("Enter your age: ");
        int age = input.nextInt();

        if (age >= 18) {
            System.out.println("You are an adult.");
        }
        // If the condition is false, nothing happens


        // ================================================
        // IF-ELSE STATEMENT (two paths)
        // ================================================
        System.out.println("\n========== IF-ELSE STATEMENT ==========");
        
        if (age >= 18) {
            System.out.println("You are an adult. You can vote!");
        } else {
            System.out.println("You are a minor. You cannot vote yet.");
        }


        // ================================================
        // ELSE IF STATEMENT (multiple paths)
        // ================================================
        System.out.println("\n========== ELSE IF STATEMENT ==========");
        System.out.print("Enter your exam score (0-100): ");
        int score = input.nextInt();

        if (score >= 90) {
            System.out.println("Grade: A (Excellent!)");
        } else if (score >= 80) {
            System.out.println("Grade: B (Very Good)");
        } else if (score >= 70) {
            System.out.println("Grade: C (Good)");
        } else if (score >= 60) {
            System.out.println("Grade: D (Pass)");
        } else {
            System.out.println("Grade: F (Fail)");
        }


        // ================================================
        // NESTED IF (decisions within decisions)
        // ================================================
        System.out.println("\n========== NESTED IF STATEMENT ==========");
        System.out.print("Enter your score: ");
        int examScore = input.nextInt();

        if (examScore >= 60) {
            System.out.println("You passed!");

            // Nested if inside the outer if
            if (examScore >= 80) {
                System.out.println("Outstanding performance!");
            } else {
                System.out.println("Good job, but you can do better.");
            }
        } else {
            System.out.println("You failed. Try again next time.");
        }


        // ================================================
        // SWITCH STATEMENT (exact value matching)
        // ================================================
        System.out.println("\n========== SWITCH STATEMENT ==========");
        input.nextLine();  // Clear newline
        
        System.out.print("Enter day number (1-7): ");
        int day = input.nextInt();

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day number!");
        }


        // ================================================
        // SWITCH WITH FALL-THROUGH (intentional)
        // ================================================
        System.out.println("\n========== SWITCH WITH FALL-THROUGH ==========");
        System.out.print("Enter month number (1-12): ");
        int month = input.nextInt();

        int days;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = 28;
                break;
            default:
                days = -1;
        }
        
        if (days != -1) {
            System.out.println("Month " + month + " has " + days + " days.");
        } else {
            System.out.println("Invalid month!");
        }


        // ================================================
        // LOGICAL OPERATORS WITH IF
        // ================================================
        System.out.println("\n========== LOGICAL OPERATORS ==========");
        System.out.print("Enter your age: ");
        int userAge = input.nextInt();
        
        System.out.print("Do you have a license? (true/false): ");
        boolean hasLicense = input.nextBoolean();

        if (userAge >= 18 && hasLicense) {
            System.out.println("You can drive!");
        } else if (userAge >= 18 && !hasLicense) {
            System.out.println("You're old enough but need a license.");
        } else {
            System.out.println("You're too young to drive.");
        }


        // ================================================
        // TERNARY OPERATOR (shorthand if-else)
        // ================================================
        System.out.println("\n========== TERNARY OPERATOR ==========");
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Traditional if-else:
        String result1;
        if (number % 2 == 0) {
            result1 = "Even";
        } else {
            result1 = "Odd";
        }
        System.out.println("Using if-else: " + result1);

        // Using ternary operator (same logic, one line):
        String result2 = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println("Using ternary: " + result2);


        // ================================================
        // NESTED TERNARY (multiple conditions)
        // ================================================
        System.out.println("\n========== NESTED TERNARY ==========");
        System.out.print("Enter your marks: ");
        int marks = input.nextInt();

        String grade = (marks >= 90) ? "A" : 
                       (marks >= 80) ? "B" : 
                       (marks >= 70) ? "C" : 
                       (marks >= 60) ? "D" : "F";
        
        System.out.println("Grade: " + grade);


        input.close();
    }
}
```

---

## 🔍 Line-by-Line Explanation

### **IF Statement**

```java
if (condition) {
    // Code runs ONLY if condition is true
}
```

**Example:**
```java
if (age >= 18) {
    System.out.println("You are an adult.");
}
```

- **Meaning:** If age is 18 or greater, print the message
- **If false:** Nothing happens (no else statement)

---

### **IF-ELSE Statement**

```java
if (condition) {
    // Code runs if condition is TRUE
} else {
    // Code runs if condition is FALSE
}
```

**Example:**
```java
if (age >= 18) {
    System.out.println("You can vote!");
} else {
    System.out.println("You cannot vote yet.");
}
```

- **Two paths:** One for true, one for false
- **Exactly one** block executes

---

### **ELSE IF Statement (Multiple Paths)**

```java
if (condition1) {
    // Runs if condition1 is TRUE
} else if (condition2) {
    // Runs if condition1 is FALSE and condition2 is TRUE
} else if (condition3) {
    // Runs if condition1 and condition2 are FALSE and condition3 is TRUE
} else {
    // Runs if all conditions are FALSE
}
```

**Example:**
```java
if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 80) {
    System.out.println("Grade: B");
} else if (score >= 70) {
    System.out.println("Grade: C");
} else {
    System.out.println("Grade: F");
}
```

- **Key:** Only ONE block executes (the first true condition)
- **Best for:** Ranges and multiple options

---

### **Nested IF (If Inside If)**

```java
if (condition1) {
    // Outer if block
    
    if (condition2) {
        // Inner if block
        // Runs only if BOTH conditions are true
    }
}
```

**Example:**
```java
if (age >= 18) {  // First check
    System.out.println("You're an adult");
    
    if (hasJob) {  // Second check (nested)
        System.out.println("And you have a job!");
    }
}
```

**Visual:**
```
If age >= 18:
    Print "Adult"
    If hasJob:
        Print "And employed"
    Else:
        Print "Not employed"
```

**⚠️ Avoid deep nesting:** It becomes hard to read!

---

### **SWITCH Statement (Exact Value Matching)**

```java
switch (expression) {
    case value1:
        // Runs if expression == value1
        break;  // CRITICAL: Exit the switch
    
    case value2:
        // Runs if expression == value2
        break;
    
    default:
        // Runs if no cases match
}
```

**Example:**
```java
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Unknown day");
}
```

- **Best for:** Fixed set of exact values
- **CRITICAL:** Always use `break` to exit!
- **Without break:** Code "falls through" to next case

**Fall-through example (intentional):**
```java
switch (month) {
    case 1: case 3: case 5: case 7:  // Multiple cases, same action
        System.out.println("31 days");
        break;
    case 4: case 6:
        System.out.println("30 days");
        break;
}
```

---

### **Ternary Operator (Shorthand If-Else)**

```java
condition ? valueIfTrue : valueIfFalse;
```

**Example:**
```java
// Traditional if-else:
String status;
if (age >= 18) {
    status = "Adult";
} else {
    status = "Minor";
}

// Same logic with ternary:
String status = (age >= 18) ? "Adult" : "Minor";
```

**Syntax breakdown:**
```
(condition) ? trueValue : falseValue
```

**Best for:**
- Simple assignments
- Assigning values based on a condition
- Quick yes/no decisions

**⚠️ Avoid nested ternary:** It becomes unreadable!

**Nested ternary (use sparingly):**
```java
String grade = (score >= 90) ? "A" : 
               (score >= 80) ? "B" : 
               (score >= 70) ? "C" : "F";
```

---

## ⚠️ Common Mistakes

### ❌ Mistake 1: Semicolon after if condition
```java
if (age >= 18);  // ❌ WRONG! Semicolon ends the statement
{
    System.out.println("Adult");  // This always runs!
}

if (age >= 18)   // ✓ CORRECT
{
    System.out.println("Adult");
}
```

### ❌ Mistake 2: Using `=` instead of `==`
```java
if (age = 18) { }   // ❌ ASSIGNS 18, doesn't compare
if (age == 18) { }  // ✓ CORRECT, compares
```

### ❌ Mistake 3: Forgetting `break` in switch
```java
switch (day) {
    case 1:
        System.out.println("Monday");
        // ❌ WRONG! Falls through to next case
    case 2:
        System.out.println("Tuesday");
}
// Output for day=1: "Monday" AND "Tuesday"!

switch (day) {
    case 1:
        System.out.println("Monday");
        break;  // ✓ CORRECT
    case 2:
        System.out.println("Tuesday");
        break;
}
// Output for day=1: Only "Monday"
```

### ❌ Mistake 4: Missing braces with multiple statements
```java
if (age >= 18)
    System.out.println("Adult");
    System.out.println("Can vote");  // ❌ Always runs, not part of if!

if (age >= 18) {
    System.out.println("Adult");
    System.out.println("Can vote");  // ✓ CORRECT
}
```

---

## 📊 If-Else vs Switch Comparison

| Aspect | If-Else | Switch |
|--------|---------|--------|
| **Best for** | Ranges, complex conditions | Exact values |
| **Example** | `age > 18 && hasLicense` | `day == 1` |
| **Performance** | Slower with many conditions | Faster with many cases |
| **Readability** | Few conditions: clearer | Many cases: clearer |
| **Data types** | Any | int, char, String, enum |
| **Conditions** | Any boolean expression | Exact equality only |

---

## 💻 Real-World Examples

### Example 1: Grade Calculator
```java
System.out.print("Enter score: ");
int score = input.nextInt();

if (score >= 90) {
    System.out.println("A - Excellent");
} else if (score >= 80) {
    System.out.println("B - Good");
} else if (score >= 70) {
    System.out.println("C - Satisfactory");
} else if (score >= 60) {
    System.out.println("D - Pass");
} else {
    System.out.println("F - Fail");
}
```

### Example 2: Weather Decision
```java
System.out.print("Is it raining? (true/false): ");
boolean isRaining = input.nextBoolean();

if (isRaining) {
    System.out.println("Take an umbrella");
} else {
    System.out.println("No umbrella needed");
}
```

### Example 3: Login System
```java
System.out.print("Enter username: ");
String username = input.nextLine();

System.out.print("Enter password: ");
String password = input.nextLine();

if (username.equals("admin") && password.equals("1234")) {
    System.out.println("Login successful!");
} else {
    System.out.println("Invalid credentials");
}
```

---

## 🎓 Self-Check Questions

1. What's the difference between `if` and `if-else`?
2. When would you use `else if` instead of multiple `if` statements?
3. Why is `break` important in switch statements?
4. What does the ternary operator do?
5. When should you use switch instead of if-else?
6. What's the difference between `=` and `==`?

---

## 🔑 Key Takeaways

✅ **If** = One path (runs or doesn't run)
✅ **If-else** = Two paths (one always runs)
✅ **Else if** = Multiple paths (check each in order)
✅ **Nested if** = Decisions within decisions
✅ **Switch** = Match exact values
✅ **Ternary** = One-line if-else for simple cases
✅ **Always use braces** for clarity
✅ **Always use break** in switch
✅ **Always use ==** for comparison

---

## 🚀 What's Next?

Now that you can make decisions, you're ready for:
- **Class 6:** Loops (repeating with `for`, `while`, `do-while`)
- **Class 7:** Methods (organizing code into reusable functions)
- **Class 8:** Arrays (storing multiple values)

---

## 📖 Further Reading

- [Oracle If-Then-Else Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html)
- [Oracle Switch Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html)
- [Java Ternary Operator](https://www.programiz.com/java-programming/ternary-operator)

---

**Awesome!** 🎉 You can now build programs that respond intelligently to different situations. This is the foundation of all real software!
