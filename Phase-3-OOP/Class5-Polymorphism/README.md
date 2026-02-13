# Class 5: Polymorphism 🎭

Welcome to **Phase 3, Class 5**! This class covers **polymorphism**, the OOP concept that lets the *same code* work with *different types* of objects.

---

## Table of Contents
1. [What is Polymorphism?](#what-is-polymorphism)
2. [Compile-Time vs Runtime Polymorphism](#compile-time-vs-runtime-polymorphism)
3. [Method Overriding Rules](#method-overriding-rules)
4. [Dynamic Dispatch (Runtime Binding)](#dynamic-dispatch-runtime-binding)
5. [Upcasting](#upcasting)
6. [Downcasting and `instanceof`](#downcasting-and-instanceof)
7. [Abstract Classes](#abstract-classes)
8. [Interfaces](#interfaces)
9. [Polymorphism in Collections](#polymorphism-in-collections)
10. [Common Mistakes](#common-mistakes)
11. [Summary](#summary)

---

## What is Polymorphism?

**Polymorphism** means "many forms." In Java, it means you can treat different objects the same way, and each object responds in its own way.

### Example
```java
Animal animal = new Dog();
animal.makeSound();  // Dog's version runs
```

Even though the variable type is `Animal`, the **Dog** version of `makeSound()` runs at runtime.

---

## Compile-Time vs Runtime Polymorphism

### ✅ Compile-Time (Overloading)
The compiler decides which method to call based on parameter types.

```java
class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
```

### ✅ Runtime (Overriding)
The JVM decides which method to call based on the **actual object type**.

```java
Animal pet = new Cat();
pet.makeSound();   // Cat's version at runtime
```

---

## Method Overriding Rules

When a subclass overrides a method:

✅ Same method name
✅ Same parameter list
✅ Return type must be same (or covariant)
✅ Access level cannot be more restrictive
✅ Use `@Override` annotation

```java
class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof!");
    }
}
```

---

## Dynamic Dispatch (Runtime Binding)

When you call an overridden method, Java decides *at runtime* which version to run.

```java
Animal[] animals = {
    new Dog(),
    new Cat(),
    new Dog()
};

for (Animal a : animals) {
    a.makeSound();
}
```

Output:
```
Woof!
Meow!
Woof!
```

---

## Upcasting

**Upcasting** means treating a subclass object as a parent type.

```java
Animal pet = new Dog();  // Upcast
pet.makeSound();         // Dog's method
```

✅ Always safe
✅ Enables polymorphism

---

## Downcasting and `instanceof`

**Downcasting** means converting a parent reference back to a child type.

```java
Animal pet = new Dog();

if (pet instanceof Dog) {
    Dog dog = (Dog) pet;
    dog.fetch();
}
```

⚠️ Only safe if the object is actually that type.

---

## Abstract Classes

Abstract classes define a common base but cannot be instantiated.

```java
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;
    Circle(double r) { radius = r; }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
```

---

## Interfaces

Interfaces are pure contracts. Classes **implement** them.

```java
interface Payable {
    void pay(double amount);
}

class CreditCard implements Payable {
    public void pay(double amount) {
        System.out.println("Paid $" + amount);
    }
}
```

You can use interfaces for flexible design:

```java
Payable method = new CreditCard();
method.pay(50.0);
```

---

## Polymorphism in Collections

A collection can store many different subclasses:

```java
List<Shape> shapes = List.of(
    new Circle(2),
    new Rectangle(4, 5)
);

for (Shape s : shapes) {
    System.out.println(s.area());
}
```

---

## Common Mistakes

❌ Confusing **overloading** with **overriding**

❌ Forgetting `@Override`

❌ Trying to override `static` methods (static methods are *hidden*, not overridden)

❌ Downcasting without checking `instanceof`

❌ Expecting fields to be polymorphic (only methods are)

---

## Summary

✅ Polymorphism lets one interface work with multiple types

✅ Overloading = compile-time polymorphism

✅ Overriding = runtime polymorphism

✅ Upcasting enables dynamic dispatch

✅ Interfaces and abstract classes make systems flexible

Next: **Phase 4 (Advanced Features)** will build on these OOP foundations! 🚀
