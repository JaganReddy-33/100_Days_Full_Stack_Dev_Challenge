````markdown
---

# 1. What is an ER Diagram?
An ER Diagram (Entity Relationship Diagram) is a graphical representation of a database that shows entities, their attributes, and the relationships between them.

It is mainly used during the database design phase before creating tables in a database.

=> Why Do We Use ER Diagrams?

- Understand database structure visually.
- Identify entities and relationships.
- Reduce data redundancy.
- Design databases before implementation.
- Convert into relational tables easily.

---

# 2. What is an Entity?
An Entity is a real-world object, person, place, event, or thing about which data is stored in a database.

Every entity becomes a table in a relational database.

### Examples
- Student
- Employee
- Customer
- Product
- Order
- Department

---

# 3. What is an Attribute?
An Attribute is a property or characteristic that describes an entity.

In a relational database, attributes become columns of a table.

---

# 4. Types of Attributes

A. Simple Attribute
An attribute that cannot be divided into smaller parts.
ex: Gender, Age, Salary

B. Composite Attribute
An attribute that can be divided into multiple sub-parts.

Example: 
Name
 ├── First Name
 ├── Middle Name
 └── Last Name


C. Single-Valued Attribute
An attribute that contains only one value for each entity.

Example: 
Student_ID
Date of Birth
Blood Group

Each student has only one Student_ID.

D. Multi-Valued Attribute
An attribute that can have multiple values for a single entity.

Ex: Phone Numbers
9876543210
9123456789
9001122334
One person can have multiple phone numbers.

E. Derived Attribute
An attribute whose value is calculated from another attribute.

It is usually not stored in the database.

F. Stored Attribute
An attribute whose value is physically stored in the database.

---

# 5. What is a Relationship?
A Relationship represents the association or connection between two or more entities.

It shows how entities are related to each other.

Ex: Student → Enrolls → Course

---

# 6. Cardinality
Cardinality defines how many instances of one entity can be associated with another entity.

=> Types of Cardinality

A. One-to-One (1:1)

One record in Entity A is related to only one record in Entity B.
 
Example: Person -------- Passport
One person has one passport.

B. One-to-Many (1:N)
One record in Entity A can be associated with many records in Entity B.

Example:  Department -------- Employees
One department has many employees.

C. Many-to-One (N:1)

Many records in Entity A are associated with one record in Entity B.

Example: Employees -------- Department
Many employees belong to one department.

D. Many-to-Many (M:N)
Many records in Entity A are associated with many records in Entity B.

Example: Students -------- Courses
One student can enroll in many courses.
One course can have many students.

---

# 7. Participation
Participation specifies whether the participation of an entity in a relationship is mandatory or optional.

### Types

A. Total Participation

Every entity must participate in the relationship.

Ex:  Employee -------- Salary
Every employee must have a salary.

B. Partial Participation - Participation is optional.

Ex: Customer -------- Coupon
Not every customer uses a coupon.


# 8. Strong Entity
A Strong Entity is an entity that has its own Primary Key and can exist independently.

### Characteristics
- Has a Primary Key.
- Does not depend on another entity.
- Exists independently.

### Examples

- Student
- Employee
- Product
- Customer

Student_ID uniquely identifies each student.

---

# 9. Weak Entity
A Weak Entity is an entity that does not have its own Primary Key.

It depends on another (strong) entity for identification.

A weak entity is identified using:

- Primary Key of the Strong Entity
- Partial Key (Discriminator)

### Characteristics
- No complete Primary Key.
- Depends on a Strong Entity.
- Cannot exist independently.

---
