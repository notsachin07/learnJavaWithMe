# Class 3: Operators - Exercises 🎯

Practice using all types of operators: arithmetic, comparison, logical, assignment, and increment/decrement.

---

## 🟢 EASY Exercises

### Exercise 3.1: Basic Arithmetic
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create variables `num1 = 15` and `num2 = 4`, then print:
- Sum
- Difference
- Product
- Quotient
- Remainder

**Expected Output:**
```text
15 + 4 = 19
15 - 4 = 11
15 * 4 = 60
15 / 4 = 3
15 % 4 = 3
```

**Solution:**
```java
public class BasicArithmetic {
    public static void main(String[] args) {
        int num1 = 15;
        int num2 = 4;

        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
        System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
    }
}
```

**Key Learning:** Use parentheses in print statements for clarity.

---

### Exercise 3.2: Comparison Operators
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create variables `age = 16` and `minAge = 18`, then check (print):
- Is age equal to minAge?
- Is age not equal to minAge?
- Is age less than minAge?
- Is age greater than minAge?
- Is age >= minAge?
- Is age <= minAge?

**Expected Output:**
```text
16 == 18 : false
16 != 18 : true
16 < 18 : true
16 > 18 : false
16 >= 18 : false
16 <= 18 : true
```

**Solution:**
```java
public class ComparisonOps {
    public static void main(String[] args) {
        int age = 16;
        int minAge = 18;

        System.out.println(age + " == " + minAge + " : " + (age == minAge));
        System.out.println(age + " != " + minAge + " : " + (age != minAge));
        System.out.println(age + " < " + minAge + " : " + (age < minAge));
        System.out.println(age + " > " + minAge + " : " + (age > minAge));
        System.out.println(age + " >= " + minAge + " : " + (age >= minAge));
        System.out.println(age + " <= " + minAge + " : " + (age <= minAge));
    }
}
```

**Key Learning:** All comparison operators return boolean values.

---

### Exercise 3.3: Assignment Operators
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Start with `value = 100`, then apply assignment operators and print after each:
- += 25 (add 25)
- -= 10 (subtract 10)
- *= 2 (multiply by 2)
- /= 5 (divide by 5)

**Expected Output:**
```text
Initial: 100
After += 25: 125
After -= 10: 115
After *= 2: 230
After /= 5: 46
```

**Solution:**
```java
public class AssignmentOps {
    public static void main(String[] args) {
        int value = 100;
        System.out.println("Initial: " + value);

        value += 25;
        System.out.println("After += 25: " + value);

        value -= 10;
        System.out.println("After -= 10: " + value);

        value *= 2;
        System.out.println("After *= 2: " + value);

        value /= 5;
        System.out.println("After /= 5: " + value);
    }
}
```

**Key Learning:** Compound assignment operators modify and assign in one step.

---

## 🟡 MEDIUM Exercises

### Exercise 3.4: Logical Operators
**Difficulty:** ⭐⭐ Medium  
**Time:** 10 minutes

**Task:**  
Create variables:
- `isStudent = true`
- `hasPassed = true`
- `hasAttended = false`

Then check and print:
- `isStudent && hasPassed` (AND)
- `isStudent || hasAttended` (OR)
- `!hasAttended` (NOT)
- `(isStudent && hasPassed) || hasAttended` (Complex)

**Expected Output:**
```text
isStudent && hasPassed: true
isStudent || hasAttended: true
!hasAttended: true
(isStudent && hasPassed) || hasAttended: true
```

**Solution:**
```java
public class LogicalOps {
    public static void main(String[] args) {
        boolean isStudent = true;
        boolean hasPassed = true;
        boolean hasAttended = false;

        System.out.println("isStudent && hasPassed: " + (isStudent && hasPassed));
        System.out.println("isStudent || hasAttended: " + (isStudent || hasAttended));
        System.out.println("!hasAttended: " + !hasAttended);
        System.out.println("(isStudent && hasPassed) || hasAttended: " + ((isStudent && hasPassed) || hasAttended));
    }
}
```

**Key Learning:** Combine multiple conditions with logical operators.

---

### Exercise 3.5: Increment/Decrement
**Difficulty:** ⭐⭐ Medium  
**Time:** 10 minutes

**Task:**  
Create counters and demonstrate:
- Postfix increment (`counter++`)
- Prefix increment (`++counter`)
- Postfix decrement (`counter--`)
- Prefix decrement (`--counter`)

Show the difference between them.

**Expected Output:**
```text
Initial counter: 10

Postfix counter++:
result = 10, counter = 11

Prefix ++counter:
result = 12, counter = 12

Postfix counter--:
result = 12, counter = 11

Prefix --counter:
result = 10, counter = 10
```

**Solution:**
```java
public class IncrementDecrement {
    public static void main(String[] args) {
        int counter = 10;
        System.out.println("Initial counter: " + counter);

        System.out.println("\nPostfix counter++:");
        int result1 = counter++;
        System.out.println("result = " + result1 + ", counter = " + counter);

        System.out.println("\nPrefix ++counter:");
        int result2 = ++counter;
        System.out.println("result = " + result2 + ", counter = " + counter);

        System.out.println("\nPostfix counter--:");
        int result3 = counter--;
        System.out.println("result = " + result3 + ", counter = " + counter);

        System.out.println("\nPrefix --counter:");
        int result4 = --counter;
        System.out.println("result = " + result4 + ", counter = " + counter);
    }
}
```

**Key Learning:** Prefix vs postfix changes when the value is used vs incremented.

---

### Exercise 3.6: Operator Precedence
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Calculate these expressions and show the step-by-step order:
1. `2 + 3 * 4` (should be 14, not 20)
2. `(2 + 3) * 4` (should be 20)
3. `10 - 5 + 2` (should be 7)
4. `20 / 4 * 2` (should be 10)

**Expected Output:**
```text
2 + 3 * 4 = 14
(2 + 3) * 4 = 20
10 - 5 + 2 = 7
20 / 4 * 2 = 10
```

**Solution:**
```java
public class Precedence {
    public static void main(String[] args) {
        System.out.println("2 + 3 * 4 = " + (2 + 3 * 4));
        System.out.println("(2 + 3) * 4 = " + ((2 + 3) * 4));
        System.out.println("10 - 5 + 2 = " + (10 - 5 + 2));
        System.out.println("20 / 4 * 2 = " + (20 / 4 * 2));
    }
}
```

**Key Learning:** Parentheses override default precedence.

---

## 🔴 HARD Exercises

### Exercise 3.7: Temperature Converter with Logic
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a program that:
- Converts Celsius to Fahrenheit: `F = (C * 9/5) + 32`
- Checks if temperature is freezing (`< 0°C`)
- Checks if temperature is hot (`> 35°C`)
- Checks if it's comfortable (`0°C <= temp <= 25°C`)

**Expected Output (example with 20°C):**
```text
Celsius: 20
Fahrenheit: 68
Is freezing: false
Is hot: false
Is comfortable: true
```

**Solution:**
```java
public class TemperatureConverter {
    public static void main(String[] args) {
        double celsius = 20;
        double fahrenheit = (celsius * 9 / 5) + 32;
        boolean isFreezing = celsius < 0;
        boolean isHot = celsius > 35;
        boolean isComfortable = (celsius >= 0) && (celsius <= 25);

        System.out.println("Celsius: " + celsius);
        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("Is freezing: " + isFreezing);
        System.out.println("Is hot: " + isHot);
        System.out.println("Is comfortable: " + isComfortable);
    }
}
```

**Key Learning:** Combine arithmetic and logical operators for complex logic.

---

### Exercise 3.8: Student Eligibility Check
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create variables and check eligibility:
- `age` (must be >= 18)
- `score` (must be >= 60)
- `attendancePercentage` (must be >= 75)
- `isEmployed` (if true, score requirement drops to 50)

Check and print:
- Is eligible? (all conditions met)
- Why not eligible? (if applicable)

**Expected Output (example):**
```text
Age: 20
Score: 55
Attendance: 85%
Employed: true

Age >= 18: true
Attendance >= 75: true
Score >= 60: false
Is Employed: true
Required Score (employed): 50
Score meets requirement: true

Eligible: true
```

**Solution:**
```java
public class StudentEligibility {
    public static void main(String[] args) {
        int age = 20;
        int score = 55;
        int attendance = 85;
        boolean isEmployed = true;

        int requiredScore = isEmployed ? 50 : 60;

        boolean ageOk = age >= 18;
        boolean attendanceOk = attendance >= 75;
        boolean scoreOk = score >= requiredScore;

        boolean isEligible = ageOk && attendanceOk && scoreOk;

        System.out.println("Age: " + age);
        System.out.println("Score: " + score);
        System.out.println("Attendance: " + attendance + "%");
        System.out.println("Employed: " + isEmployed);
        System.out.println();
        System.out.println("Age >= 18: " + ageOk);
        System.out.println("Attendance >= 75: " + attendanceOk);
        System.out.println("Score >= " + requiredScore + ": " + scoreOk);
        System.out.println();
        System.out.println("Eligible: " + isEligible);
    }
}
```

**Key Learning:** Combine multiple conditions with &&.

---

### Exercise 3.9: Salary Calculation
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 25 minutes

**Task:**  
Calculate salary with conditions:
- Base salary: `50000`
- Bonus if experience >= 5 years: `+20%`
- Bonus if performance rating >= 4: `+10%`
- Tax (if salary > 80000): `15%`, else `10%`
- Final salary = salary - tax

Print all calculations step by step.

**Expected Output (example):**
```text
Base Salary: 50000
Experience: 6 years
Performance Rating: 4.5

Experience Bonus (>= 5 years): 10000
Performance Bonus (>= 4): 5000
Salary after bonuses: 65000

Tax Rate (salary > 80000): 10%
Tax Amount: 6500
Final Salary: 58500
```

**Solution:**
```java
public class SalaryCalculation {
    public static void main(String[] args) {
        double baseSalary = 50000;
        int experience = 6;
        double performanceRating = 4.5;

        // Calculate bonuses
        double experienceBonus = (experience >= 5) ? baseSalary * 0.20 : 0;
        double performanceBonus = (performanceRating >= 4) ? baseSalary * 0.10 : 0;

        double salaryAfterBonus = baseSalary + experienceBonus + performanceBonus;

        // Calculate tax
        double taxRate = (salaryAfterBonus > 80000) ? 0.15 : 0.10;
        double taxAmount = salaryAfterBonus * taxRate;
        double finalSalary = salaryAfterBonus - taxAmount;

        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Experience: " + experience + " years");
        System.out.println("Performance Rating: " + performanceRating);
        System.out.println();
        System.out.println("Experience Bonus: " + experienceBonus);
        System.out.println("Performance Bonus: " + performanceBonus);
        System.out.println("Salary after bonuses: " + salaryAfterBonus);
        System.out.println();
        System.out.println("Tax Rate: " + (taxRate * 100) + "%");
        System.out.println("Tax Amount: " + taxAmount);
        System.out.println("Final Salary: " + finalSalary);
    }
}
```

**Key Learning:** Chained calculations with conditional logic.

---

## 🎓 Reflection Questions

1. What's the difference between `=` and `==`?
2. Why does `7 / 2` give `3` and not `3.5`?
3. When would you use `&&` vs `||`?
4. What does `x++` do differently from `++x`?
5. Why does `2 + 3 * 4` equal `14` and not `20`?

---

## ✅ Submission Checklist

Before moving to Class 4:

- [ ] Completed at least 3 EASY exercises
- [ ] Completed at least 2 MEDIUM exercises
- [ ] Completed at least 1 HARD exercise
- [ ] Compiled and ran all programs successfully
- [ ] Understand operator precedence
- [ ] Know the difference between prefix/postfix operators

---

**Excellent work!** You now understand operators and can use them to build powerful calculations and logic. Next up: **Class 4 – Input/Output** where you'll learn to get data FROM users!
