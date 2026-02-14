# Class 1: Exception Handling - Exercises 🛡️

Master error handling and write resilient, production-quality code!

---

## 🟢 Easy Exercises

### Exercise 1: Safe Division
**Goal:** Handle division by zero gracefully.

**Requirements:**
1. Create a `safeDivide(int a, int b)` method
2. Use try-catch to handle `ArithmeticException`
3. Return 0 if division by zero occurs
4. Print an error message

**Test Cases:**
```java
safeDivide(10, 2);  // Returns 5
safeDivide(10, 0);  // Returns 0, prints error
safeDivide(15, 3);  // Returns 5
```

---

### Exercise 2: Number Parser
**Goal:** Safely parse strings to integers.

**Requirements:**
1. Create `parseNumber(String input)` method
2. Handle `NumberFormatException`
3. Handle `NullPointerException`
4. Return -1 for invalid inputs

**Test Cases:**
```java
parseNumber("42");    // Returns 42
parseNumber("abc");   // Returns -1
parseNumber(null);    // Returns -1
parseNumber("123");   // Returns 123
```

---

### Exercise 3: Array Access
**Goal:** Safely access array elements.

**Requirements:**
1. Create `safeGet(int[] arr, int index)` method
2. Handle `ArrayIndexOutOfBoundsException`
3. Handle null array
4. Return -1 for invalid access

**Expected Output:**
```
safeGet([1,2,3], 1) = 2
safeGet([1,2,3], 10) = -1 (with message)
safeGet(null, 0) = -1 (with message)
```

---

## 🟡 Medium Exercises

### Exercise 4: File Reader with Finally
**Goal:** Use finally for cleanup.

**Requirements:**
1. Create a method that reads a file
2. Use try-catch-finally pattern
3. Always close the reader in finally
4. Handle `FileNotFoundException` and `IOException`

**Structure:**
```java
public static void readFile(String filename) {
    BufferedReader reader = null;
    try {
        // open and read
    } catch (FileNotFoundException e) {
        // handle
    } catch (IOException e) {
        // handle
    } finally {
        // close reader
    }
}
```

---

### Exercise 5: Custom ValidationException
**Goal:** Create and use a custom exception.

**Requirements:**
1. Create `ValidationException` extending `Exception`
2. Include field name and error message
3. Create `validateEmail(String email)` that throws it
4. Email must contain "@" and "."

**Usage:**
```java
try {
    validateEmail("invalid-email");
} catch (ValidationException e) {
    System.out.println("Field: " + e.getFieldName());
    System.out.println("Error: " + e.getMessage());
}
```

---

### Exercise 6: Multiple Exception Handler
**Goal:** Handle different exceptions differently.

**Requirements:**
1. Create a method that accepts user input
2. Parse it as a number
3. Divide 100 by that number
4. Handle: null input, non-numeric input, zero input
5. Each exception should have a unique message

**Test Cases:**
```
Input: null    → "Input cannot be null"
Input: "abc"   → "Not a valid number"
Input: "0"     → "Cannot divide by zero"
Input: "5"     → "Result: 20"
```

---

## 🔴 Hard Exercises

### Exercise 7: Banking System with Custom Exceptions
**Goal:** Build a complete banking system with proper exception handling.

**Requirements:**
1. Create custom exceptions:
   - `InsufficientFundsException`
   - `InvalidAmountException`
   - `AccountNotFoundException`
   - `TransactionLimitException`

2. Create `BankAccount` class with:
   - Daily withdrawal limit ($1000)
   - Minimum balance ($10)
   - Validation on all operations

3. Create `Bank` class with multiple accounts

4. Handle all exceptions appropriately

**Test Scenarios:**
```
Withdraw more than balance → InsufficientFundsException
Withdraw negative amount   → InvalidAmountException
Exceed daily limit         → TransactionLimitException
Access non-existent acct   → AccountNotFoundException
```

---

### Exercise 8: Configuration File Parser
**Goal:** Build a robust config file parser.

**Requirements:**
1. Read key=value pairs from a file
2. Custom exceptions:
   - `ConfigFileNotFoundException`
   - `InvalidConfigFormatException`
   - `MissingRequiredKeyException`

3. Required keys: "host", "port", "timeout"
4. Validate port is a number, timeout is positive

**Sample Config:**
```
host=localhost
port=8080
timeout=30
```

**Handle all error cases gracefully.**

---

### Exercise 9: Retry Mechanism
**Goal:** Implement retry logic with exception handling.

**Requirements:**
1. Create `RetryableOperation` interface
2. Implement `executeWithRetry(operation, maxAttempts)`
3. Retry on failure up to maxAttempts times
4. Track and report all exceptions
5. Throw final exception if all attempts fail

**Structure:**
```java
interface RetryableOperation {
    void execute() throws Exception;
}

public static void executeWithRetry(
    RetryableOperation op, 
    int maxAttempts
) throws Exception {
    // Implement retry logic
}
```

**Test with an operation that fails 2 times then succeeds:**
```
Attempt 1: Failed - Connection timeout
Attempt 2: Failed - Connection timeout
Attempt 3: Success!
```

---

## ✅ Bonus Challenge

Create a **Transaction Processor** system:

1. Read transactions from a file
2. Each line: `ACCOUNT,TYPE,AMOUNT` (e.g., `ACC001,DEPOSIT,100`)
3. Process each transaction with full error handling
4. Generate a report showing:
   - Successful transactions
   - Failed transactions with reasons
   - Summary statistics

**Sample Input File:**
```
ACC001,DEPOSIT,500
ACC001,WITHDRAW,200
ACC002,WITHDRAW,1000
ACC001,INVALID,100
,DEPOSIT,50
ACC003,DEPOSIT,-50
```

**Expected Output:**
```
Transaction Report
==================
✅ ACC001 DEPOSIT $500.00 - Success
✅ ACC001 WITHDRAW $200.00 - Success
❌ ACC002 WITHDRAW $1000.00 - Account not found
❌ ACC001 INVALID $100.00 - Invalid transaction type
❌ - - - - Missing account ID
❌ ACC003 DEPOSIT -$50.00 - Amount must be positive

Summary:
  Successful: 2
  Failed: 4
  Total processed: 6
```

---

Happy coding! 💻
