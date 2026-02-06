# Class 3: Arrays - Exercises 📋

Practice working with collections of data using arrays!

---

## 🟢 EASY Exercises

### Exercise 3.1: Sum of Array Elements
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Creates an array with values {5, 10, 15, 20, 25}
2. Calculates and prints the sum of all elements

**Sample Run:**
```
Array: [5, 10, 15, 20, 25]
Sum: 75
```

**Solution:**
```java
import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        int[] numbers = {5, 10, 15, 20, 25};
        
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Sum: " + sum);
    }
}
```

**Key Learning:** Basic array iteration and accumulation.

---

### Exercise 3.2: Find Maximum Value
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Creates an array with at least 5 numbers
2. Finds and prints the maximum value

**Sample Run:**
```
Array: [23, 45, 12, 67, 34]
Maximum value: 67
```

**Solution:**
```java
import java.util.Arrays;

public class FindMax {
    public static void main(String[] args) {
        int[] numbers = {23, 45, 12, 67, 34};
        
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Maximum value: " + max);
    }
}
```

**Key Learning:** Finding maximum using comparison.

---

### Exercise 3.3: Count Even Numbers
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Creates an array of integers
2. Counts how many are even numbers
3. Also prints which numbers are even

**Sample Run:**
```
Array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Even numbers: 2 4 6 8 10
Count of even numbers: 5
```

**Solution:**
```java
import java.util.Arrays;

public class CountEvens {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        int count = 0;
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.print("Even numbers: ");
        
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
                count++;
            }
        }
        
        System.out.println("\nCount of even numbers: " + count);
    }
}
```

**Key Learning:** Filtering elements with conditions.

---

## 🟡 MEDIUM Exercises

### Exercise 3.4: Array Statistics
**Difficulty:** ⭐⭐ Medium  
**Time:** 10 minutes

**Task:**  
Create a program that:
1. Asks user for 5 numbers
2. Stores them in an array
3. Calculates and displays: sum, average, min, max

**Sample Run:**
```
Enter 5 numbers:
Number 1: 10
Number 2: 25
Number 3: 15
Number 4: 30
Number 5: 20

Statistics:
Array: [10, 25, 15, 30, 20]
Sum: 100
Average: 20.0
Minimum: 10
Maximum: 30
```

**Solution:**
```java
import java.util.Scanner;
import java.util.Arrays;

public class ArrayStats {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }
        
        // Calculate statistics
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        
        for (int num : numbers) {
            sum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        double average = (double) sum / numbers.length;
        
        System.out.println("\nStatistics:");
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        
        input.close();
    }
}
```

**Key Learning:** Multiple operations on a single array.

---

### Exercise 3.5: Reverse an Array
**Difficulty:** ⭐⭐ Medium  
**Time:** 10 minutes

**Task:**  
Create a program that:
1. Creates an array with values 1-10
2. Reverses the array in-place (without creating a new array)
3. Prints before and after

**Sample Run:**
```
Before: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
After:  [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
```

**Solution:**
```java
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.println("Before: " + Arrays.toString(numbers));
        
        // Reverse in-place
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            // Swap elements
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            
            left++;
            right--;
        }
        
        System.out.println("After:  " + Arrays.toString(numbers));
    }
}
```

**Key Learning:** In-place array manipulation with two pointers.

---

### Exercise 3.6: Remove Duplicates
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Create a program that:
1. Creates an array with some duplicate values
2. Counts and prints unique values only

**Sample Run:**
```
Original: [1, 2, 2, 3, 4, 4, 4, 5]
Unique values: 1 2 3 4 5
Count of unique: 5
```

**Solution:**
```java
import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 3, 4, 4, 4, 5};
        
        System.out.println("Original: " + Arrays.toString(numbers));
        System.out.print("Unique values: ");
        
        int uniqueCount = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            boolean isDuplicate = false;
            
            // Check if we've seen this number before
            for (int j = 0; j < i; j++) {
                if (numbers[j] == numbers[i]) {
                    isDuplicate = true;
                    break;
                }
            }
            
            if (!isDuplicate) {
                System.out.print(numbers[i] + " ");
                uniqueCount++;
            }
        }
        
        System.out.println("\nCount of unique: " + uniqueCount);
    }
}
```

**Key Learning:** Nested loop comparison for finding duplicates.

---

## 🔴 HARD Exercises

### Exercise 3.7: Merge Two Sorted Arrays
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a program that:
1. Has two sorted arrays
2. Merges them into a single sorted array
3. Prints the result

**Sample Run:**
```
Array 1: [1, 3, 5, 7]
Array 2: [2, 4, 6, 8]
Merged:  [1, 2, 3, 4, 5, 6, 7, 8]
```

**Solution:**
```java
import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        
        int[] merged = mergeArrays(arr1, arr2);
        
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        System.out.println("Merged:  " + Arrays.toString(merged));
    }
    
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        
        int i = 0;  // Index for arr1
        int j = 0;  // Index for arr2
        int k = 0;  // Index for result
        
        // Merge while both arrays have elements
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements from arr1
        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        
        // Copy remaining elements from arr2
        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        
        return result;
    }
}
```

**Key Learning:** Classic merge algorithm with multiple pointers.

---

### Exercise 3.8: Matrix Addition (2D Arrays)
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a program that:
1. Creates two 3x3 matrices
2. Adds them together (element by element)
3. Prints all three matrices

**Sample Run:**
```
Matrix A:
  1  2  3
  4  5  6
  7  8  9

Matrix B:
  9  8  7
  6  5  4
  3  2  1

A + B:
 10 10 10
 10 10 10
 10 10 10
```

**Solution:**
```java
public class MatrixAddition {
    public static void main(String[] args) {
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int[][] matrixB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        
        int[][] result = addMatrices(matrixA, matrixB);
        
        System.out.println("Matrix A:");
        printMatrix(matrixA);
        
        System.out.println("\nMatrix B:");
        printMatrix(matrixB);
        
        System.out.println("\nA + B:");
        printMatrix(result);
    }
    
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        
        return result;
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%3d", val);
            }
            System.out.println();
        }
    }
}
```

**Key Learning:** 2D array operations with nested loops.

---

### Exercise 3.9: Rotate Array
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 25 minutes

**Task:**  
Create a program that:
1. Creates an array
2. Rotates it right by k positions
3. Example: [1,2,3,4,5] rotated by 2 = [4,5,1,2,3]

**Sample Run:**
```
Original: [1, 2, 3, 4, 5, 6, 7]
Rotate by: 3
Result:   [5, 6, 7, 1, 2, 3, 4]
```

**Solution:**
```java
import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        
        System.out.println("Original: " + Arrays.toString(numbers));
        System.out.print("Rotate by: ");
        int k = input.nextInt();
        
        rotateRight(numbers, k);
        
        System.out.println("Result:   " + Arrays.toString(numbers));
        
        input.close();
    }
    
    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;  // Handle k > n
        
        if (k == 0) return;
        
        // Method: Reverse approach
        // 1. Reverse entire array
        // 2. Reverse first k elements
        // 3. Reverse remaining elements
        
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }
    
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
```

**Key Learning:** Efficient rotation using reverse technique.

---

## 🎯 Bonus Challenges

### Bonus 1: Spiral Matrix
Print a 2D matrix in spiral order (clockwise from outside to inside).

### Bonus 2: Find Missing Number
Given an array containing n-1 numbers from 1 to n, find the missing number.

### Bonus 3: Move Zeros
Move all zeros in an array to the end while maintaining the order of other elements.

---

## 📝 Tips for Array Exercises

1. **Draw it out** - Visualize array indices on paper
2. **Watch boundaries** - Most common error is going out of bounds
3. **Remember zero-indexing** - First element is at index 0
4. **Use Arrays.toString()** - Makes printing arrays easy
5. **Test edge cases** - Empty arrays, single element, all same values

---

## ✅ Self-Check Questions

After completing these exercises, you should be able to answer:

1. How do you declare an array of 10 integers?
2. What is the index of the last element in an array of size n?
3. How do you find the length of an array?
4. What's the difference between `for` and `for-each` when working with arrays?
5. How do you properly copy an array (not just the reference)?
6. What happens if you access index -1 or length?

---

**Keep practicing!** Arrays are everywhere in programming. 📋
