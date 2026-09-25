# UPI Fraud & Risk Management System

A Java + JDBC backend system for processing UPI-style payments with transactional database operations, concurrency control, idempotency, rule-based risk assessment, and transaction reporting.

This project was developed progressively from **Day 58 to Day 60** as a practical backend application, evolving from account management and DAO architecture into atomic payment processing, fraud-risk evaluation, concurrency handling, and reporting.

---

## Overview

The system models a simplified UPI payment workflow where:

* Accounts can be created and managed.
* UPI payments can be initiated between accounts.
* Sender and receiver balances are updated atomically.
* Database transactions use `COMMIT` and `ROLLBACK`.
* Concurrent payment requests are protected using row-level locking.
* Duplicate payment requests can be prevented using idempotency keys.
* Transactions are evaluated using a rule-based risk scoring engine.
* High-risk transactions can be blocked.
* Transaction history and reporting can be generated from the database.

The project focuses on understanding how a backend payment workflow can coordinate **Java business logic, JDBC, SQL, transactions, concurrency, and risk evaluation**.

---

## Key Features

### Account Management

* Create accounts
* Find account by ID
* Find account by UPI ID
* List active accounts
* Update account balance
* Update account status
* Account validation before payment processing

### Transaction Management

* Create transactions
* Find transaction by ID
* Find transaction by reference
* Find transaction by idempotency key
* Find transactions by account
* List all transactions
* Update transaction status
* Update transaction risk score

### Atomic Payment Processing

Payment processing follows a single database transaction:

```text
Payment Request
      │
      ▼
Validate Sender
      │
      ▼
Validate Receiver
      │
      ▼
Check Idempotency
      │
      ▼
Evaluate Risk
      │
      ▼
Lock Accounts
      │
      ▼
Validate Balance
      │
      ▼
Create Transaction
      │
      ▼
Debit Sender
      │
      ▼
Credit Receiver
      │
      ▼
Update Transaction Status
      │
      ▼
    COMMIT
```

If any critical operation fails:

```text
Failure
   │
   ▼
ROLLBACK
   │
   ▼
No Partial Payment
```

### Concurrency Control

The payment flow handles concurrent access using:

* `READ_COMMITTED` transaction isolation
* `SELECT ... FOR UPDATE`
* Row-level account locking
* Deterministic account lock ordering
* Shared database connection for atomic operations

The lock ordering is designed to reduce the possibility of deadlocks when two payments involve the same accounts in opposite directions.

### Idempotency

Transactions support an `idempotency_key` to identify repeated payment requests.

This allows the system to detect an already-processed request before creating another payment transaction.

### Rule-Based Risk Assessment

The project includes a database-backed, weighted risk engine.

Risk factors include:

* Transaction amount
* Balance impact
* Transaction velocity
* Recent transaction volume
* Failed transactions
* Recipient familiarity
* Previous high-risk activity
* Account status

The resulting score is categorized as:

```text
0 ───────────── 29     LOW
30 ──────────── 69     MEDIUM
70 ─────────── 100     HIGH
```

Decision mapping:

```text
LOW      → ALLOW
MEDIUM   → REVIEW
HIGH     → BLOCK
```

### Transaction Reporting

The system supports:

* Account transaction history
* Date-range transaction history
* Transaction summary
* High-risk transaction report

Reports include transaction counts, amounts, statuses, and risk-level information.

---

## Technology Stack

| Technology | Purpose                        |
| ---------- | ------------------------------ |
| Java       | Application and business logic |
| JDBC       | Database connectivity          |
| MySQL      | Relational database            |
| SQL        | Data persistence and reporting |
| Maven      | Dependency management          |
| Git        | Version control                |
| Eclipse    | Java development environment   |

### Java Concepts Applied

* Encapsulation
* Constructors
* Method overloading
* Inheritance
* Method overriding
* Polymorphism
* Dynamic method dispatch
* Collections
* Exception handling
* Object-oriented design

### JDBC Concepts Applied

* `Connection`
* `PreparedStatement`
* `ResultSet`
* Generated keys
* DAO pattern
* Shared database connections
* Transaction management
* `COMMIT`
* `ROLLBACK`
* Transaction isolation
* Row-level locking
* Batch/database operations
* Parameterized SQL

---

# Architecture

The project follows a layered JDBC architecture:

```text
┌──────────────────────────────┐
│            App               │
│       Console Interface      │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│          Service             │
│ Business & Payment Logic     │
│ Risk & Reporting Logic       │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│            DAO               │
│        Data Contracts        │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│         DAOImpl              │
│      JDBC Implementation     │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│           JDBC               │
│ Connection / SQL / ResultSet │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│           MySQL              │
│      upi_fraud_system        │
└──────────────────────────────┘
```

---

# Project Structure

```text
DAY_58_JDBC_DAO_Fundamentals_and_Architecture/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── day58/
│   │   │       ├── model/
│   │   │       │   ├── Account.java
│   │   │       │   ├── Transaction.java
│   │   │       │   ├── TransactionSummary.java
│   │   │       │   ├── RiskProfile.java
│   │   │       │   ├── RiskAssessment.java
│   │   │       │   └── PaymentResult.java
│   │   │       │
│   │   │       ├── dao/
│   │   │       │   ├── AccountDAO.java
│   │   │       │   ├── TransactionDAO.java
│   │   │       │   └── RiskDAO.java
│   │   │       │
│   │   │       ├── daoimpl/
│   │   │       │   ├── AccountDAOImpl.java
│   │   │       │   ├── TransactionDAOImpl.java
│   │   │       │   └── RiskDAOImpl.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   ├── PaymentService.java
│   │   │       │   ├── RiskService.java
│   │   │       │   └── ReportingService.java
│   │   │       │
│   │   │       ├── config/
│   │   │       │
│   │   │       ├── ConnectionEx/
│   │   │       │   └── ConnectionEx.java
│   │   │       │
│   │   │       └── App.java
│   │   │
│   │   └── resources/
│   │       ├── db.properties
│   │       └── db.properties.example
│   │
│   └── test/
│
├── pom.xml
└── README.md
```

---

# Database

Database:

```text
upi_fraud_system
```

## Accounts

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

## Transactions

```sql
CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    transaction_reference VARCHAR(100) NOT NULL UNIQUE,
    idempotency_key VARCHAR(100) NOT NULL UNIQUE,
    transaction_type VARCHAR(20) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    recipient_upi_id VARCHAR(100),
    transaction_status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    risk_score INT DEFAULT 0,
    transaction_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);
```

---

# Development Progression

## Day 58 — Account Domain & DAO Foundation

### Part 1 — Encapsulation, Constructors & Account DAO

Built the initial account-management foundation.

### Core Java

* Encapsulation
* Constructors
* Private fields
* Getters and setters
* Object creation and state management

### JDBC

* Database connection setup
* `db.properties`
* Account model
* Account DAO interface
* Account DAO implementation
* `PreparedStatement`
* Generated keys
* `BigDecimal` for monetary values
* Affected-row validation
* Account status handling

Initial architecture:

```text
App
 ↓
AccountDAO
 ↓
AccountDAOImpl
 ↓
JDBC
 ↓
MySQL
```

### Part 2 — Static Concepts & Project Continuation

Continued the Core Java learning track with static concepts while extending the account domain of the UPI Fraud & Risk system.

The project remained focused on building the database-backed account foundation required for later payment processing.

---

# Day 59 — Transaction Domain & DAO Architecture

## Part 1 — Inheritance, Method Overriding & Transaction Foundation

### Core Java

* Inheritance
* Method overriding
* Parent-child class relationships
* Runtime behavior through overridden methods

### JDBC / Project Development

The project progressed from account management toward transaction processing and introduced the transaction domain required for UPI payments.

---

## Part 2 — Transaction Model, DAO & Service Integration

Implemented the transaction persistence layer.

### Transaction Components

* `Transaction` model
* `TransactionDAO`
* `TransactionDAOImpl`
* Transaction creation
* Transaction lookup by ID
* Transaction lookup by reference
* Transaction lookup by idempotency key
* Account-based transaction history
* Transaction status updates
* Risk-score updates

Architecture expanded to:

```text
App
 ↓
Service
 ↓
DAO
 ↓
DAOImpl
 ↓
JDBC
 ↓
MySQL
```

---

# Day 60 — Payment Processing, Concurrency & Reporting

## Part 1 — Polymorphism & Atomic Payment Processing

### Core Java

* Polymorphism
* Method overloading
* Method overriding
* Dynamic method dispatch
* Practical coding exercises

### JDBC Payment Integration

Integrated accounts and transactions into an atomic payment workflow.

Implemented:

* Shared JDBC connection
* Manual transaction boundaries
* `setAutoCommit(false)`
* Payment validation
* Sender account validation
* Receiver validation
* Transaction creation
* Sender debit
* Receiver credit
* Transaction status update
* `COMMIT`
* `ROLLBACK`

Core payment flow:

```text
Sender
  │
  ├── Validate
  │
  ├── Debit
  │
  ▼
Transaction
  │
  ├── Create
  ├── Risk evaluation
  └── Update status
  │
  ▼
Receiver
  │
  └── Credit
```

All critical database operations use the same connection so the payment can succeed or fail as one database transaction.

---

## Part 2 — Concurrency, Idempotency, Risk & Reporting

Extended the payment system with backend concerns required for safer payment processing.

### Concurrency

Implemented:

* Concurrent payment handling
* `READ_COMMITTED` isolation
* `SELECT ... FOR UPDATE`
* Account row locking
* Deterministic lock ordering
* Deadlock-risk reduction

### Idempotency

Added:

* `idempotency_key`
* Duplicate-request detection
* Idempotent payment lookup
* Protection against repeated payment processing

### Risk Engine

Implemented a weighted, database-backed risk assessment system.

Risk evaluation considers:

```text
Amount
Balance Impact
Velocity
24h Volume
Failed Transactions
Recipient Familiarity
High-Risk History
Account Status
```

The system produces:

```text
Risk Score
    ↓
Risk Level
    ↓
Decision
```

Example:

```text
Risk Score : 12
Risk Level : LOW
Decision   : ALLOW
```

### Reporting

Implemented:

* Account transaction history
* Date-range transaction history
* Transaction summary
* High-risk transaction report
* Reporting service

---

# End-to-End Payment Flow

```text
                    UPI PAYMENT REQUEST
                             │
                             ▼
                    Validate Input
                             │
                             ▼
                    Check Idempotency
                             │
                             ▼
                 Find Sender & Receiver
                             │
                             ▼
                     Lock Accounts
                             │
                             ▼
                    Validate Accounts
                             │
                             ▼
                    Validate Balance
                             │
                             ▼
                    Risk Assessment
                             │
              ┌──────────────┴──────────────┐
              │                             │
            BLOCK                     ALLOW / REVIEW
              │                             │
              ▼                             ▼
           ROLLBACK                 Create Transaction
                                            │
                                            ▼
                                      Debit Sender
                                            │
                                            ▼
                                      Credit Receiver
                                            │
                                            ▼
                                  Update Transaction
                                            │
                                            ▼
                                          COMMIT
```

---

# Transaction Safety

The payment operation is designed as an atomic unit:

```text
BEGIN TRANSACTION
       │
       ├── Validate
       ├── Lock
       ├── Risk Check
       ├── Create Transaction
       ├── Debit
       ├── Credit
       └── Update Status
       │
       ▼
     COMMIT
```

Any critical failure results in:

```text
ROLLBACK
```

This prevents partial balance updates such as:

```text
Sender debited
     +
Receiver not credited
```

---

# Reporting

The reporting layer provides four major views.

### Account Transaction History

Retrieves transactions associated with an account.

### Date-Range History

Retrieves transactions between:

```text
Start Date/Time
        ↓
End Date/Time
```

### Transaction Summary

Provides:

* Total transactions
* Successful transactions
* Failed transactions
* Pending transactions
* Total amount
* Successful amount
* Average transaction amount
* Low-risk transaction count
* Medium-risk transaction count
* High-risk transaction count

### High-Risk Report

Retrieves transactions whose risk score meets the configured minimum threshold.

---

# Configuration

Database configuration is externalized through:

```text
src/main/resources/db.properties
```

Example configuration:

```properties
db.url=jdbc:mysql://localhost:3306/upi_fraud_system
db.username=YOUR_USERNAME
db.password=YOUR_PASSWORD
```

Do not commit real database credentials.

Use:

```text
db.properties.example
```

as the configuration template.

---

# Getting Started

## Prerequisites

* Java JDK
* Maven
* MySQL
* Git
* Eclipse or another Java IDE

## 1. Clone the repository

```bash
git clone <YOUR_REPOSITORY_URL>
cd Day_58_to_60_UPI_FRAUD_RISK_SYSTEM
```

## 2. Create the database

```sql
CREATE DATABASE upi_fraud_system;
```

Create the required `accounts` and `transactions` tables.

## 3. Configure the database

Copy:

```text
db.properties.example
```

to:

```text
db.properties
```

Then configure your MySQL credentials.

## 4. Build the project

```bash
mvn clean install
```

## 5. Run the application

Run:

```text
day58.App
```

from Eclipse or your Java environment.

---

# Application Modules

```text
Account Management
        │
        ▼
Transaction Management
        │
        ▼
Payment Processing
        │
        ├── Atomic Transactions
        ├── Concurrency Control
        ├── Idempotency
        └── Risk Assessment
        │
        ▼
Transaction Reporting
```

---

# Current Scope

The current implementation is a **Java + JDBC + MySQL console-based backend system**.

The project currently focuses on:

* Object-oriented Java
* JDBC architecture
* DAO pattern
* Service-layer business logic
* Relational database design
* Transaction management
* Concurrency control
* Idempotent payment processing
* Rule-based risk assessment
* Transaction reporting

---

# Learning Outcomes

This project provided practical experience with:

* Designing a layered Java backend
* Separating business logic from persistence logic
* Implementing DAO-based database access
* Managing JDBC transactions
* Maintaining atomic database operations
* Handling concurrent database access
* Applying row-level locking
* Designing idempotent operations
* Building rule-based risk evaluation
* Generating database-backed reports
* Connecting Core Java concepts to a real application

---

## Project Status

**Day 58 → Day 60 completed**

```text
Account Management             ✓
Transaction Management         ✓
DAO Architecture               ✓
Atomic Payment Processing      ✓
Commit / Rollback              ✓
Concurrency Control            ✓
Transaction Isolation          ✓
Idempotency                    ✓
Risk Assessment                ✓
Payment Decision Flow          ✓
Transaction Reporting          ✓
```

---

## License

This project is developed for learning, experimentation, and portfolio purposes.
