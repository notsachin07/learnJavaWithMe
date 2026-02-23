# 🧪 Class 4: Unit Testing with JUnit

Welcome to Class 4 of Phase 5! In this class, you'll learn how to write professional unit tests using JUnit 5 to ensure your code works correctly and remains reliable over time.

---

## 📚 Table of Contents

1. [Introduction to Testing](#1-introduction-to-testing)
2. [Why Write Tests?](#2-why-write-tests)
3. [JUnit 5 Overview](#3-junit-5-overview)
4. [Setting Up JUnit](#4-setting-up-junit)
5. [Your First Test](#5-your-first-test)
6. [Assertions Deep Dive](#6-assertions-deep-dive)
7. [Test Lifecycle](#7-test-lifecycle)
8. [Parameterized Tests](#8-parameterized-tests)
9. [Testing Exceptions](#9-testing-exceptions)
10. [Mocking Basics](#10-mocking-basics)
11. [Test-Driven Development](#11-test-driven-development)
12. [Best Practices](#12-best-practices)
13. [Summary](#13-summary)

---

## 1. Introduction to Testing

### What is Unit Testing?

Unit testing is the practice of testing individual "units" of code (methods, classes) in isolation to verify they work correctly.

```
┌─────────────────────────────────────────────────────────────┐
│                    Testing Pyramid                          │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│                        /\                                   │
│                       /  \      UI/E2E Tests               │
│                      /    \     (Slow, Expensive)          │
│                     /──────\                                │
│                    /        \   Integration Tests          │
│                   /          \  (Medium Speed)             │
│                  /────────────\                             │
│                 /              \  Unit Tests               │
│                /                \ (Fast, Cheap)            │
│               /__________________\                          │
│                                                             │
│         More unit tests, fewer integration/E2E tests       │
└─────────────────────────────────────────────────────────────┘
```

### Types of Tests

| Type | Scope | Speed | Purpose |
|------|-------|-------|---------|
| **Unit Tests** | Single method/class | Fast (ms) | Verify logic works |
| **Integration Tests** | Multiple components | Medium (s) | Verify components work together |
| **End-to-End Tests** | Entire application | Slow (min) | Verify user workflows |

---

## 2. Why Write Tests?

### Benefits of Unit Testing

```
┌─────────────────────────────────────────────────────────────┐
│                  Why Write Unit Tests?                      │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  🐛 Catch Bugs Early                                        │
│     Find issues before they reach production               │
│                                                             │
│  📖 Documentation                                           │
│     Tests show how code should be used                     │
│                                                             │
│  🔄 Refactoring Confidence                                  │
│     Change code safely with tests as safety net            │
│                                                             │
│  ⚡ Faster Development                                      │
│     Automated tests run in seconds vs manual testing       │
│                                                             │
│  🏗️ Better Design                                           │
│     Testable code is usually well-designed code            │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### The Cost of Not Testing

```java
// Without tests - scary to change!
public double calculateDiscount(double price, String customerType) {
    // What if I break this logic?
    // What are all the edge cases?
    // Does it handle null?
    if (customerType.equals("premium")) {
        return price * 0.2;
    } else if (customerType.equals("regular")) {
        return price * 0.1;
    }
    return 0;
}

// With tests - confident changes!
@Test
void premiumCustomerGets20PercentDiscount() {
    assertEquals(20.0, calculator.calculateDiscount(100, "premium"));
}

@Test
void regularCustomerGets10PercentDiscount() {
    assertEquals(10.0, calculator.calculateDiscount(100, "regular"));
}

@Test
void unknownCustomerGetsNoDiscount() {
    assertEquals(0.0, calculator.calculateDiscount(100, "unknown"));
}
```

---

## 3. JUnit 5 Overview

### JUnit 5 Architecture

JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage

```
┌─────────────────────────────────────────────────────────────┐
│                     JUnit 5 Architecture                    │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  ┌─────────────────┐  ┌─────────────────┐                  │
│  │  JUnit Jupiter  │  │  JUnit Vintage  │  Test Engines   │
│  │  (JUnit 5 API)  │  │  (JUnit 3/4)    │                  │
│  └────────┬────────┘  └────────┬────────┘                  │
│           │                    │                            │
│           └──────────┬─────────┘                            │
│                      │                                      │
│           ┌──────────▼──────────┐                          │
│           │   JUnit Platform    │  Foundation             │
│           │   (Test Runner)     │                          │
│           └─────────────────────┘                          │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Key Annotations

| Annotation | Purpose | Example |
|------------|---------|---------|
| `@Test` | Marks a test method | `@Test void testAdd()` |
| `@BeforeEach` | Run before each test | Setup test data |
| `@AfterEach` | Run after each test | Cleanup resources |
| `@BeforeAll` | Run once before all tests | Expensive setup |
| `@AfterAll` | Run once after all tests | Final cleanup |
| `@DisplayName` | Custom test name | `@DisplayName("User login")` |
| `@Disabled` | Skip a test | `@Disabled("Bug #123")` |
| `@Nested` | Group related tests | Inner test classes |
| `@Tag` | Categorize tests | `@Tag("slow")` |

---

## 4. Setting Up JUnit

### Maven Setup

Add to your `pom.xml`:

```xml
<dependencies>
    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.1.2</version>
        </plugin>
    </plugins>
</build>
```

### Gradle Setup

Add to your `build.gradle`:

```groovy
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
}

test {
    useJUnitPlatform()
}
```

### Project Structure

```
my-project/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── Calculator.java
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── CalculatorTest.java
├── pom.xml (or build.gradle)
```

---

## 5. Your First Test

### The Code to Test

```java
// src/main/java/com/example/Calculator.java
package com.example;

public class Calculator {
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
```

### Writing the Test

```java
// src/test/java/com/example/CalculatorTest.java
package com.example;

import org.junit.jupiter.api.Test;           // Import Test annotation
import org.junit.jupiter.api.DisplayName;    // Import DisplayName
import static org.junit.jupiter.api.Assertions.*;  // Import assertions

class CalculatorTest {
    //    ^^^^^^^^^^ Test class name = ClassName + "Test"
    
    private Calculator calculator = new Calculator();
    //      ^^^^^^^^^^ Create instance of class being tested
    
    @Test  // Marks this method as a test
    @DisplayName("Adding two positive numbers")
    void testAddPositiveNumbers() {
        // Arrange - Set up test data
        int a = 5;
        int b = 3;
        
        // Act - Call the method being tested
        int result = calculator.add(a, b);
        
        // Assert - Verify the result
        assertEquals(8, result);
        //           ^ expected value
        //              ^ actual value from method
    }
    
    @Test
    @DisplayName("Adding negative numbers")
    void testAddNegativeNumbers() {
        assertEquals(-8, calculator.add(-5, -3));
    }
    
    @Test
    @DisplayName("Adding zero")
    void testAddZero() {
        assertEquals(5, calculator.add(5, 0));
        assertEquals(5, calculator.add(0, 5));
    }
}
```

### Running Tests

```bash
# With Maven
mvn test

# With Gradle
gradle test

# Output:
# [INFO] -------------------------------------------------------
# [INFO]  T E S T S
# [INFO] -------------------------------------------------------
# [INFO] Running com.example.CalculatorTest
# [INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
# [INFO] 
# [INFO] Results:
# [INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
# [INFO] 
# [INFO] BUILD SUCCESS
```

### The AAA Pattern

Every test should follow **Arrange-Act-Assert**:

```java
@Test
void testWithdrawal() {
    // ARRANGE - Set up the test scenario
    BankAccount account = new BankAccount("John", 1000);
    
    // ACT - Perform the action being tested
    account.withdraw(200);
    
    // ASSERT - Verify the expected outcome
    assertEquals(800, account.getBalance());
}
```

---

## 6. Assertions Deep Dive

### Basic Assertions

```java
import static org.junit.jupiter.api.Assertions.*;

class AssertionExamples {
    
    @Test
    void basicAssertions() {
        // assertEquals - Check equality
        assertEquals(4, 2 + 2);
        assertEquals("hello", "hello");
        assertEquals(3.14, 3.14159, 0.01);  // With delta for doubles
        //                         ^^^^^ tolerance
        
        // assertNotEquals - Check inequality
        assertNotEquals(5, 2 + 2);
        
        // assertTrue / assertFalse - Check boolean
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        
        // assertNull / assertNotNull - Check null
        String name = "John";
        assertNotNull(name);
        
        String empty = null;
        assertNull(empty);
    }
    
    @Test
    void objectAssertions() {
        // assertSame - Check same object reference
        String s1 = "hello";
        String s2 = s1;
        assertSame(s1, s2);
        
        // assertNotSame - Check different object reference
        String s3 = new String("hello");
        assertNotSame(s1, s3);  // Different objects
        assertEquals(s1, s3);   // But equal content
    }
    
    @Test
    void arrayAssertions() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        
        // assertArrayEquals - Check array equality
        assertArrayEquals(expected, actual);
    }
    
    @Test
    void iterableAssertions() {
        List<String> expected = List.of("a", "b", "c");
        List<String> actual = List.of("a", "b", "c");
        
        // assertIterableEquals - Check iterable equality
        assertIterableEquals(expected, actual);
    }
}
```

### Assertion Messages

```java
@Test
void assertionsWithMessages() {
    int result = calculator.add(2, 2);
    
    // Add descriptive message (shown on failure)
    assertEquals(4, result, "2 + 2 should equal 4");
    
    // Lazy message (computed only if test fails)
    assertEquals(4, result, () -> "Expected 4 but got " + result);
}
```

### Multiple Assertions with assertAll

```java
@Test
void testPerson() {
    Person person = new Person("John", "Doe", 30);
    
    // Without assertAll - stops at first failure
    assertEquals("John", person.getFirstName());
    assertEquals("Doe", person.getLastName());  // Won't run if above fails
    assertEquals(30, person.getAge());
    
    // With assertAll - runs ALL assertions and reports all failures
    assertAll("Person properties",
        () -> assertEquals("John", person.getFirstName()),
        () -> assertEquals("Doe", person.getLastName()),
        () -> assertEquals(30, person.getAge())
    );
}
```

### Timeout Assertions

```java
@Test
void testTimeout() {
    // assertTimeout - waits for completion, then checks time
    String result = assertTimeout(Duration.ofSeconds(2), () -> {
        // Simulate some work
        Thread.sleep(500);
        return "completed";
    });
    assertEquals("completed", result);
    
    // assertTimeoutPreemptively - aborts if timeout exceeded
    assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
        // This will be interrupted if it takes too long
        quickOperation();
    });
}
```

---

## 7. Test Lifecycle

### Lifecycle Annotations

```java
import org.junit.jupiter.api.*;

class LifecycleTest {
    
    private Database database;
    private static Connection connection;
    
    @BeforeAll  // Runs ONCE before all tests in this class
    static void setupAll() {
        //    ^^^^^^ Must be static!
        System.out.println("🚀 Starting test suite");
        connection = Database.connect();
    }
    
    @BeforeEach  // Runs before EACH test method
    void setup() {
        System.out.println("  📋 Setting up test");
        database = new Database(connection);
        database.beginTransaction();
    }
    
    @Test
    void test1() {
        System.out.println("    ✅ Running test 1");
        // Test code here
    }
    
    @Test
    void test2() {
        System.out.println("    ✅ Running test 2");
        // Test code here
    }
    
    @AfterEach  // Runs after EACH test method
    void tearDown() {
        System.out.println("  🧹 Cleaning up test");
        database.rollbackTransaction();
    }
    
    @AfterAll  // Runs ONCE after all tests complete
    static void tearDownAll() {
        System.out.println("🏁 Test suite complete");
        connection.close();
    }
}
```

### Lifecycle Execution Order

```
Output:
🚀 Starting test suite
  📋 Setting up test
    ✅ Running test 1
  🧹 Cleaning up test
  📋 Setting up test
    ✅ Running test 2
  🧹 Cleaning up test
🏁 Test suite complete
```

### Visual Lifecycle

```
┌─────────────────────────────────────────────────────────────┐
│                    Test Lifecycle                           │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  @BeforeAll                                                 │
│      │                                                      │
│      ▼                                                      │
│  ┌─────────────────────────────────────┐                   │
│  │  @BeforeEach                        │                   │
│  │      │                              │                   │
│  │      ▼                              │                   │
│  │  @Test (test1)                      │  ◀─┐              │
│  │      │                              │    │              │
│  │      ▼                              │    │ Repeat       │
│  │  @AfterEach                         │    │ for each     │
│  └─────────────────────────────────────┘    │ test         │
│                                             │              │
│  ┌─────────────────────────────────────┐    │              │
│  │  @BeforeEach                        │    │              │
│  │      │                              │    │              │
│  │      ▼                              │    │              │
│  │  @Test (test2)                      │  ──┘              │
│  │      │                              │                   │
│  │      ▼                              │                   │
│  │  @AfterEach                         │                   │
│  └─────────────────────────────────────┘                   │
│      │                                                      │
│      ▼                                                      │
│  @AfterAll                                                  │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Nested Tests

```java
@DisplayName("Calculator Tests")
class CalculatorTest {
    
    Calculator calc = new Calculator();
    
    @Nested
    @DisplayName("Addition operations")
    class AdditionTests {
        
        @Test
        @DisplayName("adds two positive numbers")
        void testAddPositive() {
            assertEquals(5, calc.add(2, 3));
        }
        
        @Test
        @DisplayName("adds two negative numbers")
        void testAddNegative() {
            assertEquals(-5, calc.add(-2, -3));
        }
    }
    
    @Nested
    @DisplayName("Division operations")
    class DivisionTests {
        
        @Test
        @DisplayName("divides two numbers")
        void testDivide() {
            assertEquals(2, calc.divide(6, 3));
        }
        
        @Test
        @DisplayName("throws exception when dividing by zero")
        void testDivideByZero() {
            assertThrows(IllegalArgumentException.class, 
                () -> calc.divide(5, 0));
        }
    }
}
```

---

## 8. Parameterized Tests

### Why Parameterized Tests?

```java
// Without parameterized tests - lots of repetition
@Test void testIsEven2() { assertTrue(isEven(2)); }
@Test void testIsEven4() { assertTrue(isEven(4)); }
@Test void testIsEven6() { assertTrue(isEven(6)); }
@Test void testIsOdd1() { assertFalse(isEven(1)); }
@Test void testIsOdd3() { assertFalse(isEven(3)); }

// With parameterized tests - clean and maintainable!
@ParameterizedTest
@ValueSource(ints = {2, 4, 6, 8, 100})
void testIsEven(int number) {
    assertTrue(NumberUtils.isEven(number));
}
```

### Setting Up Parameterized Tests

Add dependency:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
```

### @ValueSource - Simple Values

```java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedExamples {
    
    @ParameterizedTest
    @ValueSource(strings = {"hello", "world", "java"})
    void testStringNotEmpty(String input) {
        assertFalse(input.isEmpty());
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testPositiveNumbers(int number) {
        assertTrue(number > 0);
    }
    
    @ParameterizedTest
    @ValueSource(doubles = {1.0, 2.5, 3.14})
    void testPositiveDoubles(double number) {
        assertTrue(number > 0);
    }
}
```

### @NullSource, @EmptySource, @NullAndEmptySource

```java
@ParameterizedTest
@NullSource  // Passes null
void testNullInput(String input) {
    assertNull(input);
}

@ParameterizedTest
@EmptySource  // Passes empty string/collection
void testEmptyString(String input) {
    assertTrue(input.isEmpty());
}

@ParameterizedTest
@NullAndEmptySource  // Passes both null and empty
@ValueSource(strings = {"  ", "\t", "\n"})  // Also whitespace
void testBlankStrings(String input) {
    assertTrue(input == null || input.trim().isEmpty());
}
```

### @CsvSource - Multiple Parameters

```java
@ParameterizedTest
@CsvSource({
    "1, 2, 3",      // a=1, b=2, expected=3
    "5, 5, 10",     // a=5, b=5, expected=10
    "-1, 1, 0",     // a=-1, b=1, expected=0
    "100, -50, 50"  // a=100, b=-50, expected=50
})
void testAdd(int a, int b, int expected) {
    assertEquals(expected, calculator.add(a, b));
}

@ParameterizedTest
@CsvSource({
    "apple, 5",
    "banana, 6",
    "cherry, 6"
})
void testStringLength(String fruit, int expectedLength) {
    assertEquals(expectedLength, fruit.length());
}

// With custom delimiter
@ParameterizedTest
@CsvSource(value = {
    "apple | 5",
    "banana | 6"
}, delimiter = '|')
void testWithCustomDelimiter(String fruit, int length) {
    assertEquals(length, fruit.length());
}
```

### @CsvFileSource - External CSV File

```java
// src/test/resources/test-data.csv
// name,age,valid
// John,25,true
// Jane,30,true
// Bob,-5,false

@ParameterizedTest
@CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
void testFromCsvFile(String name, int age, boolean valid) {
    Person person = new Person(name, age);
    assertEquals(valid, person.isValid());
}
```

### @MethodSource - Complex Test Data

```java
@ParameterizedTest
@MethodSource("provideAdditionData")  // References method name
void testAddWithMethodSource(int a, int b, int expected) {
    assertEquals(expected, calculator.add(a, b));
}

// Method must be static and return Stream<Arguments>
static Stream<Arguments> provideAdditionData() {
    return Stream.of(
        Arguments.of(1, 2, 3),
        Arguments.of(5, 5, 10),
        Arguments.of(-1, -1, -2),
        Arguments.of(Integer.MAX_VALUE, 0, Integer.MAX_VALUE)
    );
}

// For complex objects
@ParameterizedTest
@MethodSource("providePersons")
void testPersonValidation(Person person, boolean expectedValid) {
    assertEquals(expectedValid, person.isValid());
}

static Stream<Arguments> providePersons() {
    return Stream.of(
        Arguments.of(new Person("John", 25), true),
        Arguments.of(new Person("", 25), false),      // Empty name
        Arguments.of(new Person("Jane", -5), false)   // Negative age
    );
}
```

### @EnumSource - Testing with Enums

```java
enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

@ParameterizedTest
@EnumSource(Day.class)
void testAllDays(Day day) {
    assertNotNull(day);
}

@ParameterizedTest
@EnumSource(value = Day.class, names = {"SATURDAY", "SUNDAY"})
void testWeekend(Day day) {
    assertTrue(day == Day.SATURDAY || day == Day.SUNDAY);
}

@ParameterizedTest
@EnumSource(value = Day.class, mode = EnumSource.Mode.EXCLUDE, 
            names = {"SATURDAY", "SUNDAY"})
void testWeekdays(Day day) {
    assertTrue(day != Day.SATURDAY && day != Day.SUNDAY);
}
```

---

## 9. Testing Exceptions

### assertThrows

```java
@Test
void testDivideByZero() {
    Calculator calc = new Calculator();
    
    // Basic exception testing
    assertThrows(IllegalArgumentException.class, () -> {
        calc.divide(10, 0);
    });
}

@Test
void testExceptionMessage() {
    Calculator calc = new Calculator();
    
    // Capture the exception to check its message
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> calc.divide(10, 0)
    );
    
    assertEquals("Cannot divide by zero", exception.getMessage());
}

@Test
void testExceptionType() {
    // Test that it throws ArithmeticException, not RuntimeException
    assertThrows(ArithmeticException.class, () -> {
        int result = 10 / 0;
    });
}
```

### assertDoesNotThrow

```java
@Test
void testValidOperation() {
    Calculator calc = new Calculator();
    
    // Verify no exception is thrown
    assertDoesNotThrow(() -> {
        calc.divide(10, 2);
    });
    
    // With return value
    int result = assertDoesNotThrow(() -> calc.divide(10, 2));
    assertEquals(5, result);
}
```

### Testing Multiple Scenarios

```java
@Nested
@DisplayName("Exception Testing")
class ExceptionTests {
    
    private UserService userService;
    
    @BeforeEach
    void setup() {
        userService = new UserService();
    }
    
    @Test
    @DisplayName("throws exception for null username")
    void testNullUsername() {
        assertThrows(IllegalArgumentException.class, 
            () -> userService.createUser(null, "password"));
    }
    
    @Test
    @DisplayName("throws exception for empty password")
    void testEmptyPassword() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> userService.createUser("john", "")
        );
        assertTrue(ex.getMessage().contains("password"));
    }
    
    @Test
    @DisplayName("throws exception for duplicate username")
    void testDuplicateUser() {
        userService.createUser("john", "pass123");
        
        assertThrows(UserExistsException.class,
            () -> userService.createUser("john", "different"));
    }
}
```

---

## 10. Mocking Basics

### What is Mocking?

Mocking allows you to test a class in isolation by replacing its dependencies with fake objects.

```
┌─────────────────────────────────────────────────────────────┐
│                    Without Mocking                          │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  ┌──────────────┐    ┌──────────────┐    ┌──────────────┐  │
│  │  OrderService │───▶│  Database    │───▶│  Network     │  │
│  │  (Testing)    │    │  (Real)      │    │  (Real)      │  │
│  └──────────────┘    └──────────────┘    └──────────────┘  │
│                                                             │
│  Problems:                                                  │
│  - Slow tests (database connection)                        │
│  - Flaky tests (network issues)                           │
│  - Complex setup (test data)                              │
│                                                             │
├─────────────────────────────────────────────────────────────┤
│                     With Mocking                            │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  ┌──────────────┐    ┌──────────────┐                      │
│  │  OrderService │───▶│  Mock DB     │  No network needed! │
│  │  (Testing)    │    │  (Fake)      │                      │
│  └──────────────┘    └──────────────┘                      │
│                                                             │
│  Benefits:                                                  │
│  - Fast tests (no I/O)                                     │
│  - Reliable tests (no external deps)                       │
│  - Simple setup                                            │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Setting Up Mockito

```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.5.0</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>5.5.0</version>
    <scope>test</scope>
</dependency>
```

### Creating Mocks

```java
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  // Enable Mockito annotations
class OrderServiceTest {
    
    @Mock  // Creates a mock object
    private UserRepository userRepository;
    
    @Mock
    private EmailService emailService;
    
    @InjectMocks  // Injects mocks into this object
    private OrderService orderService;
    
    @Test
    void testCreateOrder() {
        // Arrange - Define mock behavior
        User mockUser = new User("john", "john@email.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));
        //   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ When this is called
        //                                 ^^^^^^^^^^^^^^^^^^^^^^^ Return this
        
        // Act
        Order order = orderService.createOrder(1L, List.of("item1"));
        
        // Assert
        assertNotNull(order);
        assertEquals("john", order.getUsername());
        
        // Verify mock was called
        verify(userRepository).findById(1L);
        verify(emailService).sendOrderConfirmation(eq("john@email.com"), any());
    }
}
```

### Stubbing Methods

```java
@Test
void stubbingExamples() {
    // Return a value
    when(userRepository.findById(1L)).thenReturn(Optional.of(user));
    
    // Return different values on consecutive calls
    when(userRepository.count())
        .thenReturn(1L)   // First call
        .thenReturn(2L)   // Second call
        .thenReturn(3L);  // Third call
    
    // Throw exception
    when(userRepository.findById(999L))
        .thenThrow(new NotFoundException("User not found"));
    
    // Return based on argument
    when(userRepository.findByName(anyString()))
        .thenAnswer(invocation -> {
            String name = invocation.getArgument(0);
            return Optional.of(new User(name));
        });
    
    // Do nothing for void methods
    doNothing().when(emailService).sendEmail(any(), any());
    
    // Throw exception for void methods
    doThrow(new EmailException("Failed"))
        .when(emailService).sendEmail(eq("invalid@"), any());
}
```

### Verification

```java
@Test
void verificationExamples() {
    // Call the method being tested
    orderService.processOrder(orderId);
    
    // Verify method was called once (default)
    verify(paymentService).processPayment(any());
    
    // Verify specific number of calls
    verify(emailService, times(2)).sendEmail(any(), any());
    
    // Verify never called
    verify(smsService, never()).sendSms(any(), any());
    
    // Verify at least/at most
    verify(logger, atLeast(1)).log(any());
    verify(logger, atMost(5)).log(any());
    
    // Verify order of calls
    InOrder inOrder = inOrder(paymentService, inventoryService);
    inOrder.verify(paymentService).processPayment(any());
    inOrder.verify(inventoryService).reserveItems(any());
    
    // Verify no more interactions
    verifyNoMoreInteractions(paymentService);
}
```

### Argument Matchers

```java
@Test
void argumentMatcherExamples() {
    // Any value
    when(userRepo.findById(anyLong())).thenReturn(Optional.of(user));
    when(userRepo.findByName(anyString())).thenReturn(Optional.of(user));
    when(userRepo.save(any(User.class))).thenReturn(user);
    
    // Specific conditions
    when(calculator.calculate(argThat(x -> x > 0)))
        .thenReturn(100);
    
    // Contains/matches
    when(validator.validate(contains("test")))
        .thenReturn(true);
    when(validator.validate(matches("\\d+")))
        .thenReturn(true);
    
    // Argument capture for verification
    ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
    
    userService.createUser("John", "john@email.com");
    
    verify(userRepo).save(userCaptor.capture());
    User savedUser = userCaptor.getValue();
    assertEquals("John", savedUser.getName());
}
```

---

## 11. Test-Driven Development

### TDD Cycle: Red-Green-Refactor

```
┌─────────────────────────────────────────────────────────────┐
│                    TDD Cycle                                │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│                    ┌───────────┐                            │
│              ┌────▶│    RED    │◀────┐                      │
│              │     │Write Test │     │                      │
│              │     │(Fails)    │     │                      │
│              │     └─────┬─────┘     │                      │
│              │           │           │                      │
│              │           ▼           │                      │
│         ┌────┴────┐ ┌────────────┐   │                      │
│         │ REFACTOR│ │   GREEN    │───┘                      │
│         │Improve  │◀│Write Code  │                          │
│         │Code     │ │(Passes)    │                          │
│         └─────────┘ └────────────┘                          │
│                                                             │
│  1. RED:      Write a failing test first                   │
│  2. GREEN:    Write minimal code to pass the test          │
│  3. REFACTOR: Improve code while keeping tests passing     │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### TDD Example: Building a Stack

```java
// Step 1: RED - Write failing test
@Test
void newStackIsEmpty() {
    Stack<Integer> stack = new Stack<>();
    assertTrue(stack.isEmpty());  // Fails - Stack class doesn't exist
}

// Step 2: GREEN - Write minimal code to pass
public class Stack<T> {
    public boolean isEmpty() {
        return true;  // Minimal implementation
    }
}

// Step 3: RED - Next failing test
@Test
void pushMakesStackNotEmpty() {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    assertFalse(stack.isEmpty());  // Fails
}

// Step 4: GREEN - Implement push
public class Stack<T> {
    private int size = 0;
    
    public void push(T item) {
        size++;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}

// Step 5: RED - Test pop
@Test
void popReturnsLastPushedItem() {
    Stack<Integer> stack = new Stack<>();
    stack.push(42);
    assertEquals(42, stack.pop());
}

// Step 6: GREEN - Implement pop
public class Stack<T> {
    private List<T> items = new ArrayList<>();
    
    public void push(T item) {
        items.add(item);
    }
    
    public T pop() {
        return items.remove(items.size() - 1);
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
}

// Step 7: RED - Test edge case
@Test
void popOnEmptyStackThrowsException() {
    Stack<Integer> stack = new Stack<>();
    assertThrows(EmptyStackException.class, () -> stack.pop());
}

// Step 8: GREEN - Handle edge case
public T pop() {
    if (items.isEmpty()) {
        throw new EmptyStackException();
    }
    return items.remove(items.size() - 1);
}

// Continue the cycle...
```

### Benefits of TDD

1. **Design First** - Forces you to think about API before implementation
2. **100% Coverage** - Every line of code has a test
3. **Documentation** - Tests describe expected behavior
4. **Confidence** - Safe to refactor with passing tests
5. **Fewer Bugs** - Catch issues immediately

---

## 12. Best Practices

### Test Naming Conventions

```java
// Pattern: methodName_stateUnderTest_expectedBehavior
@Test
void withdraw_sufficientBalance_reducesBalance() { }

@Test
void withdraw_insufficientBalance_throwsException() { }

@Test
void withdraw_negativeAmount_throwsException() { }

// Or use @DisplayName for readability
@Test
@DisplayName("Withdrawal with sufficient balance reduces the balance")
void testWithdraw() { }
```

### One Assertion Per Test (Mostly)

```java
// ❌ Multiple unrelated assertions
@Test
void testUser() {
    User user = new User("John", 25);
    assertEquals("John", user.getName());
    assertEquals(25, user.getAge());
    assertTrue(user.isAdult());
    assertNotNull(user.getId());
}

// ✅ Focused tests
@Test
void userHasCorrectName() {
    User user = new User("John", 25);
    assertEquals("John", user.getName());
}

@Test
void userHasCorrectAge() {
    User user = new User("John", 25);
    assertEquals(25, user.getAge());
}

// ✅ Or use assertAll for related assertions
@Test
void userIsCreatedCorrectly() {
    User user = new User("John", 25);
    assertAll("user properties",
        () -> assertEquals("John", user.getName()),
        () -> assertEquals(25, user.getAge())
    );
}
```

### Keep Tests Independent

```java
// ❌ Tests depend on each other
class BadTests {
    private static User savedUser;
    
    @Test
    void test1_createUser() {
        savedUser = userService.create("John");
        assertNotNull(savedUser);
    }
    
    @Test
    void test2_updateUser() {
        // Depends on test1 running first!
        savedUser.setAge(30);
        userService.update(savedUser);
    }
}

// ✅ Independent tests
class GoodTests {
    @Test
    void createUser_savesUser() {
        User user = userService.create("John");
        assertNotNull(user);
    }
    
    @Test
    void updateUser_changesAge() {
        // Create fresh test data
        User user = userService.create("John");
        user.setAge(30);
        
        userService.update(user);
        
        assertEquals(30, userService.findById(user.getId()).getAge());
    }
}
```

### Test Edge Cases

```java
class StringUtilsTest {
    
    @Nested
    @DisplayName("reverse() method")
    class ReverseTests {
        
        @Test
        void normalString() {
            assertEquals("olleh", StringUtils.reverse("hello"));
        }
        
        @Test
        void emptyString() {
            assertEquals("", StringUtils.reverse(""));
        }
        
        @Test
        void nullString() {
            assertThrows(NullPointerException.class,
                () -> StringUtils.reverse(null));
        }
        
        @Test
        void singleCharacter() {
            assertEquals("a", StringUtils.reverse("a"));
        }
        
        @Test
        void palindrome() {
            assertEquals("radar", StringUtils.reverse("radar"));
        }
        
        @Test
        void unicodeCharacters() {
            assertEquals("界世", StringUtils.reverse("世界"));
        }
    }
}
```

### Use Test Fixtures

```java
class OrderServiceTest {
    
    // Shared test fixtures
    private static final User TEST_USER = new User("testuser", "test@email.com");
    private static final Product LAPTOP = new Product("Laptop", 999.99);
    private static final Product PHONE = new Product("Phone", 599.99);
    
    private OrderService orderService;
    private Order testOrder;
    
    @BeforeEach
    void setup() {
        orderService = new OrderService();
        testOrder = new Order(TEST_USER);
        testOrder.addItem(LAPTOP);
    }
    
    @Test
    void calculateTotal_singleItem() {
        assertEquals(999.99, testOrder.getTotal());
    }
    
    @Test
    void calculateTotal_multipleItems() {
        testOrder.addItem(PHONE);
        assertEquals(1599.98, testOrder.getTotal(), 0.01);
    }
}
```

### Test Coverage Guidelines

```
┌─────────────────────────────────────────────────────────────┐
│                  What to Test                               │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  ✅ DO Test:                                                │
│     • Public methods                                        │
│     • Business logic                                        │
│     • Edge cases and boundaries                            │
│     • Error handling                                        │
│     • Integration points                                    │
│                                                             │
│  ❌ DON'T Test:                                             │
│     • Getters/Setters (usually)                            │
│     • Private methods directly                             │
│     • Third-party libraries                                │
│     • Generated code                                        │
│                                                             │
│  📊 Coverage Goals:                                         │
│     • 70-80% is usually good                               │
│     • 100% is not always practical                         │
│     • Focus on critical paths                              │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

---

## 13. Summary

### Key Takeaways

```
┌─────────────────────────────────────────────────────────────┐
│                   JUnit 5 Summary                           │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  📝 Core Annotations:                                       │
│     @Test, @BeforeEach, @AfterEach, @BeforeAll, @AfterAll  │
│                                                             │
│  ✅ Assertions:                                             │
│     assertEquals, assertTrue, assertThrows, assertAll      │
│                                                             │
│  🔄 Parameterized:                                          │
│     @ValueSource, @CsvSource, @MethodSource, @EnumSource   │
│                                                             │
│  🎭 Mocking (Mockito):                                      │
│     @Mock, @InjectMocks, when().thenReturn(), verify()     │
│                                                             │
│  🔴🟢🔄 TDD:                                                 │
│     Red (write failing test) → Green (pass) → Refactor     │
│                                                             │
│  💡 Best Practices:                                         │
│     • One assertion per test (mostly)                      │
│     • Independent tests                                     │
│     • Test edge cases                                       │
│     • Use meaningful test names                            │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Quick Reference

```java
// Basic test structure
@Test
@DisplayName("Description of what test verifies")
void methodName_condition_expectedResult() {
    // Arrange
    var sut = new SystemUnderTest();
    
    // Act
    var result = sut.doSomething();
    
    // Assert
    assertEquals(expected, result);
}

// Parameterized test
@ParameterizedTest
@CsvSource({"input1, expected1", "input2, expected2"})
void testWithParameters(String input, String expected) {
    assertEquals(expected, process(input));
}

// Mocking test
@ExtendWith(MockitoExtension.class)
class ServiceTest {
    @Mock Repository repo;
    @InjectMocks Service service;
    
    @Test
    void testWithMock() {
        when(repo.find(1)).thenReturn(data);
        var result = service.process(1);
        verify(repo).find(1);
    }
}
```

---

## 🔗 Resources

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Mockito Documentation](https://site.mockito.org/)
- [AssertJ (Fluent Assertions)](https://assertj.github.io/doc/)

---

## ✅ Next Steps

1. Complete the exercises in `Exercises.md`
2. Practice TDD on small projects
3. Add tests to existing code
4. Move on to **Class 5: Build Tools & Packaging**

---

**Testing is not just about finding bugs - it's about building confidence in your code!** 🧪
