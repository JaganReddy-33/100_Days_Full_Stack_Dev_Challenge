
CREATE DATABASE IF NOT EXISTS Employee_DB;
USE Employee_DB;


CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(50) UNIQUE,
    location VARCHAR(50)
);


INSERT INTO departments (department_id, department_name, location) VALUES
(1, 'Human Resources', 'New York'),
(2, 'Engineering', 'San Francisco'),
(3, 'Marketing', 'Chicago'),
(4, 'Finance', 'Boston'),
(5, 'Sales', 'Austin');



CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender VARCHAR(10),
    age INT,
    email VARCHAR(60) UNIQUE,
    phone VARCHAR(15) UNIQUE,
    department_id INT,
    salary DECIMAL(10, 2),
    joining_date DATE,
    city VARCHAR(50),
    experience_years INT,
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);



INSERT INTO employees (employee_id, first_name, last_name, gender, age, email, phone, department_id, salary, joining_date, city, experience_years) VALUES
(101, 'John', 'Doe', 'Male', 30, 'john.doe@email.com', '555-0101', 2, 85000.00, '2022-01-15', 'San Francisco', 5),
(102, 'Jane', 'Smith', 'Female', 28, 'jane.smith@email.com', '555-0102', 1, 65000.00, '2023-03-10', 'New York', 3),
(103, 'Michael', 'Brown', 'Male', 45, 'michael.b@email.com', '555-0103', 4, 120000.00, '2018-06-01', 'Boston', 15),
(104, 'Emily', 'Davis', 'Female', 32, 'emily.d@email.com', '555-0104', 3, 75000.00, '2021-11-20', 'Chicago', 7),
(105, 'David', 'Wilson', 'Male', 24, 'david.w@email.com', '555-0105', 5, 55000.00, '2025-02-01', 'Austin', 1);



CREATE TABLE projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(100),
    employee_id INT,
    start_date DATE,
    end_date DATE,
    budget DECIMAL(12, 2),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);


INSERT INTO projects (project_id, project_name, employee_id, start_date, end_date, budget) VALUES
(501, 'Cloud Migration', 101, '2025-01-10', '2026-06-30', 250000.00),
(502, 'HR Portal Upgrade', 102, '2025-03-01', '2025-09-01', 50000.00),
(503, 'Q3 Marketing Campaign', 104, '2026-06-01', '2026-09-30', 75000.00),
(504, 'Annual Audit 2026', 103, '2026-01-05', '2026-04-15', 30000.00),
(505, 'Midwest Expansion', 105, '2025-08-15', '2026-02-15', 120000.00);




CREATE TABLE salary_history (
    history_id INT PRIMARY KEY,
    employee_id INT,
    salary DECIMAL(10, 2),
    effective_date DATE,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);



INSERT INTO salary_history (history_id, employee_id, salary, effective_date) VALUES
(1001, 101, 80000.00, '2022-01-15'),
(1002, 101, 85000.00, '2024-01-15'),
(1003, 102, 65000.00, '2023-03-10'),
(1004, 103, 110000.00, '2018-06-01'),
(1005, 103, 120000.00, '2022-06-01');
