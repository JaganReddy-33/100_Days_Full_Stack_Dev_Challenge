
-- IF()- Function

-- syntax:  IF(condition, value_if_true, value_if_false)

SELECT first_name, last_name, experience_years, IF(experience_years >= 5, "Experienced", "New") AS talent_status FROM employees;


SELECT project_name, budget, IF(budget > 50000.00, "Large Scale", "Small Scale") AS project_tier FROM projects;


SELECT first_name, joining_date, IF(joining_date < '2023-01-10', "Eligible", "Not Eligible") AS review_status FROM employees;

SELECT first_name, age, salary, IF(age >= 30, salary*0.10, salary*0.05) AS simulated_bonus FROM employees;


SELECT first_name, salary, IF(salary > 90000, "High Pay" , IF(salary >= 60000, "Medium Pay", "Low Pay")) AS salary_bracket FROM employees;

SELECT first_name, last_name, gender, IF(gender = 'Male', 'M', 'F') AS short_gender FROM employees;

SELECT project_name, start_date, end_date, IF(YEAR(start_date) = 2025, '2025 Start', 'Future Start') AS launch_group FROM projects;

SELECT first_name, email, IF(email LIKE '%@email.com', 'Standard Corporate', 'External/Other') AS email_type FROM employees;

SELECT employee_id, salary, effective_date, IF(salary >= 100000.00, salary * 0.15, salary * 0.08) AS tax_deduction FROM salary_history;

SELECT e.first_name, e.salary, d.department_name, IF(d.department_name = 'Engineering', e.salary + 5000, e.salary) AS adjusted_salary FROM employees e INNER JOIN departments d ON e.department_id = d.department_id;
