# Class 1: Classes & Objects - Exercises 📦

Master the fundamentals of object-oriented programming by creating and using classes!

---

## 🟢 Easy Exercises

### Exercise 1: Create a Circle Class
**Goal:** Design a class to represent a circle.

**Requirements:**
1. Create a `Circle` class with:
   - `radius` field (double)
   - `calculateArea()` method - returns area (π * r²)
   - `calculateCircumference()` method - returns circumference (2π * r)
   - `displayInfo()` method - prints all information

2. Create 3 circle objects with different radii
3. Display all information for each circle

**Test Case:**
```
Circle 1 (radius 5):
  Area: 78.54
  Circumference: 31.42

Circle 2 (radius 3):
  Area: 28.27
  Circumference: 18.85
```

---

### Exercise 2: Create a Student Grade Tracker
**Goal:** Create a class to store and manage student information.

**Requirements:**
1. Create a `Student` class with:
   - `name` field (String)
   - `studentID` field (int)
   - `grade` field (double)
   - `displayInfo()` method - prints student info
   - `isPasssing()` method - returns true if grade >= 60
   - `letterGrade()` method - returns letter grade (A, B, C, D, F)

2. Create 4 students with different grades
3. Display info and pass/fail status for each

**Test Case:**
```
Alice (ID: 101) - Grade: 92
  Letter Grade: A
  Status: Passing

Bob (ID: 102) - Grade: 55
  Letter Grade: F
  Status: Failing
```

---

### Exercise 3: Create a Temperature Converter
**Goal:** Design a class to work with temperature values.

**Requirements:**
1. Create a `Temperature` class with:
   - `celsius` field (double)
   - `toFahrenheit()` method - returns F = (C * 9/5) + 32
   - `isFreezingCold()` method - returns true if < 0°C
   - `isBurningHot()` method - returns true if > 40°C
   - `displayInfo()` method - prints all info

2. Create 3 temperature objects
3. Test each one and display results

**Test Case:**
```
Temperature 1: -5°C
  In Fahrenheit: 23°F
  Freezing Cold? true
  Burning Hot? false
```

---

## 🟡 Medium Exercises

### Exercise 4: Movie Class with Ratings
**Goal:** Create a movie information system.

**Requirements:**
1. Create a `Movie` class with:
   - `title` (String)
   - `year` (int)
   - `rating` (double, 1-10)
   - `genre` (String)
   - `displayInfo()` - print all details
   - `isClassic()` - returns true if released before 2000
   - `isHighlyRated()` - returns true if rating >= 8.0
   - `updateRating(double newRating)` - updates rating
   - `getAgeOfMovie()` - returns approximate age (assume current year is 2026)

2. Create 4 movies with different properties
3. Perform various operations and display results

**Test Case:**
```
Movie: The Shawshank Redemption (1994)
  Genre: Drama
  Rating: 9.3/10
  Is Classic? true
  Is Highly Rated? true
  Age: 32 years old
```

---

### Exercise 5: Product and Inventory System
**Goal:** Build a product management system.

**Requirements:**
1. Create a `Product` class with:
   - `name` (String)
   - `price` (double)
   - `quantity` (int)
   - `displayInfo()` - print product details
   - `totalValue()` - returns price * quantity
   - `restock(int amount)` - increase quantity
   - `sell(int amount)` - decrease quantity (if available)
   - `needsRestock()` - returns true if quantity < 10
   - `applyDiscount(double percent)` - reduces price by percentage

2. Create 3 products
3. Perform buying/restocking operations
4. Display inventory status

**Test Case:**
```
Product: Apple
  Price: $1.50
  Quantity: 50
  Total Value: $75.00
  Needs Restock? false

After selling 30:
  Quantity: 20
  Total Value: $30.00

After discount of 20%:
  New Price: $1.20
```

---

### Exercise 6: Library Book System
**Goal:** Create a library management system.

**Requirements:**
1. Create a `LibraryBook` class with:
   - `title` (String)
   - `author` (String)
   - `isbn` (String)
   - `isAvailable` (boolean)
   - `checkoutCount` (int)
   - `displayInfo()` - print all details
   - `checkout()` - borrow book (if available)
   - `returnBook()` - return book
   - `getCheckoutCount()` - returns number of checkouts
   - `isPopular()` - returns true if checkoutCount > 5

2. Simulate library operations:
   - Create 4 books
   - Perform multiple checkouts and returns
   - Display popularity status

**Test Case:**
```
Book: Java Programming
  Author: John Doe
  ISBN: 978-1234567890
  Available: true
  Checkouts: 0
  Popular? false

After 3 checkouts:
  Checkouts: 3
  Available: false

After return:
  Available: true
  Checkouts: 3
```

---

## 🔴 Hard Exercises

### Exercise 7: Bank Account with Interest
**Goal:** Build a realistic bank account system.

**Requirements:**
1. Create a `BankAccount` class with:
   - `accountNumber` (String)
   - `balance` (double)
   - `interestRate` (double, percentage)
   - `transactionCount` (int)
   - `deposit(double amount)` - add money
   - `withdraw(double amount)` - remove money (if sufficient)
   - `applyInterest()` - add interest to balance
   - `getAnnualInterest()` - returns annual interest amount
   - `isLowBalance()` - returns true if balance < 100
   - `displayStatement()` - print account details
   - `performMonthlyMaintenance()` - apply interest and reduce by fee if low balance

2. Create 3 accounts with different balances
3. Perform multiple operations over several months
4. Display final statements

**Features:**
- Prevent withdrawals if insufficient funds
- Track transaction count
- Apply 2% interest per month
- Charge $5 fee if balance drops below $100

**Test Case:**
```
Account: ACC001
  Balance: $1000.00
  Interest Rate: 2% per month
  Transactions: 0

After deposit $500 and withdraw $200:
  Balance: $1300.00
  Transactions: 2

After applying interest:
  Balance: $1326.00

After monthly maintenance:
  Balance: $1351.52
```

---

### Exercise 8: Employee Salary Management
**Goal:** Create an employee management system.

**Requirements:**
1. Create an `Employee` class with:
   - `name` (String)
   - `employeeID` (int)
   - `baseSalary` (double)
   - `department` (String)
   - `yearsWorked` (int)
   - `displayInfo()` - print all details
   - `calculateBonus()` - returns 5% of salary per year worked
   - `calculateTax()` - returns 20% of total salary
   - `getNetSalary()` - returns salary + bonus - tax
   - `giveRaise(double percent)` - increases baseSalary
   - `isEligibleForPromotion()` - returns true if yearsWorked >= 3
   - `incrementYears()` - adds 1 year to yearsWorked

2. Create 4 employees
3. Simulate annual reviews:
   - Give raises to high performers
   - Calculate bonuses
   - Determine who's eligible for promotion
   - Display salary breakdowns

**Test Case:**
```
Employee: Alice
  ID: 001
  Department: Engineering
  Base Salary: $60,000
  Years Worked: 5

Bonus (5% per year): $15,000
Tax (20%): $15,000
Net Salary: $60,000

Eligible for Promotion? true

After 10% raise:
  New Base: $66,000
```

---

### Exercise 9: Traffic Light System
**Goal:** Build a traffic light state management system.

**Requirements:**
1. Create a `TrafficLight` class with:
   - `currentColor` (String: "Red", "Yellow", "Green")
   - `secondsElapsed` (int)
   - `timeLimit` (int) - time before next change
   - `isGreen()` - returns true if color is Green
   - `isRed()` - returns true if color is Red
   - `isYellow()` - returns true if color is Yellow
   - `changeColor()` - cycles to next color (Red→Green→Yellow→Red)
   - `incrementTime()` - adds 1 second
   - `shouldChange()` - returns true if secondsElapsed >= timeLimit
   - `tick()` - increment time and change if needed
   - `getStatus()` - returns current light state and time

2. Simulate a traffic light for 30 seconds:
   - Red light: 10 seconds
   - Green light: 10 seconds
   - Yellow light: 3 seconds
   - Display status every second

**Expected Output:**
```
Second 1: 🔴 RED (1/10)
Second 2: 🔴 RED (2/10)
...
Second 10: 🔴 RED (10/10) → Changing...
Second 11: 🟢 GREEN (1/10)
...
Second 20: 🟢 GREEN (10/10) → Changing...
Second 21: 🟡 YELLOW (1/3)
...
```

---

## 🌟 Bonus Challenges

### Bonus 1: Weather Station
Create a `WeatherData` class that tracks:
- Temperature, humidity, pressure
- Calculate "feels like" temperature
- Determine weather condition (sunny, cloudy, rainy, stormy)
- Track daily min/max temperatures
- Calculate wind chill factor

### Bonus 2: Game Character
Create a `GameCharacter` class with:
- Name, health, mana, level
- Attack, defend, cast spell methods
- Experience and leveling system
- Inventory system with items
- Combat simulation

### Bonus 3: Time Management
Create a `Time` class that:
- Stores hours, minutes, seconds
- Converts to/from 24-hour and 12-hour format
- Adds time durations
- Calculates time differences
- Validates valid time values

### Bonus 4: Digital Wallet
Create a `DigitalWallet` class that:
- Stores multiple currencies
- Converts between currencies
- Tracks transaction history
- Calculates spending trends
- Generates monthly reports

---

## 📝 Object-Oriented Design Checklist

When designing your classes:

```
□ Does each class have ONE clear responsibility?
□ Are field names descriptive and meaningful?
□ Are method names verbs that describe actions?
□ Do you access fields through well-defined methods?
□ Can you create multiple objects without conflicts?
□ Do your methods modify state appropriately?
□ Have you tested object independence?
□ Are there any magic numbers that should be constants?
□ Is your code easy to understand and maintain?
□ Would someone else understand what your class does?
```

---

## 🏆 Continue Your OOP Journey!

Great work on mastering classes and objects! Next, you'll learn:

- **Class 2: Constructors** - Automatically initialize objects
- **Class 3: Encapsulation** - Control access to class members
- **Class 4: Inheritance** - Reuse code across related classes
- **Class 5: Polymorphism** - Objects that behave differently

Keep building! 🚀
