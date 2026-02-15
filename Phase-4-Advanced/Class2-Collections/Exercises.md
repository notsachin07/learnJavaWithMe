# Class 2: Collections - Exercises 📦

Master dynamic data structures and become proficient with Java's Collections framework!

---

## 🟢 Easy Exercises

### Exercise 1: Shopping List Manager
**Goal:** Practice basic ArrayList operations.

**Requirements:**
1. Create an ArrayList to store shopping items
2. Implement methods:
   - `addItem(String item)`
   - `removeItem(String item)`
   - `hasItem(String item)` - returns boolean
   - `printList()` - displays all items
3. Test with at least 5 items

**Expected Output:**
```
Shopping List: [Milk, Bread, Eggs, Butter, Cheese]
Has Milk? true
After removing Bread: [Milk, Eggs, Butter, Cheese]
```

---

### Exercise 2: Unique Number Finder
**Goal:** Use HashSet to find unique elements.

**Requirements:**
1. Create an array with duplicate numbers
2. Use HashSet to extract unique values
3. Display original count vs unique count

**Test Data:**
```java
int[] numbers = {5, 2, 8, 2, 9, 5, 8, 1, 9, 3, 2};
```

**Expected Output:**
```
Original: 11 numbers
Unique: 6 numbers [1, 2, 3, 5, 8, 9]
```

---

### Exercise 3: Phone Book
**Goal:** Use HashMap for key-value storage.

**Requirements:**
1. Create a HashMap to store name → phone number
2. Add at least 5 contacts
3. Implement:
   - `addContact(name, phone)`
   - `getPhone(name)` - returns phone or "Not found"
   - `removeContact(name)`
   - `listAll()` - print all contacts

**Expected Output:**
```
Phone Book:
  Alice: 555-1234
  Bob: 555-5678
  Charlie: 555-9999

Looking up Bob: 555-5678
Looking up Unknown: Not found
```

---

## 🟡 Medium Exercises

### Exercise 4: Inventory System
**Goal:** Manage product inventory with HashMap.

**Requirements:**
1. Create `HashMap<String, Integer>` for product → quantity
2. Implement methods:
   - `addStock(product, quantity)` - add to existing
   - `removeStock(product, quantity)` - reduce quantity
   - `getStock(product)` - return current quantity
   - `lowStockAlert(threshold)` - list items below threshold

**Test Scenarios:**
```
Add 50 Apples
Add 30 Bananas
Remove 20 Apples
Check low stock (threshold: 35)
```

**Expected Output:**
```
Inventory: {Apples=30, Bananas=30}
Low stock alert (< 35):
  - Apples: 30
  - Bananas: 30
```

---

### Exercise 5: Word Frequency Analyzer
**Goal:** Count word occurrences in text.

**Requirements:**
1. Accept a string of text
2. Split into words (ignore case)
3. Count frequency of each word using HashMap
4. Display sorted by frequency (highest first)

**Test Input:**
```
"To be or not to be that is the question to be answered"
```

**Expected Output:**
```
Word Frequencies:
  to: 3
  be: 3
  or: 1
  not: 1
  that: 1
  is: 1
  the: 1
  question: 1
  answered: 1
```

---

### Exercise 6: Playlist Manager
**Goal:** Use LinkedList for ordered music playlist.

**Requirements:**
1. Create a music playlist using LinkedList
2. Implement:
   - `addSong(song)` - add to end
   - `addNext(song)` - add to front (play next)
   - `playNext()` - remove and return first song
   - `shuffle()` - randomize order
   - `displayPlaylist()`

**Expected Output:**
```
Playlist: [Song A, Song B, Song C]
Adding 'Song X' to play next...
Playlist: [Song X, Song A, Song B, Song C]
Playing: Song X
Playlist: [Song A, Song B, Song C]
```

---

## 🔴 Hard Exercises

### Exercise 7: Student Grade Book
**Goal:** Complex nested collections.

**Requirements:**
1. Store: `HashMap<String, HashMap<String, ArrayList<Integer>>>`
   - Student → Subject → List of grades
2. Implement:
   - `addGrade(student, subject, grade)`
   - `getAverage(student, subject)`
   - `getOverallAverage(student)`
   - `getTopStudent()`
   - `getClassAverage(subject)`

**Test Data:**
```
Alice - Math: [95, 87, 92], Science: [88, 91, 85]
Bob - Math: [78, 82, 85], Science: [80, 75, 88]
```

**Expected Output:**
```
Alice's Math average: 91.33
Alice's overall average: 89.67
Top student: Alice (89.67)
Class Math average: 86.50
```

---

### Exercise 8: Social Network Connections
**Goal:** Use collections to model relationships.

**Requirements:**
1. Store friendships: `HashMap<String, HashSet<String>>`
2. Implement:
   - `addFriend(person1, person2)` - bidirectional
   - `removeFriend(person1, person2)`
   - `areFriends(person1, person2)`
   - `getFriends(person)` - return set of friends
   - `getMutualFriends(person1, person2)`
   - `suggestFriends(person)` - friends of friends

**Test Scenarios:**
```
Alice friends with: Bob, Charlie
Bob friends with: Alice, David
Charlie friends with: Alice, Eve

Mutual friends of Alice and Bob?
Friend suggestions for Alice?
```

---

### Exercise 9: LRU Cache Implementation
**Goal:** Build a Least Recently Used cache.

**Requirements:**
1. Create an LRU cache with fixed capacity
2. Use `LinkedHashMap` with access-order
3. Implement:
   - `get(key)` - return value, mark as recently used
   - `put(key, value)` - add/update, evict oldest if full
   - `size()` - current number of entries
   - `display()` - show cache contents (oldest to newest)

**Test Scenarios:**
```
Cache capacity: 3

put("A", 1)
put("B", 2)
put("C", 3)
display() → [A=1, B=2, C=3]

get("A")   // Access A, moves to end
display() → [B=2, C=3, A=1]

put("D", 4)  // Evicts B (oldest)
display() → [C=3, A=1, D=4]
```

---

## ✅ Bonus Challenge

Create a **Library Management System** using collections:

**Data Structures:**
- `HashMap<String, Book>` - ISBN → Book
- `HashMap<String, Member>` - MemberID → Member
- `HashMap<String, ArrayList<Loan>>` - MemberID → List of loans

**Features:**
1. Add/remove books
2. Register members
3. Borrow book (check availability, track due date)
4. Return book (calculate late fees: $0.50/day)
5. Search books by title or author
6. List overdue books
7. Member borrowing history

**Sample Classes:**
```java
class Book {
    String isbn, title, author;
    boolean available;
}

class Member {
    String id, name;
    int borrowLimit = 5;
}

class Loan {
    String isbn, memberId;
    LocalDate borrowDate, dueDate, returnDate;
}
```

**Expected Features:**
```
> borrow ISBN123 M001
Book "Java Basics" borrowed by John Doe
Due: 2026-03-01

> return ISBN123 M001
Book returned. Late fee: $2.50 (5 days overdue)

> search author "Smith"
Found 3 books by Smith:
  1. Data Structures (ISBN456)
  2. Algorithms (ISBN789)
  3. Design Patterns (ISBN012)

> overdue
Overdue books:
  - "Clean Code" borrowed by Jane (7 days overdue)
```

---

Happy coding! 💻
