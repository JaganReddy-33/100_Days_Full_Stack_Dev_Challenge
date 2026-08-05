# 📅 Day 37 – Advanced SQL (Part 1: Triggers)

> **100 Days of Code | SQL Learning Journey**

Today, I focused on understanding and implementing **SQL Triggers**, one of the most powerful database automation features used in real-world applications.

---

# 🎯 Objective

Learn how triggers automatically execute SQL statements in response to database events such as **INSERT**, **UPDATE**, and **DELETE**.

---

# 📚 Topics Covered

## What are Triggers?

A Trigger is a database object that automatically executes SQL statements before or after a specified database event.

---

## Trigger Types Practiced

### BEFORE INSERT

- Auto-populate missing values
- Data validation
- Data formatting

---

### AFTER INSERT

- Update related tables
- Reduce inventory
- Recalculate order totals
- Perform post-insert operations

---

### BEFORE UPDATE

- Prevent invalid modifications
- Validate business rules
- Restrict critical updates

---

### AFTER UPDATE

- Synchronize related data
- Restore inventory
- Recalculate totals
- Track important changes

---

### BEFORE DELETE

- Prevent accidental deletion
- Protect historical records
- Validate dependencies

---

### AFTER DELETE

- Restore inventory
- Recalculate totals
- Log deleted records

---

# 📂 Project Structure

```text
Day_37/
│
├── 01_Triggers.sql
└── README.md

---

# 🧠 Concepts Learned

- BEFORE Triggers
- AFTER Triggers
- NEW Keyword
- OLD Keyword
- DELIMITER
- SIGNAL SQLSTATE
- Business Rule Validation
- Database Automation

---

# 💡 Practical Scenarios

Implemented trigger examples for:

- Order Processing
- Inventory Management
- Customer Validation
- Product Management
- Supplier Validation
- Order Status Control
- Data Integrity
- Stock Restoration

---

# 🚀 Next Progress

- Trigger Revision
- Database Normalization
  - 1NF
  - 2NF
  - 3NF
  - BCNF

---

### 💻 Tech Stack

- SQL
- MySQL

---

**Author:** Ragipalyam Jaganmohan Reddy

**Day 37 – Advanced SQL (Triggers)**