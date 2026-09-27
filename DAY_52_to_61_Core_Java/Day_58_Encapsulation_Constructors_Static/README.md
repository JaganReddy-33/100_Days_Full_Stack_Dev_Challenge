````markdown
# 🚀 Day 58 — Core Java | Encapsulation, Constructors & Static Concepts

## 📌 100 Days Full Stack Developer Challenge

Day 58 focused on strengthening **Core Java object-oriented programming fundamentals** through practical, real-world backend-oriented examples based around the **UPI Payment Fraud & Risk Scoring System**.

The day was divided into two major parts:

- **Part 1 — Encapsulation & Constructors**
- **Part 2 — Static Concepts & Object Initialization**

---

# 🟦 Part 1 — Encapsulation & Constructors

## 1️⃣ Encapsulation

Covered the fundamentals of encapsulation and how it is applied in real-world Java applications.

### Topics Covered

- Encapsulation
- Data hiding
- `private` instance variables
- Getters and setters
- Controlled access
- Validation inside setters
- Business-rule validation
- Immutable-style object design basics
- Real-world object design

### Files Created

```text
day58
└── encapsulation
    ├── EncapsulationBasics_01.java
    ├── GetterSetter_02.java
    ├── EncapsulationValidation_03.java
    └── EncapsulationProblems_04.java
````

### Practical Concepts

The examples demonstrated how sensitive object state should not be directly accessible.

For example:

```text
Private Data
    ↓
Getter / Setter
    ↓
Validation
    ↓
Controlled Object State
```

The practical examples included:

* Employee data protection
* Account information
* Student validation
* Bank account balance control

A particularly important real-world concept was controlling balance changes through business operations such as:

```text
deposit()
withdraw()
```

instead of exposing a direct:

```text
setBalance()
```

This demonstrates how encapsulation can protect business-critical data.

---

# 2️⃣ Constructors

Constructors were used to understand how Java initializes objects and establishes their initial state.

### Topics Covered

* Constructor
* Constructor naming rules
* Default constructor
* No-argument constructor
* Parameterized constructor
* Constructor vs method
* Constructor overloading
* `this`
* Object state initialization
* Real-world constructor design

### Files Created

```text
day58
└── constructors
    ├── ConstructorBasics_01.java
    ├── ParameterizedConstructor_02.java
    ├── ConstructorOverloading_03.java
    ├── ConstructorChaining_04.java
    ├── ConstructorRules_05.java
    ├── ThisWithConstructors_06.java
    └── RealWorldConstructorDesign_07.java
```

### Constructor Flow

```text
new Object(...)
       ↓
Constructor
       ↓
Initial Object State
       ↓
Object Ready for Use
```

Constructors were also connected to real-world backend objects where an object should be created with meaningful initial data.

---

# 🟩 Part 2 — Static Concepts & Object Initialization

The second part focused on the `static` keyword and how Java manages class-level data and behavior.

## Topics Covered

* Static variables
* Static methods
* Static initialization
* Static blocks
* Instance vs static members
* Static with constructors
* Static constants
* Utility-style classes
* Common static mistakes
* Object initialization order
* Initialization blocks
* Real-world transaction modeling

---

## Files Created

```text
day58
└── staticconcepts
    ├── StaticTransactionCounter_01.java
    ├── StaticPaymentConfig_02.java
    ├── StaticTransactionUtility_03.java
    ├── StaticInitialization_04.java
    ├── InstanceVsStatic_05.java
    ├── StaticWithConstructors_06.java
    ├── StaticConstants_07.java
    ├── UtilityClassDesign_08.java
    ├── StaticMistakes_09.java
    ├── ObjectInitializationOrder_10.java
    ├── InitializationBlocks_11.java
    ├── RealWorldTransactionModel_12.java
    └── Main.java
```

---

# 1️⃣ Static Variables

Learned that a static variable belongs to the **class**, not to an individual object.

A practical transaction counter was used to demonstrate shared class-level state.

```text
Transaction 1 ──┐
Transaction 2 ──┼──> static totalTransactions
Transaction 3 ──┘
```

This helped understand how multiple objects can share one static variable.

---

# 2️⃣ Static Methods

Static methods were used for operations that do not depend on a particular object's instance state.

Examples included:

* Payment validation
* Transaction amount validation
* Payment method normalization
* Risk score validation
* Risk level determination

---

# 3️⃣ Static Configuration

A static payment configuration example demonstrated shared application-level configuration such as:

* Minimum transaction amount
* Maximum transaction amount
* Maximum daily transaction count

The concept:

```text
Application
     ↓
Shared Configuration
     ↓
All Relevant Objects
```

---

# 4️⃣ Static Initialization

Static blocks were used to understand class-level initialization.

Example concepts included:

* System name
* Risk threshold
* Fraud detection configuration

Static initialization happens when the class is initialized.

---

# 5️⃣ Instance vs Static

The difference between instance members and static members was practiced.

```text
Instance Variable
→ Different value for each object

Static Variable
→ Shared value across objects
```

For example:

```text
Payment Object 1 → amount
Payment Object 2 → amount
Payment Object 3 → amount

                    ↓

             totalPayments
                 STATIC
```

---

# 6️⃣ Static With Constructors

Static variables were combined with constructors to track objects created by a class.

The practical transaction/payment example demonstrated how every new object could contribute to a shared count.

---

# 7️⃣ Static Constants

Application states were represented using `static final` constants.

Examples:

```text
ACTIVE
SUSPENDED
BLOCKED

PENDING
SUCCESS
FAILED
```

Concept:

```java
public static final String SUCCESS = "SUCCESS";
```

This introduced the idea of constants for fixed application values.

---

# 8️⃣ Utility Class Design

Utility-style static methods were created for reusable operations such as:

* Transaction amount validation
* Risk score validation
* Payment method normalization
* Risk-level determination
* Supported payment method validation

The purpose was to understand when functionality can be shared without creating an object.

---

# 9️⃣ Common Static Mistakes

The practical examples demonstrated the difference between:

```text
Object-specific state
        vs
Class-level shared state
```

This is important when deciding whether a variable or method should actually be static.

---

# 🔟 Object Initialization Order

The execution order of Java initialization was explored.

General flow:

```text
Class Loading
     ↓
Static Initialization
     ↓
Object Creation
     ↓
Instance Initialization
     ↓
Constructor
```

The examples demonstrated this order using static blocks, instance initialization blocks, fields, and constructors.

---

# 1️⃣1️⃣ Initialization Blocks

Both static and instance initialization blocks were practiced.

```text
Static Block
→ Executes when class is initialized

Instance Block
→ Executes whenever an object is created

Constructor
→ Executes after instance initialization
```

---

# 1️⃣2️⃣ Real-World Transaction Model

The final static concept combined several concepts into a practical UPI transaction model.

The model included:

* Transaction ID
* Sender UPI ID
* Receiver UPI ID
* Transaction amount
* Transaction status
* Static transaction counter
* Static transaction status constants
* Transaction validation
* Success/failure state handling

Example flow:

```text
Create Transaction
        ↓
Validate Transaction
        ↓
     PENDING
      ↙   ↘
 SUCCESS   FAILED
```

This connected Core Java concepts with the larger backend project being developed throughout the challenge.

---

# 📂 Complete Day 58 Core Java Structure

```text
Day_58_Encapsulation_Constructors_Static
│
└── src
    └── day58
        ├── encapsulation
        │   ├── EncapsulationBasics_01.java
        │   ├── GetterSetter_02.java
        │   ├── EncapsulationValidation_03.java
        │   └── EncapsulationProblems_04.java
        │
        ├── constructors
        │   ├── ConstructorBasics_01.java
        │   ├── ParameterizedConstructor_02.java
        │   ├── ConstructorOverloading_03.java
        │   ├── ConstructorChaining_04.java
        │   ├── ConstructorRules_05.java
        │   ├── ThisWithConstructors_06.java
        │   └── RealWorldConstructorDesign_07.java
        │
        ├── staticconcepts
        │   ├── StaticTransactionCounter_01.java
        │   ├── StaticPaymentConfig_02.java
        │   ├── StaticTransactionUtility_03.java
        │   ├── StaticInitialization_04.java
        │   ├── InstanceVsStatic_05.java
        │   ├── StaticWithConstructors_06.java
        │   ├── StaticConstants_07.java
        │   ├── UtilityClassDesign_08.java
        │   ├── StaticMistakes_09.java
        │   ├── ObjectInitializationOrder_10.java
        │   ├── InitializationBlocks_11.java
        │   ├── RealWorldTransactionModel_12.java
        │   └── Main.java
        │
        └── Main.java
```

---

# 🧠 Key Learnings

## Encapsulation

```text
Private Data
     ↓
Controlled Access
     ↓
Validation
     ↓
Safe Object State
```

## Constructors

```text
new Object(...)
      ↓
Constructor
      ↓
Initial State
      ↓
Ready Object
```

## Static

```text
Instance Member
→ Belongs to object

Static Member
→ Belongs to class
```

## Initialization

```text
Static Initialization
        ↓
Instance Initialization
        ↓
Constructor
```

---

# 💼 Backend Relevance

These Core Java concepts directly support the backend architecture being built in the challenge.

### Encapsulation

Used when protecting:

* Account data
* Transaction data
* User information
* Risk information

### Constructors

Used when creating:

* Account objects
* Transaction objects
* Risk-score objects
* API/domain objects

### Static

Useful for:

* Constants
* Shared configuration
* Utility operations
* Application-wide counters
* Common validation logic

### Object Initialization

Important for understanding how Java initializes backend domain objects before they are processed.

---

# 🎯 Day 58 Interview Preparation

## 1. What is encapsulation?

Encapsulation is the process of bundling data and methods together while restricting direct access to internal object state.

**Why:** It protects data and allows controlled access.

**Gotcha:** Encapsulation is not simply making variables private; validation and controlled operations are also important.

**Follow-up:** How can encapsulation protect a bank account balance?

---

## 2. What is a constructor?

A constructor is a special member used to initialize an object when it is created.

**Why:** It establishes the initial state of an object.

**Gotcha:** A constructor does not have a return type.

**Follow-up:** What is constructor overloading?

---

## 3. What is the difference between instance and static variables?

An instance variable belongs to an individual object, while a static variable belongs to the class and is shared among objects.

**Why:** Static state is useful when one value should be shared.

**Gotcha:** Using static for object-specific data causes shared-state problems.

**Follow-up:** Why would a transaction counter be static?

---

## 4. What is a static block?

A static block is used for class-level initialization and executes when the class is initialized.

**Why:** It can initialize static state before objects are created.

**Gotcha:** It is not executed once per object.

**Follow-up:** What is the difference between a static block and an instance initialization block?

---

## 5. What is `static final`?

`static final` is commonly used to define class-level constants whose value should not be reassigned.

Example:

```java
public static final String SUCCESS = "SUCCESS";
```

**Why:** It provides a shared fixed value.

**Gotcha:** `final` prevents reassignment of the reference/value; it does not automatically make every referenced object deeply immutable.

**Follow-up:** When should constants be used instead of ordinary variables?

---

# 🛠️ Technologies / Environment

* Java
* Core Java
* Object-Oriented Programming
* Eclipse IDE
* Git
* GitHub
* Real-world UPI payment domain examples

---

# 📊 Day 58 Progress

```text
Day 58
│
├── Part 1
│   ├── Encapsulation              ✅
│   ├── Getters / Setters          ✅
│   ├── Validation                 ✅
│   ├── Constructors               ✅
│   ├── Constructor Overloading    ✅
│   ├── Constructor Chaining       ✅
│   └── Object Initialization      ✅
│
└── Part 2
    ├── Static Variables           ✅
    ├── Static Methods             ✅
    ├── Static Blocks              ✅
    ├── Instance vs Static         ✅
    ├── Static Constants           ✅
    ├── Utility Classes            ✅
    ├── Initialization Blocks      ✅
    └── Real-World Transaction     ✅
```

---

# 🚀 Day 58 Outcome

Day 58 strengthened the Core Java foundation required for backend development.

The main concepts completed were:

```text
Encapsulation
      +
Constructors
      +
Constructor Chaining
      +
Static
      +
Initialization
      ↓
Stronger Java Backend Foundation
```

The examples were progressively connected to the **Real-Time UPI Payment Fraud & Risk Scoring System**, preparing the codebase for the upcoming backend domain development.

---

# 🔜 Next Goal — Day 59

## Core Java

### Inheritance + Method Overriding

Planned concepts:

* Inheritance
* `extends`
* Parent-child relationship
* Method overriding
* `super`
* Runtime behavior
* Real-world backend inheritance examples

## JDBC

### Transaction Domain

Planned work:

```text
transactions table
       ↓
Transaction Model
       ↓
TransactionDAO
       ↓
TransactionDAOImpl
```

This will extend the existing account-based JDBC architecture toward the actual UPI transaction workflow.

---

# 🏗️ Overall Project Direction

The long-term backend architecture is evolving toward:

```text
                    App
                     ↓
                  Service
                     ↓
                    DAO
                     ↓
                   JDBC
                     ↓
                   MySQL
```

With the eventual domain flow:

```text
Users
  ↓
Accounts
  ↓
Transactions
  ↓
Risk Scores
  ↓
Fraud Alerts
  ↓
Audit Logs
```

Day 58 established the Core Java object-model foundation required to build these backend components progressively.

---

# 👨‍💻 Author

**Ragipalyam Jaganmohan Reddy**

GitHub: `JaganReddy-33`

100 Days Full Stack Developer Challenge

---

# 📌 Day 58 Status

**Core Java Day 58 — COMPLETED ✅**

**Part 1:** Encapsulation + Constructors ✅

**Part 2:** Static Concepts + Object Initialization ✅

**Next:** Day 59 — Inheritance + Method Overriding + JDBC Transaction Domain

```
```
