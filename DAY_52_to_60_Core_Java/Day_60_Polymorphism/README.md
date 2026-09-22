# DAY 60 — PART 1

## Core Java — Polymorphism

This part of Day 60 focused on **Polymorphism in Java**, with guided examples followed by practical portal assessment problems.

---

## 1. Topic Covered

### Polymorphism

Polymorphism means allowing the same method or reference structure to represent different behaviors.

Day 60 covered:

* Compile-Time Polymorphism
* Runtime Polymorphism
* Method Overloading
* Method Overriding
* Parent Reference with Child Object
* Dynamic Method Dispatch

---

# 2. Compile-Time Polymorphism

Compile-time polymorphism was practiced through **Method Overloading**.

### Example 01

File:

```text
day60/compiletime/MethodOverloadingEx_01.java
```

Scenario:

* Calculator
* Multiple `add()` methods
* Different parameter lists
* Integer and double values

The compiler determines which overloaded method should be called based on the arguments supplied.

### Example 02

File:

```text
day60/compiletime/MethodOverloadingEx_02.java
```

Scenario:

* Payment processing
* Multiple `makePayment()` methods
* Different parameter lists
* UPI payment
* Card payment
* Payment with description

This demonstrated how the same method name can provide different behaviors based on the method parameters.

---

# 3. Runtime Polymorphism

Runtime polymorphism was practiced through **Method Overriding**.

### Example 01

File:

```text
day60/runtime/RuntimePolymorphismEx_01.java
```

Hierarchy:

```text
Payment
   │
   ├── UPIPayment
   └── CardPayment
```

The parent class defines:

```text
processPayment()
```

The child classes override the method with their own implementation.

A parent reference was used to point to different child objects:

```text
Payment reference
      ↓
UPIPayment object
      ↓
processPayment()

Payment reference
      ↓
CardPayment object
      ↓
processPayment()
```

This demonstrated **dynamic method dispatch**.

---

### Example 02

File:

```text
day60/runtime/RuntimePolymorphismEx_02.java
```

Hierarchy:

```text
Employee
   │
   ├── Manager
   └── Developer
```

The parent class defines:

```text
calculateSalary()
```

`Manager` and `Developer` override the method with their own salary calculations.

A common `Employee` reference was used to work with different employee objects.

---

# 4. Portal Assessment Practice

After completing the guided examples, five practical polymorphism problems were solved from the portal assessment module.

No additional artificial practice problems were added.

---

## Problem 01 — Implementing Plane Flight Methods

### Concept

**Method Overriding / Runtime Polymorphism**

### Scenario

A base class `Plane` defines general flight behavior such as:

```text
fly()
```

Different plane types override the method:

```text
Plane
 ├── CargoPlane
 ├── PassengerPlane
 └── FighterPlane
```

Each subclass provides its own flying behavior.

The problem demonstrates invoking overridden methods using a parent class reference pointing to different child objects.

---

## Problem 02 — Implementing Sound Methods

### Concept

**Dynamic Method Dispatch with Inheritance**

### Scenario

A parent `Animal` class defines:

```text
sound()
```

Different animal classes override it:

```text
Animal
 ├── Dog
 ├── Cat
 └── Cow
```

When the method is called through a common `Animal` reference or through an array/loop, Java determines at runtime which implementation should execute.

---

## Problem 03 — Polymorphism with Sports Classes

### Concept

**Method Overriding and Polymorphic Behavior Across Hierarchies**

### Scenario

A base class `Sport` defines methods such as:

```text
play()
```

Different sports override the method:

```text
Sport
 ├── Rugby
 ├── Football
 └── Basketball
```

Each subclass provides behavior specific to that sport.

The common parent reference allows different sports to be handled through the same parent type.

---

## Problem 04 — Starting and Stopping Engines

### Concept

**Interface/Abstract Polymorphism for Vehicle Operations**

### Scenario

A common vehicle operation defines:

```text
startEngine()
stopEngine()
```

Different vehicle types provide their own implementation:

```text
Vehicle
 ├── Car
 ├── Bike
 └── Truck
```

The problem demonstrates polymorphic handling of different engine operations through a common abstraction.

---

## Problem 05 — Calculating Salaries

### Concept

**Polymorphic Method Call for Data Computation**

### Scenario

A generic `Employee` class provides:

```text
calculateSalary()
```

Different employee types override the method:

```text
Employee
 ├── FullTimeEmployee
 ├── PartTimeEmployee
 └── Contractor
```

Each employee type can use a different salary calculation approach.

Examples include:

* Fixed monthly salary
* Hourly rate × hours worked
* Contract-based calculation

The same polymorphic method call can therefore produce different salary calculations depending on the actual employee object.

---

# 5. Day 60 Part 1 Structure

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
    └── Portal Assessment Problems
```

The `problems` package contains the actual portal assessment practice rather than invented examples.

---

# 6. Key Concepts Practiced

```text
Polymorphism
│
├── Compile-Time Polymorphism
│   └── Method Overloading
│
└── Runtime Polymorphism
    ├── Method Overriding
    └── Dynamic Method Dispatch
```

Important Java concepts practiced:

* Method overloading
* Method overriding
* Inheritance
* Parent class reference
* Child class object
* `@Override`
* Dynamic method dispatch
* Runtime method selection
* Polymorphic method calls

---

# 7. Day 60 Part 1 Status

**Core Java — Polymorphism: COMPLETED**

Guided Examples:

* Method Overloading Example 01 — Completed
* Method Overloading Example 02 — Completed
* Runtime Polymorphism Example 01 — Completed
* Runtime Polymorphism Example 02 — Completed

Portal Assessment Practice:

* Plane polymorphism — Completed
* Animal sound polymorphism — Completed
* Sports polymorphism — Completed
* Vehicle engine polymorphism — Completed
* Employee salary polymorphism — Completed

---

## Day 60 Part 1 Conclusion

Day 60 Part 1 focused entirely on **Core Java Polymorphism**, progressing from method overloading to runtime method overriding and then applying polymorphism through five portal assessment problems.

**Status: Core Java Day 60 Part 1 — Complete**
