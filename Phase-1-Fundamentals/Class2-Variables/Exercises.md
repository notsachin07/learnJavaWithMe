# Class 2: Variables and Data Types - Exercises 🎯

After understanding the concepts in the Class 2 README, try these exercises to practice declaring, initializing, and using variables of different data types.

---

## 🟢 EASY Exercises

### Exercise 2.1: Basic Personal Info
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that stores and prints:
- Your name (String)
- Your age (int)
- Your height (float)
- Whether you are a student (boolean)

**Expected Output Example:**
```text
Name: Rahul
Age: 19
Height: 5.8
Is Student: true
```

**Solution:**
```java
public class PersonalInfo {
    public static void main(String[] args) {
        String name = "Rahul";
        int age = 19;
        float height = 5.8f;
        boolean isStudent = true;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Is Student: " + isStudent);
    }
}
```

**Key Learning:** Use correct data types and concatenation with `+`.

---

### Exercise 2.2: Favourite Movie
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Store information about your favourite movie:
- Title (String)
- Release year (int)
- IMDB rating (double)
- Whether you have watched it more than once (boolean)

Print in a formatted way.

**Example Output:**
```text
Title: Interstellar
Year: 2014
Rating: 8.6
Watched multiple times: true
```

**Solution:**
```java
public class FavouriteMovie {
    public static void main(String[] args) {
        String title = "Interstellar";
        int year = 2014;
        double rating = 8.6;
        boolean watchedMultipleTimes = true;

        System.out.println("Title: " + title);
        System.out.println("Year: " + year);
        System.out.println("Rating: " + rating);
        System.out.println("Watched multiple times: " + watchedMultipleTimes);
    }
}
```

**Key Learning:** Practice different types in a single program.

---

### Exercise 2.3: Simple Arithmetic with Variables
**Difficulty:** ⭐ Easy  
**Time:** 10 minutes

**Task:**  
Create 2 int variables `a` and `b`, assign values, and print:
- Their sum
- Their difference
- Their product

**Example Output:**
```text
a = 10
b = 3
Sum: 13
Difference: 7
Product: 30
```

**Solution:**
```java
public class SimpleMath {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        int sum = a + b;
        int diff = a - b;
        int product = a * b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + diff);
        System.out.println("Product: " + product);
    }
}
```

**Key Learning:** Use variables for basic arithmetic (operators will be explored more in Class 3).

---

## 🟡 MEDIUM Exercises

### Exercise 2.4: Student Result Card
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Create variables to store:
- Student name (String)
- Roll number (int)
- Marks in 3 subjects (int)
- Average marks (double)
- Pass status (boolean) – true if average >= 35

Print a result card.

**Example Output:**
```text
===== Result Card =====
Name: Raghav
Roll No: 101
Subject 1: 78
Subject 2: 85
Subject 3: 90
Average: 84.33333333333333
Pass: true
```

**Solution (without conditions yet):**
```java
public class ResultCard {
    public static void main(String[] args) {
        String name = "Raghav";
        int rollNo = 101;

        int sub1 = 78;
        int sub2 = 85;
        int sub3 = 90;

        int total = sub1 + sub2 + sub3;
        double average = total / 3.0; // use 3.0 to get double division

        boolean pass = average >= 35.0;

        System.out.println("===== Result Card =====");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Subject 1: " + sub1);
        System.out.println("Subject 2: " + sub2);
        System.out.println("Subject 3: " + sub3);
        System.out.println("Average: " + average);
        System.out.println("Pass: " + pass);
    }
}
```

**Key Learning:** Work with multiple related variables and compute an average using `double`.

---

### Exercise 2.5: Online Order Summary
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Create variables for an online order:
- Item name (String)
- Item price (double)
- Quantity (int)
- Total cost (double)
- Is order confirmed? (boolean)

Print a nice summary.

**Example Output:**
```text
===== Order Summary =====
Item: Mechanical Keyboard
Price: 3499.5
Quantity: 2
Total: 6999.0
Order Confirmed: true
```

**Solution:**
```java
public class OrderSummary {
    public static void main(String[] args) {
        String itemName = "Mechanical Keyboard";
        double price = 3499.5;
        int quantity = 2;

        double total = price * quantity;
        boolean isConfirmed = true;

        System.out.println("===== Order Summary =====");
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + total);
        System.out.println("Order Confirmed: " + isConfirmed);
    }
}
```

**Key Learning:** Mix int and double, and calculate totals.

---

### Exercise 2.6: System Status Dashboard
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Create variables to simulate a system status:
- CPU usage (double, in %)
- RAM usage (double, in GB)
- Number of running processes (int)
- Is system overheating? (boolean)

Print in a dashboard style.

**Example Output:**
```text
===== System Status =====
CPU Usage: 47.5%
RAM Usage: 6.25 GB
Processes: 123
Overheating: false
```

**Solution:**
```java
public class SystemStatus {
    public static void main(String[] args) {
        double cpuUsage = 47.5;
        double ramUsage = 6.25;
        int processes = 123;
        boolean isOverheating = false;

        System.out.println("===== System Status =====");
        System.out.println("CPU Usage: " + cpuUsage + "%");
        System.out.println("RAM Usage: " + ramUsage + " GB");
        System.out.println("Processes: " + processes);
        System.out.println("Overheating: " + isOverheating);
    }
}
```

**Key Learning:** Practice realistic, system-like variables.

---

## 🔴 HARD Exercises

### Exercise 2.7: Type Conversion Experiment
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a program that:
1. Declares a `double price = 199.99;`
2. Converts it to an `int` using casting
3. Declares `int a = 7; int b = 2;`
4. Calculates:
   - `double exactDivision = a / (double) b;`
   - `int intDivision = a / b;`
5. Prints all values with explanations.

**Expected Output (example):**
```text
Original price (double): 199.99
Price as int: 199
Exact division: 3.5
Integer division: 3
```

**Solution:**
```java
public class TypeConversion {
    public static void main(String[] args) {
        double price = 199.99;
        int priceAsInt = (int) price; // cast double to int

        int a = 7;
        int b = 2;

        double exactDivision = a / (double) b; // 7 / 2.0 = 3.5
        int intDivision = a / b;               // 7 / 2 = 3 (integer division)

        System.out.println("Original price (double): " + price);
        System.out.println("Price as int: " + priceAsInt);
        System.out.println("Exact division: " + exactDivision);
        System.out.println("Integer division: " + intDivision);
    }
}
```

**Key Learning:** Difference between integer division and floating-point division, and casting.

---

### Exercise 2.8: Profile Card
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a "Profile Card" using multiple variables:
- Name (String)
- Age (int)
- CGPA (double)
- University (String)
- Branch (String)
- Year of study (int)
- Is hosteller? (boolean)

Display in a nice formatted block.

**Example Output:**
```text
============================
        PROFILE CARD
============================
Name       : Raghav
Age        : 19
University : VIT-AP
Branch     : CSE Core
Year       : 1
CGPA       : 8.75
Hosteller  : true
============================
```

**Solution:**
```java
public class ProfileCard {
    public static void main(String[] args) {
        String name = "Raghav";
        int age = 19;
        String university = "VIT-AP";
        String branch = "CSE Core";
        int year = 1;
        double cgpa = 8.75;
        boolean isHosteller = true;

        System.out.println("============================");
        System.out.println("        PROFILE CARD");
        System.out.println("============================");
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("University : " + university);
        System.out.println("Branch     : " + branch);
        System.out.println("Year       : " + year);
        System.out.println("CGPA       : " + cgpa);
        System.out.println("Hosteller  : " + isHosteller);
        System.out.println("============================");
    }
}
```

**Key Learning:** Formatting output with alignment and multiple data types.

---

### Exercise 2.9: Game Character Stats
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 25 minutes

**Task:**  
Create a program to store details of a game character:
- Name (String)
- Health (int)
- Attack power (int)
- Defense (int)
- Critical hit chance (double in %)
- Is alive? (boolean)

Print the character stats card.

**Example Output:**
```text
===== CHARACTER STATS =====
Name           : Dragon Knight
Health         : 150
Attack Power   : 40
Defense        : 25
Crit Chance    : 12.5%
Alive          : true
===========================
```

**Solution:**
```java
public class CharacterStats {
    public static void main(String[] args) {
        String name = "Dragon Knight";
        int health = 150;
        int attackPower = 40;
        int defense = 25;
        double critChance = 12.5;
        boolean isAlive = true;

        System.out.println("===== CHARACTER STATS =====");
        System.out.println("Name           : " + name);
        System.out.println("Health         : " + health);
        System.out.println("Attack Power   : " + attackPower);
        System.out.println("Defense        : " + defense);
        System.out.println("Crit Chance    : " + critChance + "%");
        System.out.println("Alive          : " + isAlive);
        System.out.println("===========================");
    }
}
```

**Key Learning:** Combine multiple variable types into a themed program.

---

## 🎓 Reflection Questions

1. When should you use `int` vs `double`?
2. Why can't a `char` store multiple characters?
3. What happens when you divide two `int` values?
4. Why is `String` not a primitive type?
5. Why is it useful to use `boolean` variables like `isStudent` instead of just printing text?

---

## ✅ Submission Checklist

Before you move to Class 3, make sure you:

- [ ] Completed at least 3 EASY exercises
- [ ] Completed at least 2 MEDIUM exercises
- [ ] Completed at least 1 HARD exercise
- [ ] Compiled and ran all programs without errors
- [ ] Understand why each data type was chosen
- [ ] Tried changing some values and observing changes in output

---

**Great job!** Once you're comfortable with variables and data types, you're ready for **Class 3: Operators** where you'll start doing real calculations and logic with these variables.
