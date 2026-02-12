# Class 4: Inheritance 🧬

Welcome to **Phase 3, Class 4**! In this class, you'll learn about **inheritance** - one of the most powerful features of Object-Oriented Programming that enables code reuse and hierarchical relationships.

---

## Table of Contents
1. [What is Inheritance?](#what-is-inheritance)
2. [The `extends` Keyword](#the-extends-keyword)
3. [The `super` Keyword](#the-super-keyword)
4. [Method Overriding](#method-overriding)
5. [The `protected` Modifier](#the-protected-modifier)
6. [Inheritance Hierarchies](#inheritance-hierarchies)
7. [The `final` Keyword](#the-final-keyword)
8. [The Object Class](#the-object-class)
9. [Common Mistakes](#common-mistakes)

---

## What is Inheritance?

**Inheritance** allows a class to inherit fields and methods from another class. It creates an "is-a" relationship between classes.

### Without Inheritance (Code Duplication)

```java
// ❌ BAD: Repeated code in each class
public class Dog {
    String name;
    int age;
    
    void eat() { System.out.println(name + " is eating"); }
    void sleep() { System.out.println(name + " is sleeping"); }
    void bark() { System.out.println(name + " says: Woof!"); }
}

public class Cat {
    String name;
    int age;
    
    void eat() { System.out.println(name + " is eating"); }    // Duplicate!
    void sleep() { System.out.println(name + " is sleeping"); } // Duplicate!
    void meow() { System.out.println(name + " says: Meow!"); }
}
```

### With Inheritance (Code Reuse)

```java
// ✅ GOOD: Common code in parent class
public class Animal {
    String name;
    int age;
    
    void eat() { System.out.println(name + " is eating"); }
    void sleep() { System.out.println(name + " is sleeping"); }
}

public class Dog extends Animal {
    void bark() { System.out.println(name + " says: Woof!"); }
}

public class Cat extends Animal {
    void meow() { System.out.println(name + " says: Meow!"); }
}
```

### Terminology

```
┌─────────────────────────────────────────────────────────┐
│                    INHERITANCE TERMS                    │
├─────────────────────────────────────────────────────────┤
│                                                         │
│  Parent Class (Superclass, Base Class)                  │
│  ┌─────────────────────────────────────┐               │
│  │           Animal                    │               │
│  │  - name, age                        │               │
│  │  - eat(), sleep()                   │               │
│  └─────────────────────────────────────┘               │
│                    ▲                                    │
│                    │ extends (inherits from)            │
│         ┌──────────┴──────────┐                        │
│         │                     │                        │
│  ┌──────┴──────┐       ┌──────┴──────┐                │
│  │    Dog      │       │    Cat      │                │
│  │  - bark()   │       │  - meow()   │                │
│  └─────────────┘       └─────────────┘                │
│  Child Class (Subclass, Derived Class)                 │
│                                                         │
└─────────────────────────────────────────────────────────┘
```

### The "is-a" Relationship

```
✅ Dog is-an Animal       → Dog extends Animal
✅ Cat is-an Animal       → Cat extends Animal
✅ Car is-a Vehicle       → Car extends Vehicle
✅ Manager is-an Employee → Manager extends Employee

❌ Car has-an Engine      → Not inheritance (use composition)
❌ Dog has-a Name         → Not inheritance (use a field)
```

---

## The `extends` Keyword

Use `extends` to inherit from a parent class.

### Basic Syntax

```java
public class ChildClass extends ParentClass {
    // Child class code
}
```

### Complete Example

```java
// Parent class
public class Vehicle {
    String brand;
    int year;
    
    void start() {
        System.out.println("Vehicle starting...");
    }
    
    void stop() {
        System.out.println("Vehicle stopping...");
    }
    
    void displayInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}

// Child class
public class Car extends Vehicle {
    int numDoors;
    
    void honk() {
        System.out.println("Car goes: Beep beep!");
    }
}

// Another child class
public class Motorcycle extends Vehicle {
    boolean hasSidecar;
    
    void wheelie() {
        System.out.println("Motorcycle doing a wheelie!");
    }
}
```

### Using Inherited Members

```java
Car myCar = new Car();

// Inherited from Vehicle
myCar.brand = "Toyota";
myCar.year = 2024;
myCar.start();
myCar.displayInfo();

// Defined in Car
myCar.numDoors = 4;
myCar.honk();
```

---

## The `super` Keyword

The `super` keyword refers to the parent class. It's used to:
1. Call the parent's constructor
2. Call the parent's methods
3. Access the parent's fields (if not private)

### Calling Parent Constructor

```java
public class Animal {
    String name;
    int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Dog extends Animal {
    String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age);  // Call parent constructor FIRST
        this.breed = breed;
    }
}
```

### Important Rules for `super()`

```
1. super() must be the FIRST statement in the constructor
2. If you don't call super(), Java calls super() automatically (no-arg)
3. If parent has no no-arg constructor, you MUST call super() explicitly
```

### Example: Constructor Chain

```java
public class Person {
    String name;
    
    public Person(String name) {
        this.name = name;
        System.out.println("Person constructor called");
    }
}

public class Employee extends Person {
    String department;
    
    public Employee(String name, String department) {
        super(name);  // Must call parent constructor
        this.department = department;
        System.out.println("Employee constructor called");
    }
}

public class Manager extends Employee {
    int teamSize;
    
    public Manager(String name, String department, int teamSize) {
        super(name, department);  // Calls Employee constructor
        this.teamSize = teamSize;
        System.out.println("Manager constructor called");
    }
}

// Usage
Manager m = new Manager("Alice", "Engineering", 10);
// Output:
// Person constructor called
// Employee constructor called
// Manager constructor called
```

### Calling Parent Methods

```java
public class Animal {
    void makeSound() {
        System.out.println("Some generic sound");
    }
}

public class Dog extends Animal {
    @Override
    void makeSound() {
        super.makeSound();  // Call parent's version first
        System.out.println("Woof woof!");  // Then add our own
    }
}

// Usage
Dog d = new Dog();
d.makeSound();
// Output:
// Some generic sound
// Woof woof!
```

---

## Method Overriding

A child class can **override** (replace) a parent's method with its own implementation.

### Basic Overriding

```java
public class Animal {
    void makeSound() {
        System.out.println("Some sound...");
    }
}

public class Dog extends Animal {
    @Override  // Optional but recommended annotation
    void makeSound() {
        System.out.println("Woof woof!");
    }
}

public class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow!");
    }
}
```

### Using @Override Annotation

```java
// ✅ GOOD: @Override catches errors
public class Dog extends Animal {
    @Override
    void makeSound() {  // Compiler verifies this overrides a parent method
        System.out.println("Woof!");
    }
}

// ❌ BAD: Typo creates new method instead of overriding
public class Dog extends Animal {
    @Override
    void makSound() {  // Compiler ERROR: no method to override
        System.out.println("Woof!");
    }
}
```

### Override Rules

```
1. Method name must match exactly
2. Parameters must match exactly
3. Return type must be same or subtype (covariant return)
4. Access modifier can be same or MORE accessible (not less)
5. Cannot override final methods
6. Cannot override static methods (that's hiding, not overriding)
```

### Example: Shape Hierarchy

```java
public class Shape {
    String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    double calculateArea() {
        return 0;  // Default implementation
    }
    
    void display() {
        System.out.println("A " + color + " shape");
    }
}

public class Circle extends Shape {
    double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    void display() {
        System.out.println("A " + color + " circle with radius " + radius);
    }
}

public class Rectangle extends Shape {
    double width, height;
    
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    double calculateArea() {
        return width * height;
    }
    
    @Override
    void display() {
        System.out.println("A " + color + " rectangle " + width + "x" + height);
    }
}
```

---

## The `protected` Modifier

`protected` members are accessible in:
- The same class
- The same package
- Child classes (even in different packages)

```java
public class Animal {
    private String secret = "hidden";      // Only in Animal
    protected String family = "Animalia";  // In Animal and children
    public String name = "Generic";        // Everywhere
    
    protected void protectedMethod() {
        System.out.println("Called from Animal or its children");
    }
}

public class Dog extends Animal {
    void accessParent() {
        // System.out.println(secret);  // ❌ ERROR: private
        System.out.println(family);     // ✅ OK: protected
        System.out.println(name);       // ✅ OK: public
        protectedMethod();              // ✅ OK: protected
    }
}
```

### Access Modifier Summary

| Modifier | Same Class | Same Package | Subclass | World |
|----------|------------|--------------|----------|-------|
| private | ✅ | ❌ | ❌ | ❌ |
| (default) | ✅ | ✅ | ❌ | ❌ |
| protected | ✅ | ✅ | ✅ | ❌ |
| public | ✅ | ✅ | ✅ | ✅ |

---

## Inheritance Hierarchies

Classes can form multi-level hierarchies.

### Multi-Level Inheritance

```java
public class LivingThing {
    boolean isAlive = true;
}

public class Animal extends LivingThing {
    void move() {
        System.out.println("Moving...");
    }
}

public class Mammal extends Animal {
    void breathe() {
        System.out.println("Breathing air...");
    }
}

public class Dog extends Mammal {
    void bark() {
        System.out.println("Woof!");
    }
}

// Dog inherits from ALL parents
Dog d = new Dog();
d.isAlive;   // From LivingThing
d.move();    // From Animal
d.breathe(); // From Mammal
d.bark();    // From Dog
```

### Single Inheritance Rule

Java supports **single inheritance** only - a class can extend only ONE class.

```java
// ❌ WRONG: Java doesn't allow multiple inheritance
public class FlyingFish extends Fish, Bird {
    // Error!
}

// ✅ CORRECT: Use interfaces for multiple behaviors (covered in Phase 4)
public class FlyingFish extends Fish implements Flyable {
    // OK!
}
```

### Inheritance Hierarchy Example

```
                    Object
                       │
                    Person
                    /    \
              Employee  Student
               /    \
          Manager  Developer
             │
        SeniorManager
```

---

## The `final` Keyword

`final` prevents inheritance and overriding.

### Final Class (Cannot Be Extended)

```java
public final class String {
    // No class can extend String
}

// ❌ ERROR: Cannot extend final class
public class MyString extends String {
    // Compile error!
}
```

### Final Method (Cannot Be Overridden)

```java
public class Animal {
    final void breathe() {
        System.out.println("Breathing...");
    }
}

public class Dog extends Animal {
    // ❌ ERROR: Cannot override final method
    @Override
    void breathe() {
        // Compile error!
    }
}
```

### When to Use Final

```
Use final class when:
- Security/immutability is critical (like String)
- The class design is complete and should not be extended

Use final method when:
- The behavior should never change
- Called from constructors (prevents issues with overriding)
```

---

## The Object Class

Every class in Java implicitly extends `Object`. It provides useful methods.

### Important Object Methods

```java
public class Object {
    // Returns string representation
    public String toString() { ... }
    
    // Checks equality
    public boolean equals(Object obj) { ... }
    
    // Returns hash code
    public int hashCode() { ... }
    
    // Returns class information
    public Class<?> getClass() { ... }
    
    // Creates a copy
    protected Object clone() { ... }
}
```

### Overriding toString()

```java
public class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

// Usage
Person p = new Person("Alice", 25);
System.out.println(p);  // Calls toString() automatically
// Output: Person{name='Alice', age=25}
```

### Overriding equals()

```java
public class Person {
    String name;
    int age;
    
    @Override
    public boolean equals(Object obj) {
        // Check if same object
        if (this == obj) return true;
        
        // Check if null or different class
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // Cast and compare fields
        Person other = (Person) obj;
        return age == other.age && name.equals(other.name);
    }
}
```

---

## Common Mistakes

### Mistake 1: Forgetting to Call super()

```java
// ❌ WRONG: Parent has no default constructor
public class Animal {
    String name;
    public Animal(String name) {
        this.name = name;
    }
}

public class Dog extends Animal {
    public Dog(String name) {
        // ERROR: No super() call, and Animal has no no-arg constructor
    }
}

// ✅ CORRECT
public class Dog extends Animal {
    public Dog(String name) {
        super(name);  // Call parent constructor
    }
}
```

### Mistake 2: Overriding with Wrong Signature

```java
// ❌ WRONG: Different parameter types
public class Animal {
    void eat(String food) { }
}

public class Dog extends Animal {
    @Override
    void eat(int amount) { }  // ERROR: This doesn't override, it overloads
}
```

### Mistake 3: Reducing Visibility

```java
// ❌ WRONG: Cannot reduce visibility
public class Animal {
    public void move() { }
}

public class Dog extends Animal {
    @Override
    private void move() { }  // ERROR: Cannot be private
}
```

### Mistake 4: Incorrect "is-a" Relationship

```java
// ❌ WRONG: A square is not always a rectangle (mathematically debatable!)
public class Rectangle {
    void setWidth(int w) { width = w; }
    void setHeight(int h) { height = h; }
}

public class Square extends Rectangle {
    // Problem: Can set width and height differently!
}

// ✅ BETTER: Both extend Shape
public class Rectangle extends Shape { ... }
public class Square extends Shape { ... }
```

### Mistake 5: Deep Inheritance Hierarchies

```java
// ❌ TOO DEEP: Hard to maintain
class A { }
class B extends A { }
class C extends B { }
class D extends C { }
class E extends D { }
class F extends E { }  // 6 levels deep!

// ✅ BETTER: Keep it shallow (2-3 levels max)
```

---

## Key Takeaways

✅ **Inheritance** enables code reuse with "is-a" relationships
✅ **extends** creates a parent-child relationship
✅ **super** calls parent constructor or methods
✅ **@Override** ensures correct method overriding
✅ **protected** allows access in children
✅ **final** prevents inheritance or overriding
✅ **Object** is the root of all classes

---

## Next Steps

Now that you understand inheritance, you're ready for:
- **Polymorphism** - Objects behaving differently based on their type
- Abstract classes and interfaces

Keep building hierarchies! 🧬
