
-- Aggregative functions

USE employee_db;


SELECT COUNT(*) FROM employees WHERE department_id = 1;

SELECT ROUND(AVG(salary), 2) FROM employees WHERE department_id = 3;

SELECT MAX(salary) FROM employees;

SELECT MIN(salary) FROM employees;

SELECT SUM(salary) FROM employees WHERE experience_years >= 5;

SELECT COUNT(*) FROM employees;

SELECT COUNT(phone) FROM employees;

SELECT COUNT(DISTINCT city) FROM employees;

SELECT ROUND(AVG(age), 1) FROM employees;

SELECT MAX(experience_years) FROM employees;

SELECT MIN(age) FROM employees WHERE gender = 'Female';

SELECT SUM(salary) FROM employees WHERE city = 'New York';

SELECT COUNT(*) FROM departments;

SELECT COUNT(DISTINCT location) FROM departments;

SELECT COUNT(*) FROM projects WHERE budget > 100000.00;

SELECT SUM(budget) FROM projects;

SELECT ROUND(AVG(budget), 2) FROM projects;

SELECT MAX(budget) FROM projects;

SELECT MIN(budget) FROM projects WHERE start_date >= '2026-01-01';

SELECT COUNT(*) FROM salary_history WHERE employee_id = 103;

SELECT MAX(salary) FROM salary_history WHERE employee_id = 101;

SELECT MIN(salary) FROM salary_history;

SELECT ROUND(AVG(salary), 2) FROM salary_history;

SELECT SUM(salary) FROM salary_history WHERE effective_date >= '2022-01-01';

SELECT COUNT(DISTINCT employee_id) FROM salary_history;
