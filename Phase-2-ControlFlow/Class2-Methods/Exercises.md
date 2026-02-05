# Class 2: Methods - Exercises 🔧

Practice creating reusable, organized methods!

---

## 🟢 EASY Exercises

### Exercise 2.1: Simple Greeting Method
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program with a method called `greet` that:
1. Takes a name as a parameter
2. Prints "Hello, [name]! Welcome!"
3. Call it 3 times with different names from main

**Sample Run:**
```
Hello, Alice! Welcome!
Hello, Bob! Welcome!
Hello, Charlie! Welcome!
```

**Solution:**
```java
public class GreetingMethod {
    public static void main(String[] args) {
        greet("Alice");
        greet("Bob");
        greet("Charlie");
    }

    public static void greet(String name) {
        System.out.println("Hello, " + name + "! Welcome!");
    }
}
```

**Key Learning:** Creating and calling a method with a parameter.

---

### Exercise 2.2: Square Calculator
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program with a method called `square` that:
1. Takes an integer as a parameter
2. Returns the square of that number
3. Use it to print squares of 5, 7, and 12

**Sample Run:**
```
Square of 5 = 25
Square of 7 = 49
Square of 12 = 144
```

**Solution:**
```java
public class SquareCalculator {
    public static void main(String[] args) {
        System.out.println("Square of 5 = " + square(5));
        System.out.println("Square of 7 = " + square(7));
        System.out.println("Square of 12 = " + square(12));
    }

    public static int square(int number) {
        return number * number;
    }
}
```

**Key Learning:** Methods with return values.

---

### Exercise 2.3: Maximum of Two Numbers
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program with a method called `findMax` that:
1. Takes two integers as parameters
2. Returns the larger of the two
3. Test with multiple pairs of numbers

**Sample Run:**
```
Max of 10 and 5 = 10
Max of 3 and 8 = 8
Max of 7 and 7 = 7
```

**Solution:**
```java
public class MaxFinder {
    public static void main(String[] args) {
        System.out.println("Max of 10 and 5 = " + findMax(10, 5));
        System.out.println("Max of 3 and 8 = " + findMax(3, 8));
        System.out.println("Max of 7 and 7 = " + findMax(7, 7));
    }

    public static int findMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
        // Or simply: return (a > b) ? a : b;
    }
}
```

**Key Learning:** Comparison logic in methods.

---

## 🟡 MEDIUM Exercises

### Exercise 2.4: Temperature Converter
**Difficulty:** ⭐⭐ Medium  
**Time:** 10 minutes

**Task:**  
Create a program with two methods:
1. `celsiusToFahrenheit(double celsius)` - converts C to F
2. `fahrenheitToCelsius(double fahrenheit)` - converts F to C
3. Formula: F = (C × 9/5) + 32

**Sample Run:**
```
100°C = 212.00°F
32°F = 0.00°C
98.6°F = 37.00°C
```

**Solution:**
```java
public class TemperatureConverter {
    public static void main(String[] args) {
        System.out.printf("100°C = %.2f°F%n", celsiusToFahrenheit(100));
        System.out.printf("32°F = %.2f°C%n", fahrenheitToCelsius(32));
        System.out.printf("98.6°F = %.2f°C%n", fahrenheitToCelsius(98.6));
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}
```

**Key Learning:** Multiple related methods working together.

---

### Exercise 2.5: Method Overloading - Area Calculator
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Create a program with multiple overloaded `calculateArea` methods:
1. `calculateArea(int side)` - area of a square
2. `calculateArea(int length, int width)` - area of a rectangle
3. `calculateArea(double radius)` - area of a circle

**Sample Run:**
```
Area of square (side=5): 25
Area of rectangle (4x6): 24
Area of circle (radius=3.0): 28.27
```

**Solution:**
```java
public class AreaCalculator {
    public static void main(String[] args) {
        System.out.println("Area of square (side=5): " + calculateArea(5));
        System.out.println("Area of rectangle (4x6): " + calculateArea(4, 6));
        System.out.printf("Area of circle (radius=3.0): %.2f%n", calculateArea(3.0));
    }

    // Square area
    public static int calculateArea(int side) {
        return side * side;
    }

    // Rectangle area
    public static int calculateArea(int length, int width) {
        return length * width;
    }

    // Circle area
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
}
```

**Key Learning:** Method overloading with different parameters.

---

### Exercise 2.6: Grade Calculator with Validation
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Create a program with these methods:
1. `isValidScore(int score)` - returns true if score is 0-100
2. `getGrade(int score)` - returns letter grade (A/B/C/D/F)
3. `printResult(String name, int score)` - prints formatted result

**Sample Run:**
```
Name: Alice, Score: 85, Grade: B
Name: Bob, Score: 72, Grade: C
Name: Charlie, Score: 150, Grade: Invalid Score!
```

**Solution:**
```java
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        printResult("Alice", 85);
        printResult("Bob", 72);
        printResult("Charlie", 150);
    }

    public static boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }

    public static String getGrade(int score) {
        if (!isValidScore(score)) {
            return "Invalid Score!";
        }
        
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }

    public static void printResult(String name, int score) {
        System.out.println("Name: " + name + ", Score: " + score + 
                           ", Grade: " + getGrade(score));
    }
}
```

**Key Learning:** Methods calling other methods, validation.

---

## 🔴 HARD Exercises

### Exercise 2.7: Number Analysis Suite
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a program with these methods:
1. `isPrime(int n)` - checks if number is prime
2. `isEven(int n)` - checks if number is even
3. `sumOfDigits(int n)` - returns sum of digits
4. `reverseNumber(int n)` - returns reversed number
5. `analyzeNumber(int n)` - calls all above and prints analysis

**Sample Run:**
```
Enter a number: 123

=== Analysis of 123 ===
Even: No
Prime: No
Sum of digits: 6
Reversed: 321
```

**Solution:**
```java
import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        
        analyzeNumber(num);
        
        input.close();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int sumOfDigits(int n) {
        n = Math.abs(n);  // Handle negative numbers
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int reverseNumber(int n) {
        int reversed = 0;
        boolean negative = n < 0;
        n = Math.abs(n);
        
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        
        return negative ? -reversed : reversed;
    }

    public static void analyzeNumber(int n) {
        System.out.println("\n=== Analysis of " + n + " ===");
        System.out.println("Even: " + (isEven(n) ? "Yes" : "No"));
        System.out.println("Prime: " + (isPrime(n) ? "Yes" : "No"));
        System.out.println("Sum of digits: " + sumOfDigits(n));
        System.out.println("Reversed: " + reverseNumber(n));
    }
}
```

**Key Learning:** Building a library of utility methods.

---

### Exercise 2.8: Simple Calculator with Menu
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a calculator program with:
1. Methods for add, subtract, multiply, divide
2. A `displayMenu()` method
3. A `performOperation(int choice, double a, double b)` method
4. Use a loop to keep running until user exits

**Sample Run:**
```
===== CALCULATOR =====
1. Add
2. Subtract
3. Multiply
4. Divide
5. Exit
Enter choice: 1
Enter first number: 10
Enter second number: 5
Result: 15.0

Enter choice: 4
Enter first number: 20
Enter second number: 4
Result: 5.0

Enter choice: 5
Goodbye!
```

**Solution:**
```java
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        
        do {
            displayMenu();
            choice = input.nextInt();
            
            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                double a = input.nextDouble();
                System.out.print("Enter second number: ");
                double b = input.nextDouble();
                
                double result = performOperation(choice, a, b);
                System.out.println("Result: " + result);
            } else if (choice == 5) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
            System.out.println();
            
        } while (choice != 5);
        
        input.close();
    }

    public static void displayMenu() {
        System.out.println("===== CALCULATOR =====");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0;
        }
        return a / b;
    }

    public static double performOperation(int choice, double a, double b) {
        switch (choice) {
            case 1: return add(a, b);
            case 2: return subtract(a, b);
            case 3: return multiply(a, b);
            case 4: return divide(a, b);
            default: return 0;
        }
    }
}
```

**Key Learning:** Combining methods with loops and menus.

---

### Exercise 2.9: Password Validator
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 25 minutes

**Task:**  
Create a password validator with these methods:
1. `hasMinLength(String pwd, int minLen)` - checks minimum length
2. `hasUpperCase(String pwd)` - checks for uppercase letter
3. `hasLowerCase(String pwd)` - checks for lowercase letter
4. `hasDigit(String pwd)` - checks for digit
5. `hasSpecialChar(String pwd)` - checks for special character
6. `validatePassword(String pwd)` - returns overall strength and issues

**Sample Run:**
```
Enter password: Hello123

Password Analysis:
✓ Minimum length (8 chars)
✓ Has uppercase letter
✓ Has lowercase letter
✓ Has digit
✗ Has special character

Password Strength: 4/5 (Strong)
```

**Solution:**
```java
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter password: ");
        String password = input.nextLine();
        
        validatePassword(password);
        
        input.close();
    }

    public static boolean hasMinLength(String pwd, int minLen) {
        return pwd.length() >= minLen;
    }

    public static boolean hasUpperCase(String pwd) {
        for (int i = 0; i < pwd.length(); i++) {
            if (Character.isUpperCase(pwd.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasLowerCase(String pwd) {
        for (int i = 0; i < pwd.length(); i++) {
            if (Character.isLowerCase(pwd.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDigit(String pwd) {
        for (int i = 0; i < pwd.length(); i++) {
            if (Character.isDigit(pwd.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSpecialChar(String pwd) {
        String specialChars = "!@#$%^&*()_+-=[]{}|;':\",./<>?";
        for (int i = 0; i < pwd.length(); i++) {
            if (specialChars.contains(String.valueOf(pwd.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    public static String getStrengthLabel(int score) {
        if (score == 5) return "Very Strong";
        else if (score == 4) return "Strong";
        else if (score == 3) return "Moderate";
        else if (score == 2) return "Weak";
        else return "Very Weak";
    }

    public static void validatePassword(String pwd) {
        System.out.println("\nPassword Analysis:");
        
        int score = 0;
        
        boolean lengthOk = hasMinLength(pwd, 8);
        System.out.println((lengthOk ? "✓" : "✗") + " Minimum length (8 chars)");
        if (lengthOk) score++;
        
        boolean upperOk = hasUpperCase(pwd);
        System.out.println((upperOk ? "✓" : "✗") + " Has uppercase letter");
        if (upperOk) score++;
        
        boolean lowerOk = hasLowerCase(pwd);
        System.out.println((lowerOk ? "✓" : "✗") + " Has lowercase letter");
        if (lowerOk) score++;
        
        boolean digitOk = hasDigit(pwd);
        System.out.println((digitOk ? "✓" : "✗") + " Has digit");
        if (digitOk) score++;
        
        boolean specialOk = hasSpecialChar(pwd);
        System.out.println((specialOk ? "✓" : "✗") + " Has special character");
        if (specialOk) score++;
        
        System.out.println("\nPassword Strength: " + score + "/5 (" + 
                           getStrengthLabel(score) + ")");
    }
}
```

**Key Learning:** Building comprehensive validation with multiple helper methods.

---

## 🎯 Bonus Challenges

### Bonus 1: Recursive Factorial
Write a factorial method using recursion (a method that calls itself).

### Bonus 2: Fibonacci Method
Create a method that returns the nth Fibonacci number.

### Bonus 3: Power Function
Create your own `power(base, exponent)` method without using `Math.pow()`.

---

## 📝 Tips for Method Exercises

1. **Plan before coding** - What does the method need? What should it return?
2. **Name descriptively** - `calculateArea` is better than `calc`
3. **One task per method** - Keep methods focused
4. **Test edge cases** - What if input is 0? Negative? Empty string?
5. **Document your methods** - Use comments to explain parameters and return values

---

## ✅ Self-Check Questions

After completing these exercises, you should be able to answer:

1. What's the difference between a parameter and an argument?
2. When do you use `void` vs a return type?
3. What is method overloading and when would you use it?
4. What is variable scope and why does it matter?
5. How do you decide when to create a new method?

---

**Keep practicing!** Methods are essential for writing clean, maintainable code. 🔧
