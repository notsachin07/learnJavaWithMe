/**
 * Class 2: Variables and Data Types
 * 
 * This program demonstrates how to:
 * - Declare variables (create them with a type)
 * - Initialize variables (assign them values)
 * - Use different primitive data types
 * - Use the String type for text
 * - Print variables using concatenation
 * 
 * What this program does:
 * - Creates variables of different types
 * - Assigns values to them
 * - Prints all the variables to demonstrate storage
 * 
 * Data types covered:
 * - int: whole numbers
 * - double: decimal numbers (high precision)
 * - float: decimal numbers (lower precision, need 'f' suffix)
 * - char: single character
 * - boolean: true or false
 * - String: text (non-primitive type)
 * 
 * How to run:
 * 1. Save as: Variables.java
 * 2. Compile: javac Variables.java
 * 3. Run: java Variables
 * 
 * Expected output:
 * Name: Raghav
 * Age: 19
 * GPA: 3.75
 * Grade: A
 * Is Student: true
 */

public class Variables {
    
    public static void main(String[] args) {
        
        // ========================================
        // INTEGER VARIABLES (whole numbers)
        // ========================================
        int age = 19;           // Age in years
        int year = 2026;        // Current year
        int score = 95;         // Test score
        
        
        // ========================================
        // DOUBLE VARIABLES (decimal numbers - PREFERRED)
        // ========================================
        double gpa = 3.75;      // Grade Point Average
        double price = 99.99;   // Product price
        
        
        // ========================================
        // FLOAT VARIABLES (decimal numbers - less precise)
        // ========================================
        // Note the 'f' at the end - required for float!
        float height = 5.9f;    // Height in feet
        
        
        // ========================================
        // CHARACTER VARIABLES (single character)
        // ========================================
        // Note the single quotes around the character
        char grade = 'A';       // Letter grade
        char firstLetter = 'R'; // First letter of name
        
        
        // ========================================
        // STRING VARIABLES (text - multiple characters)
        // ========================================
        // Note the double quotes around text
        String name = "Raghav";         // Student name
        String university = "VIT-AP";   // University name
        String city = "Amaravati";      // City name
        
        
        // ========================================
        // BOOLEAN VARIABLES (true or false)
        // ========================================
        boolean isStudent = true;       // Are they a student?
        boolean hasPermission = true;   // Do they have permission?
        boolean isWeekend = false;      // Is it weekend?
        
        
        // ========================================
        // PRINTING ALL VARIABLES
        // ========================================
        // Using concatenation with the + operator to combine strings
        
        System.out.println("=== Personal Information ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
        
        System.out.println("\n=== Academic Information ===");
        System.out.println("University: " + university);
        System.out.println("Year: " + year);
        System.out.println("GPA: " + gpa);
        System.out.println("Current Grade: " + grade);
        System.out.println("Test Score: " + score);
        
        System.out.println("\n=== Physical Attributes ===");
        System.out.println("Height: " + height + " feet");
        System.out.println("First Letter of Name: " + firstLetter);
        
        System.out.println("\n=== Status ===");
        System.out.println("Is Student: " + isStudent);
        System.out.println("Has Permission: " + hasPermission);
        System.out.println("Is Weekend: " + isWeekend);
        
        System.out.println("\n=== Combined Information ===");
        System.out.println(name + " is " + age + " years old and studies at " + university);
        System.out.println("GPA: " + gpa + ", Current Grade: " + grade);
        
    }
    // End of main method
    
}
// End of Variables class
