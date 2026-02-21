# 🏗️ Class 3: Design Patterns - Exercises

Practice implementing design patterns from simple to complex scenarios!

---

## 📝 Exercise Format

Each exercise includes:
- **Objective**: What pattern to implement
- **Requirements**: Specific implementation details
- **Hints**: Helpful tips
- **Expected Output**: Sample program behavior

---

## 🟢 Easy Exercises

### Exercise 1: Logger Singleton
**Objective:** Create a thread-safe Singleton logger.

**Requirements:**
1. Create a `Logger` class with:
   - Private constructor
   - Thread-safe `getInstance()` method
   - Log levels: INFO, WARNING, ERROR
   - Store logs in a list
   - Write logs to console with timestamp
2. Add methods:
   - `info(String message)`
   - `warning(String message)`
   - `error(String message)`
   - `getLogHistory()` - returns all logs

**Hints:**
- Use double-checked locking or enum singleton
- Include timestamp in each log entry
- Make it thread-safe for concurrent access

**Expected Output:**
```
[2026-02-21 10:30:15] INFO: Application started
[2026-02-21 10:30:15] WARNING: Low memory detected
[2026-02-21 10:30:15] ERROR: Connection failed

Same instance? true
Total logs: 3
```

---

### Exercise 2: Shape Factory
**Objective:** Implement a Simple Factory for creating shapes.

**Requirements:**
1. Create a `Shape` interface with:
   - `void draw()`
   - `double getArea()`
   - `String getType()`
2. Implement shapes: `Circle`, `Rectangle`, `Triangle`, `Square`
3. Create `ShapeFactory` with:
   - `createShape(String type)` - returns appropriate shape
   - Support parameters (e.g., radius for circle)
4. Each shape should:
   - Calculate its area correctly
   - Draw ASCII representation

**Hints:**
- Use switch expression for clean factory method
- Store dimensions in each shape class
- Consider using a `ShapeConfig` object for complex shapes

**Expected Output:**
```
=== Shape Factory Demo ===

Circle (radius=5):
  Drawing: ●
  Area: 78.54

Rectangle (4x6):
  Drawing: ▬
  Area: 24.00

Triangle (base=3, height=4):
  Drawing: ▲
  Area: 6.00

Square (side=5):
  Drawing: ■
  Area: 25.00
```

---

### Exercise 3: Coffee Builder
**Objective:** Create a fluent Builder for coffee orders.

**Requirements:**
1. Create `Coffee` class with properties:
   - size (small/medium/large) - required
   - type (espresso/latte/cappuccino) - required
   - milk (none/regular/oat/almond) - optional
   - sugar (int 0-5) - optional
   - whippedCream (boolean) - optional
   - extraShot (boolean) - optional
2. Implement Builder pattern with fluent API
3. Calculate price based on selections
4. Make `Coffee` immutable

**Hints:**
- Required parameters go in Builder constructor
- Use method chaining (return `this`)
- Calculate price in `build()` method

**Expected Output:**
```
=== Coffee Order ===

Order 1:
  Large Latte with Oat Milk
  Sugar: 2, Extra Shot: Yes, Whipped Cream: No
  Price: $5.75

Order 2:
  Medium Espresso
  No milk, No sugar
  Price: $3.00

Order 3:
  Small Cappuccino with Regular Milk
  Sugar: 1, Whipped Cream: Yes
  Price: $4.25
```

---

## 🟡 Medium Exercises

### Exercise 4: Payment Strategy
**Objective:** Implement Strategy pattern for payment processing.

**Requirements:**
1. Create `PaymentStrategy` interface:
   - `boolean validate()`
   - `void pay(double amount)`
   - `String getPaymentMethod()`
2. Implement strategies:
   - `CreditCardPayment` - validates card number, expiry
   - `PayPalPayment` - validates email
   - `CryptoPayment` - validates wallet address
   - `BankTransferPayment` - validates account number
3. Create `PaymentProcessor`:
   - Set strategy at runtime
   - Process payment with validation
   - Log transaction history

**Hints:**
- Each strategy should have its own validation logic
- Add mock "processing" delay for realism
- Store transaction records

**Expected Output:**
```
=== Payment Processing ===

Setting payment method: Credit Card
Validating card: **** **** **** 3456
✓ Validation passed
Processing $150.00...
✓ Payment successful!

Setting payment method: PayPal
Validating account: john@email.com
✓ Validation passed
Processing $75.50...
✓ Payment successful!

Setting payment method: Crypto
Validating wallet: 0x1234...5678
✓ Validation passed
Processing $200.00 (0.0067 BTC)...
✓ Payment successful!

Transaction History:
1. Credit Card - $150.00 - SUCCESS
2. PayPal - $75.50 - SUCCESS
3. Crypto - $200.00 - SUCCESS
```

---

### Exercise 5: Notification Observer
**Objective:** Build an event notification system using Observer pattern.

**Requirements:**
1. Create `EventManager` (subject):
   - Subscribe to event types (order, payment, shipping)
   - Unsubscribe from events
   - Notify listeners of specific events
2. Create different observers:
   - `EmailNotifier` - sends email notifications
   - `SMSNotifier` - sends SMS notifications
   - `PushNotifier` - sends push notifications
   - `LoggingNotifier` - logs all events
3. Implement `Event` class with type, data, timestamp
4. Allow observers to filter by event type

**Hints:**
- Use `Map<String, List<Observer>>` for event-based subscription
- Observers should be able to subscribe to multiple event types
- Include event metadata in notifications

**Expected Output:**
```
=== Event Notification System ===

--- Subscribing Observers ---
EmailNotifier subscribed to: [order, payment]
SMSNotifier subscribed to: [shipping]
PushNotifier subscribed to: [order, payment, shipping]
LoggingNotifier subscribed to: [all]

--- Publishing Events ---

Event: ORDER_PLACED
  📧 Email: New order #1234 placed!
  📱 Push: New order #1234 placed!
  📝 Log: [ORDER_PLACED] New order #1234 placed!

Event: PAYMENT_RECEIVED
  📧 Email: Payment $99.99 received!
  📱 Push: Payment $99.99 received!
  📝 Log: [PAYMENT_RECEIVED] Payment $99.99 received!

Event: SHIPPED
  📱 SMS: Your order has shipped! Tracking: ABC123
  📱 Push: Your order has shipped! Tracking: ABC123
  📝 Log: [SHIPPED] Your order has shipped! Tracking: ABC123

--- Unsubscribe Test ---
EmailNotifier unsubscribed from order events

Event: ORDER_PLACED
  📱 Push: New order #5678 placed!
  📝 Log: [ORDER_PLACED] New order #5678 placed!
```

---

### Exercise 6: Text Formatting Decorator
**Objective:** Create a text formatting system using Decorator pattern.

**Requirements:**
1. Create `Text` interface:
   - `String format()`
   - `String getRaw()`
2. Create `PlainText` concrete component
3. Create decorators:
   - `BoldDecorator` - wraps in **bold**
   - `ItalicDecorator` - wraps in *italic*
   - `UnderlineDecorator` - wraps in __underline__
   - `ColorDecorator` - adds color (ANSI codes or [color])
   - `UpperCaseDecorator` - transforms to UPPERCASE
   - `TrimDecorator` - removes extra spaces
4. Decorators should be stackable

**Hints:**
- Each decorator wraps another `Text`
- Decorators can be stacked in any order
- Consider ANSI codes for actual terminal colors

**Expected Output:**
```
=== Text Decorator Demo ===

Plain text: Hello, World!

Bold: **Hello, World!**

Bold + Italic: ***Hello, World!***

Colored (red): [RED]Hello, World![/RED]

All styles combined:
  __**[BLUE]*HELLO, WORLD!*[/BLUE]**__

Processing pipeline:
  Original: "  hello world  "
  Trimmed: "hello world"
  Upper: "HELLO WORLD"
  Bold: "**HELLO WORLD**"
```

---

## 🔴 Hard Exercises

### Exercise 7: Document Builder with Validation
**Objective:** Create a complex Builder with validation and multiple outputs.

**Requirements:**
1. Create `Document` class with:
   - title (required)
   - author (required)
   - date (auto-generated if not provided)
   - sections (list of content blocks)
   - metadata (key-value pairs)
   - format (PDF/HTML/Markdown)
2. Create `Section` class:
   - heading
   - content
   - subsections (recursive)
3. Builder features:
   - Validation (title required, sections not empty)
   - Method chaining
   - Export to different formats
4. Support nested sections

**Hints:**
- Use nested builders for sections
- Validate before `build()`
- Create format-specific export methods

**Expected Output:**
```
=== Document Builder ===

Building document...

Document: "Java Design Patterns Guide"
Author: John Doe
Date: 2026-02-21

Sections:
  1. Introduction
     1.1 What are Design Patterns?
     1.2 Why Use Them?
  2. Creational Patterns
     2.1 Singleton
     2.2 Factory
  3. Conclusion

Metadata:
  version: 1.0
  category: Programming
  tags: java, patterns, oop

=== Export as HTML ===
<html>
<head><title>Java Design Patterns Guide</title></head>
<body>
<h1>Java Design Patterns Guide</h1>
<p>Author: John Doe | Date: 2026-02-21</p>
<h2>1. Introduction</h2>
<h3>1.1 What are Design Patterns?</h3>
...
</body>
</html>

=== Export as Markdown ===
# Java Design Patterns Guide
*Author: John Doe | Date: 2026-02-21*

## 1. Introduction
### 1.1 What are Design Patterns?
...
```

---

### Exercise 8: Plugin System with Factory & Strategy
**Objective:** Combine Factory and Strategy patterns for a plugin system.

**Requirements:**
1. Create plugin architecture:
   - `Plugin` interface with `execute()`, `getName()`
   - `PluginFactory` to create plugins by name
   - `PluginManager` to load, enable, disable plugins
2. Implement plugins:
   - `LoggingPlugin` - logs all actions
   - `CachingPlugin` - caches results
   - `AuthPlugin` - validates access
   - `MetricsPlugin` - tracks performance
3. Create `PluginChain` (Chain of Responsibility):
   - Execute plugins in order
   - Allow plugins to modify request/response
4. Support plugin configuration

**Hints:**
- Plugins should have priority order
- Use Factory to create from config
- Chain should continue or stop based on plugin result

**Expected Output:**
```
=== Plugin System Demo ===

Loading plugins from config...
  ✓ AuthPlugin loaded (priority: 1)
  ✓ LoggingPlugin loaded (priority: 2)
  ✓ CachingPlugin loaded (priority: 3)
  ✓ MetricsPlugin loaded (priority: 4)

Processing request: GET /api/users

Plugin Chain Execution:
  [AuthPlugin] Validating token... ✓
  [LoggingPlugin] Request logged
  [CachingPlugin] Cache miss, fetching data...
  [MetricsPlugin] Started timer

Response: 200 OK

Post-processing:
  [MetricsPlugin] Request took 45ms
  [CachingPlugin] Response cached for 5 minutes
  [LoggingPlugin] Response logged

--- Disabling AuthPlugin ---

Processing request: GET /api/public

Plugin Chain Execution:
  [LoggingPlugin] Request logged
  [CachingPlugin] Cache hit!
  [MetricsPlugin] Started timer

Response: 200 OK (from cache)
```

---

### Exercise 9: Game Character Builder with Decorator
**Objective:** Create a flexible character creation system combining Builder and Decorator.

**Requirements:**
1. Base `Character` class:
   - name, class (warrior/mage/rogue), level
   - base stats: health, mana, strength, intelligence
2. `CharacterBuilder` for initial creation:
   - Set name, class, level
   - Auto-calculate base stats by class
3. Equipment as decorators:
   - `ArmorDecorator` - increases health/defense
   - `WeaponDecorator` - increases damage
   - `AccessoryDecorator` - various bonuses
4. Enchantments as additional decorators:
   - `FireEnchantment` - adds fire damage
   - `FrostEnchantment` - slows enemies
   - `LifestealEnchantment` - heals on hit
5. Calculate final stats with all decorators

**Hints:**
- Equipment decorators modify stats
- Enchantments can stack
- Display full stat breakdown

**Expected Output:**
```
=== Character Creation ===

Building character...
Name: Arthas
Class: Warrior
Level: 10

Base Stats:
  Health: 500
  Mana: 100
  Strength: 50
  Defense: 30

=== Equipping Items ===

+ Plate Armor (Heavy)
  Defense +50, Health +100

+ Longsword (Two-Handed)
  Damage +40, Strength +10

+ Ring of Vitality
  Health +50, Regen +5

=== Adding Enchantments ===

+ Fire Enchantment on Longsword
  Fire Damage +15

+ Lifesteal Enchantment on Longsword
  Lifesteal: 10%

=== Final Character Stats ===

Arthas - Level 10 Warrior

Stats:
  Health: 650 (+150)
  Mana: 100 (+0)
  Strength: 60 (+10)
  Defense: 80 (+50)
  Damage: 55 (+40 base, +15 fire)

Special Effects:
  - Fire Damage: 15
  - Lifesteal: 10%
  - Health Regen: 5/s

Equipment:
  - Plate Armor [Heavy]
  - Longsword [Two-Handed] (Fire, Lifesteal)
  - Ring of Vitality
```

---

## 🏆 Bonus Challenge: E-Commerce System

**Objective:** Build a mini e-commerce backend using multiple design patterns.

**Requirements:**

### Patterns to Use:
1. **Singleton** - Shopping cart, User session
2. **Factory** - Product creation
3. **Builder** - Order creation
4. **Strategy** - Payment, Shipping, Discount calculation
5. **Observer** - Order status updates
6. **Decorator** - Product options (gift wrap, insurance)
7. **Facade** - Simplified checkout process

### Implement:
```java
// Product Factory
ProductFactory.create("electronics", "Laptop", 999.99);
ProductFactory.create("clothing", "T-Shirt", 29.99);

// Cart (Singleton)
Cart.getInstance().add(laptop);
Cart.getInstance().add(tshirt);

// Product Decorators
Product giftWrappedLaptop = new GiftWrapDecorator(laptop);
Product insuredLaptop = new InsuranceDecorator(giftWrappedLaptop);

// Order Builder
Order order = new Order.Builder()
    .items(cart.getItems())
    .shippingAddress(address)
    .billingAddress(address)
    .shippingMethod(new ExpressShipping())
    .paymentMethod(new CreditCardPayment(card))
    .discountCode("SAVE10")
    .giftMessage("Happy Birthday!")
    .build();

// Checkout Facade
CheckoutFacade checkout = new CheckoutFacade();
checkout.processOrder(order);

// Order Status Observer
order.addObserver(new EmailNotification(user.email));
order.addObserver(new SMSNotification(user.phone));
order.addObserver(new InventoryUpdater());

order.setStatus(OrderStatus.PROCESSING);
order.setStatus(OrderStatus.SHIPPED);
order.setStatus(OrderStatus.DELIVERED);
```

**Expected Output:**
```
╔════════════════════════════════════════════════════════════╗
║                  E-COMMERCE SYSTEM                         ║
╚════════════════════════════════════════════════════════════╝

=== Adding Products to Cart ===
✓ Added: Laptop - $999.99
✓ Added: T-Shirt - $29.99
✓ Added: Gift Wrap for Laptop - +$5.99
✓ Added: Insurance for Laptop - +$49.99

Cart Total: $1085.96

=== Creating Order ===
Order #ORD-2026-0001
Items: 3
Subtotal: $1085.96
Discount (SAVE10): -$108.60
Shipping (Express): +$15.99
Tax: +$88.12
─────────────────
Total: $1081.47

=== Processing Order ===
[PaymentStrategy] Processing credit card payment...
✓ Payment authorized
[InventoryStrategy] Updating stock...
✓ Inventory updated
[ShippingStrategy] Creating shipping label...
✓ Label created: TRACK-12345

=== Order Status Updates ===
Order status: CONFIRMED
  📧 Email sent to john@email.com
  📱 SMS sent to +1-555-0123

Order status: PROCESSING
  📧 Email sent: "Your order is being prepared"

Order status: SHIPPED
  📧 Email sent: "Your order is on the way!"
  📱 SMS sent: "Shipped! Track: TRACK-12345"

Order status: DELIVERED
  📧 Email sent: "Your order has been delivered!"
  🔔 Feedback request triggered

=== Order Summary ===
Order: ORD-2026-0001
Status: DELIVERED
Delivered: 2026-02-24
Items:
  - Laptop ($999.99) [Gift Wrapped, Insured]
  - T-Shirt ($29.99)
Payment: Credit Card ending in 3456
Shipping: Express Delivery
Total: $1081.47
```

---

## 📊 Exercise Checklist

| Exercise | Difficulty | Patterns | Completed |
|----------|------------|----------|-----------|
| 1. Logger Singleton | 🟢 Easy | Singleton | ⬜ |
| 2. Shape Factory | 🟢 Easy | Factory | ⬜ |
| 3. Coffee Builder | 🟢 Easy | Builder | ⬜ |
| 4. Payment Strategy | 🟡 Medium | Strategy | ⬜ |
| 5. Notification Observer | 🟡 Medium | Observer | ⬜ |
| 6. Text Decorator | 🟡 Medium | Decorator | ⬜ |
| 7. Document Builder | 🔴 Hard | Builder + Validation | ⬜ |
| 8. Plugin System | 🔴 Hard | Factory + Strategy + Chain | ⬜ |
| 9. Game Character | 🔴 Hard | Builder + Decorator | ⬜ |
| 🏆 E-Commerce | Bonus | All Patterns | ⬜ |

---

## 💡 Tips for Success

1. **Understand the Problem First** - Don't apply patterns blindly
2. **Start Simple** - Implement basic version, then refine
3. **One Pattern at a Time** - Master each before combining
4. **Test Each Layer** - Verify behavior at each step
5. **Refactor Continuously** - Patterns emerge from refactoring

---

## 🔧 Common Mistakes to Avoid

### Over-Engineering
```java
// ❌ Factory for single implementation
interface IUserFactory { User create(); }
class UserFactoryImpl implements IUserFactory { ... }

// ✅ Just create directly if no variation
User user = new User(name, email);
```

### Singleton Abuse
```java
// ❌ Everything as Singleton
class UserService { static getInstance() }
class ProductService { static getInstance() }
class OrderService { static getInstance() }

// ✅ Use dependency injection
class OrderService {
    private UserService userService;
    private ProductService productService;
    
    public OrderService(UserService us, ProductService ps) { ... }
}
```

### Wrong Pattern Choice
```java
// ❌ Using Builder for simple object
User user = new User.Builder().name("John").build();

// ✅ Use constructor for simple objects
User user = new User("John", "john@email.com");

// ✅ Use Builder for complex objects with many options
Pizza pizza = new Pizza.Builder("Large")
    .cheese(true)
    .pepperoni(true)
    .mushrooms(true)
    .build();
```

---

**Master design patterns to write professional, maintainable code!** 🏗️
