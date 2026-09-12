````markdown
# 🚀 100 Days of Code — Day 54
## 🗄️ JDBC Batch Processing

> **Focus:** Moving beyond individual JDBC operations and learning how to efficiently execute multiple database operations as a batch.

---

## 🎯 Day 54 Objective

The goal of Day 54 was to understand and practice **JDBC Batch Processing** using `PreparedStatement`.

After working with `PreparedStatement` and CRUD operations on Day 53, the focus today was on executing multiple parameterized SQL operations together instead of sending every operation individually to the database.

The practice was implemented using the `employees` table from the `employee_db` database.

---

# 🗄️ JDBC Topics Covered

## 1. JDBC Batch Processing

Batch processing allows multiple SQL operations to be collected and executed together.

Instead of executing every operation separately:

```text
Operation 1 → execute
Operation 2 → execute
Operation 3 → execute
Operation 4 → execute
````

we can add operations to a batch:

```text
Operation 1 → addBatch()
Operation 2 → addBatch()
Operation 3 → addBatch()
Operation 4 → addBatch()

              ↓

        executeBatch()
```

This approach is particularly useful when an application needs to process many database operations.

---

## 2. `PreparedStatement.addBatch()`

Practiced adding multiple parameterized operations into a batch using:

```java
stmt.addBatch();
```

The same `PreparedStatement` can be reused with different parameter values.

Example flow:

```java
stmt.setInt(1, id);
stmt.setString(2, firstName);
stmt.addBatch();

stmt.setInt(1, anotherId);
stmt.setString(2, anotherFirstName);
stmt.addBatch();
```

---

## 3. `PreparedStatement.executeBatch()`

After adding multiple operations, the complete batch can be executed using:

```java
int[] result = stmt.executeBatch();
```

The returned `int[]` contains update information for the individual batch operations.

---

## 4. Processing Batch Results

Practiced iterating through the returned update counts:

```java
for (int count : result) {
    System.out.println(count + " rows affected!");
}
```

Also practiced calculating the total number of affected rows.

---

# 🧪 Day 54 Practical Questions

## Question 1 — Static Batch INSERT

Created a batch containing multiple employee records and inserted them using `PreparedStatement`.

Employees added:

* Employee `107`
* Employee `108`
* Employee `109`

Each employee record was parameterized using `PreparedStatement`.

The operations were added using:

```java
stmt.addBatch();
```

and executed together using:

```java
stmt.executeBatch();
```

---

## Question 2 — Dynamic Batch INSERT

Created a dynamic batch insertion program where the user specifies how many employees should be added.

The program:

1. Accepts the number of employees.
2. Reads employee information using `Scanner`.
3. Sets all `PreparedStatement` parameters.
4. Adds every employee operation to the batch.
5. Executes the complete batch.
6. Calculates the total affected rows.

This provided practice with:

```text
User Input
    ↓
PreparedStatement
    ↓
addBatch()
    ↓
Multiple Employee Records
    ↓
executeBatch()
    ↓
Update Counts
```

---

## Question 3 — Batch Salary Updates

Created a batch update program for employee salaries.

SQL logic:

```sql
UPDATE employees
SET salary = salary + ?
WHERE employee_id = ?
```

For each employee:

* Employee ID is provided.
* Bonus amount is provided.
* Parameters are set.
* The update is added to the batch.

Finally, all salary updates are executed using `executeBatch()`.

---

## Question 4 — Batch DELETE

Created a batch delete operation using:

```sql
DELETE FROM employees
WHERE employee_id = ?
```

The program:

* Accepts multiple employee IDs.
* Adds every delete operation to the batch.
* Executes all operations together.
* Calculates the total number of deleted rows.

It also handled:

```java
PreparedStatement.SUCCESS_NO_INFO
```

when processing batch results.

---

## Question 5 — Batch INSERT with Result Tracking

Created another batch insertion program that accepts details for five employees.

After executing the batch, each employee's update status is displayed individually.

Example result structure:

```text
Employee 1 → 1 row affected
Employee 2 → 1 row affected
Employee 3 → 1 row affected
Employee 4 → 1 row affected
Employee 5 → 1 row affected
```

This helped reinforce the meaning of the `int[]` returned by `executeBatch()`.

---

## Question 6 — Department-Based Batch Salary Update

Created a batch update for department-level salary increments.

SQL logic:

```sql
UPDATE employees
SET salary = salary + ?
WHERE department_id = ?
```

The program accepts:

* Department ID
* Bonus amount

for multiple batch operations and executes them together.

The total number of updated rows is calculated from the returned update counts.

---

# 🔐 Database Configuration

The database connection was kept separate from the application logic using:

```text
src/main/resources/
└── db.properties
```

The connection utility loads the configuration through the classpath.

The application uses:

```java
ConnectionEx.getConnection()
```

to obtain a JDBC connection.

This keeps database configuration outside the Java classes.

---

# 🧩 Connection Utility

The `ConnectionEx` class is responsible for:

* Loading `db.properties`
* Reading database URL
* Reading username
* Reading password
* Loading the MySQL JDBC driver
* Creating the database connection

The connection is created through:

```java
DriverManager.getConnection(
    URL,
    USERNAME,
    PASSWORD
);
```

---

# ♻️ Try-With-Resources

The JDBC programs use try-with-resources:

```java
try (
    Connection con = ConnectionEx.getConnection();
    PreparedStatement stmt = con.prepareStatement(SQL)
) {
    // Batch processing
}
```

This ensures JDBC resources are automatically closed after execution.

---

# 🛡️ Exception Handling

The practical programs handled JDBC-related exceptions including:

```java
ClassNotFoundException
SQLException
```

Some programs also use multi-catch:

```java
catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
}
```

---

# 📁 Project Structure

```text
day54/
│
├── App.java
├── ConnectionEx.java
├── Question1.java
├── Question2.java
├── Question3.java
├── Question4.java
├── Question5.java
└── Question6.java
```

Database configuration:

```text
src/
└── main/
    └── resources/
        └── db.properties
```

---

# 🔄 Overall JDBC Batch Processing Flow

```text
Java Application
       ↓
Connection
       ↓
PreparedStatement
       ↓
Set Parameters
       ↓
addBatch()
       ↓
Set New Parameters
       ↓
addBatch()
       ↓
Set New Parameters
       ↓
addBatch()
       ↓
executeBatch()
       ↓
int[] Update Counts
       ↓
Process Results
```

---

# 🌍 Real-World Applications

JDBC batch processing is useful in scenarios such as:

### 👨‍💼 Employee Management

* Bulk employee registration
* Bulk salary updates
* Department-wide changes
* Employee record cleanup

### 💰 Payroll Systems

* Updating salaries for many employees
* Applying bonuses
* Processing deductions

### 🛒 E-Commerce

* Bulk product updates
* Inventory synchronization
* Price updates

### 📊 Data Migration

* Importing large datasets
* Moving data between systems
* Bulk database synchronization

### 📄 CSV Import

A backend application can read records from a CSV file and add many records to a database using batch processing instead of executing every INSERT individually.

---

# 💡 Key Learnings

By completing Day 54, I practiced:

* Understanding JDBC Batch Processing
* Using `addBatch()`
* Using `executeBatch()`
* Reusing `PreparedStatement`
* Batch INSERT operations
* Batch UPDATE operations
* Batch DELETE operations
* Processing `int[]` update counts
* Understanding `SUCCESS_NO_INFO`
* Dynamic batch operations with `Scanner`
* Department-level batch updates
* Employee-level batch updates
* Try-with-resources
* JDBC exception handling
* Separating database configuration from Java code

---

# 🧠 Day 54 Takeaway

The major concept I learned today is that JDBC doesn't have to execute every database operation independently.

Instead, multiple operations can be prepared and executed as a batch.

```text
Individual Operations
        ↓
Multiple Database Round Trips

        vs.

Batch Processing
        ↓
Multiple Operations
        ↓
executeBatch()
```

Batch processing becomes especially valuable when dealing with **large amounts of database operations**, such as bulk imports, payroll processing, migrations, and data synchronization.

---

# 📈 JDBC Learning Progress

```text
JDBC Introduction
      ↓
DriverManager
      ↓
Connection
      ↓
Statement
      ↓
CRUD Operations
      ↓
ResultSet
      ↓
PreparedStatement
      ↓
PreparedStatement Practice
      ↓
🚀 Batch Processing ← Day 54
      ↓
Transactions
      ↓
ACID Properties
      ↓
Commit / Rollback
      ↓
Savepoints
```

---

# 🎯 Next Goal — Day 55

The next JDBC stage will move into:

* JDBC Transactions
* Transaction management
* `setAutoCommit(false)`
* `commit()`
* `rollback()`
* Savepoints
* Handling transaction failures
* Real-world transaction scenarios
* ACID Properties

The next major practical scenario will be a **transaction-based operation**, such as transferring money between two accounts where both operations must succeed or the entire transaction must be rolled back.

---

# 🚀 100 Days of Code

**Day 54 completed successfully.**

Today I moved one step further from basic JDBC operations toward understanding how real backend applications handle **multiple database operations efficiently**.

> **Learn → Practice → Build → Understand → Repeat.**

---

## 👨‍💻 Author

**Ragipalyam Jaganmohan Reddy**

Java Backend & Full Stack Developer in progress.

**#100DaysOfCode • Day 54 • Java • JDBC • MySQL • PreparedStatement • BatchProcessing • BackendDevelopment**

```
```
