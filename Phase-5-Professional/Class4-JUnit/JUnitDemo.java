/**
 * JUnit Testing Demo
 * 
 * This file demonstrates unit testing concepts and best practices.
 * Note: This is a demonstration file showing code + test patterns.
 * In a real project, tests would be in src/test/java.
 * 
 * To run these tests:
 * 1. Set up a Maven/Gradle project
 * 2. Add JUnit 5 and Mockito dependencies
 * 3. Move test classes to src/test/java
 * 4. Run: mvn test or gradle test
 */

// ============================================================
// PART 1: THE CODE TO TEST
// ============================================================

/**
 * A simple calculator class that we'll write tests for.
 */
class Calculator {
    
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
    
    public double power(double base, int exponent) {
        return Math.pow(base, exponent);
    }
    
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}

/**
 * A string utility class with various string operations.
 */
class StringUtils {
    
    public static String reverse(String str) {
        if (str == null) {
            throw new NullPointerException("String cannot be null");
        }
        return new StringBuilder(str).reverse().toString();
    }
    
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        return cleaned.equals(reverse(cleaned));
    }
    
    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        return str.trim().split("\\s+").length;
    }
    
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
    }
}

/**
 * User class for demonstrating object testing.
 */
class User {
    private String username;
    private String email;
    private int age;
    
    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
    
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    
    public boolean isValid() {
        return username != null && !username.isEmpty()
            && email != null && email.contains("@")
            && age >= 0 && age <= 150;
    }
    
    public boolean isAdult() {
        return age >= 18;
    }
}

/**
 * User service that depends on a repository (for mocking demo).
 */
interface UserRepository {
    User findById(long id);
    User findByUsername(String username);
    User save(User user);
    void delete(long id);
    boolean exists(String username);
}

class UserService {
    private final UserRepository repository;
    
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    
    public User getUser(long id) {
        User user = repository.findById(id);
        if (user == null) {
            throw new RuntimeException("User not found: " + id);
        }
        return user;
    }
    
    public User createUser(String username, String email, int age) {
        if (repository.exists(username)) {
            throw new IllegalArgumentException("Username already exists: " + username);
        }
        User user = new User(username, email, age);
        if (!user.isValid()) {
            throw new IllegalArgumentException("Invalid user data");
        }
        return repository.save(user);
    }
    
    public void deleteUser(long id) {
        User user = repository.findById(id);
        if (user == null) {
            throw new RuntimeException("User not found: " + id);
        }
        repository.delete(id);
    }
}

/**
 * Order class for parameterized testing demo.
 */
class Order {
    private String id;
    private double subtotal;
    private String customerType; // "regular", "premium", "vip"
    private String couponCode;
    
    public Order(String id, double subtotal, String customerType, String couponCode) {
        this.id = id;
        this.subtotal = subtotal;
        this.customerType = customerType;
        this.couponCode = couponCode;
    }
    
    public double calculateDiscount() {
        double discount = 0;
        
        // Customer type discount
        switch (customerType) {
            case "premium" -> discount += subtotal * 0.10;
            case "vip" -> discount += subtotal * 0.20;
        }
        
        // Coupon code discount
        if (couponCode != null) {
            switch (couponCode) {
                case "SAVE10" -> discount += subtotal * 0.10;
                case "SAVE20" -> discount += subtotal * 0.20;
                case "FLAT50" -> discount += 50;
            }
        }
        
        // Cap discount at subtotal
        return Math.min(discount, subtotal);
    }
    
    public double getTotal() {
        return subtotal - calculateDiscount();
    }
    
    // Getters
    public String getId() { return id; }
    public double getSubtotal() { return subtotal; }
    public String getCustomerType() { return customerType; }
}


// ============================================================
// PART 2: TEST EXAMPLES (would be in src/test/java)
// ============================================================

/*
 * NOTE: The following are example test classes.
 * In a real project, these would be in separate files under src/test/java
 * and would have proper imports like:
 * 
 * import org.junit.jupiter.api.*;
 * import org.junit.jupiter.params.*;
 * import org.junit.jupiter.params.provider.*;
 * import static org.junit.jupiter.api.Assertions.*;
 * import static org.mockito.Mockito.*;
 * import org.mockito.*;
 * import org.mockito.junit.jupiter.MockitoExtension;
 */

/**
 * Example 1: Basic Calculator Tests
 * 
 * class CalculatorTest {
 *     
 *     private Calculator calculator;
 *     
 *     @BeforeEach
 *     void setUp() {
 *         calculator = new Calculator();
 *     }
 *     
 *     // ========== Addition Tests ==========
 *     
 *     @Test
 *     @DisplayName("Adding two positive numbers")
 *     void add_twoPositiveNumbers_returnsSum() {
 *         assertEquals(5, calculator.add(2, 3));
 *     }
 *     
 *     @Test
 *     @DisplayName("Adding negative numbers")
 *     void add_negativeNumbers_returnsSum() {
 *         assertEquals(-5, calculator.add(-2, -3));
 *     }
 *     
 *     @Test
 *     @DisplayName("Adding zero")
 *     void add_withZero_returnsOtherNumber() {
 *         assertAll(
 *             () -> assertEquals(5, calculator.add(5, 0)),
 *             () -> assertEquals(5, calculator.add(0, 5)),
 *             () -> assertEquals(0, calculator.add(0, 0))
 *         );
 *     }
 *     
 *     // ========== Division Tests ==========
 *     
 *     @Test
 *     @DisplayName("Dividing two numbers")
 *     void divide_validNumbers_returnsQuotient() {
 *         assertEquals(5, calculator.divide(10, 2));
 *     }
 *     
 *     @Test
 *     @DisplayName("Division by zero throws exception")
 *     void divide_byZero_throwsException() {
 *         IllegalArgumentException exception = assertThrows(
 *             IllegalArgumentException.class,
 *             () -> calculator.divide(10, 0)
 *         );
 *         assertEquals("Cannot divide by zero", exception.getMessage());
 *     }
 *     
 *     // ========== Factorial Tests ==========
 *     
 *     @Test
 *     @DisplayName("Factorial of positive numbers")
 *     void factorial_positiveNumber_returnsFactorial() {
 *         assertAll(
 *             () -> assertEquals(1, calculator.factorial(0)),
 *             () -> assertEquals(1, calculator.factorial(1)),
 *             () -> assertEquals(120, calculator.factorial(5)),
 *             () -> assertEquals(3628800, calculator.factorial(10))
 *         );
 *     }
 *     
 *     @Test
 *     @DisplayName("Factorial of negative number throws exception")
 *     void factorial_negativeNumber_throwsException() {
 *         assertThrows(IllegalArgumentException.class,
 *             () -> calculator.factorial(-1));
 *     }
 * }
 */

/**
 * Example 2: Parameterized Tests
 * 
 * class CalculatorParameterizedTest {
 *     
 *     private Calculator calculator = new Calculator();
 *     
 *     // @ValueSource for simple single values
 *     @ParameterizedTest
 *     @ValueSource(ints = {2, 4, 6, 8, 100, 0, -2, -4})
 *     @DisplayName("Even numbers return true")
 *     void isEven_evenNumbers_returnsTrue(int number) {
 *         assertTrue(calculator.isEven(number));
 *     }
 *     
 *     @ParameterizedTest
 *     @ValueSource(ints = {1, 3, 5, 7, 99, -1, -3})
 *     @DisplayName("Odd numbers return false")
 *     void isEven_oddNumbers_returnsFalse(int number) {
 *         assertFalse(calculator.isEven(number));
 *     }
 *     
 *     // @CsvSource for multiple parameters
 *     @ParameterizedTest
 *     @CsvSource({
 *         "2, 3, 5",
 *         "0, 0, 0",
 *         "-1, 1, 0",
 *         "100, 200, 300",
 *         "-50, -50, -100"
 *     })
 *     @DisplayName("Addition with various inputs")
 *     void add_variousInputs_returnsCorrectSum(int a, int b, int expected) {
 *         assertEquals(expected, calculator.add(a, b));
 *     }
 *     
 *     @ParameterizedTest
 *     @CsvSource({
 *         "10, 2, 5",
 *         "15, 3, 5",
 *         "100, 10, 10",
 *         "7, 2, 3"  // Integer division
 *     })
 *     @DisplayName("Division with various inputs")
 *     void divide_variousInputs_returnsCorrectQuotient(int a, int b, int expected) {
 *         assertEquals(expected, calculator.divide(a, b));
 *     }
 *     
 *     // @MethodSource for complex test data
 *     @ParameterizedTest
 *     @MethodSource("factorialTestCases")
 *     @DisplayName("Factorial calculations")
 *     void factorial_variousInputs_returnsCorrectResult(int input, int expected) {
 *         assertEquals(expected, calculator.factorial(input));
 *     }
 *     
 *     static Stream<Arguments> factorialTestCases() {
 *         return Stream.of(
 *             Arguments.of(0, 1),
 *             Arguments.of(1, 1),
 *             Arguments.of(2, 2),
 *             Arguments.of(3, 6),
 *             Arguments.of(4, 24),
 *             Arguments.of(5, 120),
 *             Arguments.of(10, 3628800)
 *         );
 *     }
 * }
 */

/**
 * Example 3: String Utils Tests with Nested Classes
 * 
 * @DisplayName("StringUtils Tests")
 * class StringUtilsTest {
 *     
 *     @Nested
 *     @DisplayName("reverse() method")
 *     class ReverseTests {
 *         
 *         @Test
 *         @DisplayName("Reverses a normal string")
 *         void reverse_normalString_returnsReversed() {
 *             assertEquals("olleh", StringUtils.reverse("hello"));
 *         }
 *         
 *         @Test
 *         @DisplayName("Empty string returns empty")
 *         void reverse_emptyString_returnsEmpty() {
 *             assertEquals("", StringUtils.reverse(""));
 *         }
 *         
 *         @Test
 *         @DisplayName("Single character returns same")
 *         void reverse_singleChar_returnsSame() {
 *             assertEquals("a", StringUtils.reverse("a"));
 *         }
 *         
 *         @Test
 *         @DisplayName("Null throws NullPointerException")
 *         void reverse_null_throwsException() {
 *             assertThrows(NullPointerException.class,
 *                 () -> StringUtils.reverse(null));
 *         }
 *         
 *         @Test
 *         @DisplayName("Palindrome returns same")
 *         void reverse_palindrome_returnsSame() {
 *             assertEquals("radar", StringUtils.reverse("radar"));
 *         }
 *     }
 *     
 *     @Nested
 *     @DisplayName("isPalindrome() method")
 *     class PalindromeTests {
 *         
 *         @ParameterizedTest
 *         @ValueSource(strings = {"radar", "level", "A man a plan a canal Panama", "Was it a car or a cat I saw"})
 *         @DisplayName("Valid palindromes return true")
 *         void isPalindrome_validPalindromes_returnsTrue(String input) {
 *             assertTrue(StringUtils.isPalindrome(input));
 *         }
 *         
 *         @ParameterizedTest
 *         @ValueSource(strings = {"hello", "world", "java"})
 *         @DisplayName("Non-palindromes return false")
 *         void isPalindrome_nonPalindromes_returnsFalse(String input) {
 *             assertFalse(StringUtils.isPalindrome(input));
 *         }
 *         
 *         @Test
 *         @DisplayName("Null returns false")
 *         void isPalindrome_null_returnsFalse() {
 *             assertFalse(StringUtils.isPalindrome(null));
 *         }
 *     }
 *     
 *     @Nested
 *     @DisplayName("countWords() method")
 *     class CountWordsTests {
 *         
 *         @Test
 *         @DisplayName("Counts words in sentence")
 *         void countWords_normalSentence_returnsCount() {
 *             assertEquals(4, StringUtils.countWords("Hello world from Java"));
 *         }
 *         
 *         @Test
 *         @DisplayName("Empty string returns 0")
 *         void countWords_emptyString_returnsZero() {
 *             assertEquals(0, StringUtils.countWords(""));
 *         }
 *         
 *         @Test
 *         @DisplayName("Null returns 0")
 *         void countWords_null_returnsZero() {
 *             assertEquals(0, StringUtils.countWords(null));
 *         }
 *         
 *         @Test
 *         @DisplayName("Multiple spaces handled correctly")
 *         void countWords_multipleSpaces_returnsCorrectCount() {
 *             assertEquals(3, StringUtils.countWords("  hello   world   java  "));
 *         }
 *     }
 * }
 */

/**
 * Example 4: User Validation Tests
 * 
 * class UserTest {
 *     
 *     @Nested
 *     @DisplayName("User validation")
 *     class ValidationTests {
 *         
 *         @Test
 *         @DisplayName("Valid user returns true")
 *         void isValid_validUser_returnsTrue() {
 *             User user = new User("john", "john@email.com", 25);
 *             assertTrue(user.isValid());
 *         }
 *         
 *         @Test
 *         @DisplayName("Null username is invalid")
 *         void isValid_nullUsername_returnsFalse() {
 *             User user = new User(null, "john@email.com", 25);
 *             assertFalse(user.isValid());
 *         }
 *         
 *         @Test
 *         @DisplayName("Empty username is invalid")
 *         void isValid_emptyUsername_returnsFalse() {
 *             User user = new User("", "john@email.com", 25);
 *             assertFalse(user.isValid());
 *         }
 *         
 *         @Test
 *         @DisplayName("Invalid email is invalid")
 *         void isValid_invalidEmail_returnsFalse() {
 *             User user = new User("john", "invalid-email", 25);
 *             assertFalse(user.isValid());
 *         }
 *         
 *         @Test
 *         @DisplayName("Negative age is invalid")
 *         void isValid_negativeAge_returnsFalse() {
 *             User user = new User("john", "john@email.com", -1);
 *             assertFalse(user.isValid());
 *         }
 *         
 *         @ParameterizedTest
 *         @CsvSource({
 *             "john, john@email.com, 25, true",
 *             "'', john@email.com, 25, false",
 *             "john, invalid, 25, false",
 *             "john, john@email.com, -1, false",
 *             "john, john@email.com, 200, false"
 *         })
 *         @DisplayName("Various user validation scenarios")
 *         void isValid_variousScenarios(String username, String email, int age, boolean expected) {
 *             User user = new User(username, email, age);
 *             assertEquals(expected, user.isValid());
 *         }
 *     }
 *     
 *     @Nested
 *     @DisplayName("Adult check")
 *     class AdultTests {
 *         
 *         @ParameterizedTest
 *         @ValueSource(ints = {18, 21, 30, 65, 100})
 *         @DisplayName("Adults return true")
 *         void isAdult_adultAges_returnsTrue(int age) {
 *             User user = new User("test", "test@email.com", age);
 *             assertTrue(user.isAdult());
 *         }
 *         
 *         @ParameterizedTest
 *         @ValueSource(ints = {0, 5, 10, 17})
 *         @DisplayName("Minors return false")
 *         void isAdult_minorAges_returnsFalse(int age) {
 *             User user = new User("test", "test@email.com", age);
 *             assertFalse(user.isAdult());
 *         }
 *     }
 * }
 */

/**
 * Example 5: Mocking with UserService
 * 
 * @ExtendWith(MockitoExtension.class)
 * class UserServiceTest {
 *     
 *     @Mock
 *     private UserRepository userRepository;
 *     
 *     @InjectMocks
 *     private UserService userService;
 *     
 *     private User testUser;
 *     
 *     @BeforeEach
 *     void setUp() {
 *         testUser = new User("john", "john@email.com", 25);
 *     }
 *     
 *     // ========== getUser Tests ==========
 *     
 *     @Test
 *     @DisplayName("Get existing user returns user")
 *     void getUser_existingUser_returnsUser() {
 *         // Arrange
 *         when(userRepository.findById(1L)).thenReturn(testUser);
 *         
 *         // Act
 *         User result = userService.getUser(1L);
 *         
 *         // Assert
 *         assertNotNull(result);
 *         assertEquals("john", result.getUsername());
 *         verify(userRepository).findById(1L);
 *     }
 *     
 *     @Test
 *     @DisplayName("Get non-existing user throws exception")
 *     void getUser_nonExistingUser_throwsException() {
 *         // Arrange
 *         when(userRepository.findById(999L)).thenReturn(null);
 *         
 *         // Act & Assert
 *         RuntimeException exception = assertThrows(
 *             RuntimeException.class,
 *             () -> userService.getUser(999L)
 *         );
 *         assertTrue(exception.getMessage().contains("User not found"));
 *     }
 *     
 *     // ========== createUser Tests ==========
 *     
 *     @Test
 *     @DisplayName("Create new user saves and returns user")
 *     void createUser_newUser_savesAndReturns() {
 *         // Arrange
 *         when(userRepository.exists("newuser")).thenReturn(false);
 *         when(userRepository.save(any(User.class))).thenReturn(testUser);
 *         
 *         // Act
 *         User result = userService.createUser("newuser", "new@email.com", 30);
 *         
 *         // Assert
 *         assertNotNull(result);
 *         verify(userRepository).exists("newuser");
 *         verify(userRepository).save(any(User.class));
 *     }
 *     
 *     @Test
 *     @DisplayName("Create user with existing username throws exception")
 *     void createUser_existingUsername_throwsException() {
 *         // Arrange
 *         when(userRepository.exists("john")).thenReturn(true);
 *         
 *         // Act & Assert
 *         assertThrows(IllegalArgumentException.class,
 *             () -> userService.createUser("john", "john@email.com", 25));
 *         
 *         verify(userRepository, never()).save(any());
 *     }
 *     
 *     @Test
 *     @DisplayName("Create user with invalid data throws exception")
 *     void createUser_invalidData_throwsException() {
 *         // Arrange
 *         when(userRepository.exists("invalid")).thenReturn(false);
 *         
 *         // Act & Assert - invalid email
 *         assertThrows(IllegalArgumentException.class,
 *             () -> userService.createUser("invalid", "not-an-email", 25));
 *         
 *         verify(userRepository, never()).save(any());
 *     }
 *     
 *     // ========== deleteUser Tests ==========
 *     
 *     @Test
 *     @DisplayName("Delete existing user succeeds")
 *     void deleteUser_existingUser_deletesSuccessfully() {
 *         // Arrange
 *         when(userRepository.findById(1L)).thenReturn(testUser);
 *         
 *         // Act
 *         userService.deleteUser(1L);
 *         
 *         // Assert
 *         verify(userRepository).findById(1L);
 *         verify(userRepository).delete(1L);
 *     }
 *     
 *     @Test
 *     @DisplayName("Delete non-existing user throws exception")
 *     void deleteUser_nonExistingUser_throwsException() {
 *         // Arrange
 *         when(userRepository.findById(999L)).thenReturn(null);
 *         
 *         // Act & Assert
 *         assertThrows(RuntimeException.class,
 *             () -> userService.deleteUser(999L));
 *         
 *         verify(userRepository, never()).delete(anyLong());
 *     }
 * }
 */

/**
 * Example 6: Order Discount Tests with Complex Parameterization
 * 
 * class OrderTest {
 *     
 *     @ParameterizedTest
 *     @MethodSource("discountTestCases")
 *     @DisplayName("Order discount calculations")
 *     void calculateDiscount_variousScenarios(String id, double subtotal, 
 *             String customerType, String coupon, double expectedDiscount) {
 *         Order order = new Order(id, subtotal, customerType, coupon);
 *         assertEquals(expectedDiscount, order.calculateDiscount(), 0.01);
 *     }
 *     
 *     static Stream<Arguments> discountTestCases() {
 *         return Stream.of(
 *             // Regular customer, no coupon
 *             Arguments.of("ORD-1", 100.0, "regular", null, 0.0),
 *             
 *             // Premium customer, no coupon (10% off)
 *             Arguments.of("ORD-2", 100.0, "premium", null, 10.0),
 *             
 *             // VIP customer, no coupon (20% off)
 *             Arguments.of("ORD-3", 100.0, "vip", null, 20.0),
 *             
 *             // Regular customer with SAVE10 coupon (10% off)
 *             Arguments.of("ORD-4", 100.0, "regular", "SAVE10", 10.0),
 *             
 *             // Premium customer with SAVE10 coupon (10% + 10% = 20% off)
 *             Arguments.of("ORD-5", 100.0, "premium", "SAVE10", 20.0),
 *             
 *             // VIP with SAVE20 (20% + 20% = 40% off)
 *             Arguments.of("ORD-6", 100.0, "vip", "SAVE20", 40.0),
 *             
 *             // Regular with FLAT50 coupon
 *             Arguments.of("ORD-7", 100.0, "regular", "FLAT50", 50.0),
 *             
 *             // Discount capped at subtotal
 *             Arguments.of("ORD-8", 30.0, "vip", "FLAT50", 30.0)
 *         );
 *     }
 *     
 *     @Test
 *     @DisplayName("Total is subtotal minus discount")
 *     void getTotal_withDiscount_returnsCorrectTotal() {
 *         Order order = new Order("ORD-1", 100.0, "premium", "SAVE10");
 *         // 10% premium + 10% coupon = 20% off
 *         assertEquals(80.0, order.getTotal(), 0.01);
 *     }
 * }
 */


// ============================================================
// PART 3: MAIN CLASS - DEMONSTRATION
// ============================================================

public class JUnitDemo {
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║               JUnit 5 Testing Demonstration                ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        // Demo 1: Show the code we would test
        System.out.println("=== Code Under Test ===\n");
        
        Calculator calc = new Calculator();
        System.out.println("Calculator operations:");
        System.out.println("  add(2, 3) = " + calc.add(2, 3));
        System.out.println("  subtract(10, 4) = " + calc.subtract(10, 4));
        System.out.println("  multiply(3, 4) = " + calc.multiply(3, 4));
        System.out.println("  divide(15, 3) = " + calc.divide(15, 3));
        System.out.println("  isEven(4) = " + calc.isEven(4));
        System.out.println("  factorial(5) = " + calc.factorial(5));
        System.out.println();
        
        System.out.println("StringUtils operations:");
        System.out.println("  reverse(\"hello\") = " + StringUtils.reverse("hello"));
        System.out.println("  isPalindrome(\"radar\") = " + StringUtils.isPalindrome("radar"));
        System.out.println("  countWords(\"Hello World\") = " + StringUtils.countWords("Hello World"));
        System.out.println("  capitalize(\"jAVA\") = " + StringUtils.capitalize("jAVA"));
        System.out.println();
        
        // Demo 2: Show test structure
        System.out.println("=== Test Structure Example ===\n");
        
        System.out.println("""
            // Test file: CalculatorTest.java
            
            class CalculatorTest {
                
                private Calculator calculator;
                
                @BeforeEach
                void setUp() {
                    calculator = new Calculator();
                }
                
                @Test
                @DisplayName("Adding two positive numbers")
                void add_positiveNumbers_returnsSum() {
                    // Arrange
                    int a = 2, b = 3;
                    
                    // Act
                    int result = calculator.add(a, b);
                    
                    // Assert
                    assertEquals(5, result);
                }
                
                @Test
                @DisplayName("Division by zero throws exception")
                void divide_byZero_throwsException() {
                    assertThrows(IllegalArgumentException.class,
                        () -> calculator.divide(10, 0));
                }
            }
            """);
        
        // Demo 3: Show parameterized test example
        System.out.println("=== Parameterized Test Example ===\n");
        
        System.out.println("""
            @ParameterizedTest
            @CsvSource({
                "2, 3, 5",
                "0, 0, 0",
                "-1, 1, 0",
                "100, 200, 300"
            })
            void add_variousInputs_returnsCorrectSum(int a, int b, int expected) {
                assertEquals(expected, calculator.add(a, b));
            }
            """);
        
        // Demo 4: Show mocking example
        System.out.println("=== Mocking Example ===\n");
        
        System.out.println("""
            @ExtendWith(MockitoExtension.class)
            class UserServiceTest {
                
                @Mock
                private UserRepository userRepository;
                
                @InjectMocks
                private UserService userService;
                
                @Test
                void getUser_existingUser_returnsUser() {
                    // Arrange - stub the mock
                    User mockUser = new User("john", "john@email.com", 25);
                    when(userRepository.findById(1L)).thenReturn(mockUser);
                    
                    // Act
                    User result = userService.getUser(1L);
                    
                    // Assert
                    assertEquals("john", result.getUsername());
                    verify(userRepository).findById(1L);
                }
            }
            """);
        
        // Demo 5: Show project structure
        System.out.println("=== Recommended Project Structure ===\n");
        
        System.out.println("""
            my-project/
            ├── src/
            │   ├── main/
            │   │   └── java/
            │   │       └── com/
            │   │           └── example/
            │   │               ├── Calculator.java
            │   │               ├── StringUtils.java
            │   │               ├── User.java
            │   │               └── UserService.java
            │   └── test/
            │       └── java/
            │           └── com/
            │               └── example/
            │                   ├── CalculatorTest.java
            │                   ├── StringUtilsTest.java
            │                   ├── UserTest.java
            │                   └── UserServiceTest.java
            ├── pom.xml (or build.gradle)
            """);
        
        // Demo 6: Show Maven commands
        System.out.println("=== Running Tests ===\n");
        
        System.out.println("""
            # Run all tests
            mvn test
            
            # Run specific test class
            mvn test -Dtest=CalculatorTest
            
            # Run specific test method
            mvn test -Dtest=CalculatorTest#add_positiveNumbers_returnsSum
            
            # Run with verbose output
            mvn test -X
            
            # Generate test report
            mvn surefire-report:report
            """);
        
        // Demo 7: Key annotations summary
        System.out.println("=== Key JUnit 5 Annotations ===\n");
        
        System.out.println("""
            ┌────────────────────┬────────────────────────────────────────┐
            │ Annotation         │ Purpose                                │
            ├────────────────────┼────────────────────────────────────────┤
            │ @Test              │ Mark method as test                    │
            │ @DisplayName       │ Custom test name                       │
            │ @BeforeEach        │ Run before each test                   │
            │ @AfterEach         │ Run after each test                    │
            │ @BeforeAll         │ Run once before all tests              │
            │ @AfterAll          │ Run once after all tests               │
            │ @Nested            │ Group related tests                    │
            │ @Disabled          │ Skip a test                            │
            │ @ParameterizedTest │ Run test with multiple inputs          │
            │ @ValueSource       │ Provide simple test values             │
            │ @CsvSource         │ Provide CSV test data                  │
            │ @MethodSource      │ Provide test data from method          │
            └────────────────────┴────────────────────────────────────────┘
            """);
        
        // Demo 8: Key assertions
        System.out.println("=== Key Assertions ===\n");
        
        System.out.println("""
            assertEquals(expected, actual)      - Check equality
            assertNotEquals(expected, actual)   - Check inequality
            assertTrue(condition)               - Check true
            assertFalse(condition)              - Check false
            assertNull(object)                  - Check null
            assertNotNull(object)               - Check not null
            assertThrows(Exception.class, ...)  - Check exception thrown
            assertDoesNotThrow(...)             - Check no exception
            assertAll(...)                      - Run multiple assertions
            assertTimeout(Duration, ...)        - Check within time limit
            """);
        
        System.out.println("=== Demo Complete ===\n");
        System.out.println("To practice JUnit testing:");
        System.out.println("1. Create a Maven or Gradle project");
        System.out.println("2. Add JUnit 5 dependencies");
        System.out.println("3. Write tests in src/test/java");
        System.out.println("4. Run tests with 'mvn test' or 'gradle test'");
        System.out.println();
        System.out.println("See Exercises.md for hands-on practice problems!");
    }
}
