/**
 * Class 5: Debugging & Best Practices - Complete Example
 *
 * Demonstrates:
 * - Common errors and how to fix them
 * - Debugging techniques
 * - Best practices in action
 * - Clean code examples
 *
 * How to compile and run:
 * $ javac DebuggingDemo.java
 * $ java DebuggingDemo
 */

import java.util.Scanner;
import java.util.Arrays;

public class DebuggingDemo {

    // ================================================
    // CONSTANTS (Best Practice: Use meaningful constants)
    // ================================================
    public static final int MIN_AGE = 0;
    public static final int MAX_AGE = 120;
    public static final int VOTING_AGE = 18;
    public static final int PASSING_GRADE = 60;
    public static final double PI = 3.14159;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ================================================
        // DEMONSTRATION 1: COMMON ERRORS
        // ================================================
        System.out.println("========== COMMON ERRORS DEMO ==========");
        demonstrateCommonErrors();


        // ================================================
        // DEMONSTRATION 2: DEBUGGING WITH PRINT STATEMENTS
        // ================================================
        System.out.println("\n========== DEBUGGING WITH PRINT ==========");
        int[] numbers = {5, 2, 8, 1, 9, 3};
        System.out.println("Finding max in: " + Arrays.toString(numbers));
        int max = findMaxWithDebug(numbers);
        System.out.println("Result: " + max);


        // ================================================
        // DEMONSTRATION 3: INPUT VALIDATION
        // ================================================
        System.out.println("\n========== INPUT VALIDATION ==========");
        
        // Validate age input
        System.out.print("Enter your age: ");
        int age = getValidAge(input);
        System.out.println("Valid age received: " + age);
        
        // Check voting eligibility (using constants)
        if (age >= VOTING_AGE) {
            System.out.println("You are eligible to vote!");
        } else {
            System.out.println("You cannot vote yet. " + (VOTING_AGE - age) + " years to go.");
        }


        // ================================================
        // DEMONSTRATION 4: NULL SAFETY
        // ================================================
        System.out.println("\n========== NULL SAFETY ==========");
        
        String validName = "Alice";
        String nullName = null;
        
        System.out.println("Safe length of 'Alice': " + safeLength(validName));
        System.out.println("Safe length of null: " + safeLength(nullName));


        // ================================================
        // DEMONSTRATION 5: ARRAY BOUNDS CHECKING
        // ================================================
        System.out.println("\n========== ARRAY BOUNDS CHECKING ==========");
        
        int[] data = {10, 20, 30, 40, 50};
        System.out.println("Array: " + Arrays.toString(data));
        
        System.out.println("Safe get index 2: " + safeArrayGet(data, 2));
        System.out.println("Safe get index 10: " + safeArrayGet(data, 10));
        System.out.println("Safe get index -1: " + safeArrayGet(data, -1));


        // ================================================
        // DEMONSTRATION 6: CLEAN CODE EXAMPLE
        // ================================================
        System.out.println("\n========== CLEAN CODE EXAMPLE ==========");
        
        // Bad: Magic numbers, unclear names
        // double r = 5;
        // double a = 3.14 * r * r;
        
        // Good: Clear names, constants
        double radius = 5;
        double area = calculateCircleArea(radius);
        System.out.printf("Circle with radius %.1f has area %.2f%n", radius, area);


        // ================================================
        // DEMONSTRATION 7: PROPER STRING COMPARISON
        // ================================================
        System.out.println("\n========== STRING COMPARISON ==========");
        
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        
        System.out.println("str1 = \"hello\", str2 = \"hello\", str3 = new String(\"hello\")");
        System.out.println();
        
        // Using == (compares references - WRONG for content)
        System.out.println("Using == (compares references):");
        System.out.println("  str1 == str2: " + (str1 == str2) + " (may be true due to string pool)");
        System.out.println("  str1 == str3: " + (str1 == str3) + " (false! different objects)");
        
        // Using .equals() (compares content - CORRECT)
        System.out.println("\nUsing .equals() (compares content):");
        System.out.println("  str1.equals(str2): " + str1.equals(str2) + " (correct!)");
        System.out.println("  str1.equals(str3): " + str1.equals(str3) + " (correct!)");


        // ================================================
        // DEMONSTRATION 8: SCANNER NEWLINE ISSUE
        // ================================================
        System.out.println("\n========== SCANNER NEWLINE FIX ==========");
        
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        input.nextLine();  // IMPORTANT: Consume the leftover newline!
        
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        
        System.out.println("You entered: " + num + " and " + name);


        // ================================================
        // DEMONSTRATION 9: INTEGER DIVISION FIX
        // ================================================
        System.out.println("\n========== INTEGER DIVISION FIX ==========");
        
        int total = 100;
        int count = 3;
        
        // Wrong way
        double wrongAvg = total / count;
        System.out.println("Wrong: " + total + " / " + count + " = " + wrongAvg);
        
        // Correct way
        double correctAvg = (double) total / count;
        System.out.printf("Correct: %d / %d = %.4f%n", total, count, correctAvg);


        // ================================================
        // DEMONSTRATION 10: COMPLETE WELL-WRITTEN METHOD
        // ================================================
        System.out.println("\n========== WELL-WRITTEN METHOD ==========");
        
        int[] grades = {85, 92, 78, 95, 88, 72, 90};
        printGradeStatistics(grades);


        // Close scanner (Best Practice)
        input.close();
        
        System.out.println("\n========== END OF DEBUGGING CLASS ==========");
        System.out.println("Remember: Reading error messages is a superpower!");
    }


    // ================================================
    // DEMONSTRATION METHODS
    // ================================================

    /**
     * Demonstrates common errors (all fixed versions)
     */
    public static void demonstrateCommonErrors() {
        System.out.println("1. Always use == for comparison, not =");
        int x = 5;
        if (x == 5) {  // CORRECT: uses ==
            System.out.println("   x equals 5");
        }
        
        System.out.println("\n2. Array indices start at 0, end at length-1");
        int[] arr = {10, 20, 30};
        System.out.println("   Array length: " + arr.length);
        System.out.println("   Valid indices: 0 to " + (arr.length - 1));
        System.out.println("   Last element: arr[" + (arr.length - 1) + "] = " + arr[arr.length - 1]);
        
        System.out.println("\n3. Use .equals() for String comparison");
        String a = "test";
        String b = "test";
        System.out.println("   a.equals(b): " + a.equals(b));
        
        System.out.println("\n4. Cast to double before division for decimals");
        int num = 7, den = 2;
        System.out.println("   7 / 2 = " + (num / den) + " (integer division)");
        System.out.println("   (double) 7 / 2 = " + ((double) num / den) + " (correct)");
        
        System.out.println("\n5. Don't forget break in switch statements");
        int day = 1;
        String dayName;
        switch (day) {
            case 1:
                dayName = "Monday";
                break;  // IMPORTANT!
            case 2:
                dayName = "Tuesday";
                break;
            default:
                dayName = "Unknown";
        }
        System.out.println("   Day " + day + " is " + dayName);
    }

    /**
     * Find maximum with debug output
     */
    public static int findMaxWithDebug(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("DEBUG: Array is null or empty!");
            return Integer.MIN_VALUE;
        }
        
        System.out.println("DEBUG: Starting with arr[0] = " + arr[0]);
        int max = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            System.out.println("DEBUG: Comparing max=" + max + " with arr[" + i + "]=" + arr[i]);
            if (arr[i] > max) {
                max = arr[i];
                System.out.println("DEBUG: New max found: " + max);
            }
        }
        
        System.out.println("DEBUG: Final max = " + max);
        return max;
    }

    /**
     * Get a valid age from user (with input validation)
     */
    public static int getValidAge(Scanner input) {
        int age = -1;
        
        while (age < MIN_AGE || age > MAX_AGE) {
            if (input.hasNextInt()) {
                age = input.nextInt();
                if (age < MIN_AGE || age > MAX_AGE) {
                    System.out.print("Invalid! Enter age (" + MIN_AGE + "-" + MAX_AGE + "): ");
                }
            } else {
                System.out.print("Please enter a number: ");
                input.next();  // Clear invalid input
            }
        }
        input.nextLine();  // Consume newline
        
        return age;
    }

    /**
     * Safely get string length (handles null)
     */
    public static int safeLength(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    /**
     * Safely get array element (handles out of bounds)
     */
    public static String safeArrayGet(int[] arr, int index) {
        if (arr == null) {
            return "Error: Array is null";
        }
        if (index < 0 || index >= arr.length) {
            return "Error: Index " + index + " out of bounds (0-" + (arr.length - 1) + ")";
        }
        return String.valueOf(arr[index]);
    }

    /**
     * Calculate circle area (demonstrates clean code)
     */
    public static double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return PI * radius * radius;
    }

    /**
     * Print comprehensive grade statistics (demonstrates clean code)
     */
    public static void printGradeStatistics(int[] grades) {
        // Edge case handling
        if (grades == null || grades.length == 0) {
            System.out.println("No grades to analyze.");
            return;
        }
        
        // Calculate statistics
        int sum = calculateSum(grades);
        double average = (double) sum / grades.length;
        int min = findMin(grades);
        int max = findMax(grades);
        int passingCount = countPassing(grades);
        
        // Print results
        System.out.println("Grade Statistics:");
        System.out.println("  Grades: " + Arrays.toString(grades));
        System.out.println("  Count: " + grades.length);
        System.out.println("  Sum: " + sum);
        System.out.printf("  Average: %.2f%n", average);
        System.out.println("  Min: " + min);
        System.out.println("  Max: " + max);
        System.out.println("  Passing (" + PASSING_GRADE + "+): " + passingCount);
        System.out.printf("  Pass Rate: %.1f%%%n", (passingCount * 100.0 / grades.length));
    }

    /**
     * Calculate sum of array elements
     */
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    /**
     * Find minimum value in array
     */
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    /**
     * Find maximum value in array
     */
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Count grades that meet passing threshold
     */
    public static int countPassing(int[] grades) {
        int count = 0;
        for (int grade : grades) {
            if (grade >= PASSING_GRADE) {
                count++;
            }
        }
        return count;
    }
}
