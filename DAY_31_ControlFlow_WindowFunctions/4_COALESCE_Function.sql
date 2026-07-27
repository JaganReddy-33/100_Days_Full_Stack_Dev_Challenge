
-- COALESCE FUNCTION

-- syntax: COALESCE(value1, value2, value3, ..., valueN)
USE employee_db;

SELECT first_name, COALESCE(NULL, phone, 'No Contact Available') AS contact_priority FROM employees;

SELECT project_name, COALESCE(budget*0.10, NULL, 1500.00) AS optimal_allowance FROM projects;

SELECT e.first_name, COALESCE(NULL, e.city, 'Global HQ') AS structural_location FROM employees e;

SELECT project_name, COALESCE(end_date, start_date, '2026-01-01') AS priority_milestone FROM projects;


SELECT e.first_name, COALESCE(sh.salary, e.salary, 30000.00)  ASultimate_compensation FROM employees e 
LEFT JOIN salary_history sh ON e.employee_id = sh.employee_id AND sh.history_id = 999;


