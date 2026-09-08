# Day 56 — JDBC Transactions

````markdown
# 🚀 Day 56 — JDBC: Transactions in Practice

## 📌 Overview

Today I continued my JDBC learning by practicing **database transactions** using Java, JDBC, and MySQL.

The main focus was understanding how multiple database operations can be treated as a single unit of work using:

- `setAutoCommit(false)`
- `commit()`
- `rollback()`
- `PreparedStatement`
- `ResultSet`
- Transaction validation
- Exception handling
- Transaction boundaries

The practical scenarios were mainly based on **banking and account transactions**, which helped me understand how transaction management is applied in real-world backend applications.

---

# 📚 Topics Covered

## 1. JDBC Transactions

- What is a database transaction?
- Why transactions are required
- Transaction boundaries
- Multiple SQL operations inside a single transaction
- Successful transactions
- Failed transactions
- Transaction rollback
- Transaction commit

---

## 2. Auto Commit

Practiced controlling JDBC transaction behavior using:

```java
con.setAutoCommit(false);
````

Understood that JDBC normally works with auto-commit enabled, while disabling auto-commit allows multiple operations to be handled as one transaction.

---

## 3. `commit()`

Practiced:

```java
con.commit();
```

Used `commit()` after successful database operations so that the changes become permanent.

---

## 4. `rollback()`

Practiced:

```java
con.rollback();
```

Used rollback when:

* Validation fails
* Account does not exist
* Balance is insufficient
* An update fails
* A business rule is violated
* An operation inside the transaction fails

This helped me understand how rollback prevents incomplete or unwanted database changes.

---

# 💻 Practical Problems Completed

## Q1 — Debit Amount and Commit

Created a complete debit transaction that:

* Accepts account ID
* Checks whether the account exists
* Retrieves the existing balance
* Displays the current balance
* Accepts withdrawal amount
* Validates withdrawal amount
* Checks sufficient balance
* Performs the debit using `PreparedStatement`
* Checks affected rows using `executeUpdate()`
* Commits successful transactions
* Rolls back failed transactions

Main concepts practiced:

```text
setAutoCommit(false)
commit()
rollback()
PreparedStatement
ResultSet
executeUpdate()
Transaction validation
```

---

## Q2 — Multiple Operations in One Transaction

Practiced performing multiple database operations as part of one transaction.

The transaction performs:

```text
Debit Source Account
        ↓
Credit Destination Account
        ↓
Both successful?
        ↓
      commit()
```

If one operation fails:

```text
rollback()
```

This demonstrated why related database operations should be handled as a single transaction.

---

## Q3 — Bank Transfer Transaction

Implemented a realistic banking transfer scenario.

Flow:

```text
Enter Sender Account
        ↓
Enter Receiver Account
        ↓
Enter Amount
        ↓
Validate Amount
        ↓
Check Sender Account
        ↓
Check Sender Balance
        ↓
Check Receiver Account
        ↓
Debit Sender
        ↓
Credit Receiver
        ↓
commit()
```

If any step fails:

```text
rollback()
```

This demonstrated the importance of transaction management in financial applications.

---

## Q4 — Business Rule Failure + Rollback

Practiced rollback based on business conditions rather than only SQL exceptions.

Validation included:

* Valid transaction amount
* Sender account existence
* Receiver account existence
* Sufficient sender balance
* Successful debit
* Successful credit

If a business rule failed, the transaction was rolled back.

This demonstrated that **business validation is also an important part of transaction management**.

---

## Q5 — Complete Transaction + Verification

Practiced:

* Starting a transaction
* Executing an update
* Checking affected rows
* Committing the transaction
* Closing the transaction connection
* Creating a new connection
* Reading the database again
* Verifying the committed balance

This helped demonstrate that committed changes can be verified from a separate database connection.

---

# 🧠 Key Learnings

### Transaction

A transaction is a group of database operations treated as one logical unit of work.

### `setAutoCommit(false)`

Disables automatic committing so multiple SQL operations can be controlled manually.

### `commit()`

Permanently applies the successful changes made during the transaction.

### `rollback()`

Reverts the changes made during the current transaction.

### Transaction Boundary

A transaction generally follows:

```text
Begin Transaction
       ↓
Perform Operations
       ↓
Validate
       ↓
Success → commit()
Failure → rollback()
```

---

# 🔐 PreparedStatement + Transactions

Practiced combining:

```java
PreparedStatement
```

with:

```java
setAutoCommit(false)
commit()
rollback()
```

This provided a safer and more structured approach for executing parameterized SQL operations inside transactions.

---

# 🔎 ResultSet + Transaction Validation

Used:

```java
ResultSet
```

to retrieve existing account information before performing database modifications.

Practiced validating:

* Account existence
* Current balance
* Available funds
* Destination account

before executing transaction operations.

---

# 🏦 Real-World Banking Scenario

The main real-world example was a money transfer:

```text
Sender Account
      │
      │ Debit
      ▼
Transaction
      │
      │ Credit
      ▼
Receiver Account
```

Both operations must succeed together.

If the sender is debited but the receiver is not credited, the transaction must be rolled back.

This demonstrates why transaction management is critical in:

* Banking systems
* Payment systems
* E-commerce
* Order processing
* Financial applications
* Enterprise backend systems

---

# 🧩 Error and Failure Handling

Practiced handling failures such as:

* Invalid amount
* Account not found
* Insufficient balance
* Failed update
* Business-rule failure
* SQL exception

The general approach was:

```text
Operation
   ↓
Check result
   ↓
Success → Continue
Failure → rollback()
```

---

# ♻️ Resource Management

Practiced JDBC resource management using:

```java
try-with-resources
```

for:

* `Connection`
* `PreparedStatement`
* `ResultSet`
* `Scanner`

This helped ensure resources are properly closed after execution.

---

# 📊 Transaction Flow

```text
Connection
    ↓
setAutoCommit(false)
    ↓
Validation
    ↓
SQL Operation 1
    ↓
SQL Operation 2
    ↓
Check Results
    ↓
 ┌───────────────┐
 │               │
Success        Failure
 │               │
 ↓               ↓
commit()      rollback()
 │               │
 ↓               ↓
Permanent      Changes
Changes        Reverted
```

---

# 🛠️ Technologies Used

* Java
* JDBC
* MySQL
* Eclipse IDE
* PreparedStatement
* ResultSet
* SQL Transactions

---

# 📈 Day 56 Progress

### Completed

* ✅ JDBC Transactions
* ✅ `setAutoCommit(false)`
* ✅ `commit()`
* ✅ `rollback()`
* ✅ Transaction boundaries
* ✅ Multiple SQL operations
* ✅ PreparedStatement with transactions
* ✅ ResultSet-based validation
* ✅ Business-rule validation
* ✅ Exception handling
* ✅ Banking transfer scenario
* ✅ Commit verification
* ✅ Try-with-resources

### Practical Problems

* ✅ Q1 — Debit + Commit
* ✅ Q2 — Multiple Operations + Commit
* ✅ Q3 — Bank Transfer
* ✅ Q4 — Business Rule Failure + Rollback
* ✅ Q5 — Complete Transaction + Verification

---

# 🎯 Key Takeaway

Today I learned how JDBC transactions allow multiple database operations to be treated as a single unit of work.

I practiced controlling transactions with:

```java
setAutoCommit(false);
commit();
rollback();
```

I also learned how to combine transaction management with `PreparedStatement`, `ResultSet`, validation, exception handling, and try-with-resources.

The banking transfer exercises helped me understand the importance of preventing partial database updates in real-world backend applications.

---

# 🔥 Next Goal

Continue with the next JDBC concepts and strengthen transaction handling through additional real-world problems when time is available.

---

## 👨‍💻 Author

**Jagan Mohan Reddy**

GitHub: `JaganReddy-33`

Repository: `100_Days_Full_Stack_Dev_Challenge`

## 🚀 100 Days Full Stack Developer Challenge

**Day 56 — JDBC Transactions Completed**

```
```
