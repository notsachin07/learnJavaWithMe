# Class 4: Enhanced For-Each Loop - Exercises 🔄

Practice the for-each loop and know when to use it!

---

## 🟢 EASY Exercises

### Exercise 4.1: Print Array Elements
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Creates an array of 5 favorite foods (Strings)
2. Uses for-each to print each food on a new line with a number

**Sample Run:**
```
My Favorite Foods:
1. Pizza
2. Sushi
3. Tacos
4. Pasta
5. Burger
```

**Solution:**
```java
public class FavoriteFoods {
    public static void main(String[] args) {
        String[] foods = {"Pizza", "Sushi", "Tacos", "Pasta", "Burger"};
        
        System.out.println("My Favorite Foods:");
        int number = 1;
        for (String food : foods) {
            System.out.println(number + ". " + food);
            number++;
        }
    }
}
```

**Key Learning:** Basic for-each with String array.

---

### Exercise 4.2: Sum of Doubles
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Creates an array of prices (doubles)
2. Uses for-each to calculate the total
3. Prints the total formatted as currency

**Sample Run:**
```
Prices: $19.99, $29.50, $15.00, $45.99
Total: $110.48
```

**Solution:**
```java
public class SumPrices {
    public static void main(String[] args) {
        double[] prices = {19.99, 29.50, 15.00, 45.99};
        
        System.out.print("Prices: ");
        for (int i = 0; i < prices.length; i++) {
            System.out.print("$" + prices[i]);
            if (i < prices.length - 1) System.out.print(", ");
        }
        System.out.println();
        
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        
        System.out.printf("Total: $%.2f%n", total);
    }
}
```

**Key Learning:** For-each for accumulating values.

---

### Exercise 4.3: Count Matching Elements
**Difficulty:** ⭐ Easy  
**Time:** 5 minutes

**Task:**  
Create a program that:
1. Creates an array of characters
2. Counts how many times a specific character appears
3. Uses for-each for counting

**Sample Run:**
```
Text: ['h', 'e', 'l', 'l', 'o']
Counting 'l': 2 occurrences
```

**Solution:**
```java
import java.util.Arrays;

public class CountCharacters {
    public static void main(String[] args) {
        char[] text = {'h', 'e', 'l', 'l', 'o'};
        char target = 'l';
        
        int count = 0;
        for (char c : text) {
            if (c == target) {
                count++;
            }
        }
        
        System.out.println("Text: " + Arrays.toString(text));
        System.out.println("Counting '" + target + "': " + count + " occurrences");
    }
}
```

**Key Learning:** For-each with conditions.

---

## 🟡 MEDIUM Exercises

### Exercise 4.4: For-Each vs Traditional Comparison
**Difficulty:** ⭐⭐ Medium  
**Time:** 10 minutes

**Task:**  
Create a program that demonstrates the difference between for-each and traditional for:
1. Create an array of integers
2. Try to double each element using for-each (show it doesn't work)
3. Double each element using traditional for (show it works)
4. Print before and after for both attempts

**Sample Run:**
```
Original: [1, 2, 3, 4, 5]

Attempting to double with for-each...
After for-each: [1, 2, 3, 4, 5]  (unchanged!)

Doubling with traditional for...
After traditional for: [2, 4, 6, 8, 10]  (success!)
```

**Solution:**
```java
import java.util.Arrays;

public class ForEachVsTraditional {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Original: " + Arrays.toString(numbers));
        
        // Attempt 1: For-each (doesn't work)
        System.out.println("\nAttempting to double with for-each...");
        for (int num : numbers) {
            num = num * 2;  // Only modifies local copy!
        }
        System.out.println("After for-each: " + Arrays.toString(numbers) + "  (unchanged!)");
        
        // Attempt 2: Traditional for (works)
        System.out.println("\nDoubling with traditional for...");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2;
        }
        System.out.println("After traditional for: " + Arrays.toString(numbers) + "  (success!)");
    }
}
```

**Key Learning:** Understanding why for-each can't modify arrays.

---

### Exercise 4.5: 2D Array Sum with For-Each
**Difficulty:** ⭐⭐ Medium  
**Time:** 10 minutes

**Task:**  
Create a program that:
1. Creates a 3x4 2D array of integers
2. Uses nested for-each loops to calculate the sum
3. Also finds the maximum value

**Sample Run:**
```
Matrix:
  1   2   3   4
  5   6   7   8
  9  10  11  12

Sum of all elements: 78
Maximum value: 12
```

**Solution:**
```java
public class Matrix2DForEach {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        // Print matrix
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
        
        // Calculate sum and max using for-each
        int sum = 0;
        int max = matrix[0][0];
        
        for (int[] row : matrix) {
            for (int val : row) {
                sum += val;
                if (val > max) {
                    max = val;
                }
            }
        }
        
        System.out.println("\nSum of all elements: " + sum);
        System.out.println("Maximum value: " + max);
    }
}
```

**Key Learning:** Nested for-each with 2D arrays.

---

### Exercise 4.6: String Analysis with For-Each
**Difficulty:** ⭐⭐ Medium  
**Time:** 15 minutes

**Task:**  
Create a program that analyzes a string using for-each:
1. Takes a string input
2. Counts vowels, consonants, digits, and spaces
3. Uses for-each on the character array

**Sample Run:**
```
Enter text: Hello World 123

Analysis of "Hello World 123":
Vowels: 3
Consonants: 7
Digits: 3
Spaces: 2
```

**Solution:**
```java
import java.util.Scanner;

public class StringAnalysis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = input.nextLine();
        
        int vowels = 0, consonants = 0, digits = 0, spaces = 0;
        
        for (char c : text.toCharArray()) {
            char lower = Character.toLowerCase(c);
            
            if (lower == 'a' || lower == 'e' || lower == 'i' || 
                lower == 'o' || lower == 'u') {
                vowels++;
            } else if (lower >= 'a' && lower <= 'z') {
                consonants++;
            } else if (c >= '0' && c <= '9') {
                digits++;
            } else if (c == ' ') {
                spaces++;
            }
        }
        
        System.out.println("\nAnalysis of \"" + text + "\":");
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);
        
        input.close();
    }
}
```

**Key Learning:** For-each with toCharArray() for string processing.

---

## 🔴 HARD Exercises

### Exercise 4.7: Multiple Array Statistics
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a program with methods that use for-each to:
1. Find the sum
2. Find the average
3. Find the minimum
4. Find the maximum
5. Count even numbers
6. Count numbers above average

**Sample Run:**
```
Array: [23, 45, 12, 67, 34, 89, 56, 78]

Statistics:
  Sum: 404
  Average: 50.50
  Minimum: 12
  Maximum: 89
  Even count: 4
  Above average: 4
```

**Solution:**
```java
import java.util.Arrays;

public class ArrayStatistics {
    public static void main(String[] args) {
        int[] numbers = {23, 45, 12, 67, 34, 89, 56, 78};
        
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("\nStatistics:");
        System.out.println("  Sum: " + sum(numbers));
        System.out.printf("  Average: %.2f%n", average(numbers));
        System.out.println("  Minimum: " + min(numbers));
        System.out.println("  Maximum: " + max(numbers));
        System.out.println("  Even count: " + countEven(numbers));
        System.out.println("  Above average: " + countAboveAverage(numbers));
    }
    
    public static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }
    
    public static double average(int[] arr) {
        if (arr.length == 0) return 0;
        return (double) sum(arr) / arr.length;
    }
    
    public static int min(int[] arr) {
        int minimum = arr[0];
        for (int num : arr) {
            if (num < minimum) {
                minimum = num;
            }
        }
        return minimum;
    }
    
    public static int max(int[] arr) {
        int maximum = arr[0];
        for (int num : arr) {
            if (num > maximum) {
                maximum = num;
            }
        }
        return maximum;
    }
    
    public static int countEven(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    
    public static int countAboveAverage(int[] arr) {
        double avg = average(arr);
        int count = 0;
        for (int num : arr) {
            if (num > avg) {
                count++;
            }
        }
        return count;
    }
}
```

**Key Learning:** Building a library of for-each based utility methods.

---

### Exercise 4.8: Word Frequency Counter
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 20 minutes

**Task:**  
Create a program that:
1. Takes an array of words
2. Counts frequency of each unique word
3. Uses for-each loops throughout

**Sample Run:**
```
Words: [apple, banana, apple, cherry, banana, apple, date]

Word Frequencies:
  apple: 3
  banana: 2
  cherry: 1
  date: 1
```

**Solution:**
```java
import java.util.Arrays;

public class WordFrequency {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple", "date"};
        
        System.out.println("Words: " + Arrays.toString(words));
        System.out.println("\nWord Frequencies:");
        
        // Find unique words and count them
        String[] counted = new String[words.length];  // Track what we've counted
        int countedSize = 0;
        
        for (String word : words) {
            // Check if we've already counted this word
            boolean alreadyCounted = false;
            for (int i = 0; i < countedSize; i++) {
                if (counted[i].equals(word)) {
                    alreadyCounted = true;
                    break;
                }
            }
            
            if (!alreadyCounted) {
                // Count this word
                int frequency = 0;
                for (String w : words) {
                    if (w.equals(word)) {
                        frequency++;
                    }
                }
                System.out.println("  " + word + ": " + frequency);
                counted[countedSize] = word;
                countedSize++;
            }
        }
    }
}
```

**Key Learning:** Complex counting logic with for-each.

---

### Exercise 4.9: Right Loop for the Job
**Difficulty:** ⭐⭐⭐ Hard  
**Time:** 25 minutes

**Task:**  
Create a program that demonstrates choosing the right loop type:
1. Task 1: Sum all elements (use for-each)
2. Task 2: Find element at specific index (need traditional)
3. Task 3: Reverse array (need traditional)
4. Task 4: Check if all elements positive (use for-each)
5. Task 5: Replace negative with 0 (need traditional)

For each task, explain WHY you chose that loop type.

**Sample Run:**
```
Array: [5, -3, 8, -1, 10, 2]

Task 1: Sum all elements
  Using: FOR-EACH (only reading values)
  Sum: 21

Task 2: Get element at index 3
  Using: TRADITIONAL FOR (need index access)
  Element at index 3: -1

Task 3: Reverse array
  Using: TRADITIONAL FOR (need to modify by index)
  Reversed: [2, 10, -1, 8, -3, 5]

Task 4: Check all positive
  Using: FOR-EACH (only checking values)
  All positive? false

Task 5: Replace negatives with 0
  Using: TRADITIONAL FOR (need to modify elements)
  After replacement: [2, 10, 0, 8, 0, 5]
```

**Solution:**
```java
import java.util.Arrays;

public class RightLoopChoice {
    public static void main(String[] args) {
        int[] original = {5, -3, 8, -1, 10, 2};
        int[] numbers = original.clone();
        
        System.out.println("Array: " + Arrays.toString(numbers));
        
        // Task 1: Sum (FOR-EACH - only reading)
        System.out.println("\nTask 1: Sum all elements");
        System.out.println("  Using: FOR-EACH (only reading values)");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("  Sum: " + sum);
        
        // Task 2: Index access (TRADITIONAL - need index)
        System.out.println("\nTask 2: Get element at index 3");
        System.out.println("  Using: TRADITIONAL FOR (need index access)");
        int index = 3;
        for (int i = 0; i < numbers.length; i++) {
            if (i == index) {
                System.out.println("  Element at index " + index + ": " + numbers[i]);
                break;
            }
        }
        
        // Task 3: Reverse (TRADITIONAL - need to modify by index)
        System.out.println("\nTask 3: Reverse array");
        System.out.println("  Using: TRADITIONAL FOR (need to modify by index)");
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }
        System.out.println("  Reversed: " + Arrays.toString(numbers));
        
        // Task 4: Check all positive (FOR-EACH - only checking)
        System.out.println("\nTask 4: Check all positive");
        System.out.println("  Using: FOR-EACH (only checking values)");
        boolean allPositive = true;
        for (int num : numbers) {
            if (num <= 0) {
                allPositive = false;
                break;
            }
        }
        System.out.println("  All positive? " + allPositive);
        
        // Task 5: Replace negatives (TRADITIONAL - need to modify)
        System.out.println("\nTask 5: Replace negatives with 0");
        System.out.println("  Using: TRADITIONAL FOR (need to modify elements)");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                numbers[i] = 0;
            }
        }
        System.out.println("  After replacement: " + Arrays.toString(numbers));
    }
}
```

**Key Learning:** Understanding when to use which loop type.

---

## 🎯 Bonus Challenges

### Bonus 1: Parallel For-Each (Workaround)
Process two arrays together using for-each and a counter variable.

### Bonus 2: Nested String Arrays
Create a 2D String array (like a seating chart) and print it using nested for-each.

### Bonus 3: Break Efficiency
Use break with for-each to find the first negative number and compare efficiency with processing all elements.

---

## 📝 Tips for For-Each Exercises

1. **Default to for-each** when you only need to read values
2. **Switch to traditional for** when you need to modify
3. **Remember the limitation** - can't modify array elements with for-each
4. **Use with 2D arrays** - outer loop gets rows, inner loop gets elements
5. **Works with Strings** - use `toCharArray()` first

---

## ✅ Self-Check Questions

After completing these exercises, you should be able to answer:

1. What does `for (int num : numbers)` read as in English?
2. Why can't you modify array elements using for-each?
3. When would you choose traditional for over for-each?
4. How do you use for-each with 2D arrays?
5. How do you iterate over characters in a String using for-each?

---

**Keep practicing!** Choose the right tool for the job. 🔄
