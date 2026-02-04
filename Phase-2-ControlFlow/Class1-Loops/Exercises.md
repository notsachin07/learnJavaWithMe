# Class 1: Loops - Exercises 🔁

Practice making programs that repeat actions efficiently!

---

## 🟢 EASY Exercises

### Exercise 1.1: Count to N
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Asks the user for a number N
2. Prints all numbers from 1 to N

**Sample Run:**
```
Enter a number: 5
1
2
3
4
5
```

**Solution:**
```java
import java.util.Scanner;

public class CountToN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }

        input.close();
    }
}
```

**Key Learning:** Basic for loop with user-defined limit.

---

### Exercise 1.2: Sum of Numbers
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Asks the user for a number N
2. Calculates and prints the sum of all numbers from 1 to N

**Sample Run:**
```
Enter a number: 5
Sum of 1 to 5 = 15
```

**Solution:**
```java
import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = input.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("Sum of 1 to " + n + " = " + sum);

        input.close();
    }
}
```

**Key Learning:** Using a loop to accumulate values.

---

### Exercise 1.3: Even Numbers
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Prints all even numbers from 2 to 20

**Sample Run:**
```
Even numbers from 2 to 20:
2 4 6 8 10 12 14 16 18 20
```

**Solution:**
```java
public class EvenNumbers {
    public static void main(String[] args) {
        System.out.println("Even numbers from 2 to 20:");
        
        for (int i = 2; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
```

**Key Learning:** Using custom increment in for loop.

---

## 🟡 MEDIUM Exercises

### Exercise 1.4: Multiplication Table
**Difficulty:** ⭐⭐ Medium  
**Time:** 10 minutes

**Task:**  
Create a program that:
1. Asks the user for a number
2. Prints the multiplication table for that number (1 to 10)

**Sample Run:**
```
Enter a number: 7
Multiplication Table for 7:
7 x 1 = 7
7 x 2 = 14
7 x 3 = 21
7 x 4 = 28
7 x 5 = 35
7 x 6 = 42
7 x 7 = 49
7 x 8 = 56
7 x 9 = 63
7 x 10 = 70
```

**Solution:**
```java
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = input.nextInt();

        System.out.println("Multiplication Table for " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }

        input.close();
    }
}
```

**Key Learning:** Generating formatted output with loops.

---

### Exercise 1.5: Factorial Calculator
**Difficulty:** ⭐⭐ Medium  
**Time:** 10 minutes

**Task:**  
Create a program that:
1. Asks the user for a number
2. Calculates and prints the factorial
3. Note: Factorial of n = n × (n-1) × (n-2) × ... × 1

**Sample Run:**
```
Enter a number: 5
5! = 120
```

**Solution:**
```java
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = input.nextInt();

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println(n + "! = " + factorial);

        input.close();
    }
}
```

**Key Learning:** Using loops for mathematical calculations.

---

### Exercise 1.6: Number Guessing Game
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Create a program that:
1. Generates a random number between 1 and 100
2. Lets the user guess until they get it right
3. Provides "Too high" or "Too low" hints
4. Counts and displays the number of attempts

**Sample Run:**
```
I'm thinking of a number between 1 and 100.
Enter your guess: 50
Too low!
Enter your guess: 75
Too high!
Enter your guess: 63
Correct! You got it in 3 attempts!
```

**Solution:**
```java
import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;  // 1 to 100
        int guess;
        int attempts = 0;

        System.out.println("I'm thinking of a number between 1 and 100.");

        do {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low!");
            } else if (guess > secretNumber) {
                System.out.println("Too high!");
            }
        } while (guess != secretNumber);

        System.out.println("Correct! You got it in " + attempts + " attempts!");

        input.close();
    }
}
```

**Key Learning:** Using do-while for game loops with unknown iterations.

---

## 🔴 HARD Exercises

### Exercise 1.7: Triangle Pattern
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 15 minutes

**Task:**  
Create a program that:
1. Asks for the number of rows
2. Prints a right-aligned triangle pattern

**Sample Run:**
```
Enter number of rows: 5
        *
      * *
    * * *
  * * * *
* * * * *
```

**Solution:**
```java
import java.util.Scanner;

public class TrianglePattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();

        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("  ");
            }
            // Print stars
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        input.close();
    }
}
```

**Key Learning:** Nested loops for creating patterns with alignment.

---

### Exercise 1.8: Prime Numbers in Range
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 15 minutes

**Task:**  
Create a program that:
1. Asks for a start and end number
2. Prints all prime numbers in that range

**Sample Run:**
```
Enter start: 10
Enter end: 30
Prime numbers from 10 to 30:
11 13 17 19 23 29
```

**Solution:**
```java
import java.util.Scanner;

public class PrimeInRange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter start: ");
        int start = input.nextInt();

        System.out.print("Enter end: ");
        int end = input.nextInt();

        System.out.println("Prime numbers from " + start + " to " + end + ":");

        for (int num = start; num <= end; num++) {
            if (num <= 1) {
                continue;  // Skip 0 and 1
            }

            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        input.close();
    }
}
```

**Key Learning:** Nested loops with break and continue for efficient processing.

---

### Exercise 1.9: Diamond Pattern
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a program that:
1. Asks for the size (odd number recommended)
2. Prints a diamond pattern

**Sample Run:**
```
Enter size (odd number): 5
    *
   ***
  *****
   ***
    *
```

**Solution:**
```java
import java.util.Scanner;

public class DiamondPattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size (odd number): ");
        int n = input.nextInt();

        int mid = n / 2;

        // Upper half (including middle)
        for (int i = 0; i <= mid; i++) {
            // Spaces
            for (int j = 0; j < mid - i; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half
        for (int i = mid - 1; i >= 0; i--) {
            // Spaces
            for (int j = 0; j < mid - i; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        input.close();
    }
}
```

**Key Learning:** Complex nested loops for symmetric patterns.

---

## 🎯 Bonus Challenges

### Bonus 1: FizzBuzz
Print numbers 1 to 100, but:
- For multiples of 3, print "Fizz"
- For multiples of 5, print "Buzz"
- For multiples of both, print "FizzBuzz"

### Bonus 2: Number Pyramid
Create this pattern:
```
    1
   121
  12321
 1234321
123454321
```

### Bonus 3: Palindrome Checker
Check if a number is the same forwards and backwards (e.g., 12321).

---

## 📝 Tips for Loop Exercises

1. **Plan before coding** - Trace through the logic with a small example
2. **Start simple** - Get basic functionality working, then add features
3. **Watch for off-by-one errors** - Double-check your loop boundaries
4. **Use print statements** - Debug by printing variable values
5. **Test edge cases** - What happens with 0, 1, negative numbers?

---

## ✅ Self-Check Questions

After completing these exercises, you should be able to answer:

1. When would you use a `for` loop vs a `while` loop?
2. What's the difference between `break` and `continue`?
3. How do nested loops work for creating patterns?
4. Why is it important to update loop variables in while loops?
5. What causes an infinite loop and how do you avoid it?

---

**Keep practicing!** Loops are fundamental to programming. 🔁
