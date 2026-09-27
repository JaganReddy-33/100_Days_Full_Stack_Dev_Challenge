# Day 60 — Part 1 & Part 2 | Core Java

````markdown
# DAY 60 — PART 1 & PART 2
## Core Java — Polymorphism & Real-World Practice

Day 60 focused completely on **Polymorphism in Core Java**, progressing from the fundamentals of compile-time and runtime polymorphism to real-world assessment-style problems.

---

## 📌 Topics Covered

### Part 1 — Polymorphism Fundamentals

#### 1. Compile-Time Polymorphism

Covered **Method Overloading**.

Method overloading allows multiple methods in the same class to have the same method name with different parameter lists.

Example concepts practiced:

- Different number of parameters
- Different parameter data types
- Method selection at compile time
- Real-world payment operations

---

### 2. Runtime Polymorphism

Covered **Method Overriding** and **Dynamic Method Dispatch**.

Runtime polymorphism allows a parent-class reference to refer to different child-class objects.

Core structure:

```text
Parent Reference
       ↓
Child Object
       ↓
Overridden Method
       ↓
Runtime Method Selection
````

The same parent reference can point to different child objects and execute different overridden implementations.

---

## 🧪 Guided Examples

### Compile-Time Polymorphism

#### Example 1 — Calculator

File:

```text
MethodOverloadingEx_01.java
```

Practiced:

* `add(int, int)`
* `add(int, int, int)`
* `add(double, double)`

Focus:

* Method overloading
* Different parameter lists
* Compile-time method selection

---

### Example 2 — Payment Processing

File:

```text
MethodOverloadingEx_02.java
```

Practiced overloaded payment methods using different payment information.

Examples included:

* UPI payment
* Card payment
* Payment with description

Focus:

* Method overloading
* Real-world method design
* Parameter variation

---

### Runtime Polymorphism

#### Example 1 — Payment Processing

File:

```text
RuntimePolymorphismEx_01.java
```

Structure:

```text
Payment
├── UPIPayment
└── CardPayment
```

Practiced:

* Method overriding
* Parent reference
* Child objects
* Dynamic method dispatch

---

### Example 2 — Employee Salary

File:

```text
RuntimePolymorphismEx_02.java
```

Structure:

```text
Employee
├── Manager
└── Developer
```

Practiced:

* Method overriding
* Runtime method selection
* Parent reference pointing to child objects
* Real-world salary calculation

---

# 🧩 Portal Assessment Practice

Five Core Java assessment problems were practiced during Day 60 Part 1.

### 1. Plane Flight Methods

Classes:

```text
Plane
├── CargoPlane
├── PassengerPlane
└── FighterPlane
```

Practiced:

* Inheritance
* Method overriding
* Runtime polymorphism

---

### 2. Sound Methods

Classes:

```text
Animal
├── Dog
├── Cat
└── Cow
```

Each child class provided its own implementation of `sound()`.

Practiced:

* Method overriding
* Dynamic dispatch
* Parent reference → child object

---

### 3. Sports Classes

Classes:

```text
Sport
├── Rugby
├── Football
└── Basketball
```

Each sport provided its own implementation of `play()`.

Practiced:

* Runtime polymorphism
* Method overriding
* Common parent type with different behavior

---

### 4. Starting / Stopping Engines

Practiced polymorphism using:

* `startEngine()`
* `stopEngine()`
* `Car`
* `Bike`
* `Truck`

Focus:

* Common behavior
* Different implementations
* Polymorphic method calls

---

### 5. Calculating Salaries

Classes:

```text
Employee
├── FullTimeEmployee
├── PartTimeEmployee
└── Contractor
```

Each employee type implemented its own `calculateSalary()` behavior.

Focus:

* Inheritance
* Method overriding
* Runtime polymorphism
* Real-world calculations

---

# 🚀 Part 2 — Real-World Polymorphism Practice

Part 2 focused on applying polymorphism to realistic application scenarios instead of only basic examples.

---

## 1. UPI Payment Gateway

File:

```text
UPIPaymentGateway.java
```

Structure:

```text
PaymentMethod
├── UPI
├── CreditCard
└── NetBanking
```

Each payment method overrides:

```text
processPayment()
```

The application uses a parent reference:

```text
PaymentMethod
      ↓
UPI / CreditCard / NetBanking
```

Practiced:

* Runtime polymorphism
* Method overriding
* Parent reference
* Child objects
* Instance-level state
* Real-world payment processing

The payment-method object maintains its own `totalBalance`.

---

## 2. E-Commerce Order Pricing

Problem focused on different order types:

```text
Order
├── RegularOrder
├── PremiumOrder
└── InternationalOrder
```

Each order type calculates its final amount differently.

Practiced:

* Runtime polymorphism
* Method overriding
* Order-specific pricing behavior
* Method overloading through product operations
* Real-world e-commerce modeling

---

## 3. Banking Transaction Processor

Structure:

```text
BankTransaction
├── Deposit
├── Withdrawal
├── Transfer
└── BillPayment
```

Different transaction types provide their own implementations for:

```text
processTransaction()
calculateFee()
```

Practiced:

* Runtime polymorphism
* Multiple overridden methods
* Transaction-specific behavior
* Fee calculation
* Banking domain modeling

---

## 4. Fraud Risk Evaluation

Structure:

```text
RiskEvaluator
├── LowRiskEvaluator
├── MediumRiskEvaluator
└── HighRiskEvaluator
```

Different risk evaluators provide their own implementations for:

```text
calculateRiskScore()
getRiskLevel()
```

Practiced:

* Runtime polymorphism
* Strategy-style behavior
* Risk evaluation modeling
* Different implementations behind a common parent type
* Real-world fraud/risk domain concepts

This problem also connects conceptually with the larger UPI Fraud & Risk project being developed separately through JDBC.

---

# 📁 Project Structure

```text
day60/
│
├── compiletime/
│   ├── MethodOverloadingEx_01.java
│   └── MethodOverloadingEx_02.java
│
├── runtime/
│   ├── RuntimePolymorphismEx_01.java
│   └── RuntimePolymorphismEx_02.java
│
└── problems/
    ├── UPIPaymentGateway.java
    ├── EcommerceOrderPricing.java
    ├── BankingTransactionProcessor.java
    └── FraudRiskEvaluation.java
```

---

# 🧠 Core Concepts Learned

```text
Polymorphism
│
├── Compile-Time Polymorphism
│   └── Method Overloading
│
└── Runtime Polymorphism
    ├── Method Overriding
    ├── Parent Reference
    ├── Child Object
    └── Dynamic Method Dispatch
```

Important relationship:

```text
Parent Reference
      ↓
Child Object
      ↓
Overridden Method
      ↓
Runtime decides implementation
```

---

# 🔥 Real-World Applications Practiced

The concepts were applied to multiple domains:

```text
Payment Systems
      ↓
E-Commerce
      ↓
Banking
      ↓
Fraud Risk Evaluation
```

This helped connect the Core Java polymorphism concepts with the type of backend systems being built later.

---

# 🛠️ Technologies

* Java
* Core Java
* OOP
* Inheritance
* Method Overloading
* Method Overriding
* Runtime Polymorphism
* Dynamic Method Dispatch
* Scanner
* Eclipse IDE

---

# 📌 Day 60 Learning Progress

### Part 1

```text
Method Overloading          ✅
Runtime Polymorphism        ✅
Method Overriding           ✅
Dynamic Dispatch            ✅
Portal Assessment Practice  ✅
```

### Part 2

```text
UPI Payment Gateway         ✅
E-Commerce Pricing          ✅
Banking Transactions       ✅
Fraud Risk Evaluation      ✅
Real-World Polymorphism    ✅
```

---

# 🎯 Day 60 Core Java Status

**COMPLETED ✅**

Day 60 Core Java covered polymorphism from fundamentals through real-world application scenarios and assessment practice.

The next learning phase continues with the **JDBC portion of Day 60 Part 2**.

```
```
