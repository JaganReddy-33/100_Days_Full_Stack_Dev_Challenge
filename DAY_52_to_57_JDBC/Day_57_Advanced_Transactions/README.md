
````markdown
# Day 57 — JDBC Advanced Transactions — Part 1

## 📌 Overview

Day 57 JDBC Part 1 focused on advanced transaction management using JDBC and MySQL.

The main goal was to move beyond basic `commit()` and `rollback()` from Day 56 and understand how savepoints, partial rollback, transaction validation, and multiple SQL operations can be handled inside a single transaction.

The practical work was implemented using Java, JDBC, MySQL, `Connection`, `PreparedStatement`, `ResultSet`, `Savepoint`, transactions, and exception handling.

---

## 📚 Topics Covered

### 1. Database Connection

- Reused the `ConnectionEx` utility
- Loaded database configuration from `db.properties`
- Used `Properties`
- Used `InputStream`
- Used `DriverManager`
- Created reusable JDBC connections
- MySQL JDBC Driver

---

### 2. Savepoints

Learned how to create a savepoint inside a transaction.

```java
Savepoint sp = con.setSavepoint("AFTER_FIRST_OPERATION");
````

Learned how to rollback only to a specific savepoint.

```java
con.rollback(sp);
```

Difference between:

```java
con.rollback();
```

and:

```java
con.rollback(savepoint);
```

`rollback()`:

* Rolls back the entire transaction.

`rollback(savepoint)`:

* Rolls back only the operations performed after the specified savepoint.

---

### 3. Nested Transaction Exception Handling

Practiced using nested `try-catch` blocks inside a transaction.

Example flow:

```text
Transaction Start
      ↓
Operation 1
      ↓
Savepoint 1
      ↓
try
   Operation 2
      ↓
   Savepoint 2
      ↓
   try
      Operation 3
   catch
      rollback(Savepoint 2)
catch
   rollback(Savepoint 1)
      ↓
commit()
```

This helped understand how different failures can be handled at different transaction levels.

---

### 4. Multiple Savepoints

Created multiple savepoints inside the same transaction.

Example:

```text
Operation 1
    ↓
Savepoint 1
    ↓
Operation 2
    ↓
Savepoint 2
    ↓
Operation 3
```

If Operation 3 fails:

```java
con.rollback(sp2);
```

Then Operation 3 is removed while Operations 1 and 2 remain.

If Operation 2 fails:

```java
con.rollback(sp1);
```

Then Operations 2 and 3 are removed while Operation 1 remains.

---

### 5. Partial Rollback

Learned how a transaction can preserve earlier successful operations while undoing later operations.

Example:

```text
Initial Balance
      ↓
Deposit 1
      ↓
Savepoint
      ↓
Deposit 2
      ↓
Deposit 3 fails
      ↓
rollback(savepoint)
      ↓
Deposit 1 remains
Deposit 2 removed
Deposit 3 removed
      ↓
commit()
```

This is useful when a transaction contains several stages and only later stages need to be undone.

---

### 6. Transaction Validation

Practiced validating business rules before performing database modifications.

Validations included:

* Valid account ID
* Sender account existence
* Receiver account existence
* Valid transfer amount
* Preventing zero or negative amounts
* Preventing sender and receiver from being the same
* Checking sufficient sender balance
* Checking affected rows
* Rolling back when validation fails

Transaction flow:

```text
Input
 ↓
Validation
 ↓
Account Verification
 ↓
Balance Verification
 ↓
Debit
 ↓
Credit
 ↓
Commit
```

If validation or database operation fails:

```java
con.rollback();
```

---

### 7. INSERT + UPDATE in One Transaction

Created a practical transaction involving multiple SQL operations.

The scenario was a deposit operation where:

```text
UPDATE accounts
        ↓
Increase balance
        ↓
INSERT transaction history
        ↓
COMMIT
```

Both operations must succeed.

If the account update succeeds but transaction history insertion fails:

```text
UPDATE accounts
      ↓
SUCCESS
      ↓
INSERT transaction_history
      ↓
FAILURE
      ↓
ROLLBACK
```

The account update is also undone.

This demonstrated the practical importance of atomic transactions.

---

## 🗂️ Files Completed

### `ConnectionEx.java`

Responsible for:

* Loading `db.properties`
* Reading database URL
* Reading username
* Reading password
* Creating JDBC connections
* Loading MySQL JDBC Driver

---

### `SavepointBasics.java`

Practiced:

* Transaction creation
* `setAutoCommit(false)`
* First database operation
* Creating one savepoint
* Second database operation
* Nested exception handling
* `rollback(savepoint)`
* `commit()`

Main method:

```java
SavepointBasics.savepointExample();
```

---

### `MultipleSavepoints.java`

Practiced:

* Multiple operations
* Savepoint 1
* Savepoint 2
* Nested `try-catch`
* Rolling back to different savepoints
* Partial transaction recovery
* Final commit

Main method:

```java
MultipleSavepoints.multipleSavepointExample();
```

---

### `PartialRollback.java`

Practiced:

* Creating a savepoint after an important operation
* Performing multiple subsequent operations
* Handling failure
* Rolling back multiple later operations
* Preserving earlier successful work
* Committing the remaining transaction

Main method:

```java
PartialRollback.partialRollbackExample();
```

---

### `TransactionValidation.java`

Practiced:

* Account validation
* Amount validation
* Sender validation
* Receiver validation
* Balance validation
* Debit operation
* Credit operation
* Full transaction rollback
* Successful transaction commit

Main method:

```java
TransactionValidation.validatedTransfer();
```

---

### `InsertUpdateTransaction.java`

Practiced:

* `UPDATE`
* `INSERT`
* Multiple SQL operations in one transaction
* Transaction history
* Exception handling
* Full rollback
* Commit after all operations succeed

Main method:

```java
InsertUpdateTransaction.depositWithTransactionHistory();
```

---

## 🗄️ Database Table Added

Created the transaction history table:

```sql
CREATE TABLE transaction_history (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    transaction_type VARCHAR(30) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    transaction_status VARCHAR(30) NOT NULL
);
```

This table was used to practice a real-world transaction involving account balance updates and transaction history insertion.

---

## 🔄 Transaction Concepts Practiced

### Auto Commit

```java
con.setAutoCommit(false);
```

Disabled automatic committing so multiple database operations could be treated as one transaction.

---

### Commit

```java
con.commit();
```

Used to permanently save all successful operations in the current transaction.

---

### Full Rollback

```java
con.rollback();
```

Used when the complete transaction needs to be undone.

---

### Savepoint

```java
Savepoint sp = con.setSavepoint("SAVEPOINT_NAME");
```

Created a recovery point inside a transaction.

---

### Partial Rollback

```java
con.rollback(sp);
```

Returned the transaction to a previously created savepoint instead of cancelling the entire transaction.

---

## 🧠 Important Differences Learned

### `rollback()`

```text
Operation 1
Operation 2
Operation 3
     ↓
rollback()
     ↓
Everything undone
```

### `rollback(savepoint)`

```text
Operation 1
     ↓
Savepoint
     ↓
Operation 2
Operation 3
     ↓
rollback(savepoint)
     ↓
Operation 1 remains
Operation 2 and 3 removed
```

---

## 💡 Key Learnings

* A transaction can contain multiple SQL operations.
* `setAutoCommit(false)` gives manual transaction control.
* `commit()` permanently saves the transaction.
* `rollback()` undoes the complete transaction.
* Savepoints provide intermediate recovery points.
* `rollback(savepoint)` allows partial rollback.
* Multiple savepoints can exist within one transaction.
* Nested `try-catch` blocks can handle failures at different transaction stages.
* Business validation should happen before modifying database data.
* `executeUpdate()` returns the number of affected rows.
* A successful SQL execution does not always mean that the expected row was modified.
* Multiple database operations can be treated as one atomic unit.
* Account updates and transaction history insertion should succeed or fail together.
* `PreparedStatement` was used for parameterized SQL operations.
* `ResultSet` was used for retrieving account balances.
* `try-with-resources` was used for automatic resource management.

---

## 🏦 Real-World Applications

The concepts practiced in this part are directly applicable to:

* Banking systems
* Payment processing
* UPI transactions
* Order processing
* E-commerce checkout
* Inventory management
* Wallet applications
* Employee payroll systems
* Financial transaction systems
* Audit and transaction history systems

Example:

```text
Payment Request
      ↓
Validate Payment
      ↓
Update Account/Payment Status
      ↓
Insert Transaction Record
      ↓
Update Order
      ↓
Commit
```

If any critical operation fails:

```text
Rollback
```

This prevents inconsistent database states.

---

## 🛠️ Technologies Used

* Java
* JDBC
* MySQL
* Maven
* Eclipse IDE
* PreparedStatement
* ResultSet
* Connection
* Savepoint
* SQL Transactions
* Exception Handling

---

## 📁 Part 1 Structure

```text
DAY_57_Advanced_Transactions
│
└── src
    └── main
        ├── java
        │   └── day57
        │       ├── ConnectionEx.java
        │       ├── SavepointBasics.java
        │       ├── MultipleSavepoints.java
        │       ├── PartialRollback.java
        │       ├── TransactionValidation.java
        │       └── InsertUpdateTransaction.java
        │
        └── resources
            ├── db.properties
            └── db.properties.example
```

---

## 📈 Day 57 JDBC Progress

### Part 1 — Completed ✅

* [x] Database Connection
* [x] Transaction Control
* [x] Savepoints
* [x] Multiple Savepoints
* [x] Nested Try-Catch
* [x] Partial Rollback
* [x] Transaction Validation
* [x] INSERT + UPDATE Transaction
* [x] Transaction History
* [x] Commit and Rollback
* [x] Exception Handling
* [x] PreparedStatement
* [x] ResultSet

---

## 🎯 Day 57 JDBC Part 1 Outcome

By completing Part 1, I learned how to control JDBC transactions beyond basic commit and rollback.

I practiced creating savepoints, rolling back to specific savepoints, handling multiple savepoints, using nested exception handling, validating business rules before database operations, and executing multiple SQL operations such as `UPDATE` and `INSERT` as one atomic transaction.

The practical banking and transaction-history scenarios helped me understand how transaction management is applied in real-world backend applications.

---

## 🚀 Next Goal — Day 57 JDBC Part 2

The next part will focus on more realistic transaction scenarios:

* `OrderTransaction.java`
* `PaymentTransaction.java`
* `AccountTransaction.java`
* `ExceptionTransaction.java`
* `TransactionProblems.java`
* `App.java`

The focus will move from individual transaction concepts toward **real-world multi-step business transactions and failure handling**.

```
```
