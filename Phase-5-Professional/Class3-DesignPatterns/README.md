# 🏗️ Class 3: Design Patterns

## Introduction

Welcome to **Design Patterns** - proven solutions to common software design problems! Design patterns are reusable templates that help you write cleaner, more maintainable, and more flexible code. They represent decades of collective wisdom from experienced software developers.

Think of design patterns as architectural blueprints - just as architects use standard patterns for doors, windows, and rooms, software developers use patterns for object creation, structure, and behavior.

---

## 📚 Table of Contents

1. [What are Design Patterns?](#what-are-design-patterns)
2. [Categories of Patterns](#categories-of-patterns)
3. [Creational Patterns](#creational-patterns)
   - [Singleton](#singleton-pattern)
   - [Factory Method](#factory-method-pattern)
   - [Abstract Factory](#abstract-factory-pattern)
   - [Builder](#builder-pattern)
4. [Structural Patterns](#structural-patterns)
   - [Adapter](#adapter-pattern)
   - [Decorator](#decorator-pattern)
   - [Facade](#facade-pattern)
5. [Behavioral Patterns](#behavioral-patterns)
   - [Strategy](#strategy-pattern)
   - [Observer](#observer-pattern)
   - [Template Method](#template-method-pattern)
6. [When to Use Which Pattern](#when-to-use-which-pattern)
7. [Anti-Patterns to Avoid](#anti-patterns-to-avoid)
8. [Best Practices](#best-practices)
9. [Summary](#summary)

---

## What are Design Patterns?

**Design patterns** are typical solutions to commonly occurring problems in software design. They are like pre-made blueprints that you can customize to solve a recurring design problem in your code.

### Benefits of Design Patterns

1. **Proven Solutions** - Battle-tested by countless developers
2. **Common Vocabulary** - "Use a Singleton" is instantly understood
3. **Maintainability** - Easier to modify and extend
4. **Reusability** - Apply the same solution across projects
5. **Best Practices** - Encourage good OOP principles

### The Gang of Four (GoF)

The term "design patterns" was popularized by the book *Design Patterns: Elements of Reusable Object-Oriented Software* (1994) by:
- Erich Gamma
- Richard Helm
- Ralph Johnson
- John Vlissides

They documented 23 classic patterns still widely used today.

---

## Categories of Patterns

Design patterns are typically divided into three categories:

```
┌─────────────────────────────────────────────────────────────────┐
│                      DESIGN PATTERNS                             │
├─────────────────┬──────────────────┬───────────────────────────┤
│   CREATIONAL    │   STRUCTURAL     │      BEHAVIORAL           │
│                 │                  │                           │
│  How objects    │  How objects     │  How objects              │
│  are created    │  are composed    │  communicate              │
│                 │                  │                           │
│  • Singleton    │  • Adapter       │  • Strategy               │
│  • Factory      │  • Decorator     │  • Observer               │
│  • Builder      │  • Facade        │  • Template Method        │
│  • Prototype    │  • Composite     │  • Command                │
│  • Abstract     │  • Proxy         │  • State                  │
│    Factory      │  • Bridge        │  • Iterator               │
└─────────────────┴──────────────────┴───────────────────────────┘
```

---

## Creational Patterns

### Singleton Pattern

**Purpose:** Ensure a class has only one instance and provide a global access point to it.

**Use When:**
- You need exactly one instance (database connection, configuration, logger)
- That instance should be accessible globally

#### Basic Singleton (Not Thread-Safe)

```java
public class BasicSingleton {
    // The single instance
    private static BasicSingleton instance;
    
    // Private constructor prevents external instantiation
    private BasicSingleton() {
        System.out.println("Singleton instance created");
    }
    
    // Global access point
    public static BasicSingleton getInstance() {
        if (instance == null) {
            instance = new BasicSingleton();
        }
        return instance;
    }
    
    public void doSomething() {
        System.out.println("Singleton is working!");
    }
}

// Usage
BasicSingleton s1 = BasicSingleton.getInstance();
BasicSingleton s2 = BasicSingleton.getInstance();
System.out.println(s1 == s2);  // true - same instance!
```

#### Thread-Safe Singleton (Double-Checked Locking)

```java
public class ThreadSafeSingleton {
    // volatile ensures visibility across threads
    private static volatile ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton() {}
    
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {                    // First check (no lock)
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {            // Second check (with lock)
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
```

#### Best: Enum Singleton (Recommended)

```java
public enum DatabaseConnection {
    INSTANCE;  // The single instance
    
    private Connection connection;
    
    DatabaseConnection() {
        // Initialize connection
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:app.db");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect", e);
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void executeQuery(String sql) {
        System.out.println("Executing: " + sql);
    }
}

// Usage
DatabaseConnection.INSTANCE.executeQuery("SELECT * FROM users");
```

**Why Enum Singleton is Best:**
- Thread-safe by default
- Serialization-safe
- Prevents reflection attacks
- Simple and clean

---

### Factory Method Pattern

**Purpose:** Define an interface for creating objects, but let subclasses decide which class to instantiate.

**Use When:**
- You don't know the exact types of objects to create beforehand
- You want to delegate creation logic to subclasses
- You want to decouple object creation from usage

#### Simple Factory

```java
// Product interface
interface Animal {
    void speak();
    void move();
}

// Concrete products
class Dog implements Animal {
    @Override
    public void speak() { System.out.println("Woof!"); }
    
    @Override
    public void move() { System.out.println("Dog runs on 4 legs"); }
}

class Cat implements Animal {
    @Override
    public void speak() { System.out.println("Meow!"); }
    
    @Override
    public void move() { System.out.println("Cat walks gracefully"); }
}

class Bird implements Animal {
    @Override
    public void speak() { System.out.println("Tweet!"); }
    
    @Override
    public void move() { System.out.println("Bird flies"); }
}

// Simple Factory
class AnimalFactory {
    public static Animal createAnimal(String type) {
        return switch (type.toLowerCase()) {
            case "dog" -> new Dog();
            case "cat" -> new Cat();
            case "bird" -> new Bird();
            default -> throw new IllegalArgumentException("Unknown animal: " + type);
        };
    }
}

// Usage
Animal dog = AnimalFactory.createAnimal("dog");
dog.speak();  // Woof!
dog.move();   // Dog runs on 4 legs
```

#### Factory Method (with Inheritance)

```java
// Product
interface Document {
    void open();
    void save();
}

class PDFDocument implements Document {
    @Override
    public void open() { System.out.println("Opening PDF document"); }
    
    @Override
    public void save() { System.out.println("Saving PDF document"); }
}

class WordDocument implements Document {
    @Override
    public void open() { System.out.println("Opening Word document"); }
    
    @Override
    public void save() { System.out.println("Saving Word document"); }
}

// Creator (abstract)
abstract class Application {
    // Factory method - subclasses decide what to create
    protected abstract Document createDocument();
    
    // Template method using the factory method
    public void newDocument() {
        Document doc = createDocument();
        doc.open();
        System.out.println("Document ready for editing");
    }
}

// Concrete creators
class PDFApplication extends Application {
    @Override
    protected Document createDocument() {
        return new PDFDocument();
    }
}

class WordApplication extends Application {
    @Override
    protected Document createDocument() {
        return new WordDocument();
    }
}

// Usage
Application app = new PDFApplication();
app.newDocument();  // Creates and opens PDF
```

---

### Abstract Factory Pattern

**Purpose:** Provide an interface for creating families of related objects without specifying their concrete classes.

**Use When:**
- You need to create families of related products
- You want to ensure products from the same family are used together
- You want to provide a library of products without exposing implementation

```java
// Abstract products
interface Button {
    void render();
    void onClick();
}

interface Checkbox {
    void render();
    void toggle();
}

// Windows family
class WindowsButton implements Button {
    @Override
    public void render() { System.out.println("Rendering Windows button"); }
    
    @Override
    public void onClick() { System.out.println("Windows button clicked"); }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() { System.out.println("Rendering Windows checkbox"); }
    
    @Override
    public void toggle() { System.out.println("Windows checkbox toggled"); }
}

// macOS family
class MacButton implements Button {
    @Override
    public void render() { System.out.println("Rendering macOS button"); }
    
    @Override
    public void onClick() { System.out.println("macOS button clicked"); }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() { System.out.println("Rendering macOS checkbox"); }
    
    @Override
    public void toggle() { System.out.println("macOS checkbox toggled"); }
}

// Abstract factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete factories
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() { return new WindowsButton(); }
    
    @Override
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() { return new MacButton(); }
    
    @Override
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

// Client code
class Application {
    private Button button;
    private Checkbox checkbox;
    
    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }
    
    public void render() {
        button.render();
        checkbox.render();
    }
}

// Usage
GUIFactory factory = System.getProperty("os.name").contains("Windows") 
    ? new WindowsFactory() 
    : new MacFactory();

Application app = new Application(factory);
app.render();
```

---

### Builder Pattern

**Purpose:** Construct complex objects step by step, allowing different representations.

**Use When:**
- Object has many optional parameters
- You want to avoid telescoping constructors
- You need to create immutable objects with many fields
- Construction process should allow different representations

#### Classic Builder

```java
public class Pizza {
    // Required parameters
    private final String size;
    private final String crust;
    
    // Optional parameters
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;
    private final boolean onions;
    private final boolean bacon;
    private final String extraNotes;
    
    // Private constructor - only Builder can create
    private Pizza(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        this.onions = builder.onions;
        this.bacon = builder.bacon;
        this.extraNotes = builder.extraNotes;
    }
    
    // Static Builder class
    public static class Builder {
        // Required
        private final String size;
        private final String crust;
        
        // Optional - defaults
        private boolean cheese = true;
        private boolean pepperoni = false;
        private boolean mushrooms = false;
        private boolean onions = false;
        private boolean bacon = false;
        private String extraNotes = "";
        
        // Constructor with required params
        public Builder(String size, String crust) {
            this.size = size;
            this.crust = crust;
        }
        
        // Fluent setters return Builder for chaining
        public Builder cheese(boolean value) {
            cheese = value;
            return this;
        }
        
        public Builder pepperoni(boolean value) {
            pepperoni = value;
            return this;
        }
        
        public Builder mushrooms(boolean value) {
            mushrooms = value;
            return this;
        }
        
        public Builder onions(boolean value) {
            onions = value;
            return this;
        }
        
        public Builder bacon(boolean value) {
            bacon = value;
            return this;
        }
        
        public Builder extraNotes(String notes) {
            extraNotes = notes;
            return this;
        }
        
        // Build method creates the immutable object
        public Pizza build() {
            return new Pizza(this);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append(" pizza with ").append(crust).append(" crust");
        if (cheese) sb.append(", cheese");
        if (pepperoni) sb.append(", pepperoni");
        if (mushrooms) sb.append(", mushrooms");
        if (onions) sb.append(", onions");
        if (bacon) sb.append(", bacon");
        if (!extraNotes.isEmpty()) sb.append(" [").append(extraNotes).append("]");
        return sb.toString();
    }
}

// Usage - clean and readable!
Pizza pizza = new Pizza.Builder("Large", "Thin")
    .cheese(true)
    .pepperoni(true)
    .mushrooms(true)
    .extraNotes("Extra crispy")
    .build();

System.out.println(pizza);
// Large pizza with Thin crust, cheese, pepperoni, mushrooms [Extra crispy]
```

#### Builder with Lombok (in real projects)

```java
// With Lombok annotation - generates builder automatically
@Builder
public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final int age;
}

// Usage
User user = User.builder()
    .firstName("John")
    .lastName("Doe")
    .email("john@email.com")
    .age(30)
    .build();
```

---

## Structural Patterns

### Adapter Pattern

**Purpose:** Allow incompatible interfaces to work together.

**Use When:**
- You want to use an existing class but its interface doesn't match
- You need to create a reusable class that cooperates with unrelated classes
- You're integrating with third-party or legacy code

```java
// Target interface (what client expects)
interface MediaPlayer {
    void play(String filename);
}

// Existing class with incompatible interface
class VLCPlayer {
    public void playVLC(String filename) {
        System.out.println("VLC playing: " + filename);
    }
}

class FLVPlayer {
    public void playFLV(String filename) {
        System.out.println("FLV playing: " + filename);
    }
}

// Adapter makes incompatible interfaces compatible
class MediaAdapter implements MediaPlayer {
    private VLCPlayer vlcPlayer;
    private FLVPlayer flvPlayer;
    
    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            vlcPlayer = new VLCPlayer();
        } else if (audioType.equalsIgnoreCase("flv")) {
            flvPlayer = new FLVPlayer();
        }
    }
    
    @Override
    public void play(String filename) {
        if (vlcPlayer != null) {
            vlcPlayer.playVLC(filename);
        } else if (flvPlayer != null) {
            flvPlayer.playFLV(filename);
        }
    }
}

// Client using the adapter
class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String filename) {
        String extension = filename.substring(filename.lastIndexOf('.') + 1);
        
        if (extension.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3: " + filename);
        } else if (extension.equalsIgnoreCase("vlc") || 
                   extension.equalsIgnoreCase("flv")) {
            MediaAdapter adapter = new MediaAdapter(extension);
            adapter.play(filename);
        } else {
            System.out.println("Unsupported format: " + extension);
        }
    }
}

// Usage
MediaPlayer player = new AudioPlayer();
player.play("song.mp3");    // Playing MP3: song.mp3
player.play("movie.vlc");   // VLC playing: movie.vlc
player.play("video.flv");   // FLV playing: video.flv
```

---

### Decorator Pattern

**Purpose:** Add responsibilities to objects dynamically without altering their structure.

**Use When:**
- You want to add behavior to individual objects without affecting others
- Extension by subclassing is impractical
- You need to add/remove responsibilities at runtime

```java
// Component interface
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
    
    @Override
    public double getCost() {
        return 2.00;
    }
}

// Base decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    
    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
    
    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }
    
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.50;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }
    
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.25;
    }
}

class WhipCreamDecorator extends CoffeeDecorator {
    public WhipCreamDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Whip Cream";
    }
    
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.75;
    }
}

// Usage - decorators can be stacked!
Coffee coffee = new SimpleCoffee();
System.out.println(coffee.getDescription() + " $" + coffee.getCost());
// Simple Coffee $2.0

coffee = new MilkDecorator(coffee);
System.out.println(coffee.getDescription() + " $" + coffee.getCost());
// Simple Coffee, Milk $2.5

coffee = new SugarDecorator(coffee);
coffee = new WhipCreamDecorator(coffee);
System.out.println(coffee.getDescription() + " $" + coffee.getCost());
// Simple Coffee, Milk, Sugar, Whip Cream $3.5
```

**Real-world Java example:** `BufferedReader` decorates `FileReader`:
```java
Reader reader = new BufferedReader(new FileReader("file.txt"));
```

---

### Facade Pattern

**Purpose:** Provide a simplified interface to a complex subsystem.

**Use When:**
- You want a simple interface to a complex system
- There are many dependencies between clients and implementation
- You want to layer your subsystems

```java
// Complex subsystem classes
class CPU {
    public void freeze() { System.out.println("CPU: Freezing..."); }
    public void jump(long position) { System.out.println("CPU: Jumping to " + position); }
    public void execute() { System.out.println("CPU: Executing..."); }
}

class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Memory: Loading data at " + position);
    }
}

class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("HardDrive: Reading " + size + " bytes from " + lba);
        return new byte[size];
    }
}

class GPU {
    public void initialize() { System.out.println("GPU: Initializing..."); }
    public void render() { System.out.println("GPU: Rendering display..."); }
}

// Facade - provides simple interface
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
    private GPU gpu;
    
    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
        this.gpu = new GPU();
    }
    
    // Simple method hides complex startup sequence
    public void start() {
        System.out.println("=== Starting Computer ===");
        cpu.freeze();
        memory.load(0, hardDrive.read(0, 1024));
        cpu.jump(0);
        cpu.execute();
        gpu.initialize();
        gpu.render();
        System.out.println("=== Computer Started ===\n");
    }
    
    public void shutdown() {
        System.out.println("=== Shutting Down ===");
        // Hide complex shutdown sequence
        System.out.println("Saving state...");
        System.out.println("Closing applications...");
        System.out.println("Computer off.");
    }
}

// Usage - client doesn't need to know the complex internals
ComputerFacade computer = new ComputerFacade();
computer.start();    // Simple!
computer.shutdown();
```

---

## Behavioral Patterns

### Strategy Pattern

**Purpose:** Define a family of algorithms, encapsulate each one, and make them interchangeable.

**Use When:**
- You have multiple algorithms for a specific task
- You want to switch algorithms at runtime
- You want to avoid conditional statements for selecting behaviors

```java
// Strategy interface
interface PaymentStrategy {
    void pay(double amount);
    boolean validate();
}

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    
    public CreditCardPayment(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    
    @Override
    public boolean validate() {
        // Simplified validation
        return cardNumber.length() == 16 && cvv.length() == 3;
    }
    
    @Override
    public void pay(double amount) {
        if (validate()) {
            System.out.printf("Paid $%.2f using Credit Card ending in %s%n",
                amount, cardNumber.substring(12));
        } else {
            System.out.println("Invalid credit card details!");
        }
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;
    
    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean validate() {
        return email.contains("@") && password.length() >= 8;
    }
    
    @Override
    public void pay(double amount) {
        if (validate()) {
            System.out.printf("Paid $%.2f using PayPal account: %s%n", amount, email);
        } else {
            System.out.println("Invalid PayPal credentials!");
        }
    }
}

class CryptoPayment implements PaymentStrategy {
    private String walletAddress;
    
    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }
    
    @Override
    public boolean validate() {
        return walletAddress.startsWith("0x") && walletAddress.length() == 42;
    }
    
    @Override
    public void pay(double amount) {
        if (validate()) {
            System.out.printf("Paid $%.2f in crypto to wallet: %s...%n",
                amount, walletAddress.substring(0, 10));
        } else {
            System.out.println("Invalid wallet address!");
        }
    }
}

// Context
class ShoppingCart {
    private List<String> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;
    
    public void addItem(String item) {
        items.add(item);
    }
    
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
    
    public void checkout(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method!");
            return;
        }
        System.out.println("Checking out " + items.size() + " items...");
        paymentStrategy.pay(amount);
    }
}

// Usage - switch strategies at runtime
ShoppingCart cart = new ShoppingCart();
cart.addItem("Laptop");
cart.addItem("Mouse");

// Pay with credit card
cart.setPaymentStrategy(new CreditCardPayment("1234567890123456", "123", "12/25"));
cart.checkout(1099.99);

// Or pay with PayPal
cart.setPaymentStrategy(new PayPalPayment("user@email.com", "password123"));
cart.checkout(1099.99);

// Or pay with crypto
cart.setPaymentStrategy(new CryptoPayment("0x1234567890abcdef1234567890abcdef12345678"));
cart.checkout(1099.99);
```

#### Strategy with Lambda (Java 8+)

```java
// Functional interface
@FunctionalInterface
interface SortStrategy {
    void sort(int[] array);
}

class Sorter {
    private SortStrategy strategy;
    
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void sort(int[] array) {
        strategy.sort(array);
    }
}

// Usage with lambdas
Sorter sorter = new Sorter();

// Bubble sort strategy
sorter.setStrategy(arr -> {
    System.out.println("Using Bubble Sort");
    // bubble sort implementation
});

// Or use method reference
sorter.setStrategy(Arrays::sort);  // Built-in sort
```

---

### Observer Pattern

**Purpose:** Define a one-to-many dependency so that when one object changes state, all its dependents are notified.

**Use When:**
- Changes to one object require changing others
- An object should notify other objects without knowing who they are
- You need a publish-subscribe mechanism

```java
import java.util.*;

// Observer interface
interface Observer {
    void update(String event, Object data);
}

// Subject interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String event, Object data);
}

// Concrete Subject
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String latestNews;
    
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers(String event, Object data) {
        for (Observer observer : observers) {
            observer.update(event, data);
        }
    }
    
    public void publishNews(String news) {
        this.latestNews = news;
        System.out.println("\n📰 NEWS AGENCY: Publishing - " + news);
        notifyObservers("NEWS", news);
    }
    
    public void publishWeather(String weather) {
        System.out.println("\n🌤️ NEWS AGENCY: Weather Update - " + weather);
        notifyObservers("WEATHER", weather);
    }
}

// Concrete Observers
class NewsChannel implements Observer {
    private String name;
    
    public NewsChannel(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String event, Object data) {
        if ("NEWS".equals(event)) {
            System.out.println("  📺 " + name + " received news: " + data);
        }
    }
}

class WeatherApp implements Observer {
    @Override
    public void update(String event, Object data) {
        if ("WEATHER".equals(event)) {
            System.out.println("  📱 Weather App updated: " + data);
        }
    }
}

class NewsWebsite implements Observer {
    private String domain;
    
    public NewsWebsite(String domain) {
        this.domain = domain;
    }
    
    @Override
    public void update(String event, Object data) {
        System.out.println("  🌐 " + domain + " [" + event + "]: " + data);
    }
}

// Usage
NewsAgency agency = new NewsAgency();

// Subscribe observers
NewsChannel cnn = new NewsChannel("CNN");
NewsChannel bbc = new NewsChannel("BBC");
WeatherApp weatherApp = new WeatherApp();
NewsWebsite website = new NewsWebsite("news.com");

agency.addObserver(cnn);
agency.addObserver(bbc);
agency.addObserver(weatherApp);
agency.addObserver(website);

// Publish - all observers are notified
agency.publishNews("Java 25 Released!");
agency.publishWeather("Sunny, 75°F");

// Unsubscribe
agency.removeObserver(bbc);
agency.publishNews("Tech stocks rise 10%");
```

#### Observer with Java Built-in (PropertyChangeListener)

```java
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

class Stock {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String symbol;
    private double price;
    
    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    
    public void setPrice(double newPrice) {
        double oldPrice = this.price;
        this.price = newPrice;
        support.firePropertyChange("price", oldPrice, newPrice);
    }
    
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
}

// Usage
Stock apple = new Stock("AAPL", 150.00);

apple.addPropertyChangeListener(evt -> {
    System.out.printf("Stock %s price changed: $%.2f → $%.2f%n",
        apple.getSymbol(), evt.getOldValue(), evt.getNewValue());
});

apple.setPrice(155.50);  // Triggers notification
apple.setPrice(152.25);  // Triggers notification
```

---

### Template Method Pattern

**Purpose:** Define the skeleton of an algorithm, deferring some steps to subclasses.

**Use When:**
- You have an algorithm with invariant parts and customizable parts
- You want to avoid code duplication in subclasses
- You want to control which parts can be overridden

```java
// Abstract class with template method
abstract class DataMiner {
    
    // Template method - defines the algorithm skeleton
    public final void mine(String path) {
        openFile(path);
        extractData();
        parseData();
        analyzeData();
        generateReport();
        closeFile();
    }
    
    // Common implementation
    protected void openFile(String path) {
        System.out.println("Opening file: " + path);
    }
    
    protected void closeFile() {
        System.out.println("Closing file");
    }
    
    protected void generateReport() {
        System.out.println("Generating standard report");
    }
    
    // Abstract methods - must be implemented by subclasses
    protected abstract void extractData();
    protected abstract void parseData();
    
    // Hook method - can be overridden optionally
    protected void analyzeData() {
        System.out.println("Performing basic analysis");
    }
}

// Concrete implementations
class PDFDataMiner extends DataMiner {
    @Override
    protected void extractData() {
        System.out.println("Extracting data from PDF using PDF library");
    }
    
    @Override
    protected void parseData() {
        System.out.println("Parsing PDF text content");
    }
}

class CSVDataMiner extends DataMiner {
    @Override
    protected void extractData() {
        System.out.println("Reading CSV rows");
    }
    
    @Override
    protected void parseData() {
        System.out.println("Parsing CSV with comma delimiter");
    }
    
    @Override
    protected void analyzeData() {
        // Custom analysis for CSV
        System.out.println("Performing statistical analysis on CSV data");
    }
}

class JSONDataMiner extends DataMiner {
    @Override
    protected void extractData() {
        System.out.println("Extracting JSON from file");
    }
    
    @Override
    protected void parseData() {
        System.out.println("Parsing JSON structure");
    }
    
    @Override
    protected void generateReport() {
        // Custom report for JSON
        System.out.println("Generating JSON-formatted report");
    }
}

// Usage
System.out.println("=== Mining PDF ===");
DataMiner pdfMiner = new PDFDataMiner();
pdfMiner.mine("document.pdf");

System.out.println("\n=== Mining CSV ===");
DataMiner csvMiner = new CSVDataMiner();
csvMiner.mine("data.csv");

System.out.println("\n=== Mining JSON ===");
DataMiner jsonMiner = new JSONDataMiner();
jsonMiner.mine("config.json");
```

---

## When to Use Which Pattern

| Problem | Pattern | Solution |
|---------|---------|----------|
| Need exactly one instance | **Singleton** | Enum singleton |
| Create objects without specifying exact class | **Factory** | Factory method or Abstract Factory |
| Object has many optional parameters | **Builder** | Fluent builder |
| Incompatible interfaces | **Adapter** | Wrapper class |
| Add behavior dynamically | **Decorator** | Stackable wrappers |
| Complex subsystem | **Facade** | Simplified interface |
| Multiple algorithms, switchable | **Strategy** | Pluggable behavior |
| Notify multiple objects of changes | **Observer** | Publish-subscribe |
| Algorithm with fixed structure, variable steps | **Template Method** | Abstract class with hooks |

---

## Anti-Patterns to Avoid

### 1. Singleton Overuse

```java
// ❌ Bad - Using Singleton for everything
public class Utils {
    private static Utils instance;
    // This should just be static methods!
}

// ✅ Better - Use static utility class or dependency injection
public final class Utils {
    private Utils() {}  // Prevent instantiation
    public static void doSomething() { }
}
```

### 2. God Object

```java
// ❌ Bad - One class does everything
class Application {
    public void handleUser() { }
    public void processOrder() { }
    public void sendEmail() { }
    public void generateReport() { }
    public void connectDatabase() { }
    // 1000 more methods...
}

// ✅ Better - Single Responsibility Principle
class UserService { }
class OrderService { }
class EmailService { }
class ReportService { }
```

### 3. Premature Abstraction

```java
// ❌ Bad - Over-engineering for one implementation
interface IUserRepository { }
interface IUserService { }
interface IUserController { }
class UserRepositoryImpl implements IUserRepository { }
class UserServiceImpl implements IUserService { }
// ... when you only have ONE implementation!

// ✅ Better - Start simple, refactor when needed
class UserRepository { }
class UserService { }
```

---

## Best Practices

### 1. Favor Composition Over Inheritance

```java
// ❌ Inheritance - tight coupling
class Bird extends Animal {
    public void fly() { }
}

// ✅ Composition - flexible
class Bird {
    private FlyBehavior flyBehavior;  // Can be changed at runtime
    
    public void performFly() {
        flyBehavior.fly();
    }
}
```

### 2. Program to Interfaces

```java
// ❌ Programming to implementation
ArrayList<String> list = new ArrayList<>();

// ✅ Programming to interface
List<String> list = new ArrayList<>();
```

### 3. Apply SOLID Principles

- **S**ingle Responsibility - One class, one reason to change
- **O**pen/Closed - Open for extension, closed for modification
- **L**iskov Substitution - Subtypes must be substitutable
- **I**nterface Segregation - Many specific interfaces over one general
- **D**ependency Inversion - Depend on abstractions, not concretions

### 4. Keep It Simple

```java
// Don't use a pattern just to use it!
// Use the simplest solution that works.

// If you only need one implementation, don't create a factory.
// If you don't need to swap algorithms, don't use Strategy.
// Patterns are tools, not goals.
```

---

## Summary

### Patterns Covered

| Pattern | Category | Purpose |
|---------|----------|---------|
| **Singleton** | Creational | Single instance |
| **Factory** | Creational | Object creation |
| **Abstract Factory** | Creational | Family of objects |
| **Builder** | Creational | Complex construction |
| **Adapter** | Structural | Interface compatibility |
| **Decorator** | Structural | Dynamic behavior |
| **Facade** | Structural | Simplified interface |
| **Strategy** | Behavioral | Interchangeable algorithms |
| **Observer** | Behavioral | Event notification |
| **Template Method** | Behavioral | Algorithm skeleton |

### Quick Reference

```
Need ONE instance?           → Singleton (enum)
Complex object creation?     → Builder
Many similar objects?        → Factory
Dynamic behavior?            → Decorator or Strategy
Legacy code integration?     → Adapter
Complex subsystem?           → Facade
State change notifications?  → Observer
Fixed algorithm, variable steps? → Template Method
```

---

## 🎯 What's Next?

Now that you understand design patterns, you're ready for:
- **Class 4: Unit Testing with JUnit** - Test your patterns!

---

## 📚 Additional Resources

- [Design Patterns Book (Gang of Four)](https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
- [Refactoring Guru - Design Patterns](https://refactoring.guru/design-patterns)
- [Head First Design Patterns](https://www.oreilly.com/library/view/head-first-design/0596007124/)

---

**Practice makes perfect! Complete the exercises in `Exercises.md` to master design patterns!** 🏗️
