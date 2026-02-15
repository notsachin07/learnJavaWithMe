# Class 2: Collections 📦

Welcome to **Phase 4, Class 2**! In this class, you'll learn about **Collections** - dynamic data structures that can grow and shrink as needed, replacing the limitations of fixed-size arrays.

---

## Table of Contents
1. [Why Collections?](#why-collections)
2. [The Collections Framework](#the-collections-framework)
3. [ArrayList](#arraylist)
4. [LinkedList](#linkedlist)
5. [HashSet](#hashset)
6. [HashMap](#hashmap)
7. [Iterating Collections](#iterating-collections)
8. [Generics](#generics)
9. [Useful Methods](#useful-methods)
10. [Choosing the Right Collection](#choosing-the-right-collection)
11. [Common Mistakes](#common-mistakes)
12. [Summary](#summary)

---

## Why Collections?

Arrays have limitations:
- Fixed size (can't grow or shrink)
- No built-in methods for searching, sorting, etc.
- Can't easily remove elements

Collections solve these problems!

### Array vs ArrayList

```java
// Array - fixed size
String[] arr = new String[3];
arr[0] = "A";
arr[1] = "B";
// arr[3] = "D";  // Error! Can't add more

// ArrayList - dynamic size
ArrayList<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add("C");
list.add("D");  // No problem!
```

---

## The Collections Framework

```
                    Collection (interface)
                    /         |         \
                List       Set        Queue
               /    \        |           |
        ArrayList  LinkedList  HashSet   PriorityQueue
        
                    Map (interface)
                      |
                   HashMap
```

| Interface | Description | Duplicates? | Ordered? |
|-----------|-------------|-------------|----------|
| `List` | Ordered sequence | Yes | Yes |
| `Set` | Unique elements | No | No* |
| `Map` | Key-value pairs | Keys: No | No* |
| `Queue` | FIFO structure | Yes | Yes |

*LinkedHashSet and LinkedHashMap maintain insertion order

---

## ArrayList

The most commonly used collection. A resizable array.

### Import

```java
import java.util.ArrayList;
```

### Creating an ArrayList

```java
// Empty list
ArrayList<String> names = new ArrayList<>();

// With initial capacity
ArrayList<Integer> numbers = new ArrayList<>(100);

// From another collection
ArrayList<String> copy = new ArrayList<>(names);
```

### Common Operations

```java
ArrayList<String> fruits = new ArrayList<>();

// Add elements
fruits.add("Apple");           // Add to end
fruits.add(0, "Banana");       // Add at index

// Access elements
String first = fruits.get(0);  // Get by index
int size = fruits.size();      // Get size

// Modify elements
fruits.set(0, "Blueberry");    // Replace at index

// Remove elements
fruits.remove("Apple");        // Remove by value
fruits.remove(0);              // Remove by index

// Search
boolean hasApple = fruits.contains("Apple");
int index = fruits.indexOf("Banana");  // -1 if not found

// Clear all
fruits.clear();
```

### Example: Managing a Shopping List

```java
ArrayList<String> shopping = new ArrayList<>();

// Add items
shopping.add("Milk");
shopping.add("Bread");
shopping.add("Eggs");
shopping.add("Butter");

System.out.println("Shopping list: " + shopping);
// [Milk, Bread, Eggs, Butter]

// Remove purchased item
shopping.remove("Bread");
System.out.println("After buying bread: " + shopping);
// [Milk, Eggs, Butter]

// Check if we need milk
if (shopping.contains("Milk")) {
    System.out.println("Don't forget the milk!");
}
```

---

## LinkedList

Similar to ArrayList but optimized for insertions/deletions.

```java
import java.util.LinkedList;

LinkedList<String> queue = new LinkedList<>();

// Add to end
queue.addLast("First");
queue.addLast("Second");

// Add to front
queue.addFirst("Zero");

// Remove from front (queue behavior)
String first = queue.removeFirst();

// Remove from end (stack behavior)
String last = queue.removeLast();
```

### When to Use LinkedList vs ArrayList

| Operation | ArrayList | LinkedList |
|-----------|-----------|------------|
| Get by index | O(1) Fast | O(n) Slow |
| Add to end | O(1) Fast | O(1) Fast |
| Add to middle | O(n) Slow | O(1) Fast* |
| Remove from middle | O(n) Slow | O(1) Fast* |

*After finding the position

---

## HashSet

Stores **unique** elements only. No duplicates allowed.

```java
import java.util.HashSet;

HashSet<String> colors = new HashSet<>();

colors.add("Red");
colors.add("Blue");
colors.add("Green");
colors.add("Red");  // Ignored! Already exists

System.out.println(colors);  // [Red, Blue, Green]
System.out.println(colors.size());  // 3
```

### Common Operations

```java
HashSet<Integer> numbers = new HashSet<>();

// Add elements
numbers.add(10);
numbers.add(20);
numbers.add(30);

// Check membership (very fast!)
boolean hasTen = numbers.contains(10);  // true

// Remove
numbers.remove(20);

// Size
int count = numbers.size();
```

### Use Case: Finding Unique Values

```java
int[] data = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};

HashSet<Integer> unique = new HashSet<>();
for (int num : data) {
    unique.add(num);
}

System.out.println("Unique values: " + unique);  // [1, 2, 3, 4]
```

---

## HashMap

Stores **key-value pairs**. Each key maps to exactly one value.

```java
import java.util.HashMap;

HashMap<String, Integer> ages = new HashMap<>();

// Add entries
ages.put("Alice", 25);
ages.put("Bob", 30);
ages.put("Charlie", 35);

// Get value by key
int aliceAge = ages.get("Alice");  // 25

// Check if key exists
boolean hasBob = ages.containsKey("Bob");  // true

// Get with default value
int unknownAge = ages.getOrDefault("Unknown", 0);  // 0
```

### Common Operations

```java
HashMap<String, Double> prices = new HashMap<>();

// Add/update
prices.put("Apple", 1.50);
prices.put("Banana", 0.75);
prices.put("Apple", 1.75);  // Updates existing key!

// Remove
prices.remove("Banana");

// Get all keys
Set<String> items = prices.keySet();

// Get all values
Collection<Double> allPrices = prices.values();

// Get all entries
for (Map.Entry<String, Double> entry : prices.entrySet()) {
    System.out.println(entry.getKey() + ": $" + entry.getValue());
}
```

### Use Case: Word Counter

```java
String text = "the quick brown fox jumps over the lazy dog the fox";
String[] words = text.split(" ");

HashMap<String, Integer> wordCount = new HashMap<>();

for (String word : words) {
    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
}

System.out.println(wordCount);
// {the=3, quick=1, brown=1, fox=2, jumps=1, over=1, lazy=1, dog=1}
```

---

## Iterating Collections

### For-Each Loop (Recommended)

```java
ArrayList<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");

for (String name : names) {
    System.out.println(name);
}
```

### Iterator

```java
import java.util.Iterator;

Iterator<String> it = names.iterator();
while (it.hasNext()) {
    String name = it.next();
    System.out.println(name);
    
    // Safe removal during iteration
    if (name.equals("Bob")) {
        it.remove();
    }
}
```

### forEach with Lambda (Java 8+)

```java
names.forEach(name -> System.out.println(name));

// Or method reference
names.forEach(System.out::println);
```

### Iterating HashMap

```java
HashMap<String, Integer> map = new HashMap<>();

// Keys only
for (String key : map.keySet()) {
    System.out.println(key);
}

// Values only
for (Integer value : map.values()) {
    System.out.println(value);
}

// Both
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```

---

## Generics

Generics provide **type safety** at compile time.

### Without Generics (Bad)

```java
ArrayList list = new ArrayList();  // Raw type
list.add("Hello");
list.add(123);  // No compile error!

String s = (String) list.get(1);  // Runtime error!
```

### With Generics (Good)

```java
ArrayList<String> list = new ArrayList<>();
list.add("Hello");
// list.add(123);  // Compile error! Type safety

String s = list.get(0);  // No cast needed
```

### Generic Methods

```java
public static <T> void printAll(ArrayList<T> list) {
    for (T item : list) {
        System.out.println(item);
    }
}
```

### Bounded Generics

```java
// Only accept Number or subclasses
public static <T extends Number> double sum(ArrayList<T> numbers) {
    double total = 0;
    for (T num : numbers) {
        total += num.doubleValue();
    }
    return total;
}
```

---

## Useful Methods

### Collections Utility Class

```java
import java.util.Collections;

ArrayList<Integer> nums = new ArrayList<>();
nums.add(3);
nums.add(1);
nums.add(4);
nums.add(1);
nums.add(5);

// Sort
Collections.sort(nums);  // [1, 1, 3, 4, 5]

// Reverse
Collections.reverse(nums);  // [5, 4, 3, 1, 1]

// Shuffle
Collections.shuffle(nums);  // Random order

// Min/Max
int min = Collections.min(nums);
int max = Collections.max(nums);

// Frequency
int count = Collections.frequency(nums, 1);  // 2
```

### List Methods

```java
ArrayList<String> list = new ArrayList<>();

// Check empty
boolean empty = list.isEmpty();

// Convert to array
String[] arr = list.toArray(new String[0]);

// Sublist
List<String> sub = list.subList(0, 2);

// Add all from another collection
list.addAll(anotherList);

// Remove all matching
list.removeIf(s -> s.startsWith("A"));
```

---

## Choosing the Right Collection

| Need | Use |
|------|-----|
| Ordered list with duplicates | `ArrayList` |
| Fast add/remove at ends | `LinkedList` |
| Unique elements | `HashSet` |
| Unique + ordered | `LinkedHashSet` |
| Unique + sorted | `TreeSet` |
| Key-value mapping | `HashMap` |
| Sorted key-value | `TreeMap` |
| Thread-safe list | `CopyOnWriteArrayList` |
| Thread-safe map | `ConcurrentHashMap` |

---

## Common Mistakes

### ❌ Modifying While Iterating

```java
// BAD - ConcurrentModificationException
for (String s : list) {
    if (s.equals("remove")) {
        list.remove(s);  // Crashes!
    }
}

// GOOD - Use Iterator
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    if (it.next().equals("remove")) {
        it.remove();  // Safe!
    }
}

// GOOD - Use removeIf (Java 8+)
list.removeIf(s -> s.equals("remove"));
```

### ❌ Using Raw Types

```java
// BAD
ArrayList list = new ArrayList();

// GOOD
ArrayList<String> list = new ArrayList<>();
```

### ❌ Null Keys in HashMap

```java
HashMap<String, Integer> map = new HashMap<>();
map.put(null, 10);  // Works but can cause issues

// Always check for null keys if uncertain
if (key != null) {
    map.put(key, value);
}
```

### ❌ Forgetting equals/hashCode

```java
// If you use custom objects in HashSet/HashMap,
// you MUST override equals() and hashCode()!

class Person {
    String name;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
```

---

## Summary

| Collection | Description | Key Methods |
|------------|-------------|-------------|
| `ArrayList` | Dynamic array | `add`, `get`, `remove`, `size` |
| `LinkedList` | Doubly-linked list | `addFirst`, `addLast`, `removeFirst` |
| `HashSet` | Unique elements | `add`, `contains`, `remove` |
| `HashMap` | Key-value pairs | `put`, `get`, `containsKey`, `keySet` |

### Quick Reference

```java
// ArrayList
ArrayList<String> list = new ArrayList<>();
list.add("item");
String item = list.get(0);

// HashSet
HashSet<String> set = new HashSet<>();
set.add("item");
boolean exists = set.contains("item");

// HashMap
HashMap<String, Integer> map = new HashMap<>();
map.put("key", 100);
int value = map.get("key");
```

---

**Congratulations!** You now know how to use Java's powerful Collections framework. Next up: **File I/O** - reading and writing files! 🚀
