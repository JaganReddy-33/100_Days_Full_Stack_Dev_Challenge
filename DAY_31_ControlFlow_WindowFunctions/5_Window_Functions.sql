use employee_db;


-- ROW_NUMBER() 

SELECT 
    first_name, 
    last_name, 
    salary,
    ROW_NUMBER() OVER(ORDER BY salary DESC) AS global_salary_seq
FROM employees;


SELECT 
    first_name, 
    joining_date,
    ROW_NUMBER() OVER(ORDER BY joining_date ASC) AS hire_sequence_number
FROM employees;

SELECT 
    project_name,
    budget,
    ROW_NUMBER() OVER(ORDER BY budget DESC) AS project_budget_line 
FROM projects;


SELECT
    first_name,
    age,
    ROW_NUMBER() OVER(ORDER BY age DESC) AS age_sequence
FROM employees;


SELECT 
    employee_id, 
    salary, 
    effective_date,
    ROW_NUMBER() OVER(ORDER BY effective_date ASC) AS record_sequence
FROM salary_history;



-- RANK();

SELECT 
    first_name, 
    last_name, 
    salary,
    RANK() OVER(ORDER BY salary DESC) AS company_salary_rank
FROM employees;


SELECT 
    first_name, 
    joining_date,
    RANK() OVER(ORDER BY joining_date ASC) AS tenure_rank
FROM employees;


SELECT 
    project_name, 
    budget,
    RANK() OVER(ORDER BY budget DESC) AS budget_allocation_rank
FROM projects;


SELECT 
    employee_id, 
    salary, 
    effective_date,
    RANK() OVER(ORDER BY salary DESC) AS historical_pay_rank
FROM salary_history;


SELECT 
    first_name, 
    age,
    RANK() OVER(ORDER BY age DESC) AS employee_age_rank
FROM employees;



-- DENSE_RANK();

SELECT 
    first_name, 
    last_name, 
    salary,
    DENSE_RANK() OVER(ORDER BY salary DESC) AS continuous_salary_rank
FROM employees;


SELECT 
    first_name, 
    age,
    DENSE_RANK() OVER(ORDER BY age DESC) AS continuous_age_rank
FROM employees;


SELECT 
    project_name, 
    budget,
    DENSE_RANK() OVER(ORDER BY budget DESC) AS continuous_budget_rank
FROM projects;


SELECT 
    employee_id, 
    salary, 
    effective_date,
    DENSE_RANK() OVER(ORDER BY salary DESC) AS historical_pay_step
FROM salary_history;


SELECT 
    first_name, 
    joining_date,
    DENSE_RANK() OVER(ORDER BY joining_date ASC) AS continuous_hire_bracket
FROM employees;


-- LAG() 

SELECT 
    employee_id,
    effective_date,
    salary AS current_salary,
    LAG(salary, 1) OVER(ORDER BY effective_date ASC) AS previous_recorded_salary
FROM salary_history;


SELECT 
    first_name,
    joining_date,
    salary,
    LAG(salary, 2) OVER(ORDER BY joining_date ASC) AS previous_hire_salary
FROM employees;


SELECT 
    first_name,
    age,
    LAG(age, 1) OVER(ORDER BY age ASC) AS younger_peer_age
FROM employees;



-- LEAD()

SELECT 
    first_name,
    joining_date,
    LEAD(joining_date, 1) OVER(ORDER BY joining_date ASC) AS next_hire_date
FROM employees;


SELECT 
    project_id,
    project_name,
    budget,
    LEAD(budget, 1) OVER(ORDER BY project_id ASC) AS next_project_budget
FROM projects;


SELECT 
    first_name,
    age,
    LEAD(age, 1) OVER(ORDER BY age ASC) AS next_older_age
FROM employees;



-- FIRST_VALUE()

SELECT 
    first_name,
    salary,
    FIRST_VALUE(first_name) OVER(ORDER BY salary DESC) AS top_earner_name
FROM employees;


SELECT 
    first_name,
    joining_date,
    FIRST_VALUE(joining_date) OVER(ORDER BY joining_date ASC) AS company_start_date
FROM employees;



SELECT 
    project_name,
    budget,
    FIRST_VALUE(budget) OVER(ORDER BY budget ASC) AS baseline_minimum_budget
FROM projects;



-- LAST_VALUE()

SELECT 
    first_name,
    salary,
    LAST_VALUE(first_name) OVER(ORDER BY salary DESC RANGE BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS lowest_earner_name
FROM employees;



SELECT 
    employee_id,
    effective_date,
    salary,
    LAST_VALUE(salary) OVER(ORDER BY effective_date ASC RANGE BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS absolute_latest_history_salary
FROM salary_history;



-- 6. SUM() OVER()
SELECT 
    project_id,
    project_name,
    budget,
    SUM(budget) OVER(ORDER BY project_id ASC) AS cumulative_running_budget
FROM projects;


SELECT 
    first_name,
    salary,
    SUM(salary) OVER() AS total_company_payroll
FROM employees;



-- 8. AVG() OVER()


SELECT 
    first_name,
    salary,
    AVG(salary) OVER() AS company_average_salary
FROM employees;



SELECT 
    project_name,
    budget,
    AVG(budget) OVER() AS baseline_average_budget
FROM projects;

-- 10. COUNT() OVER()
SELECT 
    first_name,
    joining_date,
    COUNT(employee_id) OVER(ORDER BY joining_date ASC) AS running_headcount_total
FROM employees;
