/**
 * Class 1: Classes & Objects - Complete Example
 *
 * Demonstrates:
 * - Class definition with fields and methods
 * - Creating objects from a class
 * - Accessing fields and calling methods
 * - Real-world class examples
 * - Object independence
 *
 * How to compile and run:
 * $ javac ClassesDemo.java
 * $ java ClassesDemo
 */

public class ClassesDemo {

    public static void main(String[] args) {
        System.out.println("========== CLASSES & OBJECTS DEMO ==========\n");

        // ================================================
        // DEMONSTRATION 1: SIMPLE CLASS USAGE
        // ================================================
        System.out.println("1. SIMPLE BOOK CLASS");
        System.out.println("─────────────────────────────────────────");

        // Create first book object
        Book book1 = new Book();
        book1.title = "Java Programming";
        book1.author = "John Doe";
        book1.pages = 500;
        book1.price = 45.99;
        book1.isAvailable = true;

        System.out.println("Book 1:");
        book1.displayInfo();
        System.out.println("Reading time: " + book1.readingTime() + " hours\n");

        // Create second book object
        Book book2 = new Book();
        book2.title = "Python Basics";
        book2.author = "Jane Smith";
        book2.pages = 350;
        book2.price = 35.99;
        book2.isAvailable = true;

        System.out.println("Book 2:");
        book2.displayInfo();
        System.out.println("Reading time: " + book2.readingTime() + " hours\n");

        // Objects are independent!
        System.out.println("Notice: book1 and book2 are separate objects\n");


        // ================================================
        // DEMONSTRATION 2: OBJECT METHODS
        // ================================================
        System.out.println("2. OBJECT METHODS");
        System.out.println("─────────────────────────────────────────");

        book1.checkout();
        System.out.println("Available now? " + book1.isAvailable + "\n");

        book1.returnBook();
        System.out.println("Available now? " + book1.isAvailable + "\n");


        // ================================================
        // DEMONSTRATION 3: PERSON CLASS
        // ================================================
        System.out.println("3. PERSON CLASS");
        System.out.println("─────────────────────────────────────────");

        Person person = new Person();
        person.name = "Alice";
        person.age = 25;
        person.occupation = "Software Engineer";
        person.city = "New York";

        person.introduce();
        person.displayInfo();
        System.out.println();

        person.celebrateBirthday();
        person.displayInfo();
        System.out.println();

        person.changeJob("Senior Developer");
        person.displayInfo();
        System.out.println();


        // ================================================
        // DEMONSTRATION 4: RECTANGLE CLASS
        // ================================================
        System.out.println("4. RECTANGLE CLASS");
        System.out.println("─────────────────────────────────────────");

        Rectangle rect1 = new Rectangle();
        rect1.width = 10;
        rect1.height = 5;
        rect1.color = "blue";

        rect1.displayDimensions();
        System.out.println("Area: " + rect1.calculateArea());
        System.out.println("Perimeter: " + rect1.calculatePerimeter());
        System.out.println("Is square? " + rect1.isSquare());
        System.out.println();

        // Resize the rectangle
        rect1.resize(8, 8);
        System.out.println("After resizing to 8x8:");
        System.out.println("Area: " + rect1.calculateArea());
        System.out.println("Is square? " + rect1.isSquare());
        System.out.println();


        // ================================================
        // DEMONSTRATION 5: BANK ACCOUNT CLASS
        // ================================================
        System.out.println("5. BANK ACCOUNT CLASS");
        System.out.println("─────────────────────────────────────────");

        BankAccount account = new BankAccount();
        account.accountHolder = "Bob Johnson";
        account.accountNumber = "123456789";
        account.balance = 1000.00;

        account.displayBalance();
        System.out.println();

        account.deposit(500);
        System.out.println();

        account.withdraw(300);
        System.out.println();

        if (account.hasEnoughFunds(200)) {
            System.out.println("You have enough funds for a $200 withdrawal\n");
        }

        if (!account.hasEnoughFunds(2000)) {
            System.out.println("You don't have enough funds for a $2000 withdrawal\n");
        }


        // ================================================
        // DEMONSTRATION 6: STUDENT CLASS WITH ARRAY
        // ================================================
        System.out.println("6. STUDENT CLASS");
        System.out.println("─────────────────────────────────────────");

        Student student = new Student();
        student.name = "Charlie";
        student.studentID = 12345;
        student.major = "Computer Science";
        student.grades = new int[]{85, 90, 92, 88, 95};

        student.displayInfo();
        System.out.println("Average: " + student.calculateAverage());
        System.out.println("Highest grade: " + student.findHighestGrade());
        System.out.println("Passed? " + student.isPassing());
        System.out.println();


        // ================================================
        // DEMONSTRATION 7: MULTIPLE OBJECTS, INDEPENDENT STATES
        // ================================================
        System.out.println("7. OBJECT INDEPENDENCE");
        System.out.println("─────────────────────────────────────────");

        Dog dog1 = new Dog();
        dog1.name = "Buddy";
        dog1.breed = "Golden Retriever";
        dog1.age = 3;

        Dog dog2 = new Dog();
        dog2.name = "Max";
        dog2.breed = "Labrador";
        dog2.age = 2;

        Dog dog3 = new Dog();
        dog3.name = "Charlie";
        dog3.breed = "Bulldog";
        dog3.age = 5;

        System.out.println("Three dogs, each with their own properties:\n");

        dog1.displayInfo();
        System.out.println("Is adult? " + dog1.isAdult());
        System.out.println();

        dog2.displayInfo();
        System.out.println("Is adult? " + dog2.isAdult());
        System.out.println();

        dog3.displayInfo();
        System.out.println("Is adult? " + dog3.isAdult());
        System.out.println();

        System.out.println("They can all do different things:");
        dog1.bark();
        dog1.eat("kibble");
        System.out.println();

        dog2.bark();
        dog2.play("fetch");
        System.out.println();

        dog3.bark();
        dog3.sleep();
        System.out.println();


        // ================================================
        // DEMONSTRATION 8: CAR CLASS WITH OPERATIONS
        // ================================================
        System.out.println("8. CAR CLASS WITH STATE CHANGES");
        System.out.println("─────────────────────────────────────────");

        Car car = new Car();
        car.brand = "Toyota";
        car.color = "red";
        car.speed = 0;
        car.fuelLevel = 100;

        car.displayStatus();
        System.out.println();

        System.out.println("Starting the car and accelerating...");
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.displayStatus();
        System.out.println();

        System.out.println("Honking the horn...");
        car.honk();
        System.out.println();

        System.out.println("Using fuel...");
        car.useFuel(20);
        car.displayStatus();
        System.out.println();

        System.out.println("Braking...");
        car.brake();
        car.brake();
        car.displayStatus();
        System.out.println();


        // ================================================
        // DEMONSTRATION 9: COMPARING TWO OBJECTS
        // ================================================
        System.out.println("9. COMPARING OBJECTS");
        System.out.println("─────────────────────────────────────────");

        Person p1 = new Person();
        p1.name = "John";
        p1.age = 30;

        Person p2 = new Person();
        p2.name = "Jane";
        p2.age = 25;

        System.out.println("Person 1:");
        p1.displayInfo();
        System.out.println();

        System.out.println("Person 2:");
        p2.displayInfo();
        System.out.println();

        if (p1.age > p2.age) {
            System.out.println(p1.name + " is older than " + p2.name);
        } else {
            System.out.println(p2.name + " is older than " + p1.name);
        }
        System.out.println();


        System.out.println("========== END OF CLASSES DEMO ==========");
        System.out.println("Objects are the foundation of OOP! 🎯");
    }
}


// ================================================
// CLASS DEFINITIONS
// ================================================

/**
 * Simple Book class
 */
class Book {
    String title;
    String author;
    int pages;
    double price;
    boolean isAvailable;

    void displayInfo() {
        System.out.println("  Title: " + title);
        System.out.println("  Author: " + author);
        System.out.println("  Pages: " + pages);
        System.out.println("  Price: $" + price);
    }

    void checkout() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("✓ " + title + " checked out!");
        } else {
            System.out.println("✗ " + title + " is not available.");
        }
    }

    void returnBook() {
        isAvailable = true;
        System.out.println("✓ " + title + " returned!");
    }

    int readingTime() {
        return pages / 50;  // Assume 50 pages per hour
    }
}

/**
 * Person class with personal information
 */
class Person {
    String name;
    int age;
    String occupation;
    String city;

    void introduce() {
        System.out.println("Hi! I'm " + name + ", a " + age + "-year-old " + occupation + ".");
    }

    void displayInfo() {
        System.out.println("  Name: " + name);
        System.out.println("  Age: " + age);
        System.out.println("  Occupation: " + occupation);
        System.out.println("  City: " + city);
    }

    void celebrateBirthday() {
        age = age + 1;
        System.out.println("🎂 Happy birthday! " + name + " is now " + age + " years old.");
    }

    void changeJob(String newJob) {
        occupation = newJob;
        System.out.println("💼 " + name + " is now a " + occupation);
    }
}

/**
 * Rectangle class with geometric operations
 */
class Rectangle {
    double width;
    double height;
    String color;

    void displayDimensions() {
        System.out.println("  Width: " + width);
        System.out.println("  Height: " + height);
        System.out.println("  Color: " + color);
    }

    double calculateArea() {
        return width * height;
    }

    double calculatePerimeter() {
        return 2 * (width + height);
    }

    boolean isSquare() {
        return width == height;
    }

    void resize(double newWidth, double newHeight) {
        width = newWidth;
        height = newHeight;
    }
}

/**
 * BankAccount class with financial operations
 */
class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✓ Deposited: $" + amount);
            System.out.println("  New balance: $" + balance);
        } else {
            System.out.println("✗ Deposit amount must be positive!");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✓ Withdrew: $" + amount);
            System.out.println("  New balance: $" + balance);
        } else {
            System.out.println("✗ Invalid withdrawal amount!");
        }
    }

    void displayBalance() {
        System.out.println("  Account Holder: " + accountHolder);
        System.out.println("  Account Number: " + accountNumber);
        System.out.println("  Balance: $" + balance);
    }

    boolean hasEnoughFunds(double amount) {
        return amount <= balance;
    }
}

/**
 * Student class with grades
 */
class Student {
    String name;
    int studentID;
    String major;
    int[] grades;

    void displayInfo() {
        System.out.println("  Name: " + name);
        System.out.println("  ID: " + studentID);
        System.out.println("  Major: " + major);
        System.out.print("  Grades: ");
        for (int grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }

    double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    int findHighestGrade() {
        int max = grades[0];
        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }

    boolean isPassing() {
        return calculateAverage() >= 60;
    }
}

/**
 * Dog class with pet behaviors
 */
class Dog {
    String name;
    String breed;
    int age;

    void displayInfo() {
        System.out.println("  Name: " + name);
        System.out.println("  Breed: " + breed);
        System.out.println("  Age: " + age + " years");
    }

    void bark() {
        System.out.println("🐕 " + name + " says: Woof woof!");
    }

    void eat(String food) {
        System.out.println("🐕 " + name + " is eating " + food);
    }

    void play(String game) {
        System.out.println("🐕 " + name + " is playing " + game);
    }

    void sleep() {
        System.out.println("😴 " + name + " is taking a nap");
    }

    boolean isAdult() {
        return age >= 1;
    }
}

/**
 * Car class with state changes
 */
class Car {
    String brand;
    String color;
    int speed;
    double fuelLevel;

    void displayStatus() {
        System.out.println("  Brand: " + brand);
        System.out.println("  Color: " + color);
        System.out.println("  Speed: " + speed + " mph");
        System.out.println("  Fuel: " + fuelLevel + "%");
    }

    void accelerate() {
        if (speed < 120) {
            speed += 20;
            fuelLevel -= 2;
        }
    }

    void brake() {
        if (speed > 0) {
            speed -= 20;
        }
    }

    void honk() {
        System.out.println("🚗 " + brand + ": Beep beep!");
    }

    void useFuel(double amount) {
        if (fuelLevel >= amount) {
            fuelLevel -= amount;
            System.out.println("⛽ Used " + amount + "% fuel");
        } else {
            System.out.println("⛽ Not enough fuel!");
        }
    }
}
