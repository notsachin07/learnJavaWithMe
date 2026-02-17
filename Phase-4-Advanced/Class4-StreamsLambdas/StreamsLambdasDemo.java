/**
 * Class 4: Streams & Lambdas - Complete Example
 *
 * Demonstrates:
 * - Lambda expressions
 * - Functional interfaces
 * - Method references
 * - Stream creation and operations
 * - Filtering, mapping, reducing
 * - Collectors
 * - Optional class
 *
 * How to compile and run:
 * $ javac StreamsLambdasDemo.java
 * $ java StreamsLambdasDemo
 */

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamsLambdasDemo {

    public static void main(String[] args) {
        System.out.println("========== STREAMS & LAMBDAS DEMO ==========\n");

        // ================================================
        // DEMONSTRATION 1: LAMBDA EXPRESSIONS
        // ================================================
        System.out.println("1. LAMBDA EXPRESSIONS");
        System.out.println("─────────────────────────────────────────");

        // Traditional anonymous class
        Comparator<String> oldWay = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };

        // Lambda expression
        Comparator<String> newWay = (s1, s2) -> s1.length() - s2.length();

        List<String> names = new ArrayList<>(Arrays.asList("Charlie", "Bob", "Alice", "David"));
        
        Collections.sort(names, newWay);
        System.out.println("Sorted by length: " + names);
        System.out.println();


        // ================================================
        // DEMONSTRATION 2: FUNCTIONAL INTERFACES
        // ================================================
        System.out.println("2. FUNCTIONAL INTERFACES");
        System.out.println("─────────────────────────────────────────");

        // Predicate<T> - test condition
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 7 even? " + isEven.test(7));

        // Function<T, R> - transform
        Function<String, Integer> getLength = String::length;
        System.out.println("Length of 'Hello': " + getLength.apply("Hello"));

        // Consumer<T> - use value
        Consumer<String> printer = s -> System.out.println("  → " + s);
        System.out.print("Printing: ");
        printer.accept("Hello from Consumer!");

        // Supplier<T> - provide value
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random: " + randomSupplier.get());
        System.out.println();


        // ================================================
        // DEMONSTRATION 3: METHOD REFERENCES
        // ================================================
        System.out.println("3. METHOD REFERENCES");
        System.out.println("─────────────────────────────────────────");

        List<String> fruits = Arrays.asList("apple", "banana", "cherry");

        System.out.println("Using lambda:");
        fruits.forEach(f -> System.out.println("  " + f));

        System.out.println("Using method reference:");
        fruits.stream()
              .map(String::toUpperCase)
              .forEach(f -> System.out.println("  " + f));
        System.out.println();


        // ================================================
        // DEMONSTRATION 4: STREAM BASICS
        // ================================================
        System.out.println("4. STREAM BASICS");
        System.out.println("─────────────────────────────────────────");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers
        List<Integer> evens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evens);

        // Map to squares
        List<Integer> squares = numbers.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());
        System.out.println("Squares: " + squares);

        // Sum
        int sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        System.out.println();


        // ================================================
        // DEMONSTRATION 5: CHAINED OPERATIONS
        // ================================================
        System.out.println("5. CHAINED OPERATIONS");
        System.out.println("─────────────────────────────────────────");

        List<String> words = Arrays.asList("hello", "world", "java", "streams", "are", "awesome");

        // Find words with length > 4, uppercase, sorted
        List<String> result = words.stream()
            .filter(w -> w.length() > 4)
            .map(String::toUpperCase)
            .sorted()
            .collect(Collectors.toList());
        
        System.out.println("Original: " + words);
        System.out.println("Filtered (>4), uppercase, sorted: " + result);
        System.out.println();


        // ================================================
        // DEMONSTRATION 6: FLATMAP
        // ================================================
        System.out.println("6. FLATMAP");
        System.out.println("─────────────────────────────────────────");

        List<List<Integer>> nested = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8, 9)
        );

        System.out.println("Nested: " + nested);

        List<Integer> flat = nested.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        
        System.out.println("Flattened: " + flat);

        // Words from sentences
        List<String> sentences = Arrays.asList(
            "Hello World",
            "Java is great",
            "Streams are powerful"
        );

        List<String> allWords = sentences.stream()
            .flatMap(s -> Arrays.stream(s.split(" ")))
            .collect(Collectors.toList());
        
        System.out.println("All words: " + allWords);
        System.out.println();


        // ================================================
        // DEMONSTRATION 7: COLLECTORS
        // ================================================
        System.out.println("7. COLLECTORS");
        System.out.println("─────────────────────────────────────────");

        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "Engineering"),
            new Person("Bob", 30, "Sales"),
            new Person("Charlie", 35, "Engineering"),
            new Person("Diana", 28, "Sales"),
            new Person("Eve", 22, "Engineering")
        );

        // Group by department
        Map<String, List<Person>> byDept = people.stream()
            .collect(Collectors.groupingBy(Person::getDepartment));
        
        System.out.println("Grouped by department:");
        byDept.forEach((dept, list) -> 
            System.out.println("  " + dept + ": " + list));

        // Average age by department
        Map<String, Double> avgAgeByDept = people.stream()
            .collect(Collectors.groupingBy(
                Person::getDepartment,
                Collectors.averagingInt(Person::getAge)
            ));
        
        System.out.println("Average age by department: " + avgAgeByDept);

        // Joining names
        String allNames = people.stream()
            .map(Person::getName)
            .collect(Collectors.joining(", "));
        
        System.out.println("All names: " + allNames);

        // Partitioning (age > 25)
        Map<Boolean, List<Person>> partitioned = people.stream()
            .collect(Collectors.partitioningBy(p -> p.getAge() > 25));
        
        System.out.println("Over 25: " + partitioned.get(true));
        System.out.println("25 or under: " + partitioned.get(false));
        System.out.println();


        // ================================================
        // DEMONSTRATION 8: REDUCE
        // ================================================
        System.out.println("8. REDUCE");
        System.out.println("─────────────────────────────────────────");

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        // Sum
        int sumResult = nums.stream()
            .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sumResult);

        // Product
        int product = nums.stream()
            .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);

        // Max
        Optional<Integer> max = nums.stream()
            .reduce(Integer::max);
        System.out.println("Max: " + max.orElse(0));

        // Concatenate strings
        List<String> letters = Arrays.asList("a", "b", "c", "d");
        String concat = letters.stream()
            .reduce("", (a, b) -> a + b);
        System.out.println("Concatenated: " + concat);
        System.out.println();


        // ================================================
        // DEMONSTRATION 9: OPTIONAL
        // ================================================
        System.out.println("9. OPTIONAL");
        System.out.println("─────────────────────────────────────────");

        List<String> nameList = Arrays.asList("Alice", "Bob", "Charlie");

        // Find first starting with 'A'
        Optional<String> found = nameList.stream()
            .filter(n -> n.startsWith("A"))
            .findFirst();
        
        System.out.println("Found: " + found.orElse("None"));

        // Find first starting with 'X' (not found)
        Optional<String> notFound = nameList.stream()
            .filter(n -> n.startsWith("X"))
            .findFirst();
        
        System.out.println("Not found: " + notFound.orElse("None"));

        // ifPresent
        found.ifPresent(name -> System.out.println("Found name: " + name));

        // map on Optional
        Optional<Integer> nameLength = found.map(String::length);
        System.out.println("Name length: " + nameLength.orElse(0));
        System.out.println();


        // ================================================
        // DEMONSTRATION 10: PRACTICAL EXAMPLES
        // ================================================
        System.out.println("10. PRACTICAL EXAMPLES");
        System.out.println("─────────────────────────────────────────");

        List<Product> products = Arrays.asList(
            new Product("Laptop", 999.99, "Electronics"),
            new Product("Mouse", 29.99, "Electronics"),
            new Product("Desk", 199.99, "Furniture"),
            new Product("Chair", 149.99, "Furniture"),
            new Product("Monitor", 299.99, "Electronics"),
            new Product("Keyboard", 79.99, "Electronics")
        );

        // Total value of all products
        double totalValue = products.stream()
            .mapToDouble(Product::getPrice)
            .sum();
        System.out.printf("Total inventory value: $%.2f%n", totalValue);

        // Most expensive product
        Optional<Product> mostExpensive = products.stream()
            .max(Comparator.comparingDouble(Product::getPrice));
        mostExpensive.ifPresent(p -> 
            System.out.printf("Most expensive: %s ($%.2f)%n", p.getName(), p.getPrice()));

        // Products by category with count
        Map<String, Long> countByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.counting()
            ));
        System.out.println("Products by category: " + countByCategory);

        // Electronics under $100
        List<String> cheapElectronics = products.stream()
            .filter(p -> p.getCategory().equals("Electronics"))
            .filter(p -> p.getPrice() < 100)
            .map(Product::getName)
            .collect(Collectors.toList());
        System.out.println("Electronics under $100: " + cheapElectronics);

        // Price statistics
        DoubleSummaryStatistics priceStats = products.stream()
            .collect(Collectors.summarizingDouble(Product::getPrice));
        System.out.printf("Price stats: min=$%.2f, max=$%.2f, avg=$%.2f%n",
            priceStats.getMin(), priceStats.getMax(), priceStats.getAverage());


        System.out.println("\n========== END OF DEMO ==========");
    }
}


// =========================================================
// HELPER CLASSES
// =========================================================

class Person {
    private String name;
    private int age;
    private String department;

    public Person(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
