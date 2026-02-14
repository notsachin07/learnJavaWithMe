/**
 * Class 1: Exception Handling - Complete Example
 *
 * Demonstrates:
 * - Basic try-catch blocks
 * - Multiple catch blocks
 * - Finally block
 * - Throwing exceptions
 * - Custom exceptions
 * - Try-with-resources
 *
 * How to compile and run:
 * $ javac ExceptionDemo.java
 * $ java ExceptionDemo
 */

import java.io.*;
import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) {
        System.out.println("========== EXCEPTION HANDLING DEMO ==========\n");

        // ================================================
        // DEMONSTRATION 1: BASIC TRY-CATCH
        // ================================================
        System.out.println("1. BASIC TRY-CATCH");
        System.out.println("─────────────────────────────────────────");

        // Without exception handling, this would crash
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }
        System.out.println("Program continues after handling exception!\n");


        // ================================================
        // DEMONSTRATION 2: MULTIPLE CATCH BLOCKS
        // ================================================
        System.out.println("2. MULTIPLE CATCH BLOCKS");
        System.out.println("─────────────────────────────────────────");

        testMultipleCatches(null);
        testMultipleCatches("abc");
        testMultipleCatches("42");
        System.out.println();


        // ================================================
        // DEMONSTRATION 3: FINALLY BLOCK
        // ================================================
        System.out.println("3. FINALLY BLOCK");
        System.out.println("─────────────────────────────────────────");

        demonstrateFinally(true);
        System.out.println();
        demonstrateFinally(false);
        System.out.println();


        // ================================================
        // DEMONSTRATION 4: THROWING EXCEPTIONS
        // ================================================
        System.out.println("4. THROWING EXCEPTIONS");
        System.out.println("─────────────────────────────────────────");

        try {
            validateAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        try {
            validateAge(25);
            System.out.println("Age 25 is valid!");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 5: CUSTOM EXCEPTIONS
        // ================================================
        System.out.println("5. CUSTOM EXCEPTIONS");
        System.out.println("─────────────────────────────────────────");

        BankAccount account = new BankAccount("ACC001", 500.0);
        System.out.println("Initial balance: $" + account.getBalance());

        try {
            account.withdraw(200.0);
            System.out.println("After withdrawal: $" + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            account.withdraw(400.0);
            System.out.println("After withdrawal: $" + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Short by: $" + e.getShortfall());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 6: EXCEPTION CHAINING
        // ================================================
        System.out.println("6. EXCEPTION CHAINING");
        System.out.println("─────────────────────────────────────────");

        try {
            processUserData("invalid");
        } catch (DataProcessingException e) {
            System.out.println("High-level error: " + e.getMessage());
            System.out.println("Caused by: " + e.getCause().getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 7: TRY-WITH-RESOURCES
        // ================================================
        System.out.println("7. TRY-WITH-RESOURCES");
        System.out.println("─────────────────────────────────────────");

        // Create a test file
        String filename = "test_exception_demo.txt";
        createTestFile(filename);

        // Read using try-with-resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("File contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
            // reader is automatically closed here
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Clean up test file
        new File(filename).delete();
        System.out.println("(File automatically closed and deleted)\n");


        // ================================================
        // DEMONSTRATION 8: EXCEPTION IN LOOPS
        // ================================================
        System.out.println("8. EXCEPTION IN LOOPS");
        System.out.println("─────────────────────────────────────────");

        String[] numbers = {"10", "20", "abc", "30", "xyz", "40"};

        int sum = 0;
        for (String num : numbers) {
            try {
                sum += Integer.parseInt(num);
                System.out.println("Parsed: " + num);
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid: " + num);
            }
        }
        System.out.println("Sum of valid numbers: " + sum);
        System.out.println();


        // ================================================
        // DEMONSTRATION 9: NESTED TRY-CATCH
        // ================================================
        System.out.println("9. NESTED TRY-CATCH");
        System.out.println("─────────────────────────────────────────");

        try {
            System.out.println("Outer try block");

            try {
                int[] arr = {1, 2, 3};
                System.out.println(arr[10]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: Array index error");
                throw new RuntimeException("Propagating error");
            }

        } catch (RuntimeException e) {
            System.out.println("Outer catch: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 10: BEST PRACTICES
        // ================================================
        System.out.println("10. BEST PRACTICES EXAMPLE");
        System.out.println("─────────────────────────────────────────");

        UserService service = new UserService();
        
        try {
            User user = service.findUser("nonexistent");
            System.out.println("Found: " + user.getName());
        } catch (UserNotFoundException e) {
            System.out.println("User not found: " + e.getUserId());
            System.out.println("Suggestion: " + e.getSuggestion());
        }


        System.out.println("\n========== END OF DEMO ==========");
    }


    // =========================================================
    // HELPER METHODS
    // =========================================================

    public static void testMultipleCatches(String input) {
        try {
            int number = Integer.parseInt(input);
            System.out.println("Parsed successfully: " + number);
        } catch (NullPointerException e) {
            System.out.println("Input was null");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: '" + input + "'");
        }
    }

    public static void demonstrateFinally(boolean causeError) {
        System.out.println("Attempting operation (causeError=" + causeError + "):");
        try {
            if (causeError) {
                throw new RuntimeException("Intentional error");
            }
            System.out.println("  Try block completed successfully");
        } catch (RuntimeException e) {
            System.out.println("  Caught: " + e.getMessage());
        } finally {
            System.out.println("  Finally block ALWAYS runs");
        }
    }

    public static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative: " + age);
        }
        if (age > 150) {
            throw new IllegalArgumentException("Age seems unrealistic: " + age);
        }
    }

    public static void processUserData(String data) throws DataProcessingException {
        try {
            // Simulate parsing that fails
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            // Wrap the low-level exception in a high-level one
            throw new DataProcessingException("Failed to process user data", e);
        }
    }

    public static void createTestFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println("Line 1: Hello");
            writer.println("Line 2: World");
            writer.println("Line 3: Exception Handling");
        } catch (IOException e) {
            System.out.println("Could not create test file");
        }
    }
}


// =========================================================
// CUSTOM EXCEPTION: InsufficientFundsException
// =========================================================
class InsufficientFundsException extends Exception {
    private double shortfall;

    public InsufficientFundsException(double shortfall) {
        super("Insufficient funds. You need $" + String.format("%.2f", shortfall) + " more.");
        this.shortfall = shortfall;
    }

    public double getShortfall() {
        return shortfall;
    }
}


// =========================================================
// CUSTOM EXCEPTION: DataProcessingException
// =========================================================
class DataProcessingException extends Exception {
    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}


// =========================================================
// CUSTOM EXCEPTION: UserNotFoundException
// =========================================================
class UserNotFoundException extends Exception {
    private String userId;
    private String suggestion;

    public UserNotFoundException(String userId, String suggestion) {
        super("User not found: " + userId);
        this.userId = userId;
        this.suggestion = suggestion;
    }

    public String getUserId() {
        return userId;
    }

    public String getSuggestion() {
        return suggestion;
    }
}


// =========================================================
// BANK ACCOUNT CLASS
// =========================================================
class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
    }
}


// =========================================================
// USER SERVICE (BEST PRACTICES EXAMPLE)
// =========================================================
class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class UserService {
    public User findUser(String userId) throws UserNotFoundException {
        // Simulate user lookup
        if (!userId.equals("admin")) {
            throw new UserNotFoundException(userId, "Try 'admin' as the user ID");
        }
        return new User(userId, "Administrator");
    }
}
