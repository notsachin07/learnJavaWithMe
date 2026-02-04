/**
 * Class 1: Loops - Complete Example
 *
 * Demonstrates:
 * - for loop (fixed iterations)
 * - while loop (condition-based)
 * - do-while loop (run-then-check)
 * - break and continue statements
 * - nested loops
 * - common loop patterns
 *
 * How to compile and run:
 * $ javac Loops.java
 * $ java Loops
 */

import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ================================================
        // FOR LOOP - Fixed Iterations
        // ================================================
        System.out.println("========== FOR LOOP ==========");
        
        // Basic for loop: counting from 1 to 5
        System.out.println("Counting from 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }

        // Counting backwards
        System.out.println("\nCountdown from 5 to 1:");
        for (int i = 5; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Liftoff!");

        // Counting by 2s (even numbers)
        System.out.println("\nEven numbers from 2 to 10:");
        for (int i = 2; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Using loop to calculate sum
        System.out.println("\nSum of numbers 1 to 10:");
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Sum = " + sum);


        // ================================================
        // WHILE LOOP - Condition-Based
        // ================================================
        System.out.println("\n========== WHILE LOOP ==========");

        // Basic while loop
        System.out.println("While loop counting to 5:");
        int count = 1;
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;
        }

        // User input validation
        System.out.println("\nInput validation example:");
        System.out.print("Enter a positive number: ");
        int number = input.nextInt();

        while (number <= 0) {
            System.out.print("Invalid! Enter a POSITIVE number: ");
            number = input.nextInt();
        }
        System.out.println("You entered: " + number);

        // Summing user input until 0
        System.out.println("\nEnter numbers to sum (0 to stop):");
        int total = 0;
        int userNumber;
        
        System.out.print("Enter a number: ");
        userNumber = input.nextInt();
        
        while (userNumber != 0) {
            total += userNumber;
            System.out.print("Enter a number (0 to stop): ");
            userNumber = input.nextInt();
        }
        System.out.println("Total sum: " + total);


        // ================================================
        // DO-WHILE LOOP - Run At Least Once
        // ================================================
        System.out.println("\n========== DO-WHILE LOOP ==========");

        // Menu that always shows at least once
        int choice;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Say Hello");
            System.out.println("2. Say Goodbye");
            System.out.println("3. Exit");
            System.out.print("Enter choice (1-3): ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Hello, World!");
                    break;
                case 2:
                    System.out.println("Goodbye, World!");
                    break;
                case 3:
                    System.out.println("Exiting menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);


        // ================================================
        // BREAK STATEMENT
        // ================================================
        System.out.println("\n========== BREAK STATEMENT ==========");
        
        // Stop loop when condition is met
        System.out.println("Finding first number divisible by 7 (between 50-100):");
        for (int i = 50; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.println("Found: " + i);
                break;  // Exit loop immediately
            }
        }

        // Search for a number
        int[] numbers = {4, 7, 2, 9, 1, 5, 3};
        int target = 9;
        boolean found = false;
        int index = -1;

        System.out.println("\nSearching for " + target + " in array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Checking index " + i + ": " + numbers[i]);
            if (numbers[i] == target) {
                found = true;
                index = i;
                break;  // Stop searching
            }
        }

        if (found) {
            System.out.println("Found " + target + " at index " + index);
        } else {
            System.out.println(target + " not found");
        }


        // ================================================
        // CONTINUE STATEMENT
        // ================================================
        System.out.println("\n========== CONTINUE STATEMENT ==========");

        // Skip certain values
        System.out.println("Numbers 1-10, skipping multiples of 3:");
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                continue;  // Skip this iteration
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // Print only even numbers using continue
        System.out.println("\nEven numbers 1-10 (using continue):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                continue;  // Skip odd numbers
            }
            System.out.print(i + " ");
        }
        System.out.println();


        // ================================================
        // NESTED LOOPS
        // ================================================
        System.out.println("\n========== NESTED LOOPS ==========");

        // Rectangle pattern
        System.out.println("Rectangle (3 rows x 5 columns):");
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 5; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Right triangle pattern
        System.out.println("\nRight Triangle (5 rows):");
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Inverted triangle
        System.out.println("\nInverted Triangle:");
        for (int row = 5; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Number pyramid
        System.out.println("\nNumber Pyramid:");
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }


        // ================================================
        // MULTIPLICATION TABLE
        // ================================================
        System.out.println("\n========== MULTIPLICATION TABLE ==========");
        System.out.print("Enter a number for multiplication table: ");
        int n = input.nextInt();

        System.out.println("\nMultiplication table for " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }


        // ================================================
        // COMMON PATTERNS
        // ================================================
        System.out.println("\n========== COMMON PATTERNS ==========");

        // Factorial calculation
        System.out.print("\nEnter a number for factorial: ");
        int factNum = input.nextInt();
        long factorial = 1;
        
        for (int i = 1; i <= factNum; i++) {
            factorial *= i;
        }
        System.out.println(factNum + "! = " + factorial);

        // Fibonacci sequence
        System.out.print("\nHow many Fibonacci numbers? ");
        int fibCount = input.nextInt();
        
        int first = 0, second = 1;
        System.out.print("Fibonacci sequence: ");
        
        for (int i = 1; i <= fibCount; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();

        // Check if number is prime
        System.out.print("\nEnter a number to check if prime: ");
        int primeCheck = input.nextInt();
        boolean isPrime = true;
        
        if (primeCheck <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(primeCheck); i++) {
                if (primeCheck % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        
        if (isPrime) {
            System.out.println(primeCheck + " is a prime number");
        } else {
            System.out.println(primeCheck + " is not a prime number");
        }

        // Reverse a number
        System.out.print("\nEnter a number to reverse: ");
        int original = input.nextInt();
        int reversed = 0;
        int temp = original;
        
        while (temp != 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        System.out.println("Reversed: " + reversed);


        // ================================================
        // LOOP COMPARISON SUMMARY
        // ================================================
        System.out.println("\n========== LOOP COMPARISON ==========");
        System.out.println("for loop    : Use when you know exact iterations");
        System.out.println("while loop  : Use when iteration count is unknown");
        System.out.println("do-while    : Use when you need at least one run");
        System.out.println("break       : Exit loop immediately");
        System.out.println("continue    : Skip to next iteration");

        // Close scanner
        input.close();
        
        System.out.println("\n========== END OF LOOPS CLASS ==========");
        System.out.println("Practice makes perfect! Try the exercises!");
    }
}
