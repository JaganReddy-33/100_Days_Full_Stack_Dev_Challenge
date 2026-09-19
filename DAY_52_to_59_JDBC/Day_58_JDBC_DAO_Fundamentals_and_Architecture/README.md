
````markdown
# Day 58 — JDBC | Account Management System

## 🚀 Project

**Real-Time UPI Payment Fraud & Risk Scoring System**

Day 58 focused on building the **Account Management foundation** of the UPI Payment Fraud & Risk Scoring System using JDBC, MySQL, DAO architecture, and a Service Layer.

The objective was to move from basic JDBC operations toward a structured backend architecture:

```text
App
 ↓
Service
 ↓
DAO
 ↓
JDBC
 ↓
MySQL
````

---

# 📌 Day 58 JDBC Overview

Day 58 JDBC was divided into two major parts:

### Part 1 — JDBC Account Domain

* Database configuration
* JDBC connection management
* Account database table
* Account model
* DAO interface
* DAO implementation
* Create account
* Find account by ID
* Find account by UPI ID
* Find all active accounts
* Update account balance
* Update account status

### Part 2 — Service Layer

* Understanding Service Layer
* Connecting App with Service
* Moving business validation into Service
* AccountService
* Create account validation
* Account lookup validation
* Balance operation validation
* Account status validation
* Complete App → Service → DAO architecture
* End-to-end testing

---

# 🏦 Part 1 — Account Domain

## 1. Database

Database schema:

```text
upi_fraud_system
```

Main table created for Day 58:

```text
accounts
```

### Accounts Table

```sql
CREATE TABLE accounts (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    upi_id VARCHAR(100) NOT NULL UNIQUE,
    account_number VARCHAR(20) NOT NULL UNIQUE,
    balance DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    account_status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

The table stores:

* Account ID
* User name
* UPI ID
* Account number
* Balance
* Account status
* Creation timestamp

---

# 📁 Database Script

Created:

```text
database
└── accounts.sql
```

The SQL file contains the `accounts` table definition for future reference.

Future database tables will be added progressively as the project grows.

---

# 🔐 Database Configuration

Database configuration is stored separately from Java source code.

```text
src/main/resources
└── db.properties
```

Example configuration:

```properties
db.url=jdbc:mysql://localhost:3306/upi_fraud_system
db.username=root
db.password=YOUR_MYSQL_PASSWORD
```

The real `db.properties` file is excluded from Git using `.gitignore`.

A template can be maintained using:

```text
db.properties.example
```

---

# 🔌 2. ConnectionEx

### File

```text
src/main/java/day58/ConnectionEx.java
```

### Responsibility

`ConnectionEx` is responsible for creating a JDBC connection using the database configuration.

It:

* Loads `db.properties`
* Reads database URL
* Reads username
* Reads password
* Loads MySQL JDBC Driver
* Creates a JDBC connection
* Returns `Connection`

The application successfully connected to:

```text
upi_fraud_system
```

---

# 🧱 3. Account Model

### File

```text
src/main/java/day58/model/Account.java
```

### Responsibility

`Account` represents one record from the `accounts` table.

Fields:

```text
accountId
userName
upiId
accountNumber
balance
accountStatus
createdAt
```

The model contains:

* No database SQL
* No Scanner
* No user input
* Getters
* Setters
* Constructors
* `toString()`

---

# 🧩 4. AccountDAO

### File

```text
src/main/java/day58/dao/AccountDAO.java
```

### Type

```text
Interface
```

### Responsibility

`AccountDAO` defines the database operations that can be performed for an account.

Methods:

```java
boolean createAccount(Account account) throws SQLException;

Account findAccountById(int accountId) throws SQLException;

Account findAccountByUpiId(String upiId) throws SQLException;

List<Account> findAllActiveAccounts() throws SQLException;

boolean updateBalance(int accountId, BigDecimal amount, String operation) throws SQLException;

boolean updateAccountStatus(int accountId, String status) throws SQLException;
```

The interface defines **WHAT operations are available**.

It does not define the JDBC implementation details.

---

# 🛠️ 5. AccountDAOImpl

### File

```text
src/main/java/day58/daoimpl/AccountDAOImpl.java
```

### Type

```text
Class
```

### Responsibility

`AccountDAOImpl` implements `AccountDAO` and contains the actual JDBC/database logic.

It uses:

```text
Connection
PreparedStatement
ResultSet
SQLException
```

---

# 6. createAccount()

Creates a new account in the database.

The method:

* Inserts account details
* Uses `PreparedStatement`
* Executes the INSERT
* Retrieves the generated AUTO_INCREMENT ID
* Stores the generated ID inside the `Account` object

Important JDBC concepts:

```text
Statement.RETURN_GENERATED_KEYS
getGeneratedKeys()
```

Example flow:

```text
Account object
      ↓
INSERT
      ↓
MySQL AUTO_INCREMENT
      ↓
Generated account_id
      ↓
Account.setAccountId()
```

---

# 7. findAccountById()

Searches for one account using:

```text
account_id
```

SQL concept:

```sql
SELECT * FROM accounts WHERE account_id = ?
```

Because `account_id` is the primary key, the query returns at most one account.

The method:

* Executes SELECT
* Reads the ResultSet
* Creates an Account object
* Returns the Account
* Returns `null` when no account exists

---

# 8. findAccountByUpiId()

Searches for an account using:

```text
upi_id
```

SQL concept:

```sql
SELECT * FROM accounts WHERE upi_id = ?
```

The `upi_id` column is UNIQUE, so one UPI ID maps to one account.

The method converts the database row into an `Account` object.

---

# 9. findAllActiveAccounts()

Retrieves all accounts whose status is:

```text
ACTIVE
```

SQL concept:

```sql
SELECT * FROM accounts WHERE account_status = 'ACTIVE'
```

The return type is:

```java
List<Account>
```

because multiple database rows can be returned.

Important ResultSet concept:

```text
if(resultSet.next())
```

is suitable when expecting one row.

```text
while(resultSet.next())
```

is required when processing multiple rows.

If no active accounts exist, the DAO returns an empty list rather than `null`.

---

# 10. updateBalance()

The balance operation was designed as an adjustment rather than directly replacing the existing balance.

Supported operations:

```text
CREDIT
DEBIT
```

### CREDIT

```text
Existing Balance + Amount
```

Example:

```text
₹12,000 + ₹18,000
        ↓
₹30,000
```

### DEBIT

```text
Existing Balance - Amount
```

The DAO also prevents a debit when the available balance is insufficient.

The account must also be:

```text
ACTIVE
```

for the balance operation.

---

# 11. updateAccountStatus()

Updates the account status.

Supported statuses:

```text
ACTIVE
SUSPENDED
BLOCKED
```

SQL concept:

```sql
UPDATE accounts
SET account_status = ?
WHERE account_id = ?
```

The status is normalized before being stored.

Examples:

```text
active
Active
ACTIVE
```

become:

```text
ACTIVE
```

Likewise:

```text
suspended
Suspended
SUSPENDED
```

become:

```text
SUSPENDED
```

---

# 🧠 Part 2 — Service Layer

After completing the Account DAO implementation, the next architectural step was introducing the Service Layer.

The architecture became:

```text
App
 ↓
AccountService
 ↓
AccountDAO
 ↓
AccountDAOImpl
 ↓
JDBC
 ↓
MySQL
```

---

# 🧩 AccountService

### File

```text
src/main/java/day58/service/AccountService.java
```

### Type

```text
Class
```

### Responsibility

`AccountService` contains account-related business validation and delegates database operations to the DAO.

The Service Layer answers:

> What business operation should happen?

The DAO answers:

> How should the database operation happen?

---

# 12. AccountService — createAccount()

Validates:

```text
Account object
User name
UPI ID
Account number
Initial balance
```

Rules:

```text
Account cannot be null
User name cannot be empty
UPI ID cannot be empty
Account number cannot be empty
Balance cannot be null
Balance cannot be negative
```

A newly created account receives:

```text
ACTIVE
```

as its default status.

Then the Service delegates the actual database operation:

```text
AccountService
      ↓
AccountDAO.createAccount()
```

---

# 13. AccountService — findAccountById()

Validates:

```text
accountId > 0
```

If valid:

```text
AccountService
      ↓
AccountDAO.findAccountById()
```

If invalid:

```text
return null
```

---

# 14. AccountService — findAccountByUpiId()

Validates:

```text
UPI ID is not null
UPI ID is not empty
```

The input is trimmed before being passed to the DAO.

Example:

```text
"   santhosh@upi   "
```

becomes:

```text
"santhosh@upi"
```

The Service then delegates to:

```text
AccountDAO.findAccountByUpiId()
```

---

# 15. AccountService — findAllActiveAccounts()

No input validation is required because this method doesn't receive parameters.

The Service delegates directly:

```text
AccountService
      ↓
AccountDAO.findAllActiveAccounts()
```

Return type:

```text
List<Account>
```

---

# 16. AccountService — updateBalance()

Validates:

```text
accountId > 0
amount != null
amount > 0
operation != null
operation is not empty
operation is CREDIT or DEBIT
```

The operation is normalized:

```text
credit
Credit
CREDIT
```

becomes:

```text
CREDIT
```

and:

```text
debit
Debit
DEBIT
```

becomes:

```text
DEBIT
```

Then:

```text
AccountService
      ↓
AccountDAO.updateBalance()
```

---

# 17. AccountService — updateAccountStatus()

Validates:

```text
accountId > 0
status != null
status is not empty
```

Supported statuses:

```text
ACTIVE
SUSPENDED
BLOCKED
```

The status is normalized before delegation.

Flow:

```text
AccountService
      ↓
AccountDAO.updateAccountStatus()
```

---

# 🖥️ App Integration

### File

```text
src/main/java/day58/App.java
```

`App` remains responsible for:

* Scanner
* User input
* Menu
* Calling Service methods
* Displaying results

The application menu contains:

```text
1. Create Account
2. Find Account By ID
3. Find Account By UPI_ID
4. Find All Active Accounts
5. Update Account Balance
6. Update Account Status
0. Exit
```

The application now uses:

```text
AccountService
```

instead of directly calling:

```text
AccountDAO
```

---

# 🏗️ Final Day 58 Architecture

```text
                         App
                          │
                          ▼
                  ┌───────────────┐
                  │ AccountService │
                  └───────┬───────┘
                          │
                          ▼
                  ┌───────────────┐
                  │  AccountDAO   │
                  │   Interface   │
                  └───────┬───────┘
                          │
                          ▼
                  ┌───────────────┐
                  │AccountDAOImpl │
                  └───────┬───────┘
                          │
                          ▼
                        JDBC
                          │
                          ▼
                    MySQL Database
                          │
                          ▼
                   upi_fraud_system
                          │
                          ▼
                       accounts
```

---

# 📂 Day 58 JDBC Folder Structure

```text
Day_58_JDBC_DAO
│
├── database
│   └── accounts.sql
│
├── src
│   └── main
│       ├── java
│       │   └── day58
│       │       ├── dao
│       │       │   └── AccountDAO.java
│       │       │
│       │       ├── daoimpl
│       │       │   └── AccountDAOImpl.java
│       │       │
│       │       ├── model
│       │       │   └── Account.java
│       │       │
│       │       ├── service
│       │       │   └── AccountService.java
│       │       │
│       │       ├── ConnectionEx.java
│       │       └── App.java
│       │
│       └── resources
│           ├── db.properties
│           └── db.properties.example
│
├── pom.xml
└── .gitignore
```

---

# 🧪 Day 58 End-to-End Testing

The following operations were successfully tested.

### Create Account

Example:

```text
User: Santhosh
UPI ID: santhosh@upi
Account Number: ACC1007
Initial Balance: ₹12,000
```

Result:

```text
Account created successfully!
Generated Account ID: 12
```

---

### Find Account By ID

Tested invalid ID:

```text
-1
```

Result:

```text
Account not found!
```

Tested valid ID:

```text
2
```

Result:

```text
Account found successfully!
```

---

### Find Account By UPI ID

Tested:

```text
santhosh@upi
```

and:

```text
Santhosh@upi
```

The Service normalization allowed the lookup to work with mixed-case input.

---

### Find All Active Accounts

Successfully retrieved multiple active accounts using:

```text
List<Account>
```

---

### Credit Balance

Initial:

```text
₹12,000
```

Credit:

```text
₹18,000
```

Result:

```text
₹30,000
```

---

### Update Account Status

Example:

```text
Account ID: 11
Status: Suspended
```

Result:

```text
SUSPENDED
```

---

# 🧠 Key JDBC Concepts Learned

## JDBC

Java Database Connectivity used to communicate between Java applications and relational databases.

```text
Java
 ↓
JDBC
 ↓
MySQL
```

## Connection

Used to establish communication with the database.

## PreparedStatement

Used for parameterized SQL queries.

```text
?
```

placeholders are populated using methods such as:

```text
setInt()
setString()
setBigDecimal()
```

## ResultSet

Used to read data returned by SELECT queries.

## executeQuery()

Used for SELECT operations.

## executeUpdate()

Used for:

```text
INSERT
UPDATE
DELETE
```

## Generated Keys

Used to retrieve AUTO_INCREMENT IDs after INSERT.

## BigDecimal

Used for monetary values such as account balances and transaction amounts.

## List<Account>

Used when a database query can return multiple account records.

---

# 🧠 Architecture Concepts Learned

### Model

Represents application data.

```text
Account
```

### DAO

Represents database operations.

```text
AccountDAO
```

### DAO Implementation

Contains actual JDBC implementation.

```text
AccountDAOImpl
```

### Service

Contains business validation and coordinates DAO operations.

```text
AccountService
```

### App

Handles user interaction.

```text
Scanner
Menu
Input
Output
```

---

# 🔑 Important Design Principle

The application should not allow database logic to spread everywhere.

Instead:

```text
App
 ↓
Service
 ↓
DAO
 ↓
Database
```

This makes the application easier to:

* maintain
* test
* extend
* debug
* modify

---

# 🚧 Current Project Status

## Completed

```text
Database
   ↓
accounts table                    ✅

Connection
   ↓
ConnectionEx                      ✅

Model
   ↓
Account                           ✅

DAO
   ↓
AccountDAO                        ✅

DAO Implementation
   ↓
AccountDAOImpl                    ✅

Service
   ↓
AccountService                    ✅

Application
   ↓
App                               ✅

End-to-End Testing                ✅
```

---

# 🔜 Next Phase — Day 59

The next domain will be the **Transaction Domain**.

The project will expand from:

```text
accounts
```

to:

```text
accounts
    +
transactions
```

### Day 59 JDBC

```text
Transaction Domain
        ↓
transactions table
        ↓
Transaction Model
        ↓
TransactionDAO
        ↓
TransactionDAOImpl
```

### Day 59 Core Java

```text
Inheritance
        +
Method Overriding
```

---

# 🔥 Future Project Architecture

As the project grows:

```text
                         App
                          │
                          ▼
                     Services
                          │
             ┌────────────┼────────────┐
             ▼            ▼            ▼
        Account       Transaction    Merchant
        Service         Service       Service
             │            │            │
             ▼            ▼            ▼
           DAO          DAO           DAO
             │            │            │
             └────────────┼────────────┘
                          ▼
                         JDBC
                          │
                          ▼
                         MySQL
```

Eventually:

```text
Account
   ↓
Transaction
   ↓
Risk Score
   ↓
Fraud Detection
   ↓
Fraud Alert
   ↓
Audit Log
```

---

# 📅 JDBC + Core Java Project Roadmap

| Day | Core Java                               | JDBC / Project                           |
| --- | --------------------------------------- | ---------------------------------------- |
| 58  | Encapsulation, Constructors, Static     | Account Domain + DAO + Service           |
| 59  | Inheritance + Method Overriding         | Transaction Domain + Table + Model + DAO |
| 60  | Polymorphism + `super` + `final`        | Atomic UPI Transfer + JDBC Transactions  |
| 61  | Interfaces + Abstract Classes           | Merchant Domain                          |
| 62  | Exception Handling                      | Business Exceptions + Validation         |
| 63  | Collections                             | Transaction History + Filtering          |
| 64  | Generics + Wrapper Classes              | Risk Score Domain                        |
| 65  | Date/Time + Enums                       | Risk Engine                              |
| 66  | File Handling / Properties              | Fraud Alert Domain                       |
| 67  | Java 8+ Functional Concepts             | Fraud Detection Workflow                 |
| 68  | Multithreading Basics                   | Processing / Concurrency Concepts        |
| 69  | Core Java Revision + Interview Problems | Audit Logs + Integration                 |
| 70  | Complete Core Java Revision             | End-to-End JDBC Backend Testing          |

The timetable is flexible and can be extended when a concept or project module requires additional practice.

---

# 🎯 Day 58 Final Learning Outcome

By the end of Day 58, the project moved beyond basic JDBC examples into a layered backend structure:

```text
User Input
    ↓
App
    ↓
Service
    ↓
DAO
    ↓
DAO Implementation
    ↓
JDBC
    ↓
MySQL
```

The **Account domain is now the first completed backend module** of the Real-Time UPI Payment Fraud & Risk Scoring System.

The next development phase is the **Transaction Domain**, which will introduce the core payment-flow functionality of the application.

---

# 👨‍💻 Project

**Real-Time UPI Payment Fraud & Risk Scoring System**

### Day 58 Status

```text
Core Java Part 1        ✅
Core Java Part 2        ✅
JDBC Account Domain     ✅
DAO Layer               ✅
Service Layer           ✅
App Integration         ✅
End-to-End Testing     ✅

Day 58 COMPLETE         ✅
```

### Next Goal

```text
DAY 59

Core Java:
Inheritance + Method Overriding

JDBC:
Transaction Domain
        ↓
transactions table
        ↓
Transaction Model
        ↓
TransactionDAO
        ↓
TransactionDAOImpl
```

```
```
