/**
 * Class 3: Arrays - Complete Example
 *
 * Demonstrates:
 * - Array declaration and initialization
 * - Accessing and modifying elements
 * - Iterating with for and for-each loops
 * - Common array operations
 * - Arrays with methods
 * - 2D arrays
 *
 * How to compile and run:
 * $ javac ArraysDemo.java
 * $ java ArraysDemo
 */

import java.util.Arrays;
import java.util.Scanner;

public class ArraysDemo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ================================================
        // ARRAY DECLARATION AND INITIALIZATION
        // ================================================
        System.out.println("========== ARRAY BASICS ==========");
        
        // Method 1: Declare then create
        int[] numbers1;
        numbers1 = new int[5];  // Creates {0, 0, 0, 0, 0}
        
        // Method 2: Declare and create together
        int[] numbers2 = new int[5];
        
        // Method 3: Initialize with values
        int[] numbers3 = {10, 20, 30, 40, 50};
        
        // Method 4: Explicit initialization
        int[] numbers4 = new int[]{100, 200, 300};
        
        System.out.println("numbers1 (default values): " + Arrays.toString(numbers1));
        System.out.println("numbers3 (initialized): " + Arrays.toString(numbers3));
        System.out.println("numbers4: " + Arrays.toString(numbers4));


        // ================================================
        // ACCESSING AND MODIFYING ELEMENTS
        // ================================================
        System.out.println("\n========== ACCESSING ELEMENTS ==========");
        
        int[] scores = {85, 92, 78, 95, 88};
        
        System.out.println("Array: " + Arrays.toString(scores));
        System.out.println("First element (index 0): " + scores[0]);
        System.out.println("Third element (index 2): " + scores[2]);
        System.out.println("Last element: " + scores[scores.length - 1]);
        System.out.println("Array length: " + scores.length);
        
        // Modifying elements
        System.out.println("\nModifying element at index 2...");
        scores[2] = 100;
        System.out.println("After modification: " + Arrays.toString(scores));


        // ================================================
        // ITERATING WITH FOR LOOP
        // ================================================
        System.out.println("\n========== FOR LOOP ITERATION ==========");
        
        int[] values = {5, 10, 15, 20, 25};
        
        System.out.println("Printing with indices:");
        for (int i = 0; i < values.length; i++) {
            System.out.println("  Index " + i + ": " + values[i]);
        }
        
        // Printing on same line
        System.out.print("All values: ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();


        // ================================================
        // ITERATING WITH FOR-EACH LOOP
        // ================================================
        System.out.println("\n========== FOR-EACH LOOP ==========");
        
        String[] fruits = {"Apple", "Banana", "Cherry", "Date"};
        
        System.out.println("Fruits in our basket:");
        for (String fruit : fruits) {
            System.out.println("  - " + fruit);
        }


        // ================================================
        // COMMON OPERATIONS: SUM AND AVERAGE
        // ================================================
        System.out.println("\n========== SUM AND AVERAGE ==========");
        
        int[] grades = {85, 92, 78, 95, 88, 72, 90};
        
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        
        double average = (double) sum / grades.length;
        
        System.out.println("Grades: " + Arrays.toString(grades));
        System.out.println("Sum: " + sum);
        System.out.printf("Average: %.2f%n", average);


        // ================================================
        // FINDING MAXIMUM AND MINIMUM
        // ================================================
        System.out.println("\n========== MAX AND MIN ==========");
        
        int[] data = {45, 12, 89, 34, 67, 23, 90, 11};
        
        int max = data[0];
        int min = data[0];
        int maxIndex = 0;
        int minIndex = 0;
        
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
                maxIndex = i;
            }
            if (data[i] < min) {
                min = data[i];
                minIndex = i;
            }
        }
        
        System.out.println("Data: " + Arrays.toString(data));
        System.out.println("Maximum: " + max + " at index " + maxIndex);
        System.out.println("Minimum: " + min + " at index " + minIndex);


        // ================================================
        // SEARCHING FOR AN ELEMENT
        // ================================================
        System.out.println("\n========== SEARCHING ==========");
        
        int[] searchArray = {10, 25, 30, 45, 50, 65, 70};
        int target = 45;
        
        int foundIndex = linearSearch(searchArray, target);
        
        System.out.println("Array: " + Arrays.toString(searchArray));
        System.out.println("Searching for: " + target);
        if (foundIndex != -1) {
            System.out.println("Found at index: " + foundIndex);
        } else {
            System.out.println("Not found!");
        }


        // ================================================
        // COUNTING OCCURRENCES
        // ================================================
        System.out.println("\n========== COUNTING OCCURRENCES ==========");
        
        int[] repeats = {1, 3, 2, 3, 4, 3, 5, 3, 6};
        int searchValue = 3;
        int count = countOccurrences(repeats, searchValue);
        
        System.out.println("Array: " + Arrays.toString(repeats));
        System.out.println(searchValue + " appears " + count + " times");


        // ================================================
        // REVERSING AN ARRAY
        // ================================================
        System.out.println("\n========== REVERSING ==========");
        
        int[] toReverse = {1, 2, 3, 4, 5};
        System.out.println("Before: " + Arrays.toString(toReverse));
        
        reverseArray(toReverse);
        System.out.println("After: " + Arrays.toString(toReverse));


        // ================================================
        // COPYING ARRAYS
        // ================================================
        System.out.println("\n========== COPYING ARRAYS ==========");
        
        int[] original = {10, 20, 30, 40, 50};
        
        // Using Arrays.copyOf
        int[] copy1 = Arrays.copyOf(original, original.length);
        
        // Using clone
        int[] copy2 = original.clone();
        
        // Manual copy
        int[] copy3 = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy3[i] = original[i];
        }
        
        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Copy 1: " + Arrays.toString(copy1));
        System.out.println("Copy 2: " + Arrays.toString(copy2));
        System.out.println("Copy 3: " + Arrays.toString(copy3));
        
        // Modifying copy doesn't affect original
        copy1[0] = 999;
        System.out.println("\nAfter modifying copy1[0] = 999:");
        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Copy 1: " + Arrays.toString(copy1));


        // ================================================
        // USING java.util.Arrays
        // ================================================
        System.out.println("\n========== ARRAYS UTILITY CLASS ==========");
        
        int[] unsorted = {64, 25, 12, 22, 11};
        System.out.println("Before sorting: " + Arrays.toString(unsorted));
        
        Arrays.sort(unsorted);
        System.out.println("After sorting: " + Arrays.toString(unsorted));
        
        // Binary search (must be sorted!)
        int searchResult = Arrays.binarySearch(unsorted, 22);
        System.out.println("Binary search for 22: found at index " + searchResult);
        
        // Fill array
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println("Filled array: " + Arrays.toString(filled));
        
        // Compare arrays
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 4};
        System.out.println("arr1 equals arr2: " + Arrays.equals(arr1, arr2));
        System.out.println("arr1 equals arr3: " + Arrays.equals(arr1, arr3));


        // ================================================
        // USER INPUT INTO ARRAY
        // ================================================
        System.out.println("\n========== USER INPUT ==========");
        
        System.out.print("How many numbers do you want to enter? ");
        int size = input.nextInt();
        
        int[] userNumbers = new int[size];
        
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            System.out.print("  Number " + (i + 1) + ": ");
            userNumbers[i] = input.nextInt();
        }
        
        System.out.println("You entered: " + Arrays.toString(userNumbers));
        System.out.println("Sum: " + calculateSum(userNumbers));
        System.out.println("Average: " + calculateAverage(userNumbers));


        // ================================================
        // 2D ARRAYS
        // ================================================
        System.out.println("\n========== 2D ARRAYS ==========");
        
        // Creating a 2D array
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("3x3 Matrix:");
        print2DArray(matrix);
        
        System.out.println("\nAccessing elements:");
        System.out.println("matrix[0][0] = " + matrix[0][0]);  // 1
        System.out.println("matrix[1][2] = " + matrix[1][2]);  // 6
        System.out.println("matrix[2][1] = " + matrix[2][1]);  // 8
        
        System.out.println("\nMatrix dimensions:");
        System.out.println("Rows: " + matrix.length);
        System.out.println("Columns (row 0): " + matrix[0].length);


        // ================================================
        // 2D ARRAY: MULTIPLICATION TABLE
        // ================================================
        System.out.println("\n========== MULTIPLICATION TABLE (5x5) ==========");
        
        int[][] mulTable = createMultiplicationTable(5);
        print2DArray(mulTable);


        // ================================================
        // 2D ARRAY: SUM OF ALL ELEMENTS
        // ================================================
        System.out.println("\n========== 2D ARRAY SUM ==========");
        
        int[][] grid = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        System.out.println("Grid:");
        print2DArray(grid);
        System.out.println("Sum of all elements: " + sum2DArray(grid));


        // ================================================
        // PRACTICAL EXAMPLE: STUDENT GRADES
        // ================================================
        System.out.println("\n========== STUDENT GRADES ==========");
        
        String[] students = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        int[] studentGrades = {92, 85, 78, 95, 88};
        
        printGradeReport(students, studentGrades);


        // Close scanner
        input.close();
        
        System.out.println("\n========== END OF ARRAYS CLASS ==========");
        System.out.println("Practice makes perfect! Try the exercises!");
    }


    // ================================================
    // HELPER METHODS
    // ================================================

    /**
     * Linear search - finds index of target, or -1 if not found
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Counts occurrences of a value in an array
     */
    public static int countOccurrences(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * Reverses an array in place
     */
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Swap
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }

    /**
     * Calculates sum of array elements
     */
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    /**
     * Calculates average of array elements
     */
    public static double calculateAverage(int[] arr) {
        if (arr.length == 0) return 0;
        return (double) calculateSum(arr) / arr.length;
    }

    /**
     * Prints a 2D array as a grid
     */
    public static void print2DArray(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    /**
     * Creates an n x n multiplication table
     */
    public static int[][] createMultiplicationTable(int n) {
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    /**
     * Calculates sum of all elements in a 2D array
     */
    public static int sum2DArray(int[][] arr) {
        int sum = 0;
        for (int[] row : arr) {
            for (int val : row) {
                sum += val;
            }
        }
        return sum;
    }

    /**
     * Prints a grade report for students
     */
    public static void printGradeReport(String[] names, int[] grades) {
        System.out.println("Grade Report:");
        System.out.println("-------------------");
        
        int sum = 0;
        int max = grades[0];
        int min = grades[0];
        String topStudent = names[0];
        
        for (int i = 0; i < names.length; i++) {
            String letterGrade = getLetterGrade(grades[i]);
            System.out.printf("%s: %d (%s)%n", names[i], grades[i], letterGrade);
            
            sum += grades[i];
            if (grades[i] > max) {
                max = grades[i];
                topStudent = names[i];
            }
            if (grades[i] < min) {
                min = grades[i];
            }
        }
        
        System.out.println("-------------------");
        System.out.printf("Class Average: %.1f%n", (double) sum / grades.length);
        System.out.println("Highest: " + max + " (" + topStudent + ")");
        System.out.println("Lowest: " + min);
    }

    /**
     * Converts numeric grade to letter grade
     */
    public static String getLetterGrade(int grade) {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }
}
