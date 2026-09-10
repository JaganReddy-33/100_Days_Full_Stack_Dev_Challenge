
````markdown
# ☕ Day 57 — Core Java: Method Overloading — Part 1

## 📌 Overview

Day 57 Part 1 focused on **Method Overloading in Java**, one of the important concepts of compile-time polymorphism.

The practice was structured using multiple real-world examples to understand how Java allows methods with the same name to perform different operations based on their parameter list.

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

---

## 📂 Part 1 Folder Structure

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
        └── Calculator_06.java
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
* Same parameter types
* Different parameter order

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
* Real-world applications commonly use overloaded utility and service methods.

---

# 🔥 Method Overloading Summary

```text
Same Method Name
       │
       ├── Different Number of Parameters
       │
       ├── Different Parameter Types
       │
       └── Different Parameter Order
                │
                ↓
       Method Overloading
                │
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

### Status

**Day 57 Core Java — Part 1: ✅ Completed**

---

# 🎯 Next Goal

Continue with:

**Day 57 Core Java — Part 2**

Remaining practical classes:

```text
AreaCalculator.java
MaxValue.java
StringUtility.java
EmployeeUtility.java
OverloadingProblems.java
Main.java
```

---

## 👨‍💻 Author

**Jaganmohan Reddy**

GitHub: `JaganReddy-33`

---

## 🚀 Day 57 — Keep Building. Keep Practicing. Keep Coding.

```
```
