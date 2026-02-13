/**
 * Class 5: Polymorphism - Complete Example
 *
 * Demonstrates:
 * - Method overloading (compile-time polymorphism)
 * - Method overriding (runtime polymorphism)
 * - Dynamic dispatch with arrays
 * - Upcasting and downcasting
 * - Abstract classes
 * - Interfaces
 *
 * How to compile and run:
 * $ javac PolymorphismDemo.java
 * $ java PolymorphismDemo
 */

public class PolymorphismDemo {

    public static void main(String[] args) {
        System.out.println("========== POLYMORPHISM DEMO ==========\n");

        // ================================================
        // DEMONSTRATION 1: COMPILE-TIME POLYMORPHISM
        // ================================================
        System.out.println("1. COMPILE-TIME POLYMORPHISM (OVERLOADING)");
        System.out.println("─────────────────────────────────────────");

        Calculator calculator = new Calculator();
        System.out.println("add(int, int): " + calculator.add(3, 4));
        System.out.println("add(double, double): " + calculator.add(2.5, 4.1));
        System.out.println();


        // ================================================
        // DEMONSTRATION 2: RUNTIME POLYMORPHISM
        // ================================================
        System.out.println("2. RUNTIME POLYMORPHISM (OVERRIDING)");
        System.out.println("─────────────────────────────────────────");

        Animal animal = new Animal("Generic");
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Mittens");

        animal.makeSound();
        dog.makeSound();
        cat.makeSound();
        System.out.println();


        // ================================================
        // DEMONSTRATION 3: DYNAMIC DISPATCH WITH ARRAYS
        // ================================================
        System.out.println("3. DYNAMIC DISPATCH WITH ARRAYS");
        System.out.println("─────────────────────────────────────────");

        Animal[] pets = {
            new Dog("Rex"),
            new Cat("Luna"),
            new Dog("Max")
        };

        for (Animal pet : pets) {
            pet.makeSound();
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 4: UPCASTING AND DOWNCASTING
        // ================================================
        System.out.println("4. UPCASTING AND DOWNCASTING");
        System.out.println("─────────────────────────────────────────");

        Animal pet = new Dog("Charlie");  // Upcast
        pet.makeSound();

        if (pet instanceof Dog) {
            Dog realDog = (Dog) pet;      // Downcast
            realDog.fetch();
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 5: ABSTRACT CLASSES
        // ================================================
        System.out.println("5. ABSTRACT CLASSES");
        System.out.println("─────────────────────────────────────────");

        Shape circle = new Circle("Circle", 5);
        Shape rectangle = new Rectangle("Rectangle", 4, 6);

        circle.printInfo();
        rectangle.printInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 6: INTERFACES
        // ================================================
        System.out.println("6. INTERFACES");
        System.out.println("─────────────────────────────────────────");

        PaymentMethod card = new CardPayment("Visa", "**** 1234");
        PaymentMethod wallet = new WalletPayment("QuickPay", "user@quickpay");

        processPayment(card, 49.99);
        processPayment(wallet, 19.50);
        System.out.println();


        // ================================================
        // DEMONSTRATION 7: POLYMORPHIC COLLECTION
        // ================================================
        System.out.println("7. POLYMORPHIC COLLECTION");
        System.out.println("─────────────────────────────────────────");

        Shape[] shapes = {
            new Circle("Circle", 2),
            new Rectangle("Rectangle", 3, 7),
            new Triangle("Triangle", 4, 5)
        };

        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.area();
            shape.printInfo();
        }
        System.out.println("Total area: " + String.format("%.2f", totalArea));
        System.out.println();

        System.out.println("========== END OF DEMO ==========");
    }

    // Helper method to show interface polymorphism
    public static void processPayment(PaymentMethod method, double amount) {
        System.out.println("Processing payment using: " + method.getMethodName());
        boolean success = method.pay(amount);
        System.out.println("Payment success: " + success);
        System.out.println();
    }
}

// =========================================================
// CLASSES FOR OVERLOADING
// =========================================================
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

// =========================================================
// CLASSES FOR OVERRIDING
// =========================================================
class Animal {
    protected String name;

    Animal(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println(name + " says: ...");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof!");
    }

    void fetch() {
        System.out.println(name + " is fetching the ball!");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

// =========================================================
// ABSTRACT CLASS EXAMPLE
// =========================================================
abstract class Shape {
    protected String name;

    Shape(String name) {
        this.name = name;
    }

    abstract double area();

    void printInfo() {
        System.out.println(name + " area: " + String.format("%.2f", area()));
    }
}

class Circle extends Shape {
    private double radius;

    Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    Triangle(String name, double base, double height) {
        super(name);
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }
}

// =========================================================
// INTERFACE EXAMPLE
// =========================================================
interface PaymentMethod {
    String getMethodName();
    boolean pay(double amount);
}

class CardPayment implements PaymentMethod {
    private String cardType;
    private String maskedNumber;

    CardPayment(String cardType, String maskedNumber) {
        this.cardType = cardType;
        this.maskedNumber = maskedNumber;
    }

    @Override
    public String getMethodName() {
        return cardType + " " + maskedNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Charging " + getMethodName() + " for $" + amount);
        return true;
    }
}

class WalletPayment implements PaymentMethod {
    private String provider;
    private String accountId;

    WalletPayment(String provider, String accountId) {
        this.provider = provider;
        this.accountId = accountId;
    }

    @Override
    public String getMethodName() {
        return provider + " (" + accountId + ")";
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Sending payment via " + provider + " for $" + amount);
        return true;
    }
}
