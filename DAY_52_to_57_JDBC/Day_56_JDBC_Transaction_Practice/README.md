````markdown
# 📘 Day 56 — JDBC Transactions & ACID Properties

> **100 Days Full Stack Developer Challenge**  
> **Day 56 — JDBC Practical Transactions**

---

## 📌 Day Overview

On Day 56 of the JDBC journey, I focused on **database transactions using JDBC and MySQL**.

The main goal was to understand how multiple database operations can be treated as a **single reliable unit of work** using:

- `setAutoCommit(false)`
- `commit()`
- `rollback()`
- `Savepoint`
- `PreparedStatement`
- `ResultSet`
- Exception handling
- Transaction boundaries
- Business-rule validation
- Transaction verification using a new connection

The practical exercises were designed around **real-world banking/account transaction scenarios**.

---

# 🎯 Learning Objectives

By the end of Day 56, I practiced how to:

- Understand JDBC transactions
- Disable automatic commit
- Manually commit successful transactions
- Roll back failed transactions
- Handle multiple database operations as one transaction
- Validate business rules before modifying data
- Roll back transactions when a business condition fails
- Use multiple `PreparedStatement` objects inside one transaction
- Use `ResultSet` to validate account information
- Use `Savepoint` for partial rollback
- Handle exceptions during transactions
- Verify committed data using a new database connection
- Understand the practical behavior of transaction states

---

# 🧠 JDBC Transaction Fundamentals

## What is a Transaction?

A transaction is a group of database operations that should be treated as **one logical unit of work**.

For example, transferring ₹1000 from Account A to Account B involves:

```text
Account A → Debit ₹1000
Account B → Credit ₹1000
````

Both operations should succeed together.

If the debit succeeds but the credit fails, the debit should also be undone.

This is where transactions are important.

---

# 🔄 Transaction Flow

The basic JDBC transaction flow practiced today was:

```text
Connection
    ↓
setAutoCommit(false)
    ↓
Execute SQL Operations
    ↓
Validate Results
    ↓
Success?
 ┌──┴──┐
YES    NO
 ↓      ↓
commit rollback
```

---

# ⚙️ Important JDBC Transaction Methods

## `setAutoCommit(false)`

Disables automatic committing.

```java
con.setAutoCommit(false);
```

After this, database changes remain part of the current transaction until:

```java
con.commit();
```

or

```java
con.rollback();
```

---

## `commit()`

Permanently saves the transaction changes.

```java
con.commit();
```

---

## `rollback()`

Cancels the changes made during the current transaction.

```java
con.rollback();
```

---

## `setSavepoint()`

Creates a point inside a transaction to which we can partially roll back.

```java
Savepoint savepoint = con.setSavepoint("SAVEPOINT_NAME");
```

Then:

```java
con.rollback(savepoint);
```

---

# 🏦 Database Used for Practice

The practical transaction exercises used the `accounts` table.

```sql
CREATE DATABASE jdbc_acid_db;

USE jdbc_acid_db;

CREATE TABLE accounts (
    account_id INT PRIMARY KEY,
    account_holder VARCHAR(100) NOT NULL,
    balance DECIMAL(10,2) NOT NULL
);
```

Sample data:

```sql
INSERT INTO accounts (account_id, account_holder, balance) VALUES
(1, 'Jagan', 5000.00),
(2, 'Lohith', 3000.00),
(3, 'AJay', 7500.00),
(4, 'Kiran', 4500.00),
(5, 'Priya', 6000.00);
```

---

# 📚 Part 1 — Core Transaction Practice

## Question 1 — Basic Debit Transaction + Commit

### Objective

Perform a withdrawal transaction from an account.

### Flow

```text
Enter Account ID
        ↓
Check Account Balance
        ↓
Account Exists?
        ↓
Display Existing Balance
        ↓
Enter Withdrawal Amount
        ↓
Validate Amount
        ↓
Check Sufficient Balance
        ↓
Debit Account
        ↓
commit()
```

### Concepts Practiced

* `Connection`
* `PreparedStatement`
* `ResultSet`
* `SELECT`
* `UPDATE`
* `setAutoCommit(false)`
* `commit()`
* `rollback()`
* Input validation
* Account existence validation
* Balance validation

### Important Learning

The database should not be updated before validating the withdrawal amount.

The correct order is:

```text
Check balance
     ↓
Validate amount
     ↓
Execute UPDATE
     ↓
Commit
```

---

# Question 2 — Multiple Operations in One Transaction

### Objective

Perform multiple database operations inside one transaction.

Scenario:

```text
Source Account
      ↓
    Debit
      ↓
Destination Account
      ↓
    Credit
      ↓
    commit()
```

### Concepts Practiced

* Multiple `PreparedStatement` objects
* Multiple `UPDATE` operations
* One transaction boundary
* `executeUpdate()`
* Checking affected rows
* `commit()`
* `rollback()`

### Important Learning

Both operations belong to the same transaction.

If:

```text
Debit → SUCCESS
Credit → SUCCESS
```

then:

```java
con.commit();
```

If:

```text
Debit → SUCCESS
Credit → FAILURE
```

then:

```java
con.rollback();
```

This prevents partial transaction results.

---

# Question 3 — Bank Transfer Transaction

### Objective

Implement a realistic bank transfer.

Example:

```text
Jagan
Account 1
₹5000

        ↓ Transfer ₹1000

Lohith
Account 2
₹3000
```

After successful transaction:

```text
Jagan  → ₹4000
Lohith → ₹4000
```

### Validation Flow

```text
Sender Account
      ↓
Check Sender Exists
      ↓
Check Sender Balance
      ↓
Check Amount
      ↓
Receiver Account
      ↓
Check Receiver Exists
      ↓
Debit Sender
      ↓
Credit Receiver
      ↓
commit()
```

### Concepts Practiced

* Transaction boundaries
* Multiple SQL operations
* `SELECT`
* `UPDATE`
* `PreparedStatement`
* `ResultSet`
* Account validation
* Sufficient balance validation
* Commit
* Rollback

### Real-World Concept

A money transfer should never produce:

```text
Sender debited
Receiver not credited
```

Both operations must be treated as one transaction.

---

# Question 4 — Business Rule Failure + Rollback

### Objective

Understand that a transaction can fail because of a **business rule**, even when SQL itself executes successfully.

Examples:

```text
Invalid amount
Insufficient balance
Sender account doesn't exist
Receiver account doesn't exist
Debit operation failed
Credit operation failed
```

### Transaction Flow

```text
Start Transaction
       ↓
Validate Input
       ↓
Validate Sender
       ↓
Validate Balance
       ↓
Validate Receiver
       ↓
Debit
       ↓
Credit
       ↓
Everything Successful?
     /       \
   YES        NO
    ↓          ↓
 commit     rollback
```

### Important Learning

Not every failure produces a Java `SQLException`.

For example:

```java
int rows = stmt.executeUpdate();
```

may return:

```text
0
```

if no record was affected.

Therefore, checking the affected row count is important:

```java
if (rows != 1) {
    con.rollback();
}
```

---

# Question 5 — Complete Transaction + Verification

### Objective

Commit a transaction and verify that the committed data is actually persisted.

### Flow

```text
Get Account ID
      ↓
Get Amount
      ↓
Validate Amount
      ↓
Execute UPDATE
      ↓
Check Result
      ↓
commit()
      ↓
Close Connection
      ↓
Create NEW Connection
      ↓
SELECT Balance
      ↓
Verify Data
```

### Concepts Practiced

* Transaction commit
* `setAutoCommit(false)`
* `executeUpdate()`
* `commit()`
* New database connection
* `SELECT`
* `ResultSet`
* Data verification

### Important Learning

A successful:

```java
con.commit();
```

means the transaction has been committed.

The exercise then used a **new connection** to verify that the committed value can be retrieved.

---

# 📚 Part 2 — Additional Transaction Practice

After completing the primary five transaction problems, I practiced additional transaction concepts.

---

# Question 6 — Savepoint + Partial Rollback

### Objective

Understand how a transaction can roll back only part of its operations.

Example:

```text
Transaction Started
       ↓
First Deposit
       ↓
Create Savepoint
       ↓
Second Deposit
       ↓
Second Operation Fails
       ↓
rollback(savepoint)
       ↓
First Deposit Remains
       ↓
commit()
```

### Important Methods

Create savepoint:

```java
Savepoint savepoint =
        con.setSavepoint("AFTER_FIRST_DEPOSIT");
```

Rollback to savepoint:

```java
con.rollback(savepoint);
```

Commit remaining transaction:

```java
con.commit();
```

### Key Difference

Normal rollback:

```java
con.rollback();
```

means:

```text
Rollback entire transaction
```

Savepoint rollback:

```java
con.rollback(savepoint);
```

means:

```text
Rollback only changes after the savepoint
```

### Practical Understanding

```text
Operation 1
    ↓
Savepoint
    ↓
Operation 2
    ↓
Failure
    ↓
Rollback to Savepoint
    ↓
Operation 1 remains
```

---

# Question 7 — Exception During Transaction + Full Rollback

### Objective

Understand how an exception occurring during a transaction can cause the entire transaction to be rolled back.

### Flow

```text
Start Transaction
       ↓
Operation 1
       ↓
SUCCESS
       ↓
Operation 2
       ↓
Exception / Failure
       ↓
catch
       ↓
rollback()
```

### Concepts Practiced

* `try`
* `catch`
* `SQLException`
* `rollback()`
* Multiple operations
* Transaction failure handling

### Important Learning

Suppose:

```text
Operation 1 → SUCCESS
Operation 2 → FAILURE
```

Without rollback:

```text
Operation 1 remains
```

With rollback:

```text
Operation 1 → UNDONE
Operation 2 → FAILED
```

Therefore:

```java
try {
    // transaction operations

    con.commit();

} catch (SQLException e) {

    con.rollback();
}
```

is an important transaction pattern.

---

# Question 8 — Transaction State + Commit/Rollback Verification

### Objective

Understand what happens to data before and after committing a transaction.

### Flow

```text
Read Initial Balance
        ↓
Start Transaction
        ↓
Update Balance
        ↓
Read Balance Inside Transaction
        ↓
commit()
        ↓
Close Connection
        ↓
Create New Connection
        ↓
Read Balance Again
        ↓
Verify Committed Data
```

### Concepts Practiced

* Transaction state
* Uncommitted changes
* Committed changes
* `SELECT`
* `UPDATE`
* `commit()`
* New connection
* `ResultSet`

### Important Learning

A transaction has a lifecycle:

```text
Transaction Started
       ↓
Changes Made
       ↓
Changes Pending
       ↓
commit()
       ↓
Changes Persisted
```

---

# 🧩 Complete Day 56 Question List

| Question | Topic                   | Main Concept                      |
| -------- | ----------------------- | --------------------------------- |
| Q1       | Basic Debit Transaction | `commit()`                        |
| Q2       | Multiple Operations     | Multiple statements + transaction |
| Q3       | Bank Transfer           | Debit + Credit                    |
| Q4       | Business Rule Failure   | `rollback()`                      |
| Q5       | Commit + Verification   | New connection verification       |
| Q6       | Savepoint               | Partial rollback                  |
| Q7       | Exception Handling      | Full rollback                     |
| Q8       | Transaction State       | Commit verification               |

---

# 🔑 JDBC Concepts Practiced

### Connection

```java
Connection con = ConnectionEx.getConnection();
```

### Disable Auto Commit

```java
con.setAutoCommit(false);
```

### PreparedStatement

```java
PreparedStatement stmt =
        con.prepareStatement(SQL);
```

### Execute Query

```java
ResultSet rs = stmt.executeQuery();
```

### Execute Update

```java
int rows = stmt.executeUpdate();
```

### Commit

```java
con.commit();
```

### Rollback

```java
con.rollback();
```

### Savepoint

```java
Savepoint savepoint =
        con.setSavepoint("SAVEPOINT");
```

### Rollback to Savepoint

```java
con.rollback(savepoint);
```

---

# 🔐 Transaction Safety Pattern

The general pattern practiced throughout Day 56 was:

```java
con.setAutoCommit(false);

try {

    // Validate data

    // Execute operation 1

    // Execute operation 2

    // Validate results

    con.commit();

} catch (SQLException e) {

    con.rollback();

}
```

The exact implementation changes depending on the transaction scenario.

---

# 🛡️ Resource Management

The exercises also used **try-with-resources** for JDBC resources.

Example:

```java
try (Connection con = ConnectionEx.getConnection();
     PreparedStatement stmt = con.prepareStatement(SQL)) {

}
```

For `ResultSet`:

```java
try (ResultSet rs = stmt.executeQuery()) {

}
```

This helps automatically close:

* `Connection`
* `PreparedStatement`
* `ResultSet`

---

# 💡 Major Learnings from Day 56

## 1. Auto Commit

By default, JDBC connections generally operate with auto-commit enabled.

For multi-step transactions:

```java
con.setAutoCommit(false);
```

is required so the operations can be committed or rolled back together.

---

## 2. Commit

`commit()` makes the transaction's changes permanent.

```java
con.commit();
```

---

## 3. Rollback

`rollback()` reverses changes made in the current transaction.

```java
con.rollback();
```

---

## 4. Transactions Prevent Partial Updates

For example:

```text
Debit ₹1000
Credit ₹1000
```

If credit fails after debit succeeds, rollback can undo the debit.

---

## 5. Business Validation Is Important

SQL executing successfully does not always mean the operation is logically valid.

We must also check:

```text
Account exists?
Amount valid?
Sufficient balance?
Correct destination?
Rows affected?
```

---

## 6. `executeUpdate()` Returns Affected Rows

For an `UPDATE`:

```java
int rows = stmt.executeUpdate();
```

Possible result:

```text
1 → one record updated
0 → no record updated
```

Therefore, checking:

```java
if (rows != 1)
```

is useful for detecting failed business operations.

---

## 7. Savepoints Allow Partial Rollback

A savepoint allows the transaction to return to a specific point instead of cancelling everything.

```java
con.rollback(savepoint);
```

---

## 8. Exception Handling and Transactions Work Together

When an unexpected database error occurs:

```java
catch (SQLException e) {
    con.rollback();
}
```

can prevent partial transaction changes.

---

# 🏦 Real-World Banking Example

A real banking transfer can conceptually be represented as:

```text
BEGIN TRANSACTION

        ↓

Validate Sender

        ↓

Validate Receiver

        ↓

Check Balance

        ↓

Debit Sender

        ↓

Credit Receiver

        ↓

Everything Successful?

     /              \
   YES              NO
    ↓                ↓
 COMMIT           ROLLBACK

    ↓                ↓
Money Transfer    No Partial
Completed          Transfer
```

This is one of the most important practical applications of JDBC transactions.

---

# 🧠 Day 56 Transaction Mental Model

The most important thing I learned is:

```text
Transaction
     =
Multiple database operations
     +
One logical unit of work
     +
Validation
     +
Commit / Rollback
```

Or:

```text
START
  ↓
OPERATE
  ↓
VALIDATE
  ↓
SUCCESS ─────→ COMMIT
  │
  └── FAILURE → ROLLBACK
```

---

# 🏆 Day 56 JDBC Progress

```text
JDBC Fundamentals          ✅
JDBC Connection            ✅
PreparedStatement          ✅
ResultSet                  ✅
SQL Injection Prevention   ✅
Batch Processing           ✅
ACID Properties            ✅
Transactions               ✅
Auto Commit                ✅
Manual Commit              ✅
Rollback                   ✅
Business Validation        ✅
Bank Transfer              ✅
Exception Rollback         ✅
Savepoints                 ✅
Transaction Verification   ✅
```

---

# 🛠️ Technology Stack

* Java
* JDBC
* MySQL
* Eclipse IDE
* Maven
* PreparedStatement
* ResultSet
* SQL Transactions

---

# 📂 Day 56 Practical Files

```text
Day_56_JDBC_Transactions
│
├── Question1.java
├── Question2.java
├── Question3.java
├── Question4.java
├── Question5.java
├── Question6.java
├── Question7.java
├── Question8.java
├── ConnectionEx.java
└── App.java
```

---

# 📈 100 Days Challenge Progress

### Day 56 — JDBC Transactions

**Status: ✅ Completed**

Today's focus:

```text
JDBC
  ↓
Transactions
  ↓
Commit / Rollback
  ↓
Business Validation
  ↓
Banking Transactions
  ↓
Savepoints
  ↓
Exception Handling
  ↓
Transaction Verification
```

---

# 🚀 Next Goal

Continue with the next planned backend/JDBC topic after completing Day 56.

The focus will continue to move from basic JDBC operations toward **more realistic backend database development and transaction-based applications**.

---

# 👨‍💻 Author

**Jaganmohan Reddy**

Electronics & Communication Engineering Graduate
Java Backend / Full Stack Developer
---

## 🔥 Day 56 Final Takeaway

> **A database transaction should be treated as one logical unit of work: validate the operation, execute all required statements, commit only when everything succeeds, and rollback when something goes wrong.**

Day 56 strengthened my practical understanding of **JDBC Transactions, ACID concepts, commit, rollback, savepoints, business-rule validation, exception handling, and real-world banking transaction flows.**

```
```
