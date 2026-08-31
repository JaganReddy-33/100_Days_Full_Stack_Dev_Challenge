# 🚀 100 Days Full Stack Challenge — Day 52

# 🔌 JDBC — Day 52

## 📌 Focus

JDBC Fundamentals, JDBC Architecture, MySQL Connectivity, `DriverManager`, `Connection`, `Statement`, `ResultSet`, CRUD Operations, Aggregate Queries, and Database Configuration.

---

## 🎯 Day 52 Objectives

- Understand JDBC.
- Understand JDBC architecture.
- Understand the JDBC driver.
- Connect Java with MySQL.
- Understand `DriverManager`.
- Create a database `Connection`.
- Execute SQL statements from Java.
- Understand `Statement`.
- Retrieve database records using `ResultSet`.
- Perform INSERT operations.
- Perform SELECT operations.
- Perform UPDATE operations.
- Perform DELETE operations.
- Execute aggregate queries.
- Create a reusable database connection utility.
- Separate database credentials from Java source code.
- Protect database credentials using `.gitignore`.

---

# 📁 Project Structure

    JDBC Project
    │
    ├── src/
    │   └── main/
    │       ├── java/
    │       │   └── day52/
    │       │       ├── DBConnection.java
    │       │       ├── SelectEx.java
    │       │       ├── InsertEx.java
    │       │       ├── UpdateEx.java
    │       │       ├── DeleteEx.java
    │       │       ├── ResultSetEx.java
    │       │       └── CountEx.java
    │       │
    │       └── resources/
    │           └── db.properties
    │
    ├── pom.xml
    └── .gitignore

---

# 1️⃣ What is JDBC?

JDBC stands for:

    Java Database Connectivity

JDBC is the standard Java API used to communicate with relational databases.

It allows Java applications to:

    Connect to Database
          ↓
    Execute SQL
          ↓
    Receive Results
          ↓
    Process Data

---

# 2️⃣ JDBC Architecture

Basic JDBC architecture:

    Java Application
          ↓
       JDBC API
          ↓
      DriverManager
          ↓
      JDBC Driver
          ↓
     MySQL Database

---

# 3️⃣ JDBC Driver

The JDBC driver acts as the communication layer between the Java application and MySQL.

For this project, the MySQL JDBC driver is included through Maven.

The driver allows Java to communicate with the MySQL database.

---

# 4️⃣ DriverManager

`DriverManager` manages JDBC drivers and is responsible for helping establish database connections.

A connection can be created using:

    DriverManager.getConnection(...)

The returned object is a `Connection`.

---

# 5️⃣ Connection

The `Connection` object represents the active connection between Java and the database.

Conceptually:

    Java Application
          ↓
      Connection
          ↓
      MySQL Database

---

# 6️⃣ DBConnection

## 📄 File

`DBConnection.java`

A reusable database connection utility was created.

Instead of writing the database URL, username, and password inside every JDBC class, the values are loaded from:

    db.properties

This allows all JDBC examples to reuse the same connection logic.

---

# 7️⃣ Database Configuration

## 📄 File

`db.properties`

The configuration file contains database connection information.

Example structure:

    db.url=jdbc:mysql://localhost:3306/employee_db
    db.username=root
    db.password=YOUR_PASSWORD

The actual password should never be committed to GitHub.

---

# 🔐 Security Practice

Database credentials should be separated from Java source code.

The connection flow becomes:

    Java Application
          ↓
      DBConnection
          ↓
      db.properties
          ↓
      MySQL Database

The properties file should be excluded from Git.

Example `.gitignore` entry:

    src/main/resources/db.properties

---

# 8️⃣ Select Operation

## 📄 File

`SelectEx.java`

The `SelectEx` program retrieves employee records from the `employees` table.

SQL operation:

    SELECT * FROM employees;

The program performs the following steps:

    Load JDBC Driver
          ↓
    Get Connection
          ↓
    Create Statement
          ↓
    Execute SELECT
          ↓
    Receive ResultSet
          ↓
    Read Records
          ↓
    Close Resources

---

# 9️⃣ Statement

The `Statement` interface is used to execute SQL statements.

Example:

    Statement stmt = con.createStatement();

For SELECT operations:

    stmt.executeQuery(SQL);

For INSERT, UPDATE, and DELETE operations:

    stmt.executeUpdate(SQL);

---

# 🔟 ResultSet

## 📄 File

`ResultSetEx.java`

`ResultSet` represents the rows returned by a SQL query.

The cursor can be moved through the returned rows using:

    while (res.next()) {
        // read data
    }

Common retrieval methods practiced:

    getInt()
    getString()
    getDouble()
    getDate()

---

# 1️⃣1️⃣ Insert Operation

## 📄 File

`InsertEx.java`

The `InsertEx` program inserts a new employee record into the `employees` table.

SQL operation:

    INSERT INTO employees (...)
    VALUES (...);

The number of affected rows is returned by:

    executeUpdate()

Example output:

    1 row inserted!

---

# 1️⃣2️⃣ Update Operation

## 📄 File

`UpdateEx.java`

The `UpdateEx` program updates an employee's salary.

SQL operation:

    UPDATE employees
    SET salary = salary + 5000
    WHERE employee_id = 101;

The affected row count is returned by:

    executeUpdate()

---

# 1️⃣3️⃣ Delete Operation

## 📄 File

`DeleteEx.java`

The `DeleteEx` program removes an employee record.

SQL operation:

    DELETE FROM employees
    WHERE employee_id = 106;

The affected row count is returned by:

    executeUpdate()

---

# 1️⃣4️⃣ Count Query

## 📄 File

`CountEx.java`

The `CountEx` program retrieves the total number of employees.

SQL operation:

    SELECT COUNT(*) FROM employees;

The result can be retrieved using:

    int count = result.getInt(1);

---

# 1️⃣5️⃣ CRUD Operations Practiced

| Operation | SQL Command | JDBC Method |
|---|---|---|
| Create | `INSERT` | `executeUpdate()` |
| Read | `SELECT` | `executeQuery()` |
| Update | `UPDATE` | `executeUpdate()` |
| Delete | `DELETE` | `executeUpdate()` |

---

# 1️⃣6️⃣ JDBC Execution Flow

The complete basic JDBC flow practiced today:

    Load Driver
         ↓
    Get Connection
         ↓
    Create Statement
         ↓
    Execute SQL
         ↓
    Process ResultSet
         ↓
    Close ResultSet
         ↓
    Close Statement
         ↓
    Close Connection

---

# 1️⃣7️⃣ Exception Handling

The JDBC programs handle database-related exceptions.

Important exceptions practiced:

    ClassNotFoundException
    SQLException

`ClassNotFoundException` can occur when the JDBC driver class cannot be loaded.

`SQLException` represents database-related errors.

Examples include:

- Invalid SQL
- Connection failure
- Authentication failure
- Missing table
- Constraint violation
- Database availability problems

---

# 1️⃣8️⃣ Resource Management

The JDBC programs explicitly close resources.

General closing order:

    ResultSet
        ↓
    Statement
        ↓
    Connection

Closing JDBC resources is important because open resources consume database and application resources.

---

# 1️⃣9️⃣ Important JDBC Methods

## `DriverManager.getConnection()`

Creates a database connection.

## `createStatement()`

Creates a `Statement` object.

## `executeQuery()`

Executes a query that returns a `ResultSet`.

Commonly used with:

    SELECT

## `executeUpdate()`

Executes SQL statements that modify data.

Commonly used with:

    INSERT
    UPDATE
    DELETE

## `ResultSet.next()`

Moves the cursor to the next available row.

## `ResultSet.getInt()`

Retrieves an integer value.

## `ResultSet.getString()`

Retrieves a String value.

## `ResultSet.getDouble()`

Retrieves a decimal value.

## `ResultSet.getDate()`

Retrieves a SQL date value.

---

# ⚠️ 2️⃣0️⃣ Important Limitation

The Day 52 CRUD examples primarily use `Statement`.

This is useful for understanding the JDBC fundamentals.

However, dynamically building SQL using user input can create SQL injection vulnerabilities.

Problematic flow:

    User Input
         ↓
    String Concatenation
         ↓
    SQL Query
         ↓
    Statement

This will be improved in the upcoming JDBC lessons.

---

# 🚨 2️⃣1️⃣ Next JDBC Step

The next important JDBC concept is:

    Statement
         ↓
    PreparedStatement
         ↓
    Parameterized Queries
         ↓
    SQL Injection Prevention

`PreparedStatement` will be used for safer and more maintainable database operations.

---

# 🧠 JDBC Concepts Learned

Today I practiced:

- JDBC
- JDBC architecture
- JDBC driver
- MySQL connectivity
- DriverManager
- Connection
- Statement
- ResultSet
- executeQuery()
- executeUpdate()
- SELECT
- INSERT
- UPDATE
- DELETE
- COUNT
- SQLException
- ClassNotFoundException
- Resource closing
- DBConnection utility
- `db.properties`
- `.gitignore`

---

# 🎯 Interview Preparation

## 1. What is JDBC?

### Direct Answer

JDBC is Java's standard API for communicating with relational databases.

### Why / How

It provides APIs for establishing database connections, executing SQL statements, and processing results.

### Real-World Gotcha

JDBC is an API. Communication with a specific database requires a suitable JDBC driver.

### Likely Follow-Up

What is the role of the JDBC driver?

---

## 2. What is DriverManager?

### Direct Answer

`DriverManager` manages JDBC drivers and helps establish database connections.

### Why / How

It identifies a suitable JDBC driver and uses it to establish a connection.

### Real-World Gotcha

Modern JDBC applications can automatically load JDBC drivers through the JDBC driver mechanism.

### Likely Follow-Up

What does `DriverManager.getConnection()` return?

---

## 3. What is the difference between `executeQuery()` and `executeUpdate()`?

### Direct Answer

`executeQuery()` is used for queries that return results, while `executeUpdate()` is used for SQL statements that modify data.

### Why / How

Typical usage:

    SELECT → executeQuery()

    INSERT → executeUpdate()

    UPDATE → executeUpdate()

    DELETE → executeUpdate()

### Real-World Gotcha

Using an inappropriate execution method can result in a JDBC exception.

### Likely Follow-Up

What does `executeUpdate()` return?

---

## 4. What is ResultSet?

### Direct Answer

`ResultSet` represents the data returned from a database query.

### Why / How

It provides methods to navigate through rows and retrieve column values.

### Real-World Gotcha

The cursor initially starts before the first row, so `next()` must be called before reading row data.

### Likely Follow-Up

What happens when `ResultSet.next()` returns `false`?

---

## 5. Why should database credentials not be hardcoded?

### Direct Answer

Database credentials should not be hardcoded because source code can be shared, committed, or exposed.

### Why / How

Separating configuration from source code improves security and makes configuration easier to manage.

### Real-World Gotcha

A private GitHub repository should not be treated as a secure password storage system.

### Likely Follow-Up

How can database credentials be excluded from Git?

---

# 🔐 Security Checklist

Before pushing the project to GitHub:

- [ ] Do not commit the real database password.
- [ ] Do not commit private database credentials.
- [ ] Add `db.properties` to `.gitignore`.
- [ ] Verify `db.properties` does not appear in Source Control.
- [ ] Use placeholder credentials in documentation.
- [ ] Keep the real credentials only in the local environment.

---

# 📝 Day 52 Summary

Today I connected Java with MySQL using JDBC and practiced the fundamental JDBC workflow.

## Covered

- JDBC fundamentals
- JDBC architecture
- MySQL JDBC driver
- DriverManager
- Connection
- Statement
- ResultSet
- SELECT
- INSERT
- UPDATE
- DELETE
- COUNT query
- executeQuery()
- executeUpdate()
- Exception handling
- Resource management
- DBConnection utility
- External database configuration
- db.properties
- Git security

---

# 🚀 Next

## Day 53

### Core Java

Continue with:

- Conditions
- Loops
- Pattern programming
- Arrays
- Array traversal
- Array built-in methods
- Real-world array problems

### JDBC

Continue with:

- PreparedStatement
- Parameterized SQL
- CRUD using PreparedStatement
- SQL injection
- Better resource management

---
# 📅 Challenge Information

**Challenge:** 100 Days Full Stack Challenge

**Day:** 52

**Track:** JDBC

**Phase:** Phase 1 — Java Backend

**Status:** ✅ Completed

---
⭐ Keep Coding. Keep Building. Keep Improving.
