# Class 3: Encapsulation - Exercises 🔒

Master data protection and controlled access through encapsulation!

---

## 🟢 Easy Exercises

### Exercise 1: Create a Person Class with Validation
**Goal:** Build a simple encapsulated class.

**Requirements:**
1. Create a `Person` class with private fields:
   - `name` (String)
   - `age` (int)
   - `email` (String)

2. Add getters for all fields

3. Add setters with validation:
   - `name`: Cannot be null or empty
   - `age`: Must be between 0 and 150
   - `email`: Must contain "@" and "."

4. Create several Person objects and test validation

**Expected Output:**
```
Setting name to "Alice": ✓ Success
Setting name to "": ✗ Name cannot be empty

Setting age to 25: ✓ Success
Setting age to -5: ✗ Age must be between 0 and 150

Setting email to "alice@test.com": ✓ Success
Setting email to "invalid": ✗ Invalid email format
```

---

### Exercise 2: Create a Temperature Class
**Goal:** Multiple views of the same data.

**Requirements:**
1. Create a `Temperature` class with:
   - Private field `celsius` (double)

2. Add getter and setter for Celsius

3. Add computed getters for:
   - `getFahrenheit()` - converts from Celsius
   - `getKelvin()` - converts from Celsius

4. Add setters that convert:
   - `setFahrenheit(double f)` - converts to Celsius internally
   - `setKelvin(double k)` - converts to Celsius internally

5. Add helper methods:
   - `isBoiling()` - true if >= 100°C
   - `isFreezing()` - true if <= 0°C

**Expected Output:**
```
Temperature set to 25°C
  Celsius: 25.0
  Fahrenheit: 77.0
  Kelvin: 298.15

Temperature set to 212°F
  Celsius: 100.0
  Fahrenheit: 212.0
  Is Boiling: true
```

---

### Exercise 3: Create a Counter Class
**Goal:** Controlled modification of data.

**Requirements:**
1. Create a `Counter` class with:
   - Private field `count` (int)
   - Private field `step` (int, default 1)

2. Add getter for count (no direct setter!)

3. Add methods:
   - `increment()` - adds step to count
   - `decrement()` - subtracts step (can't go below 0)
   - `reset()` - sets count to 0
   - `setStep(int step)` - changes step size (must be positive)

4. Test with different step values

**Expected Output:**
```
Initial count: 0
After 3 increments: 3
After 1 decrement: 2
After reset: 0

Setting step to 5:
After 3 increments: 15
After decrement: 10
```

---

## 🟡 Medium Exercises

### Exercise 4: Create a BankAccount Class
**Goal:** Complete encapsulation with business logic.

**Requirements:**
1. Create a `BankAccount` class with private fields:
   - `accountNumber` (String) - read-only after creation
   - `holderName` (String)
   - `balance` (double) - no direct setter
   - `isActive` (boolean)
   - `transactionCount` (int)

2. Add appropriate getters and setters

3. Add methods:
   - `deposit(double amount)` - validates positive amount
   - `withdraw(double amount)` - validates sufficient funds
   - `transfer(BankAccount other, double amount)` - transfer between accounts
   - `deactivate()` / `activate()` - toggle active status
   - `getStatement()` - returns formatted account info

4. Inactive accounts should reject deposits/withdrawals

**Expected Output:**
```
Account created: ACC001
Balance: $1000.00

Deposit $500: ✓ New balance: $1500.00
Withdraw $200: ✓ New balance: $1300.00
Withdraw $5000: ✗ Insufficient funds

Transfer $300 to ACC002: ✓ Success
ACC001 Balance: $1000.00
ACC002 Balance: $300.00

Deactivating account...
Deposit $100: ✗ Account is inactive
```

---

### Exercise 5: Create a Student Grade System
**Goal:** Complex validation and computed properties.

**Requirements:**
1. Create a `StudentGrades` class with private fields:
   - `studentName` (String)
   - `studentId` (String) - read-only
   - `grades` (double array)
   - `maxGrades` (int) - maximum allowed grades

2. Add getters (return copy of grades array, not the array itself!)

3. Add methods:
   - `addGrade(double grade)` - validates 0-100
   - `removeLastGrade()` - removes most recent grade
   - `getAverage()` - computed property
   - `getHighest()` / `getLowest()` - computed properties
   - `getLetterGrade()` - based on average
   - `isPassing()` - average >= 60
   - `getGradeCount()` - how many grades recorded

4. Test thoroughly

**Expected Output:**
```
Student: Alice (ID: STU001)

Adding grade 85: ✓ Added
Adding grade 92: ✓ Added
Adding grade 78: ✓ Added
Adding grade 150: ✗ Grade must be 0-100

Grades: [85.0, 92.0, 78.0]
Average: 85.0
Highest: 92.0
Lowest: 78.0
Letter Grade: B
Passing: true
```

---

### Exercise 6: Create a Rectangle Class
**Goal:** Computed properties and validation.

**Requirements:**
1. Create a `Rectangle` class with private fields:
   - `width` (double)
   - `height` (double)
   - `color` (String)
   - `filled` (boolean)

2. Add validation in setters:
   - Width and height must be positive
   - Color cannot be null or empty

3. Add computed getters:
   - `getArea()`
   - `getPerimeter()`
   - `getDiagonal()`
   - `isSquare()`

4. Add methods:
   - `scale(double factor)` - multiply both dimensions
   - `stretch(double widthFactor, double heightFactor)`
   - `displayInfo()` - formatted output

**Expected Output:**
```
Rectangle: 10.0 x 5.0 (Blue, filled)
Area: 50.0
Perimeter: 30.0
Diagonal: 11.18
Is Square: false

After scaling by 2:
Rectangle: 20.0 x 10.0
Area: 200.0

Setting width to -5: ✗ Width must be positive
```

---

## 🔴 Hard Exercises

### Exercise 7: Create a Time Tracker
**Goal:** Complex encapsulation with multiple operations.

**Requirements:**
1. Create a `TimeTracker` class with private fields:
   - `hours` (int)
   - `minutes` (int)
   - `seconds` (int)
   - `isRunning` (boolean)

2. Validation:
   - Hours: 0-23
   - Minutes: 0-59
   - Seconds: 0-59
   - Auto-normalize (60 seconds → 1 minute, etc.)

3. Add methods:
   - Getters for each component
   - `setTime(int h, int m, int s)` - with validation
   - `addSeconds(int s)` - can be negative
   - `addMinutes(int m)` - can be negative
   - `addHours(int h)` - can be negative
   - `start()` / `stop()` / `reset()`
   - `getFormattedTime()` - returns "HH:MM:SS"
   - `get12HourFormat()` - returns "HH:MM:SS AM/PM"
   - `toTotalSeconds()` - converts everything to seconds

4. Test all edge cases (overflow, underflow)

**Expected Output:**
```
Time: 14:30:45 (2:30:45 PM)
Total seconds: 52245

Adding 30 seconds:
Time: 14:31:15

Adding 45 minutes:
Time: 15:16:15

Subtracting 2 hours:
Time: 13:16:15

Adding 50 minutes to 23:30:00:
Time: 00:20:00 (next day overflow)
```

---

### Exercise 8: Create an Inventory Management System
**Goal:** Real-world encapsulation scenario.

**Requirements:**
1. Create a `Product` class with private fields:
   - `productId` (String) - read-only
   - `name` (String)
   - `price` (double)
   - `quantity` (int)
   - `reorderLevel` (int)

2. Create an `Inventory` class with:
   - `products` (array of Products) - private
   - `maxCapacity` (int)

3. Product methods:
   - Getters with appropriate validation
   - `sell(int amount)` - reduces quantity
   - `restock(int amount)` - increases quantity
   - `applyDiscount(double percent)`
   - `needsReorder()` - true if quantity <= reorderLevel
   - `getTotalValue()` - price * quantity

4. Inventory methods:
   - `addProduct(Product p)` - if space available
   - `removeProduct(String productId)`
   - `findProduct(String productId)` - returns copy, not reference!
   - `sellProduct(String productId, int amount)`
   - `getTotalInventoryValue()`
   - `getProductsNeedingReorder()` - returns array of products
   - `displayInventory()`

**Expected Output:**
```
=== INVENTORY ===
ID: P001 | Laptop | $999.99 | Qty: 50 | Value: $49,999.50
ID: P002 | Mouse | $29.99 | Qty: 100 | Value: $2,999.00
ID: P003 | Keyboard | $79.99 | Qty: 5 | Value: $399.95 [REORDER NEEDED]

Total Inventory Value: $53,398.45

Selling 45 Laptops...
New quantity: 5 [REORDER NEEDED]

Products needing reorder: Laptop, Keyboard
```

---

### Exercise 9: Create a Secure User Account System
**Goal:** Security-focused encapsulation.

**Requirements:**
1. Create a `SecureAccount` class with private fields:
   - `username` (String) - read-only after creation
   - `passwordHash` (String) - write-only!
   - `email` (String) - with validation
   - `loginAttempts` (int) - track failed logins
   - `isLocked` (boolean) - lock after 3 failed attempts
   - `lastLoginTime` (long) - timestamp
   - `createdAt` (long) - read-only

2. Security features:
   - No `getPassword()` method ever!
   - `setPassword(String password)` - validates strength:
     - Minimum 8 characters
     - At least one uppercase
     - At least one lowercase
     - At least one digit
   - `checkPassword(String attempt)` - returns boolean
   - Auto-lock after 3 failed attempts
   - `unlock()` - requires admin (separate method)

3. Add methods:
   - `login(String password)` - returns boolean, tracks attempts
   - `logout()`
   - `changePassword(String oldPass, String newPass)`
   - `getAccountAge()` - days since creation
   - `getAccountInfo()` - displays safe info (no password!)

**Expected Output:**
```
Account created: john_doe
Email: john@email.com
Created: February 11, 2026

Setting password "weak": ✗ Password too weak
  - Missing uppercase
  - Missing digit

Setting password "Strong123": ✓ Password set

Login attempt with wrong password: ✗ Failed (1/3)
Login attempt with wrong password: ✗ Failed (2/3)
Login attempt with wrong password: ✗ Failed (3/3)
Account locked!

Login attempt: ✗ Account is locked

Unlocking account...
Login with correct password: ✓ Success
Last login: February 11, 2026 10:30 AM
```

---

## 🌟 Bonus Challenges

### Bonus 1: Immutable Person Class
Create a completely immutable `ImmutablePerson` class:
- All fields are final
- No setters at all
- All values set in constructor
- Methods like `withName()` return NEW objects
- Demonstrate why immutability is useful

### Bonus 2: Builder Pattern
Implement the Builder pattern for a `Pizza` class:
- Many optional fields (size, cheese, toppings, etc.)
- Builder handles validation
- `build()` returns immutable Pizza
- Chain methods: `new PizzaBuilder().size("large").cheese(true).build()`

### Bonus 3: Observable Pattern
Create a class that notifies listeners of changes:
- `addListener()` / `removeListener()`
- When a setter is called, notify all listeners
- Demonstrate with a simple example

### Bonus 4: Audit Trail
Create an `AuditedAccount` that:
- Tracks all changes to fields
- Records who made the change and when
- Can display change history
- Can rollback to previous values

---

## 📝 Encapsulation Checklist

When designing encapsulated classes:

```
□ Are all fields private?
□ Do getters exist for fields that need reading?
□ Do setters have appropriate validation?
□ Are computed properties implemented as getters?
□ Are read-only fields truly unmodifiable?
□ Are mutable objects copied when returned?
□ Is sensitive data (passwords) write-only?
□ Do methods provide controlled access?
□ Is the internal representation hidden?
□ Can the implementation change without breaking users?
```

---

## 🏆 Keep Protecting Your Data!

Excellent work on mastering encapsulation! You now understand:
- **Private fields** protect data
- **Getters/Setters** provide controlled access
- **Validation** ensures data integrity
- **Computed properties** hide implementation

Next up:
- **Class 4: Inheritance** - Reuse code across class hierarchies
- **Class 5: Polymorphism** - Objects with flexible behavior

Keep coding securely! 🔒
