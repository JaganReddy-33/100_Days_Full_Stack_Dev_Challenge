# Day 61 — Core Java: Abstraction & Interface

![Java](https://img.shields.io/badge/Java-Core%20Java-orange?style=flat-square\&logo=openjdk)
![OOP](https://img.shields.io/badge/OOP-Abstraction%20%26%20Interface-blue?style=flat-square)
![Status](https://img.shields.io/badge/Status-Completed-success?style=flat-square)

Part of my **100 Days Full Stack Developer Challenge**, focused on strengthening Core Java and Object-Oriented Programming fundamentals.

---

## 📌 Overview

Day 61 covers two major OOP concepts:

* **Abstraction**
* **Interface**

The practice focuses on applying these concepts to real-world Java design problems rather than only syntax-based examples.

---

## 🧠 Concepts Covered

### Abstraction

* Abstract Classes
* Abstract Methods
* Concrete Methods
* Abstract Class Constructors
* Inheritance
* Method Overriding
* Encapsulation
* Runtime Polymorphism
* Real-World Abstraction

### Interface

* Interface Declaration
* `implements`
* Interface Methods
* Interface Variables
* Interface References
* Multiple Implementations
* Multiple Interfaces
* Default Methods
* Static Methods
* Runtime Polymorphism
* Loose Coupling
* Contract-Based Design

---

## 💻 Practice Projects

### Part 1 — Abstraction

| # | Project |
|---|---|
| 01 | Animal Behaviours |
| 02 | Animal Sounds |
| 03 | Area of Shapes |
| 04 | Bird Behaviours |
| 05 | Volume of 3D Shapes |
| 06 | Employee Payroll System |
| 07 | Bank Account System |

### Part 2 — Interface

| # | Project |
|---|---|
| 01 | Payment Gateway System |
| 02 | Notification Service System |
| 03 | Order Shipping System |
| 04 | UPI Risk Engine System |
| 05 | Ride Booking System |
| 06 | E-Commerce Order System |

**Total Practice Programs: 13**

---

## 🔧 Key OOP Design Patterns Practiced

### Abstract Class

Used when related classes share common state or behavior while requiring specific implementations from subclasses.

```java
abstract class Payment {
    abstract void processPayment();

    void showStatus() {
        System.out.println("Payment processing...");
    }
}
```

### Interface

Used to define a contract that multiple classes can implement differently.

```java
interface PaymentGateway {
    void processPayment();
    void refundPayment();
}
```

This allows different implementations such as:

```text
PaymentGateway
├── UPI
├── Credit Card
└── Net Banking
```

---

## 🏗️ Real-World Applications

The concepts were applied to systems such as:

```text
Payment Gateway
Notification Service
Shipping Service
UPI Risk Engine
Ride Booking
E-Commerce Orders
Employee Payroll
Bank Accounts
```

These examples demonstrate how Java applications can separate **contracts from implementations** and support different behaviors through inheritance, interfaces, and polymorphism.

---

## 📈 OOP Progression

```text
Encapsulation
      ↓
Inheritance
      ↓
Polymorphism
      ↓
Abstraction
      ↓
Interface
      ↓
Flexible Object-Oriented Design
```

---

## 🎯 Learning Outcome

After completing Day 61, I can:

* Create and use abstract classes.
* Define and implement abstract methods.
* Use constructors inside abstract classes.
* Apply inheritance and method overriding.
* Design and implement interfaces.
* Use interface references with runtime polymorphism.
* Implement multiple interfaces.
* Apply abstraction to real-world Java systems.
* Design loosely coupled components using interfaces.

---

## 📊 Day 61 Progress

| Section    | Topic                       | Status          |
| ---------- | --------------------------- | --------------- |
| Part 1     | Abstraction                 | ✅ Completed     |
| Part 2     | Interface                   | ✅ Completed     |
| **Day 61** | **Abstraction & Interface** | **✅ Completed** |

---

## 📂 Project Structure

```text
Day_61_Abstract_&_Interface/
│
├── src/
│   └── day61/
│       ├── abstraction/
│       │   └── ...
│       │
│       └── interfaces/
│           ├── ECommerceOrderSystem.java
│           ├── NotificationServiceSystem.java
│           ├── OrderShippingSystem.java
│           ├── PaymentGatewaySystem.java
│           ├── RideBookingSystem.java
│           └── UPIRiskEngineSystem.java
│
└── README.md
```

---

## ✅ Status

**Day 61 — Core Java: Abstraction & Interface**

**Completed**

> Building strong Core Java and OOP fundamentals through practical, real-world problems.
