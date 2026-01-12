# Class 4: Input/Output (Scanner) - Exercises 🎯

Practice reading different types of user input with Scanner. **Pay special attention to the newline issue!**

---

## 🟢 EASY Exercises

### Exercise 4.1: Simple Greeting
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Asks for the user's name
2. Asks for the user's age
3. Prints a greeting message

**Sample Run:**
```
Enter your name: Rajesh
Enter your age: 19
Hello Rajesh! You are 19 years old.
```

**Solution:**
```java
import java.util.Scanner;

public class SimpleGreeting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        System.out.println("Hello " + name + "! You are " + age + " years old.");

        input.close();
    }
}
```

**Key Learning:** Basic input with Scanner.

---

### Exercise 4.2: Temperature Converter Input
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Asks user for temperature in Celsius
2. Converts to Fahrenheit: `F = (C * 9/5) + 32`
3. Displays both temperatures

**Sample Run:**
```
Enter temperature in Celsius: 25
Temperature in Celsius: 25.0
Temperature in Fahrenheit: 77.0
```

**Solution:**
```java
import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double celsius = input.nextDouble();

        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println("Temperature in Celsius: " + celsius);
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);

        input.close();
    }
}
```

**Key Learning:** Reading decimals with `nextDouble()`.

---

### Exercise 4.3: Simple Calculator
**Difficulty:** ⭐ Easy  
**Time:** 10 minutes

**Task:**  
Create a calculator that:
1. Asks for two numbers
2. Asks for an operation (+, -, *, /)
3. Performs the operation (just store the operator, don't use it yet)
4. Displays all input

**Sample Run:**
```
Enter first number: 10
Enter second number: 3
Enter operator (+, -, *, /): +
You entered: 10 + 3
```

**Solution:**
```java
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();
        
        input.nextLine();  // Clear newline

        System.out.print("Enter operator (+, -, *, /): ");
        String operator = input.nextLine();

        System.out.println("You entered: " + num1 + " " + operator + " " + num2);

        input.close();
    }
}
```

**Key Learning:** Mixing `nextInt()` and `nextLine()` correctly.

---

## 🟡 MEDIUM Exercises

### Exercise 4.4: Student Information Form
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Create a form that collects:
- Full name (entire line)
- Student ID (integer)
- Major (entire line)
- GPA (decimal)
- Year of study (integer)

Then display a formatted summary.

**Sample Run:**
```
Enter your full name: John Doe
Enter your student ID: 12345
Enter your major: Computer Science
Enter your GPA: 3.85
Enter your year (1-4): 2

===== STUDENT INFORMATION =====
Name       : John Doe
ID         : 12345
Major      : Computer Science
GPA        : 3.85
Year       : 2
```

**Solution:**
```java
import java.util.Scanner;

public class StudentInfo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String name = input.nextLine();

        System.out.print("Enter your student ID: ");
        int id = input.nextInt();
        input.nextLine();  // Clear newline

        System.out.print("Enter your major: ");
        String major = input.nextLine();

        System.out.print("Enter your GPA: ");
        double gpa = input.nextDouble();
        input.nextLine();  // Clear newline

        System.out.print("Enter your year (1-4): ");
        int year = input.nextInt();

        System.out.println("\n===== STUDENT INFORMATION =====");
        System.out.println("Name       : " + name);
        System.out.println("ID         : " + id);
        System.out.println("Major      : " + major);
        System.out.println("GPA        : " + gpa);
        System.out.println("Year       : " + year);

        input.close();
    }
}
```

**Key Learning:** Managing multiple inputs with proper newline clearing.

---

### Exercise 4.5: Purchase Calculator
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Create a purchase calculator that:
1. Asks for item name
2. Asks for quantity (integer)
3. Asks for price per unit (decimal)
4. Calculates total: `quantity * price`
5. Calculates tax (10%): `total * 0.10`
6. Calculates final price: `total + tax`

**Sample Run:**
```
Item name: Laptop
Quantity: 2
Price per unit: 50000.5
===== PURCHASE SUMMARY =====
Item: Laptop
Quantity: 2
Price per unit: 50000.5
Subtotal: 100001.0
Tax (10%): 10000.1
Final Price: 110001.1
```

**Solution:**
```java
import java.util.Scanner;

public class PurchaseCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Item name: ");
        String itemName = input.nextLine();

        System.out.print("Quantity: ");
        int quantity = input.nextInt();

        System.out.print("Price per unit: ");
        double pricePerUnit = input.nextDouble();

        double subtotal = quantity * pricePerUnit;
        double tax = subtotal * 0.10;
        double finalPrice = subtotal + tax;

        System.out.println("\n===== PURCHASE SUMMARY =====");
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per unit: " + pricePerUnit);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Tax (10%): " + tax);
        System.out.println("Final Price: " + finalPrice);

        input.close();
    }
}
```

**Key Learning:** Calculations with user input.

---

### Exercise 4.6: Input Validation
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Create a program that:
1. Asks for an age (integer)
2. Validates the input (checks if it's actually an integer)
3. Checks if age is valid (between 1 and 150)
4. Prints appropriate message

**Sample Run (Valid):**
```
Enter your age: 25
✓ Valid age: 25
```

**Sample Run (Invalid Type):**
```
Enter your age: hello
✗ Invalid input! Please enter a number.
```

**Solution:**
```java
import java.util.Scanner;

public class AgeValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");

        if (input.hasNextInt()) {
            int age = input.nextInt();

            if (age >= 1 && age <= 150) {
                System.out.println("✓ Valid age: " + age);
            } else {
                System.out.println("✗ Age must be between 1 and 150");
            }
        } else {
            System.out.println("✗ Invalid input! Please enter a number.");
        }

        input.close();
    }
}
```

**Key Learning:** Using `hasNextInt()` for validation.

---

## 🔴 HARD Exercises

### Exercise 4.7: Budget Tracker
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a budget tracker that:
1. Asks for monthly income
2. Asks for 3 expense categories and amounts
3. Calculates total expenses
4. Calculates remaining balance
5. Calculates percentage spent
6. Shows formatted report

**Sample Run:**
```
===== MONTHLY BUDGET TRACKER =====
Enter your monthly income: 50000
Enter expense 1 name: Rent
Enter expense 1 amount: 15000
Enter expense 2 name: Food
Enter expense 2 amount: 8000
Enter expense 3 name: Entertainment
Enter expense 3 amount: 5000

===== BUDGET REPORT =====
Monthly Income: 50000.0
Total Expenses: 28000.0
Remaining Balance: 22000.0
Percentage Spent: 56.0%
```

**Solution:**
```java
import java.util.Scanner;

public class BudgetTracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== MONTHLY BUDGET TRACKER =====");
        System.out.print("Enter your monthly income: ");
        double income = input.nextDouble();
        input.nextLine();  // Clear newline

        System.out.print("Enter expense 1 name: ");
        String exp1Name = input.nextLine();
        System.out.print("Enter expense 1 amount: ");
        double exp1Amount = input.nextDouble();
        input.nextLine();

        System.out.print("Enter expense 2 name: ");
        String exp2Name = input.nextLine();
        System.out.print("Enter expense 2 amount: ");
        double exp2Amount = input.nextDouble();
        input.nextLine();

        System.out.print("Enter expense 3 name: ");
        String exp3Name = input.nextLine();
        System.out.print("Enter expense 3 amount: ");
        double exp3Amount = input.nextDouble();

        double totalExpenses = exp1Amount + exp2Amount + exp3Amount;
        double remaining = income - totalExpenses;
        double percentSpent = (totalExpenses / income) * 100;

        System.out.println("\n===== BUDGET REPORT =====");
        System.out.println("Monthly Income: " + income);
        System.out.println("Expense 1 (" + exp1Name + "): " + exp1Amount);
        System.out.println("Expense 2 (" + exp2Name + "): " + exp2Amount);
        System.out.println("Expense 3 (" + exp3Name + "): " + exp3Amount);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Remaining Balance: " + remaining);
        System.out.println("Percentage Spent: " + percentSpent + "%");

        input.close();
    }
}
```

**Key Learning:** Complex program with multiple inputs and calculations.

---

### Exercise 4.8: Movie Ticket Booking
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 25 minutes

**Task:**  
Create a movie ticket booking system that:
1. Asks for customer name
2. Asks for movie name
3. Asks for number of tickets
4. Asks if they want popcorn (true/false)
5. Calculates: Ticket price = 250 per ticket
6. Add popcorn cost if needed: 100 per ticket
7. Add 5% tax
8. Shows detailed bill

**Sample Run:**
```
===== MOVIE TICKET BOOKING =====
Enter customer name: Alice
Enter movie name: Avatar
Enter number of tickets: 3
Do you want popcorn? (true/false): true

===== BOOKING RECEIPT =====
Customer: Alice
Movie: Avatar
Tickets: 3
Price per ticket: 250
Subtotal (tickets): 750
Popcorn (100 x 3): 300
Subtotal: 1050
Tax (5%): 52.5
Total: 1102.5
```

**Solution:**
```java
import java.util.Scanner;

public class MovieBooking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== MOVIE TICKET BOOKING =====");
        System.out.print("Enter customer name: ");
        String name = input.nextLine();

        System.out.print("Enter movie name: ");
        String movie = input.nextLine();

        System.out.print("Enter number of tickets: ");
        int tickets = input.nextInt();

        System.out.print("Do you want popcorn? (true/false): ");
        boolean wantPopcorn = input.nextBoolean();

        double ticketPrice = 250;
        double subtotal = tickets * ticketPrice;

        double popcornCost = 0;
        if (wantPopcorn) {
            popcornCost = tickets * 100;
        }

        double beforeTax = subtotal + popcornCost;
        double tax = beforeTax * 0.05;
        double total = beforeTax + tax;

        System.out.println("\n===== BOOKING RECEIPT =====");
        System.out.println("Customer: " + name);
        System.out.println("Movie: " + movie);
        System.out.println("Tickets: " + tickets);
        System.out.println("Price per ticket: " + ticketPrice);
        System.out.println("Subtotal (tickets): " + subtotal);
        if (wantPopcorn) {
            System.out.println("Popcorn (100 x " + tickets + "): " + popcornCost);
        }
        System.out.println("Subtotal: " + beforeTax);
        System.out.println("Tax (5%): " + tax);
        System.out.println("Total: " + total);

        input.close();
    }
}
```

**Key Learning:** Real-world application with conditional logic.

---

### Exercise 4.9: Employee Salary Calculator
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 25 minutes

**Task:**  
Create an employee salary system that:
1. Asks for employee name
2. Asks for basic salary
3. Asks for experience (years)
4. Bonus: 5% if experience >= 5 years
5. Deductions:
   - PF (Provident Fund): 10% of salary
   - TDS (Tax): 5% of salary
6. Calculate net salary

**Sample Run:**
```
===== SALARY CALCULATION =====
Enter employee name: Raj Kumar
Enter basic salary: 50000
Enter years of experience: 6

===== SALARY SLIP =====
Employee: Raj Kumar
Basic Salary: 50000.0
Experience Bonus (>= 5 years): 2500.0
Gross Salary: 52500.0
PF Deduction (10%): 5250.0
TDS (5%): 2625.0
Total Deductions: 7875.0
Net Salary: 44625.0
```

**Solution:**
```java
import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== SALARY CALCULATION =====");
        System.out.print("Enter employee name: ");
        String name = input.nextLine();

        System.out.print("Enter basic salary: ");
        double basicSalary = input.nextDouble();

        System.out.print("Enter years of experience: ");
        int experience = input.nextInt();

        double bonus = 0;
        if (experience >= 5) {
            bonus = basicSalary * 0.05;
        }

        double grossSalary = basicSalary + bonus;

        double pf = grossSalary * 0.10;
        double tds = grossSalary * 0.05;
        double totalDeductions = pf + tds;

        double netSalary = grossSalary - totalDeductions;

        System.out.println("\n===== SALARY SLIP =====");
        System.out.println("Employee: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        if (experience >= 5) {
            System.out.println("Experience Bonus (>= 5 years): " + bonus);
        }
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("PF Deduction (10%): " + pf);
        System.out.println("TDS (5%): " + tds);
        System.out.println("Total Deductions: " + totalDeductions);
        System.out.println("Net Salary: " + netSalary);

        input.close();
    }
}
```

**Key Learning:** Complete real-world application with multiple inputs and calculations.

---

## 🎓 Reflection Questions

1. What's the difference between `next()` and `nextLine()`?
2. Why do we use `input.nextLine()` after `nextInt()`?
3. What does `hasNextInt()` check?
4. How do you read a decimal number?
5. Why should we close the Scanner?

---

## ✅ Submission Checklist

Before moving to Class 5:

- [ ] Completed at least 3 EASY exercises
- [ ] Completed at least 2 MEDIUM exercises
- [ ] Completed at least 1 HARD exercise
- [ ] All programs compile and run correctly
- [ ] Understand the newline issue
- [ ] Know when to use `nextLine()` vs other methods
- [ ] Can use `hasNext()` for validation

---

**Great job!** You now know how to build interactive programs that take user input. Next up: **Class 5 – Conditional Statements (if/else)** where you'll make your programs make decisions!
