
-- CASE statement

SELECT first_name, department_id, 
CASE department_id
    WHEN 1 THEN 'Administration'
    WHEN 2 THEN 'Technical'
    WHEN 3 THEN 'Growth'
    WHEN 4 THEN 'Operations'
    WHEN 5 THEN 'Revenue' 
    ELSE  'Unassigned Division'
END AS division_label FROM employees;

SELECT first_name, city,
CASE city
    WHEN 'New York' THEN 'EST'
    WHEN 'Boston' THEN 'EST'
    WHEN 'Chicago' THEN 'CST'
    WHEN 'Austin' THEN 'CST'
    WHEN 'San Francisco' THEN 'PST'
    ELSE 'Unknown Zone'
END AS operating_tz FROM employees;


SELECT first_name, age,
CASE 
    WHEN age < 25 THEN "Gen Z"
    WHEN age BETWEEN 25 AND 40 THEN "Millennial"
    WHEN age > 40 then "Gen X" 
    ELSE "Not Specified!"
END AS generation_tier FROM employees;


SELECT project_name, budget,
CASE 
    WHEN budget >= 200000.00 THEN "Critical Exposure"
    WHEN budget BETWEEN 75000.00 AND 199999.99 THEN "Moderate Exposure" 
    ELSE "Low Exposure"
END AS risk_classification FROM projects;

SELECT first_name, experience_years, salary,
CASE 
    WHEN experience_years >= 10 AND salary >= 100000 THEN 'High-Tier Expert'
    WHEN experience_years < 5 AND salary >= 80000 THEN 'Premium-Tier Junior'
    ELSE 'Standard Structure'
END AS comp_archetype FROM employees;


SELECT first_name, last_name, salary, 
CASE 
    WHEN salary >= 100000 THEN 'Tier 1' 
    WHEN salary BETWEEN 70000 AND 99999 THEN 'Tier 2' 
    ELSE 'Tier 3' 
END AS financial_tier FROM employees;


SELECT project_name, budget, 
CASE 
    WHEN budget > 150000 THEN budget * 0.10 
    WHEN budget BETWEEN 50000 AND 150000 THEN budget * 0.05 
    ELSE 0 
END AS contingency_fund FROM projects;


SELECT first_name, joining_date, 
CASE 
    WHEN joining_date < '2020-01-01' THEN 'Pre-2020 Vet' 
    WHEN joining_date BETWEEN '2020-01-01' AND '2023-12-31' THEN 'Mid-Era Hire' ELSE 'Recent onboarding' 
END AS tenure_class FROM employees;


SELECT e.first_name, d.location, 
CASE 
    WHEN d.location IN ('New York', 'Boston') THEN 'East Coast' 
    WHEN d.location IN ('San Francisco', 'Austin') THEN 'West/South' 
    ELSE 'Midwest' 
END AS regional_hub FROM employees e INNER JOIN departments d ON e.department_id = d.department_id;


SELECT employee_id, salary, effective_date, 
CASE 
    WHEN effective_date LIKE '2018%' THEN 'Base Pay' 
    WHEN effective_date LIKE '2022%' THEN 'Mid-Career Adjustment' 
    ELSE 'Latest Revision' 
END AS historical_marker FROM salary_history;
