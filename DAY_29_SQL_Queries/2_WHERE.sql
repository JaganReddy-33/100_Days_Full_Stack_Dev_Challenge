
-- WHERE - Filters records by applying conditional evaluation before returning the final rows.

USE student_DB;

SELECT * FROM student_details WHERE age <= 20;
SELECT * FROM student_details WHERE age > 21;
SELECT * FROM student_details WHERE age = 19;

SELECT * FROM student_details WHERE department = 'Computer Science';
SELECT * FROM student_details WHERE department = 'Data Science';
SELECT * FROM student_details WHERE hometown = 'New York';

SELECT * FROM student_details WHERE age >= 21 AND hometown = 'Boston';
SELECT * FROM student_details WHERE department = 'Computer Science' AND age < 22;
SELECT * FROM student_details WHERE cgpa > 3.50 AND blood_group = 'A+';

SELECT * FROM student_details WHERE department = 'Data Science' OR department = 'Computer Science';
SELECT * FROM student_details WHERE hometown = 'Chicago' OR hometown = 'Austin';
SELECT * FROM student_details WHERE age = 20 OR age = 23;

SELECT * FROM student_details WHERE blood_group IS NOT NULL;
SELECT * FROM student_details WHERE phone IS NOT NULL;
SELECT * FROM student_details WHERE email IS NOT NULL;

SELECT * FROM student_details WHERE blood_group IS NULL;
SELECT * FROM student_details WHERE phone IS NULL;
SELECT * FROM student_details WHERE email IS NULL;

SELECT * FROM course WHERE fee > 400.00;
SELECT * FROM course WHERE credits = 4;
SELECT * FROM course WHERE duration = '12 Weeks';

SELECT * FROM enrollment WHERE status != 'Completed';
SELECT * FROM enrollment WHERE status = 'Active';
SELECT * FROM enrollment WHERE enrollment_date >= '2025-01-01';
