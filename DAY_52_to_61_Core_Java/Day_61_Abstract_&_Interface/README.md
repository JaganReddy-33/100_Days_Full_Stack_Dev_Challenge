
# Day 61 Part 1: Core Java — Abstraction

Here is the complete topic README for today's work.

````markdown
# Day 61 — Part 1: Core Java — Abstraction

## Overview

Day 61 Part 1 focuses on the fourth pillar of Object-Oriented Programming in Java: **Abstraction**.

Abstraction is the process of hiding implementation details and exposing only the essential behavior required by the user or other parts of the application.

In Java, abstraction can be implemented using:

- Abstract Classes
- Interfaces

This part focuses specifically on **Abstract Classes**.

Interfaces will be covered separately in **Day 61 — Part 2**.

---

# Learning Objectives

By completing this part, I learned how to:

- Understand abstraction in Java
- Create abstract classes
- Declare abstract methods
- Implement abstract methods in child classes
- Understand why abstract classes cannot be instantiated
- Use constructors inside abstract classes
- Use concrete methods inside abstract classes
- Use variables inside abstract classes
- Combine abstraction with inheritance
- Combine abstraction with method overriding
- Apply runtime polymorphism with abstract classes
- Decide which behavior should be abstract
- Decide which behavior should be common and concrete
- Encapsulate data inside an abstract class
- Build real-world systems using abstraction

---

# 1. What is Abstraction?

Abstraction means:

> Hiding implementation details and exposing only the essential functionality.

The user should know **what an object can do**, without necessarily knowing **how the operation is implemented internally**.

### Real-World Example

Consider an ATM.

A user can:

- Withdraw money
- Deposit money
- Check balance

The user does not need to know the internal implementation of:

- Database operations
- Account validation
- Transaction processing
- Balance calculations
- Security checks

The ATM exposes the required operations while hiding the internal implementation.

---

# 2. Abstraction in Java

Java provides two major mechanisms for abstraction:

```text
Abstraction
│
├── Abstract Class
│
└── Interface
````

Day 61 is divided into:

```text
Day 61
│
├── Part 1 → Abstract Class
│
└── Part 2 → Interface
```

---

# 3. Abstract Class

An abstract class is declared using the `abstract` keyword.

```java
abstract class Animal {

}
```

An abstract class can contain:

* Abstract methods
* Concrete methods
* Constructors
* Instance variables
* Static methods
* Final methods

---

# 4. Abstract Method

An abstract method is a method declared without an implementation.

```java
abstract void sound();
```

The child class must provide the implementation.

Example:

```java
abstract class Animal {

    abstract void sound();

}
```

Child class:

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }

}
```

---

# 5. Abstract Class Cannot Be Instantiated

We cannot directly create an object of an abstract class.

Invalid:

```java
Animal animal = new Animal();
```

Instead, we create an object of a concrete child class:

```java
Animal animal = new Dog();
```

This also demonstrates runtime polymorphism.

---

# 6. Abstract Class with Concrete Method

An abstract class can contain normal concrete methods.

Example:

```java
abstract class Employee {

    abstract double calculateSalary();

    void displayCompanyName() {
        System.out.println("ABC Technologies");
    }

}
```

The abstract method defines behavior that subclasses must implement.

The concrete method provides behavior shared by all subclasses.

---

# 7. Abstract Class Constructor

An abstract class can have a constructor.

Example:

```java
abstract class Employee {

    private int employeeId;
    private String employeeName;

    public Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

}
```

The abstract class constructor executes when a child-class object is created.

Example:

```java
Employee employee = new FullTimeEmployee(101, "Jagan", 50000);
```

The `Employee` constructor executes as part of child-object creation.

---

# 8. Abstract Class + Inheritance

Abstract classes are commonly used as parent classes.

Example:

```text
Employee
├── FullTimeEmployee
└── PartTimeEmployee
```

The parent defines common structure and behavior.

The child classes provide specialized implementations.

---

# 9. Abstract Class + Method Overriding

An abstract method must be implemented by a concrete child class.

Example:

```java
abstract class Employee {

    abstract void calculateSalary();

}
```

Child:

```java
class FullTimeEmployee extends Employee {

    @Override
    void calculateSalary() {
        System.out.println("Calculating full-time salary");
    }

}
```

The child overrides the abstract method.

---

# 10. Abstract Class + Runtime Polymorphism

An abstract class can be used as a parent reference.

```java
Employee employee;
```

The reference can point to different child objects:

```java
employee = new FullTimeEmployee(...);
```

or:

```java
employee = new PartTimeEmployee(...);
```

Then:

```java
employee.calculateSalary();
```

The appropriate child implementation executes at runtime.

This combines:

```text
Abstraction
      +
Inheritance
      +
Method Overriding
      +
Runtime Polymorphism
```

---

# 11. Abstraction + Encapsulation

Abstraction and encapsulation are related but different concepts.

### Encapsulation

Focuses on:

> Protecting and controlling access to data.

Example:

```java
private double balance;
```

with:

```java
public double getBalance()
```

and:

```java
public void setBalance(double balance)
```

### Abstraction

Focuses on:

> Hiding implementation details and exposing required behavior.

Example:

```java
abstract void withdraw(double amount);
```

The parent defines the required operation without defining its implementation.

---

# 12. Four Pillars of OOP — Progress

The Core Java OOP journey has now covered all four major pillars:

```text
1. Encapsulation
       ↓
   Day 58

2. Inheritance
       ↓
   Day 59

3. Polymorphism
       ↓
   Day 60

4. Abstraction
       ↓
   Day 61 Part 1
```

Interfaces will be covered in:

```text
Day 61 Part 2
```

---

# 13. Practice Program 1 — Animal Behaviours

Created an abstract `Animals` class with:

```java
abstract void eat();

abstract void sleep();
```

Child classes:

```text
Animals
├── Lion
├── Tiger
└── Deer
```

Each child provides its own implementation of:

* `eat()`
* `sleep()`

The program also uses:

```java
Animals animal;
```

to demonstrate polymorphism.

---

# 14. Practice Program 2 — Animal Sounds

Created an abstract `Animal` class with:

```java
abstract void sound();
```

Child classes:

```text
Animal
├── Lion
└── Tiger
```

Each child provides its own implementation of `sound()`.

This was a basic exercise for understanding abstract methods and overriding.

---

# 15. Practice Program 3 — Area of Shapes

Created:

```java
abstract class Shape
```

with:

```java
abstract void acceptInput(Scanner sc);

abstract void calcArea();
```

The parent also maintained common area state.

Child classes:

```text
Shape
├── Square
├── Rectangle
└── Circle
```

This exercise combined:

* Abstraction
* Encapsulation
* Inheritance
* Method overriding
* Runtime polymorphism

---

# 16. Practice Program 4 — Bird Behaviours

Created:

```java
abstract class Bird
```

with:

```java
abstract void fly();

abstract void makeSound();
```

Child classes:

```text
Bird
├── Eagle
└── Hawk
```

This demonstrated an abstract class containing multiple abstract behaviors.

---

# 17. Practice Program 5 — Volume of 3D Shapes

Created:

```java
abstract class ThreeDShape
```

with:

```java
abstract void acceptInput(Scanner scanner);

abstract void calcVolume();
```

The parent also contained a concrete method:

```java
void displayVolume(String shapeName)
```

Child classes:

```text
ThreeDShape
├── Cube
├── Cylinder
└── Sphere
```

This demonstrated that an abstract class can contain both:

* Abstract methods
* Concrete methods

---

# 18. Practice Program 6 — Employee Payroll System

Created an abstract:

```java
abstract class Employee
```

with common fields:

```text
employeeId
employeeName
```

Abstract behavior:

```java
abstract void calculateSalary();
```

Concrete behavior:

```java
void displayEmployeeDetails()
```

Child classes:

```text
Employee
├── FullTimeEmployee
└── PartTimeEmployee
```

Full-time salary is based on monthly salary.

Part-time salary is calculated using:

```text
hours worked × hourly rate
```

The program uses:

```java
Employee employee;
```

to demonstrate runtime polymorphism.

---

# 19. Practice Program 7 — Bank Account System

Created an abstract:

```java
abstract class BankAccount
```

Common fields:

```text
accountNumber
accountHolder
balance
```

Abstract operations:

```java
abstract void deposit(double amount);

abstract void withdraw(double amount);
```

Concrete operation:

```java
void displayAccountDetails()
```

Child classes:

```text
BankAccount
├── SavingsAccount
└── CurrentAccount
```

### Savings Account

Withdrawal is allowed only when:

```text
withdrawal amount <= current balance
```

### Current Account

Supports an overdraft limit.

Example:

```text
Balance = 50000
Overdraft Limit = 10000

Maximum withdrawal = 60000
```

This exercise combined:

```text
Abstraction
+
Encapsulation
+
Inheritance
+
Method Overriding
+
Runtime Polymorphism
```

---

# 20. Important Design Pattern Learned

The major design pattern practiced throughout these exercises is:

```text
Parent
│
├── Common data
├── Common behavior
└── Abstract behavior
        │
        ├── Child A implementation
        └── Child B implementation
```

The parent defines the **contract**.

The child defines the **implementation**.

---

# 21. When Should a Method Be Abstract?

A method should generally be abstract when:

* Every child must provide that behavior
* The parent cannot provide one meaningful implementation
* Different child classes require different implementations

Example:

```java
abstract void calculateSalary();
```

A full-time employee and part-time employee calculate salary differently.

Therefore the parent declares the method abstract.

---

# 22. When Should a Method Be Concrete?

A method should be concrete when:

* The behavior is common to all subclasses
* The same implementation can be reused

Example:

```java
void displayEmployeeDetails()
```

Both full-time and part-time employees need the same basic employee information.

Therefore the behavior can be implemented once in the parent.

---

# 23. Key Syntax

### Abstract class

```java
abstract class Parent {

}
```

### Abstract method

```java
abstract void methodName();
```

### Child class

```java
class Child extends Parent {

    @Override
    void methodName() {

    }

}
```

### Runtime polymorphism

```java
Parent reference = new Child();
```

---

# 24. Key Takeaways

* An abstract class cannot be instantiated directly.
* An abstract class can contain both abstract and concrete methods.
* An abstract class can have constructors.
* An abstract class can contain instance variables.
* Abstract methods do not have an implementation in the parent.
* Concrete child classes must implement inherited abstract methods.
* Abstract classes work naturally with inheritance.
* Abstract classes can be used as parent references.
* Abstract classes support runtime polymorphism.
* Encapsulation can be combined with abstraction.
* Common behavior belongs in the parent.
* Specialized behavior can be implemented by child classes.
* Abstraction focuses on exposing essential behavior while hiding implementation details.

---

# 25. Day 61 Part 1 Practice Summary

| Program             | Main Concept                               |
| ------------------- | ------------------------------------------ |
| Animal Behaviours   | Abstract methods                           |
| Animal Sounds       | Basic abstraction                          |
| Area of Shapes      | Abstraction + encapsulation                |
| Bird Behaviours     | Multiple abstract methods                  |
| Volume of 3D Shapes | Abstract + concrete methods                |
| Employee Payroll    | Abstraction + polymorphism                 |
| Bank Account System | Abstraction + encapsulation + polymorphism |

---

# 26. Day 61 Part 1 Status

```text
CORE JAVA — DAY 61

Part 1: Abstraction
Status: COMPLETED ✅

Topics:
├── Abstract Class
├── Abstract Method
├── Concrete Method
├── Abstract Class Constructor
├── Inheritance
├── Method Overriding
├── Encapsulation
├── Runtime Polymorphism
└── Real-World Abstraction

Practice:
├── Animal Behaviours
├── Animal Sounds
├── Area of Shapes
├── Bird Behaviours
├── Volume of 3D Shapes
├── Employee Payroll System
└── Bank Account System
```

---

# Next

## Day 61 — Part 2

### Core Java — Interface

Topics to cover:

* What is an interface?
* Interface syntax
* Interface methods
* Interface variables
* Implementing an interface
* Multiple interfaces
* Interface + polymorphism
* Interface vs abstract class
* Real-world interface design
* Practical interface exercises

```

**Day 61 Part 1 is now closed.** Tomorrow we start **Interface** as Part 2, and we'll build from the abstraction concepts you just practiced rather than restarting OOP from scratch.
```
