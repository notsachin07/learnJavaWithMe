# Class 3: File I/O 📂

Welcome to **Phase 4, Class 3**! In this class, you'll learn how to read from and write to files - essential skills for data persistence and working with external data.

---

## Table of Contents
1. [Why File I/O?](#why-file-io)
2. [The File Class](#the-file-class)
3. [Writing to Files](#writing-to-files)
4. [Reading from Files](#reading-from-files)
5. [Try-With-Resources](#try-with-resources)
6. [BufferedReader and BufferedWriter](#bufferedreader-and-bufferedwriter)
7. [Reading All Lines at Once](#reading-all-lines-at-once)
8. [Working with Paths](#working-with-paths)
9. [Common File Operations](#common-file-operations)
10. [Best Practices](#best-practices)
11. [Common Mistakes](#common-mistakes)
12. [Summary](#summary)

---

## Why File I/O?

Programs need to persist data beyond their runtime:
- Save user settings
- Store game progress
- Process data files (CSV, JSON, logs)
- Export reports

---

## The File Class

The `File` class represents file and directory paths.

```java
import java.io.File;

File file = new File("data.txt");

// Check if exists
boolean exists = file.exists();

// Get information
String name = file.getName();           // "data.txt"
String path = file.getAbsolutePath();   // Full path
long size = file.length();              // Size in bytes
boolean isFile = file.isFile();
boolean isDir = file.isDirectory();

// Create new file
boolean created = file.createNewFile();

// Delete file
boolean deleted = file.delete();
```

### Directory Operations

```java
File dir = new File("myFolder");

// Create directory
dir.mkdir();

// Create nested directories
File nested = new File("parent/child/grandchild");
nested.mkdirs();

// List files in directory
File folder = new File(".");
String[] files = folder.list();
File[] fileObjects = folder.listFiles();
```

---

## Writing to Files

### FileWriter (Basic)

```java
import java.io.FileWriter;
import java.io.IOException;

try {
    FileWriter writer = new FileWriter("output.txt");
    writer.write("Hello, World!\n");
    writer.write("Second line\n");
    writer.close();
} catch (IOException e) {
    e.printStackTrace();
}
```

### Append Mode

```java
// true = append mode (don't overwrite)
FileWriter writer = new FileWriter("output.txt", true);
writer.write("This is appended\n");
writer.close();
```

### PrintWriter (Easier)

```java
import java.io.PrintWriter;

try (PrintWriter out = new PrintWriter("output.txt")) {
    out.println("Line 1");
    out.println("Line 2");
    out.printf("Formatted: %d + %d = %d%n", 2, 3, 5);
} catch (IOException e) {
    e.printStackTrace();
}
```

---

## Reading from Files

### FileReader (Basic)

```java
import java.io.FileReader;

try {
    FileReader reader = new FileReader("input.txt");
    int character;
    while ((character = reader.read()) != -1) {
        System.out.print((char) character);
    }
    reader.close();
} catch (IOException e) {
    e.printStackTrace();
}
```

### Scanner (Familiar)

```java
import java.util.Scanner;
import java.io.File;

try {
    Scanner scanner = new Scanner(new File("input.txt"));
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        System.out.println(line);
    }
    scanner.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
```

---

## Try-With-Resources

Automatically closes resources - **always use this!**

### Old Way (Error-Prone)

```java
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader("file.txt"));
    String line = reader.readLine();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Modern Way (Clean)

```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    String line = reader.readLine();
} catch (IOException e) {
    e.printStackTrace();
}
// reader is automatically closed!
```

### Multiple Resources

```java
try (
    BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
    BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))
) {
    String line;
    while ((line = reader.readLine()) != null) {
        writer.write(line.toUpperCase());
        writer.newLine();
    }
}
```

---

## BufferedReader and BufferedWriter

Buffered streams are more efficient for reading/writing large files.

### BufferedReader

```java
import java.io.BufferedReader;
import java.io.FileReader;

try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### BufferedWriter

```java
import java.io.BufferedWriter;
import java.io.FileWriter;

try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
    writer.write("First line");
    writer.newLine();  // Platform-independent line break
    writer.write("Second line");
    writer.newLine();
} catch (IOException e) {
    e.printStackTrace();
}
```

---

## Reading All Lines at Once

### Files.readAllLines (Java 7+)

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

try {
    List<String> lines = Files.readAllLines(Paths.get("data.txt"));
    for (String line : lines) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### Files.readString (Java 11+)

```java
try {
    String content = Files.readString(Paths.get("data.txt"));
    System.out.println(content);
} catch (IOException e) {
    e.printStackTrace();
}
```

### Files.write

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

try {
    // Write lines
    List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3");
    Files.write(Paths.get("output.txt"), lines);
    
    // Write string (Java 11+)
    Files.writeString(Paths.get("output.txt"), "Hello, World!");
} catch (IOException e) {
    e.printStackTrace();
}
```

---

## Working with Paths

The `Path` class (Java 7+) is the modern way to handle file paths.

```java
import java.nio.file.Path;
import java.nio.file.Paths;

// Create paths
Path path1 = Paths.get("folder", "subfolder", "file.txt");
Path path2 = Path.of("folder/subfolder/file.txt");  // Java 11+

// Get information
String fileName = path1.getFileName().toString();
Path parent = path1.getParent();
Path absolute = path1.toAbsolutePath();

// Resolve paths
Path base = Paths.get("/home/user");
Path full = base.resolve("documents/file.txt");
// Result: /home/user/documents/file.txt
```

---

## Common File Operations

### Check if File Exists

```java
Path path = Paths.get("data.txt");
boolean exists = Files.exists(path);
boolean notExists = Files.notExists(path);
```

### Create Files and Directories

```java
// Create file
Files.createFile(Paths.get("newfile.txt"));

// Create directory
Files.createDirectory(Paths.get("newfolder"));

// Create nested directories
Files.createDirectories(Paths.get("parent/child/grandchild"));
```

### Copy and Move

```java
Path source = Paths.get("original.txt");
Path target = Paths.get("copy.txt");

// Copy
Files.copy(source, target);

// Copy with options
Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

// Move/Rename
Files.move(source, Paths.get("renamed.txt"));
```

### Delete

```java
Files.delete(Paths.get("file.txt"));  // Throws if not exists
Files.deleteIfExists(Paths.get("file.txt"));  // Safe
```

### Get File Information

```java
Path path = Paths.get("data.txt");

long size = Files.size(path);
boolean isReadable = Files.isReadable(path);
boolean isWritable = Files.isWritable(path);
boolean isDirectory = Files.isDirectory(path);
```

---

## Best Practices

### ✅ Do

1. **Always use try-with-resources** for automatic cleanup
2. **Use buffered streams** for better performance
3. **Handle exceptions** appropriately
4. **Use Path/Files API** (modern, cleaner)
5. **Check if file exists** before operations

### ❌ Don't

1. **Don't forget to close** file handles
2. **Don't ignore exceptions** silently
3. **Don't hardcode paths** - use Path API
4. **Don't read huge files** into memory at once

### Example: Good File Reading

```java
public static List<String> readFileLines(String filename) {
    Path path = Paths.get(filename);
    
    if (!Files.exists(path)) {
        System.err.println("File not found: " + filename);
        return Collections.emptyList();
    }
    
    try {
        return Files.readAllLines(path);
    } catch (IOException e) {
        System.err.println("Error reading file: " + e.getMessage());
        return Collections.emptyList();
    }
}
```

---

## Common Mistakes

### ❌ Forgetting to Close Files

```java
// BAD
FileWriter writer = new FileWriter("file.txt");
writer.write("data");
// File never closed! Data may not be written!

// GOOD
try (FileWriter writer = new FileWriter("file.txt")) {
    writer.write("data");
}
```

### ❌ Not Handling FileNotFoundException

```java
// BAD
Scanner scanner = new Scanner(new File("maybe.txt"));

// GOOD
try {
    Scanner scanner = new Scanner(new File("maybe.txt"));
} catch (FileNotFoundException e) {
    System.out.println("File not found!");
}
```

### ❌ Reading Large Files into Memory

```java
// BAD for huge files
String everything = Files.readString(Paths.get("huge.txt"));

// GOOD - process line by line
try (BufferedReader reader = Files.newBufferedReader(Paths.get("huge.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        processLine(line);  // Process one line at a time
    }
}
```

### ❌ Platform-Specific Line Endings

```java
// BAD - Windows only
writer.write("line\r\n");

// GOOD - Platform independent
writer.write("line");
writer.newLine();

// Or use System property
writer.write("line" + System.lineSeparator());
```

---

## Summary

| Class/Method | Purpose |
|--------------|---------|
| `File` | Represent file/directory path |
| `FileReader`/`FileWriter` | Basic character I/O |
| `BufferedReader`/`BufferedWriter` | Efficient buffered I/O |
| `PrintWriter` | Convenient writing with println |
| `Scanner` | Easy reading with parsing |
| `Files` | Modern utility methods |
| `Path`/`Paths` | Modern path handling |

### Quick Reference

```java
// Write to file
try (PrintWriter out = new PrintWriter("file.txt")) {
    out.println("Hello");
}

// Read from file
try (BufferedReader in = new BufferedReader(new FileReader("file.txt"))) {
    String line;
    while ((line = in.readLine()) != null) {
        System.out.println(line);
    }
}

// Modern way - read all lines
List<String> lines = Files.readAllLines(Paths.get("file.txt"));

// Modern way - write all lines
Files.write(Paths.get("file.txt"), lines);
```

---

**Congratulations!** You can now read and write files in Java. Next up: **Streams & Lambdas** - functional programming in Java! 🚀
