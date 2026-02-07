/**
 * Class 4: Enhanced For-Each Loop - Complete Example
 *
 * Demonstrates:
 * - For-each syntax with different data types
 * - Comparison with traditional for loop
 * - For-each with 2D arrays
 * - For-each with Strings
 * - Limitations and when to use traditional for
 * - Practical examples and patterns
 *
 * How to compile and run:
 * $ javac ForEachDemo.java
 * $ java ForEachDemo
 */

import java.util.Arrays;

public class ForEachDemo {

    public static void main(String[] args) {

        // ================================================
        // BASIC FOR-EACH SYNTAX
        // ================================================
        System.out.println("========== BASIC FOR-EACH ==========");
        
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.print("Using for-each: ");
        
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();


        // ================================================
        // COMPARISON: FOR-EACH VS TRADITIONAL FOR
        // ================================================
        System.out.println("\n========== FOR-EACH VS TRADITIONAL ==========");
        
        String[] fruits = {"Apple", "Banana", "Cherry", "Date"};
        
        System.out.println("Traditional for loop:");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("  Index " + i + ": " + fruits[i]);
        }
        
        System.out.println("\nFor-each loop:");
        for (String fruit : fruits) {
            System.out.println("  " + fruit);
        }


        // ================================================
        // FOR-EACH WITH DIFFERENT DATA TYPES
        // ================================================
        System.out.println("\n========== DIFFERENT DATA TYPES ==========");
        
        // With doubles
        double[] prices = {19.99, 29.99, 9.99, 49.99};
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        System.out.printf("Prices: %s%n", Arrays.toString(prices));
        System.out.printf("Total: $%.2f%n", total);
        
        // With booleans
        boolean[] answers = {true, false, true, true, false};
        int trueCount = 0;
        for (boolean answer : answers) {
            if (answer) trueCount++;
        }
        System.out.println("\nAnswers: " + Arrays.toString(answers));
        System.out.println("True answers: " + trueCount);
        
        // With characters
        char[] letters = {'J', 'A', 'V', 'A'};
        System.out.print("\nLetters: ");
        for (char letter : letters) {
            System.out.print(letter + " ");
        }
        System.out.println();


        // ================================================
        // THE MODIFICATION PITFALL
        // ================================================
        System.out.println("\n========== MODIFICATION PITFALL ==========");
        
        int[] values = {1, 2, 3, 4, 5};
        System.out.println("Before: " + Arrays.toString(values));
        
        // This does NOT work!
        for (int val : values) {
            val = val * 2;  // Only modifies local copy
        }
        System.out.println("After for-each (wrong): " + Arrays.toString(values));
        
        // This DOES work - use traditional for
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i] * 2;  // Modifies actual array
        }
        System.out.println("After traditional for (correct): " + Arrays.toString(values));


        // ================================================
        // FOR-EACH WITH 2D ARRAYS
        // ================================================
        System.out.println("\n========== FOR-EACH WITH 2D ARRAYS ==========");
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Matrix:");
        for (int[] row : matrix) {           // row is int[]
            for (int value : row) {          // value is int
                System.out.print(value + " ");
            }
            System.out.println();
        }
        
        // Calculate sum of 2D array
        int matrixSum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                matrixSum += value;
            }
        }
        System.out.println("Sum of all elements: " + matrixSum);


        // ================================================
        // FOR-EACH WITH STRINGS
        // ================================================
        System.out.println("\n========== FOR-EACH WITH STRINGS ==========");
        
        String text = "Hello World";
        
        System.out.println("Original: " + text);
        System.out.print("Characters: ");
        
        for (char c : text.toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        // Count vowels
        int vowelCount = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }
        System.out.println("Vowel count: " + vowelCount);


        // ================================================
        // BREAK AND CONTINUE WITH FOR-EACH
        // ================================================
        System.out.println("\n========== BREAK AND CONTINUE ==========");
        
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        
        // Using break
        System.out.println("Finding 'Charlie':");
        for (String name : names) {
            if (name.equals("Charlie")) {
                System.out.println("  Found: " + name);
                break;
            }
            System.out.println("  Checking: " + name);
        }
        
        // Using continue
        System.out.println("\nNames with more than 3 letters:");
        for (String name : names) {
            if (name.length() <= 3) {
                continue;  // Skip short names
            }
            System.out.println("  " + name);
        }


        // ================================================
        // PRACTICAL EXAMPLES
        // ================================================
        System.out.println("\n========== PRACTICAL EXAMPLES ==========");
        
        // Example 1: Calculate average
        int[] scores = {85, 92, 78, 95, 88};
        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println("Average: " + calculateAverage(scores));
        
        // Example 2: Check if element exists
        System.out.println("\nContains 78? " + contains(scores, 78));
        System.out.println("Contains 100? " + contains(scores, 100));
        
        // Example 3: Count elements greater than threshold
        System.out.println("\nScores above 85: " + countGreaterThan(scores, 85));
        
        // Example 4: Find max
        System.out.println("Maximum score: " + findMax(scores));
        
        // Example 5: String array - longest word
        String[] words = {"cat", "elephant", "dog", "hippopotamus"};
        System.out.println("\nWords: " + Arrays.toString(words));
        System.out.println("Longest word: " + findLongestWord(words));


        // ================================================
        // WHEN YOU NEED THE INDEX
        // ================================================
        System.out.println("\n========== WHEN YOU NEED INDEX ==========");
        
        String[] items = {"First", "Second", "Third", "Fourth"};
        
        System.out.println("Option 1: Use traditional for");
        for (int i = 0; i < items.length; i++) {
            System.out.println("  " + i + ": " + items[i]);
        }
        
        System.out.println("\nOption 2: Track index manually");
        int idx = 0;
        for (String item : items) {
            System.out.println("  " + idx + ": " + item);
            idx++;
        }


        // ================================================
        // PARALLEL ARRAYS (MUST USE TRADITIONAL FOR)
        // ================================================
        System.out.println("\n========== PARALLEL ARRAYS ==========");
        
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] grades = {92, 85, 78, 95};
        
        System.out.println("Student Grades:");
        for (int i = 0; i < students.length; i++) {
            System.out.println("  " + students[i] + ": " + grades[i]);
        }


        // ================================================
        // FILTERING AND COLLECTING
        // ================================================
        System.out.println("\n========== FILTERING ==========");
        
        int[] allNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.print("Original: ");
        for (int n : allNumbers) {
            System.out.print(n + " ");
        }
        
        System.out.print("\nEven only: ");
        for (int n : allNumbers) {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
        }
        
        System.out.print("\nOdd only:  ");
        for (int n : allNumbers) {
            if (n % 2 != 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println();


        // ================================================
        // AGGREGATION EXAMPLES
        // ================================================
        System.out.println("\n========== AGGREGATION ==========");
        
        int[] data = {15, 8, 23, 42, 4, 16};
        System.out.println("Data: " + Arrays.toString(data));
        
        // Sum
        int sum = 0;
        for (int d : data) {
            sum += d;
        }
        System.out.println("Sum: " + sum);
        
        // Product
        long product = 1;
        for (int d : data) {
            product *= d;
        }
        System.out.println("Product: " + product);
        
        // Count above average
        double avg = (double) sum / data.length;
        int aboveAvg = 0;
        for (int d : data) {
            if (d > avg) {
                aboveAvg++;
            }
        }
        System.out.printf("Average: %.2f%n", avg);
        System.out.println("Count above average: " + aboveAvg);


        // ================================================
        // SUMMARY
        // ================================================
        System.out.println("\n========== SUMMARY ==========");
        System.out.println("Use FOR-EACH when:");
        System.out.println("  ✓ Reading elements (not modifying)");
        System.out.println("  ✓ Processing all elements");
        System.out.println("  ✓ Index is not needed");
        System.out.println("  ✓ Forward iteration only");
        System.out.println();
        System.out.println("Use TRADITIONAL FOR when:");
        System.out.println("  ✓ Modifying elements");
        System.out.println("  ✓ Need the index");
        System.out.println("  ✓ Need to go backwards");
        System.out.println("  ✓ Need to skip elements by index");
        System.out.println("  ✓ Working with multiple arrays");

        System.out.println("\n========== END OF FOR-EACH CLASS ==========");
    }


    // ================================================
    // HELPER METHODS
    // ================================================

    /**
     * Calculates average of array elements
     */
    public static double calculateAverage(int[] arr) {
        if (arr.length == 0) return 0;
        
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    /**
     * Checks if array contains a specific value
     */
    public static boolean contains(int[] arr, int target) {
        for (int element : arr) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * Counts elements greater than threshold
     */
    public static int countGreaterThan(int[] arr, int threshold) {
        int count = 0;
        for (int num : arr) {
            if (num > threshold) {
                count++;
            }
        }
        return count;
    }

    /**
     * Finds maximum value in array
     */
    public static int findMax(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Finds the longest word in a String array
     */
    public static String findLongestWord(String[] words) {
        if (words.length == 0) return "";
        
        String longest = words[0];
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
}
