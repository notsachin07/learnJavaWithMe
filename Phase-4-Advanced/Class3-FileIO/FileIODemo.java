/**
 * Class 3: File I/O - Complete Example
 *
 * Demonstrates:
 * - File class operations
 * - Writing with FileWriter and PrintWriter
 * - Reading with BufferedReader and Scanner
 * - Try-with-resources
 * - Modern Files/Paths API
 * - Copy, move, delete operations
 *
 * How to compile and run:
 * $ javac FileIODemo.java
 * $ java FileIODemo
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileIODemo {

    public static void main(String[] args) {
        System.out.println("========== FILE I/O DEMO ==========\n");

        // ================================================
        // DEMONSTRATION 1: FILE CLASS BASICS
        // ================================================
        System.out.println("1. FILE CLASS BASICS");
        System.out.println("─────────────────────────────────────────");

        File file = new File("demo_file.txt");
        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Exists? " + file.exists());
        System.out.println();


        // ================================================
        // DEMONSTRATION 2: WRITING WITH PRINTWRITER
        // ================================================
        System.out.println("2. WRITING WITH PRINTWRITER");
        System.out.println("─────────────────────────────────────────");

        String filename = "demo_output.txt";
        
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println("Hello, File I/O!");
            writer.println("This is line 2.");
            writer.println("Line 3 with number: " + 42);
            writer.printf("Formatted: %.2f%n", 3.14159);
            System.out.println("Successfully wrote to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 3: READING WITH BUFFEREDREADER
        // ================================================
        System.out.println("3. READING WITH BUFFEREDREADER");
        System.out.println("─────────────────────────────────────────");

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("Contents of " + filename + ":");
            String line;
            int lineNum = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + lineNum + ": " + line);
                lineNum++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 4: READING WITH SCANNER
        // ================================================
        System.out.println("4. READING WITH SCANNER");
        System.out.println("─────────────────────────────────────────");

        try (Scanner scanner = new Scanner(new File(filename))) {
            System.out.println("Reading with Scanner:");
            while (scanner.hasNextLine()) {
                System.out.println("  > " + scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 5: MODERN FILES API
        // ================================================
        System.out.println("5. MODERN FILES API");
        System.out.println("─────────────────────────────────────────");

        Path path = Paths.get(filename);
        
        try {
            // Read all lines at once
            List<String> lines = Files.readAllLines(path);
            System.out.println("Read " + lines.size() + " lines using Files.readAllLines()");
            
            // File info
            System.out.println("File size: " + Files.size(path) + " bytes");
            System.out.println("Is readable: " + Files.isReadable(path));
            System.out.println("Is writable: " + Files.isWritable(path));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 6: WRITING WITH FILES API
        // ================================================
        System.out.println("6. WRITING WITH FILES API");
        System.out.println("─────────────────────────────────────────");

        Path modernPath = Paths.get("modern_output.txt");
        List<String> linesToWrite = Arrays.asList(
            "Line 1: Using modern Files API",
            "Line 2: Much cleaner code",
            "Line 3: Java NIO is great!"
        );

        try {
            Files.write(modernPath, linesToWrite);
            System.out.println("Wrote " + linesToWrite.size() + " lines to " + modernPath);
            
            // Read it back
            System.out.println("Contents:");
            Files.readAllLines(modernPath).forEach(l -> System.out.println("  " + l));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 7: APPEND TO FILE
        // ================================================
        System.out.println("7. APPEND TO FILE");
        System.out.println("─────────────────────────────────────────");

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println("This line was appended!");
            writer.println("Another appended line.");
            System.out.println("Appended 2 lines to " + filename);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Show updated content
        try {
            System.out.println("Updated contents:");
            Files.readAllLines(Paths.get(filename))
                 .forEach(l -> System.out.println("  " + l));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 8: COPY FILE
        // ================================================
        System.out.println("8. COPY FILE");
        System.out.println("─────────────────────────────────────────");

        Path source = Paths.get(filename);
        Path target = Paths.get("demo_copy.txt");

        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copied " + source + " to " + target);
            System.out.println("Copy exists: " + Files.exists(target));
        } catch (IOException e) {
            System.out.println("Error copying: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 9: DIRECTORY OPERATIONS
        // ================================================
        System.out.println("9. DIRECTORY OPERATIONS");
        System.out.println("─────────────────────────────────────────");

        Path dirPath = Paths.get("demo_directory");
        
        try {
            // Create directory
            if (!Files.exists(dirPath)) {
                Files.createDirectory(dirPath);
                System.out.println("Created directory: " + dirPath);
            }

            // Create file inside
            Path fileInDir = dirPath.resolve("inside.txt");
            Files.write(fileInDir, Arrays.asList("File inside directory"));
            System.out.println("Created file: " + fileInDir);

            // List directory contents
            System.out.println("Directory contents:");
            Files.list(dirPath).forEach(p -> System.out.println("  " + p.getFileName()));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 10: CSV FILE PROCESSING
        // ================================================
        System.out.println("10. CSV FILE PROCESSING");
        System.out.println("─────────────────────────────────────────");

        String csvFile = "demo_data.csv";
        
        // Write CSV
        try (PrintWriter csv = new PrintWriter(csvFile)) {
            csv.println("Name,Age,City");
            csv.println("Alice,25,New York");
            csv.println("Bob,30,Los Angeles");
            csv.println("Charlie,35,Chicago");
            System.out.println("Created CSV file: " + csvFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Read and parse CSV
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            System.out.println("\nParsed CSV data:");
            String line;
            boolean header = true;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (header) {
                    System.out.println("  [" + String.join(" | ", parts) + "]");
                    header = false;
                } else {
                    System.out.printf("  %s is %s years old, lives in %s%n",
                                      parts[0], parts[1], parts[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // CLEANUP
        // ================================================
        System.out.println("CLEANUP");
        System.out.println("─────────────────────────────────────────");

        // Delete created files
        String[] filesToDelete = {filename, "modern_output.txt", "demo_copy.txt", csvFile};
        for (String f : filesToDelete) {
            try {
                Files.deleteIfExists(Paths.get(f));
                System.out.println("Deleted: " + f);
            } catch (IOException e) {
                System.out.println("Could not delete " + f);
            }
        }

        // Delete directory and contents
        try {
            Path insideFile = dirPath.resolve("inside.txt");
            Files.deleteIfExists(insideFile);
            Files.deleteIfExists(dirPath);
            System.out.println("Deleted: " + dirPath);
        } catch (IOException e) {
            System.out.println("Could not delete directory");
        }


        System.out.println("\n========== END OF DEMO ==========");
    }
}
