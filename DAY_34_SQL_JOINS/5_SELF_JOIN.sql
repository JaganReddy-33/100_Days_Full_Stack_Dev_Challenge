

-- SELF JOIN - join a table with itself.

USE product_db;

CREATE TABLE employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(100) NOT NULL,
    manager_id INT,
    department VARCHAR(50),
    salary DECIMAL(10,2)
);

INSERT INTO employee VALUES
(101,'John',NULL,'Management',120000),
(102,'Alice',101,'IT',85000),
(103,'Bob',101,'HR',75000),
(104,'David',102,'IT',65000),
(105,'Emma',102,'IT',70000),
(106,'Sophia',103,'HR',60000),
(107,'Michael',103,'HR',68000),
(108,'James',104,'IT',55000),
(109,'Olivia',104,'IT',52000),
(110,'William',105,'IT',58000);

SELECT * FROM employee;


-- 1. Display every employee with their manager.
SELECT
    e.employee_name AS Employee,
    m.employee_name AS Manager
FROM employee e
LEFT JOIN employee m
ON e.manager_id = m.employee_id;



-- 2. Display employees who do not have a manager.
SELECT
    employee_name
FROM employee
WHERE manager_id IS NULL;



-- 3. Display managers with the employees they manage.
SELECT
    m.employee_name AS Manager,
    e.employee_name AS Employee
FROM employee e
JOIN employee m
ON e.manager_id = m.employee_id
ORDER BY Manager;



-- 4. Count the number of employees under each manager.
SELECT
    m.employee_name AS Manager,
    COUNT(e.employee_id) AS Total_Employees
FROM employee e
JOIN employee m
ON e.manager_id = m.employee_id
GROUP BY m.employee_name
ORDER BY Total_Employees DESC;



-- 5. Display managers who manage more than one employee.
SELECT
    m.employee_name AS Manager,
    COUNT(e.employee_id) AS Total_Employees
FROM employee e
JOIN employee m
ON e.manager_id = m.employee_id
GROUP BY m.employee_name
HAVING COUNT(e.employee_id) > 1;



-- 6. Display employee salary and manager salary.
SELECT
    e.employee_name,
    e.salary AS Employee_Salary,
    m.employee_name AS Manager,
    m.salary AS Manager_Salary
FROM employee e
JOIN employee m
ON e.manager_id = m.employee_id;



-- 7. Find employees earning more than their manager.
SELECT
    e.employee_name,
    e.salary,
    m.employee_name AS Manager,
    m.salary AS Manager_Salary
FROM employee e
JOIN employee m
ON e.manager_id = m.employee_id
WHERE e.salary > m.salary;



-- 8. Display employee department and manager department.
SELECT
    e.employee_name,
    e.department AS Employee_Department,
    m.employee_name AS Manager,
    m.department AS Manager_Department
FROM employee e
JOIN employee m
ON e.manager_id = m.employee_id;



-- 9. Display employee ID, employee name, manager ID, and manager name.
SELECT
    e.employee_id,
    e.employee_name,
    m.employee_id AS Manager_ID,
    m.employee_name AS Manager_Name
FROM employee e
LEFT JOIN employee m
ON e.manager_id = m.employee_id;



-- 10. Display employees working under manager 'Alice'.
SELECT
    e.employee_name,
    m.employee_name AS Manager
FROM employee e
JOIN employee m
ON e.manager_id = m.employee_id
WHERE m.employee_name = 'Alice';



-- 11. Display employees working under manager 'John'.
SELECT
    e.employee_name,
    m.employee_name AS Manager
FROM employee e
JOIN employee m
ON e.manager_id = m.employee_id
WHERE m.employee_name = 'John';



-- 12. Display all managers.
SELECT DISTINCT
    m.employee_name AS Manager
FROM employee e
JOIN employee m
ON e.manager_id = m.employee_id;



-- 13. Find the highest-paid employee under each manager.
SELECT
    m.employee_name AS Manager,
    MAX(e.salary) AS Highest_Employee_Salary
FROM employee e
JOIN employee m
ON e.manager_id = m.employee_id
GROUP BY m.employee_name;



-- 14. Display employees and managers sorted by manager name.
SELECT
    e.employee_name,
    m.employee_name AS Manager
FROM employee e
LEFT JOIN employee m
ON e.manager_id = m.employee_id
ORDER BY Manager;