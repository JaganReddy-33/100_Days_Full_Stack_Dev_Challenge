
-- Comparison_Operators

-- basic operators: > , < , >= , <= , = , != , <> 
-- Advance operators : BETWEEN , IN, NOT IN, IS NULL, IS NOT NULL.

USE employee_db;

SELECT * FROM employees WHERE salary > 70000.00;

SELECT * FROM employees WHERE age < 30;

SELECT * FROM employees WHERE experience_years >= 5;

SELECT * FROM employees WHERE joining_date <= '2022-12-31';

SELECT * FROM employees WHERE employee_id = 103;

SELECT * FROM employees WHERE gender != 'Male';

SELECT * FROM employees WHERE city <> 'Chicago';

SELECT * FROM departments WHERE department_id > 2;

SELECT * FROM departments WHERE department_id < 4;

SELECT * FROM departments WHERE department_id = 1;

SELECT * FROM departments WHERE location <> 'New York';

SELECT * FROM projects WHERE budget > 100000.00;

SELECT * FROM projects WHERE budget < 60000.00;

SELECT * FROM projects WHERE start_date >= '2026-01-01';

SELECT * FROM projects WHERE end_date <= '2025-12-31';

SELECT * FROM projects WHERE employee_id = 101;

SELECT * FROM projects WHERE project_id <> 503;

SELECT * FROM salary_history WHERE salary > 90000.00;

SELECT * FROM salary_history WHERE salary <= 80000.00;

SELECT * FROM salary_history WHERE effective_date >= '2020-01-01';

SELECT * FROM salary_history WHERE employee_id = 103;

SELECT * FROM salary_history WHERE history_id != 1001;

SELECT * FROM employees WHERE salary BETWEEN 60000.00 AND 90000.00;

SELECT * FROM projects WHERE budget BETWEEN 50000.00 AND 150000.00;

SELECT * FROM salary_history WHERE effective_date BETWEEN '2018-01-01' AND '2023-12-31';

SELECT * FROM employees WHERE department_id IN (2, 4);

SELECT * FROM departments WHERE location IN ('San Francisco', 'Boston', 'Austin');

SELECT * FROM projects WHERE employee_id IN (101, 104, 105);

SELECT * FROM salary_history WHERE employee_id IN (101, 102);

SELECT * FROM employees WHERE city NOT IN ('New York', 'Boston');

SELECT * FROM departments WHERE department_name NOT IN ('Human Resources', 'Marketing');

SELECT * FROM employees WHERE phone IS NULL;

SELECT * FROM projects WHERE end_date IS NULL;

SELECT * FROM employees WHERE phone IS NOT NULL;

SELECT * FROM projects WHERE end_date IS NOT NULL;

