/**
 * ============================================
 * DESIGN PATTERNS DEMONSTRATION
 * ============================================
 * 
 * This file demonstrates essential design patterns:
 * 
 * CREATIONAL:
 * 1. Singleton - Single instance
 * 2. Factory Method - Object creation
 * 3. Builder - Complex construction
 * 
 * STRUCTURAL:
 * 4. Adapter - Interface compatibility
 * 5. Decorator - Dynamic behavior
 * 6. Facade - Simplified interface
 * 
 * BEHAVIORAL:
 * 7. Strategy - Interchangeable algorithms
 * 8. Observer - Event notification
 * 9. Template Method - Algorithm skeleton
 * 
 * @author Learn Java With Me
 */

import java.util.*;

public class DesignPatternsDemo {
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║           DESIGN PATTERNS DEMONSTRATION                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
        
        // Creational Patterns
        demo1_Singleton();
        demo2_FactoryMethod();
        demo3_Builder();
        
        // Structural Patterns
        demo4_Adapter();
        demo5_Decorator();
        demo6_Facade();
        
        // Behavioral Patterns
        demo7_Strategy();
        demo8_Observer();
        demo9_TemplateMethod();
        
        System.out.println("\n✅ All design pattern demonstrations completed!");
    }
    
    // ═══════════════════════════════════════════════════════════
    // CREATIONAL PATTERNS
    // ═══════════════════════════════════════════════════════════
    
    /**
     * DEMO 1: Singleton Pattern
     * Ensures only one instance exists
     */
    public static void demo1_Singleton() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 1: Singleton Pattern");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Get instance multiple times
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("Same instance? Yes!\n");
        
        // Use the singleton
        logger1.log("INFO", "Application started");
        logger2.log("WARNING", "Low memory");
        logger1.log("ERROR", "Connection failed");
        
        System.out.println("\nLog count: " + logger1.getLogCount());
        
        // Enum singleton
        System.out.println("\n--- Enum Singleton (Best Practice) ---");
        AppConfig.INSTANCE.set("theme", "dark");
        AppConfig.INSTANCE.set("language", "en");
        System.out.println("Theme: " + AppConfig.INSTANCE.get("theme"));
        System.out.println("Language: " + AppConfig.INSTANCE.get("language"));
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 2: Factory Method Pattern
     * Creates objects without specifying exact class
     */
    public static void demo2_FactoryMethod() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 2: Factory Method Pattern");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Simple Factory
        System.out.println("--- Simple Factory ---");
        Shape circle = ShapeFactory.createShape("circle");
        Shape rectangle = ShapeFactory.createShape("rectangle");
        Shape triangle = ShapeFactory.createShape("triangle");
        
        circle.draw();
        rectangle.draw();
        triangle.draw();
        
        // Factory Method with polymorphism
        System.out.println("\n--- Factory Method (Polymorphic) ---");
        NotificationFactory emailFactory = new EmailNotificationFactory();
        NotificationFactory smsFactory = new SMSNotificationFactory();
        
        Notification email = emailFactory.createNotification();
        Notification sms = smsFactory.createNotification();
        
        email.send("Hello via Email!");
        sms.send("Hello via SMS!");
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 3: Builder Pattern
     * Constructs complex objects step by step
     */
    public static void demo3_Builder() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 3: Builder Pattern");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Build a computer
        Computer gamingPC = new Computer.Builder("Intel i9", "32GB")
            .storage("2TB SSD")
            .gpu("RTX 4090")
            .coolingSystem("Liquid Cooling")
            .rgbLighting(true)
            .build();
        
        System.out.println("Gaming PC:");
        System.out.println(gamingPC);
        
        // Build a simpler computer
        Computer officePC = new Computer.Builder("Intel i5", "16GB")
            .storage("512GB SSD")
            .build();
        
        System.out.println("\nOffice PC:");
        System.out.println(officePC);
        
        // Build with method chaining
        HttpRequest request = new HttpRequest.Builder()
            .url("https://api.example.com/users")
            .method("POST")
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer token123")
            .body("{\"name\": \"John\"}")
            .timeout(30)
            .build();
        
        System.out.println("\nHTTP Request:");
        System.out.println(request);
        
        System.out.println("\n");
    }
    
    // ═══════════════════════════════════════════════════════════
    // STRUCTURAL PATTERNS
    // ═══════════════════════════════════════════════════════════
    
    /**
     * DEMO 4: Adapter Pattern
     * Makes incompatible interfaces compatible
     */
    public static void demo4_Adapter() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 4: Adapter Pattern");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Our system expects MediaPlayer interface
        MediaPlayer mp3Player = new MP3Player();
        mp3Player.play("song.mp3");
        
        // We have a legacy VLC player with different interface
        LegacyVLCPlayer legacyPlayer = new LegacyVLCPlayer();
        // legacyPlayer.playMedia("movie.vlc");  // Can't use directly!
        
        // Adapter makes it compatible
        MediaPlayer vlcAdapter = new VLCPlayerAdapter(legacyPlayer);
        vlcAdapter.play("movie.vlc");  // Now it works!
        
        // Another adapter for Spotify
        SpotifyService spotify = new SpotifyService();
        MediaPlayer spotifyAdapter = new SpotifyAdapter(spotify);
        spotifyAdapter.play("Spotify:track:12345");
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 5: Decorator Pattern
     * Adds behavior dynamically
     */
    public static void demo5_Decorator() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 5: Decorator Pattern");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Start with plain text
        TextComponent plainText = new PlainText("Hello, World!");
        System.out.println("Plain: " + plainText.render());
        
        // Add decorators
        TextComponent bold = new BoldDecorator(plainText);
        System.out.println("Bold: " + bold.render());
        
        TextComponent boldItalic = new ItalicDecorator(bold);
        System.out.println("Bold+Italic: " + boldItalic.render());
        
        TextComponent fullyStyled = new UnderlineDecorator(
            new ItalicDecorator(
                new BoldDecorator(
                    new PlainText("Fancy Text")
                )
            )
        );
        System.out.println("Fully Styled: " + fullyStyled.render());
        
        // Pizza example
        System.out.println("\n--- Pizza Decorator ---");
        Pizza basicPizza = new BasicPizza();
        System.out.println(basicPizza.getDescription() + " - $" + basicPizza.getCost());
        
        Pizza loaded = new ExtraCheeseDecorator(
            new PepperoniDecorator(
                new MushroomDecorator(basicPizza)
            )
        );
        System.out.println(loaded.getDescription() + " - $" + loaded.getCost());
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 6: Facade Pattern
     * Provides simplified interface to complex subsystem
     */
    public static void demo6_Facade() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 6: Facade Pattern");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Without facade - complex!
        System.out.println("--- Without Facade (Complex) ---");
        VideoDecoder decoder = new VideoDecoder();
        AudioDecoder audioDecoder = new AudioDecoder();
        VideoRenderer renderer = new VideoRenderer();
        AudioPlayer audioPlayer = new AudioPlayer();
        
        System.out.println("Client must coordinate all subsystems manually...\n");
        
        // With facade - simple!
        System.out.println("--- With Facade (Simple) ---");
        MediaPlayerFacade mediaPlayer = new MediaPlayerFacade();
        mediaPlayer.playVideo("movie.mp4");
        
        System.out.println();
        mediaPlayer.playAudio("song.mp3");
        
        System.out.println("\n--- Home Theater Facade ---");
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();
        
        System.out.println("\n");
    }
    
    // ═══════════════════════════════════════════════════════════
    // BEHAVIORAL PATTERNS
    // ═══════════════════════════════════════════════════════════
    
    /**
     * DEMO 7: Strategy Pattern
     * Interchangeable algorithms
     */
    public static void demo7_Strategy() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 7: Strategy Pattern");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);
        
        System.out.println("Shopping Cart:");
        System.out.println("  Total: $" + cart.getTotal());
        
        // Pay with different strategies
        System.out.println("\n--- Credit Card Payment ---");
        cart.setPaymentStrategy(new CreditCardStrategy("1234-5678-9012-3456", "John Doe"));
        cart.checkout();
        
        System.out.println("\n--- PayPal Payment ---");
        cart.setPaymentStrategy(new PayPalStrategy("john@email.com"));
        cart.checkout();
        
        System.out.println("\n--- Bitcoin Payment ---");
        cart.setPaymentStrategy(new BitcoinStrategy("1BvBMSEYstWetqTFn5Au4m4GFg7xJaNVN2"));
        cart.checkout();
        
        // Compression strategy example
        System.out.println("\n--- Compression Strategy ---");
        FileCompressor compressor = new FileCompressor();
        
        compressor.setStrategy(new ZipCompressionStrategy());
        compressor.compress("documents/");
        
        compressor.setStrategy(new RarCompressionStrategy());
        compressor.compress("images/");
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 8: Observer Pattern
     * Event notification system
     */
    public static void demo8_Observer() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 8: Observer Pattern");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Create subject (publisher)
        StockMarket stockMarket = new StockMarket();
        
        // Create observers (subscribers)
        StockObserver investor1 = new InvestorObserver("Alice");
        StockObserver investor2 = new InvestorObserver("Bob");
        StockObserver newsAgency = new NewsAgencyObserver("Bloomberg");
        
        // Subscribe
        stockMarket.addObserver(investor1);
        stockMarket.addObserver(investor2);
        stockMarket.addObserver(newsAgency);
        
        System.out.println("--- Stock Updates ---");
        stockMarket.updateStock("AAPL", 150.00);
        System.out.println();
        stockMarket.updateStock("GOOGL", 2800.00);
        
        // Unsubscribe Bob
        System.out.println("\n--- Bob unsubscribes ---");
        stockMarket.removeObserver(investor2);
        stockMarket.updateStock("AAPL", 152.50);
        
        // Event-based observer
        System.out.println("\n--- Event-Based Observer ---");
        EventManager eventManager = new EventManager("click", "hover", "submit");
        
        eventManager.subscribe("click", event -> 
            System.out.println("  Button clicked: " + event));
        eventManager.subscribe("submit", event -> 
            System.out.println("  Form submitted: " + event));
        
        eventManager.notify("click", "Login Button");
        eventManager.notify("submit", "Contact Form");
        eventManager.notify("hover", "Menu Item");  // No listener
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 9: Template Method Pattern
     * Algorithm skeleton with customizable steps
     */
    public static void demo9_TemplateMethod() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 9: Template Method Pattern");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Different report generators with same structure
        System.out.println("--- PDF Report ---");
        ReportGenerator pdfReport = new PDFReportGenerator();
        pdfReport.generateReport("Sales Q4");
        
        System.out.println("\n--- Excel Report ---");
        ReportGenerator excelReport = new ExcelReportGenerator();
        excelReport.generateReport("Inventory");
        
        System.out.println("\n--- HTML Report ---");
        ReportGenerator htmlReport = new HTMLReportGenerator();
        htmlReport.generateReport("User Analytics");
        
        // Game AI example
        System.out.println("\n--- Game AI Template ---");
        GameAI orc = new OrcAI();
        GameAI monster = new MonsterAI();
        
        System.out.println("Orc turn:");
        orc.takeTurn();
        
        System.out.println("\nMonster turn:");
        monster.takeTurn();
    }
}

// ════════════════════════════════════════════════════════════════════════════
// SINGLETON PATTERN IMPLEMENTATIONS
// ════════════════════════════════════════════════════════════════════════════

class Logger {
    private static volatile Logger instance;
    private List<String> logs = new ArrayList<>();
    
    private Logger() {
        System.out.println("Logger instance created");
    }
    
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    
    public void log(String level, String message) {
        String entry = String.format("[%s] %s: %s", 
            java.time.LocalTime.now().toString().substring(0, 8), level, message);
        logs.add(entry);
        System.out.println(entry);
    }
    
    public int getLogCount() {
        return logs.size();
    }
}

enum AppConfig {
    INSTANCE;
    
    private Map<String, String> settings = new HashMap<>();
    
    public void set(String key, String value) {
        settings.put(key, value);
    }
    
    public String get(String key) {
        return settings.getOrDefault(key, "");
    }
}

// ════════════════════════════════════════════════════════════════════════════
// FACTORY PATTERN IMPLEMENTATIONS
// ════════════════════════════════════════════════════════════════════════════

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() { System.out.println("Drawing Circle ●"); }
}

class Rectangle implements Shape {
    @Override
    public void draw() { System.out.println("Drawing Rectangle ▬"); }
}

class Triangle implements Shape {
    @Override
    public void draw() { System.out.println("Drawing Triangle ▲"); }
}

class ShapeFactory {
    public static Shape createShape(String type) {
        return switch (type.toLowerCase()) {
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            case "triangle" -> new Triangle();
            default -> throw new IllegalArgumentException("Unknown shape: " + type);
        };
    }
}

interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("📧 Email: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("📱 SMS: " + message);
    }
}

abstract class NotificationFactory {
    abstract Notification createNotification();
}

class EmailNotificationFactory extends NotificationFactory {
    @Override
    Notification createNotification() { return new EmailNotification(); }
}

class SMSNotificationFactory extends NotificationFactory {
    @Override
    Notification createNotification() { return new SMSNotification(); }
}

// ════════════════════════════════════════════════════════════════════════════
// BUILDER PATTERN IMPLEMENTATIONS
// ════════════════════════════════════════════════════════════════════════════

class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String gpu;
    private final String coolingSystem;
    private final boolean rgbLighting;
    
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.coolingSystem = builder.coolingSystem;
        this.rgbLighting = builder.rgbLighting;
    }
    
    @Override
    public String toString() {
        return String.format("  CPU: %s\n  RAM: %s\n  Storage: %s\n  GPU: %s\n  Cooling: %s\n  RGB: %s",
            cpu, ram, storage, gpu, coolingSystem, rgbLighting);
    }
    
    public static class Builder {
        private final String cpu;
        private final String ram;
        private String storage = "256GB SSD";
        private String gpu = "Integrated";
        private String coolingSystem = "Air Cooling";
        private boolean rgbLighting = false;
        
        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }
        
        public Builder storage(String val) { storage = val; return this; }
        public Builder gpu(String val) { gpu = val; return this; }
        public Builder coolingSystem(String val) { coolingSystem = val; return this; }
        public Builder rgbLighting(boolean val) { rgbLighting = val; return this; }
        
        public Computer build() { return new Computer(this); }
    }
}

class HttpRequest {
    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final String body;
    private final int timeout;
    
    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.body = builder.body;
        this.timeout = builder.timeout;
    }
    
    @Override
    public String toString() {
        return String.format("  %s %s\n  Headers: %s\n  Body: %s\n  Timeout: %ds",
            method, url, headers, body, timeout);
    }
    
    public static class Builder {
        private String url;
        private String method = "GET";
        private Map<String, String> headers = new HashMap<>();
        private String body = "";
        private int timeout = 30;
        
        public Builder url(String val) { url = val; return this; }
        public Builder method(String val) { method = val; return this; }
        public Builder header(String key, String value) { headers.put(key, value); return this; }
        public Builder body(String val) { body = val; return this; }
        public Builder timeout(int val) { timeout = val; return this; }
        
        public HttpRequest build() { return new HttpRequest(this); }
    }
}

// ════════════════════════════════════════════════════════════════════════════
// ADAPTER PATTERN IMPLEMENTATIONS
// ════════════════════════════════════════════════════════════════════════════

interface MediaPlayer {
    void play(String filename);
}

class MP3Player implements MediaPlayer {
    @Override
    public void play(String filename) {
        System.out.println("🎵 MP3 Player: Playing " + filename);
    }
}

class LegacyVLCPlayer {
    public void playMedia(String filename, String codec) {
        System.out.println("🎬 VLC: Playing " + filename + " with " + codec + " codec");
    }
}

class VLCPlayerAdapter implements MediaPlayer {
    private LegacyVLCPlayer vlcPlayer;
    
    public VLCPlayerAdapter(LegacyVLCPlayer vlcPlayer) {
        this.vlcPlayer = vlcPlayer;
    }
    
    @Override
    public void play(String filename) {
        vlcPlayer.playMedia(filename, "auto");
    }
}

class SpotifyService {
    public void streamTrack(String trackId) {
        System.out.println("🎧 Spotify: Streaming track " + trackId);
    }
}

class SpotifyAdapter implements MediaPlayer {
    private SpotifyService spotify;
    
    public SpotifyAdapter(SpotifyService spotify) {
        this.spotify = spotify;
    }
    
    @Override
    public void play(String filename) {
        String trackId = filename.replace("Spotify:track:", "");
        spotify.streamTrack(trackId);
    }
}

// ════════════════════════════════════════════════════════════════════════════
// DECORATOR PATTERN IMPLEMENTATIONS
// ════════════════════════════════════════════════════════════════════════════

interface TextComponent {
    String render();
}

class PlainText implements TextComponent {
    private String text;
    
    public PlainText(String text) { this.text = text; }
    
    @Override
    public String render() { return text; }
}

abstract class TextDecorator implements TextComponent {
    protected TextComponent wrapped;
    
    public TextDecorator(TextComponent component) { this.wrapped = component; }
}

class BoldDecorator extends TextDecorator {
    public BoldDecorator(TextComponent component) { super(component); }
    
    @Override
    public String render() { return "<b>" + wrapped.render() + "</b>"; }
}

class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(TextComponent component) { super(component); }
    
    @Override
    public String render() { return "<i>" + wrapped.render() + "</i>"; }
}

class UnderlineDecorator extends TextDecorator {
    public UnderlineDecorator(TextComponent component) { super(component); }
    
    @Override
    public String render() { return "<u>" + wrapped.render() + "</u>"; }
}

interface Pizza {
    String getDescription();
    double getCost();
}

class BasicPizza implements Pizza {
    @Override
    public String getDescription() { return "Basic Pizza"; }
    
    @Override
    public double getCost() { return 8.00; }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;
    
    public PizzaDecorator(Pizza pizza) { this.pizza = pizza; }
}

class ExtraCheeseDecorator extends PizzaDecorator {
    public ExtraCheeseDecorator(Pizza pizza) { super(pizza); }
    
    @Override
    public String getDescription() { return pizza.getDescription() + ", Extra Cheese"; }
    
    @Override
    public double getCost() { return pizza.getCost() + 1.50; }
}

class PepperoniDecorator extends PizzaDecorator {
    public PepperoniDecorator(Pizza pizza) { super(pizza); }
    
    @Override
    public String getDescription() { return pizza.getDescription() + ", Pepperoni"; }
    
    @Override
    public double getCost() { return pizza.getCost() + 2.00; }
}

class MushroomDecorator extends PizzaDecorator {
    public MushroomDecorator(Pizza pizza) { super(pizza); }
    
    @Override
    public String getDescription() { return pizza.getDescription() + ", Mushrooms"; }
    
    @Override
    public double getCost() { return pizza.getCost() + 1.00; }
}

// ════════════════════════════════════════════════════════════════════════════
// FACADE PATTERN IMPLEMENTATIONS
// ════════════════════════════════════════════════════════════════════════════

class VideoDecoder {
    public void decode(String file) { System.out.println("    Decoding video: " + file); }
}

class AudioDecoder {
    public void decode(String file) { System.out.println("    Decoding audio: " + file); }
}

class VideoRenderer {
    public void render() { System.out.println("    Rendering video frames"); }
}

class AudioPlayer {
    public void play() { System.out.println("    Playing audio"); }
}

class MediaPlayerFacade {
    private VideoDecoder videoDecoder = new VideoDecoder();
    private AudioDecoder audioDecoder = new AudioDecoder();
    private VideoRenderer videoRenderer = new VideoRenderer();
    private AudioPlayer audioPlayer = new AudioPlayer();
    
    public void playVideo(String file) {
        System.out.println("  MediaPlayerFacade: Playing video...");
        videoDecoder.decode(file);
        audioDecoder.decode(file);
        videoRenderer.render();
        audioPlayer.play();
        System.out.println("  ▶️ Video playing!");
    }
    
    public void playAudio(String file) {
        System.out.println("  MediaPlayerFacade: Playing audio...");
        audioDecoder.decode(file);
        audioPlayer.play();
        System.out.println("  🎵 Audio playing!");
    }
}

class HomeTheaterFacade {
    public void watchMovie(String movie) {
        System.out.println("  🎬 Home Theater: Preparing to watch " + movie);
        System.out.println("    Dimming lights...");
        System.out.println("    Lowering screen...");
        System.out.println("    Turning on projector...");
        System.out.println("    Setting surround sound...");
        System.out.println("  ▶️ Movie starting!");
    }
    
    public void endMovie() {
        System.out.println("  🎬 Home Theater: Shutting down");
        System.out.println("    Stopping playback...");
        System.out.println("    Raising screen...");
        System.out.println("    Turning off projector...");
        System.out.println("    Restoring lights...");
    }
}

// ════════════════════════════════════════════════════════════════════════════
// STRATEGY PATTERN IMPLEMENTATIONS
// ════════════════════════════════════════════════════════════════════════════

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String name;
    
    public CreditCardStrategy(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }
    
    @Override
    public void pay(double amount) {
        System.out.printf("  💳 Paid $%.2f using Credit Card (%s)%n", 
            amount, cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalStrategy implements PaymentStrategy {
    private String email;
    
    public PayPalStrategy(String email) { this.email = email; }
    
    @Override
    public void pay(double amount) {
        System.out.printf("  🅿️ Paid $%.2f using PayPal (%s)%n", amount, email);
    }
}

class BitcoinStrategy implements PaymentStrategy {
    private String walletAddress;
    
    public BitcoinStrategy(String walletAddress) { this.walletAddress = walletAddress; }
    
    @Override
    public void pay(double amount) {
        System.out.printf("  ₿ Paid $%.2f in Bitcoin to %s...%n", 
            amount, walletAddress.substring(0, 10));
    }
}

class ShoppingCart {
    private List<Map.Entry<String, Double>> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;
    
    public void addItem(String name, double price) {
        items.add(Map.entry(name, price));
    }
    
    public double getTotal() {
        return items.stream().mapToDouble(Map.Entry::getValue).sum();
    }
    
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
    
    public void checkout() {
        paymentStrategy.pay(getTotal());
    }
}

interface CompressionStrategy {
    void compress(String folder);
}

class ZipCompressionStrategy implements CompressionStrategy {
    @Override
    public void compress(String folder) {
        System.out.println("  📦 Compressing " + folder + " to ZIP format");
    }
}

class RarCompressionStrategy implements CompressionStrategy {
    @Override
    public void compress(String folder) {
        System.out.println("  📦 Compressing " + folder + " to RAR format");
    }
}

class FileCompressor {
    private CompressionStrategy strategy;
    
    public void setStrategy(CompressionStrategy strategy) { this.strategy = strategy; }
    
    public void compress(String folder) { strategy.compress(folder); }
}

// ════════════════════════════════════════════════════════════════════════════
// OBSERVER PATTERN IMPLEMENTATIONS
// ════════════════════════════════════════════════════════════════════════════

interface StockObserver {
    void update(String stock, double price);
}

class StockMarket {
    private List<StockObserver> observers = new ArrayList<>();
    
    public void addObserver(StockObserver observer) { observers.add(observer); }
    public void removeObserver(StockObserver observer) { observers.remove(observer); }
    
    public void updateStock(String stock, double price) {
        System.out.println("📈 " + stock + " is now $" + price);
        for (StockObserver observer : observers) {
            observer.update(stock, price);
        }
    }
}

class InvestorObserver implements StockObserver {
    private String name;
    
    public InvestorObserver(String name) { this.name = name; }
    
    @Override
    public void update(String stock, double price) {
        System.out.printf("  👤 %s notified: %s at $%.2f%n", name, stock, price);
    }
}

class NewsAgencyObserver implements StockObserver {
    private String name;
    
    public NewsAgencyObserver(String name) { this.name = name; }
    
    @Override
    public void update(String stock, double price) {
        System.out.printf("  📰 %s: Breaking - %s reaches $%.2f%n", name, stock, price);
    }
}

class EventManager {
    private Map<String, List<java.util.function.Consumer<String>>> listeners = new HashMap<>();
    
    public EventManager(String... events) {
        for (String event : events) {
            listeners.put(event, new ArrayList<>());
        }
    }
    
    public void subscribe(String event, java.util.function.Consumer<String> listener) {
        listeners.get(event).add(listener);
    }
    
    public void notify(String event, String data) {
        List<java.util.function.Consumer<String>> eventListeners = listeners.get(event);
        if (eventListeners != null) {
            for (var listener : eventListeners) {
                listener.accept(data);
            }
        }
    }
}

// ════════════════════════════════════════════════════════════════════════════
// TEMPLATE METHOD PATTERN IMPLEMENTATIONS
// ════════════════════════════════════════════════════════════════════════════

abstract class ReportGenerator {
    // Template method - defines the algorithm
    public final void generateReport(String reportName) {
        System.out.println("  Generating " + reportName + " report...");
        gatherData();
        processData();
        formatReport();
        exportReport();
        System.out.println("  ✓ Report complete!");
    }
    
    // Common steps
    protected void gatherData() { System.out.println("    Gathering data from database..."); }
    protected void processData() { System.out.println("    Processing data..."); }
    
    // Abstract steps - must be implemented
    protected abstract void formatReport();
    protected abstract void exportReport();
}

class PDFReportGenerator extends ReportGenerator {
    @Override
    protected void formatReport() { System.out.println("    Formatting as PDF..."); }
    
    @Override
    protected void exportReport() { System.out.println("    Exporting to report.pdf"); }
}

class ExcelReportGenerator extends ReportGenerator {
    @Override
    protected void formatReport() { System.out.println("    Formatting as Excel spreadsheet..."); }
    
    @Override
    protected void exportReport() { System.out.println("    Exporting to report.xlsx"); }
}

class HTMLReportGenerator extends ReportGenerator {
    @Override
    protected void formatReport() { System.out.println("    Formatting as HTML..."); }
    
    @Override
    protected void exportReport() { System.out.println("    Exporting to report.html"); }
    
    @Override
    protected void processData() {
        System.out.println("    Processing data with charts...");
    }
}

abstract class GameAI {
    // Template method
    public final void takeTurn() {
        collectResources();
        buildStructures();
        buildUnits();
        attack();
    }
    
    protected void collectResources() { System.out.println("    Collecting resources..."); }
    
    protected abstract void buildStructures();
    protected abstract void buildUnits();
    protected abstract void attack();
}

class OrcAI extends GameAI {
    @Override
    protected void buildStructures() { System.out.println("    Building barracks and forge"); }
    
    @Override
    protected void buildUnits() { System.out.println("    Training warriors and wolves"); }
    
    @Override
    protected void attack() { System.out.println("    Attacking with brute force!"); }
}

class MonsterAI extends GameAI {
    @Override
    protected void collectResources() { } // Monsters don't collect
    
    @Override
    protected void buildStructures() { } // Monsters don't build
    
    @Override
    protected void buildUnits() { System.out.println("    Spawning minions"); }
    
    @Override
    protected void attack() { System.out.println("    Ambushing nearby enemies!"); }
}
