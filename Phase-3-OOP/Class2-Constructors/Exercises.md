# Class 2: Constructors - Exercises 🏗️

Master object initialization by creating classes with various constructors!

---

## 🟢 Easy Exercises

### Exercise 1: Create a Pet Class
**Goal:** Build a class with a default and parameterized constructor.

**Requirements:**
1. Create a `Pet` class with fields:
   - `name` (String)
   - `species` (String)
   - `age` (int)

2. Add two constructors:
   - Default: Sets name to "Unknown", species to "Unknown", age to 0
   - Parameterized: Accepts all three values

3. Add a `displayInfo()` method

4. Create 3 pets:
   - One with default constructor
   - Two with parameterized constructor

**Expected Output:**
```
Pet 1:
  Name: Unknown
  Species: Unknown
  Age: 0

Pet 2:
  Name: Buddy
  Species: Dog
  Age: 3

Pet 3:
  Name: Whiskers
  Species: Cat
  Age: 5
```

---

### Exercise 2: Create a Point Class
**Goal:** Represent 2D coordinates with constructors.

**Requirements:**
1. Create a `Point` class with:
   - `x` (int) and `y` (int) fields
   - Default constructor: Sets x=0, y=0
   - Parameterized constructor: Accepts x and y

2. Add methods:
   - `displayPoint()` - prints "(x, y)"
   - `distanceFromOrigin()` - returns distance from (0,0)
   - `moveBy(int dx, int dy)` - moves the point

3. Create 3 points and test all methods

**Expected Output:**
```
Point 1: (0, 0)
  Distance from origin: 0.0

Point 2: (3, 4)
  Distance from origin: 5.0

After moving Point 2 by (2, 3):
Point 2: (5, 7)
  Distance from origin: 8.6
```

---

### Exercise 3: Create a Time Class
**Goal:** Represent time with hours, minutes, seconds.

**Requirements:**
1. Create a `Time` class with:
   - `hours` (int), `minutes` (int), `seconds` (int)
   - Default constructor: Sets to 00:00:00
   - Constructor with hours and minutes: Seconds defaults to 0
   - Full constructor: All three values

2. Add methods:
   - `displayTime()` - prints time in HH:MM:SS format
   - `toSeconds()` - converts entire time to seconds
   - `is12HourFormat()` - returns time in 12-hour format with AM/PM

3. Test with different constructor combinations

**Expected Output:**
```
Time 1: 00:00:00
  In seconds: 0
  12-hour: 12:00:00 AM

Time 2: 14:30:00
  In seconds: 52200
  12-hour: 2:30:00 PM

Time 3: 08:45:30
  In seconds: 31530
  12-hour: 8:45:30 AM
```

---

## 🟡 Medium Exercises

### Exercise 4: Create a Book with Constructor Chaining
**Goal:** Use `this()` to chain constructors.

**Requirements:**
1. Create a `Book` class with:
   - `title` (String)
   - `author` (String)
   - `pages` (int)
   - `price` (double)
   - `isbn` (String)

2. Create 5 constructors using chaining:
   - Full constructor (5 parameters)
   - Without ISBN → chains to full
   - Title and author only → chains up
   - Title only → chains up
   - Default → chains up

3. Each simpler constructor should call the next one up

4. Create books using each constructor and display them

**Expected Output:**
```
Book 1 (full):
  Java Programming by John Doe
  400 pages, $49.99, ISBN: 978-1234567890

Book 2 (no ISBN):
  Python Basics by Jane Smith
  300 pages, $39.99, ISBN: Not assigned

Book 3 (title & author):
  Web Dev by Bob Johnson
  0 pages, $0.00, ISBN: Not assigned

Book 4 (title only):
  Data Science by Unknown Author
  0 pages, $0.00, ISBN: Not assigned

Book 5 (default):
  Untitled by Unknown
  0 pages, $0.00, ISBN: Not assigned
```

---

### Exercise 5: Create a Vehicle Registration System
**Goal:** Practice constructor overloading with validation.

**Requirements:**
1. Create a `Vehicle` class with:
   - `licensePlate` (String)
   - `make` (String)
   - `model` (String)
   - `year` (int)
   - `ownerName` (String)

2. Add constructors:
   - Full constructor with all fields
   - Without owner (for dealer inventory)
   - Just license plate and year (for DMV records)
   - Default (unregistered vehicle)

3. Add validation in main constructor:
   - Year must be between 1900 and current year (2026)
   - License plate cannot be empty

4. Create various vehicles and test validation

**Expected Output:**
```
Vehicle 1 (full):
  License: ABC-123
  2022 Toyota Camry
  Owner: John Smith

Vehicle 2 (dealer):
  License: DEF-456
  2024 Honda Civic
  Owner: Not registered

Vehicle 3 (DMV record):
  License: XYZ-789
  Year: 2020
  Make/Model: Unknown
  Owner: Not registered

Vehicle 4 (with invalid year):
  ⚠️ Invalid year 2030. Setting to 2026.
  License: TEST-01
  2026 Test Model
```

---

### Exercise 6: Create a Rectangle with Multiple Options
**Goal:** Create a versatile rectangle class.

**Requirements:**
1. Create a `Rectangle` class with:
   - `width` (double)
   - `height` (double)
   - `color` (String)
   - `filled` (boolean)

2. Add constructors:
   - Full constructor (all 4 parameters)
   - Width and height only (default: white, not filled)
   - Square constructor (one side length)
   - Default (1x1 white rectangle)
   - Copy constructor (takes another Rectangle)

3. Add methods:
   - `calculateArea()`
   - `calculatePerimeter()`
   - `isSquare()`
   - `displayInfo()`

4. Demonstrate all constructors including the copy constructor

**Expected Output:**
```
Rectangle 1 (full):
  10.0 x 5.0 Blue (filled)
  Area: 50.0, Perimeter: 30.0
  Is square? false

Rectangle 2 (width/height):
  8.0 x 4.0 White (not filled)

Rectangle 3 (square):
  5.0 x 5.0 White (not filled)
  Is square? true

Rectangle 4 (copy of 1):
  10.0 x 5.0 Blue (filled)
```

---

## 🔴 Hard Exercises

### Exercise 7: Create a Comprehensive Date Class
**Goal:** Build a complete date handling class.

**Requirements:**
1. Create a `Date` class with:
   - `day` (int), `month` (int), `year` (int)

2. Add constructors:
   - Full constructor with validation
   - Month and year only (day defaults to 1)
   - Year only (defaults to January 1)
   - Default (current date: February 10, 2026)
   - String constructor (parses "DD/MM/YYYY")

3. Add validation:
   - Month: 1-12
   - Day: Valid for the month (handle Feb, 30/31 day months)
   - Year: 1-9999
   - Handle leap years for February

4. Add methods:
   - `displayDate()` - multiple formats
   - `isLeapYear()`
   - `daysInMonth()`
   - `dayOfYear()` - which day of the year (1-365/366)
   - `isWeekend()` - (bonus: calculate day of week)

**Test Cases:**
```
Date 1: February 10, 2026
  Format 1: 10/02/2026
  Format 2: February 10, 2026
  Leap year? false
  Day of year: 41

Date 2: February 29, 2024 (leap year)
  Valid date!
  Leap year? true

Date 3: February 30, 2024 (invalid)
  ⚠️ Invalid day 30 for February. Setting to 29.
```

---

### Exercise 8: Create a Complex Number Class
**Goal:** Model mathematical complex numbers (a + bi).

**Requirements:**
1. Create a `ComplexNumber` class with:
   - `real` (double) - the real part
   - `imaginary` (double) - the imaginary part

2. Add constructors:
   - Full constructor (real and imaginary)
   - Real only (imaginary = 0)
   - Default (0 + 0i)
   - Copy constructor

3. Add methods:
   - `display()` - shows "a + bi" or "a - bi" format
   - `add(ComplexNumber other)` - returns sum
   - `subtract(ComplexNumber other)` - returns difference
   - `multiply(ComplexNumber other)` - returns product
   - `magnitude()` - returns √(a² + b²)
   - `conjugate()` - returns a - bi

4. Create complex numbers and perform operations

**Expected Output:**
```
Complex 1: 3.0 + 4.0i
  Magnitude: 5.0
  Conjugate: 3.0 - 4.0i

Complex 2: 1.0 + 2.0i

Sum: 4.0 + 6.0i
Difference: 2.0 + 2.0i
Product: -5.0 + 10.0i
```

---

### Exercise 9: Create a Grade Book System
**Goal:** Build a complete student grade management system.

**Requirements:**
1. Create a `GradeBook` class with:
   - `studentName` (String)
   - `studentID` (String)
   - `courseName` (String)
   - `grades` (double array)
   - `maxGrades` (int) - maximum number of grades
   - `gradeCount` (int) - current number of grades

2. Add constructors:
   - Full constructor (name, ID, course, max grades)
   - Without max grades (defaults to 10)
   - Quick constructor (name and ID only, defaults for rest)
   - Copy constructor (creates copy of another GradeBook)

3. Add methods:
   - `addGrade(double grade)` - adds a grade (with validation 0-100)
   - `calculateAverage()` - returns average
   - `getHighest()` and `getLowest()`
   - `getLetterGrade()` - returns A/B/C/D/F based on average
   - `isPassing()` - true if average >= 60
   - `displayReport()` - full grade report
   - `dropLowest()` - removes lowest grade

4. Simulate a full semester:
   - Create student
   - Add multiple grades
   - Display report
   - Drop lowest
   - Show updated report

**Expected Output:**
```
===== GRADE REPORT =====
Student: Alice Johnson
ID: STU001
Course: Java Programming

Grades: 85.0 72.0 90.0 68.0 95.0
Total Grades: 5

Statistics:
  Average: 82.0
  Highest: 95.0
  Lowest: 68.0
  Letter Grade: B
  Status: PASSING

After dropping lowest grade:
Grades: 85.0 72.0 90.0 95.0
New Average: 85.5
New Letter Grade: B
```

---

## 🌟 Bonus Challenges

### Bonus 1: Fraction Class
Create a `Fraction` class that:
- Stores numerator and denominator
- Automatically simplifies fractions (using GCD)
- Supports add, subtract, multiply, divide operations
- Converts to decimal and mixed number format
- Validates denominator != 0

### Bonus 2: Color Class (RGB)
Create a `Color` class that:
- Stores red, green, blue values (0-255)
- Has constructors for RGB, hex string (#RRGGBB), named colors
- Validates values are in range
- Calculates brightness, inverts color
- Blends two colors together

### Bonus 3: Playing Card and Deck
Create `Card` and `Deck` classes:
- Card has suit and value
- Multiple constructors for Card
- Deck initializes with 52 cards
- Methods: shuffle, draw, peek, reset
- Track remaining cards

### Bonus 4: Builder Pattern (Advanced)
Research and implement the Builder Pattern:
- Create a `Pizza` class with many optional toppings
- Use a `PizzaBuilder` inner class
- Allow method chaining: `new PizzaBuilder().size("large").cheese(true).build()`

---

## 📝 Constructor Design Checklist

When designing constructors:

```
□ Is there a sensible default constructor?
□ Are all required fields initialized?
□ Is constructor overloading used effectively?
□ Is there code duplication? → Use chaining!
□ Are parameters validated?
□ Do parameter names clearly describe their purpose?
□ Is the 'this' keyword used when needed?
□ Are constructors easy to understand and use?
□ Is there a copy constructor if objects need cloning?
□ Are immutable objects truly immutable after construction?
```

---

## 🏆 Keep Building!

Excellent work on mastering constructors! Next up:

- **Class 3: Encapsulation** - Control access with private/public
- **Class 4: Inheritance** - Reuse code across class hierarchies
- **Class 5: Polymorphism** - Write flexible, extensible code

Keep creating! 🚀
