````markdown
# ☕ Day 57 — Core Java: Method Overloading — Part 1 & Part 2

## 📌 Overview

Day 57 focused on **Method Overloading in Java**, an important concept of **compile-time polymorphism**.

The practice was structured using multiple practical and real-world examples to understand how Java allows methods with the same name to perform different operations based on their parameter list.

---

## 📚 Topics Covered

- Method Overloading
- Compile-Time Polymorphism
- Overloading based on Number of Parameters
- Overloading based on Parameter Data Types
- Overloading based on Parameter Order
- Static Method Overloading
- Practical Method Overloading
- Real-World Utility Methods
- Method Return Values
- Integer and Decimal Calculations
- String-Based Method Overloading
- Employee Utility Methods
- Maximum Value Operations
- Area Calculations
- Interview-Oriented Overloading Problems

---

## 📂 Folder Structure

```text
DAY_57_Method_Overloading/
│
└── src/
    └── day57/
        ├── MethodOverloadingBasics_01.java
        ├── ParameterOverloading_02.java
        ├── TypeOverloading_03.java
        ├── OrderOverloading_04.java
        ├── StaticMethodOverloading_05.java
        ├── Calculator_06.java
        ├── AreaCalculator_07.java
        ├── MaxValue_08.java
        ├── StringUtility_09.java
        ├── EmployeeUtility_10.java
        ├── OverloadingProblems_11.java
        └── Main.java
````

---

# 1️⃣ MethodOverloadingBasics_01.java

### Concepts Practiced

* Basic method overloading
* Same method name with different parameters
* Different number of parameters
* Different parameter data types
* Practical `display()` methods
* `showNumber()` overloading
* `printDetails()` overloading
* `calculate()` overloading

### Examples

```text
display()
display(String)
display(String, int)

showNumber(int)
showNumber(double)
showNumber(String)

printDetails(String)
printDetails(String, int)
printDetails(String, int, double)

calculate(int, int)
calculate(int, int, int)
calculate(double, double)
```

---

# 2️⃣ ParameterOverloading_02.java

### Concepts Practiced

* Method overloading using different numbers of parameters
* Integer calculations
* Decimal calculations
* Employee information
* Salary calculations
* Product calculations
* Average calculations

### Practical Methods

```text
calculateSum()
calculateAverage()
printEmployee()
calculateSalary()
displayProduct()
```

Examples included:

```text
calculateSum(int, int)
calculateSum(int, int, int)
calculateSum(int, int, int, int)

calculateSum(double, double)
calculateSum(double, double, double)

calculateAverage(int, int)
calculateAverage(int, int, int)
calculateAverage(double, double, double)

printEmployee(String)
printEmployee(String, int)
printEmployee(String, int, double)

calculateSalary(double)
calculateSalary(double, double)
calculateSalary(double, double, double)

displayProduct(String)
displayProduct(String, double)
displayProduct(String, double, int)
```

---

# 3️⃣ TypeOverloading_03.java

### Concepts Practiced

* Method overloading using different parameter types
* Integer vs decimal values
* Payment processing
* Product searching
* Discount calculation
* Interest calculation
* User creation

### Practical Methods

```text
calculateInterest()
calculateBill()
calculateDiscount()
processPayment()
createUser()
searchProduct()
```

Examples:

```text
processPayment(int)
processPayment(double)
processPayment(String)

searchProduct(int)
searchProduct(String)
searchProduct(double)
```

These examples demonstrated how the same operation can accept different types of input.

---

# 4️⃣ OrderOverloading_04.java

### Concepts Practiced

* Method overloading based on parameter order
* Same method name
* Same number of parameters
* Different parameter order
* Practical business operations

### Practical Methods

```text
processOrder()
employeeDetails()
paymentDetails()
productDetails()
bookTicket()
deliveryDetails()
```

Examples:

```text
processOrder(String, int)
processOrder(int, String)

paymentDetails(String, double)
paymentDetails(double, String)

employeeDetails(String, int)
employeeDetails(int, String)

bookTicket(String, int)
bookTicket(int, String)
```

This demonstrated that Java can distinguish overloaded methods based on the **order of parameter types**.

---

# 5️⃣ StaticMethodOverloading_05.java

### Concepts Practiced

* Static methods
* Static method overloading
* Calling static overloaded methods using the class name
* Utility-style methods
* Tax calculation
* Invoice generation
* Shipping calculation
* Currency conversion

### Practical Methods

```text
calculateTax()
generateInvoice()
calculateShipping()
convertCurrency()
```

Examples:

```text
calculateTax(double)
calculateTax(double, double)
calculateTax(double, double, double)

generateInvoice(String, double)
generateInvoice(int, double)
generateInvoice(String, int, double)

calculateShipping(double)
calculateShipping(double, double)
calculateShipping(double, double, boolean)

convertCurrency(double)
convertCurrency(double, double)
```

---

# 6️⃣ Calculator_06.java

### Concepts Practiced

* Real-world method overloading
* Returning values from overloaded methods
* Integer calculations
* Decimal calculations
* Percentage calculations
* Average calculations
* EMI calculation
* Discount calculation

### Practical Methods

```text
add()
subtract()
multiply()
calculatePercentage()
calculateAverage()
calculateEMI()
calculateDiscount()
```

Examples:

```text
add(int, int)
add(double, double)
add(int, int, int)
add(double, double, double)

subtract(int, int)
subtract(double, double)

multiply(int, int)
multiply(double, double)

calculateAverage(int, int)
calculateAverage(int, int, int)
calculateAverage(double, double)
calculateAverage(double, double, double)

calculateEMI(double, double, int)

calculateDiscount(double, int)
calculateDiscount(double, double)
calculateDiscount(double, double, double)
```

---

# 7️⃣ AreaCalculator_07.java

### Concepts Practiced

* Real-world method overloading
* Area calculations
* Different parameter counts
* Different parameter data types
* Parameter combinations
* Integer and decimal calculations
* Circle, square, rectangle and triangle calculations
* Heron's Formula

### Practical Methods

```text
area()
```

Examples:

```text
area(int)

area(int, int)

area(double)

area(double, double)

area(float, String)

area(int, int, String)

area(double, double, String)

area(int, int, boolean)

area(double, double, double)

area(double, String, boolean)
```

This demonstrated how overloaded methods can handle different shapes and different combinations of parameters.

---

# 8️⃣ MaxValue_08.java

### Concepts Practiced

* Finding maximum values
* Method overloading
* Integer and decimal values
* Different parameter counts
* Mixed data types
* String comparison
* Practical utility methods

### Practical Methods

```text
max()
```

Examples:

```text
max(int, int)

max(double, double)

max(int, int, int)

max(double, double, double)

max(int, double)

max(double, int)

max(float, float)

max(long, long)

max(String, String)

max(int, int, String)
```

This demonstrated method overloading with different numeric types as well as String values.

---

# 9️⃣ StringUtility_09.java

### Concepts Practiced

* String utility operations
* String-based method overloading
* Character counting
* Character access
* String reversal
* String concatenation
* Substring extraction
* Character replacement
* Different parameter types and combinations

### Practical Methods

```text
process()
```

Examples:

```text
process(String)

process(String, String)

process(String, char)

process(String, int)

process(String, boolean)

process(String, String, String)

process(String, int, int)

process(String, char, char)

process(String, String, String, boolean)
```

This demonstrated how a single utility method name can support different String operations through overloading.

---

# 🔟 EmployeeUtility_10.java

### Concepts Practiced

* Real-world employee operations
* Employee information
* Salary calculations
* Bonus calculations
* Experience calculations
* Method overloading
* Different parameter combinations

### Practical Methods

```text
employeeDetails()
calculateSalary()
calculateBonus()
calculateExperience()
```

Examples:

```text
employeeDetails(int)
employeeDetails(int, String)
employeeDetails(int, String, String)
employeeDetails(int, String, double)
employeeDetails(String, String, double)

calculateSalary(double)
calculateSalary(double, double)
calculateSalary(double, double, double)

calculateBonus(double, int)
calculateBonus(double, double)

calculateExperience(int, int)
calculateExperience(int, int, String)
```

These examples demonstrated how method overloading can be applied to real-world employee and business operations.

---

# 1️⃣1️⃣ OverloadingProblems_11.java

### Concepts Practiced

* Interview-oriented method overloading
* Parameter count
* Parameter data types
* Parameter order
* Mixed data types
* String and numeric overloading
* Compile-time method selection
* Type conversion scenarios

### Practical Methods

```text
display()
calculate()
print()
convert()
```

Examples:

```text
display(int)
display(double)
display(String)

display(int, String)
display(String, int)

calculate(int, int)
calculate(double, double)
calculate(int, double)
calculate(double, int)

print(String)
print(String, int)
print(int, String)

convert(int)
convert(double)
convert(String)
```

This file focused on practical and interview-style scenarios for understanding how Java selects the correct overloaded method.

---

# 🧠 Key Learnings

* Method overloading allows multiple methods to have the **same name with different parameter lists**.
* Java determines the correct overloaded method at **compile time**.
* Overloading can be achieved using:

  * Different number of parameters
  * Different parameter data types
  * Different parameter order
* Changing only the return type does **not** create method overloading.
* Static methods can also be overloaded.
* Overloaded methods can return values just like normal methods.
* Method overloading improves code readability and provides flexibility when handling different types of input.
* Overloaded methods can be used for real-world utilities such as calculators, employee services, payment processing, String utilities and business operations.
* Java can select overloaded methods based on the arguments supplied during the method call.
* `String.compareTo()` can be used when comparing String values lexicographically.

---

# 🔥 Method Overloading Summary

```text
                    Same Method Name
                           │
          ┌────────────────┼────────────────┐
          │                │                │
          ↓                ↓                ↓
 Different Number   Different Types   Different Order
  of Parameters      of Parameters    of Parameters
          │                │                │
          └────────────────┼────────────────┘
                           ↓
                 Method Overloading
                           ↓
               Compile-Time Polymorphism
```

---

# 💻 Development Environment

* Java
* Eclipse IDE
* JDK
* Git
* GitHub

---

# 📈 Day 57 Progress

### Core Java — Part 1

* [x] Method Overloading Basics
* [x] Parameter Overloading
* [x] Type Overloading
* [x] Order Overloading
* [x] Static Method Overloading
* [x] Real-World Calculator Overloading

### Core Java — Part 2

* [x] Area Calculator Overloading
* [x] Maximum Value Overloading
* [x] String Utility Overloading
* [x] Employee Utility Overloading
* [x] Interview-Oriented Overloading Problems

### Status

**Day 57 Core Java — Part 1 & Part 2: ✅ Completed**

---

# 🎯 Next Goal

Continue with:

**Day 57 — JDBC: Advanced Transactions — Part 2**

Remaining practical classes:

```text
OrderTransaction.java
PaymentTransaction.java
AccountTransaction.java
ExceptionTransaction.java
TransactionProblems.java
App.java
```

---

## 👨‍💻 Author

**Jaganmohan Reddy**

GitHub: `JaganReddy-33`

---

## 🚀 Day 57 — Keep Building. Keep Practicing. Keep Coding.

```
```
