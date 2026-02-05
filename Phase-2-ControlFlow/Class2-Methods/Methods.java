/**
 * Class 2: Methods - Complete Example
 *
 * Demonstrates:
 * - Method definition and calling
 * - Methods without parameters (void)
 * - Methods with parameters
 * - Methods with return values
 * - Method overloading
 * - Variable scope
 * - Practical examples
 *
 * How to compile and run:
 * $ javac Methods.java
 * $ java Methods
 */

import java.util.Scanner;

public class Methods {

    // ================================================
    // STATIC VARIABLE (Class Level - accessible by all methods)
    // ================================================
    static int operationCount = 0;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ================================================
        // VOID METHODS (No return, no parameters)
        // ================================================
        System.out.println("========== VOID METHODS ==========");
        
        printWelcome();
        printLine();
        sayHello();
        printLine();


        // ================================================
        // METHODS WITH PARAMETERS
        // ================================================
        System.out.println("\n========== METHODS WITH PARAMETERS ==========");
        
        greet("Alice");
        greet("Bob");
        
        printLine();
        
        printPersonInfo("Charlie", 25, "New York");
        
        printLine();
        
        printRepeat("Java", 3);


        // ================================================
        // METHODS WITH RETURN VALUES
        // ================================================
        System.out.println("\n========== METHODS WITH RETURN VALUES ==========");
        
        // Storing returned values
        int sum = add(10, 5);
        System.out.println("10 + 5 = " + sum);
        
        int difference = subtract(10, 5);
        System.out.println("10 - 5 = " + difference);
        
        int product = multiply(10, 5);
        System.out.println("10 * 5 = " + product);
        
        double quotient = divide(10, 5);
        System.out.println("10 / 5 = " + quotient);
        
        // Using returned values directly
        System.out.println("\nDirect usage:");
        System.out.println("7 + 3 = " + add(7, 3));
        System.out.println("Max of 15, 8: " + max(15, 8));
        System.out.println("Min of 15, 8: " + min(15, 8));
        
        printLine();
        
        // Boolean return
        System.out.println("\nBoolean returns:");
        System.out.println("Is 4 even? " + isEven(4));
        System.out.println("Is 7 even? " + isEven(7));
        System.out.println("Is 17 prime? " + isPrime(17));
        System.out.println("Is 20 prime? " + isPrime(20));


        // ================================================
        // METHOD OVERLOADING
        // ================================================
        System.out.println("\n========== METHOD OVERLOADING ==========");
        
        // Same method name, different parameters
        System.out.println("add(5, 3) = " + add(5, 3));
        System.out.println("add(5, 3, 2) = " + add(5, 3, 2));
        System.out.println("add(5.5, 3.2) = " + add(5.5, 3.2));
        
        printLine();
        
        // Overloaded greet methods
        greet("Diana");                    // One parameter
        greet("Edward", "Good morning");   // Two parameters


        // ================================================
        // PRACTICAL EXAMPLES
        // ================================================
        System.out.println("\n========== PRACTICAL EXAMPLES ==========");
        
        // Calculator
        System.out.print("\nEnter first number: ");
        int num1 = input.nextInt();
        System.out.print("Enter second number: ");
        int num2 = input.nextInt();
        
        System.out.println("\nCalculator Results:");
        System.out.println(num1 + " + " + num2 + " = " + add(num1, num2));
        System.out.println(num1 + " - " + num2 + " = " + subtract(num1, num2));
        System.out.println(num1 + " * " + num2 + " = " + multiply(num1, num2));
        System.out.println(num1 + " / " + num2 + " = " + divide(num1, num2));
        
        printLine();
        
        // Factorial
        System.out.print("\nEnter a number for factorial: ");
        int factNum = input.nextInt();
        System.out.println(factNum + "! = " + factorial(factNum));
        
        printLine();
        
        // Circle calculations
        System.out.print("\nEnter circle radius: ");
        double radius = input.nextDouble();
        printCircleInfo(radius);
        
        printLine();
        
        // Temperature conversion
        System.out.print("\nEnter temperature in Celsius: ");
        double celsius = input.nextDouble();
        double fahrenheit = celsiusToFahrenheit(celsius);
        System.out.println(celsius + "°C = " + fahrenheit + "°F");
        
        printLine();
        
        // Formatting examples
        System.out.println("\nFormatting Examples:");
        System.out.println(formatName("John", "Doe"));
        System.out.println(formatCurrency(1234.567));
        System.out.println(formatPhone("1234567890"));


        // ================================================
        // VARIABLE SCOPE DEMONSTRATION
        // ================================================
        System.out.println("\n========== VARIABLE SCOPE ==========");
        
        demonstrateScope();
        
        System.out.println("\nOperation count (class variable): " + operationCount);


        // ================================================
        // METHODS CALLING METHODS
        // ================================================
        System.out.println("\n========== METHODS CALLING METHODS ==========");
        
        System.out.print("\nEnter a number to analyze: ");
        int analyzeNum = input.nextInt();
        analyzeNumber(analyzeNum);


        // Close scanner
        input.close();
        
        printLine();
        System.out.println("========== END OF METHODS CLASS ==========");
        System.out.println("Practice makes perfect! Try the exercises!");
    }


    // ================================================
    // VOID METHODS (No return value)
    // ================================================

    /**
     * Prints a welcome message
     */
    public static void printWelcome() {
        System.out.println("Welcome to the Methods Class!");
        System.out.println("Learn how to organize your code.");
    }

    /**
     * Prints a separator line
     */
    public static void printLine() {
        System.out.println("----------------------------------------");
    }

    /**
     * Prints a simple hello message
     */
    public static void sayHello() {
        System.out.println("Hello, World!");
    }


    // ================================================
    // METHODS WITH PARAMETERS
    // ================================================

    /**
     * Greets a person by name
     * @param name the name to greet
     */
    public static void greet(String name) {
        System.out.println("Hello, " + name + "! Nice to meet you.");
        operationCount++;
    }

    /**
     * Greets a person with a custom greeting
     * @param name the name to greet
     * @param greeting the greeting to use
     */
    public static void greet(String name, String greeting) {
        System.out.println(greeting + ", " + name + "!");
        operationCount++;
    }

    /**
     * Prints detailed person information
     * @param name person's name
     * @param age person's age
     * @param city person's city
     */
    public static void printPersonInfo(String name, int age, String city) {
        System.out.println("Person Information:");
        System.out.println("  Name: " + name);
        System.out.println("  Age: " + age);
        System.out.println("  City: " + city);
    }

    /**
     * Prints a message multiple times
     * @param message the message to print
     * @param times how many times to print
     */
    public static void printRepeat(String message, int times) {
        for (int i = 1; i <= times; i++) {
            System.out.println(i + ". " + message);
        }
    }


    // ================================================
    // METHODS WITH RETURN VALUES
    // ================================================

    /**
     * Adds two integers
     * @param a first number
     * @param b second number
     * @return the sum
     */
    public static int add(int a, int b) {
        operationCount++;
        return a + b;
    }

    /**
     * Adds three integers (overloaded)
     * @param a first number
     * @param b second number
     * @param c third number
     * @return the sum
     */
    public static int add(int a, int b, int c) {
        operationCount++;
        return a + b + c;
    }

    /**
     * Adds two doubles (overloaded)
     * @param a first number
     * @param b second number
     * @return the sum
     */
    public static double add(double a, double b) {
        operationCount++;
        return a + b;
    }

    /**
     * Subtracts two integers
     * @param a first number
     * @param b second number
     * @return the difference
     */
    public static int subtract(int a, int b) {
        operationCount++;
        return a - b;
    }

    /**
     * Multiplies two integers
     * @param a first number
     * @param b second number
     * @return the product
     */
    public static int multiply(int a, int b) {
        operationCount++;
        return a * b;
    }

    /**
     * Divides two integers
     * @param a numerator
     * @param b denominator
     * @return the quotient as double
     */
    public static double divide(int a, int b) {
        operationCount++;
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0;
        }
        return (double) a / b;
    }

    /**
     * Returns the larger of two numbers
     * @param a first number
     * @param b second number
     * @return the maximum value
     */
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Returns the smaller of two numbers
     * @param a first number
     * @param b second number
     * @return the minimum value
     */
    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    /**
     * Checks if a number is even
     * @param number the number to check
     * @return true if even, false if odd
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Checks if a number is prime
     * @param n the number to check
     * @return true if prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Calculates factorial of a number
     * @param n the number
     * @return factorial of n
     */
    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Error: Factorial not defined for negative numbers!");
            return -1;
        }
        
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }


    // ================================================
    // CIRCLE METHODS (Methods calling methods)
    // ================================================

    /**
     * Calculates the area of a circle
     * @param radius the radius
     * @return the area
     */
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    /**
     * Calculates the circumference of a circle
     * @param radius the radius
     * @return the circumference
     */
    public static double calculateCircleCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    /**
     * Prints all information about a circle
     * @param radius the radius
     */
    public static void printCircleInfo(double radius) {
        System.out.println("Circle Information:");
        System.out.println("  Radius: " + radius);
        System.out.printf("  Area: %.2f%n", calculateCircleArea(radius));
        System.out.printf("  Circumference: %.2f%n", calculateCircleCircumference(radius));
    }


    // ================================================
    // TEMPERATURE CONVERSION
    // ================================================

    /**
     * Converts Celsius to Fahrenheit
     * @param celsius temperature in Celsius
     * @return temperature in Fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    /**
     * Converts Fahrenheit to Celsius
     * @param fahrenheit temperature in Fahrenheit
     * @return temperature in Celsius
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }


    // ================================================
    // FORMATTING METHODS
    // ================================================

    /**
     * Formats a name as "Last, First"
     * @param firstName first name
     * @param lastName last name
     * @return formatted name
     */
    public static String formatName(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    /**
     * Formats a number as currency
     * @param amount the amount
     * @return formatted currency string
     */
    public static String formatCurrency(double amount) {
        return String.format("$%.2f", amount);
    }

    /**
     * Formats a 10-digit phone number
     * @param phone the phone number (10 digits)
     * @return formatted phone number
     */
    public static String formatPhone(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        return "(" + phone.substring(0, 3) + ") " + 
               phone.substring(3, 6) + "-" + 
               phone.substring(6);
    }


    // ================================================
    // SCOPE DEMONSTRATION
    // ================================================

    /**
     * Demonstrates variable scope
     */
    public static void demonstrateScope() {
        int localVar = 100;  // Local to this method
        System.out.println("Local variable in demonstrateScope(): " + localVar);
        
        // Block scope
        if (true) {
            int blockVar = 200;  // Only exists in this block
            System.out.println("Block variable: " + blockVar);
            System.out.println("Can access local variable here: " + localVar);
        }
        
        // blockVar doesn't exist here
        // System.out.println(blockVar);  // Would cause error
        
        System.out.println("Class variable accessible: " + operationCount);
    }


    // ================================================
    // COMPREHENSIVE ANALYSIS
    // ================================================

    /**
     * Analyzes a number using multiple methods
     * @param number the number to analyze
     */
    public static void analyzeNumber(int number) {
        System.out.println("\nAnalysis of " + number + ":");
        System.out.println("  Even? " + isEven(number));
        System.out.println("  Prime? " + isPrime(number));
        
        if (number >= 0) {
            System.out.println("  Factorial: " + factorial(number));
        }
        
        System.out.println("  Doubled: " + multiply(number, 2));
        System.out.println("  Squared: " + multiply(number, number));
    }
}
