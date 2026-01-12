/**
 * Class 4: Input/Output (Scanner) - Complete Example
 *
 * This program demonstrates:
 * - Reading different data types (String, int, double, boolean)
 * - The critical newline issue and how to solve it
 * - Input validation
 * - Building interactive programs
 *
 * How to compile and run:
 * $ javac InputOutput.java
 * $ java InputOutput
 */

import java.util.Scanner;

public class InputOutput {

    public static void main(String[] args) {

        // Create Scanner object for keyboard input
        Scanner input = new Scanner(System.in);

        System.out.println("========== READING A SINGLE WORD ==========");
        System.out.print("Enter your first name (one word): ");
        String firstName = input.next();
        System.out.println("Hello, " + firstName + "!\n");

        // CRITICAL: Clear the newline left by next()
        input.nextLine();


        System.out.println("========== READING A FULL LINE ==========");
        System.out.print("Enter your complete address: ");
        String address = input.nextLine();
        System.out.println("You live at: " + address + "\n");


        System.out.println("========== READING AN INTEGER ==========");
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        System.out.println("You are " + age + " years old.\n");

        // CRITICAL: Clear the newline left by nextInt()
        input.nextLine();


        System.out.println("========== READING STRING AFTER NUMBER ==========");
        System.out.print("Enter your favorite hobby: ");
        String hobby = input.nextLine();
        System.out.println("Your hobby is: " + hobby + "\n");


        System.out.println("========== READING A DECIMAL ==========");
        System.out.print("Enter your GPA (e.g., 3.75): ");
        double gpa = input.nextDouble();
        System.out.println("Your GPA: " + gpa + "\n");

        // Clear newline after nextDouble()
        input.nextLine();


        System.out.println("========== READING A BOOLEAN ==========");
        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = input.nextBoolean();
        System.out.println("Student: " + isStudent + "\n");

        // Clear newline after nextBoolean()
        input.nextLine();


        System.out.println("========== INPUT VALIDATION ==========");
        System.out.print("Enter a number (we'll validate): ");

        if (input.hasNextInt()) {
            int number = input.nextInt();
            System.out.println("✓ Valid number: " + number);
        } else {
            System.out.println("✗ Invalid input! You didn't enter a number.");
            input.nextLine();  // Clear the bad input
        }


        System.out.println("\n========== COMPLETE FORM EXAMPLE ==========");
        input.nextLine();  // Clear remaining buffer

        System.out.print("Enter your full name: ");
        String fullName = input.nextLine();

        System.out.print("Enter your student ID: ");
        int studentId = input.nextInt();
        input.nextLine();  // Clear newline

        System.out.print("Enter your department: ");
        String department = input.nextLine();

        System.out.print("Enter your CGPA: ");
        double cgpa = input.nextDouble();
        input.nextLine();  // Clear newline

        System.out.print("Enter your email address: ");
        String email = input.nextLine();


        System.out.println("\n========== FORM SUMMARY ==========");
        System.out.println("Name       : " + fullName);
        System.out.println("Student ID : " + studentId);
        System.out.println("Department : " + department);
        System.out.println("CGPA       : " + cgpa);
        System.out.println("Email      : " + email);

        // Always close Scanner when done
        input.close();
        System.out.println("\nScanner closed. Program ended.");
    }
}
