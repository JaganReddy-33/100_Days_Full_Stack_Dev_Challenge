
````markdown
# Day 57 — JDBC Advanced Transactions — Part 1 & Part 2

## 📌 Overview

Day 57 JDBC focused on advanced transaction management using JDBC and MySQL.

Part 1 focused on savepoints, partial rollback, transaction validation, nested exception handling, and multiple SQL operations inside a single transaction.

Part 2 moved toward more realistic backend transaction scenarios such as order processing, payment processing, account transfers, exception handling, business validation, and multiple database operations.

The practical work was implemented using Java, JDBC, MySQL, Connection, PreparedStatement, ResultSet, Savepoint, transactions, commit(), rollback(), and exception handling.

---

# 📚 Part 1 — Advanced Transaction Management

## 1. Database Connection

- Reused the ConnectionEx utility
- Loaded database configuration from db.properties
- Used Properties
- Used InputStream
- Used DriverManager
- Created reusable JDBC connections
- Used MySQL JDBC Driver
- Used Maven for JDBC dependency management
- Used try-with-resources for connection management

---

## 2. Savepoints

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

### rollback()

* Rolls back the entire transaction.

### rollback(savepoint)

* Rolls back only the operations performed after the specified savepoint.
* Operations performed before the savepoint remain inside the transaction.

---

## 3. Nested Transaction Exception Handling

Practiced using nested try-catch blocks inside a transaction.

Example flow:

```text
Transaction Start
      ↓
Operation 1
      ↓
Savepoint 1
      ↓
try
      ↓
Operation 2
      ↓
Savepoint 2
      ↓
try
      ↓
Operation 3
catch
      ↓
rollback(Savepoint 2)
catch
      ↓
rollback(Savepoint 1)
      ↓
commit()
```

This helped understand how different failures can be handled at different transaction stages.

---

## 4. Multiple Savepoints

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

Then Operation 3 is removed while Operations 1 and 2 remain inside the transaction.

If Operation 2 fails:

```java
con.rollback(sp1);
```

Then Operations 2 and 3 are removed while Operation 1 remains.

---

## 5. Partial Rollback

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

## 6. Transaction Validation

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

## 7. INSERT + UPDATE in One Transaction

Created a practical transaction involving multiple SQL operations.

The scenario was a deposit operation where:

```text
UPDATE accounts
      ↓
Increase balance
      ↓
INSERT transaction_history
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

# 🗂️ Part 1 — Files Completed

## ConnectionEx.java

Responsible for:

* Loading db.properties
* Reading database URL
* Reading username
* Reading password
* Creating JDBC connections
* Loading MySQL JDBC Driver

---

## SavepointBasics.java

Practiced:

* Transaction creation
* setAutoCommit(false)
* First database operation
* Creating one savepoint
* Second database operation
* Nested exception handling
* rollback(savepoint)
* commit()

Main method:

```java
SavepointBasics.savepointExample();
```

---

## MultipleSavepoints.java

Practiced:

* Multiple operations
* Savepoint 1
* Savepoint 2
* Nested try-catch
* Rolling back to different savepoints
* Partial transaction recovery
* Final commit

Main method:

```java
MultipleSavepoints.multipleSavepointExample();
```

---

## PartialRollback.java

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

## TransactionValidation.java

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

## InsertUpdateTransaction.java

Practiced:

* UPDATE
* INSERT
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

# 🗄️ Part 1 — Database Table Added

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

# 🔄 Part 1 — Transaction Concepts Practiced

## Auto Commit

```java
con.setAutoCommit(false);
```

Disabled automatic committing so multiple database operations could be treated as one transaction.

---

## Commit

```java
con.commit();
```

Used to permanently save all successful operations in the current transaction.

---

## Full Rollback

```java
con.rollback();
```

Used when the complete transaction needs to be undone.

---

## Savepoint

```java
Savepoint sp = con.setSavepoint("SAVEPOINT_NAME");
```

Created a recovery point inside a transaction.

---

## Partial Rollback

```java
con.rollback(sp);
```

Returned the transaction to a previously created savepoint instead of cancelling the entire transaction.

---

# 💡 Part 1 — Key Learnings

* A transaction can contain multiple SQL operations.
* setAutoCommit(false) gives manual transaction control.
* commit() permanently saves the transaction.
* rollback() undoes the complete transaction.
* Savepoints provide intermediate recovery points.
* rollback(savepoint) allows partial rollback.
* Multiple savepoints can exist within one transaction.
* Nested try-catch blocks can handle failures at different transaction stages.
* Business validation should happen before modifying database data.
* executeUpdate() returns the number of affected rows.
* A successful SQL execution does not always mean that the expected row was modified.
* Multiple database operations can be treated as one atomic unit.
* Account updates and transaction history insertion should succeed or fail together.
* PreparedStatement was used for parameterized SQL operations.
* ResultSet was used for retrieving account balances.
* try-with-resources was used for automatic resource management.

---

# 🏦 Part 1 — Real-World Applications

The concepts practiced in Part 1 are directly applicable to:

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

# 🚀 Part 2 — Real-World Transaction Processing

Part 2 moved from individual transaction concepts toward practical multi-step business transactions.

The main focus was:

* Order transactions
* Payment transactions
* Account transfers
* Savepoint-based transaction handling
* Exception handling
* Multiple SQL operations
* Business validation
* Commit and rollback
* Atomic business operations
* Transaction failure scenarios
* Real-world database consistency

---

# 📚 Part 2 — Topics Covered

## 1. Order Transaction

Created an order-processing transaction involving:

```text
Account
   ↓
Check Balance
   ↓
Enter Product
   ↓
Validate Amount
   ↓
Deduct Account Balance
   ↓
Insert Order
   ↓
Commit
```

The transaction ensures that the account balance deduction and order creation belong to the same transaction.

If order creation fails:

```text
Balance Deduction
      ↓
Order Creation Fails
      ↓
ROLLBACK
```

The balance deduction is undone.

---

## 2. Payment Transaction

Created a payment-processing transaction involving:

* Account validation
* Balance retrieval
* Payment amount validation
* Sufficient balance validation
* Balance deduction
* Payment record insertion
* Payment method
* Payment status
* Commit
* Rollback

Transaction flow:

```text
Account ID
    ↓
Check Account
    ↓
Get Balance
    ↓
Payment Amount
    ↓
Validate Amount
    ↓
Check Balance
    ↓
Deduct Balance
    ↓
Insert Payment Record
    ↓
COMMIT
```

If any critical operation fails:

```text
ROLLBACK
```

---

## 3. Account Transaction

Practiced a real-world account transfer involving:

* Sender account
* Receiver account
* Transfer amount
* Sender validation
* Receiver validation
* Balance validation
* Debit operation
* Savepoint
* Credit operation
* Commit
* Rollback

Transaction flow:

```text
Sender
   ↓
Receiver
   ↓
Transfer Amount
   ↓
Validate Accounts
   ↓
Check Sender Balance
   ↓
Debit Sender
   ↓
Create Savepoint
   ↓
Credit Receiver
   ↓
Success
   ↓
COMMIT
```

If the receiver credit operation fails, transaction recovery is performed using the savepoint and full rollback where required.

---

## 4. Exception Transaction

Practiced handling exceptions during multi-step database transactions.

Example:

```text
Transaction Start
      ↓
Operation 1
      ↓
Operation 2
      ↓
Exception
      ↓
Transaction Failure
      ↓
Rollback Handling
```

The goal was to understand that transaction operations must be handled carefully when unexpected SQL exceptions occur.

Practiced:

* SQLException
* try-catch
* Transaction failure
* Multiple SQL operations
* Transaction state
* Commit after successful operations
* Rollback during failure scenarios

---

## 5. Transaction Problems

Created additional practical transaction problems covering:

* Safe deposit
* Safe withdrawal
* Balance validation
* Multiple account updates
* Failed transaction scenarios
* Explicit rollback
* Business validation
* Commit after successful operations

These problems reinforced the concepts learned throughout Day 57.

---

# 🗂️ Part 2 — Files Completed

## OrderTransaction.java

Practiced:

* Account validation
* Balance retrieval
* Product input
* Amount validation
* Insufficient balance validation
* Balance deduction
* Order insertion
* Order status
* Multiple SQL operations
* commit()
* rollback()

Main method:

```java
OrderTransaction.placeOrder();
```

Transaction flow:

```text
Account Validation
      ↓
Balance Check
      ↓
Product + Amount
      ↓
Validation
      ↓
Balance Deduction
      ↓
Order INSERT
      ↓
COMMIT
```

Order status used:

```text
SUCCESS
```

---

## PaymentTransaction.java

Practiced:

* Account validation
* Balance retrieval
* Payment amount validation
* Insufficient balance validation
* Balance deduction
* Payment record insertion
* Payment method
* Payment status
* Multiple SQL operations
* commit()
* rollback()

Main method:

```java
PaymentTransaction.makePayment();
```

Payment methods practiced:

```text
UPI
CARD
NET_BANKING
WALLET
CASH
```

Example payment record:

```text
Account ID: 3
Amount: 1000
Payment Method: UPI
Payment Status: SUCCESS
```

---

## AccountTransaction.java

Practiced:

* Sender account validation
* Receiver account validation
* Sender balance validation
* Transfer amount validation
* Debit operation
* Savepoint creation
* Credit operation
* Savepoint rollback
* Full rollback
* Commit

Main method:

```java
AccountTransaction.transferWithSavepoint();
```

Transaction flow:

```text
Sender Validation
      ↓
Receiver Validation
      ↓
Balance Validation
      ↓
Debit Sender
      ↓
Savepoint
      ↓
Credit Receiver
      ↓
COMMIT
```

---

## ExceptionTransaction.java

Practiced:

* Exception handling inside transactions
* SQLException
* Multiple SQL operations
* Transaction failure
* Transaction state
* Commit
* Failure handling
* Resource management

Main method:

```java
ExceptionTransaction.handleTransactionException();
```

Example:

```text
Operation 1
      ↓
Operation 2
      ↓
Exception
      ↓
Transaction Failure
      ↓
Rollback Handling
```

---

## TransactionProblems.java

Created additional practical transaction problems.

Methods:

```java
TransactionProblems.safeDeposit();

TransactionProblems.safeWithdrawal();

TransactionProblems.failedTransaction();

TransactionProblems.multipleUpdates();

TransactionProblems.transactionWithRollback();
```

### safeDeposit()

Practiced:

* Deposit validation
* Account update
* Commit
* Transaction success

### safeWithdrawal()

Practiced:

* Account validation
* Balance retrieval
* Withdrawal validation
* Sufficient balance check
* Balance update
* Commit

### failedTransaction()

Practiced:

* Successful operation followed by simulated failure
* Transaction failure handling
* Exception handling

### multipleUpdates()

Practiced:

* Multiple UPDATE statements
* One transaction
* Affected-row validation
* Commit

### transactionWithRollback()

Practiced:

* Database update
* Explicit rollback
* Understanding uncommitted transaction changes

---

## App.java

Used App.java as the testing entry point for the practical transaction programs.

Example:

```java
package day57;

public class App {

    public static void main(String[] args)
            throws ClassNotFoundException, Exception {

        OrderTransaction.placeOrder();

        // PaymentTransaction.makePayment();

        // AccountTransaction.transferWithSavepoint();

        // ExceptionTransaction.handleTransactionException();

        // TransactionProblems.safeDeposit();

        // TransactionProblems.safeWithdrawal();

        // TransactionProblems.failedTransaction();

        // TransactionProblems.multipleUpdates();

        // TransactionProblems.transactionWithRollback();
    }
}
```

The transaction programs were tested individually to avoid Scanner/System.in conflicts.

---

# 🗄️ Part 2 — Database Tables Added

## Orders Table

```sql
CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    product_name VARCHAR(100) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    order_status VARCHAR(30) NOT NULL
);
```

Used for practicing:

* Order creation
* Account balance deduction
* Order status
* Atomic order transactions

---

## Payments Table

```sql
CREATE TABLE payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_method VARCHAR(30) NOT NULL,
    payment_status VARCHAR(30) NOT NULL
);
```

Used for practicing:

* Payment processing
* Payment methods
* Payment status
* Account balance deduction
* Transaction recording

---

# 🔄 Part 2 — Transaction Patterns Practiced

## Order Transaction

```text
Validate Account
      ↓
Check Balance
      ↓
Validate Order
      ↓
Deduct Balance
      ↓
Create Order
      ↓
Commit
```

---

## Payment Transaction

```text
Validate Account
      ↓
Check Balance
      ↓
Validate Payment
      ↓
Deduct Balance
      ↓
Insert Payment Record
      ↓
Commit
```

---

## Account Transfer

```text
Validate Sender
      ↓
Validate Receiver
      ↓
Check Balance
      ↓
Debit Sender
      ↓
Savepoint
      ↓
Credit Receiver
      ↓
Commit
```

---

## Failure Scenario

```text
Operation 1
      ↓
Operation 2
      ↓
Operation 2 Fails
      ↓
Rollback
      ↓
No Partial Transaction
```

---

# 🧠 Part 2 — Key Learnings

* Real-world business operations often require multiple SQL statements.
* Multiple SQL statements can be grouped into one transaction.
* setAutoCommit(false) provides manual transaction control.
* commit() permanently saves successful transaction operations.
* rollback() cancels uncommitted transaction operations.
* Savepoints provide intermediate recovery points.
* rollback(savepoint) can recover a transaction to a specific stage.
* Business validation should happen before critical database modifications.
* Account existence should be checked before performing financial operations.
* Balance should be checked before withdrawals, payments, and transfers.
* executeUpdate() should be checked using affected-row counts.
* An UPDATE followed by an INSERT can be treated as one transaction.
* Order creation and balance deduction should succeed or fail together.
* Payment processing and payment record insertion should succeed or fail together.
* Sender debit and receiver credit belong to one logical transfer transaction.
* PreparedStatement provides parameterized SQL operations.
* ResultSet is used to retrieve account information.
* try-with-resources helps automatically close JDBC resources.
* Exception handling is important when working with database transactions.
* Transactions help prevent inconsistent database states.
* Database locks can affect transaction execution.
* A transaction must be properly completed using commit() or rollback().
* Stale transactions can cause lock wait timeout errors.

---

# 🔐 Real Transaction Locking Issue Practiced

During the OrderTransaction testing, a real MySQL transaction locking problem occurred:

```text
Lock wait timeout exceeded
```

The problem was caused by an older JDBC connection with an active transaction.

The connection was identified using:

```sql
SHOW FULL PROCESSLIST;
```

The active transaction was identified using:

```sql
SELECT *
FROM information_schema.innodb_trx;
```

The stale connection was terminated using:

```sql
KILL 10;
```

This demonstrated a real-world database transaction problem involving:

* Open transactions
* Database locks
* Sleeping connections
* Lock wait timeout
* Transaction cleanup
* Proper commit/rollback handling

This was an important practical backend learning experience.

---

# 🏦 Real-World Applications

The transaction concepts practiced during Day 57 can be applied to:

* Banking applications
* UPI payment systems
* Payment gateways
* E-commerce checkout
* Order management systems
* Wallet applications
* Financial applications
* Inventory systems
* Payroll systems
* Ticket booking systems
* Subscription systems
* Transaction history systems
* Audit systems

Example e-commerce transaction:

```text
Customer Places Order
        ↓
Validate Customer
        ↓
Check Balance
        ↓
Validate Product
        ↓
Deduct Payment
        ↓
Create Order
        ↓
Update Inventory
        ↓
Create Transaction Record
        ↓
COMMIT
```

If a critical operation fails:

```text
ROLLBACK
```

This prevents partial updates and inconsistent data.

---

# 🔥 Day 57 — Overall Transaction Architecture

```text
                    TRANSACTION
                         ↓
                setAutoCommit(false)
                         ↓
                  Business Validation
                         ↓
                  Account Verification
                         ↓
                    SQL Operation
                         ↓
                    SQL Operation
                         ↓
                     Savepoint
                         ↓
                    SQL Operation
                         ↓
                 ┌───────┴───────┐
                 ↓               ↓
              SUCCESS          FAILURE
                 ↓               ↓
              commit()       rollback()
                 ↓               ↓
             Database       Changes Undone
              Saved
```

---

# 🛠️ Technologies Used

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
* try-with-resources
* MySQL InnoDB Transactions

---

# 📁 Day 57 JDBC Complete Structure

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
        │       ├── InsertUpdateTransaction.java
        │       ├── OrderTransaction.java
        │       ├── PaymentTransaction.java
        │       ├── AccountTransaction.java
        │       ├── ExceptionTransaction.java
        │       ├── TransactionProblems.java
        │       └── App.java
        │
        └── resources
            ├── db.properties
            └── db.properties.example
```

---

# 📈 Day 57 JDBC Progress

## Part 1 — Completed ✅

* [x] Database Connection
* [x] Transaction Control
* [x] setAutoCommit(false)
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

## Part 2 — Completed ✅

* [x] Order Transaction
* [x] Payment Transaction
* [x] Account Transfer
* [x] Savepoint-Based Recovery
* [x] Exception Transaction Handling
* [x] Business Validation
* [x] Multiple SQL Operations
* [x] Order Creation
* [x] Payment Record Creation
* [x] Account Balance Deduction
* [x] Commit Handling
* [x] Rollback Handling
* [x] Transaction Failure Scenarios
* [x] Practical Transaction Problems
* [x] MySQL Lock Wait Timeout Troubleshooting

---

# 🎯 Day 57 JDBC Overall Outcome

By completing Part 1 and Part 2, I moved from basic JDBC transaction control toward practical backend transaction management.

I learned how to use setAutoCommit(false), commit(), rollback(), and Savepoint to control database transactions.

I practiced full rollback, partial rollback, multiple savepoints, nested try-catch handling, transaction validation, and multiple SQL operations inside a single transaction.

I also implemented realistic backend scenarios such as order processing, payment processing, account transfers, transaction history, and failure handling.

The practical problems helped me understand how multiple database operations can be treated as one logical business transaction and how commit and rollback protect database consistency.

I also encountered and resolved a real MySQL lock wait timeout caused by an open transaction, which helped me understand the importance of properly completing and closing database transactions.

---

# 🚀 Day 57 Completed

```text
DAY 57 JDBC
     │
     ├── Part 1
     │    ├── Savepoints
     │    ├── Multiple Savepoints
     │    ├── Partial Rollback
     │    ├── Validation
     │    └── INSERT + UPDATE
     │
     └── Part 2
          ├── Order Transaction
          ├── Payment Transaction
          ├── Account Transfer
          ├── Exception Handling
          ├── Multiple SQL Operations
          └── Transaction Problems
```

## ✅ Day 57 JDBC — PART 1 & PART 2 COMPLETED

---
```
s