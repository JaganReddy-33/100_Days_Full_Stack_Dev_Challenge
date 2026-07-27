
-- IFNULL() Function

-- syntax: IFNULL(expression, alternative_value);


SELECT first_name, IFNULL(NULL, "No phone Listed!") AS verified_contact FROM employees;

SELECT project_name, budget, IFNULL(ROUND(budget/1, 2), 0.00) AS safe_calculation FROM projects;


SELECT d.department_name, 
IFNULL(e.first_name, 'No Staff Assigned') AS staff_name FROM departments d 
LEFT JOIN employees e ON d.department_id = e.department_id AND e.employee_id = 999;

SELECT first_name, IFNULL(NULL, 0) AS calculated_allowance FROM employees;


SELECT project_name, IFNULL(NULL, '2026-12-31') AS terminal_deadline FROM projects;


SELECT first_name, IFNULL(NULL, 'System Default Email') AS active_email FROM employees;

SELECT project_name, IFNULL(budget * NULL, 50000.00) AS default_allocation FROM projects;

SELECT d.department_name, IFNULL(e.city, 'Remote / No City') AS assignment_city FROM departments d LEFT JOIN employees e ON d.department_id = e.department_id AND e.salary > 200000;

SELECT employee_id, IFNULL(NULL, CURDATE()) AS baseline_date FROM salary_history;

SELECT first_name, IFNULL(STR_TO_DATE(NULL, '%Y-%m-%d'), joining_date) AS audit_date FROM employees;
