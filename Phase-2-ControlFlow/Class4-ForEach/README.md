# Class 4: Enhanced For-Each Loop 🔄

Welcome to **Phase 2, Class 4**! In this class, you'll take a deeper dive into the **enhanced for-each loop** - a cleaner, more readable way to iterate through arrays and collections. You've seen it briefly, now let's master it!

---

## 📌 What You'll Learn

- The for-each loop syntax in detail
- When to use for-each vs traditional for
- Working with different data types
- Limitations and pitfalls
- For-each with 2D arrays
- For-each with Strings
- Best practices and common patterns

---

## 🎯 Why For-Each Matters

The for-each loop (also called "enhanced for loop") was introduced in Java 5 to:
- **Simplify iteration** - No index management needed
- **Reduce errors** - No off-by-one mistakes
- **Improve readability** - Code is cleaner and more expressive
- **Prevent bugs** - Can't accidentally go out of bounds

---

## 📋 Syntax Comparison

### Traditional For Loop
```java
int[] numbers = {10, 20, 30, 40, 50};

for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

### For-Each Loop
```java
int[] numbers = {10, 20, 30, 40, 50};

for (int num : numbers) {
    System.out.println(num);
}
```

**Read it as:** "For each `num` in `numbers`, do..."

---

## 🔍 For-Each Anatomy

```java
for (ElementType element : collection) {
    // use element
}
```

| Part | Description | Example |
|------|-------------|---------|
| **ElementType** | Data type of elements in collection | `int`, `String`, `double` |
| **element** | Variable name for current element | `num`, `name`, `item` |
| **:** | Reads as "in" | "for each num IN numbers" |
| **collection** | The array or collection to iterate | `numbers`, `names` |

---

## 1️⃣ For-Each with Different Types

### With Integers
```java
int[] numbers = {1, 2, 3, 4, 5};

for (int num : numbers) {
    System.out.print(num + " ");
}
// Output: 1 2 3 4 5
```

### With Doubles
```java
double[] prices = {19.99, 29.99, 9.99, 49.99};

double total = 0;
for (double price : prices) {
    total += price;
}
System.out.println("Total: $" + total);
// Output: Total: $109.96
```

### With Strings
```java
String[] names = {"Alice", "Bob", "Charlie"};

for (String name : names) {
    System.out.println("Hello, " + name + "!");
}
// Output:
// Hello, Alice!
// Hello, Bob!
// Hello, Charlie!
```

### With Booleans
```java
boolean[] flags = {true, false, true, true, false};

int trueCount = 0;
for (boolean flag : flags) {
    if (flag) {
        trueCount++;
    }
}
System.out.println("True count: " + trueCount);
// Output: True count: 3
```

### With Characters
```java
char[] vowels = {'a', 'e', 'i', 'o', 'u'};

System.out.print("Vowels: ");
for (char vowel : vowels) {
    System.out.print(vowel + " ");
}
// Output: Vowels: a e i o u
```

---

## 2️⃣ For-Each vs Traditional For Loop

### Use For-Each When:

✅ You only need to **read** elements  
✅ You need to process **all** elements  
✅ You don't need the **index**  
✅ You're iterating **forward** only  

```java
// Perfect for-each use case: calculate sum
int[] numbers = {1, 2, 3, 4, 5};
int sum = 0;

for (int num : numbers) {
    sum += num;
}
```

### Use Traditional For When:

✅ You need to **modify** the array  
✅ You need the **index** for something  
✅ You need to iterate **backwards**  
✅ You need to **skip** certain indices  
✅ You need to iterate over **multiple arrays** simultaneously  

```java
// Need to modify: use traditional for
int[] numbers = {1, 2, 3, 4, 5};

for (int i = 0; i < numbers.length; i++) {
    numbers[i] = numbers[i] * 2;  // Double each element
}
```

---

## 3️⃣ Comparison Table

| Feature | For-Each | Traditional For |
|---------|----------|-----------------|
| Read elements | ✅ Yes | ✅ Yes |
| Modify elements | ❌ No | ✅ Yes |
| Access index | ❌ No | ✅ Yes |
| Go backwards | ❌ No | ✅ Yes |
| Skip elements | ❌ No | ✅ Yes |
| Multiple arrays | ❌ No | ✅ Yes |
| Cleaner syntax | ✅ Yes | ❌ No |
| Less error-prone | ✅ Yes | ❌ No |

---

## ⚠️ Common Pitfall: Cannot Modify Array Elements

This is the **#1 mistake** beginners make with for-each:

```java
int[] numbers = {1, 2, 3, 4, 5};

// THIS DOES NOT WORK!
for (int num : numbers) {
    num = num * 2;  // Only modifies local copy!
}

System.out.println(Arrays.toString(numbers));
// Output: [1, 2, 3, 4, 5]  ← NOT modified!
```

### Why?

The variable `num` is a **copy** of the array element, not a reference to it. Modifying `num` only changes the copy.

### The Fix: Use Traditional For Loop

```java
int[] numbers = {1, 2, 3, 4, 5};

for (int i = 0; i < numbers.length; i++) {
    numbers[i] = numbers[i] * 2;  // Modifies actual array
}

System.out.println(Arrays.toString(numbers));
// Output: [2, 4, 6, 8, 10]  ← Modified!
```

---

## 4️⃣ For-Each with 2D Arrays

For-each works great with 2D arrays using **nested loops**:

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// The outer loop gets each row (which is an int[])
for (int[] row : matrix) {
    // The inner loop gets each element in that row
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

### Understanding the Types

```java
int[][] matrix = {...};

for (int[] row : matrix) {    // row is int[] (a 1D array)
    for (int val : row) {     // val is int (a single element)
        // process val
    }
}
```

### Sum of All Elements in 2D Array

```java
int[][] grid = {
    {1, 2, 3},
    {4, 5, 6}
};

int sum = 0;
for (int[] row : grid) {
    for (int value : row) {
        sum += value;
    }
}
System.out.println("Sum: " + sum);  // Sum: 21
```

---

## 5️⃣ For-Each with Strings

### Iterating Over Characters in a String

Strings don't directly support for-each, but you can convert to a char array:

```java
String text = "Hello";

// Method 1: Convert to char array
for (char c : text.toCharArray()) {
    System.out.print(c + " ");
}
// Output: H e l l o

// Method 2: Traditional for (more efficient for long strings)
for (int i = 0; i < text.length(); i++) {
    System.out.print(text.charAt(i) + " ");
}
```

### Counting Specific Characters

```java
String sentence = "Mississippi";
int countS = 0;

for (char c : sentence.toCharArray()) {
    if (c == 's') {
        countS++;
    }
}
System.out.println("Number of 's': " + countS);
// Output: Number of 's': 4
```

### Processing Array of Strings

```java
String[] words = {"apple", "banana", "cherry"};

for (String word : words) {
    System.out.println(word + " has " + word.length() + " letters");
}
// Output:
// apple has 5 letters
// banana has 6 letters
// cherry has 6 letters
```

---

## 6️⃣ Practical Examples

### Example 1: Calculate Average

```java
public static double calculateAverage(int[] numbers) {
    if (numbers.length == 0) return 0;
    
    int sum = 0;
    for (int num : numbers) {
        sum += num;
    }
    return (double) sum / numbers.length;
}

// Usage
int[] scores = {85, 90, 78, 92, 88};
System.out.println("Average: " + calculateAverage(scores));
```

### Example 2: Find an Element

```java
public static boolean contains(int[] array, int target) {
    for (int element : array) {
        if (element == target) {
            return true;
        }
    }
    return false;
}

// Usage
int[] numbers = {1, 5, 10, 15, 20};
System.out.println(contains(numbers, 10));  // true
System.out.println(contains(numbers, 7));   // false
```

### Example 3: Count Matches

```java
public static int countGreaterThan(int[] array, int threshold) {
    int count = 0;
    for (int num : array) {
        if (num > threshold) {
            count++;
        }
    }
    return count;
}

// Usage
int[] values = {5, 12, 8, 20, 3, 15};
System.out.println(countGreaterThan(values, 10));  // 3
```

### Example 4: Find Maximum

```java
public static int findMax(int[] array) {
    if (array.length == 0) {
        throw new IllegalArgumentException("Array is empty");
    }
    
    int max = array[0];
    for (int num : array) {
        if (num > max) {
            max = num;
        }
    }
    return max;
}
```

### Example 5: String Array Processing

```java
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

// Usage
String[] animals = {"cat", "elephant", "dog", "hippopotamus"};
System.out.println(findLongestWord(animals));  // hippopotamus
```

### Example 6: Joining Strings

```java
public static String joinWithComma(String[] words) {
    if (words.length == 0) return "";
    
    StringBuilder result = new StringBuilder();
    for (String word : words) {
        if (result.length() > 0) {
            result.append(", ");
        }
        result.append(word);
    }
    return result.toString();
}

// Usage
String[] fruits = {"apple", "banana", "orange"};
System.out.println(joinWithComma(fruits));  // apple, banana, orange
```

---

## 7️⃣ Using break and continue with For-Each

### break - Exit Early

```java
String[] names = {"Alice", "Bob", "Charlie", "Diana"};

for (String name : names) {
    if (name.equals("Charlie")) {
        System.out.println("Found Charlie!");
        break;  // Exit loop
    }
    System.out.println("Checking: " + name);
}
// Output:
// Checking: Alice
// Checking: Bob
// Found Charlie!
```

### continue - Skip Current Iteration

```java
int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

System.out.print("Odd numbers: ");
for (int num : numbers) {
    if (num % 2 == 0) {
        continue;  // Skip even numbers
    }
    System.out.print(num + " ");
}
// Output: Odd numbers: 1 3 5 7 9
```

---

## 8️⃣ When You MUST Use Index

Sometimes you need the index. Here's how to handle it:

### Option 1: Use Traditional For Loop

```java
String[] items = {"A", "B", "C", "D"};

for (int i = 0; i < items.length; i++) {
    System.out.println("Item " + i + ": " + items[i]);
}
```

### Option 2: Track Index Manually

```java
String[] items = {"A", "B", "C", "D"};
int index = 0;

for (String item : items) {
    System.out.println("Item " + index + ": " + item);
    index++;
}
```

### Option 3: Parallel Arrays

When processing two arrays together, use traditional for:

```java
String[] names = {"Alice", "Bob", "Charlie"};
int[] scores = {85, 92, 78};

for (int i = 0; i < names.length; i++) {
    System.out.println(names[i] + ": " + scores[i]);
}
```

---

## 📊 Decision Guide

```
Do you need to MODIFY elements?
├── YES → Use traditional for loop
└── NO
    └── Do you need the INDEX?
        ├── YES → Use traditional for loop
        └── NO
            └── Do you need to go BACKWARDS or SKIP?
                ├── YES → Use traditional for loop
                └── NO → Use FOR-EACH ✅
```

---

## ⚠️ Common Mistakes

### 1. Trying to Modify Elements
```java
// WRONG - doesn't modify array
for (int num : numbers) {
    num = num * 2;
}
```

### 2. Trying to Get Index
```java
// WRONG - no index available
for (String name : names) {
    System.out.println("Index: " + ???);  // No way to get index!
}
```

### 3. Modifying Collection While Iterating
```java
// This can cause issues with some collections
// (less of a problem with arrays, but be careful)
```

### 4. Forgetting the Correct Type
```java
int[][] matrix = {{1, 2}, {3, 4}};

// WRONG - outer loop element is int[], not int
for (int row : matrix) { ... }  // Compile error!

// CORRECT
for (int[] row : matrix) { ... }
```

---

## 📝 Key Takeaways

1. **For-each is for reading** - Use it when you don't need to modify
2. **Cleaner syntax** - No index management, no bounds checking
3. **Cannot modify** - Changes to the loop variable don't affect the array
4. **No index access** - If you need the index, use traditional for
5. **Works with 2D arrays** - Nested for-each loops
6. **Works with Strings** - Use `toCharArray()`
7. **break and continue work** - Just like regular loops
8. **Choose wisely** - Use the right loop for the job

---

## 🔗 What's Next?

In **Class 5**, you'll learn about **Debugging & Best Practices** - essential skills for finding and fixing bugs, and writing clean, maintainable code!

---

**Keep practicing!** 🔄  
The for-each loop will become your go-to for simple iterations!
