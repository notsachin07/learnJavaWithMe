# Class 4: Streams & Lambdas - Exercises ⚡

Master functional programming in Java with lambdas and the Stream API!

---

## 🟢 Easy Exercises

### Exercise 1: Lambda Comparators
**Goal:** Practice writing lambda expressions.

**Requirements:**
1. Create a list of strings
2. Sort by:
   - Alphabetical order
   - Length (shortest first)
   - Length (longest first)
   - Last character
3. Use lambda expressions for all comparators

**Test Data:**
```java
List<String> words = Arrays.asList("banana", "apple", "cherry", "date", "elderberry");
```

**Expected Output:**
```
Alphabetical: [apple, banana, cherry, date, elderberry]
By length (asc): [date, apple, banana, cherry, elderberry]
By length (desc): [elderberry, cherry, banana, apple, date]
By last char: [banana, apple, date, elderberry, cherry]
```

---

### Exercise 2: Filter and Map
**Goal:** Basic stream operations.

**Requirements:**
1. Start with a list of integers 1-20
2. Filter to keep only even numbers
3. Square each number
4. Collect to a list

**Expected Output:**
```
Original: [1, 2, 3, ..., 20]
Even squares: [4, 16, 36, 64, 100, 144, 196, 256, 324, 400]
```

---

### Exercise 3: String Processing
**Goal:** Transform strings with streams.

**Requirements:**
1. Start with a list of names (mixed case)
2. Filter names longer than 3 characters
3. Convert to uppercase
4. Sort alphabetically
5. Collect and print

**Test Data:**
```java
Arrays.asList("Jo", "Alice", "Bob", "Charlie", "Ann", "David")
```

**Expected Output:**
```
Processed: [ALICE, CHARLIE, DAVID]
```

---

## 🟡 Medium Exercises

### Exercise 4: Statistics Calculator
**Goal:** Use stream reduction operations.

**Requirements:**
1. Create a list of integers
2. Calculate using streams:
   - Sum
   - Average
   - Min
   - Max
   - Count of even numbers
   - Count of numbers > average

**Test Data:**
```java
List<Integer> numbers = Arrays.asList(5, 12, 8, 19, 3, 15, 7, 22, 11, 9);
```

**Expected Output:**
```
Sum: 111
Average: 11.1
Min: 3
Max: 22
Even count: 3
Above average: 4
```

---

### Exercise 5: Word Frequency Counter
**Goal:** Group and count with collectors.

**Requirements:**
1. Take a string of text
2. Split into words (lowercase, ignore punctuation)
3. Count frequency of each word
4. Sort by frequency (descending)
5. Display top 5 words

**Test Input:**
```
"To be or not to be that is the question whether tis nobler to suffer"
```

**Expected Output:**
```
Word frequencies (top 5):
  to: 3
  be: 2
  or: 1
  not: 1
  that: 1
```

---

### Exercise 6: Employee Analytics
**Goal:** Complex grouping and aggregation.

**Requirements:**
1. Create Employee class (name, department, salary)
2. Create list of 10+ employees
3. Calculate:
   - Average salary by department
   - Highest paid employee per department
   - Total salary expense
   - Employees earning above company average
   - Department with highest average salary

**Expected Output:**
```
Average salary by dept:
  Engineering: $75,000
  Sales: $65,000
  HR: $55,000

Top earner per dept:
  Engineering: Alice ($95,000)
  Sales: Bob ($80,000)
  HR: Carol ($60,000)

Total expense: $650,000
Above average (>$65,000): [Alice, Bob, David, ...]
Top paying dept: Engineering
```

---

## 🔴 Hard Exercises

### Exercise 7: Transaction Analyzer
**Goal:** Complex stream pipelines.

**Requirements:**
1. Create Transaction class (id, type, amount, date, category)
2. Generate 50+ random transactions
3. Implement analytics:
   - Total by type (INCOME/EXPENSE)
   - Monthly totals
   - Top spending categories
   - Running balance over time
   - Largest transaction per category
   - Average transaction by day of week

**Sample Output:**
```
=== Transaction Analysis ===

By Type:
  INCOME: $15,230.00
  EXPENSE: $12,450.00
  Net: $2,780.00

Monthly Summary:
  January: +$1,200.00
  February: -$450.00
  ...

Top Spending Categories:
  1. Food: $3,200.00
  2. Transportation: $1,800.00
  3. Entertainment: $1,200.00

Day of Week Averages:
  Monday: $85.50
  Tuesday: $92.30
  ...
```

---

### Exercise 8: Parallel Stream Performance
**Goal:** Understand parallel processing.

**Requirements:**
1. Create a computationally intensive operation
2. Process a large dataset (1 million items)
3. Compare sequential vs parallel streams
4. Measure execution time for both
5. Identify when parallel is beneficial

**Implementation:**
```java
// Sequential
long start = System.currentTimeMillis();
list.stream()
    .map(this::expensiveOperation)
    .collect(Collectors.toList());
long seqTime = System.currentTimeMillis() - start;

// Parallel
start = System.currentTimeMillis();
list.parallelStream()
    .map(this::expensiveOperation)
    .collect(Collectors.toList());
long parTime = System.currentTimeMillis() - start;
```

**Expected Output:**
```
Dataset size: 1,000,000 items

Simple operation (x * 2):
  Sequential: 45ms
  Parallel: 120ms (overhead not worth it)

Complex operation (isPrime):
  Sequential: 8,500ms
  Parallel: 2,100ms (4x speedup on 4 cores)
```

---

### Exercise 9: Custom Collector
**Goal:** Build your own collector.

**Requirements:**
1. Create a custom collector that:
   - Groups strings by first letter
   - Joins strings in each group with commas
   - Returns `Map<Character, String>`
2. Use `Collector.of()` to build it
3. Test with a list of words

**Usage:**
```java
List<String> words = Arrays.asList(
    "apple", "apricot", "banana", "blueberry", 
    "cherry", "coconut", "date"
);

Map<Character, String> result = words.stream()
    .collect(groupAndJoin());
```

**Expected Output:**
```
{
  a -> "apple, apricot"
  b -> "banana, blueberry"
  c -> "cherry, coconut"
  d -> "date"
}
```

---

## ✅ Bonus Challenge

Create a **Data Pipeline Framework** using streams:

**Features:**
1. **Pipeline Builder** - Fluent API for building data transformations
2. **Sources** - Read from List, File, or generate
3. **Transformations** - Filter, map, flatMap, distinct, sorted
4. **Aggregations** - Count, sum, average, group, partition
5. **Sinks** - Collect to List, write to File, print
6. **Metrics** - Track items processed, time taken

**Sample API:**
```java
Pipeline.from(transactions)
    .filter(t -> t.getAmount() > 100)
    .map(Transaction::getCategory)
    .groupBy(Function.identity())
    .count()
    .sortByValue(descending())
    .limit(10)
    .writeTo("top_categories.txt")
    .execute();

// Output
Pipeline Stats:
  Input records: 10,000
  Output records: 10
  Processing time: 45ms
  Memory used: 12MB
```

**Advanced Features:**
- Error handling with fallback values
- Progress reporting for large datasets
- Checkpointing for resumable processing
- Custom transformations via lambda

---

Happy coding! 💻
