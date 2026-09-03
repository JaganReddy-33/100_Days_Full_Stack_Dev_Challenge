
````markdown
# ☕ 100 Days of Code — Day 53: Core Java

> **Focus:** Conditional Statements, Loops & Pattern Programming  
> **Phase:** Core Java  
> **Day:** 53

---

## 🎯 Day 53 Objective

The goal of Day 53 was to strengthen Java control-flow fundamentals by practicing:

- Conditional statements
- Logical conditions
- Ternary operator
- `switch`
- `for` loops
- `while` loops
- `do-while` loops
- Nested loops
- `break`
- `continue`
- Pattern programming

The focus was not only on syntax, but also on writing multiple small programs inside organized methods and understanding how control flow is used in real applications.

---

## 📚 Topics Covered

### 1. Conditional Statements

Practiced different decision-making mechanisms in Java.

#### `if` Statement

Used when a block of code should execute only when a condition is true.

Examples practiced:

- Age-based eligibility
- Salary-based benefits
- Marks-based conditions

#### `if-else`

Used when one block should execute when the condition is true and another when it is false.

Examples practiced:

- Even or odd number
- Voting eligibility
- Minimum account balance

#### `else-if`

Used for checking multiple conditions sequentially.

Examples practiced:

- Grade calculation
- Salary levels
- Temperature classification

#### Nested `if`

Used when one condition depends on another condition.

Examples practiced:

- Driving eligibility based on age and license
- Exam eligibility based on marks and attendance
- Employee benefits based on salary and experience

---

## 🔀 2. Switch Statements

Practiced `switch` for selecting one execution path from multiple options.

Implemented examples using:

- Integer values
- Character values
- String values

Real-world scenarios included:

- Department selection
- Day selection
- Grade classification
- User roles
- Payment methods
- Transaction status

---

## 🧠 3. Multiple Conditions

Practiced logical operators with conditional statements.

### Logical AND `&&`

Used when multiple conditions must be true simultaneously.

Examples:

- Loan eligibility
- Exam eligibility
- Account verification

This helped understand how multiple business rules can be combined into a single condition.

---

## ⚡ 4. Ternary Operator

Practiced the short-form conditional operator.

Used for simple decisions such as:

- Even or odd
- Age eligibility
- Salary bonus eligibility

The ternary operator is useful when a condition requires only a simple true/false result.

---

# 🔁 Loops

Loops were practiced extensively to understand repetitive execution.

---

## 5. `for` Loop

Practiced multiple `for` loop examples inside a dedicated method.

Examples included:

- Printing numbers from 1 to 10
- Printing even numbers
- Printing odd numbers
- Reverse counting
- Calculating sums
- Multiplication tables
- Printing squares

---

## 6. `while` Loop

Practiced the same types of repetitive problems using `while`.

Examples included:

- Number sequences
- Even numbers
- Odd numbers
- Reverse counting
- Sum calculation
- Multiplication tables
- Square values

This helped understand how a `while` loop differs from a `for` loop while solving similar problems.

---

## 7. `do-while` Loop

Practiced `do-while` loops and understood that the loop body executes at least once before the condition is checked.

Examples included:

- Number printing
- Even and odd numbers
- Reverse counting
- Sum calculation
- Multiplication tables
- Square values

---

## 🔂 8. Nested Loops

Practiced loops inside other loops.

Examples included:

- Number pairs
- Multiplication values
- Matrix positions
- Nested `while` loops
- Multiplication tables

Nested loops became the foundation for the pattern-programming exercises completed later in the day.

---

## 🛑 9. `break`

Practiced terminating loop execution when a particular condition is reached.

Examples included:

- Stop when the value reaches 5
- Stop when the value reaches 7
- Find the first even number
- Find the first multiple of 5
- Find the first number divisible by 7

---

## ⏭️ 10. `continue`

Practiced skipping the current iteration and continuing with the next iteration.

Examples included:

- Skip even numbers
- Skip odd numbers
- Skip multiples of 5
- Skip multiples of 3
- Skip values less than or equal to 5

---

# ⭐ Pattern Programming

Pattern programming was introduced using nested loops.

The main purpose was to understand:

- Outer loop control
- Inner loop control
- Rows and columns
- Number placement
- Character placement
- Spaces
- Incrementing and decrementing patterns
- Symmetrical patterns

---

## ✳️ Star Patterns

Implemented:

- Star square
- Right-angled triangle
- Inverted right-angled triangle
- Pyramid
- Inverted pyramid
- Diamond

---

## 🔢 Number Patterns

Implemented:

- Number triangle
- Repeated number triangle
- Inverted number triangle
- Increasing number pattern

---

## 🔤 Alphabet Patterns

Implemented:

- Alphabet triangle
- Repeated alphabet triangle

These exercises strengthened the relationship between loop counters and printed output.

---

# 🗂️ Day 53 Project Structure

```text
Core-Java/
└── src/
    └── day53/
        ├── ConditionalStatements.java
        ├── Loops.java
        ├── PatternPrograms.java
        └── Main.java
````

---

# 🧩 Classes & Responsibilities

| Class                   | Responsibility                                             |
| ----------------------- | ---------------------------------------------------------- |
| `ConditionalStatements` | Practices Java decision-making statements                  |
| `Loops`                 | Practices different loop types and loop-control statements |
| `PatternPrograms`       | Implements star, number and alphabet patterns              |
| `Main`                  | Executes and tests all Day 53 programs                     |

---

# 🔧 Methods Practiced

## Conditional Statements

```text
ifStatement()
elseStatement()
elseIfStatement()
nestedIfStatement()
switchStatement()
switchStatement2()
multipleConditions()
ternaryOperator()
```

## Loops

```text
forLoopExamples()
whileLoopExamples()
doWhileExamples()
nestedLoopExamples()
breakExamples()
continueExamples()
```

## Pattern Programming

```text
starSquare()
rightTriangle()
invertedRightTriangle()
numberTriangle()
repeatedNumberTriangle()
invertedNumberTriangle()
increasingNumberPattern()
alphabetTriangle()
repeatedAlphabetTriangle()
pyramid()
invertedPyramid()
diamond()
```

---

# 🧪 Practical Implementation

The Day 53 programs were organized according to the concept being practiced rather than placing every example inside a single `main()` method.

Each category was grouped into a dedicated method.

### Conditional Statements

```text
ConditionalStatements
│
├── ifStatement()
├── elseStatement()
├── elseIfStatement()
├── nestedIfStatement()
├── switchStatement()
├── switchStatement2()
├── multipleConditions()
└── ternaryOperator()
```

### Loops

```text
Loops
│
├── forLoopExamples()
├── whileLoopExamples()
├── doWhileExamples()
├── nestedLoopExamples()
├── breakExamples()
└── continueExamples()
```

### Patterns

```text
PatternPrograms
│
├── Star Patterns
├── Number Patterns
├── Alphabet Patterns
├── Pyramid Patterns
└── Diamond Pattern
```

This organization makes the code easier to understand, execute, debug, and extend.

---

# 🌍 Real-World Applications

The concepts practiced on Day 53 are fundamental to almost every Java application.

## Conditional Statements in Real Applications

Conditional statements are commonly used for:

* User authentication
* Authorization
* Role-based access
* Payment validation
* Transaction validation
* Input validation
* Business-rule execution
* Eligibility checking
* Account status verification

For example, a backend application may check whether a user is authenticated before allowing access to a protected resource.

---

## Loops in Real Applications

Loops are heavily used for:

* Processing database records
* Iterating through collections
* Processing API responses
* Generating reports
* Validating multiple inputs
* Processing transactions
* Batch operations
* Data transformation
* Searching through data

For example, when a database query returns multiple employees, Java can iterate through the `ResultSet` and process each employee record.

---

## `break` in Real Applications

`break` can be useful when processing should stop immediately after a required condition is satisfied.

Examples:

* Finding the first matching record
* Searching for a specific user
* Detecting the first invalid value
* Stopping processing after a successful result
* Ending a menu operation

---

## `continue` in Real Applications

`continue` can be used when certain records should be ignored without terminating the entire loop.

Examples:

* Skip inactive users
* Skip invalid records
* Skip empty values
* Skip failed validation records
* Ignore unnecessary data

---

## Nested Loops in Real Applications

Nested loops are useful for:

* Matrix operations
* Multi-dimensional arrays
* Table generation
* Grid processing
* Comparing multiple datasets
* Pattern generation
* Complex data processing

---

# 🧠 Core Concepts Strengthened

Day 53 helped strengthen the understanding of Java's control-flow execution model.

### Decision Making

```text
Condition
   ↓
Check
   ↓
True / False
   ↓
Execute Appropriate Block
```

### Loop Execution

```text
Initialization
      ↓
Condition
      ↓
Loop Body
      ↓
Update
      ↓
Condition
      ↓
Repeat / Exit
```

### Nested Loop Execution

```text
Outer Loop
    ↓
    Inner Loop
        ↓
        Execute
        ↓
    Inner Loop Ends
    ↓
Outer Loop Continues
```

Understanding these execution flows is important before moving into arrays, collections, algorithms, and backend programming.

---

# 💡 Key Learnings

* Understood Java decision-making statements.
* Practiced `if`, `if-else`, `else-if`, and nested `if`.
* Practiced `switch` using integers, characters, and Strings.
* Understood how multiple conditions can be combined using logical operators.
* Practiced the ternary operator.
* Strengthened `for` loop fundamentals.
* Strengthened `while` loop fundamentals.
* Understood `do-while` execution.
* Practiced nested loops.
* Understood the practical purpose of `break`.
* Understood the practical purpose of `continue`.
* Learned how nested loops can control rows and columns.
* Practiced star patterns.
* Practiced number patterns.
* Practiced alphabet patterns.
* Practiced pyramid and diamond patterns.
* Improved logical thinking and problem-solving.
* Improved code organization by grouping related examples into methods.

---

# 📊 Day 53 Practice Summary

| Area               | Practice    |
| ------------------ | ----------- |
| `if`               | ✅ Completed |
| `if-else`          | ✅ Completed |
| `else-if`          | ✅ Completed |
| Nested `if`        | ✅ Completed |
| `switch`           | ✅ Completed |
| Logical conditions | ✅ Completed |
| Ternary operator   | ✅ Completed |
| `for` loop         | ✅ Completed |
| `while` loop       | ✅ Completed |
| `do-while` loop    | ✅ Completed |
| Nested loops       | ✅ Completed |
| `break`            | ✅ Completed |
| `continue`         | ✅ Completed |
| Star patterns      | ✅ Completed |
| Number patterns    | ✅ Completed |
| Alphabet patterns  | ✅ Completed |
| Pyramid patterns   | ✅ Completed |
| Diamond pattern    | ✅ Completed |

---

# 🏆 Day 53 Outcome

By the end of Day 53, Java control-flow fundamentals were practiced through multiple independent examples.

The major outcome was the ability to:

* Make decisions using conditions
* Handle multiple execution paths
* Repeat operations using loops
* Control loop execution
* Work with nested loops
* Build patterns using rows and columns
* Organize multiple programs into reusable methods
* Apply basic Java logic to real-world programming scenarios

These concepts form an important foundation for the upcoming Java topics.

---

# 🚀 Connection to Backend Development

Although these exercises are fundamental, they directly support future backend development.

Java backend applications constantly use:

```text
Conditions
    ↓
Business Rules

Loops
    ↓
Data Processing

Methods
    ↓
Reusable Logic

Arrays
    ↓
Data Storage & Processing

Collections
    ↓
Dynamic Data Handling

Exceptions
    ↓
Error Handling

JDBC
    ↓
Database Communication
```

The goal is therefore not simply to memorize Java syntax, but to develop the programming logic required for building real applications.

---

# 📌 Daily Progress

**100 Days of Code — Day 53**

### Completed

* ✅ Java Conditional Statements
* ✅ Java Switch Statements
* ✅ Logical Conditions
* ✅ Ternary Operator
* ✅ Java Loops
* ✅ Nested Loops
* ✅ Break & Continue
* ✅ Pattern Programming

### Status

**Day 53 — Completed Successfully 🎉**

---

# 🎯 Next Goal — Day 54

The next stage is to move deeper into Java data handling and programming practice.

Planned focus areas include:

* Arrays
* Array declaration and initialization
* Array traversal
* Array operations
* Array methods
* Passing arrays to methods
* Returning arrays from methods
* Practical array programs
* More problem-solving exercises

These concepts will provide the foundation for working with collections and more advanced Java backend programming.

---

# 🛠️ Development Environment

| Tool / Technology | Purpose                   |
| ----------------- | ------------------------- |
| Java              | Core programming language |
| Eclipse IDE       | Java development          |
| Git               | Version control           |
| GitHub            | Source code management    |

---

# 📁 Repository Organization

The Core Java practice is maintained separately from the other technologies in the learning journey.

```text
100-Days-Of-Code/
│
├── Frontend/
│
├── SQL/
│
├── Core-Java/
│   └── src/
│       ├── day52/
│       └── day53/
│
└── JDBC/
```

This separation keeps each learning track organized and makes it easier to review previous concepts.

---

# 📈 Learning Journey

```text
Core Java Fundamentals
        ↓
Control Flow
        ↓
Arrays
        ↓
Strings
        ↓
OOP
        ↓
Inheritance & Polymorphism
        ↓
Abstract Classes & Interfaces
        ↓
Functional Interfaces & Lambda
        ↓
Exception Handling
        ↓
Multithreading
        ↓
Collections
        ↓
JDBC
        ↓
Java Backend Development
```

---

# 💻 Tech Stack

| Technology | Usage                                      |
| ---------- | ------------------------------------------ |
| Java       | Core programming and backend foundation    |
| Eclipse    | Java development                           |
| Maven      | Project and dependency management for JDBC |
| MySQL      | Relational database                        |
| JDBC       | Java database connectivity                 |
| Git        | Version control                            |
| GitHub     | Repository management                      |

---

# 👨‍💻 Author

**Ragipalyam Jagan Mohan Reddy**

> Building strong Java fundamentals and progressing toward production-ready Full Stack & Java Backend Development.

---

# 🔥 100 Days of Code

**Day 53 / 100 — Completed ✅**

> Learn → Practice → Build → Document → Improve

**Core Java control flow mastered.
Next step: Arrays and deeper Java programming. 🚀**

```
```
