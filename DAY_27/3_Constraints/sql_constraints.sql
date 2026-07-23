

-- SQL CONSTRAINTS PRACTICE

-- 1. primary key (PK) - uniquely values only allowed
CREATE TABLE pk_ex(emp_id INT PRIMARY KEY, emp_name VARCHAR(30));
INSERT INTO pk_ex VALUES (101, "Jagan"), (2, "Lohith"), (103, "Sathi");
-- If I INSERT INTO pk_ex VALUES (101, "Ajay"); here the id is primary key so not allowed duplicates, so that it gives error or failed!


-- 2. Foreign key(fk) - links fields to a parent table to protect structural relationships.
CREATE TABLE fk_ex (
    dependent_id INT PRIMARY KEY,
    parent_emp_id INT,
    FOREIGN KEY (parent_emp_id) REFERENCES pk_ex(emp_id)
);
INSERT INTO fk_ex VALUES (1, 101), (2, 102);


-- NOT NULL - blocks missing or empty values from being saved into fields.
CREATE TABLE nn_ex (id INT, email VARCHAR(100) NOT NULL);
INSERT INTO nn_ex VALUES (1, 'test@test.com');
-- Fails: INSERT INTO nn_ex VALUES (2, NULL);


-- UNIQUE - guarantees values never repeat across rows while allowing NULLs.
CREATE TABLE uniq_ex (id INT, passport_no VARCHAR(20) UNIQUE);
INSERT INTO uniq_ex VALUES (1, 'Z12345'), (2, 'Y67890');
-- Fails: INSERT INTO uniq_ex VALUES (3, 'Z12345');

-- CHECK - filters input values using logic conditions before saving rows.
CREATE TABLE chk_ex (id INT, discount_rate INT CHECK (discount_rate BETWEEN 0 AND 100));
INSERT INTO chk_ex VALUES (1, 15), (2, 50);
-- Fails: INSERT INTO chk_ex VALUES (3, 150);


-- DEFAULT - applies backup field values if data inputs are missing.
CREATE TABLE df_ex (id INT, user_role VARCHAR(20) DEFAULT 'Guest');
INSERT INTO df_ex (id) VALUES (1);
INSERT INTO df_ex VALUES (2, 'Admin');

-- AUTO_INCREMENT - creates numbers step-by-step automatically for system records.
CREATE TABLE ai_ex (ticket_id INT AUTO_INCREMENT PRIMARY KEY, issue VARCHAR(50));
INSERT INTO ai_ex (issue) VALUES ('Login Crash'), ('UI Bug');