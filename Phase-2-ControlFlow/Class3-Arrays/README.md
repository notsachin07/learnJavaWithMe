# Class 3: Arrays - Storing Collections of Data 📋

Welcome to **Phase 2, Class 3**! In this class, you'll learn how to store and manipulate **collections of data** using arrays. Instead of creating dozens of separate variables, arrays let you store multiple values under a single name!

---

## 📌 What You'll Learn

- What arrays are and why we use them
- Declaring and initializing arrays
- Accessing and modifying array elements
- Iterating through arrays with loops
- Common array operations (find, sum, min/max, sort)
- Multi-dimensional arrays (2D arrays)
- Common mistakes and best practices

---

## 🎯 Why Arrays Matter

Without arrays, storing 100 student grades would require 100 separate variables! With arrays:
- **Store multiple values** in a single variable
- **Access data by index** - quickly get any element
- **Process data in loops** - perform operations on all elements
- **Organize related data** - keep things together
- **Foundation for data structures** - lists, stacks, queues all build on arrays

---

## 📋 The Complete Code Example

```java
/**
 * Class 3: Arrays
 *
 * Demonstrates:
 * - Array declaration and initialization
 * - Accessing and modifying elements
 * - Iterating with loops
 * - Common array operations
 * - 2D arrays
 *
 * How to run:
 * 1. Save as: Arrays.java
 * 2. Compile: javac Arrays.java
 * 3. Run:    java Arrays
 */

public class Arrays {

    public static void main(String[] args) {
        // ... (see Arrays.java for complete code)
    }
}
```

---

## 🔍 Array Basics

### What is an Array?

An array is a **container** that holds a **fixed number** of values of the **same type**.

```
Index:    [0]    [1]    [2]    [3]    [4]
         +------+------+------+------+------+
numbers: |  10  |  20  |  30  |  40  |  50  |
         +------+------+------+------+------+
```

### Key Characteristics

| Feature | Description |
|---------|-------------|
| **Fixed Size** | Size is set when created and cannot change |
| **Zero-Indexed** | First element is at index 0, not 1 |
| **Same Type** | All elements must be the same data type |
| **Contiguous Memory** | Elements are stored next to each other |

---

## 1️⃣ Declaring Arrays

### Syntax Options

```java
// Option 1: Declare then create
int[] numbers;              // Declare
numbers = new int[5];       // Create with size 5

// Option 2: Declare and create together
int[] numbers = new int[5]; // Creates array with 5 elements (all 0)

// Option 3: Declare, create, and initialize
int[] numbers = {10, 20, 30, 40, 50};  // Creates and fills array

// Option 4: Explicit initialization
int[] numbers = new int[]{10, 20, 30, 40, 50};
```

### Default Values

When you create an array with `new`, elements get default values:

| Data Type | Default Value |
|-----------|---------------|
| `int` | `0` |
| `double` | `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` (null character) |
| `String` (or any object) | `null` |

```java
int[] nums = new int[3];      // {0, 0, 0}
double[] prices = new double[3]; // {0.0, 0.0, 0.0}
boolean[] flags = new boolean[3]; // {false, false, false}
String[] names = new String[3];   // {null, null, null}
```

---

## 2️⃣ Accessing Array Elements

### Reading Elements

Use the **index** in square brackets to access elements:

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers[0]);  // 10 (first element)
System.out.println(numbers[2]);  // 30 (third element)
System.out.println(numbers[4]);  // 50 (last element)

// Store in a variable
int first = numbers[0];
int last = numbers[numbers.length - 1];
```

### Modifying Elements

```java
int[] numbers = {10, 20, 30, 40, 50};

numbers[0] = 100;    // Change first element
numbers[2] = 300;    // Change third element

// Now: {100, 20, 300, 40, 50}
```

### Array Length

Use `.length` (no parentheses!) to get the size:

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers.length);  // 5

int lastIndex = numbers.length - 1;  // 4
```

---

## 3️⃣ Iterating Through Arrays

### Using a `for` Loop

```java
int[] numbers = {10, 20, 30, 40, 50};

// Print all elements
for (int i = 0; i < numbers.length; i++) {
    System.out.println("Element at index " + i + ": " + numbers[i]);
}
```

Output:
```
Element at index 0: 10
Element at index 1: 20
Element at index 2: 30
Element at index 3: 40
Element at index 4: 50
```

### Using a `for-each` Loop (Enhanced For)

Simpler syntax when you don't need the index:

```java
int[] numbers = {10, 20, 30, 40, 50};

for (int num : numbers) {
    System.out.println(num);
}
```

### Comparison: for vs for-each

| Use `for` when... | Use `for-each` when... |
|-------------------|------------------------|
| You need the index | You only need the values |
| You want to modify elements | You're just reading elements |
| You need to go backwards | Forward iteration is fine |
| You need to skip elements | You process all elements |

```java
// for loop - can modify
for (int i = 0; i < numbers.length; i++) {
    numbers[i] = numbers[i] * 2;  // Double each element
}

// for-each - cannot modify the array
for (int num : numbers) {
    num = num * 2;  // This changes local copy, NOT the array!
}
```

---

## 4️⃣ Common Array Operations

### Sum of All Elements

```java
int[] numbers = {10, 20, 30, 40, 50};
int sum = 0;

for (int num : numbers) {
    sum += num;
}

System.out.println("Sum: " + sum);  // Sum: 150
```

### Average

```java
int[] numbers = {10, 20, 30, 40, 50};
int sum = 0;

for (int num : numbers) {
    sum += num;
}

double average = (double) sum / numbers.length;
System.out.println("Average: " + average);  // Average: 30.0
```

### Finding Maximum

```java
int[] numbers = {25, 10, 45, 30, 15};
int max = numbers[0];  // Start with first element

for (int i = 1; i < numbers.length; i++) {
    if (numbers[i] > max) {
        max = numbers[i];
    }
}

System.out.println("Maximum: " + max);  // Maximum: 45
```

### Finding Minimum

```java
int[] numbers = {25, 10, 45, 30, 15};
int min = numbers[0];

for (int i = 1; i < numbers.length; i++) {
    if (numbers[i] < min) {
        min = numbers[i];
    }
}

System.out.println("Minimum: " + min);  // Minimum: 10
```

### Searching for an Element

```java
int[] numbers = {10, 20, 30, 40, 50};
int target = 30;
int foundIndex = -1;

for (int i = 0; i < numbers.length; i++) {
    if (numbers[i] == target) {
        foundIndex = i;
        break;
    }
}

if (foundIndex != -1) {
    System.out.println("Found at index: " + foundIndex);
} else {
    System.out.println("Not found");
}
```

### Counting Occurrences

```java
int[] numbers = {1, 2, 3, 2, 4, 2, 5};
int target = 2;
int count = 0;

for (int num : numbers) {
    if (num == target) {
        count++;
    }
}

System.out.println(target + " appears " + count + " times");  // 2 appears 3 times
```

### Reversing an Array

```java
int[] numbers = {1, 2, 3, 4, 5};

// Swap elements from ends toward middle
for (int i = 0; i < numbers.length / 2; i++) {
    int temp = numbers[i];
    numbers[i] = numbers[numbers.length - 1 - i];
    numbers[numbers.length - 1 - i] = temp;
}

// Now: {5, 4, 3, 2, 1}
```

### Copying an Array

```java
int[] original = {1, 2, 3, 4, 5};

// Method 1: Manual copy
int[] copy1 = new int[original.length];
for (int i = 0; i < original.length; i++) {
    copy1[i] = original[i];
}

// Method 2: Using Arrays.copyOf (requires import)
import java.util.Arrays;
int[] copy2 = Arrays.copyOf(original, original.length);

// Method 3: Using clone
int[] copy3 = original.clone();
```

---

## 5️⃣ Arrays with Methods

### Passing Arrays to Methods

```java
public static void printArray(int[] arr) {
    for (int num : arr) {
        System.out.print(num + " ");
    }
    System.out.println();
}

public static int sum(int[] arr) {
    int total = 0;
    for (int num : arr) {
        total += num;
    }
    return total;
}

public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4, 5};
    printArray(numbers);           // 1 2 3 4 5
    System.out.println(sum(numbers)); // 15
}
```

### Returning Arrays from Methods

```java
public static int[] createArray(int size, int value) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
        arr[i] = value;
    }
    return arr;
}

public static int[] doubleValues(int[] arr) {
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        result[i] = arr[i] * 2;
    }
    return result;
}

public static void main(String[] args) {
    int[] fives = createArray(5, 5);     // {5, 5, 5, 5, 5}
    int[] doubled = doubleValues(fives); // {10, 10, 10, 10, 10}
}
```

### ⚠️ Arrays are Passed by Reference

When you pass an array to a method, changes affect the original:

```java
public static void modifyArray(int[] arr) {
    arr[0] = 999;  // This changes the original array!
}

public static void main(String[] args) {
    int[] numbers = {1, 2, 3};
    modifyArray(numbers);
    System.out.println(numbers[0]);  // 999 (changed!)
}
```

---

## 6️⃣ The `java.util.Arrays` Class

Java provides helpful methods in the `Arrays` class:

```java
import java.util.Arrays;

int[] numbers = {5, 2, 8, 1, 9};

// Sort the array
Arrays.sort(numbers);  // {1, 2, 5, 8, 9}

// Convert to string for printing
System.out.println(Arrays.toString(numbers));  // [1, 2, 5, 8, 9]

// Fill array with a value
int[] filled = new int[5];
Arrays.fill(filled, 7);  // {7, 7, 7, 7, 7}

// Check if two arrays are equal
int[] a = {1, 2, 3};
int[] b = {1, 2, 3};
System.out.println(Arrays.equals(a, b));  // true

// Binary search (array must be sorted!)
int[] sorted = {1, 3, 5, 7, 9};
int index = Arrays.binarySearch(sorted, 5);  // 2
```

---

## 7️⃣ Multi-Dimensional Arrays (2D Arrays)

A 2D array is an "array of arrays" - think of it as a table with rows and columns.

### Declaration and Initialization

```java
// Method 1: Declare size
int[][] matrix = new int[3][4];  // 3 rows, 4 columns

// Method 2: Initialize with values
int[][] matrix = {
    {1, 2, 3, 4},     // Row 0
    {5, 6, 7, 8},     // Row 1
    {9, 10, 11, 12}   // Row 2
};
```

### Visual Representation

```
         Col 0   Col 1   Col 2   Col 3
        +-------+-------+-------+-------+
Row 0   |   1   |   2   |   3   |   4   |
        +-------+-------+-------+-------+
Row 1   |   5   |   6   |   7   |   8   |
        +-------+-------+-------+-------+
Row 2   |   9   |  10   |  11   |  12   |
        +-------+-------+-------+-------+
```

### Accessing Elements

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

System.out.println(matrix[0][0]);  // 1 (row 0, col 0)
System.out.println(matrix[1][2]);  // 6 (row 1, col 2)
System.out.println(matrix[2][1]);  // 8 (row 2, col 1)

// Modify
matrix[1][1] = 50;  // Change center element to 50
```

### Iterating Through 2D Arrays

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Using nested for loops
for (int row = 0; row < matrix.length; row++) {
    for (int col = 0; col < matrix[row].length; col++) {
        System.out.print(matrix[row][col] + " ");
    }
    System.out.println();  // New line after each row
}

// Using for-each
for (int[] row : matrix) {
    for (int value : row) {
        System.out.print(value + " ");
    }
    System.out.println();
}
```

Output:
```
1 2 3
4 5 6
7 8 9
```

### 2D Array Length

```java
int[][] matrix = new int[3][4];

System.out.println(matrix.length);       // 3 (number of rows)
System.out.println(matrix[0].length);    // 4 (number of columns in row 0)
```

---

## 8️⃣ Practical Examples

### Example 1: Student Grades

```java
public static void main(String[] args) {
    String[] students = {"Alice", "Bob", "Charlie", "Diana"};
    int[] grades = {85, 92, 78, 95};
    
    // Find highest grade
    int maxGrade = grades[0];
    String topStudent = students[0];
    
    for (int i = 1; i < grades.length; i++) {
        if (grades[i] > maxGrade) {
            maxGrade = grades[i];
            topStudent = students[i];
        }
    }
    
    System.out.println("Top student: " + topStudent + " with " + maxGrade);
}
```

### Example 2: Multiplication Table (2D)

```java
int[][] table = new int[10][10];

// Fill the table
for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
        table[i][j] = (i + 1) * (j + 1);
    }
}

// Print the table
for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
        System.out.printf("%4d", table[i][j]);
    }
    System.out.println();
}
```

### Example 3: Tic-Tac-Toe Board

```java
char[][] board = {
    {'X', 'O', 'X'},
    {' ', 'X', 'O'},
    {'O', ' ', 'X'}
};

// Print the board
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        System.out.print(" " + board[i][j] + " ");
        if (j < 2) System.out.print("|");
    }
    System.out.println();
    if (i < 2) System.out.println("-----------");
}
```

Output:
```
 X | O | X
-----------
   | X | O
-----------
 O |   | X
```

---

## ⚠️ Common Mistakes to Avoid

### 1. ArrayIndexOutOfBoundsException

```java
int[] numbers = {1, 2, 3};  // Valid indices: 0, 1, 2

System.out.println(numbers[3]);  // ERROR! Index out of bounds
System.out.println(numbers[-1]); // ERROR! No negative indices
```

### 2. Confusing Length with Last Index

```java
int[] numbers = {1, 2, 3, 4, 5};

// WRONG - causes ArrayIndexOutOfBoundsException
int last = numbers[numbers.length];  // length is 5, max index is 4!

// CORRECT
int last = numbers[numbers.length - 1];
```

### 3. Using = Instead of Arrays.equals()

```java
int[] a = {1, 2, 3};
int[] b = {1, 2, 3};

// WRONG - compares memory addresses
if (a == b) { ... }  // false!

// CORRECT - compares contents
if (Arrays.equals(a, b)) { ... }  // true
```

### 4. Forgetting Arrays Have Fixed Size

```java
int[] numbers = new int[3];  // Can only hold 3 elements

numbers[0] = 1;
numbers[1] = 2;
numbers[2] = 3;
numbers[3] = 4;  // ERROR! Array is full
```

### 5. Modifying Array During for-each

```java
int[] numbers = {1, 2, 3};

// This does NOT modify the array
for (int num : numbers) {
    num = num * 2;  // Only modifies local copy
}
// numbers is still {1, 2, 3}

// Use regular for loop to modify
for (int i = 0; i < numbers.length; i++) {
    numbers[i] = numbers[i] * 2;  // This works!
}
```

---

## 📝 Key Takeaways

1. **Arrays store multiple values** of the same type
2. **Arrays are zero-indexed** - first element is at index 0
3. **Arrays have fixed size** - cannot grow or shrink
4. **Use `.length`** to get array size (no parentheses!)
5. **Use for loops** to iterate and modify arrays
6. **Use for-each** when you only need to read values
7. **Arrays are passed by reference** to methods
8. **`java.util.Arrays`** provides helpful utility methods
9. **2D arrays** are arrays of arrays (rows and columns)
10. **Watch for IndexOutOfBoundsException** - stay within bounds!

---

## 🔗 What's Next?

In **Class 4**, you'll learn about the **Enhanced For-Each Loop** in more detail, exploring how it works with arrays and other collections!

---

**Keep practicing!** 📋  
Arrays are fundamental to almost every program you'll write!
