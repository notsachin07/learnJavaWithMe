/**
 * Class 4: Inheritance - Complete Example
 *
 * Demonstrates:
 * - Basic inheritance with extends
 * - The super keyword
 * - Method overriding
 * - Protected access
 * - Inheritance hierarchies
 * - The final keyword
 * - Overriding Object methods
 *
 * How to compile and run:
 * $ javac InheritanceDemo.java
 * $ java InheritanceDemo
 */

public class InheritanceDemo {

    public static void main(String[] args) {
        System.out.println("========== INHERITANCE DEMO ==========\n");

        // ================================================
        // DEMONSTRATION 1: BASIC INHERITANCE
        // ================================================
        System.out.println("1. BASIC INHERITANCE");
        System.out.println("─────────────────────────────────────────");

        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        System.out.println("Created a Dog:");
        dog.displayInfo();
        
        // Inherited methods from Animal
        dog.eat();
        dog.sleep();
        
        // Dog's own method
        dog.bark();
        System.out.println();

        Cat cat = new Cat("Whiskers", 2, true);
        System.out.println("Created a Cat:");
        cat.displayInfo();
        cat.eat();
        cat.meow();
        System.out.println();


        // ================================================
        // DEMONSTRATION 2: THE SUPER KEYWORD
        // ================================================
        System.out.println("2. THE SUPER KEYWORD");
        System.out.println("─────────────────────────────────────────");

        System.out.println("Creating Manager (shows constructor chain):");
        Manager manager = new Manager("Alice", 35, "Engineering", 75000, 10);
        System.out.println();
        manager.displayInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 3: METHOD OVERRIDING
        // ================================================
        System.out.println("3. METHOD OVERRIDING");
        System.out.println("─────────────────────────────────────────");

        Animal genericAnimal = new Animal("Generic", 1);
        Dog buddy = new Dog("Buddy", 3, "Labrador");
        Cat mittens = new Cat("Mittens", 2, false);

        System.out.println("Calling makeSound() on different animals:");
        genericAnimal.makeSound();  // Animal's version
        buddy.makeSound();          // Dog's overridden version
        mittens.makeSound();        // Cat's overridden version
        System.out.println();


        // ================================================
        // DEMONSTRATION 4: SHAPE HIERARCHY
        // ================================================
        System.out.println("4. SHAPE HIERARCHY");
        System.out.println("─────────────────────────────────────────");

        Circle circle = new Circle("red", 5);
        Rectangle rectangle = new Rectangle("blue", 10, 5);
        Triangle triangle = new Triangle("green", 6, 8);

        System.out.println("Circle:");
        circle.display();
        System.out.println("Area: " + String.format("%.2f", circle.calculateArea()));
        System.out.println();

        System.out.println("Rectangle:");
        rectangle.display();
        System.out.println("Area: " + String.format("%.2f", rectangle.calculateArea()));
        System.out.println();

        System.out.println("Triangle:");
        triangle.display();
        System.out.println("Area: " + String.format("%.2f", triangle.calculateArea()));
        System.out.println();


        // ================================================
        // DEMONSTRATION 5: VEHICLE HIERARCHY
        // ================================================
        System.out.println("5. VEHICLE HIERARCHY");
        System.out.println("─────────────────────────────────────────");

        Car car = new Car("Toyota", "Camry", 2024, 4);
        Motorcycle motorcycle = new Motorcycle("Harley", "Sportster", 2023, true);
        Truck truck = new Truck("Ford", "F-150", 2022, 5000);

        System.out.println("Car:");
        car.displayInfo();
        car.start();
        car.honk();
        System.out.println();

        System.out.println("Motorcycle:");
        motorcycle.displayInfo();
        motorcycle.start();
        motorcycle.wheelie();
        System.out.println();

        System.out.println("Truck:");
        truck.displayInfo();
        truck.start();
        truck.loadCargo(2000);
        System.out.println();


        // ================================================
        // DEMONSTRATION 6: MULTI-LEVEL INHERITANCE
        // ================================================
        System.out.println("6. MULTI-LEVEL INHERITANCE");
        System.out.println("─────────────────────────────────────────");

        GermanShepherd gs = new GermanShepherd("Rex", 4, true);
        System.out.println("GermanShepherd inherits from Dog → Animal:");
        gs.displayInfo();
        gs.eat();      // From Animal
        gs.bark();     // From Dog
        gs.guard();    // From GermanShepherd
        System.out.println();


        // ================================================
        // DEMONSTRATION 7: PROTECTED ACCESS
        // ================================================
        System.out.println("7. PROTECTED ACCESS");
        System.out.println("─────────────────────────────────────────");

        BankAccount account = new SavingsAccount("SA001", "John", 1000, 0.05);
        account.displayInfo();
        
        SavingsAccount savings = (SavingsAccount) account;
        savings.applyInterest();
        savings.displayInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 8: OVERRIDING toString()
        // ================================================
        System.out.println("8. OVERRIDING toString()");
        System.out.println("─────────────────────────────────────────");

        Student student = new Student("Bob", 20, "Computer Science", 3.8);
        
        // Without override: something like "Student@15db9742"
        // With override: readable information
        System.out.println("Printing student object:");
        System.out.println(student);  // Calls toString() automatically
        System.out.println();


        // ================================================
        // DEMONSTRATION 9: OVERRIDING equals()
        // ================================================
        System.out.println("9. OVERRIDING equals()");
        System.out.println("─────────────────────────────────────────");

        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);

        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
        System.out.println();

        System.out.println("p1 == p2: " + (p1 == p2) + " (compares references)");
        System.out.println("p1.equals(p2): " + p1.equals(p2) + " (compares content)");
        System.out.println("p1.equals(p3): " + p1.equals(p3));
        System.out.println();


        // ================================================
        // DEMONSTRATION 10: CALLING SUPER METHOD
        // ================================================
        System.out.println("10. CALLING SUPER METHOD");
        System.out.println("─────────────────────────────────────────");

        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2024, 4, 300);
        System.out.println("ElectricCar extends Car:");
        tesla.displayInfo();  // Calls super.displayInfo() + adds battery info
        System.out.println();
        tesla.start();  // Overridden start method
        System.out.println();


        System.out.println("========== END OF INHERITANCE DEMO ==========");
        System.out.println("Inheritance enables powerful code reuse! 🧬");
    }
}


// ================================================
// ANIMAL HIERARCHY
// ================================================

class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("  → Animal constructor called");
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    public void makeSound() {
        System.out.println(name + " makes a sound");
    }

    public void displayInfo() {
        System.out.println("  Name: " + name);
        System.out.println("  Age: " + age + " years");
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);  // Call parent constructor
        this.breed = breed;
        System.out.println("  → Dog constructor called");
    }

    public void bark() {
        System.out.println(name + " says: Woof woof!");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof woof!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();  // Call parent's displayInfo
        System.out.println("  Breed: " + breed);
    }

    public String getBreed() {
        return breed;
    }
}

class Cat extends Animal {
    private boolean isIndoor;

    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }

    public void meow() {
        System.out.println(name + " says: Meow!");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Indoor cat: " + isIndoor);
    }
}

// Multi-level inheritance
class GermanShepherd extends Dog {
    private boolean isTrainedGuard;

    public GermanShepherd(String name, int age, boolean isTrainedGuard) {
        super(name, age, "German Shepherd");
        this.isTrainedGuard = isTrainedGuard;
    }

    public void guard() {
        if (isTrainedGuard) {
            System.out.println(name + " is guarding the house!");
        } else {
            System.out.println(name + " is watching...");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Trained Guard: " + isTrainedGuard);
    }
}


// ================================================
// EMPLOYEE HIERARCHY
// ================================================

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("  → Person constructor called");
    }
}

class Employee extends Person {
    protected String department;
    protected double salary;

    public Employee(String name, int age, String department, double salary) {
        super(name, age);
        this.department = department;
        this.salary = salary;
        System.out.println("  → Employee constructor called");
    }

    public void displayInfo() {
        System.out.println("  Name: " + name);
        System.out.println("  Age: " + age);
        System.out.println("  Department: " + department);
        System.out.println("  Salary: $" + salary);
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int age, String department, double salary, int teamSize) {
        super(name, age, department, salary);
        this.teamSize = teamSize;
        System.out.println("  → Manager constructor called");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Team Size: " + teamSize);
    }
}


// ================================================
// SHAPE HIERARCHY
// ================================================

class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public double calculateArea() {
        return 0;
    }

    public void display() {
        System.out.println("A " + color + " shape");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("A " + color + " circle with radius " + radius);
    }
}

class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public void display() {
        System.out.println("A " + color + " rectangle " + width + " x " + height);
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public void display() {
        System.out.println("A " + color + " triangle with base " + base + " and height " + height);
    }
}


// ================================================
// VEHICLE HIERARCHY
// ================================================

class Vehicle {
    protected String brand;
    protected String model;
    protected int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println("Vehicle starting...");
    }

    public void stop() {
        System.out.println("Vehicle stopping...");
    }

    public void displayInfo() {
        System.out.println("  Brand: " + brand);
        System.out.println("  Model: " + model);
        System.out.println("  Year: " + year);
    }
}

class Car extends Vehicle {
    protected int numDoors;

    public Car(String brand, String model, int year, int numDoors) {
        super(brand, model, year);
        this.numDoors = numDoors;
    }

    public void honk() {
        System.out.println("🚗 " + brand + " " + model + ": Beep beep!");
    }

    @Override
    public void start() {
        System.out.println("🚗 " + brand + " " + model + " engine starting... Vroom!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Doors: " + numDoors);
    }
}

class ElectricCar extends Car {
    private int batteryRange;

    public ElectricCar(String brand, String model, int year, int numDoors, int batteryRange) {
        super(brand, model, year, numDoors);
        this.batteryRange = batteryRange;
    }

    @Override
    public void start() {
        System.out.println("⚡ " + brand + " " + model + " silently starting...");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Battery Range: " + batteryRange + " miles");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, boolean hasSidecar) {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }

    public void wheelie() {
        System.out.println("🏍️ " + brand + " " + model + " doing a wheelie!");
    }

    @Override
    public void start() {
        System.out.println("🏍️ " + brand + " " + model + " engine roaring!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Has Sidecar: " + hasSidecar);
    }
}

class Truck extends Vehicle {
    private int cargoCapacity;
    private int currentCargo;

    public Truck(String brand, String model, int year, int cargoCapacity) {
        super(brand, model, year);
        this.cargoCapacity = cargoCapacity;
        this.currentCargo = 0;
    }

    public void loadCargo(int weight) {
        if (currentCargo + weight <= cargoCapacity) {
            currentCargo += weight;
            System.out.println("🚚 Loaded " + weight + " lbs. Total: " + currentCargo + "/" + cargoCapacity);
        } else {
            System.out.println("🚚 Cannot load! Exceeds capacity.");
        }
    }

    @Override
    public void start() {
        System.out.println("🚚 " + brand + " " + model + " diesel engine rumbling!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Cargo Capacity: " + cargoCapacity + " lbs");
    }
}


// ================================================
// BANK ACCOUNT HIERARCHY
// ================================================

class BankAccount {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount);
        }
    }

    public void displayInfo() {
        System.out.println("  Account: " + accountNumber);
        System.out.println("  Owner: " + ownerName);
        System.out.println("  Balance: $" + String.format("%.2f", balance));
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest applied: $" + String.format("%.2f", interest));
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Interest Rate: " + (interestRate * 100) + "%");
    }
}


// ================================================
// STUDENT CLASS (toString example)
// ================================================

class Student {
    private String name;
    private int age;
    private String major;
    private double gpa;

    public Student(String name, int age, String major, double gpa) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + 
               ", major='" + major + "', gpa=" + gpa + "}";
    }
}


// ================================================
// POINT CLASS (equals example)
// ================================================

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        // Same reference
        if (this == obj) return true;
        
        // Null or different class
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // Compare fields
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
