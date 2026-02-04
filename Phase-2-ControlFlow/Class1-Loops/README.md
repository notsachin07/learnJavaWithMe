# Class 1: Loops - Repeating Actions 🔁

Welcome to **Phase 2, Class 1**! In this class, you'll learn how to make your programs **repeat actions** using loops. Instead of writing the same code multiple times, loops let you execute code as many times as needed!

---

## 📌 What You'll Learn

- The `for` loop (fixed iterations)
- The `while` loop (condition-based iteration)
- The `do-while` loop (run-then-check)
- Loop control: `break` and `continue`
- Nested loops
- Building tables and patterns
- Common loop patterns and best practices

---

## 🎯 Why Loops Matter

Without loops, if you want to print "Hello" 100 times, you'd need 100 `println` statements! With loops:
- **Repeat actions** any number of times
- **Process data** item by item
- **Build patterns** and tables
- **Search through** collections
- **Automate** repetitive tasks

---

## 📋 The Complete Code Example

```java
/**
 * Class 1: Loops
 *
 * Demonstrates:
 * - for loop
 * - while loop
 * - do-while loop
 * - break and continue
 * - nested loops
 *
 * How to run:
 * 1. Save as: Loops.java
 * 2. Compile: javac Loops.java
 * 3. Run:    java Loops
 */

import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ... (see Loops.java for complete code)
    }
}
```

---

## 🔍 Loop Types Explained

### 1️⃣ The `for` Loop

**Use when:** You know exactly how many times you want to repeat.

#### Syntax:
```java
for (initialization; condition; update) {
    // code to repeat
}
```

#### Breaking Down Each Part:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Count: " + i);
}
```

| Part | Code | What It Does |
|------|------|--------------|
| **Initialization** | `int i = 1` | Runs ONCE at the start. Creates a counter variable. |
| **Condition** | `i <= 5` | Checked BEFORE each iteration. Loop continues if true. |
| **Update** | `i++` | Runs AFTER each iteration. Usually increments the counter. |
| **Body** | `{ ... }` | The code that repeats. |

#### Execution Flow:
```
1. Initialize: i = 1
2. Check condition: 1 <= 5? YES → run body → print "Count: 1"
3. Update: i++ → i = 2
4. Check condition: 2 <= 5? YES → run body → print "Count: 2"
5. Update: i++ → i = 3
6. ... continues until i = 6
7. Check condition: 6 <= 5? NO → EXIT loop
```

#### Examples:

**Counting from 1 to 10:**
```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
// Output: 1 2 3 4 5 6 7 8 9 10 (each on new line)
```

**Counting backwards from 10 to 1:**
```java
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}
// Output: 10 9 8 7 6 5 4 3 2 1
```

**Counting by 2s (even numbers):**
```java
for (int i = 2; i <= 10; i += 2) {
    System.out.println(i);
}
// Output: 2 4 6 8 10
```

**Printing on the same line:**
```java
for (int i = 1; i <= 5; i++) {
    System.out.print(i + " ");
}
System.out.println(); // Move to next line
// Output: 1 2 3 4 5
```

---

### 2️⃣ The `while` Loop

**Use when:** You don't know how many times to repeat, but you have a condition to check.

#### Syntax:
```java
while (condition) {
    // code to repeat
}
```

#### How It Works:
1. Check condition
2. If true → execute body → go back to step 1
3. If false → exit loop

#### Examples:

**Basic while loop:**
```java
int count = 1;
while (count <= 5) {
    System.out.println("Count: " + count);
    count++;  // Don't forget to update! Otherwise infinite loop!
}
```

**User input validation (keep asking until valid):**
```java
int age = -1;
while (age < 0 || age > 120) {
    System.out.print("Enter a valid age (0-120): ");
    age = input.nextInt();
}
System.out.println("Your age is: " + age);
```

**Summing numbers until user enters 0:**
```java
int sum = 0;
int number;

System.out.println("Enter numbers to sum (0 to stop):");
number = input.nextInt();

while (number != 0) {
    sum += number;
    number = input.nextInt();
}

System.out.println("Total sum: " + sum);
```

#### ⚠️ Common Mistake - Infinite Loop:
```java
int i = 1;
while (i <= 5) {
    System.out.println(i);
    // OOPS! Forgot i++ → this runs forever!
}
```

---

### 3️⃣ The `do-while` Loop

**Use when:** You want to run the code AT LEAST ONCE, then check the condition.

#### Syntax:
```java
do {
    // code to repeat
} while (condition);  // Note the semicolon!
```

#### Key Difference from `while`:
- `while` checks condition FIRST (might run 0 times)
- `do-while` runs FIRST, then checks (always runs at least once)

#### Example:

**Menu that always shows at least once:**
```java
int choice;

do {
    System.out.println("\n===== MENU =====");
    System.out.println("1. Play Game");
    System.out.println("2. Settings");
    System.out.println("3. Exit");
    System.out.print("Enter choice: ");
    choice = input.nextInt();

    switch (choice) {
        case 1:
            System.out.println("Starting game...");
            break;
        case 2:
            System.out.println("Opening settings...");
            break;
        case 3:
            System.out.println("Goodbye!");
            break;
        default:
            System.out.println("Invalid choice!");
    }

} while (choice != 3);
```

**Comparison - while vs do-while:**
```java
// This might not run at all
int x = 10;
while (x < 5) {
    System.out.println("While: " + x);
    x++;
}
// Output: (nothing - condition is false from start)

// This runs at least once
int y = 10;
do {
    System.out.println("Do-while: " + y);
    y++;
} while (y < 5);
// Output: Do-while: 10
```

---

## 🛑 Loop Control Statements

### `break` - Exit Loop Immediately

Stops the loop completely, even if the condition is still true.

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;  // Exit when i reaches 5
    }
    System.out.println(i);
}
// Output: 1 2 3 4
```

**Common use:** Stop searching once you find what you need.

```java
int[] numbers = {4, 7, 2, 9, 3};
int target = 9;
boolean found = false;

for (int i = 0; i < numbers.length; i++) {
    if (numbers[i] == target) {
        System.out.println("Found at index: " + i);
        found = true;
        break;  // No need to keep searching
    }
}

if (!found) {
    System.out.println("Not found");
}
```

---

### `continue` - Skip Current Iteration

Skips the rest of the current iteration and moves to the next one.

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;  // Skip when i is 3
    }
    System.out.println(i);
}
// Output: 1 2 4 5 (3 is skipped)
```

**Common use:** Skip unwanted values.

```java
// Print only even numbers
for (int i = 1; i <= 10; i++) {
    if (i % 2 != 0) {
        continue;  // Skip odd numbers
    }
    System.out.println(i);
}
// Output: 2 4 6 8 10
```

---

## 🔄 Nested Loops

A loop inside another loop. The inner loop runs completely for each iteration of the outer loop.

### Basic Pattern:
```java
for (int i = 1; i <= 3; i++) {           // Outer loop (rows)
    for (int j = 1; j <= 4; j++) {       // Inner loop (columns)
        System.out.print("* ");
    }
    System.out.println();                 // New line after each row
}
```

**Output:**
```
* * * * 
* * * * 
* * * * 
```

### Multiplication Table:
```java
System.out.println("Multiplication Table (1-5):");
System.out.println("============================");

for (int i = 1; i <= 5; i++) {
    for (int j = 1; j <= 5; j++) {
        System.out.print(i * j + "\t");  // \t is tab for alignment
    }
    System.out.println();
}
```

**Output:**
```
1    2    3    4    5
2    4    6    8    10
3    6    9    12   15
4    8    12   16   20
5    10   15   20   25
```

### Triangle Pattern:
```java
int rows = 5;
for (int i = 1; i <= rows; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

**Output:**
```
* 
* * 
* * * 
* * * * 
* * * * * 
```

---

## 📊 When to Use Which Loop?

| Loop Type | Use When |
|-----------|----------|
| **for** | You know the exact number of iterations |
| **while** | You have a condition but unknown iterations |
| **do-while** | You need at least one execution |

### Decision Flowchart:

```
Do you know how many times to repeat?
    │
    ├── YES → Use FOR loop
    │
    └── NO → Does it need to run at least once?
                │
                ├── YES → Use DO-WHILE loop
                │
                └── NO → Use WHILE loop
```

---

## 🎯 Common Loop Patterns

### 1. Counting Sum
```java
int sum = 0;
for (int i = 1; i <= 100; i++) {
    sum += i;
}
System.out.println("Sum of 1 to 100: " + sum);
// Output: 5050
```

### 2. Factorial
```java
int n = 5;
int factorial = 1;
for (int i = 1; i <= n; i++) {
    factorial *= i;
}
System.out.println(n + "! = " + factorial);
// Output: 5! = 120
```

### 3. Finding Maximum
```java
int[] numbers = {3, 7, 2, 9, 5};
int max = numbers[0];

for (int i = 1; i < numbers.length; i++) {
    if (numbers[i] > max) {
        max = numbers[i];
    }
}
System.out.println("Maximum: " + max);
// Output: Maximum: 9
```

### 4. Counting Occurrences
```java
String text = "Hello World";
char target = 'l';
int count = 0;

for (int i = 0; i < text.length(); i++) {
    if (text.charAt(i) == target) {
        count++;
    }
}
System.out.println("'" + target + "' appears " + count + " times");
// Output: 'l' appears 3 times
```

### 5. Reverse Number
```java
int number = 12345;
int reversed = 0;

while (number != 0) {
    int digit = number % 10;      // Get last digit
    reversed = reversed * 10 + digit;
    number /= 10;                 // Remove last digit
}
System.out.println("Reversed: " + reversed);
// Output: Reversed: 54321
```

---

## ⚠️ Common Mistakes to Avoid

### 1. Off-by-One Errors
```java
// WRONG: Prints 1 to 9 (misses 10)
for (int i = 1; i < 10; i++) { ... }

// CORRECT: Prints 1 to 10
for (int i = 1; i <= 10; i++) { ... }
```

### 2. Infinite Loops
```java
// WRONG: Never ends!
while (true) {
    System.out.println("Forever!");
}

// WRONG: Forgot to update counter
int i = 0;
while (i < 5) {
    System.out.println(i);
    // Missing: i++;
}
```

### 3. Modifying Loop Variable Inside Loop
```java
// CONFUSING: Don't do this
for (int i = 0; i < 10; i++) {
    i = i + 2;  // Don't modify i inside the loop!
}
```

### 4. Using Wrong Comparison
```java
// WRONG: Condition never true
for (int i = 10; i < 1; i++) { ... }

// CORRECT: Counting down needs >= or > and i--
for (int i = 10; i >= 1; i--) { ... }
```

---

## 📝 Key Takeaways

1. **`for` loops** are best when you know the iteration count
2. **`while` loops** are best for unknown iteration count with a condition
3. **`do-while` loops** guarantee at least one execution
4. **`break`** exits the loop immediately
5. **`continue`** skips to the next iteration
6. **Nested loops** create patterns and tables
7. **Always ensure loops can terminate** (avoid infinite loops)
8. **Initialize variables** before while loops
9. **Update loop variables** to progress toward termination

---

## 🔗 What's Next?

In **Class 2**, you'll learn about **Methods** - how to organize your code into reusable blocks, making your programs cleaner and more efficient!

---

**Happy Looping!** 🔁
Practice these patterns and you'll master iteration in no time!
