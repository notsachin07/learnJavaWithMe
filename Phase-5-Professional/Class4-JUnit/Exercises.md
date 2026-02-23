# 🧪 Class 4: Unit Testing with JUnit - Exercises

Practice writing unit tests from simple assertions to complex mocking scenarios!

---

## 📝 Exercise Format

Each exercise includes:
- **Objective**: What to test
- **Requirements**: Specific testing requirements
- **Hints**: Testing tips
- **Expected Output**: Sample test results

---

## 🟢 Easy Exercises

### Exercise 1: MathUtils Tests
**Objective:** Write comprehensive tests for a math utility class.

**Code to Test:**
```java
public class MathUtils {
    
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
    
    public static int min(int a, int b) {
        return a < b ? a : b;
    }
    
    public static int abs(int n) {
        return n < 0 ? -n : n;
    }
    
    public static boolean isPositive(int n) {
        return n > 0;
    }
    
    public static boolean isNegative(int n) {
        return n < 0;
    }
    
    public static int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
}
```

**Requirements:**
1. Test `max()` with:
   - Two positive numbers
   - Two negative numbers
   - Equal numbers
   - One positive, one negative
2. Test `min()` with same scenarios
3. Test `abs()` with positive, negative, and zero
4. Test `isPositive()` and `isNegative()` edge cases
5. Test `clamp()` with value inside, below, and above range

**Hints:**
- Use `@DisplayName` for readable test names
- Group related tests with `@Nested`
- Test edge cases like `Integer.MAX_VALUE`

**Expected Test Results:**
```
MathUtils Tests
├── max() method
│   ├── ✓ returns larger of two positive numbers
│   ├── ✓ returns larger of two negative numbers
│   ├── ✓ returns either when equal
│   └── ✓ handles positive and negative
├── min() method
│   ├── ✓ returns smaller of two positive numbers
│   └── ...
├── abs() method
│   ├── ✓ positive number returns same
│   ├── ✓ negative number returns positive
│   └── ✓ zero returns zero
└── clamp() method
    ├── ✓ value in range returns value
    ├── ✓ value below range returns min
    └── ✓ value above range returns max

Tests: 15 passed
```

---

### Exercise 2: Password Validator Tests
**Objective:** Write tests for a password validation class.

**Code to Test:**
```java
public class PasswordValidator {
    
    public ValidationResult validate(String password) {
        if (password == null || password.isEmpty()) {
            return new ValidationResult(false, "Password cannot be empty");
        }
        if (password.length() < 8) {
            return new ValidationResult(false, "Password must be at least 8 characters");
        }
        if (password.length() > 128) {
            return new ValidationResult(false, "Password cannot exceed 128 characters");
        }
        if (!password.matches(".*[A-Z].*")) {
            return new ValidationResult(false, "Password must contain uppercase letter");
        }
        if (!password.matches(".*[a-z].*")) {
            return new ValidationResult(false, "Password must contain lowercase letter");
        }
        if (!password.matches(".*\\d.*")) {
            return new ValidationResult(false, "Password must contain a number");
        }
        if (!password.matches(".*[!@#$%^&*].*")) {
            return new ValidationResult(false, "Password must contain special character");
        }
        return new ValidationResult(true, "Password is valid");
    }
}

record ValidationResult(boolean isValid, String message) {}
```

**Requirements:**
1. Test null password
2. Test empty password
3. Test password too short
4. Test password too long
5. Test missing uppercase
6. Test missing lowercase
7. Test missing number
8. Test missing special character
9. Test valid password

**Hints:**
- Use `assertAll()` to check both `isValid` and `message`
- Test boundary conditions (7 chars, 8 chars, 128 chars, 129 chars)
- Create helper method for creating test passwords

**Expected Test Results:**
```
PasswordValidator Tests
├── Empty/Null Passwords
│   ├── ✓ null password returns invalid with message
│   └── ✓ empty password returns invalid with message
├── Length Validation
│   ├── ✓ 7 character password is too short
│   ├── ✓ 8 character password passes length check
│   └── ✓ 129 character password is too long
├── Character Requirements
│   ├── ✓ missing uppercase is invalid
│   ├── ✓ missing lowercase is invalid
│   ├── ✓ missing number is invalid
│   └── ✓ missing special character is invalid
└── Valid Passwords
    └── ✓ password meeting all criteria is valid

Tests: 10 passed
```

---

### Exercise 3: Shopping Cart Tests
**Objective:** Write tests for a shopping cart with basic operations.

**Code to Test:**
```java
public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();
    
    public void addItem(String productId, String name, double price, int quantity) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        if (quantity < 1) throw new IllegalArgumentException("Quantity must be at least 1");
        
        // Check if item exists
        for (CartItem item : items) {
            if (item.productId().equals(productId)) {
                items.remove(item);
                items.add(new CartItem(productId, name, price, item.quantity() + quantity));
                return;
            }
        }
        items.add(new CartItem(productId, name, price, quantity));
    }
    
    public void removeItem(String productId) {
        items.removeIf(item -> item.productId().equals(productId));
    }
    
    public int getItemCount() {
        return items.stream().mapToInt(CartItem::quantity).sum();
    }
    
    public double getTotal() {
        return items.stream()
            .mapToDouble(item -> item.price() * item.quantity())
            .sum();
    }
    
    public void clear() {
        items.clear();
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }
}

record CartItem(String productId, String name, double price, int quantity) {}
```

**Requirements:**
1. Test adding single item
2. Test adding multiple different items
3. Test adding same item increases quantity
4. Test removing item
5. Test getting total
6. Test clearing cart
7. Test negative price throws exception
8. Test zero quantity throws exception

**Hints:**
- Use `@BeforeEach` to create fresh cart for each test
- Test the empty cart state
- Verify item count and total after operations

**Expected Test Results:**
```
ShoppingCart Tests
├── Adding Items
│   ├── ✓ adding item to empty cart
│   ├── ✓ adding multiple items
│   ├── ✓ adding same item increases quantity
│   ├── ✓ negative price throws exception
│   └── ✓ zero quantity throws exception
├── Removing Items
│   ├── ✓ removing existing item
│   └── ✓ removing non-existing item (no error)
├── Calculations
│   ├── ✓ total of empty cart is 0
│   ├── ✓ total with single item
│   └── ✓ total with multiple items
└── Cart State
    ├── ✓ new cart is empty
    ├── ✓ clear removes all items
    └── ✓ item count is sum of quantities

Tests: 13 passed
```

---

## 🟡 Medium Exercises

### Exercise 4: Parameterized Email Validator
**Objective:** Write parameterized tests for email validation.

**Code to Test:**
```java
public class EmailValidator {
    
    private static final String EMAIL_REGEX = 
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    
    public boolean isValid(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches(EMAIL_REGEX);
    }
    
    public String getDomain(String email) {
        if (!isValid(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        return email.substring(email.indexOf('@') + 1);
    }
    
    public String getLocalPart(String email) {
        if (!isValid(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        return email.substring(0, email.indexOf('@'));
    }
}
```

**Requirements:**
1. Use `@ParameterizedTest` with `@ValueSource` for valid emails
2. Use `@ParameterizedTest` with `@ValueSource` for invalid emails
3. Use `@CsvSource` to test domain extraction
4. Use `@CsvSource` to test local part extraction
5. Use `@NullAndEmptySource` for null/empty tests
6. Test at least 10 valid and 10 invalid email formats

**Valid Email Examples:**
```
test@example.com
user.name@domain.org
user+tag@example.co.uk
123@numbers.com
```

**Invalid Email Examples:**
```
invalid (no @)
@nodomain.com (no local part)
no@domain (no TLD)
double@@at.com
spaces in@email.com
```

**Hints:**
- Use `@MethodSource` for complex test cases
- Include edge cases like single letter domain
- Test international domains

**Expected Test Results:**
```
EmailValidator Parameterized Tests
├── Valid Emails
│   ├── ✓ test@example.com is valid
│   ├── ✓ user.name@domain.org is valid
│   ├── ✓ user+tag@example.co.uk is valid
│   └── ... (10 more)
├── Invalid Emails
│   ├── ✓ null is invalid
│   ├── ✓ empty string is invalid
│   ├── ✓ 'invalid' is invalid (no @)
│   └── ... (10 more)
├── Domain Extraction
│   ├── ✓ test@example.com → example.com
│   └── ✓ user@sub.domain.org → sub.domain.org
└── Local Part Extraction
    ├── ✓ test@example.com → test
    └── ✓ user.name@domain.org → user.name

Tests: 30+ passed
```

---

### Exercise 5: Order Service with Mocking
**Objective:** Write tests using mocks for an order service.

**Code to Test:**
```java
public interface ProductRepository {
    Product findById(String id);
    void updateStock(String id, int quantity);
    boolean hasStock(String id, int quantity);
}

public interface PaymentService {
    PaymentResult processPayment(String orderId, double amount, PaymentMethod method);
}

public interface NotificationService {
    void sendOrderConfirmation(String email, Order order);
    void sendPaymentReceipt(String email, PaymentResult payment);
}

public class OrderService {
    private final ProductRepository productRepo;
    private final PaymentService paymentService;
    private final NotificationService notificationService;
    
    public OrderService(ProductRepository productRepo, 
                       PaymentService paymentService,
                       NotificationService notificationService) {
        this.productRepo = productRepo;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }
    
    public Order createOrder(String customerId, String email, 
                            List<OrderItem> items, PaymentMethod paymentMethod) {
        // Validate stock
        for (OrderItem item : items) {
            if (!productRepo.hasStock(item.productId(), item.quantity())) {
                throw new InsufficientStockException(item.productId());
            }
        }
        
        // Calculate total
        double total = 0;
        for (OrderItem item : items) {
            Product product = productRepo.findById(item.productId());
            total += product.price() * item.quantity();
        }
        
        // Create order
        Order order = new Order(generateOrderId(), customerId, items, total);
        
        // Process payment
        PaymentResult payment = paymentService.processPayment(
            order.id(), total, paymentMethod);
        
        if (!payment.success()) {
            throw new PaymentFailedException(payment.message());
        }
        
        // Update stock
        for (OrderItem item : items) {
            productRepo.updateStock(item.productId(), -item.quantity());
        }
        
        // Send notifications
        notificationService.sendOrderConfirmation(email, order);
        notificationService.sendPaymentReceipt(email, payment);
        
        return order;
    }
    
    private String generateOrderId() {
        return "ORD-" + System.currentTimeMillis();
    }
}
```

**Requirements:**
1. Mock all three dependencies
2. Test successful order creation:
   - Verify stock check is called
   - Verify payment is processed
   - Verify stock is updated
   - Verify notifications are sent
3. Test insufficient stock scenario
4. Test payment failure scenario
5. Use `ArgumentCaptor` to verify notification content
6. Verify order of operations with `InOrder`

**Hints:**
- Use `@Mock` and `@InjectMocks` annotations
- Use `when().thenReturn()` for stubbing
- Use `verify()` with matchers
- Use `ArgumentCaptor` to capture arguments

**Expected Test Results:**
```
OrderService Tests
├── Successful Order
│   ├── ✓ checks stock for all items
│   ├── ✓ processes payment with correct amount
│   ├── ✓ updates stock after payment
│   ├── ✓ sends order confirmation email
│   ├── ✓ sends payment receipt email
│   └── ✓ returns order with correct total
├── Insufficient Stock
│   ├── ✓ throws InsufficientStockException
│   ├── ✓ does not process payment
│   └── ✓ does not send notifications
├── Payment Failure
│   ├── ✓ throws PaymentFailedException
│   ├── ✓ does not update stock
│   └── ✓ does not send notifications
└── Verification
    ├── ✓ operations happen in correct order
    └── ✓ notification contains order details

Tests: 14 passed
```

---

### Exercise 6: Date/Time Calculator Tests
**Objective:** Test a date/time utility class with complex scenarios.

**Code to Test:**
```java
public class DateTimeCalculator {
    
    public int daysBetween(LocalDate start, LocalDate end) {
        return (int) ChronoUnit.DAYS.between(start, end);
    }
    
    public boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
    
    public int workingDaysBetween(LocalDate start, LocalDate end) {
        int workDays = 0;
        LocalDate current = start;
        while (!current.isAfter(end)) {
            if (!isWeekend(current)) {
                workDays++;
            }
            current = current.plusDays(1);
        }
        return workDays;
    }
    
    public LocalDate addWorkingDays(LocalDate start, int days) {
        LocalDate result = start;
        int added = 0;
        while (added < days) {
            result = result.plusDays(1);
            if (!isWeekend(result)) {
                added++;
            }
        }
        return result;
    }
    
    public boolean isLeapYear(int year) {
        return Year.of(year).isLeap();
    }
    
    public int getQuarter(LocalDate date) {
        return (date.getMonthValue() - 1) / 3 + 1;
    }
    
    public LocalDate getLastDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }
}
```

**Requirements:**
1. Test `daysBetween()` with various date ranges
2. Test `isWeekend()` for all days of the week
3. Test `workingDaysBetween()` including weeks with weekends
4. Test `addWorkingDays()` across weekends
5. Test `isLeapYear()` with leap and non-leap years
6. Test `getQuarter()` for all 12 months
7. Test `getLastDayOfMonth()` for various months including February in leap years

**Hints:**
- Use `@ParameterizedTest` with `@EnumSource` for days of week
- Use `@CsvSource` with date strings
- Test edge cases like year boundaries

**Expected Test Results:**
```
DateTimeCalculator Tests
├── daysBetween()
│   ├── ✓ same day returns 0
│   ├── ✓ consecutive days returns 1
│   └── ✓ negative for reversed dates
├── isWeekend()
│   ├── ✓ Saturday is weekend
│   ├── ✓ Sunday is weekend
│   └── ✓ weekdays are not weekend [5 tests]
├── workingDaysBetween()
│   ├── ✓ full week has 5 working days
│   ├── ✓ weekend only has 0 working days
│   └── ✓ two weeks has 10 working days
├── addWorkingDays()
│   ├── ✓ adding 5 days from Monday lands on Monday
│   └── ✓ adding 1 day from Friday lands on Monday
├── isLeapYear()
│   ├── ✓ 2024 is leap year
│   ├── ✓ 2023 is not leap year
│   ├── ✓ 2000 is leap year (divisible by 400)
│   └── ✓ 1900 is not leap year (divisible by 100)
├── getQuarter()
│   └── ✓ all months return correct quarter [12 tests]
└── getLastDayOfMonth()
    ├── ✓ January has 31 days
    ├── ✓ February has 28/29 days
    ├── ✓ April has 30 days
    └── ✓ leap year February has 29 days

Tests: 35+ passed
```

---

## 🔴 Hard Exercises

### Exercise 7: Banking System with State Testing
**Objective:** Write comprehensive tests for a banking system with complex state.

**Code to Test:**
```java
public class BankAccount {
    private String accountId;
    private String ownerName;
    private double balance;
    private AccountStatus status;
    private List<Transaction> transactions;
    private double dailyLimit;
    private double dailyWithdrawn;
    private LocalDate lastTransactionDate;
    
    public enum AccountStatus { ACTIVE, FROZEN, CLOSED }
    
    public BankAccount(String accountId, String ownerName, double initialDeposit) {
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative");
        }
        this.accountId = accountId;
        this.ownerName = ownerName;
        this.balance = initialDeposit;
        this.status = AccountStatus.ACTIVE;
        this.transactions = new ArrayList<>();
        this.dailyLimit = 1000.0;
        this.dailyWithdrawn = 0;
        this.lastTransactionDate = LocalDate.now();
        
        if (initialDeposit > 0) {
            transactions.add(new Transaction(TransactionType.DEPOSIT, 
                initialDeposit, "Initial deposit"));
        }
    }
    
    public void deposit(double amount) {
        validateActive();
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        transactions.add(new Transaction(TransactionType.DEPOSIT, amount, "Deposit"));
    }
    
    public void withdraw(double amount) {
        validateActive();
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance");
        }
        
        resetDailyLimitIfNeeded();
        
        if (dailyWithdrawn + amount > dailyLimit) {
            throw new DailyLimitExceededException("Daily withdrawal limit exceeded");
        }
        
        balance -= amount;
        dailyWithdrawn += amount;
        lastTransactionDate = LocalDate.now();
        transactions.add(new Transaction(TransactionType.WITHDRAWAL, amount, "Withdrawal"));
    }
    
    public void transfer(BankAccount target, double amount) {
        validateActive();
        target.validateActive();
        
        this.withdraw(amount);
        target.deposit(amount);
        
        // Update transaction descriptions
        transactions.get(transactions.size() - 1)
            .setDescription("Transfer to " + target.accountId);
        target.transactions.get(target.transactions.size() - 1)
            .setDescription("Transfer from " + this.accountId);
    }
    
    public void freeze() {
        if (status == AccountStatus.CLOSED) {
            throw new IllegalStateException("Cannot freeze closed account");
        }
        status = AccountStatus.FROZEN;
    }
    
    public void unfreeze() {
        if (status != AccountStatus.FROZEN) {
            throw new IllegalStateException("Account is not frozen");
        }
        status = AccountStatus.ACTIVE;
    }
    
    public void close() {
        if (balance > 0) {
            throw new IllegalStateException("Cannot close account with positive balance");
        }
        status = AccountStatus.CLOSED;
    }
    
    private void validateActive() {
        if (status != AccountStatus.ACTIVE) {
            throw new AccountNotActiveException("Account is " + status);
        }
    }
    
    private void resetDailyLimitIfNeeded() {
        if (!LocalDate.now().equals(lastTransactionDate)) {
            dailyWithdrawn = 0;
        }
    }
    
    // Getters...
}

record Transaction(TransactionType type, double amount, String description) {
    private String description; // mutable for transfer updates
}

enum TransactionType { DEPOSIT, WITHDRAWAL, TRANSFER }
```

**Requirements:**
1. Test account creation with various initial deposits
2. Test deposit scenarios (valid, invalid, on frozen account)
3. Test withdrawal scenarios:
   - Valid withdrawal
   - Insufficient funds
   - Daily limit exceeded
   - On frozen/closed account
4. Test transfer between accounts
5. Test account status transitions (freeze, unfreeze, close)
6. Test daily limit reset
7. Test transaction history
8. Use nested test classes for organization

**Expected Test Results:**
```
BankAccount Tests
├── Account Creation
│   ├── ✓ creates with valid initial deposit
│   ├── ✓ creates with zero initial deposit
│   └── ✓ rejects negative initial deposit
├── Deposits
│   ├── ✓ increases balance
│   ├── ✓ adds transaction to history
│   ├── ✓ rejects zero amount
│   ├── ✓ rejects negative amount
│   └── ✓ fails on frozen account
├── Withdrawals
│   ├── ✓ decreases balance
│   ├── ✓ fails with insufficient funds
│   ├── ✓ fails when exceeding daily limit
│   ├── ✓ multiple withdrawals within daily limit
│   └── ✓ daily limit resets next day
├── Transfers
│   ├── ✓ updates both account balances
│   ├── ✓ creates transactions in both accounts
│   ├── ✓ fails if source has insufficient funds
│   └── ✓ fails if either account is frozen
├── Account Status
│   ├── ✓ freeze changes status
│   ├── ✓ unfreeze restores active status
│   ├── ✓ cannot freeze closed account
│   ├── ✓ cannot close account with balance
│   └── ✓ operations fail on closed account
└── Transaction History
    ├── ✓ tracks all operations
    └── ✓ stores correct amounts and types

Tests: 25+ passed
```

---

### Exercise 8: REST API Client with Retries
**Objective:** Test an HTTP client with retry logic using mocks.

**Code to Test:**
```java
public interface HttpClient {
    HttpResponse get(String url) throws IOException;
    HttpResponse post(String url, String body) throws IOException;
}

public record HttpResponse(int statusCode, String body, Map<String, String> headers) {
    public boolean isSuccess() { return statusCode >= 200 && statusCode < 300; }
    public boolean isRetryable() { return statusCode == 429 || statusCode >= 500; }
}

public class ApiClient {
    private final HttpClient httpClient;
    private final int maxRetries;
    private final long retryDelayMs;
    
    public ApiClient(HttpClient httpClient, int maxRetries, long retryDelayMs) {
        this.httpClient = httpClient;
        this.maxRetries = maxRetries;
        this.retryDelayMs = retryDelayMs;
    }
    
    public <T> T get(String url, Class<T> responseType) throws ApiException {
        HttpResponse response = executeWithRetry(() -> httpClient.get(url));
        return parseResponse(response, responseType);
    }
    
    public <T> T post(String url, Object body, Class<T> responseType) throws ApiException {
        String jsonBody = toJson(body);
        HttpResponse response = executeWithRetry(() -> httpClient.post(url, jsonBody));
        return parseResponse(response, responseType);
    }
    
    private HttpResponse executeWithRetry(HttpSupplier supplier) throws ApiException {
        int attempts = 0;
        Exception lastException = null;
        
        while (attempts <= maxRetries) {
            try {
                HttpResponse response = supplier.get();
                
                if (response.isSuccess()) {
                    return response;
                }
                
                if (!response.isRetryable()) {
                    throw new ApiException("Request failed: " + response.statusCode());
                }
                
                // Retryable error
                attempts++;
                if (attempts <= maxRetries) {
                    Thread.sleep(retryDelayMs * attempts);  // Exponential backoff
                }
            } catch (IOException e) {
                lastException = e;
                attempts++;
                if (attempts <= maxRetries) {
                    try {
                        Thread.sleep(retryDelayMs * attempts);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new ApiException("Interrupted", ie);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new ApiException("Interrupted", e);
            }
        }
        
        throw new ApiException("Max retries exceeded", lastException);
    }
    
    @FunctionalInterface
    interface HttpSupplier {
        HttpResponse get() throws IOException;
    }
    
    // JSON parsing methods...
}
```

**Requirements:**
1. Test successful GET request (no retries needed)
2. Test successful POST request
3. Test retry on 500 error, then success
4. Test retry on 429 (rate limited), then success
5. Test retry on IOException, then success
6. Test max retries exceeded
7. Test non-retryable errors (400, 401, 404) don't retry
8. Verify number of retry attempts
9. Verify retry delay (use mocking to verify timing behavior)

**Hints:**
- Use `when().thenReturn()` for first call, `thenReturn()` for subsequent
- Use `verify(mock, times(n))` to check call count
- Mock `Thread.sleep` or use short delays in tests
- Use `doThrow().doReturn()` pattern for exception then success

**Expected Test Results:**
```
ApiClient Tests
├── Successful Requests
│   ├── ✓ GET returns parsed response
│   ├── ✓ POST sends body and returns response
│   └── ✓ no retries on success
├── Retry Behavior
│   ├── ✓ retries on 500 error
│   ├── ✓ retries on 429 rate limit
│   ├── ✓ retries on IOException
│   ├── ✓ succeeds after transient failure
│   └── ✓ retries correct number of times
├── Non-Retryable Errors
│   ├── ✓ 400 throws immediately
│   ├── ✓ 401 throws immediately
│   ├── ✓ 404 throws immediately
│   └── ✓ no retries for client errors
├── Max Retries
│   ├── ✓ throws after max retries
│   └── ✓ exception contains last error
└── Timing (optional)
    └── ✓ exponential backoff between retries

Tests: 15+ passed
```

---

### Exercise 9: Integration Test Suite
**Objective:** Create a complete test suite for a mini application.

**System to Test:**
```java
// Complete task management system
public class TaskManager {
    private final TaskRepository taskRepo;
    private final UserRepository userRepo;
    private final NotificationService notifications;
    private final AuditLogger auditLogger;
    
    public Task createTask(String title, String description, String assigneeId) {
        User assignee = userRepo.findById(assigneeId)
            .orElseThrow(() -> new UserNotFoundException(assigneeId));
        
        Task task = new Task(generateId(), title, description, 
            TaskStatus.TODO, assignee, LocalDateTime.now());
        
        task = taskRepo.save(task);
        notifications.notifyAssignment(assignee, task);
        auditLogger.log(AuditEvent.TASK_CREATED, task.id());
        
        return task;
    }
    
    public Task updateStatus(String taskId, TaskStatus newStatus, String userId) {
        Task task = taskRepo.findById(taskId)
            .orElseThrow(() -> new TaskNotFoundException(taskId));
        
        User user = userRepo.findById(userId)
            .orElseThrow(() -> new UserNotFoundException(userId));
        
        if (!canTransition(task.status(), newStatus)) {
            throw new InvalidStatusTransitionException(task.status(), newStatus);
        }
        
        Task updatedTask = task.withStatus(newStatus);
        updatedTask = taskRepo.save(updatedTask);
        
        if (newStatus == TaskStatus.DONE) {
            notifications.notifyCompletion(task.assignee(), updatedTask);
        }
        
        auditLogger.log(AuditEvent.STATUS_CHANGED, taskId, 
            task.status().name(), newStatus.name());
        
        return updatedTask;
    }
    
    public List<Task> getTasksForUser(String userId) {
        userRepo.findById(userId)
            .orElseThrow(() -> new UserNotFoundException(userId));
        return taskRepo.findByAssigneeId(userId);
    }
    
    public void deleteTask(String taskId, String userId) {
        Task task = taskRepo.findById(taskId)
            .orElseThrow(() -> new TaskNotFoundException(taskId));
        
        User user = userRepo.findById(userId)
            .orElseThrow(() -> new UserNotFoundException(userId));
        
        if (!task.assignee().id().equals(userId) && !user.isAdmin()) {
            throw new UnauthorizedException("Not authorized to delete this task");
        }
        
        taskRepo.delete(taskId);
        auditLogger.log(AuditEvent.TASK_DELETED, taskId, userId);
    }
    
    private boolean canTransition(TaskStatus from, TaskStatus to) {
        return switch (from) {
            case TODO -> to == TaskStatus.IN_PROGRESS;
            case IN_PROGRESS -> to == TaskStatus.DONE || to == TaskStatus.TODO;
            case DONE -> to == TaskStatus.TODO;  // Reopen
        };
    }
}

enum TaskStatus { TODO, IN_PROGRESS, DONE }
enum AuditEvent { TASK_CREATED, STATUS_CHANGED, TASK_DELETED }
```

**Requirements:**
Write a complete test suite including:

1. **Unit Tests (with mocks):**
   - TaskManager.createTask()
   - TaskManager.updateStatus()
   - TaskManager.getTasksForUser()
   - TaskManager.deleteTask()

2. **Test Coverage:**
   - All happy paths
   - All error scenarios
   - All status transitions (valid and invalid)
   - Authorization checks

3. **Test Organization:**
   - Use `@Nested` classes for organization
   - Use `@DisplayName` for documentation
   - Use `@Tag` for categorization

4. **Verification:**
   - Verify all repository calls
   - Verify all notification calls
   - Verify all audit log calls
   - Use `ArgumentCaptor` for complex verifications

**Expected Test Structure:**
```
TaskManager Test Suite
├── createTask Tests
│   ├── Happy Path
│   │   ├── ✓ creates task with valid data
│   │   ├── ✓ notifies assignee
│   │   └── ✓ logs audit event
│   └── Error Scenarios
│       └── ✓ throws for unknown assignee
├── updateStatus Tests
│   ├── Valid Transitions
│   │   ├── ✓ TODO → IN_PROGRESS
│   │   ├── ✓ IN_PROGRESS → DONE
│   │   ├── ✓ IN_PROGRESS → TODO
│   │   └── ✓ DONE → TODO (reopen)
│   ├── Invalid Transitions
│   │   ├── ✓ TODO → DONE throws
│   │   └── ✓ DONE → IN_PROGRESS throws
│   ├── Notifications
│   │   ├── ✓ notifies on completion
│   │   └── ✓ no notification for other transitions
│   └── Error Scenarios
│       ├── ✓ throws for unknown task
│       └── ✓ throws for unknown user
├── getTasksForUser Tests
│   ├── ✓ returns tasks for valid user
│   ├── ✓ returns empty list if no tasks
│   └── ✓ throws for unknown user
└── deleteTask Tests
    ├── Authorization
    │   ├── ✓ assignee can delete own task
    │   ├── ✓ admin can delete any task
    │   └── ✓ non-assignee non-admin cannot delete
    ├── Audit
    │   └── ✓ logs deletion with user id
    └── Error Scenarios
        ├── ✓ throws for unknown task
        └── ✓ throws for unknown user

Tests: 25+ passed
```

---

## 🏆 Bonus Challenge: Test Coverage Analysis

**Objective:** Achieve 100% test coverage for a complex class.

**Requirements:**
1. Choose any medium-sized class from previous exercises
2. Write tests to achieve:
   - 100% line coverage
   - 100% branch coverage
   - 100% mutation coverage (optional)
3. Use JaCoCo for coverage reporting
4. Document any uncoverable lines and why

**Setup JaCoCo:**
```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.10</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>test</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

**Expected Output:**
```
=== JaCoCo Coverage Report ===

Class: BankAccount
├── Line Coverage: 100%
├── Branch Coverage: 100%
└── Method Coverage: 100%

Class: OrderService
├── Line Coverage: 98%
├── Branch Coverage: 95%
└── Method Coverage: 100%

Uncovered:
  - OrderService.java:145 (unreachable exception handler)

Overall: 99% coverage
```

---

## 📊 Exercise Checklist

| Exercise | Difficulty | Focus Area | Completed |
|----------|------------|------------|-----------|
| 1. MathUtils Tests | 🟢 Easy | Basic assertions | ⬜ |
| 2. Password Validator | 🟢 Easy | Validation testing | ⬜ |
| 3. Shopping Cart | 🟢 Easy | State testing | ⬜ |
| 4. Email Validator | 🟡 Medium | Parameterized tests | ⬜ |
| 5. Order Service | 🟡 Medium | Mocking | ⬜ |
| 6. DateTime Calculator | 🟡 Medium | Edge cases | ⬜ |
| 7. Banking System | 🔴 Hard | Complex state | ⬜ |
| 8. API Client | 🔴 Hard | Retry logic testing | ⬜ |
| 9. Integration Suite | 🔴 Hard | Complete coverage | ⬜ |
| 🏆 Coverage Analysis | Bonus | 100% coverage | ⬜ |

---

## 💡 Testing Tips

1. **Write tests first (TDD)** - Clarifies requirements
2. **One assertion per test** - Easier to diagnose failures
3. **Use meaningful names** - `method_scenario_expectedResult`
4. **Test edge cases** - null, empty, boundaries, extremes
5. **Keep tests independent** - Each test should stand alone
6. **Don't test private methods** - Test through public interface
7. **Use mocks sparingly** - Only for external dependencies
8. **Make tests deterministic** - No random, no time-dependent

---

**Testing is a skill - the more you practice, the better you get!** 🧪
