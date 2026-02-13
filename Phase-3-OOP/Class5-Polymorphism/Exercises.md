# Class 5: Polymorphism - Exercises 🎭

Practice making your code flexible and reusable through polymorphism!

---

## 🟢 Easy Exercises

### Exercise 1: Animal Sounds
**Goal:** Practice runtime polymorphism with overriding.

**Requirements:**
1. Create `Animal` class with `makeSound()` method
2. Create `Dog` and `Cat` that override `makeSound()`
3. Store them in an `Animal[]` array
4. Loop and call `makeSound()` for each

**Expected Output:**
```
Woof!
Meow!
Woof!
```

---

### Exercise 2: Shape Areas
**Goal:** Use a base class reference to call overridden methods.

**Requirements:**
1. Create `Shape` with `area()` method
2. Create `Circle` and `Rectangle` that override `area()`
3. Use `Shape` references to store both
4. Print each area

---

### Exercise 3: Simple Payment System
**Goal:** Use an interface for polymorphic behavior.

**Requirements:**
1. Create `PaymentMethod` interface with `pay(double amount)`
2. Implement it in `CardPayment` and `CashPayment`
3. Write a `processPayment(PaymentMethod method)` function
4. Use it with both payment types

---

## 🟡 Medium Exercises

### Exercise 4: Employee Bonus Calculator
**Goal:** Override a method to calculate different bonuses.

**Requirements:**
1. Base class `Employee` with `calculateBonus()`
2. Subclasses `Developer`, `Manager`, `Intern`
3. Each overrides `calculateBonus()` with unique logic
4. Store them in a list and print their bonuses

---

### Exercise 5: Transportation System
**Goal:** Demonstrate upcasting and dynamic dispatch.

**Requirements:**
1. Create base class `Transport` with `move()`
2. Subclasses: `Car`, `Bicycle`, `Train`
3. Store all in `Transport[]`
4. Call `move()` for each

---

### Exercise 6: Media Player
**Goal:** Use interfaces with different implementations.

**Requirements:**
1. Interface `Playable` with `play()` and `pause()`
2. Classes `Song`, `Podcast`, `Video`
3. Write a `startPlayback(Playable media)` method
4. Demonstrate with each type

---

## 🔴 Hard Exercises

### Exercise 7: Polymorphic Billing System
**Goal:** Combine abstract classes and interfaces.

**Requirements:**
1. Abstract class `Subscription` with abstract `monthlyCost()`
2. Subclasses: `StreamingSubscription`, `GymSubscription`, `CloudStorageSubscription`
3. Interface `Billable` with `generateInvoice()`
4. Each subclass implements `Billable`
5. Loop through subscriptions and generate invoices

---

### Exercise 8: Smart Home Devices
**Goal:** Use polymorphism with multiple device types.

**Requirements:**
1. Base class `SmartDevice` with `turnOn()` and `turnOff()`
2. Subclasses: `SmartLight`, `SmartThermostat`, `SmartSpeaker`
3. Interface `Configurable` with `configure()`
4. Each device implements `Configurable`
5. Store in array and configure all devices

---

### Exercise 9: Game Character System
**Goal:** Build a complete polymorphic battle system.

**Requirements:**
1. Abstract class `Character` with `attack()` and `takeDamage()`
2. Subclasses: `Warrior`, `Mage`, `Archer`
3. Each override `attack()` with different logic
4. Store all in a `Character[]` team
5. Simulate a battle loop where each character attacks

---

### ✅ Bonus Challenge
Create a **GUI-free mini library system** using polymorphism:
- Base class `LibraryItem`
- Subclasses `Book`, `Magazine`, `DVD`
- Override `getLoanPeriod()` for each type
- Store all in a list and print loan periods

Happy coding! 💻
