
-- CONVERSION FUNCTIONS


-- CAST(expression AS type): Converts a value from one data type to another explicit target data type.
SELECT course_name, fee, CAST(fee AS UNSIGNED) AS whole_dollar_fee FROM course;

SELECT course_name, duration, CAST(LEFT(duration, 2) AS SIGNED) AS total_weeks FROM course;

SELECT first_name, cgpa, CAST(cgpa AS DECIMAL(3,1)) AS precise_cgpa FROM student_details;

SELECT first_name, CONCAT('STU-', CAST(student_id AS CHAR)) AS student_serial_code FROM student_details;

SELECT first_name, admission_date, CAST('2025-01-01' AS DATE) AS system_cutoff_date FROM student_details;


-- CONVERT(expression, type): Functions almost identically to CAST, but uses a comma syntax (expression, type) instead of the AS keyword. It can also change character sets.
SELECT first_name, age, CONVERT(age, DECIMAL(4,2)) AS decimal_age FROM student_details;

SELECT course_name, CONCAT(CONVERT(credits, CHAR), ' Credits') AS credit_tag FROM course;

SELECT enrollment_id, enrollment_date, CONVERT('2026-12-31', DATE) AS year_end_deadline FROM enrollment;

SELECT enrollment_id, CONCAT(CAST(DATEDIFF(CURDATE(), enrollment_date) AS CHAR), ' Days Ago') AS elapsed_time_text FROM enrollment;
