# Class 4: Inheritance - Exercises 🧬

Master code reuse and hierarchical relationships through inheritance!

---

## 🟢 Easy Exercises

### Exercise 1: Animal Hierarchy
**Goal:** Create a simple animal inheritance hierarchy.

**Requirements:**
1. Create an `Animal` base class with:
   - Fields: `name`, `age`
   - Constructor that initializes both
   - Methods: `eat()`, `sleep()`, `makeSound()`

2. Create `Dog` and `Cat` classes that extend `Animal`:
   - Dog: Add `breed` field, `bark()` method, override `makeSound()`
   - Cat: Add `isIndoor` field, `meow()` method, override `makeSound()`

3. Create objects and demonstrate inherited + specific behaviors

**Expected Output:**
```
Dog Buddy:
  Name: Buddy, Age: 3, Breed: Labrador
  Eating...
  Sleeping...
  Woof woof!

Cat Whiskers:
  Name: Whiskers, Age: 2, Indoor: true
  Eating...
  Sleeping...
  Meow!
```

---

### Exercise 2: Shape Hierarchy
**Goal:** Create shapes with area calculation.

**Requirements:**
1. Create a `Shape` base class with:
   - Field: `color`
   - Constructor
   - Method: `calculateArea()` (returns 0)
   - Method: `displayInfo()`

2. Create subclasses:
   - `Circle`: radius field, override `calculateArea()`
   - `Rectangle`: width/height fields, override `calculateArea()`
   - `Square`: extends Rectangle with single side length

3. Create various shapes and display their areas

**Expected Output:**
```
Circle (red): radius = 5
  Area: 78.54

Rectangle (blue): 10 x 5
  Area: 50.00

Square (green): side = 4
  Area: 16.00
```

---

### Exercise 3: Person → Student → GraduateStudent
**Goal:** Practice multi-level inheritance.

**Requirements:**
1. Create hierarchy:
   - `Person`: name, age
   - `Student extends Person`: studentId, major
   - `GraduateStudent extends Student`: thesis, advisor

2. Each class should:
   - Call parent constructor with `super()`
   - Override `displayInfo()` calling `super.displayInfo()`

3. Create a GraduateStudent and show all inherited info

**Expected Output:**
```
Creating Graduate Student:
  → Person constructor
  → Student constructor
  → GraduateStudent constructor

Graduate Student Info:
  Name: Alice
  Age: 26
  Student ID: G12345
  Major: Computer Science
  Thesis: Machine Learning Applications
  Advisor: Dr. Smith
```

---

## 🟡 Medium Exercises

### Exercise 4: Employee Management System
**Goal:** Build a realistic employee hierarchy.

**Requirements:**
1. Create base class `Employee`:
   - Fields: `name`, `employeeId`, `baseSalary`
   - Constructor
   - Method: `calculatePay()` - returns baseSalary
   - Method: `displayInfo()`

2. Create subclasses:
   - `HourlyEmployee`: hoursWorked, hourlyRate; override `calculatePay()`
   - `SalariedEmployee`: monthlyBonus; override `calculatePay()`
   - `Manager extends SalariedEmployee`: teamSize, managementBonus; override `calculatePay()`

3. Create employees of each type and calculate their pay

**Expected Output:**
```
Hourly Employee:
  Name: Bob, ID: E001
  Hours: 45, Rate: $15/hr
  Pay: $675.00

Salaried Employee:
  Name: Alice, ID: E002
  Base: $5000, Bonus: $500
  Pay: $5500.00

Manager:
  Name: Carol, ID: E003
  Base: $7000, Bonus: $1000, Team Size: 5
  Management Bonus: $250 (5 × $50)
  Pay: $8250.00
```

---

### Exercise 5: Vehicle Fleet System
**Goal:** Create a comprehensive vehicle hierarchy.

**Requirements:**
1. Create base class `Vehicle`:
   - Fields: `brand`, `model`, `year`, `fuelLevel`
   - Methods: `start()`, `stop()`, `refuel(amount)`, `displayInfo()`

2. Create subclasses with unique features:
   - `Car`: numDoors, `honk()`, `openTrunk()`
   - `Motorcycle`: engineCC, hasSidecar, `wheelie()`
   - `Truck`: cargoCapacity, currentCargo, `loadCargo()`, `unloadCargo()`
   - `ElectricCar extends Car`: batteryPercent, `charge()`, override `refuel()` to charge instead

3. Override `start()` in each to have unique messages

4. Demonstrate all vehicles with their unique behaviors

**Expected Output:**
```
Car: 2024 Toyota Camry
  Starting... Engine purrs to life!
  Honk! Beep beep!
  
Motorcycle: 2023 Honda CBR
  Starting... VROOM!
  *Does a wheelie*
  
Truck: 2022 Ford F-150
  Starting... Diesel rumbles!
  Loading 2000 lbs... Success!
  Cargo: 2000/5000 lbs
  
ElectricCar: 2024 Tesla Model 3
  Starting... Silent and smooth!
  Charging... 50% → 100%
```

---

### Exercise 6: Bank Account Types
**Goal:** Implement different account types with varying behaviors.

**Requirements:**
1. Create base class `BankAccount`:
   - Fields: `accountNumber`, `holderName`, `balance`
   - Methods: `deposit()`, `withdraw()`, `getBalance()`, `displayInfo()`

2. Create subclasses with different rules:
   - `SavingsAccount`: interestRate, `applyInterest()`, minimum balance requirement
   - `CheckingAccount`: overdraftLimit, allow negative balance up to limit
   - `StudentAccount extends CheckingAccount`: no fees, lower overdraft limit

3. Override `withdraw()` in each to enforce different rules

4. Test edge cases (overdrafts, minimum balance, etc.)

**Expected Output:**
```
Savings Account (SA001):
  Balance: $1000, Interest Rate: 3%
  Withdraw $900: DENIED (minimum balance $200)
  Withdraw $700: SUCCESS
  Balance: $300
  Apply Interest: +$9.00
  Balance: $309.00

Checking Account (CA001):
  Balance: $500, Overdraft Limit: $200
  Withdraw $600: SUCCESS (using overdraft)
  Balance: -$100
  Withdraw $200: DENIED (exceeds overdraft)

Student Account (ST001):
  Balance: $100, Overdraft Limit: $50
  No monthly fees!
```

---

## 🔴 Hard Exercises

### Exercise 7: Game Character System
**Goal:** Build an RPG-style character hierarchy.

**Requirements:**
1. Create base class `GameCharacter`:
   - Fields: `name`, `health`, `maxHealth`, `level`, `experience`
   - Methods: `attack()`, `defend()`, `takeDamage()`, `heal()`, `gainExperience()`, `levelUp()`

2. Create character classes with unique abilities:
   - `Warrior`: strength, `powerAttack()`, `rage()` (temporary damage boost)
   - `Mage`: mana, maxMana, `castSpell()`, `fireball()`, `heal()` override
   - `Archer`: arrows, `shoot()`, `multiShot()`, critical hit chance
   - `Paladin extends Warrior`: faith, `holyStrike()`, `divineShield()`

3. Implement level-up system:
   - Each level increases stats
   - Different classes gain different stats

4. Simulate a battle sequence

**Expected Output:**
```
=== BATTLE SIMULATION ===

Warrior Thor (Level 5):
  Health: 150/150, Strength: 25
  Uses Power Attack! → 50 damage
  Uses Rage! Strength boosted to 35!

Mage Merlin (Level 5):
  Health: 80/80, Mana: 100/100
  Casts Fireball! → 60 damage (costs 20 mana)
  Mana: 80/100

Archer Legolas (Level 5):
  Health: 100/100, Arrows: 20
  Shoots arrow! → 30 damage
  CRITICAL HIT! → 60 damage
  Arrows: 18

Round result:
  Enemy takes 170 damage total!
```

---

### Exercise 8: Media Library System
**Goal:** Create a comprehensive media management system.

**Requirements:**
1. Create base class `MediaItem`:
   - Fields: `title`, `creator`, `year`, `duration` (minutes)
   - Methods: `play()`, `pause()`, `getInfo()`, `calculateRoyalty()`

2. Create media types:
   - `Song`: album, genre, `calculateRoyalty()` = $0.005 per play
   - `Podcast`: episode number, host, `calculateRoyalty()` = $0.001 per play
   - `Video`: resolution, views, `calculateRoyalty()` = $0.01 per view
   - `Movie extends Video`: director, boxOffice, `calculateRoyalty()` includes box office %
   - `MusicVideo extends Video`: artist, album, combined royalty calculation

3. Create a `Playlist` class that:
   - Holds multiple MediaItems
   - Calculates total duration
   - Calculates total royalties
   - Can shuffle, add, remove items

4. Test with a diverse playlist

**Expected Output:**
```
=== MY PLAYLIST ===
1. Song: "Bohemian Rhapsody" by Queen (6 min)
   Plays: 1000, Royalties: $5.00

2. Podcast: "Tech Talk #45" by John (45 min)
   Plays: 500, Royalties: $0.50

3. Movie: "Inception" by Nolan (148 min)
   Views: 10000, Box Office: $800M
   Royalties: $100.00 + $8000.00

Total Duration: 199 minutes
Total Royalties: $8105.50
```

---

### Exercise 9: E-Commerce Product Hierarchy
**Goal:** Build a complete product management system.

**Requirements:**
1. Create base class `Product`:
   - Fields: `productId`, `name`, `basePrice`, `stockQuantity`
   - Methods: `calculatePrice()`, `applyDiscount()`, `isInStock()`, `displayInfo()`

2. Create product categories:
   - `Electronics`: warranty (months), `calculatePrice()` adds warranty cost
   - `Clothing`: size, color, `calculatePrice()` varies by size
   - `Food`: expirationDate, organic, `calculatePrice()` +20% if organic
   - `Book`: author, pages, genre, no extra calculations
   - `DigitalProduct extends Product`: downloadLink, fileSize, no shipping cost
   - `Subscription extends DigitalProduct`: monthlyFee, duration, `calculatePrice()` = fee × months

3. Create a `ShoppingCart` class:
   - Add/remove products
   - Calculate subtotal (using each product's `calculatePrice()`)
   - Apply cart-wide discount
   - Calculate shipping (free for digital, $5 per physical item)
   - Generate receipt

4. Test with a full shopping scenario

**Expected Output:**
```
=== SHOPPING CART ===
1. Electronics: Samsung TV 55"
   Base: $800, Warranty (24mo): +$100
   Subtotal: $900.00

2. Clothing: Nike Shoes (Size L)
   Base: $120, Size markup: +$10
   Subtotal: $130.00

3. Food: Organic Apples
   Base: $5, Organic: +$1
   Subtotal: $6.00

4. Digital: Netflix (12 months)
   Monthly: $15 × 12
   Subtotal: $180.00

─────────────────────────
Items: 4
Product Total: $1216.00
Shipping (3 physical): $15.00
Cart Discount (10%): -$123.10
─────────────────────────
TOTAL: $1107.90
```

---

## 🌟 Bonus Challenges

### Bonus 1: GUI Component Hierarchy
Design a GUI framework hierarchy:
- `Component` base (x, y, width, height)
- `Container extends Component` (holds children)
- `Button`, `Label`, `TextField` extend Component
- `Panel`, `Window`, `Dialog` extend Container
- Implement `render()` and `handleClick()` methods

### Bonus 2: Exception Hierarchy
Create custom exceptions:
- `ApplicationException` base
- `ValidationException`, `AuthenticationException`, `DatabaseException`
- `UserNotFoundException extends DatabaseException`
- Each provides meaningful error messages and codes

### Bonus 3: Tax Calculation System
Build a tax system:
- `TaxPayer` base class
- `Individual`, `Corporation`, `NonProfit`
- Different tax rates and deduction rules
- Override `calculateTax()` for each type
- Support multiple tax brackets

### Bonus 4: Command Pattern with Inheritance
Implement an undo/redo system:
- `Command` base class with `execute()` and `undo()`
- `AddCommand`, `DeleteCommand`, `ModifyCommand`
- `CommandHistory` to track and reverse commands

---

## 📝 Inheritance Checklist

When designing inheritance hierarchies:

```
□ Is there a true "is-a" relationship?
□ Is super() called properly in constructors?
□ Are overridden methods marked with @Override?
□ Is the hierarchy shallow (2-3 levels max)?
□ Is protected used appropriately for inherited access?
□ Are toString(), equals(), hashCode() overridden when needed?
□ Should any classes or methods be final?
□ Is code being reused effectively?
□ Could composition be better than inheritance here?
□ Are method signatures compatible in overrides?
```

---

## 🏆 Almost There!

Fantastic work on inheritance! You now understand:
- **extends** creates parent-child relationships
- **super** calls parent constructors and methods
- **@Override** ensures correct method overriding
- **protected** enables inheritance-friendly access
- **Multi-level inheritance** for deep hierarchies

One more class to go:
- **Class 5: Polymorphism** - The power of treating objects flexibly

Keep inheriting! 🧬
