# Class 3: Operators 🧮

Welcome to **Class 3** of the Java Learning Journey! In this class, you'll learn about **operators** - symbols that let you perform calculations, comparisons, and logical operations on your variables.

---

## 📌 What You'll Learn

- Arithmetic operators (+, -, *, /, %)
- Assignment operators (=, +=, -=, etc.)
- Comparison operators (==, !=, <, >, <=, >=)
- Logical operators (&&, ||, !)
- Increment/Decrement operators (++, --)
- Operator precedence (order of operations)
- How to use parentheses to control order

---

## 🎯 Why Operators Matter

Without operators, variables would just sit there storing data. Operators let you:
- **Calculate** values (3 + 5 = 8)
- **Compare** values (age > 18?)
- **Make decisions** (is it raining AND cold?)
- **Modify** values (score += 10)

---

## 📋 The Complete Code Example

```java
public class Operators {
    
    public static void main(String[] args) {
        
        // ============================================
        // ARITHMETIC OPERATORS
        // ============================================
        int a = 20;
        int b = 3;
        
        int addition = a + b;      // 23
        int subtraction = a - b;   // 17
        int multiplication = a * b; // 60
        int division = a / b;      // 6 (integer division)
        int modulo = a % b;        // 2 (remainder)
        
        System.out.println("=== ARITHMETIC OPERATORS ===");
        System.out.println(a + " + " + b + " = " + addition);
        System.out.println(a + " - " + b + " = " + subtraction);
        System.out.println(a + " * " + b + " = " + multiplication);
        System.out.println(a + " / " + b + " = " + division);
        System.out.println(a + " % " + b + " = " + modulo);
        
        
        // ============================================
        // COMPARISON OPERATORS (return boolean)
        // ============================================
        boolean equal = (a == b);              // false
        boolean notEqual = (a != b);           // true
        boolean greaterThan = (a > b);         // true
        boolean lessThan = (a < b);            // false
        boolean greaterOrEqual = (a >= b);     // true
        boolean lessOrEqual = (a <= b);        // false
        
        System.out.println("\n=== COMPARISON OPERATORS ===");
        System.out.println(a + " == " + b + " : " + equal);
        System.out.println(a + " != " + b + " : " + notEqual);
        System.out.println(a + " > " + b + " : " + greaterThan);
        System.out.println(a + " < " + b + " : " + lessThan);
        System.out.println(a + " >= " + b + " : " + greaterOrEqual);
        System.out.println(a + " <= " + b + " : " + lessOrEqual);
        
        
        // ============================================
        // LOGICAL OPERATORS
        // ============================================
        boolean isStudent = true;
        boolean hasPermission = true;
        boolean isWeekend = false;
        
        boolean andResult = (isStudent && hasPermission);  // true (both true)
        boolean orResult = (isStudent || isWeekend);       // true (at least one true)
        boolean notResult = !isWeekend;                    // true (flips false to true)
        
        System.out.println("\n=== LOGICAL OPERATORS ===");
        System.out.println("isStudent: " + isStudent);
        System.out.println("hasPermission: " + hasPermission);
        System.out.println("isWeekend: " + isWeekend);
        System.out.println("isStudent && hasPermission: " + andResult);
        System.out.println("isStudent || isWeekend: " + orResult);
        System.out.println("!isWeekend: " + notResult);
        
        
        // ============================================
        // ASSIGNMENT OPERATORS
        // ============================================
        int score = 100;
        score += 10;  // score = score + 10 = 110
        score -= 5;   // score = score - 5 = 105
        score *= 2;   // score = score * 2 = 210
        score /= 3;   // score = score / 3 = 70
        
        System.out.println("\n=== ASSIGNMENT OPERATORS ===");
        System.out.println("After operations, score = " + score);
        
        
        // ============================================
        // INCREMENT & DECREMENT OPERATORS
        // ============================================
        int counter = 5;
        int counter2 = 5;
        
        // Postfix: use value first, then increment
        int result1 = counter++;  // result1 = 5, then counter = 6
        
        // Prefix: increment first, then use value
        int result2 = ++counter2; // counter2 = 6, then result2 = 6
        
        System.out.println("\n=== INCREMENT/DECREMENT ===");
        System.out.println("Postfix counter++: result1 = " + result1 + ", counter = " + counter);
        System.out.println("Prefix ++counter2: result2 = " + result2 + ", counter2 = " + counter2);
        
        int decrementTest = 10;
        decrementTest--;
        System.out.println("After decrement--: " + decrementTest);
        
        
        // ============================================
        // OPERATOR PRECEDENCE
        // ============================================
        int result3 = 2 + 3 * 4;      // Multiplication first: 2 + 12 = 14
        int result4 = (2 + 3) * 4;    // Parentheses first: 5 * 4 = 20
        
        System.out.println("\n=== OPERATOR PRECEDENCE ===");
        System.out.println("2 + 3 * 4 = " + result3 + " (multiply first)");
        System.out.println("(2 + 3) * 4 = " + result4 + " (parentheses first)");
    }
}
```

**Expected Output:**
```
=== ARITHMETIC OPERATORS ===
20 + 3 = 23
20 - 3 = 17
20 * 3 = 60
20 / 3 = 6
20 % 3 = 2

=== COMPARISON OPERATORS ===
20 == 3 : false
20 != 3 : true
20 > 3 : true
20 < 3 : false
20 >= 3 : true
20 <= 3 : false

=== LOGICAL OPERATORS ===
isStudent: true
hasPermission: true
isWeekend: false
isStudent && hasPermission: true
isStudent || isWeekend: true
!isWeekend: true

=== ASSIGNMENT OPERATORS ===
After operations, score = 70

=== INCREMENT/DECREMENT ===
Postfix counter++: result1 = 5, counter = 6
Prefix ++counter2: result2 = 6, counter2 = 6
After decrement--: 9

=== OPERATOR PRECEDENCE ===
2 + 3 * 4 = 14 (multiply first)
(2 + 3) * 4 = 20 (parentheses first)
```

---

## 🔍 Line-by-Line Explanation

### **Arithmetic Operators**

Operators that perform mathematical calculations.

#### **`+` (Addition)**
```java
int sum = 20 + 3;  // Result: 23
```
- **Meaning:** Adds two values
- **Works with:** int, long, double, float
- **Also:** Concatenates strings: `"Hello" + " World"` = `"Hello World"`

#### **`-` (Subtraction)**
```java
int diff = 20 - 3;  // Result: 17
```
- **Meaning:** Subtracts right value from left value
- **Order matters:** `5 - 3` ≠ `3 - 5`

#### **`*` (Multiplication)**
```java
int product = 20 * 3;  // Result: 60
```
- **Meaning:** Multiplies two values
- **Order doesn't matter:** `20 * 3` = `3 * 20`

#### **`/` (Division)**
```java
int quotient = 20 / 3;  // Result: 6 (NOT 6.666...)
```
- **Meaning:** Divides left by right
- **Important:** Integer division discards decimals
- **With decimals:** `20.0 / 3` = `6.666...`

#### **`%` (Modulo - Remainder)**
```java
int remainder = 20 % 3;  // Result: 2
```
- **Meaning:** Gives remainder after division
- **Example:** `20 ÷ 3 = 6 remainder 2`
- **Use case:** Check if number is even: `num % 2 == 0`

---

### **Comparison Operators**

Operators that compare two values and return `true` or `false`.

#### **`==` (Equal To)**
```java
boolean isEqual = (20 == 20);  // true
boolean isEqual = (20 == 3);   // false
```
- **Meaning:** Are the two values the same?
- **⚠️ Important:** Use `==` to compare, NOT `=`
  - `=` assigns value
  - `==` compares values

#### **`!=` (Not Equal To)**
```java
boolean notEqual = (20 != 3);   // true
boolean notEqual = (20 != 20);  // false
```
- **Meaning:** Are the two values different?
- **Opposite of:** `==`

#### **`>` (Greater Than)**
```java
boolean greater = (20 > 3);   // true
boolean greater = (3 > 20);   // false
boolean greater = (20 > 20);  // false
```
- **Meaning:** Is left value larger than right?

#### **`<` (Less Than)**
```java
boolean less = (3 < 20);   // true
boolean less = (20 < 3);   // false
```
- **Meaning:** Is left value smaller than right?

#### **`>=` (Greater Than or Equal To)**
```java
boolean ge = (20 >= 20);  // true
boolean ge = (20 >= 3);   // true
boolean ge = (3 >= 20);   // false
```
- **Meaning:** Is left ≥ right?

#### **`<=` (Less Than or Equal To)**
```java
boolean le = (20 <= 20);  // true
boolean le = (3 <= 20);   // true
boolean le = (20 <= 3);   // false
```
- **Meaning:** Is left ≤ right?

---

### **Logical Operators**

Operators that combine boolean values (true/false).

#### **`&&` (Logical AND)**
```java
boolean result = (true && true);    // true
boolean result = (true && false);   // false
boolean result = (false && false);  // false
```
- **Meaning:** TRUE only if BOTH are true
- **Truth table:**
  ```
  true  && true  = true
  true  && false = false
  false && true  = false
  false && false = false
  ```

**Real example:**
```java
int age = 19;
boolean hasLicense = true;

if (age >= 18 && hasLicense) {
    System.out.println("Can drive");  // This prints
}
```

#### **`||` (Logical OR)**
```java
boolean result = (true || false);   // true
boolean result = (false || false);  // false
boolean result = (true || true);    // true
```
- **Meaning:** TRUE if AT LEAST ONE is true
- **Truth table:**
  ```
  true  || true  = true
  true  || false = true
  false || true  = true
  false || false = false
  ```

**Real example:**
```java
boolean isWeekend = false;
boolean isHoliday = true;

if (isWeekend || isHoliday) {
    System.out.println("No work today");  // This prints
}
```

#### **`!` (Logical NOT)**
```java
boolean result = !true;   // false
boolean result = !false;  // true
```
- **Meaning:** Flips the boolean value
- **Truth table:**
  ```
  !true  = false
  !false = true
  ```

**Real example:**
```java
boolean isRaining = true;

if (!isRaining) {
    System.out.println("Go outside");  // Doesn't print
}
```

---

### **Assignment Operators**

Operators that assign or modify a variable's value.

#### **`=` (Simple Assignment)**
```java
int score = 100;  // Assign 100 to score
```
- **Meaning:** Set variable to a value
- **Flow:** Right side → Left side

#### **`+=` (Add and Assign)**
```java
int score = 100;
score += 10;  // Same as: score = score + 10;
// Now score = 110
```

#### **`-=` (Subtract and Assign)**
```java
score -= 5;   // score = score - 5;
```

#### **`*=` (Multiply and Assign)**
```java
score *= 2;   // score = score * 2;
```

#### **`/=` (Divide and Assign)**
```java
score /= 3;   // score = score / 3;
```

#### **`%=` (Modulo and Assign)**
```java
score %= 10;  // score = score % 10;
```

---

### **Increment & Decrement Operators**

Special operators that increase or decrease by 1.

#### **`++` (Increment - increase by 1)**

**Postfix version (`counter++`):**
```java
int counter = 5;
int result = counter++;  // Use value first (5), then increment
// result = 5, counter = 6
```

**Prefix version (`++counter`):**
```java
int counter = 5;
int result = ++counter;  // Increment first, then use value
// result = 6, counter = 6
```

#### **`--` (Decrement - decrease by 1)**

**Postfix version (`counter--`):**
```java
int counter = 5;
int result = counter--;  // Use value first (5), then decrement
// result = 5, counter = 4
```

**Prefix version (`--counter`):**
```java
int counter = 5;
int result = --counter;  // Decrement first, then use value
// result = 4, counter = 4
```

**Simple usage (most common):**
```java
counter++;   // Just increment by 1
counter--;   // Just decrement by 1
```

---

### **Operator Precedence (Order of Operations)**

When multiple operators are in one expression, which one executes first?

**Priority (Highest to Lowest):**
1. **Parentheses** `()`
2. **Multiplication, Division, Modulo** `*, /, %`
3. **Addition, Subtraction** `+, -`
4. **Comparison** `<, >, <=, >=, ==, !=`
5. **Logical AND** `&&`
6. **Logical OR** `||`

**Examples:**

```java
// Example 1: Multiplication before addition
int result = 2 + 3 * 4;   // 3 * 4 = 12, then 2 + 12 = 14

// Example 2: Parentheses override precedence
int result = (2 + 3) * 4; // 2 + 3 = 5, then 5 * 4 = 20

// Example 3: Left-to-right for same precedence
int result = 10 - 3 + 2;  // 10 - 3 = 7, then 7 + 2 = 9

// Example 4: Complex with precedence
int result = 2 + 3 * 4 - 1;  // Step 1: 3 * 4 = 12
                              // Step 2: 2 + 12 = 14
                              // Step 3: 14 - 1 = 13

// Example 5: Use parentheses for clarity
int result = 2 + (3 * 4) - 1;  // Makes it clear!
```

**Pro tip:** When unsure, use parentheses for clarity!

---

## ⚠️ Common Mistakes

### ❌ Mistake 1: Using `=` instead of `==`
```java
if (age = 18) { }   // ERROR! Assigns instead of compares
if (age == 18) { }  // ✓ CORRECT
```

### ❌ Mistake 2: Forgetting `&&` vs `&`
```java
if (age > 18 & hasLicense) { }  // Bitwise AND (wrong context)
if (age > 18 && hasLicense) { } // ✓ Logical AND (correct)
```

### ❌ Mistake 3: Integer division losing decimals
```java
int result = 7 / 2;      // Result: 3 (not 3.5!)
double result = 7.0 / 2; // ✓ Result: 3.5
```

### ❌ Mistake 4: Postfix vs Prefix confusion
```java
int x = 5;
int y = x++;  // y = 5, x = 6 (postfix)

int a = 5;
int b = ++a;  // b = 6, a = 6 (prefix)
```

### ❌ Mistake 5: Incorrect operator precedence
```java
int result = 2 + 3 * 4;  // Correct: 14 (not 20)
// Without thinking, you might calculate: 2 + 3 = 5, then 5 * 4 = 20 (WRONG!)
// Actually: 3 * 4 = 12, then 2 + 12 = 14 (RIGHT!)
```

---

## 💻 How to Run

1. Save as `Operators.java`
2. Compile:
   ```bash
   javac Operators.java
   ```
3. Run:
   ```bash
   java Operators
   ```

---

## 📚 Operators at a Glance

| Category | Operators | Examples |
|----------|-----------|----------|
| **Arithmetic** | `+, -, *, /, %` | `a + b`, `x % 3` |
| **Comparison** | `==, !=, <, >, <=, >=` | `age > 18`, `score == 100` |
| **Logical** | `&&, ||, !` | `a && b`, `!isTrue` |
| **Assignment** | `=, +=, -=, *=, /=, %=` | `score += 10` |
| **Increment/Decrement** | `++, --` | `i++`, `--count` |

---

## 🎓 Self-Check Questions

1. What's the difference between `==` and `=`?
2. What does `5 % 2` return?
3. Will `5 / 2` give `2.5` or `2`?
4. What does `!true` return?
5. What's the difference between `x++` and `++x`?
6. In expression `2 + 3 * 4`, which operation happens first?
7. When would you use `&&` vs `||`?
8. What does `score += 5` do?

---

## 🔑 Key Takeaways

✅ **Arithmetic operators** do math
✅ **Comparison operators** return true/false
✅ **Logical operators** combine booleans
✅ **Assignment operators** modify variables
✅ **Increment/Decrement** add or subtract 1
✅ **Precedence** matters: `*` before `+`
✅ **Parentheses** override precedence
✅ Use **descriptive code** with clear operators

---

## 🚀 What's Next?

Now that you understand operators, you're ready for:
- **Class 4:** Input/Output (getting user input)
- **Class 5:** Comments and Documentation
- **Class 6:** Conditional Statements (if/else using comparisons!)

---

## 📖 Further Reading

- [Oracle Java Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html)
- [Java Operator Precedence](https://www.w3schools.com/java/java_operators_precedence.asp)
- [Increment/Decrement Operators](https://www.programiz.com/java-programming/increment-decrement-operators)

---

**Happy Learning! 🎉**

Operators are the foundation of all calculations and logic in programming. Master these and you'll be able to build powerful programs!
