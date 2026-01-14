# Class 5: Conditional Statements - Exercises 🎯

Practice making programs that respond to different situations!

---

## 🟢 EASY Exercises

### Exercise 5.1: Voting Eligibility
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Asks for user's age
2. Checks if they can vote (age >= 18)
3. Prints appropriate message

**Sample Run:**
```
Enter your age: 20
You are eligible to vote!
```

**Solution:**
```java
import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        if (age >= 18) {
            System.out.println("You are eligible to vote!");
        } else {
            System.out.println("You are not eligible to vote yet.");
        }

        input.close();
    }
}
```

**Key Learning:** Basic if-else statement.

---

### Exercise 5.2: Positive, Negative, or Zero
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Asks for a number
2. Checks if it's positive, negative, or zero
3. Prints the result

**Sample Run:**
```
Enter a number: -5
The number is negative.
```

**Solution:**
```java
import java.util.Scanner;

public class NumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        input.close();
    }
}
```

**Key Learning:** Using else if for multiple conditions.

---

### Exercise 5.3: Even or Odd
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Asks for a number
2. Checks if it's even or odd
3. Prints the result

**Sample Run:**
```
Enter a number: 7
7 is odd.
```

**Solution:**
```java
import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }

        input.close();
    }
}
```

**Key Learning:** Using modulo operator (%) with conditionals.

---

## 🟡 MEDIUM Exercises

### Exercise 5.4: Grade Calculator
**Difficulty:** ⭐⭐ Medium  
**Time:** 10 minutes

**Task:**  
Create a program that:
1. Asks for exam score (0-100)
2. Calculates grade using:
   - 90-100: A
   - 80-89: B
   - 70-79: C
   - 60-69: D
   - Below 60: F
3. Prints grade and message

**Sample Run:**
```
Enter exam score: 85
Your grade: B (Very Good)
```

**Solution:**
```java
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter exam score (0-100): ");
        int score = input.nextInt();

        if (score >= 90) {
            System.out.println("Your grade: A (Excellent)");
        } else if (score >= 80) {
            System.out.println("Your grade: B (Very Good)");
        } else if (score >= 70) {
            System.out.println("Your grade: C (Good)");
        } else if (score >= 60) {
            System.out.println("Your grade: D (Pass)");
        } else {
            System.out.println("Your grade: F (Fail)");
        }

        input.close();
    }
}
```

**Key Learning:** Multiple else if conditions for ranges.

---

### Exercise 5.5: Day of Week (Switch Statement)
**Difficulty:** ⭐⭐ Medium  
**Time:** 10 minutes

**Task:**  
Create a program that:
1. Asks for day number (1-7)
2. Uses switch to print day name
3. Use default for invalid input

**Sample Run:**
```
Enter day (1-7): 3
Wednesday
```

**Solution:**
```java
import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter day (1-7): ");
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

        input.close();
    }
}
```

**Key Learning:** Using switch statement correctly with break.

---

### Exercise 5.6: Largest of Three Numbers
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Create a program that:
1. Asks for three numbers
2. Finds the largest using nested if
3. Prints the largest

**Sample Run:**
```
Enter first number: 10
Enter second number: 25
Enter third number: 15
The largest number is: 25
```

**Solution:**
```java
import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        System.out.print("Enter third number: ");
        int num3 = input.nextInt();

        int largest;

        if (num1 >= num2) {
            if (num1 >= num3) {
                largest = num1;
            } else {
                largest = num3;
            }
        } else {
            if (num2 >= num3) {
                largest = num2;
            } else {
                largest = num3;
            }
        }

        System.out.println("The largest number is: " + largest);

        input.close();
    }
}
```

**Key Learning:** Nested if statements.

---

## 🔴 HARD Exercises

### Exercise 5.7: Triangle Classification
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a program that:
1. Asks for three side lengths
2. Checks if valid triangle (sum of any 2 > 3rd)
3. Classifies as:
   - Equilateral (all sides equal)
   - Isosceles (2 sides equal)
   - Scalene (all different)

**Sample Run:**
```
Enter side 1: 5
Enter side 2: 5
Enter side 3: 8
Valid triangle: Isosceles
```

**Solution:**
```java
import java.util.Scanner;

public class TriangleClassifier {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter side 1: ");
        int a = input.nextInt();

        System.out.print("Enter side 2: ");
        int b = input.nextInt();

        System.out.print("Enter side 3: ");
        int c = input.nextInt();

        // Check if valid triangle
        if (a + b > c && b + c > a && a + c > b) {
            // Classify triangle
            if (a == b && b == c) {
                System.out.println("Valid triangle: Equilateral");
            } else if (a == b || b == c || a == c) {
                System.out.println("Valid triangle: Isosceles");
            } else {
                System.out.println("Valid triangle: Scalene");
            }
        } else {
            System.out.println("Invalid triangle!");
        }

        input.close();
    }
}
```

**Key Learning:** Complex nested if with logical operators.

---

### Exercise 5.8: Library Membership Discount
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a program for library membership discount:
1. Ask for item cost and membership level
2. Membership levels: "Gold" (20%), "Silver" (10%), "None" (0%)
3. Use switch statement
4. Show original price, discount, and final price

**Sample Run:**
```
Enter item cost: 500
Enter membership level (Gold/Silver/None): Gold
Original Price: 500
Discount (20%): 100
Final Price: 400
```

**Solution:**
```java
import java.util.Scanner;

public class LibraryDiscount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter item cost: ");
        double cost = input.nextDouble();

        input.nextLine();  // Clear newline

        System.out.print("Enter membership level (Gold/Silver/None): ");
        String membership = input.nextLine();

        double discountPercent;

        switch (membership) {
            case "Gold":
                discountPercent = 0.20;
                break;
            case "Silver":
                discountPercent = 0.10;
                break;
            case "None":
                discountPercent = 0.0;
                break;
            default:
                System.out.println("Invalid membership level!");
                input.close();
                return;
        }

        double discount = cost * discountPercent;
        double finalPrice = cost - discount;

        System.out.println("Original Price: " + cost);
        System.out.println("Discount (" + (discountPercent * 100) + "%): " + discount);
        System.out.println("Final Price: " + finalPrice);

        input.close();
    }
}
```

**Key Learning:** Switch with String and logical flow.

---

### Exercise 5.9: BMI Calculator
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 25 minutes

**Task:**  
Create BMI calculator:
1. Ask for weight (kg) and height (m)
2. Calculate BMI = weight / (height * height)
3. Classify using:
   - BMI < 18.5: Underweight
   - 18.5 - 24.9: Normal
   - 25 - 29.9: Overweight
   - >= 30: Obese
4. Show BMI and classification

**Sample Run:**
```
Enter weight (kg): 70
Enter height (m): 1.75
Your BMI: 22.86
Classification: Normal weight
```

**Solution:**
```java
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight (kg): ");
        double weight = input.nextDouble();

        System.out.print("Enter height (m): ");
        double height = input.nextDouble();

        double bmi = weight / (height * height);

        System.out.println("\nYour BMI: " + String.format("%.2f", bmi));

        if (bmi < 18.5) {
            System.out.println("Classification: Underweight");
            System.out.println("You need to eat more and exercise!");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("Classification: Normal weight");
            System.out.println("You are in good health!");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("Classification: Overweight");
            System.out.println("Consider exercising more.");
        } else {
            System.out.println("Classification: Obese");
            System.out.println("Please consult a doctor.");
        }

        input.close();
    }
}
```

**Key Learning:** Real-world calculation with conditional logic.

---

## 🎓 Reflection Questions

1. What's the difference between `if`, `else if`, and `else`?
2. When should you use `switch` instead of `if-else`?
3. Why is `break` important in switch?
4. What does the ternary operator do?
5. How would you check if a number is divisible by 3?

---

## ✅ Submission Checklist

Before moving to Class 6:

- [ ] Completed at least 3 EASY exercises
- [ ] Completed at least 2 MEDIUM exercises
- [ ] Completed at least 1 HARD exercise
- [ ] All programs compile and run correctly
- [ ] Understand if, if-else, and else if
- [ ] Know when to use switch vs if-else
- [ ] Can use nested if correctly
- [ ] Understand ternary operator basics

---

**Excellent work!** You can now build programs with intelligent decision-making! Next up: **Class 6 – Loops** where you'll repeat actions!
