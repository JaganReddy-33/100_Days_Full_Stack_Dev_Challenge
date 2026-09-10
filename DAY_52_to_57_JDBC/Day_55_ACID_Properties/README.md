
````markdown id="core55readme"
# 🚀 Day 55 — Core Java: 2D Arrays & Multidimensional Arrays

> **100 Days Full Stack Development Challenge — Java Backend Journey**

## 📅 Day Overview

Day 55 of the Core Java journey focused on **2D Arrays and Multidimensional Arrays**.

The practical work covered array declaration and initialization, accessing and updating elements, rows and columns, nested-loop traversal, matrix operations, transpose, diagonal operations, identity and symmetric matrices, triangular matrices, multidimensional arrays, and jagged arrays.

---

## 🎯 Objective

The objective of Day 55 was to strengthen understanding of:

- 2D arrays
- Multidimensional arrays
- Matrix-based problems
- Nested-loop traversal
- Array manipulation
- Jagged arrays
- Passing arrays to methods
- Real-world matrix operations

---

# 📚 Topics Covered

## 1️⃣ 2D Array Fundamentals

Practiced:

- Declaration
- Initialization
- `new` keyword
- Indexing
- `.length`
- Accessing elements
- Updating elements
- Rows and columns

Example structure:

```text
2D Array
 ├── Row 0
 │    ├── Column 0
 │    ├── Column 1
 │    └── Column 2
 │
 ├── Row 1
 │    ├── Column 0
 │    ├── Column 1
 │    └── Column 2
 │
 └── Row 2
      ├── Column 0
      ├── Column 1
      └── Column 2
````

---

## 2️⃣ Traversing 2D Arrays

Practiced traversal using:

* Nested `for` loops
* Nested `while` loops
* Enhanced `for` loops

The nested-loop approach was used to process rows and columns systematically.

---

## 3️⃣ Basic Matrix Programs

Practiced basic matrix operations including:

* Printing matrix elements
* Accessing individual elements
* Updating matrix values
* Processing rows
* Processing columns
* Calculating matrix-based values

---

## 4️⃣ Matrix Addition

Practiced adding corresponding elements of two matrices.

```text
A + B = C
```

Each element of the resulting matrix is obtained by adding corresponding elements from the input matrices.

---

## 5️⃣ Matrix Subtraction

Practiced subtracting corresponding elements of two matrices.

```text
A - B = C
```

---

## 6️⃣ Matrix Multiplication

Practiced matrix multiplication using nested loops.

The operation requires:

* Selecting a row from the first matrix
* Selecting a column from the second matrix
* Multiplying corresponding elements
* Adding the products

---

## 7️⃣ Matrix Transpose

Practiced converting rows into columns and columns into rows.

```text
Original Matrix
      ↓
   Transpose
      ↓
Rows ↔ Columns
```

---

## 8️⃣ Diagonal Operations

Practiced working with:

### Main Diagonal

Elements where:

```text
row index == column index
```

### Secondary Diagonal

Elements where:

```text
row index + column index == matrix size - 1
```

---

## 9️⃣ Identity Matrix

Practiced identifying and working with identity matrices.

An identity matrix contains:

```text
1 0 0
0 1 0
0 0 1
```

The main diagonal contains `1`, while the remaining elements contain `0`.

---

## 🔟 Symmetric Matrix

Practiced checking whether a matrix is symmetric.

A matrix is symmetric when:

```text
A[i][j] == A[j][i]
```

---

## 1️⃣1️⃣ Triangular Matrices

Practiced:

* Upper triangular matrix
* Lower triangular matrix

### Upper Triangular

Elements below the main diagonal are zero.

### Lower Triangular

Elements above the main diagonal are zero.

---

## 1️⃣2️⃣ Multidimensional Arrays

Extended array knowledge from one-dimensional and two-dimensional arrays to multidimensional structures.

Practiced:

* Declaration
* Initialization
* Accessing elements
* Traversal
* Nested structures

---

## 1️⃣3️⃣ Jagged Arrays

Practiced jagged arrays where each row can contain a different number of elements.

Example:

```text
Row 0 → [10, 20]
Row 1 → [30, 40, 50]
Row 2 → [60]
```

Unlike a regular rectangular matrix, each row can have a different length.

---

# 🧠 Key Learnings

By completing Day 55, I strengthened my understanding of:

* 2D array memory structure
* Row and column indexing
* Nested loops
* Matrix traversal
* Matrix addition
* Matrix subtraction
* Matrix multiplication
* Matrix transpose
* Diagonal processing
* Identity matrices
* Symmetric matrices
* Triangular matrices
* Multidimensional arrays
* Jagged arrays
* Passing arrays to methods

---

# 🌍 Real-World Applications

2D and multidimensional arrays are useful for:

* Matrix calculations
* Image processing
* Game boards
* Seating systems
* Spreadsheet-like data
* Student marks tables
* Grid-based applications
* Scientific calculations
* Data visualization structures

---

# 📂 Project Structure

```text
CoreJava/
└── src/
    └── day55/
        ├── 2D Array Programs
        ├── Matrix Programs
        ├── Multidimensional Array Programs
        └── Jagged Array Programs
```

---

# 📈 Progress

### Core Java

* [x] 2D Arrays
* [x] Array declaration and initialization
* [x] Accessing and updating elements
* [x] Rows and columns
* [x] Nested-loop traversal
* [x] Basic matrix programs
* [x] Matrix addition
* [x] Matrix subtraction
* [x] Matrix multiplication
* [x] Matrix transpose
* [x] Main diagonal operations
* [x] Secondary diagonal operations
* [x] Identity matrices
* [x] Symmetric matrices
* [x] Upper triangular matrices
* [x] Lower triangular matrices
* [x] Multidimensional arrays
* [x] Jagged arrays
* [x] Array methods

---

# 🎯 Next Goal

Continue strengthening **Core Java arrays and collections**, while progressing further into the Java Backend development journey.

---

# 🏆 Day 55 Status

**Core Java — COMPLETED ✅**

> **2D Arrays → Matrix Operations → Multidimensional Arrays → Jagged Arrays**

---

## 🟩 2. JDBC — Day 55 README

```markdown id="jdbc55readme"
# 🚀 Day 55 — JDBC: ACID Properties

> **100 Days Full Stack Development Challenge — Java Backend Journey**

## 📅 Day Overview

Day 55 of the JDBC journey focused on **ACID Properties** and their importance in reliable database transactions.

I studied and practiced all four ACID properties:

- **A — Atomicity**
- **C — Consistency**
- **I — Isolation**
- **D — Durability**

The concepts were implemented through realistic account and banking transaction scenarios using JDBC, MySQL, `Connection`, `PreparedStatement`, `ResultSet`, transaction control, commit, rollback, and transaction isolation levels.

---

# 🎯 Objective

The objective of Day 55 was to understand how databases maintain reliable and safe transactions using ACID properties.

The practical work focused on:

- JDBC transactions
- `setAutoCommit(false)`
- `commit()`
- `rollback()`
- Transaction validation
- Multiple operations inside transactions
- Concurrent transactions
- Isolation levels
- Verifying committed data
- Real-world banking scenarios

---

# 🔐 ACID Properties

ACID represents four fundamental properties of database transactions.

| Property | Meaning |
|---|---|
| **Atomicity** | All operations succeed or none take effect |
| **Consistency** | Database moves from one valid state to another |
| **Isolation** | Concurrent transactions do not interfere improperly |
| **Durability** | Committed data remains permanently stored |

---

# 1️⃣ Atomicity

### Meaning

Atomicity follows the:

> **All-or-Nothing principle**

A transaction is treated as one complete unit.

If every operation succeeds:

```text
COMMIT
````

If any operation fails:

```text
ROLLBACK
```

The transaction must not leave behind partial changes.

---

## 🧪 Atomicity Practice

I implemented multiple JDBC transaction scenarios involving account withdrawals, deposits, transfers, validation, failures, and multiple account updates.

The practice included:

### Q1 — Deduct Money and Commit

Deducted money from an account and committed the transaction.

Practiced:

* `setAutoCommit(false)`
* `PreparedStatement`
* `executeUpdate()`
* `commit()`

### Q2 — Add Money and Commit

Added money to an account and committed the transaction.

### Q3 — Two Operations with Rollback

Performed debit and credit operations as one transaction.

If an operation failed:

```text
ROLLBACK
```

### Q4 — Jagan to Lohith Transfer

Implemented a practical account-to-account transfer using debit and credit operations.

### Q5 — Failed Transfer

Forced a transfer failure using an invalid destination account and rolled back the transaction.

### Q6 — Multiple Operations

Performed multiple account updates within one transaction.

If any operation failed, all changes were rolled back.

### Q7 — Account Existence Check

Checked whether the destination account existed before performing the transfer.

### Q8 — Complete Atomic Transaction

Performed three account updates as one atomic transaction.

All operations were committed together, or all were rolled back.

---

# 2️⃣ Consistency

### Meaning

Consistency ensures that a transaction moves the database from:

```text
Valid State
     ↓
 Transaction
     ↓
Valid State
```

Database rules, constraints, and business rules must remain valid.

---

## 🧪 Consistency Practice

I practiced consistency through validation-based account operations, including:

* Checking account existence
* Preventing negative balances
* Checking sufficient funds
* Validating deposits
* Validating withdrawals
* Performing validated money transfers

The objective was to ensure that transactions do not leave the database in an invalid business state.

---

# 3️⃣ Isolation

### Meaning

Isolation ensures that multiple transactions running at the same time do not improperly interfere with one another.

Example:

```text
Transaction A
      ↘
       Database
      ↗
Transaction B
```

Each transaction should behave correctly even when other transactions are executing concurrently.

---

## 🧪 Isolation Practice

I practiced JDBC transaction isolation using multiple database connections.

The isolation levels practiced included:

* `READ_COMMITTED`
* `REPEATABLE_READ`
* `SERIALIZABLE`

I also practiced:

* Checking the current isolation level
* Changing the transaction isolation level
* Working with multiple JDBC connections
* Understanding concurrent transaction behavior

---

# 4️⃣ Durability

### Meaning

Durability ensures that once a transaction is successfully committed, its changes remain stored even after:

* Closing the connection
* Closing the application
* Reconnecting to the database

The important idea is:

```text
Transaction
    ↓
 COMMIT
    ↓
Data Persisted
    ↓
New Connection
    ↓
Data Still Exists
```

---

## 🧪 Durability Practice

I practiced:

* Committed deposits
* Committed withdrawals
* Committed transfers
* Verifying committed data using a new connection
* Comparing `commit()` and `rollback()`

This demonstrated the difference between committed and rolled-back database changes.

---

# 🔄 JDBC Transaction Control

The major JDBC transaction methods practiced were:

| Method                 | Purpose                               |
| ---------------------- | ------------------------------------- |
| `setAutoCommit(false)` | Enables manual transaction control    |
| `commit()`             | Permanently saves transaction changes |
| `rollback()`           | Reverts transaction changes           |

---

# 🛠️ Technologies Used

* Java
* JDBC
* MySQL
* `Connection`
* `PreparedStatement`
* `ResultSet`
* JDBC Transactions
* ACID Properties
* Transaction Isolation Levels
* Try-with-resources
* Exception Handling

---

# 🏦 Real-World Banking Scenarios

The practical exercises were based around realistic account operations.

### 💰 Deposit

```text
Account
   ↓
Deposit
   ↓
COMMIT
```

### 💸 Withdrawal

```text
Account
   ↓
Withdrawal
   ↓
COMMIT / ROLLBACK
```

### 💳 Money Transfer

```text
Account A
   ↓
Debit
   ↓
Credit
   ↓
Account B
   ↓
COMMIT
```

If the transfer fails:

```text
ROLLBACK
```

---

# 🧠 Key Learnings

By completing Day 55 JDBC, I learned:

* What ACID properties are
* Why transactions need ACID guarantees
* Atomicity and the All-or-Nothing principle
* Consistency and database validity
* Isolation and concurrent transactions
* Transaction isolation levels
* Durability of committed data
* `setAutoCommit(false)`
* `commit()`
* `rollback()`
* JDBC transaction handling
* PreparedStatement with transactions
* Validation before database updates
* Real-world banking transaction design

---

# 🔑 ACID in One Line

```text
Atomicity   → All or Nothing
Consistency → Valid State to Valid State
Isolation   → Transactions Don't Interfere Improperly
Durability  → Committed Data Persists
```

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
        │       └── Other ACID practice classes
        │
        └── resources/
            └── db.properties
```

---

# 🛡️ Good JDBC Practices

The practical work followed important JDBC practices:

* Used `PreparedStatement`
* Used try-with-resources
* Used explicit transaction boundaries
* Used `commit()` for successful transactions
* Used `rollback()` when transactions failed
* Used exception handling
* Used database configuration through properties
* Practiced transaction isolation
* Verified transaction results

---

# 📈 Day 55 Progress

### JDBC

* [x] Transactions
* [x] ACID Properties
* [x] Atomicity
* [x] Consistency
* [x] Isolation
* [x] Durability
* [x] `setAutoCommit(false)`
* [x] `commit()`
* [x] `rollback()`
* [x] Transaction validation
* [x] Isolation levels
* [x] Multiple JDBC connections
* [x] Committed data verification
* [x] Banking/account scenarios
* [x] 8 Atomicity practice questions

---

# 🎯 Next Goal

Continue with the next JDBC topics after completing:

```text
Transactions
      ↓
ACID Properties
      ↓
Atomicity ✅
Consistency ✅
Isolation ✅
Durability ✅
```

The next stage will build on these transaction fundamentals and move deeper into enterprise-level JDBC/backend concepts.

---

# 🏆 Day 55 Status

**JDBC — ACID Properties: COMPLETED ✅**

> **Atomicity → Consistency → Isolation → Durability**

Today I strengthened my understanding of how reliable database transactions work and practiced all four ACID properties using realistic banking and account scenarios.

---


