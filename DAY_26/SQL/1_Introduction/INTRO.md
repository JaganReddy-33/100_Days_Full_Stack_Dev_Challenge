````markdown
# 📅 Day 26 — SQL Introduction

---

# 1. What is Data?
Data is a collection of raw facts, figures, or values that have not yet been processed or organized into meaningful information.

Data can exist in many forms such as:
- Numbers
- Text
- Images
- Audio
- Videos

### Real-World Example
When a user signs up on a website, the information they enter (name, email, password, phone number, etc.) is considered data.

---

# 2. What is a Database?
A Database is an organized collection of related data that is stored electronically and can be easily accessed, managed, updated, and retrieved whenever required.

A database helps store large amounts of information efficiently while reducing duplication.

### Real-World Examples
- Amazon stores product information.
- Instagram stores user profiles and posts.
- Banks store customer accounts and transactions.
- Hospitals store patient records.
- Job portals store users and job postings.

---

# 3. What is DBMS?
DBMS (Database Management System) is software that allows users to create, store, retrieve, update, and manage databases.

It acts as an interface between the user and the database.

Instead of directly accessing stored data, users communicate with the DBMS, which performs all required operations.

### Responsibilities of a DBMS
- Store data
- Retrieve data
- Update data
- Delete data
- Manage security
- Control user access
- Backup and recovery

---

# 4. What is RDBMS?

## Definition
RDBMS (Relational Database Management System) is an advanced type of DBMS that stores data in the form of **tables** and establishes relationships between those tables using keys.

Each table consists of rows and columns.

Relationships reduce duplicate data and improve consistency.

### Features
- Stores data in tables
- Supports relationships
- Uses Primary Keys
- Uses Foreign Keys
- Supports SQL
- Reduces redundancy
- Ensures data integrity

### Examples
- MySQL
- PostgreSQL
- Oracle Database
- Microsoft SQL Server

---

# 5. Why SQL?

## Definition
SQL (Structured Query Language) is the standard language used to communicate with relational databases.

SQL allows users to create, read, update, delete, and manage data stored in databases.

### Why Do We Use SQL?
- Store data
- Retrieve data
- Update records
- Delete records
- Create tables
- Manage databases
- Generate reports

---

# 6. Features of SQL

1. Easy to Learn- SQL uses simple English-like commands.

2. Standard Language - SQL is accepted worldwide and supported by almost every relational database.

3. Fast Data Retrieval- SQL can quickly search millions of records.

4. Supports CRUD Operations
- Create
- Read
- Update
- Delete

5. Data Security- Different users can have different access permissions.

6. Data Integrity- Constraints help maintain accurate and valid data.

7. Supports Multiple Users - Many users can access the database simultaneously.

8. Portable - SQL works across different database systems with only minor syntax differences.

---

# 7. SQL vs MySQL

SQL stands for Structured Query Language. 
SQL is a language.
Used to write queries.
Cannot store data by itself.
SQL is a standard language. 


MySQL is a Relational Database Management System(RDBMS). MySQL is software that uses SQL.
Used to store and manage databases.
Stores data in tables. 
MySQL is one implementation of an RDBMS.

---

# 8. What is a Table?
A Table is a collection of related data organized into rows and columns.

Each table stores information about one specific entity.

---

# 9. What is a Row?
A Row represents one complete record in a table.

Every row contains information about one entity.

---

# 10. What is a Column?
A Column represents a single attribute of all records in a table.

Each column stores one type of information.

---

# 11. What is a Record?
A Record is another name for a row.

It contains complete information about one entity.

---

# 12. What is a Field?

## Definition
A Field is a single value stored inside a record.
A row contains multiple fields.

---

# 13. What is a Schema?
A Schema is the logical structure or blueprint of a database.

It defines:
- Tables
- Columns
- Data Types
- Constraints
- Relationships

before any data is stored.

---

# 14. What is a Primary Key?
A Primary Key is a column (or combination of columns) that uniquely identifies each record in a table.

### Characteristics
- Must be unique.
- Cannot contain NULL values.
- Only one Primary Key is allowed per table.
- Prevents duplicate records.

---

# 15. What is a Foreign Key?
A Foreign Key is a column in one table that refers to the Primary Key of another table.

It creates relationships between tables and maintains referential integrity.

---