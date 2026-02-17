# Class 4: Streams & Lambdas ⚡

Welcome to **Phase 4, Class 4**! In this class, you'll learn about **lambda expressions** and the **Stream API** - modern Java features that enable functional programming and cleaner, more expressive code.

---

## Table of Contents
1. [Why Lambdas and Streams?](#why-lambdas-and-streams)
2. [Lambda Expressions](#lambda-expressions)
3. [Functional Interfaces](#functional-interfaces)
4. [Method References](#method-references)
5. [Introduction to Streams](#introduction-to-streams)
6. [Stream Operations](#stream-operations)
7. [Filtering and Mapping](#filtering-and-mapping)
8. [Reducing and Collecting](#reducing-and-collecting)
9. [Common Stream Patterns](#common-stream-patterns)
10. [Optional Class](#optional-class)
11. [Best Practices](#best-practices)
12. [Summary](#summary)

---

## Why Lambdas and Streams?

### Before (Verbose)

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// Filter names starting with 'A'
List<String> filtered = new ArrayList<>();
for (String name : names) {
    if (name.startsWith("A")) {
        filtered.add(name);
    }
}

// Convert to uppercase
List<String> upper = new ArrayList<>();
for (String name : filtered) {
    upper.add(name.toUpperCase());
}
```

### After (Clean & Expressive)

```java
List<String> result = names.stream()
    .filter(name -> name.startsWith("A"))
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

---

## Lambda Expressions

A **lambda** is an anonymous function - a function without a name.

### Syntax

```java
(parameters) -> expression

(parameters) -> { statements; }
```

### Examples

```java
// No parameters
() -> System.out.println("Hello")

// One parameter (parentheses optional)
x -> x * 2
(x) -> x * 2

// Multiple parameters
(a, b) -> a + b

// Multiple statements (need braces and return)
(a, b) -> {
    int sum = a + b;
    return sum;
}
```

### Practical Examples

```java
// Comparator
Comparator<String> byLength = (s1, s2) -> s1.length() - s2.length();

// Runnable
Runnable task = () -> System.out.println("Running!");

// ActionListener
button.addActionListener(e -> System.out.println("Clicked!"));
```

---

## Functional Interfaces

A **functional interface** has exactly ONE abstract method. Lambdas implement these interfaces.

### Built-in Functional Interfaces

| Interface | Method | Description |
|-----------|--------|-------------|
| `Predicate<T>` | `test(T t)` → boolean | Test a condition |
| `Function<T,R>` | `apply(T t)` → R | Transform T to R |
| `Consumer<T>` | `accept(T t)` | Use T, return nothing |
| `Supplier<T>` | `get()` → T | Provide T |
| `BiFunction<T,U,R>` | `apply(T,U)` → R | Two inputs, one output |

### Examples

```java
import java.util.function.*;

// Predicate - test condition
Predicate<Integer> isEven = n -> n % 2 == 0;
System.out.println(isEven.test(4));  // true

// Function - transform
Function<String, Integer> length = s -> s.length();
System.out.println(length.apply("Hello"));  // 5

// Consumer - use value
Consumer<String> printer = s -> System.out.println(s);
printer.accept("Hello");  // prints "Hello"

// Supplier - provide value
Supplier<Double> random = () -> Math.random();
System.out.println(random.get());  // random number
```

### Custom Functional Interface

```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

Calculator add = (a, b) -> a + b;
Calculator multiply = (a, b) -> a * b;

System.out.println(add.calculate(5, 3));      // 8
System.out.println(multiply.calculate(5, 3)); // 15
```

---

## Method References

A shorter syntax for lambdas that call existing methods.

### Types of Method References

| Type | Lambda | Method Reference |
|------|--------|------------------|
| Static method | `x -> Math.abs(x)` | `Math::abs` |
| Instance method | `s -> s.toUpperCase()` | `String::toUpperCase` |
| Instance of object | `x -> obj.process(x)` | `obj::process` |
| Constructor | `s -> new String(s)` | `String::new` |

### Examples

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// Lambda
names.forEach(name -> System.out.println(name));

// Method reference (same thing!)
names.forEach(System.out::println);

// Transformations
names.stream()
     .map(String::toUpperCase)    // Instead of s -> s.toUpperCase()
     .forEach(System.out::println);
```

---

## Introduction to Streams

A **Stream** is a sequence of elements that supports sequential and parallel operations.

### Creating Streams

```java
// From collection
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream1 = list.stream();

// From array
String[] array = {"a", "b", "c"};
Stream<String> stream2 = Arrays.stream(array);

// From values
Stream<String> stream3 = Stream.of("a", "b", "c");

// From range
IntStream range = IntStream.range(1, 10);      // 1 to 9
IntStream rangeClosed = IntStream.rangeClosed(1, 10);  // 1 to 10

// Infinite stream (be careful!)
Stream<Integer> infinite = Stream.iterate(0, n -> n + 1);
```

### Stream Pipeline

```
Source → Intermediate Operations → Terminal Operation
         (lazy, return Stream)     (triggers execution)
```

```java
list.stream()           // Source
    .filter(...)        // Intermediate
    .map(...)           // Intermediate
    .sorted()           // Intermediate
    .collect(...);      // Terminal
```

---

## Stream Operations

### Intermediate Operations (Lazy)

| Operation | Description |
|-----------|-------------|
| `filter(Predicate)` | Keep elements matching condition |
| `map(Function)` | Transform each element |
| `flatMap(Function)` | Flatten nested structures |
| `sorted()` | Sort elements |
| `distinct()` | Remove duplicates |
| `limit(n)` | Take first n elements |
| `skip(n)` | Skip first n elements |
| `peek(Consumer)` | Debug/inspect elements |

### Terminal Operations (Eager)

| Operation | Description |
|-----------|-------------|
| `forEach(Consumer)` | Process each element |
| `collect(Collector)` | Collect to collection |
| `reduce(BinaryOperator)` | Combine elements |
| `count()` | Count elements |
| `findFirst()` | Get first element (Optional) |
| `findAny()` | Get any element (Optional) |
| `anyMatch(Predicate)` | Any element matches? |
| `allMatch(Predicate)` | All elements match? |
| `noneMatch(Predicate)` | No elements match? |
| `min(Comparator)` | Find minimum |
| `max(Comparator)` | Find maximum |

---

## Filtering and Mapping

### filter()

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Keep even numbers
List<Integer> evens = numbers.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());
// [2, 4, 6, 8, 10]

// Multiple conditions
List<Integer> result = numbers.stream()
    .filter(n -> n > 3)
    .filter(n -> n < 8)
    .collect(Collectors.toList());
// [4, 5, 6, 7]
```

### map()

```java
List<String> names = Arrays.asList("alice", "bob", "charlie");

// Transform to uppercase
List<String> upper = names.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
// [ALICE, BOB, CHARLIE]

// Get lengths
List<Integer> lengths = names.stream()
    .map(String::length)
    .collect(Collectors.toList());
// [5, 3, 7]
```

### flatMap()

```java
List<List<Integer>> nested = Arrays.asList(
    Arrays.asList(1, 2),
    Arrays.asList(3, 4),
    Arrays.asList(5, 6)
);

// Flatten
List<Integer> flat = nested.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList());
// [1, 2, 3, 4, 5, 6]

// Words from sentences
List<String> sentences = Arrays.asList("Hello World", "Java Streams");
List<String> words = sentences.stream()
    .flatMap(s -> Arrays.stream(s.split(" ")))
    .collect(Collectors.toList());
// [Hello, World, Java, Streams]
```

---

## Reducing and Collecting

### reduce()

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Sum
int sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);
// 15

// Using method reference
int sum2 = numbers.stream()
    .reduce(0, Integer::sum);

// Product
int product = numbers.stream()
    .reduce(1, (a, b) -> a * b);
// 120

// Max (returns Optional)
Optional<Integer> max = numbers.stream()
    .reduce(Integer::max);
```

### collect() with Collectors

```java
import java.util.stream.Collectors;

List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Alice");

// To List
List<String> list = names.stream()
    .collect(Collectors.toList());

// To Set (removes duplicates)
Set<String> set = names.stream()
    .collect(Collectors.toSet());

// To Map
Map<String, Integer> nameLengths = names.stream()
    .distinct()
    .collect(Collectors.toMap(
        name -> name,           // key
        name -> name.length()   // value
    ));
// {Alice=5, Bob=3, Charlie=7}

// Joining strings
String joined = names.stream()
    .collect(Collectors.joining(", "));
// "Alice, Bob, Charlie, Alice"

// Grouping
Map<Integer, List<String>> byLength = names.stream()
    .collect(Collectors.groupingBy(String::length));
// {3=[Bob], 5=[Alice, Alice], 7=[Charlie]}

// Counting
Map<String, Long> counts = names.stream()
    .collect(Collectors.groupingBy(
        name -> name,
        Collectors.counting()
    ));
// {Alice=2, Bob=1, Charlie=1}

// Statistics
IntSummaryStatistics stats = names.stream()
    .collect(Collectors.summarizingInt(String::length));
// count=4, sum=20, min=3, average=5.0, max=7
```

---

## Common Stream Patterns

### Find First Match

```java
Optional<String> first = names.stream()
    .filter(n -> n.startsWith("A"))
    .findFirst();

first.ifPresent(System.out::println);
```

### Check Conditions

```java
boolean anyMatch = names.stream()
    .anyMatch(n -> n.length() > 5);  // Any name longer than 5?

boolean allMatch = names.stream()
    .allMatch(n -> n.length() > 2);  // All names longer than 2?

boolean noneMatch = names.stream()
    .noneMatch(n -> n.isEmpty());    // No empty names?
```

### Sorting

```java
// Natural order
List<String> sorted = names.stream()
    .sorted()
    .collect(Collectors.toList());

// Custom comparator
List<String> byLength = names.stream()
    .sorted(Comparator.comparingInt(String::length))
    .collect(Collectors.toList());

// Reversed
List<String> reversed = names.stream()
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.toList());
```

### Distinct and Limit

```java
List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4);

// Remove duplicates
List<Integer> unique = numbers.stream()
    .distinct()
    .collect(Collectors.toList());
// [1, 2, 3, 4]

// First 3
List<Integer> firstThree = numbers.stream()
    .limit(3)
    .collect(Collectors.toList());
// [1, 2, 2]

// Skip first 2
List<Integer> skipped = numbers.stream()
    .skip(2)
    .collect(Collectors.toList());
// [2, 3, 3, 3, 4]
```

---

## Optional Class

`Optional` represents a value that may or may not be present.

### Creating Optional

```java
Optional<String> empty = Optional.empty();
Optional<String> present = Optional.of("Hello");
Optional<String> nullable = Optional.ofNullable(maybeNull);
```

### Using Optional

```java
Optional<String> opt = findName(id);

// Check presence
if (opt.isPresent()) {
    System.out.println(opt.get());
}

// Better: ifPresent
opt.ifPresent(System.out::println);

// Default value
String name = opt.orElse("Unknown");

// Default from supplier
String name2 = opt.orElseGet(() -> computeDefault());

// Throw if empty
String name3 = opt.orElseThrow(() -> new RuntimeException("Not found"));

// Transform
Optional<Integer> length = opt.map(String::length);

// Filter
Optional<String> longName = opt.filter(s -> s.length() > 5);
```

### Optional with Streams

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

Optional<String> first = names.stream()
    .filter(n -> n.startsWith("X"))
    .findFirst();

String result = first.orElse("None found");
```

---

## Best Practices

### ✅ Do

1. **Keep lambdas short** - One line if possible
2. **Use method references** when clearer
3. **Prefer built-in collectors** over manual reduction
4. **Use parallel() sparingly** - Only for large data and CPU-intensive ops
5. **Return Optional** instead of null

### ❌ Don't

1. **Don't reuse streams** - They can only be used once
2. **Don't modify external state** in lambdas
3. **Don't nest streams** excessively
4. **Don't overuse** - Simple loops are sometimes clearer

### Example: Good vs Bad

```java
// ❌ BAD: Modifying external state
List<String> results = new ArrayList<>();
names.stream().forEach(n -> results.add(n.toUpperCase()));

// ✅ GOOD: Pure function, collect result
List<String> results = names.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

```java
// ❌ BAD: Too complex
names.stream()
    .filter(n -> n != null)
    .filter(n -> !n.isEmpty())
    .filter(n -> n.length() > 3)
    .map(n -> n.toUpperCase())
    .map(n -> n.trim())
    .collect(Collectors.toList());

// ✅ GOOD: Combine predicates, extract to methods
names.stream()
    .filter(this::isValidName)
    .map(this::normalizeName)
    .collect(Collectors.toList());
```

---

## Summary

| Concept | Description |
|---------|-------------|
| Lambda | Anonymous function: `(params) -> expression` |
| Functional Interface | Interface with one abstract method |
| Method Reference | Shorthand: `Class::method` |
| Stream | Sequence supporting functional operations |
| Intermediate | Lazy operations returning Stream |
| Terminal | Eager operations producing result |
| Optional | Container for possibly absent value |

### Quick Reference

```java
// Lambda
list.forEach(item -> System.out.println(item));

// Method reference
list.forEach(System.out::println);

// Stream pipeline
List<String> result = list.stream()
    .filter(s -> s.length() > 3)
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());

// Optional
Optional<String> opt = list.stream().findFirst();
String value = opt.orElse("default");
```

---

**Congratulations!** You now know functional programming in Java. Next up: **Working with APIs** - connecting to web services! 🚀
