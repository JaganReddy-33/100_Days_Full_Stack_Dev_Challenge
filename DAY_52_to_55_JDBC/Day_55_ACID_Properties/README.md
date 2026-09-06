
## 📘 JDBC Day 55 README

````markdown
# 🚀 Day 55 — JDBC ACID Properties: Atomicity

> **100 Days Full Stack Development Challenge — Java Backend Journey**

## 📅 Day Overview

Day 55 of the JDBC journey focused on understanding **ACID Properties**, starting with the first and most fundamental property:

> **A — Atomicity**

The practical focus was on understanding how JDBC transactions ensure that a group of database operations behaves as **one indivisible unit**.

---

## 🎯 Objective

The objective of Day 55 was to:

- Understand the meaning of Atomicity
- Understand the **All-or-Nothing** principle
- Work with JDBC transactions
- Use `setAutoCommit(false)`
- Use `commit()`
- Use `rollback()`
- Perform multiple database operations inside a transaction
- Handle transaction failures
- Understand Atomicity through real-world bank-transfer scenarios
- Practice transaction handling using `PreparedStatement`

---

# 🔐 ACID Properties

ACID represents four fundamental properties of reliable database transactions:

| Property | Meaning |
|---|---|
| **A — Atomicity** | All operations succeed or none take effect |
| **C — Consistency** | Database moves from one valid state to another |
| **I — Isolation** | Concurrent transactions do not interfere incorrectly |
| **D — Durability** | Committed data remains permanently saved |

### Day 55 Progress

**A — Atomicity → Completed ✅**

The remaining properties will be continued in the next practice session.

---

# 1️⃣ Atomicity

Atomicity means:

> **A transaction is treated as one logical unit of work. Either all operations succeed, or all changes are rolled back.**

### Example

A bank transfer contains:

```text
Debit Account A
      ↓
Credit Account B
````

If both operations succeed:

```text
COMMIT
```

If any operation fails:

```text
ROLLBACK
```

The successful operations performed before the failure are also undone.

---

# 2️⃣ JDBC Transaction Control

The main JDBC transaction methods practiced today were:

| Method                 | Purpose                                 |
| ---------------------- | --------------------------------------- |
| `setAutoCommit(false)` | Enables manual transaction control      |
| `commit()`             | Permanently saves the transaction       |
| `rollback()`           | Reverts changes made in the transaction |

### Transaction Flow

```text
Connection
    ↓
setAutoCommit(false)
    ↓
Operation 1
    ↓
Operation 2
    ↓
Operation 3
    ↓
All Successful?
   ↙       ↘
 YES       NO
 ↓          ↓
COMMIT    ROLLBACK
```

---

# 3️⃣ PreparedStatement + Transactions

The practical programs used `PreparedStatement` together with JDBC transaction management.

Typical structure:

```java
connection.setAutoCommit(false);

try {
    // database operations

    connection.commit();

} catch (SQLException e) {
    connection.rollback();
}
```

This allows multiple SQL statements to be handled as one transaction.

---

# 🧪 Practice Questions Completed

## Q1 — Deduct Money and Commit

Implemented a transaction that deducts money from an account and commits the operation successfully.

### Concepts practiced

* `PreparedStatement`
* `setAutoCommit(false)`
* `executeUpdate()`
* `commit()`
* SQLException handling

---

## Q2 — Add Money and Commit

Implemented a transaction that adds money to an account and commits the change.

### Concepts practiced

* Transaction boundaries
* PreparedStatement parameters
* Manual commit
* Exception handling

---

## Q3 — Two Operations with Rollback

Performed two account operations:

```text
Debit Account
      ↓
Credit Account
```

If either operation fails, the transaction is rolled back.

### Main concept

```text
Operation 1 ✅
Operation 2 ❌
     ↓
ROLLBACK
     ↓
Operation 1 is also undone
```

This demonstrates the **All-or-Nothing** behavior of Atomicity.

---

## Q4 — Jagan to Lohith Transfer

Implemented a practical bank-transfer transaction:

```text
Jagan
  ↓
₹1000 deducted

Lohith
  ↑
₹1000 credited
```

Both operations are committed only when the complete transaction succeeds.

---

## Q5 — Failed Transfer

Implemented a transaction where the destination account intentionally uses an invalid account ID.

Flow:

```text
Debit operation
      ↓
Credit operation fails
      ↓
SQLException
      ↓
ROLLBACK
```

This demonstrated how Atomicity protects the database from partial transactions.

---

## Q6 — Multiple Operations Transaction

Implemented a transaction containing multiple account updates.

Operations included:

```text
1. Deduct money from AJay
2. Credit money to Kiran
3. Credit additional amount to another account
```

All operations are committed together.

If one operation fails:

```text
ROLLBACK
```

All changes from the transaction are reverted.

---

## Q7 — Account Existence Check

Implemented a transaction that first checks whether the destination account exists.

Flow:

```text
Check destination account
        ↓
Account exists?
    ↙          ↘
  YES           NO
   ↓             ↓
Debit          Exception
   ↓             ↓
Credit        ROLLBACK
   ↓
COMMIT
```

This demonstrated how validation can be performed inside a transaction before modifying account balances.

---

## Q8 — Complete Atomic Transaction

Implemented a transaction containing three account updates.

All three operations are committed together:

```text
Account 1 → Update
Account 2 → Update
Account 3 → Update
       ↓
     COMMIT
```

If any operation fails:

```text
ROLLBACK
```

Therefore, no partial transaction remains in the database.

---

# 🗄️ Database Used

The practical exercises used an `accounts` table with account identifiers and balances.

Example account data used during practice:

```text
1 → Jagan
2 → Lohith
3 → AJay
4 → Kiran
5 → Priya
```

The transactions were primarily performed using:

```text
account_id
balance
```

---

# 🔒 Key Concepts Learned

### Atomicity

```text
All operations succeed
        ↓
      COMMIT

Any operation fails
        ↓
     ROLLBACK
```

### Auto-Commit

By default, JDBC connections commonly operate with auto-commit enabled.

For multi-operation transactions:

```java
connection.setAutoCommit(false);
```

is used so that the application controls when the transaction is committed.

### Commit

```java
connection.commit();
```

permanently applies the successful transaction.

### Rollback

```java
connection.rollback();
```

undoes changes made during the current transaction.

---

# 🌍 Real-World Applications of Atomicity

Atomicity is essential in many backend systems.

### 💳 Banking

```text
Debit → Credit
```

Both operations must succeed.

### 🛒 E-Commerce

```text
Create Order
     ↓
Reduce Inventory
     ↓
Create Payment Record
```

A failure should prevent an incomplete order from being stored.

### 🎟️ Ticket Booking

```text
Reserve Seat
     ↓
Create Booking
     ↓
Process Payment
```

A failure should prevent inconsistent booking data.

### 💼 Payroll

```text
Deduct Employee Salary
     ↓
Create Salary Record
     ↓
Create Transaction Record
```

All related changes should succeed together.

---

# 🧠 Important Takeaway

The most important idea from today's practice:

> **Atomicity protects the database from partial transactions.**

A transaction should never leave the database in a state where only half of the required operations were completed.

---

# 📂 Project Structure

```text
JDBC/
└── src/
    └── main/
        ├── java/
        │   └── day55/
        │       ├── ConnectionEx.java
        │       ├── Atomicity.java
        │       └── App.java
        │
        └── resources/
            └── db.properties
```

> `db.properties` contains database configuration and should remain excluded from Git when it contains credentials.

---

# 🛡️ Security Practices

The practical implementation followed important JDBC practices:

* Used `PreparedStatement`
* Avoided hardcoded SQL values where parameters were appropriate
* Kept database configuration in `db.properties`
* Used try-with-resources
* Handled `SQLException`
* Used explicit transaction boundaries
* Used rollback when a transaction failed

---

# 📈 Day 55 Progress

### JDBC

* [x] Understand Transactions
* [x] Understand Atomicity
* [x] `setAutoCommit(false)`
* [x] `commit()`
* [x] `rollback()`
* [x] Transactions with PreparedStatement
* [x] Bank transfer scenario
* [x] Failed transaction scenario
* [x] Multiple operations transaction
* [x] Account validation inside transaction
* [x] 8 Atomicity practice questions

### Remaining

* [ ] Additional Atomicity practice
* [ ] C — Consistency
* [ ] I — Isolation
* [ ] D — Durability

---

# 🎯 Next Goal

Continue Day 55 with:

## C — Consistency

Understand:

* What Consistency means
* Database valid state → valid state
* Constraints and business rules
* How transactions preserve database correctness
* Real-world examples
* JDBC practice problems

After completing **Consistency**, continue with:

```text
I → Isolation
D → Durability
```

---

# 🏆 Day 55 Status

**JDBC ACID — Atomicity: COMPLETED ✅**

Today I strengthened my understanding of JDBC transaction management by implementing multiple practical transaction scenarios using `PreparedStatement`, `commit()`, and `rollback()`.

The main lesson:

> **A transaction is All or Nothing.**

---

## 💡 Backend Development Takeaway

```text
Java Application
      ↓
JDBC
      ↓
Transaction
      ↓
PreparedStatement
      ↓
Database
      ↓
COMMIT / ROLLBACK
```

Understanding transactions and ACID properties is essential before moving deeper into enterprise Java backend development.

---

# 🚀 100 Days Full Stack Challenge

**Day 55 — JDBC ACID Properties: Atomicity**

> Learning backend development by understanding the database operations behind real-world applications.

**Progress: Day 55 🔥**

---

## 👨‍💻 Author

**Jaganmohan Reddy**

Java Backend Developer in Progress 🚀

#100DaysOfCode #Java #JDBC #MySQL #BackendDevelopment #ACID #Atomicity #Database #FullStackDevelopment

