
-- LIMIT - Retrieve only a limited number of rows.

USE employee_db;


SELECT * FROM employees LIMIT 3;

SELECT * FROM employees ORDER BY salary DESC LIMIT 3;

SELECT * FROM employees ORDER BY age ASC LIMIT 4;

SELECT first_name FROM employees ORDER BY first_name DESC LIMIT 2;

SELECT * FROM employees ORDER BY joining_date LIMIT 5;

SELECT * FROM departments LIMIT 2;

SELECT * FROM departments ORDER BY department_name ASC LIMIT 3;

SELECT * FROM departments ORDER BY department_id DESC LIMIT 4;

SELECT location FROM departments ORDER BY location DESC LIMIT 2;

SELECT * FROM projects LIMIT 3;

SELECT * FROM projects ORDER BY budget DESC LIMIT 2;

SELECT * FROM projects ORDER BY start_date ASC LIMIT 4;

SELECT project_name FROM projects ORDER BY project_name DESC LIMIT 3;

SELECT * FROM projects ORDER BY end_date ASC LIMIT 2;

SELECT * FROM salary_history LIMIT 3;

SELECT * FROM salary_history ORDER BY salary DESC LIMIT 2;

SELECT * FROM salary_history ORDER BY effective_date ASC LIMIT 4;

SELECT salary FROM salary_history ORDER BY salary ASC LIMIT 3;

SELECT * FROM salary_history ORDER BY history_id DESC LIMIT 2;

SELECT * FROM employees WHERE gender = 'Female' ORDER BY salary DESC LIMIT 2;

SELECT * FROM employees WHERE age > 30 ORDER BY experience_years DESC LIMIT 3;

SELECT * FROM projects WHERE budget > 50000.00 ORDER BY budget ASC LIMIT 2;

SELECT * FROM salary_history WHERE employee_id = 103 ORDER BY effective_date DESC LIMIT 1;

SELECT * FROM employees ORDER BY employee_id LIMIT 2 OFFSET 2;

SELECT * FROM projects ORDER BY budget DESC LIMIT 3 OFFSET 1;
