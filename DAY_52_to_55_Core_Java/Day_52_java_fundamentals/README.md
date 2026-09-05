# 🚀 100 Days Full Stack Challenge — Day 52

# ☕ Core Java — Day 52

## 📌 Focus

Java Fundamentals, Program Structure, `main()` Method, Data Types, Type Casting, Methods, Conditions, Loops, and Basic Pattern Programming.

---

## 🎯 Day 52 Objectives

- Understand the basic structure of a Java program.
- Understand the `main()` method.
- Practice Java primitive data types.
- Take input using `Scanner`.
- Practice arithmetic operations.
- Understand type casting.
- Understand methods and method invocation.
- Practice parameters and return values.
- Practice conditions.
- Practice loops.
- Practice nested loops.
- Practice basic pattern programming.

---

# 📁 Project Structure

    src/
    └── day52/
        ├── Main.java
        ├── Basic.java
        ├── DataTypes.java
        ├── TypeCasting.java
        └── Methods.java

---

# 1️⃣ Basic Java Program

## 📄 File

`Basic.java`

## 🔹 Concepts Practiced

- Class declaration
- Static methods
- Variables
- `System.out.println()`
- Arithmetic operators
- Integer division
- Method execution

## 🔹 Practice

The `Basic` class contains a simple method that demonstrates basic Java statements and arithmetic operations.

The program performs:

- Addition
- Subtraction
- Multiplication
- Division

Example calculation:

    int a = 10;
    int b = 20;

    a + b
    b - a
    a * b
    b / a

---

# 2️⃣ Java Data Types

## 📄 File

`DataTypes.java`

## 🔹 Primitive Data Types Practiced

    byte
    short
    int
    long
    float
    double
    char

## 🔹 Scanner Input

The `Scanner` class is used to receive input from the user.

Methods practiced:

    nextByte()
    nextShort()
    nextInt()
    nextLong()
    nextFloat()
    nextDouble()
    next()
    charAt(0)

## 🔹 Character Input

Character input is handled using:

    sc.next().charAt(0);

`next()` reads the input as a String and `charAt(0)` extracts the first character.

---

# 3️⃣ Type Casting

## 📄 File

`TypeCasting.java`

## 🔹 Concepts Practiced

- Primitive type conversion
- Widening casting
- Narrowing casting
- Automatic conversion
- Explicit conversion

## 🔹 Widening Casting

Widening conversion happens when a smaller compatible data type is converted into a larger data type.

General flow:

    byte
      ↓
    short
      ↓
    int
      ↓
    long
      ↓
    float
      ↓
    double

Widening conversion generally happens automatically.

## 🔹 Narrowing Casting

Narrowing conversion converts a larger data type into a smaller data type.

It requires explicit casting.

Example:

    int value = 100;
    byte result = (byte) value;

## ⚠️ Real-World Gotcha

Narrowing conversion can result in:

- Data loss
- Precision loss
- Overflow

Therefore, explicit casting should be used carefully.

---

# 4️⃣ Methods

## 📄 File

`Methods.java`

## 🔹 Concepts Practiced

- Method declaration
- Method invocation
- Parameters
- Return values
- `void` methods
- Methods returning values
- Conditions
- Loops
- Nested loops
- Pattern programming

---

## 🔹 Methods Implemented

### `printGreeting()`

Prints a greeting message.

### `addNumbers(int a, int b)`

Adds two numbers and returns the result.

### `subtraction(int a, int b)`

Performs subtraction and returns the result.

### `mulNumbers(int a, int b)`

Multiplies two numbers and returns the result.

### `printSquarePattern(int n)`

Prints a square pattern using nested loops.

### `printMaxNumber(int a, int b)`

Compares two numbers and returns the larger value.

### `squareOfNumber(int n)`

Returns the square of a number.

### `cubeOfNumber(int n)`

Returns the cube of a number.

---

# 5️⃣ Method Without Return Value

Example concept:

    public static void printGreeting()

A `void` method performs an operation but does not return a value.

---

# 6️⃣ Method With Parameters

Example concept:

    public static int addNumbers(int a, int b)

Parameters allow data to be passed into a method.

For example:

    addNumbers(10, 20)

Here:

    10 → a
    20 → b

---

# 7️⃣ Method With Return Value

Example:

    public static int squareOfNumber(int n)

The method performs a calculation and returns an integer value.

Example:

    squareOfNumber(5)

Result:

    25

---

# 8️⃣ Conditional Statements

The Day 52 practice includes conditional logic using `if-else`.

Example concept:

    if (a > b) {
        return a;
    } else {
        return b;
    }

This logic is used to determine the maximum of two numbers.

---

# 9️⃣ Loops

The Day 52 practice includes `for` loops.

General syntax:

    for (initialization; condition; update) {
        // statements
    }

Example flow:

    initialization
         ↓
    condition
         ↓
    execute body
         ↓
    update
         ↓
    condition
         ↓
    repeat

---

# 🔟 Nested Loops

Nested loops were used for pattern programming.

General structure:

    Outer Loop
        ↓
        Inner Loop
            ↓
            Execute statements

The outer loop generally controls rows.

The inner loop generally controls columns.

---

# 1️⃣1️⃣ Square Pattern

A square pattern was implemented using nested loops.

For `n = 5`, the output is:

    *****
    *****
    *****
    *****
    *****

This provides the foundation for more advanced pattern-programming problems.

---

# 1️⃣2️⃣ Main Method

## 📄 File

`Main.java`

The `main()` method is the entry point of a standard Java application.

Signature:

    public static void main(String[] args)

The `Main` class is used to execute the required Day 52 practice program.

Different programs can be executed by calling their methods.

Example:

    Basic.runProgram1();
    DataTypes.runProgram2();
    TypeCasting.runProgram3();
    Methods.runProgran4();

---

# 1️⃣3️⃣ Day 52 Execution Flow

    Main.java
        ↓
    main()
        ↓
    Select required program
        ↓
    Call method
        ↓
    Program executes
        ↓
    Output

---

# 🧠 Core Java Concepts Learned

## Java Program Structure

    Class
       ↓
    Method
       ↓
    Statements
       ↓
    Output

## Method Structure

    Access Modifier
         ↓
    static
         ↓
    Return Type
         ↓
    Method Name
         ↓
    Parameters
         ↓
    Method Body

---

# ⚠️ Areas To Improve

The Day 52 implementation focuses on fundamentals.

Future practice will improve:

- Naming conventions
- Input handling
- Conditions
- Loops
- Pattern programming
- Arrays
- Strings
- Built-in methods
- Method overloading
- Encapsulation
- Constructors
- Static keyword
- Inheritance
- Constructor chaining
- Method overriding
- Polymorphism
- Abstract classes
- Interfaces
- Lambda expressions
- Functional interfaces
- Exception handling
- Multithreading
- Collections

---

# 📝 Day 52 Summary

Today I practiced the fundamental concepts required to continue with Core Java.

## Covered

- Java program structure
- Classes
- Methods
- `main()`
- Variables
- Primitive data types
- Scanner input
- Type casting
- Widening casting
- Narrowing casting
- Arithmetic operations
- Conditions
- `for` loops
- Nested loops
- Pattern programming
- Method parameters
- Return values
- Basic reusable methods

---

# 🚀 Next

## Day 53

### Core Java

Continue with:

- Conditions
- Loops
- Pattern programming
- Arrays
- Array traversal
- Array built-in methods
- More real-world practice problems

### Backend Companion

Continue JDBC with:

- CRUD improvement
- `PreparedStatement`
- Parameterized queries
- SQL injection prevention
- Better resource management

---

# 📅 Challenge Information

**Challenge:** 100 Days Full Stack Challenge

**Day:** 52

**Track:** Core Java

**Phase:** Phase 1 — Java Backend

**Status:** ✅ Completed

---

⭐ Keep Coding. Keep Building. Keep Improving.
