# Class 5: Debugging & Best Practices - Exercises 🐛

Practice your debugging skills and learn to write clean, maintainable code!

---

## 🟢 Easy Exercises

### Exercise 1: Fix the Syntax Errors
**Goal:** Identify and fix all syntax errors in this code.

```java
public class BuggyCode {
    public static void main(String[] args) {
        int x = 10
        if (x = 10) {
            System.out.println("x is ten")
        }
        
        String name = "Java"
        System.out.println("Hello, " + name);
    }
}
```

**Tasks:**
1. Find all syntax errors
2. Fix each error
3. Explain what was wrong

**Expected Output:**
```
x is ten
Hello, Java
```

---

### Exercise 2: Fix the Logic Error
**Goal:** This code should check if a number is even, but it always says "odd". Fix it.

```java
public class EvenChecker {
    public static void main(String[] args) {
        int number = 8;
        
        if (number % 2 == 1) {
            System.out.println(number + " is even");
        } else {
            System.out.println(number + " is odd");
        }
    }
}
```

**Expected Output:**
```
8 is even
```

---

### Exercise 3: Fix the Array Error
**Goal:** This code crashes. Find out why and fix it.

```java
public class ArrayPrinter {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        for (int i = 0; i <= numbers.length; i++) {
            System.out.println("Element " + i + ": " + numbers[i]);
        }
    }
}
```

**Expected Output:**
```
Element 0: 10
Element 1: 20
Element 2: 30
Element 3: 40
Element 4: 50
```

---

## 🟡 Medium Exercises

### Exercise 4: Fix the String Comparison Bug
**Goal:** This login checker doesn't work correctly. Fix it.

```java
import java.util.Scanner;

public class LoginChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String correctPassword = "secret123";
        
        System.out.print("Enter password: ");
        String userPassword = input.nextLine();
        
        // BUG: This comparison doesn't work correctly!
        if (userPassword == correctPassword) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
        
        input.close();
    }
}
```

**Test Cases:**
- Input: `secret123` → Output: `Access granted!`
- Input: `wrong` → Output: `Access denied!`

---

### Exercise 5: Fix the Division Bug
**Goal:** This grade calculator gives wrong averages. Fix it.

```java
public class GradeCalculator {
    public static void main(String[] args) {
        int test1 = 85;
        int test2 = 90;
        int test3 = 78;
        
        int sum = test1 + test2 + test3;
        double average = sum / 3;
        
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);  // Should show 84.33...
    }
}
```

**Expected Output:**
```
Sum: 253
Average: 84.33333...
```

---

### Exercise 6: Debug the Loop
**Goal:** This code should print numbers 1-5 but runs forever. Fix it.

```java
public class InfiniteLoop {
    public static void main(String[] args) {
        int i = 1;
        
        while (i <= 5) {
            System.out.println("Number: " + i);
            // Something is missing here!
        }
        
        System.out.println("Done!");
    }
}
```

**Expected Output:**
```
Number: 1
Number: 2
Number: 3
Number: 4
Number: 5
Done!
```

---

## 🔴 Hard Exercises

### Exercise 7: Multiple Bug Fix Challenge
**Goal:** This method has 5 bugs. Find and fix them all!

```java
public class BugHunt {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 95, 88};
        printStats(scores);
    }
    
    public static void printStats(int[] arr) {
        // Bug 1: Initialization
        int sum = 1;
        int min = 0;
        int max = 0;
        
        // Bug 2 & 3: Loop condition and logic
        for (int i = 1; i <= arr.length; i++) {
            sum += arr[i];
            
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        // Bug 4: Integer division
        double avg = sum / arr.length;
        
        // Bug 5: Missing format specifier
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
```

**Expected Output:**
```
Sum: 438
Average: 87.6
Min: 78
Max: 95
```

---

### Exercise 8: Rewrite for Clean Code
**Goal:** Rewrite this messy code following best practices.

```java
public class m {
    public static void main(String[] args) {
        int a=10,b=20,c=30,d=40,e=50;int s=0;int x=0;
        s=a+b+c+d+e;x=s/5;double y=100-x;
        if(y>0){System.out.println("below avg by "+y);}
        else if(y<0){System.out.println("above avg by "+(-y));}
        else{System.out.println("exactly avg");}
    }
}
```

**Requirements:**
1. Use meaningful variable names
2. Add proper spacing and indentation
3. Use constants where appropriate
4. Add comments explaining the logic
5. Extract calculations into methods
6. Add proper Javadoc comments

---

### Exercise 9: Build a Debugger Tool
**Goal:** Create a complete debug helper class with these methods:

```java
public class DebugHelper {
    
    // 1. Log messages with severity levels
    // Usage: log("INFO", "Program started")
    //        log("ERROR", "File not found")
    //        log("DEBUG", "x = 5")
    public static void log(String level, String message) {
        // Print: [INFO] Program started
        // Print: [ERROR] File not found
        // etc.
    }
    
    // 2. Print array with index numbers
    // Usage: debugArray("myArr", {1, 2, 3})
    // Output: myArr[0] = 1
    //         myArr[1] = 2
    //         myArr[2] = 3
    public static void debugArray(String name, int[] arr) {
        // Handle null arrays gracefully
    }
    
    // 3. Compare two values and show result
    // Usage: compare("x", 5, "y", 10)
    // Output: Comparing x=5 vs y=10: y is greater
    public static void compare(String name1, int val1, String name2, int val2) {
        // Implementation
    }
    
    // 4. Validate input is in range
    // Returns true if valid, prints error if not
    // Usage: validateRange("age", 25, 0, 120) → true
    //        validateRange("age", -5, 0, 120) → false, prints error
    public static boolean validateRange(String name, int value, int min, int max) {
        // Implementation
    }
    
    // 5. Timing helper
    // Usage: long start = startTimer("sort");
    //        // ... do work ...
    //        endTimer("sort", start);
    // Output: [TIMER] sort started
    //         [TIMER] sort completed in 15 ms
    public static long startTimer(String taskName) {
        // Implementation
    }
    
    public static void endTimer(String taskName, long startTime) {
        // Implementation
    }
}
```

**Test your class with:**
```java
public static void main(String[] args) {
    log("INFO", "Debug Helper Test Started");
    
    int[] testArr = {10, 20, 30};
    debugArray("testArr", testArr);
    
    compare("a", 5, "b", 10);
    compare("x", 7, "y", 7);
    
    validateRange("age", 25, 0, 120);
    validateRange("temperature", 150, -40, 100);
    
    long start = startTimer("calculation");
    // Simulate work
    int sum = 0;
    for (int i = 0; i < 1000000; i++) {
        sum += i;
    }
    endTimer("calculation", start);
    
    log("INFO", "Debug Helper Test Complete");
}
```

---

## 🌟 Bonus Challenges

### Bonus 1: Error Message Parser
Create a program that reads common Java error messages and explains them in simple terms:
- `NullPointerException` → "You tried to use an object that doesn't exist (is null)"
- `ArrayIndexOutOfBoundsException` → "You tried to access an array position that doesn't exist"
- etc.

### Bonus 2: Code Review Checklist
Write a program that asks yes/no questions about code quality:
- Does every variable have a meaningful name?
- Are magic numbers replaced with constants?
- Is each method doing only one thing?
- Are there comments explaining complex logic?

Print a final score and suggestions.

### Bonus 3: Create a Bug Tracker
Build a simple bug tracking system that can:
1. Add new bugs (id, description, severity)
2. List all bugs
3. Mark bugs as fixed
4. Show bugs by severity
5. Display statistics (total, fixed, open)

---

## 📝 Debugging Checklist

Use this checklist when debugging:

```
□ READ the error message completely
□ IDENTIFY the line number mentioned
□ CHECK for common issues:
    □ Missing semicolons?
    □ Mismatched braces {}?
    □ Wrong comparison (= vs ==)?
    □ Off-by-one errors in loops?
    □ Using == instead of .equals() for Strings?
    □ Integer division when you need decimals?
    □ Array index out of bounds?
    □ Null pointer issues?
□ ADD print statements to trace execution
□ TEST with simple input first
□ SIMPLIFY - comment out code to isolate the bug
□ TAKE A BREAK if stuck for too long!
```

---

## 🏆 Phase 2 Complete!

Congratulations on completing Phase 2: Control Flow! You've learned:

- ✅ **Loops** - for, while, do-while, break, continue
- ✅ **Methods** - Parameters, return values, overloading
- ✅ **Arrays** - Declaration, iteration, common operations
- ✅ **For-Each** - Enhanced for loops, when to use them
- ✅ **Debugging** - Finding and fixing bugs, best practices

**What's Next?** Phase 3: Object-Oriented Programming!
- Classes and Objects
- Constructors
- Encapsulation (private, getters/setters)
- Inheritance
- Polymorphism

Keep coding and learning! 🚀
