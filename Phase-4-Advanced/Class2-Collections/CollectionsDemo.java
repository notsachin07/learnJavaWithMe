/**
 * Class 2: Collections - Complete Example
 *
 * Demonstrates:
 * - ArrayList operations
 * - LinkedList operations
 * - HashSet for unique values
 * - HashMap for key-value pairs
 * - Iterating collections
 * - Generics
 * - Collections utility methods
 *
 * How to compile and run:
 * $ javac CollectionsDemo.java
 * $ java CollectionsDemo
 */

import java.util.*;

public class CollectionsDemo {

    public static void main(String[] args) {
        System.out.println("========== COLLECTIONS DEMO ==========\n");

        // ================================================
        // DEMONSTRATION 1: ARRAYLIST BASICS
        // ================================================
        System.out.println("1. ARRAYLIST BASICS");
        System.out.println("─────────────────────────────────────────");

        ArrayList<String> fruits = new ArrayList<>();
        
        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        System.out.println("Initial list: " + fruits);

        // Add at specific index
        fruits.add(1, "Blueberry");
        System.out.println("After add at index 1: " + fruits);

        // Access elements
        System.out.println("First fruit: " + fruits.get(0));
        System.out.println("Size: " + fruits.size());

        // Update element
        fruits.set(0, "Apricot");
        System.out.println("After update: " + fruits);

        // Remove elements
        fruits.remove("Cherry");
        System.out.println("After remove 'Cherry': " + fruits);
        
        fruits.remove(0);
        System.out.println("After remove index 0: " + fruits);

        // Search
        System.out.println("Contains 'Banana'? " + fruits.contains("Banana"));
        System.out.println("Index of 'Date': " + fruits.indexOf("Date"));
        System.out.println();


        // ================================================
        // DEMONSTRATION 2: LINKEDLIST
        // ================================================
        System.out.println("2. LINKEDLIST");
        System.out.println("─────────────────────────────────────────");

        LinkedList<String> queue = new LinkedList<>();

        // Add elements
        queue.addLast("First");
        queue.addLast("Second");
        queue.addLast("Third");
        System.out.println("Queue: " + queue);

        // Add to front
        queue.addFirst("Zero");
        System.out.println("After addFirst: " + queue);

        // Remove from front (queue behavior)
        String removed = queue.removeFirst();
        System.out.println("Removed first: " + removed);
        System.out.println("Queue now: " + queue);

        // Peek without removing
        System.out.println("Peek first: " + queue.peekFirst());
        System.out.println("Peek last: " + queue.peekLast());
        System.out.println();


        // ================================================
        // DEMONSTRATION 3: HASHSET
        // ================================================
        System.out.println("3. HASHSET (Unique Elements)");
        System.out.println("─────────────────────────────────────────");

        HashSet<String> colors = new HashSet<>();
        
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        System.out.println("Colors: " + colors);

        // Try to add duplicate
        boolean added = colors.add("Red");
        System.out.println("Added 'Red' again? " + added);
        System.out.println("Colors still: " + colors);

        // Check membership
        System.out.println("Contains 'Blue'? " + colors.contains("Blue"));
        System.out.println("Contains 'Yellow'? " + colors.contains("Yellow"));

        // Remove
        colors.remove("Green");
        System.out.println("After remove 'Green': " + colors);
        System.out.println();


        // ================================================
        // DEMONSTRATION 4: FINDING UNIQUE VALUES
        // ================================================
        System.out.println("4. FINDING UNIQUE VALUES");
        System.out.println("─────────────────────────────────────────");

        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5};
        System.out.println("Original array: " + Arrays.toString(numbers));

        HashSet<Integer> unique = new HashSet<>();
        for (int num : numbers) {
            unique.add(num);
        }
        System.out.println("Unique values: " + unique);
        System.out.println("Count of unique: " + unique.size());
        System.out.println();


        // ================================================
        // DEMONSTRATION 5: HASHMAP BASICS
        // ================================================
        System.out.println("5. HASHMAP BASICS");
        System.out.println("─────────────────────────────────────────");

        HashMap<String, Integer> ages = new HashMap<>();

        // Add entries
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 35);
        System.out.println("Ages: " + ages);

        // Get value
        System.out.println("Alice's age: " + ages.get("Alice"));

        // Get with default
        System.out.println("Unknown's age: " + ages.getOrDefault("Unknown", 0));

        // Update value
        ages.put("Alice", 26);
        System.out.println("Alice's updated age: " + ages.get("Alice"));

        // Check existence
        System.out.println("Has 'Bob'? " + ages.containsKey("Bob"));
        System.out.println("Has age 30? " + ages.containsValue(30));

        // Remove entry
        ages.remove("Charlie");
        System.out.println("After remove Charlie: " + ages);
        System.out.println();


        // ================================================
        // DEMONSTRATION 6: WORD COUNTER
        // ================================================
        System.out.println("6. WORD COUNTER (HashMap Use Case)");
        System.out.println("─────────────────────────────────────────");

        String text = "the quick brown fox jumps over the lazy dog the fox";
        String[] words = text.split(" ");
        System.out.println("Text: \"" + text + "\"");

        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 7: ITERATING COLLECTIONS
        // ================================================
        System.out.println("7. ITERATING COLLECTIONS");
        System.out.println("─────────────────────────────────────────");

        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // For-each loop
        System.out.println("For-each loop:");
        for (String name : names) {
            System.out.println("  " + name);
        }

        // Iterator
        System.out.println("Iterator:");
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.println("  " + it.next());
        }

        // forEach with lambda
        System.out.println("Lambda forEach:");
        names.forEach(name -> System.out.println("  " + name));

        // Iterating HashMap
        System.out.println("HashMap iteration:");
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Math", 95);
        scores.put("Science", 88);
        scores.put("History", 92);

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 8: COLLECTIONS UTILITY METHODS
        // ================================================
        System.out.println("8. COLLECTIONS UTILITY METHODS");
        System.out.println("─────────────────────────────────────────");

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(1);
        nums.add(4);
        nums.add(1);
        nums.add(5);
        nums.add(9);
        nums.add(2);
        nums.add(6);

        System.out.println("Original: " + nums);

        // Sort
        Collections.sort(nums);
        System.out.println("Sorted: " + nums);

        // Reverse
        Collections.reverse(nums);
        System.out.println("Reversed: " + nums);

        // Min and Max
        System.out.println("Min: " + Collections.min(nums));
        System.out.println("Max: " + Collections.max(nums));

        // Frequency
        System.out.println("Frequency of 1: " + Collections.frequency(nums, 1));

        // Shuffle
        Collections.shuffle(nums);
        System.out.println("Shuffled: " + nums);
        System.out.println();


        // ================================================
        // DEMONSTRATION 9: SAFE REMOVAL WITH ITERATOR
        // ================================================
        System.out.println("9. SAFE REMOVAL WITH ITERATOR");
        System.out.println("─────────────────────────────────────────");

        ArrayList<Integer> values = new ArrayList<>();
        values.add(10);
        values.add(20);
        values.add(30);
        values.add(40);
        values.add(50);
        System.out.println("Before removal: " + values);

        // Remove all values > 25 using iterator
        Iterator<Integer> iter = values.iterator();
        while (iter.hasNext()) {
            if (iter.next() > 25) {
                iter.remove();
            }
        }
        System.out.println("After removing > 25: " + values);

        // Alternative: removeIf (Java 8+)
        values.add(30);
        values.add(40);
        System.out.println("After adding back: " + values);
        
        values.removeIf(v -> v > 25);
        System.out.println("After removeIf > 25: " + values);
        System.out.println();


        // ================================================
        // DEMONSTRATION 10: STUDENT GRADES SYSTEM
        // ================================================
        System.out.println("10. STUDENT GRADES SYSTEM");
        System.out.println("─────────────────────────────────────────");

        // Using HashMap to store student grades
        HashMap<String, ArrayList<Integer>> studentGrades = new HashMap<>();

        // Add grades for students
        studentGrades.put("Alice", new ArrayList<>(Arrays.asList(95, 87, 92, 88)));
        studentGrades.put("Bob", new ArrayList<>(Arrays.asList(78, 82, 85, 80)));
        studentGrades.put("Charlie", new ArrayList<>(Arrays.asList(92, 95, 98, 94)));

        // Calculate and display averages
        System.out.println("Student Averages:");
        for (Map.Entry<String, ArrayList<Integer>> entry : studentGrades.entrySet()) {
            String student = entry.getKey();
            ArrayList<Integer> grades = entry.getValue();
            
            double average = grades.stream()
                                   .mapToInt(Integer::intValue)
                                   .average()
                                   .orElse(0.0);
            
            System.out.printf("  %s: %.2f (from %s)%n", student, average, grades);
        }

        // Find top student
        String topStudent = "";
        double highestAvg = 0;
        
        for (Map.Entry<String, ArrayList<Integer>> entry : studentGrades.entrySet()) {
            double avg = entry.getValue().stream()
                              .mapToInt(Integer::intValue)
                              .average()
                              .orElse(0.0);
            if (avg > highestAvg) {
                highestAvg = avg;
                topStudent = entry.getKey();
            }
        }
        System.out.printf("%nTop student: %s (%.2f average)%n", topStudent, highestAvg);


        System.out.println("\n========== END OF DEMO ==========");
    }
}
