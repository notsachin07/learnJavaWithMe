/**
 * Class 3: Operators
 *
 * Demonstrates all types of operators in Java:
 * - Arithmetic operators (+, -, *, /, %)
 * - Comparison operators (==, !=, <, >, <=, >=)
 * - Logical operators (&&, ||, !)
 * - Assignment operators (=, +=, -=, *=, /=, %=)
 * - Increment/Decrement operators (++, --)
 * - Operator precedence
 *
 * How to run:
 * 1. Save as: Operators.java
 * 2. Compile: javac Operators.java
 * 3. Run:    java Operators
 */

public class Operators {

    public static void main(String[] args) {

        // ================================================
        // ARITHMETIC OPERATORS
        // ================================================
        int a = 20;
        int b = 3;

        int addition = a + b;        // 23
        int subtraction = a - b;     // 17
        int multiplication = a * b;  // 60
        int division = a / b;        // 6 (integer division)
        int modulo = a % b;          // 2 (remainder)

        System.out.println("========== ARITHMETIC OPERATORS ==========");
        System.out.println(a + " + " + b + " = " + addition);
        System.out.println(a + " - " + b + " = " + subtraction);
        System.out.println(a + " * " + b + " = " + multiplication);
        System.out.println(a + " / " + b + " = " + division);
        System.out.println(a + " % " + b + " = " + modulo);


        // ================================================
        // COMPARISON OPERATORS (return boolean)
        // ================================================
        boolean equal = (a == b);        // false
        boolean notEqual = (a != b);     // true
        boolean greaterThan = (a > b);   // true
        boolean lessThan = (a < b);      // false
        boolean geOrEq = (a >= b);       // true
        boolean leOrEq = (a <= b);       // false

        System.out.println("\n========== COMPARISON OPERATORS ==========");
        System.out.println(a + " == " + b + " : " + equal);
        System.out.println(a + " != " + b + " : " + notEqual);
        System.out.println(a + " > " + b + " : " + greaterThan);
        System.out.println(a + " < " + b + " : " + lessThan);
        System.out.println(a + " >= " + b + " : " + geOrEq);
        System.out.println(a + " <= " + b + " : " + leOrEq);


        // ================================================
        // LOGICAL OPERATORS
        // ================================================
        boolean isStudent = true;
        boolean hasPermission = true;
        boolean isWeekend = false;

        boolean andResult = (isStudent && hasPermission);  // true
        boolean orResult = (isStudent || isWeekend);       // true
        boolean notResult = !isWeekend;                    // true

        System.out.println("\n========== LOGICAL OPERATORS ==========");
        System.out.println("isStudent: " + isStudent);
        System.out.println("hasPermission: " + hasPermission);
        System.out.println("isWeekend: " + isWeekend);
        System.out.println("isStudent && hasPermission: " + andResult);
        System.out.println("isStudent || isWeekend: " + orResult);
        System.out.println("!isWeekend: " + notResult);


        // ================================================
        // ASSIGNMENT OPERATORS
        // ================================================
        int score = 100;
        System.out.println("\n========== ASSIGNMENT OPERATORS ==========");
        System.out.println("Initial score: " + score);

        score += 10;  // score = score + 10 = 110
        System.out.println("After score += 10: " + score);

        score -= 5;   // score = score - 5 = 105
        System.out.println("After score -= 5: " + score);

        score *= 2;   // score = score * 2 = 210
        System.out.println("After score *= 2: " + score);

        score /= 3;   // score = score / 3 = 70
        System.out.println("After score /= 3: " + score);

        score %= 30;  // score = score % 30 = 10
        System.out.println("After score %= 30: " + score);


        // ================================================
        // INCREMENT & DECREMENT OPERATORS
        // ================================================
        System.out.println("\n========== INCREMENT/DECREMENT OPERATORS ==========");

        int counter = 5;
        System.out.println("Initial counter: " + counter);

        // Postfix increment
        int result1 = counter++;  // result1 gets 5, then counter becomes 6
        System.out.println("counter++: result1 = " + result1 + ", counter = " + counter);

        // Reset for prefix example
        int counter2 = 5;

        // Prefix increment
        int result2 = ++counter2;  // counter2 becomes 6, then result2 gets 6
        System.out.println("++counter2: result2 = " + result2 + ", counter2 = " + counter2);

        // Decrement examples
        int decrementTest = 10;
        System.out.println("\nInitial decrementTest: " + decrementTest);
        decrementTest--;
        System.out.println("After decrementTest--: " + decrementTest);


        // ================================================
        // OPERATOR PRECEDENCE
        // ================================================
        System.out.println("\n========== OPERATOR PRECEDENCE ==========");

        int result3 = 2 + 3 * 4;      // Multiplication first: 3*4=12, then 2+12=14
        int result4 = (2 + 3) * 4;    // Parentheses first: 2+3=5, then 5*4=20
        int result5 = 10 - 3 + 2;     // Left to right: 10-3=7, then 7+2=9
        int result6 = 20 / 4 * 2;     // Left to right: 20/4=5, then 5*2=10

        System.out.println("2 + 3 * 4 = " + result3 + " (* first: 3*4=12, 2+12=14)");
        System.out.println("(2 + 3) * 4 = " + result4 + " (parentheses first: 5*4)");
        System.out.println("10 - 3 + 2 = " + result5 + " (left to right)");
        System.out.println("20 / 4 * 2 = " + result6 + " (left to right)");


        // ================================================
        // COMPLEX EXPRESSIONS
        // ================================================
        System.out.println("\n========== COMPLEX EXPRESSIONS ==========");

        int x = 10, y = 5;
        boolean complexLogic = (x > y) && (x + y > 14) || !false;
        System.out.println("(10 > 5) && (10+5 > 14) || !false = " + complexLogic);

        int age = 20;
        int yearsExperience = 3;
        boolean canApply = (age >= 18) && (yearsExperience >= 2);
        System.out.println("Can apply for job (age>=18 && exp>=2): " + canApply);
    }
}
