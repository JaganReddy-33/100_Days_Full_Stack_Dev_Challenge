# 📅 Day 33 – SQL GROUP BY, HAVING & Subqueries

> **100 Days of Code | SQL Learning Journey**

Day 33 was focused on writing advanced SQL queries using **GROUP BY**, **HAVING**, and different types of **Subqueries**. To practice these concepts in a realistic scenario, I designed a complete **Product Inventory Management Database** and solved all practice queries using it.

---

# 📚 Topics Covered

## 1️⃣ GROUP BY

Learned how to group rows based on one or more columns and generate summarized reports.

### Concepts Practiced

- GROUP BY
- Multiple column grouping
- Aggregate functions with GROUP BY

### Examples

- Products count by category
- Average product price by manufacturer
- Total stock by warehouse
- Supplier-wise order count

---

## 2️⃣ HAVING

Learned how to filter grouped records after aggregation.

### Concepts Practiced

- HAVING clause
- GROUP BY + HAVING
- Aggregate filtering

### Examples

- Categories having more than 3 products
- Warehouses with stock greater than a threshold
- Suppliers having multiple orders

---

## 3️⃣ Single Row Subqueries

Learned how to use subqueries that return exactly one value.

### Examples

- Products priced above average
- Products with maximum rating
- Products having minimum stock
- Most expensive product

---

## 4️⃣ Multi Row Subqueries

Learned how to work with subqueries returning multiple rows.

### Operators Used

- IN
- NOT IN
- ANY
- ALL
- EXISTS

### Examples

- Products supplied by US suppliers
- Products ordered from highly rated suppliers
- Categories matching multiple conditions

---

## 5️⃣ Correlated Subqueries

Learned how inner queries reference values from the outer query.

### Examples

- Products priced above the average price of their category
- Suppliers with orders above their own average cost
- Product-wise comparison queries

---

# 💻 Hands-on Database Project

## 📦 Product Inventory Management System

Designed and implemented a relational database consisting of:

- Supplier
- Product Details
- Inventory Orders

### Concepts Applied

- Database Design
- Primary Keys
- Foreign Keys
- One-to-Many Relationships
- GROUP BY
- HAVING
- Single Row Subqueries
- Multi Row Subqueries
- Correlated Subqueries

---

# 📝 Practice Completed

✔ GROUP BY Queries

✔ HAVING Queries

✔ Single Row Subqueries

✔ Multi Row Subqueries

✔ Correlated Subqueries

✔ Real-world Product Inventory Database

---

# 🧠 Key Learnings

- Understood the difference between WHERE and HAVING.
- Learned how GROUP BY creates summarized datasets.
- Improved problem-solving using different types of subqueries.
- Practiced writing nested SQL queries efficiently.
- Applied advanced SQL concepts on a real-world inventory management database.

---

# 📂 Folder Structure

```text
Day-33-SQL-GroupBy-Having-Subqueries/
│
├── 01_GROUP_BY.sql
├── 02_HAVING.sql
├── 03_Single_Row_Subqueries.sql
├── 04_Multi_Row_Subqueries.sql
├── 05_Correlated_Subqueries.sql
├── Product_DB.sql
└── README.md
```

---

# 🚀 Progress

- ✅ GROUP BY
- ✅ HAVING
- ✅ Single Row Subqueries
- ✅ Multi Row Subqueries
- ✅ Correlated Subqueries
- ✅ Product Inventory Database
- ✅ Practice Queries Completed

---

## 🎯 Next Goal (Day 34)

- INNER JOIN
- LEFT JOIN
- RIGHT JOIN
- SELF JOIN
- CROSS JOIN

---

### 💻 Tech Stack

- SQL
- MySQL
- Relational Databases

---

**Author:** Ragipalyam Jaganmohan Reddy

**Day 33 – SQL Journey | 100 Days of Code**