# 📅 Day 37 – Advanced SQL (Triggers & Normalization)

> **100 Days of Code | SQL Learning Journey**

Today, I completed two essential database design concepts that play a major role in real-world applications: **SQL Triggers** and **Database Normalization**.

---

# 🎯 Objective

- Learn how SQL Triggers automate database operations.
- Understand how Normalization organizes data to reduce redundancy and improve consistency.

---

# 📚 Topics Covered

# 1️⃣ SQL Triggers

## What are Triggers?

A Trigger is a database object that automatically executes SQL statements before or after a specific database event such as **INSERT**, **UPDATE**, or **DELETE**.

### Trigger Types Practiced

### BEFORE INSERT

- Auto-populate missing values
- Data validation
- Data formatting

### AFTER INSERT

- Update related tables
- Reduce inventory
- Recalculate order totals

### BEFORE UPDATE

- Prevent invalid modifications
- Validate business rules

### AFTER UPDATE

- Synchronize related data
- Restore inventory
- Track important changes

### BEFORE DELETE

- Prevent accidental deletion
- Protect historical records

### AFTER DELETE

- Restore inventory
- Log deleted records

---

# 2️⃣ Database Normalization

## What is Normalization?

Normalization is the process of organizing database tables to eliminate redundancy and maintain data integrity.

### Normal Forms Covered

### 1NF (First Normal Form)

- Atomic values
- No repeating groups
- One value per cell

### 2NF (Second Normal Form)

- Remove Partial Dependency
- Every non-key attribute depends on the whole primary key

### 3NF (Third Normal Form)

- Remove Transitive Dependency
- Non-key attributes depend only on the primary key

### BCNF (Boyce-Codd Normal Form)

- Every determinant must be a Candidate Key

---

# 📝 Practice Completed

## SQL Triggers

- Implemented multiple business-oriented triggers using:
  - BEFORE INSERT
  - AFTER INSERT
  - BEFORE UPDATE
  - AFTER UPDATE
  - BEFORE DELETE
  - AFTER DELETE

---

## Normalization

Completed normalization practice for:

- Student Course Management System
- Hospital Management System

Practiced converting database designs through:

- 1NF
- 2NF
- 3NF
- BCNF

---

# 📂 Project Structure

```text
Day_37/
│
├── 01_Triggers.sql
├── 02_Normalization.md
└── README.md
```

---

# 🧠 Concepts Learned

## Triggers

- BEFORE Trigger
- AFTER Trigger
- NEW Keyword
- OLD Keyword
- DELIMITER
- SIGNAL SQLSTATE
- Business Rule Validation
- Database Automation

---

## Normalization

- 1NF
- 2NF
- 3NF
- BCNF
- Partial Dependency
- Transitive Dependency
- Candidate Key
- Determinant

---

# 💡 Practical Scenarios

### Triggers

- Inventory Management
- Order Processing
- Customer Validation
- Product Validation
- Supplier Validation
- Stock Restoration
- Data Integrity

### Normalization

- Eliminating redundant data
- Splitting large tables
- Improving database consistency
- Designing scalable database schemas

---

# 🚀 Next Progress

➡️ **Day 38 – React.js Journey Begins**

Topics:

- Introduction to React
- JSX
- Components
- Props
- State
- Event Handling

---

## 💻 Tech Stack

- SQL
- MySQL

---

**Author:** Ragipalyam Jaganmohan Reddy

**Day 37 – SQL Triggers & Database Normalization**