
-- OFFSET - Skip rows before returning results.


SELECT * FROM employees LIMIT 3 OFFSET 3;

SELECT * FROM employees LIMIT 5 OFFSET 5;

SELECT * FROM employees ORDER BY salary DESC LIMIT 3 OFFSET 3;

SELECT * FROM employees ORDER BY employee_id LIMIT 5 OFFSET 10;

SELECT * FROM employees ORDER BY age ASC LIMIT 2 OFFSET 2;

SELECT * FROM employees ORDER BY joining_date DESC LIMIT 3 OFFSET 1;

SELECT first_name, last_name FROM employees ORDER BY first_name ASC LIMIT 2 OFFSET 3;

SELECT * FROM departments LIMIT 2 OFFSET 2;

SELECT * FROM departments ORDER BY department_name DESC LIMIT 3 OFFSET 1;

SELECT * FROM departments ORDER BY department_id ASC LIMIT 1 OFFSET 4;

SELECT location FROM departments ORDER BY location ASC LIMIT 2 OFFSET 2;

SELECT * FROM projects LIMIT 2 OFFSET 2;

SELECT * FROM projects ORDER BY budget DESC LIMIT 2 OFFSET 1;

SELECT * FROM projects ORDER BY start_date ASC LIMIT 3 OFFSET 2;

SELECT project_name FROM projects ORDER BY project_name DESC LIMIT 2 OFFSET 3;

SELECT * FROM projects ORDER BY end_date DESC LIMIT 1 OFFSET 2;

SELECT * FROM salary_history LIMIT 2 OFFSET 2;

SELECT * FROM salary_history ORDER BY salary DESC LIMIT 2 OFFSET 1;

SELECT * FROM salary_history ORDER BY effective_date ASC LIMIT 3 OFFSET 2;

SELECT salary FROM salary_history ORDER BY salary ASC LIMIT 1 OFFSET 4;

SELECT * FROM employees WHERE gender = 'Male' ORDER BY salary DESC LIMIT 2 OFFSET 1;

SELECT * FROM employees WHERE age >= 30 ORDER BY experience_years ASC LIMIT 2 OFFSET 1;

SELECT * FROM projects WHERE budget > 60000.00 ORDER BY budget DESC LIMIT 2 OFFSET 1;

SELECT * FROM salary_history WHERE employee_id = 101 ORDER BY effective_date DESC LIMIT 1 OFFSET 1;

SELECT * FROM departments WHERE location <> 'New York' ORDER BY location ASC LIMIT 2 OFFSET 1;
