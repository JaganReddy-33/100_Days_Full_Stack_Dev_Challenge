
````markdown
# 🚀 100 Days Full Stack Developer Challenge

## 📅 DAY 58 — CORE JAVA PART 1

### 📌 Topics Covered

- Encapsulation
- Data Hiding
- Private Instance Variables
- Getters and Setters
- Controlled Access
- Validation through Setters
- Real-World Encapsulation
- Immutable-Style Object Design Basics
- Constructors
- No-Argument Constructors
- Default Constructor
- Parameterized Constructors
- Constructor Overloading
- Constructor Chaining
- `this()`
- `this.variable`
- Object State Initialization
- Real-World Constructor Design

---

# 🔐 PART 1 — ENCAPSULATION

## 1. Encapsulation

Encapsulation is the process of wrapping data and the methods that operate on that data inside a class while restricting direct access to the internal state.

The main mechanism used for encapsulation in Java is:

- `private` fields
- `public` getters
- `public` setters
- validation methods
- controlled business operations

### Basic Flow

```text
Private Data
     ↓
Getter / Setter / Business Method
     ↓
Controlled Access
     ↓
Object State
````

---

## 2. Data Hiding

Instance variables were declared as `private` so they cannot be directly accessed from outside the class.

Example:

```java
private int empId;
private String name;
private double salary;
```

External code cannot directly modify these fields.

Instead:

```text
Main.java
    ↓
setEmpId()
setName()
setSalary()
    ↓
Private Fields
```

---

## 3. Getters and Setters

Getters are used to retrieve private data.

Setters are used to modify private data.

Example:

```java
public void setBalance(double balance) {
    if (balance < 0) {
        return;
    }

    this.balance = balance;
}

public double getBalance() {
    return balance;
}
```

This provides controlled access instead of allowing:

```java
account.balance = -50000;
```

---

## 4. Validation Through Setters

Validation can be placed inside setters before modifying object state.

Examples:

* ID must be positive
* Name cannot be empty
* Balance cannot be negative
* Marks must be between 0 and 100

Example:

```java
public void setMarks(double marks) {

    if (marks < 0 || marks > 100) {
        return;
    }

    this.marks = marks;
}
```

---

## 5. Real-World Encapsulation

A bank account should not expose its balance for direct modification.

Instead of:

```java
account.balance = 100000;
```

the application should provide controlled operations:

```java
account.deposit(50000);
account.withdraw(10000);
```

This prevents invalid state changes.

### Important Design Principle

```text
Private balance
      ↓
deposit()
withdraw()
      ↓
Validation
      ↓
Balance Updated
```

This is closer to how real business applications are designed.

---

# 🏗️ PART 2 — CONSTRUCTORS

## 6. Constructor

A constructor is a special member of a class used to initialize an object when it is created.

Example:

```java
ConstructorBasics_01 employee =
        new ConstructorBasics_01();
```

The constructor executes automatically during object creation.

---

## 7. No-Argument Constructor

A constructor without parameters is a no-argument constructor.

Example:

```java
public ConstructorBasics_01() {
    this.empId = 101;
    this.empName = "John Doe";
    this.salary = 50000;
}
```

It initializes an object with predefined/default state.

---

## 8. Parameterized Constructor

A parameterized constructor accepts values while creating an object.

Example:

```java
ParameterizedConstructor_02 employee =
        new ParameterizedConstructor_02(
                empId,
                empName,
                salary
        );
```

This allows the object to be initialized with actual application data.

---

## 9. Constructor Overloading

A class can have multiple constructors with different parameter lists.

Example:

```java
public ConstructorOverloading_03() {
}

public ConstructorOverloading_03(int empId) {
}

public ConstructorOverloading_03(
        int empId,
        String empName,
        double salary) {
}
```

The compiler selects the constructor based on the arguments supplied.

---

## 10. Constructor Chaining

Constructor chaining allows one constructor to call another constructor using:

```java
this(...)
```

Example:

```java
public ConstructorChaining_04() {
    this("ORD-DEFAULT");
}

public ConstructorChaining_04(String orderId) {
    this(orderId, "Unknown Restaurant");
}

public ConstructorChaining_04(
        String orderId,
        String restaurant) {

    this(orderId, restaurant, "STANDARD", 40);
}
```

### Constructor Chain

```text
Constructor()
      ↓
Constructor(String)
      ↓
Constructor(String, String)
      ↓
Full Constructor
```

This reduces duplicate initialization logic.

### Important Rule

`this(...)` must be the **first statement** inside a constructor.

---

# 🔄 `this` KEYWORD

## 11. `this.variable`

When constructor parameters have the same names as instance variables:

```java
public ThisWithConstructors_06(
        String transactionId,
        double amount) {

    this.transactionId = transactionId;
    this.amount = amount;
}
```

The left side:

```java
this.transactionId
```

refers to the object's instance variable.

The right side:

```java
transactionId
```

refers to the constructor parameter.

---

# 💼 REAL-WORLD APPLICATION EXAMPLES

## UPI Transaction

Constructor-based initialization was applied to a transaction object containing:

* Transaction ID
* Sender UPI
* Receiver UPI
* Amount
* Payment method

The object could then calculate a basic transaction risk level.

Example:

```text
Transaction
     ↓
Amount
     ↓
Risk Evaluation
     ↓
LOW / MEDIUM / HIGH
```

---

## Job Application Tracking

Constructor-based initialization was also applied to a job application object containing:

* Application ID
* Candidate name
* Company
* Role
* Application source
* Status

The initial status was:

```text
APPLIED
```

and could later be updated using a business method.

---

# 📂 DAY 58 CORE JAVA PART 1 STRUCTURE

```text
Day_58_Encapsulation_Constructors_Static
│
├── src
│   └── day58
│       │
│       ├── encapsulation
│       │   ├── EncapsulationBasics_01.java
│       │   ├── GetterSetter_02.java
│       │   ├── EncapsulationValidation_03.java
│       │   └── EncapsulationProblems_04.java
│       │
│       ├── constructors
│       │   ├── ConstructorBasics_01.java
│       │   ├── ParameterizedConstructor_02.java
│       │   ├── ConstructorOverloading_03.java
│       │   ├── ConstructorChaining_04.java
│       │   ├── ConstructorRules_05.java
│       │   ├── ThisWithConstructors_06.java
│       │   └── RealWorldConstructorDesign_07.java
│       │
│       ├── staticconcepts
│       │
│       └── Main.java
```

---

# 🧠 KEY LEARNINGS

* Encapsulation protects an object's internal state.
* `private` fields prevent direct external access.
* Getters provide controlled read access.
* Setters provide controlled write access.
* Validation should happen before modifying object state.
* Business methods can be better than exposing setters for sensitive fields.
* Constructors initialize objects during object creation.
* Constructors do not have a return type.
* Constructor names must match the class name.
* Constructors can be overloaded.
* `this()` is used for constructor chaining.
* `this.variable` refers to the current object's instance variable.
* Constructor chaining reduces duplicate initialization code.
* Constructor design should represent valid object state.

---

# 🎯 DAY 58 PART 1 PRACTICE COMPLETED

### Encapsulation

* Employee data encapsulation
* Getter/setter implementation
* Validation
* Student validation
* Bank account controlled operations

### Constructors

* No-argument constructor
* Parameterized constructor
* Constructor overloading
* Constructor chaining
* `this()`
* `this.variable`
* Real-world object initialization
* UPI transaction object
* Job application object
* API request configuration
* Food-delivery order configuration

---

# 🎤 DAY 58 PART 1 — INTERVIEW QUESTIONS

## 1. What is encapsulation?

**Direct answer:**
Encapsulation is wrapping data and methods together inside a class and restricting direct access to the object's internal state.

**Why/how:**
Java commonly achieves this using `private` fields and controlled public methods.

**Real-world gotcha:**
Do not blindly create setters for every field. Sensitive state should often be changed through business methods such as `deposit()` and `withdraw()`.

**Likely follow-up:**
What is the difference between encapsulation and data hiding?

---

## 2. Why are fields usually declared private?

**Direct answer:**
To prevent direct external modification and maintain control over object state.

**Why/how:**
Access is provided through getters, setters, or business methods.

**Real-world gotcha:**
A public setter can still expose too much control, so validation and business rules matter.

**Likely follow-up:**
Can encapsulation exist without setters?

---

## 3. What is a constructor?

**Direct answer:**
A constructor is a special member used to initialize an object when it is created.

**Why/how:**
It executes automatically when `new` creates an object.

**Real-world gotcha:**
A constructor has no return type, not even `void`.

**Likely follow-up:**
What happens if no constructor is explicitly written?

---

## 4. What is constructor overloading?

**Direct answer:**
Constructor overloading means defining multiple constructors with different parameter lists in the same class.

**Why/how:**
Java selects the appropriate constructor based on the arguments supplied.

**Real-world gotcha:**
Changing only the return type is irrelevant because constructors do not have return types.

**Likely follow-up:**
How is constructor overloading different from method overloading?

---

## 5. What is constructor chaining?

**Direct answer:**
Constructor chaining is calling one constructor from another constructor using `this(...)`.

**Why/how:**
It allows common initialization logic to be centralized.

**Real-world gotcha:**
`this(...)` must be the first statement in the constructor.

**Likely follow-up:**
What is the difference between `this()` and `super()`?

---

# 📈 DAY 58 CORE JAVA PROGRESS

```text
Day 58
│
├── Part 1 — Encapsulation        ✅
├── Part 2 — Constructors         ✅
├── Part 3 — Constructor Chaining ✅
│
└── Part 4 — static               ⏳
```

---

# 🔜 NEXT — DAY 58 CORE JAVA PART 2

We will continue with:

### `static`

* Static variables
* Static methods
* Static initialization
* Instance vs static
* When to use `static`
* Static with constructors
* Static classes / utility-style design
* Common mistakes
* Practical problems
* Real-world application examples
* User-input-driven testing from `Main.java`

After completing Core Java Part 2, we will continue with:

```text
DAY 58 — JDBC
        ↓
JDBC Architecture
        ↓
Separation of Responsibilities
        ↓
Connection Layer
        ↓
Database Access Layer
        ↓
Business/Application Layer
        ↓
DAO Pattern
        ↓
Entity / Model
        ↓
DAO Interface
        ↓
DAO Implementation
        ↓
CRUD Operations
        ↓
Practical Employee CRUD
```

---

# 🛠️ TECHNOLOGY

* Java
* Eclipse IDE
* JDK
* Object-Oriented Programming
* Java Collections concepts introduced through practical development
* JDBC
* MySQL
* Maven

---

# 👨‍💻 AUTHOR

**Jagan Mohan Reddy**

GitHub: `JaganReddy-33`

100 Days Full Stack Developer Challenge

---

# 🚀 PROGRESS

**Day 58 — Core Java Part 1: COMPLETED ✅**

Encapsulation + Constructors + Constructor Chaining completed with practical, application-oriented examples.

Next target:

**Day 58 — Core Java Part 2: `static`**

````
