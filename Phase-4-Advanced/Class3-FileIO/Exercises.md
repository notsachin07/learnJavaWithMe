# Class 3: File I/O - Exercises 📂

Master reading and writing files in Java!

---

## 🟢 Easy Exercises

### Exercise 1: Simple File Writer
**Goal:** Write text to a file.

**Requirements:**
1. Create a method `writeToFile(String filename, String content)`
2. Write the content to the specified file
3. Use try-with-resources
4. Handle IOException

**Test:**
```java
writeToFile("hello.txt", "Hello, World!\nThis is line 2.");
```

**Expected Result:** File `hello.txt` created with content.

---

### Exercise 2: Line Counter
**Goal:** Count lines in a file.

**Requirements:**
1. Create method `countLines(String filename)` returning int
2. Read file and count lines
3. Handle FileNotFoundException
4. Return -1 if file not found

**Test:**
```java
int lines = countLines("sample.txt");
System.out.println("Lines: " + lines);
```

---

### Exercise 3: File Copier
**Goal:** Copy contents from one file to another.

**Requirements:**
1. Create method `copyFile(String source, String destination)`
2. Read source file line by line
3. Write each line to destination
4. Handle exceptions appropriately

**Test:**
```java
copyFile("original.txt", "backup.txt");
```

---

## 🟡 Medium Exercises

### Exercise 4: Word Counter
**Goal:** Count words in a text file.

**Requirements:**
1. Read a text file
2. Count total words (split by whitespace)
3. Count unique words (use HashSet)
4. Display statistics

**Expected Output:**
```
File: document.txt
Total words: 150
Unique words: 87
Most common word: "the" (12 occurrences)
```

---

### Exercise 5: CSV Parser
**Goal:** Read and parse a CSV file.

**Requirements:**
1. Read a CSV file with headers
2. Parse into a List of Maps (each row = Map<String, String>)
3. Handle missing values
4. Provide method to get column values

**Sample CSV:**
```
name,age,city
Alice,25,New York
Bob,30,Los Angeles
Charlie,,Chicago
```

**Expected Output:**
```java
List<Map<String, String>> data = parseCSV("data.csv");
// data.get(0).get("name") → "Alice"
// data.get(2).get("age") → "" (empty)
```

---

### Exercise 6: Log File Analyzer
**Goal:** Analyze a log file and extract information.

**Requirements:**
1. Read a log file with format: `[LEVEL] timestamp - message`
2. Count entries by level (INFO, WARN, ERROR)
3. Find all ERROR messages
4. Write summary to a new file

**Sample Log:**
```
[INFO] 2026-02-15 10:00:00 - Application started
[WARN] 2026-02-15 10:05:00 - Low memory
[ERROR] 2026-02-15 10:10:00 - Connection failed
[INFO] 2026-02-15 10:15:00 - Retry successful
```

**Expected Summary:**
```
Log Analysis Report
===================
INFO: 2 entries
WARN: 1 entries
ERROR: 1 entries

ERROR Details:
- 2026-02-15 10:10:00: Connection failed
```

---

## 🔴 Hard Exercises

### Exercise 7: Configuration File Manager
**Goal:** Read and write configuration files.

**Requirements:**
1. Support `key=value` format (like .properties)
2. Support comments (lines starting with #)
3. Implement:
   - `loadConfig(filename)` → Map<String, String>
   - `saveConfig(filename, Map)` 
   - `getValue(key)` with default value
   - `setValue(key, value)`

**Sample Config:**
```
# Application Settings
app.name=MyApp
app.version=1.0
database.host=localhost
database.port=5432
```

**Usage:**
```java
Config config = new Config("app.properties");
String host = config.getValue("database.host", "127.0.0.1");
config.setValue("app.version", "1.1");
config.save();
```

---

### Exercise 8: Search and Replace Tool
**Goal:** Find and replace text across multiple files.

**Requirements:**
1. Accept directory path, search text, replace text
2. Recursively process all .txt files
3. Create backups before modifying
4. Report changes made

**Features:**
- Case-sensitive and case-insensitive modes
- Regular expression support
- Dry-run mode (show what would change)
- Undo using backup files

**Expected Output:**
```
Searching in: /documents
Pattern: "colour" → "color"

Modified files:
  file1.txt: 3 replacements
  subdir/file2.txt: 1 replacement

Total: 4 replacements in 2 files
Backups created in: /documents/.backup/
```

---

### Exercise 9: File Comparison Tool (Diff)
**Goal:** Compare two files and show differences.

**Requirements:**
1. Compare two text files line by line
2. Show added, removed, and changed lines
3. Display line numbers
4. Generate a diff report

**Expected Output:**
```
Comparing: file1.txt vs file2.txt

Line 3:
  - "Hello World"
  + "Hello, World!"

Line 5:
  - (deleted) "Old line"

Line 8:
  + (added) "New line"

Summary:
  1 modified
  1 deleted
  1 added
  6 unchanged
```

---

## ✅ Bonus Challenge

Create a **Personal Diary Application** with file persistence:

**Features:**
1. **Add Entry** - Write diary entry with date/time stamp
2. **View Entries** - List all entries or filter by date
3. **Search** - Find entries containing keyword
4. **Export** - Export to single text file
5. **Import** - Import from backup
6. **Encryption** - Simple XOR encryption for privacy

**File Structure:**
```
diary/
├── entries/
│   ├── 2026-02-15.txt
│   ├── 2026-02-16.txt
│   └── ...
├── index.txt (entry dates and preview)
└── settings.properties
```

**Sample Interaction:**
```
Diary Menu:
1. New Entry
2. View Today
3. Browse Entries
4. Search
5. Export All
6. Settings
7. Exit

> 1
Enter your diary entry (empty line to finish):
Today was a productive day. Learned File I/O in Java!

Entry saved: 2026-02-16_14-30.txt

> 4
Search for: productive

Found 1 entry:
[2026-02-16] Today was a productive day...
```

---

Happy coding! 💻
