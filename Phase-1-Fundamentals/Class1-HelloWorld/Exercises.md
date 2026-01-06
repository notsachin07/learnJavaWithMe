# Class 1: Hello World - Exercises 🎯

After understanding the concepts in the README, try these exercises. They're designed to reinforce your learning and help you get comfortable with Java syntax.

---

## 🟢 EASY Exercises (Start here!)

### Exercise 1.1: Print Your Name
**Difficulty:** ⭐ Easy
**Time:** 5 minutes

**Task:**
Modify the HelloWorld program to print your name instead of "Hello World"

**Example Output:**
```
John Doe
```

**Solution:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("John Doe");  // Replace with your name
    }
}
```

**Key Learning:** You can print any text by changing the string inside println()

---

### Exercise 1.2: Print on Multiple Lines
**Difficulty:** ⭐ Easy
**Time:** 5 minutes

**Task:**
Print three different lines: your name, your age, and your favorite programming language

**Example Output:**
```
John Doe
19
Java
```

**Hint:** Use multiple System.out.println() statements

**Solution:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("John Doe");
        System.out.println("19");
        System.out.println("Java");
    }
}
```

**Key Learning:** Each println() creates a new line in the output

---

### Exercise 1.3: Print Without New Line
**Difficulty:** ⭐ Easy
**Time:** 5 minutes

**Task:**
Use `print()` instead of `println()` to print "Hello" and "World" on the same line

**Expected Output:**
```
HelloWorld
```

**Solution:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.print("Hello");
        System.out.print("World");
    }
}
```

**Key Learning:** `print()` doesn't add a newline, `println()` does

---

### Exercise 1.4: Print With Spacing
**Difficulty:** ⭐ Easy
**Time:** 5 minutes

**Task:**
Print "Hello" and "World" on the same line with a space between them

**Expected Output:**
```
Hello World
```

**Solution:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.print("Hello ");  // Notice the space inside quotes
        System.out.println("World");
    }
}
```

**Alternative Solution:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");  // Entire phrase in one println
    }
}
```

**Key Learning:** Spaces inside quotes are printed as part of the string

---

## 🟡 MEDIUM Exercises

### Exercise 1.5: Print a Pattern
**Difficulty:** ⭐⭐ Medium
**Time:** 10 minutes

**Task:**
Print a simple pyramid pattern using asterisks (*)

**Expected Output:**
```
*
**
***
****
*****
```

**Hint:** Each println() statement prints one line

**Solution:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("*");
        System.out.println("**");
        System.out.println("***");
        System.out.println("****");
        System.out.println("*****");
    }
}
```

**Key Learning:** You can create patterns by combining multiple print statements

---

### Exercise 1.6: Print Your Information Card
**Difficulty:** ⭐⭐ Medium
**Time:** 10 minutes

**Task:**
Create an information card for yourself with borders and formatted text

**Expected Output:**
```
======================
   Information Card
======================
Name: John Doe
Age: 19
University: VIT-AP
Course: CSE
======================
```

**Hint:** You can use = and - characters to create borders

**Solution:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("======================");
        System.out.println("   Information Card");
        System.out.println("======================");
        System.out.println("Name: John Doe");
        System.out.println("Age: 19");
        System.out.println("University: VIT-AP");
        System.out.println("Course: CSE");
        System.out.println("======================");
    }
}
```

**Key Learning:** Combining text and special characters creates formatted output

---

### Exercise 1.7: Print Special Characters
**Difficulty:** ⭐⭐ Medium
**Time:** 10 minutes

**Task:**
Print text with special characters and symbols

**Expected Output:**
```
Hello! How are you?
Cost: $50
Rate: 4/5 ⭐
Email: user@gmail.com
```

**Solution:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! How are you?");
        System.out.println("Cost: $50");
        System.out.println("Rate: 4/5");
        System.out.println("Email: user@gmail.com");
    }
}
```

**Key Learning:** You can include punctuation and special characters in strings

---

## 🔴 HARD Exercises

### Exercise 1.8: Print Your Schedule
**Difficulty:** ⭐⭐⭐ Hard
**Time:** 15 minutes

**Task:**
Create a weekly schedule with formatted output using print() and println() strategically

**Expected Output:**
```
========== WEEKLY SCHEDULE ==========

Monday    | 9:00 AM  - Classes Start
          | 12:00 PM - Lunch Break
          | 2:00 PM  - Lab Work

Tuesday   | 10:00 AM - Java Class
          | 3:00 PM  - Gym

Wednesday | 9:00 AM  - Classes Start
          | 1:00 PM  - Project Work

====================================
```

**Hint:** Use multiple print() and println() statements to align text

**Solution:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("========== WEEKLY SCHEDULE ==========");
        System.out.println();
        System.out.println("Monday    | 9:00 AM  - Classes Start");
        System.out.println("          | 12:00 PM - Lunch Break");
        System.out.println("          | 2:00 PM  - Lab Work");
        System.out.println();
        System.out.println("Tuesday   | 10:00 AM - Java Class");
        System.out.println("          | 3:00 PM  - Gym");
        System.out.println();
        System.out.println("Wednesday | 9:00 AM  - Classes Start");
        System.out.println("          | 1:00 PM  - Project Work");
        System.out.println();
        System.out.println("====================================");
    }
}
```

**Key Learning:** Formatting and layout make output more readable

---

### Exercise 1.9: Print ASCII Art
**Difficulty:** ⭐⭐⭐ Hard
**Time:** 20 minutes

**Task:**
Create simple ASCII art of a house or tree

**Expected Output Example (House):**
```
      /\
     /  \
    /____\
    |    |
    |    |
    |____|
```

**Solution:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("      /\\");
        System.out.println("     /  \\");
        System.out.println("    /____\\");
        System.out.println("    |    |");
        System.out.println("    |    |");
        System.out.println("    |____|");
    }
}
```

**Note:** To print a backslash (\), you need to use double backslash (\\) because \ is a special character in Java

**Key Learning:** Special characters like \ need to be escaped with another \

---

### Exercise 1.10: Create a Welcome Message
**Difficulty:** ⭐⭐⭐ Hard
**Time:** 15 minutes

**Task:**
Create a welcome message for a user learning Java that includes:
- A decorative border
- A greeting
- Learning tips
- Encouragement

**Expected Output:**
```
╔════════════════════════════════════╗
║   Welcome to Java Programming!    ║
╚════════════════════════════════════╝

Hello, Java Learner!

Get ready to learn:
✓ Programming fundamentals
✓ Object-Oriented Programming
✓ Real-world application development

Remember:
→ Practice makes perfect
→ Don't be afraid to make mistakes
→ Keep learning every day!

Happy Coding! 🚀
```

**Solution:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║   Welcome to Java Programming!    ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println();
        System.out.println("Hello, Java Learner!");
        System.out.println();
        System.out.println("Get ready to learn:");
        System.out.println("✓ Programming fundamentals");
        System.out.println("✓ Object-Oriented Programming");
        System.out.println("✓ Real-world application development");
        System.out.println();
        System.out.println("Remember:");
        System.out.println("→ Practice makes perfect");
        System.out.println("→ Don't be afraid to make mistakes");
        System.out.println("→ Keep learning every day!");
        System.out.println();
        System.out.println("Happy Coding! 🚀");
    }
}
```

**Key Learning:** Emojis and Unicode characters can be used in Java strings!

---

## 🎓 Challenge: Create Your Own Program

**Task:** Design your own program that:
1. Uses at least 5 println() statements
2. Creates a formatted output (with borders, alignment, etc.)
3. Includes some creative text or art
4. Demonstrates understanding of print() vs println()

**Remember:** Creativity counts! Make it personal and interesting.

---

## 📋 Quick Reference: Print Commands

| Command | Effect | Example |
|---------|--------|---------|
| `System.out.println("text")` | Prints text + new line | `Hello` → appears on own line |
| `System.out.print("text")` | Prints text only | `Hello` + `World` → HelloWorld |
| `System.out.println()` | Just a new line | Creates blank line |
| `System.out.println("a" + "b")` | Concatenate strings | `a` + `b` → ab |

---

## ✅ Submission Checklist

Before considering an exercise complete:

- [ ] Code compiles without errors (`javac` runs successfully)
- [ ] Program runs without errors (`java Main` works)
- [ ] Output matches expected output
- [ ] Code has comments explaining what it does
- [ ] No copy-paste without understanding
- [ ] You tried to solve it yourself first

---

## 🤔 Reflection Questions

Answer these questions to test your understanding:

1. **Why must the filename be Main.java?** (Hint: Look at the class name)
2. **What's the difference between print() and println()?**
3. **How would you print a blank line?**
4. **What happens if you remove the semicolon from the end of a println()?**
5. **Can you print numbers? Try: System.out.println(123);**

---

## 🚀 Next Steps

Once you've completed these exercises:
1. Try creating your own variations
2. Experiment with different text and patterns
3. Move to **Class 2: Variables and Data Types**
4. Come back to these exercises if you forget concepts

---

## 📞 Getting Help

If you're stuck:
1. **Re-read the Class 1 README.md** - Answers are there!
2. **Check the error message** - Java tells you what's wrong
3. **Compare with solutions** - After trying, compare your approach
4. **Experiment** - Try changing things and see what happens

---

**Happy Learning! 🎉**

Remember: Every expert was once a beginner. Keep practicing!

