/**
 * Class 5: Conditional Statements - Complete Example
 *
 * Demonstrates:
 * - if statement
 * - if-else statement
 * - else if statement (multiple conditions)
 * - nested if statements
 * - switch statement
 * - ternary operator
 * - logical operators with conditionals
 *
 * How to compile and run:
 * $ javac ConditionalStatements.java
 * $ java ConditionalStatements
 */

import java.util.Scanner;

public class ConditionalStatements {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ================================================
        // IF STATEMENT
        // ================================================
        System.out.println("========== IF STATEMENT ==========");
        System.out.print("Enter your age: ");
        int age = input.nextInt();

        if (age >= 18) {
            System.out.println("You are an adult.");
        }


        // ================================================
        // IF-ELSE STATEMENT
        // ================================================
        System.out.println("\n========== IF-ELSE STATEMENT ==========");
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }


        // ================================================
        // ELSE IF STATEMENT (Multiple paths)
        // ================================================
        System.out.println("\n========== ELSE IF STATEMENT ==========");
        System.out.print("Enter your exam score (0-100): ");
        int score = input.nextInt();

        if (score >= 90) {
            System.out.println("Grade: A (Excellent!)");
        } else if (score >= 80) {
            System.out.println("Grade: B (Very Good)");
        } else if (score >= 70) {
            System.out.println("Grade: C (Good)");
        } else if (score >= 60) {
            System.out.println("Grade: D (Pass)");
        } else {
            System.out.println("Grade: F (Fail)");
        }


        // ================================================
        // NESTED IF STATEMENT
        // ================================================
        System.out.println("\n========== NESTED IF STATEMENT ==========");
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number > 0) {
            System.out.println("The number is positive.");

            // Nested if
            if (number % 2 == 0) {
                System.out.println("And it is even.");
            } else {
                System.out.println("And it is odd.");
            }
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }


        // ================================================
        // SWITCH STATEMENT
        // ================================================
        System.out.println("\n========== SWITCH STATEMENT ==========");
        System.out.print("Enter day of week (1-7): ");
        int day = input.nextInt();

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day number!");
        }


        // ================================================
        // SWITCH WITH MULTIPLE CASES
        // ================================================
        System.out.println("\n========== SWITCH - MULTIPLE CASES ==========");
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();

        int daysInMonth;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                daysInMonth = 31;
                break;
            case 4: case 6: case 9: case 11:
                daysInMonth = 30;
                break;
            case 2:
                daysInMonth = 28;  // Ignoring leap years for simplicity
                break;
            default:
                daysInMonth = -1;
        }

        if (daysInMonth != -1) {
            System.out.println("Month " + month + " has " + daysInMonth + " days.");
        } else {
            System.out.println("Invalid month!");
        }


        // ================================================
        // LOGICAL OPERATORS IN IF
        // ================================================
        System.out.println("\n========== LOGICAL OPERATORS ==========");
        System.out.print("Enter your age: ");
        int userAge = input.nextInt();

        System.out.print("Do you have a driving license? (true/false): ");
        boolean hasLicense = input.nextBoolean();

        if (userAge >= 18 && hasLicense) {
            System.out.println("✓ You can drive!");
        } else if (userAge >= 18 && !hasLicense) {
            System.out.println("You are old enough but need to get a license.");
        } else if (userAge < 18 && hasLicense) {
            System.out.println("You have a license but are too young to drive.");
        } else {
            System.out.println("You are too young and don't have a license.");
        }


        // ================================================
        // TERNARY OPERATOR (shorthand if-else)
        // ================================================
        System.out.println("\n========== TERNARY OPERATOR ==========");
        System.out.print("Enter a number: ");
        int num = input.nextInt();

        // Using if-else (verbose)
        String result1;
        if (num % 2 == 0) {
            result1 = "Even";
        } else {
            result1 = "Odd";
        }
        System.out.println("Using if-else: " + result1);

        // Using ternary operator (concise)
        String result2 = (num % 2 == 0) ? "Even" : "Odd";
        System.out.println("Using ternary: " + result2);


        // ================================================
        // NESTED TERNARY (multiple conditions)
        // ================================================
        System.out.println("\n========== NESTED TERNARY ==========");
        System.out.print("Enter marks (0-100): ");
        int marks = input.nextInt();

        String grade = (marks >= 90) ? "A+" :
                       (marks >= 80) ? "A" :
                       (marks >= 70) ? "B" :
                       (marks >= 60) ? "C" : "F";

        System.out.println("Your grade: " + grade);


        // ================================================
        // PRACTICAL EXAMPLE: Login System
        // ================================================
        System.out.println("\n========== LOGIN SYSTEM ==========");
        input.nextLine();  // Clear newline

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (username.equals("admin") && password.equals("password123")) {
            System.out.println("✓ Login successful!");
        } else if (username.equals("admin")) {
            System.out.println("✗ Wrong password!");
        } else if (password.equals("password123")) {
            System.out.println("✗ User not found!");
        } else {
            System.out.println("✗ Invalid credentials!");
        }

        input.close();
    }
}
