
-- SELECT - Retrieves specified data rows and columns from one or more database tables.

USE student_DB;

SELECT * FROM student_details;
SELECT * FROM course;
SELECT * FROM enrollment;

SELECT first_name, hometown FROM student_details;
SELECT last_name, email, phone FROM student_details;
SELECT course_name, duration, fee FROM course;

SELECT first_name AS Name, email AS Email_ID FROM student_details;
SELECT last_name AS Surname, phone AS Contact_No FROM student_details;
SELECT course_name AS Title, fee AS Base_Price FROM course;

SELECT fee * 1.10 AS Hiked_Fee FROM course;
SELECT fee * 0.90 AS Discounted_Fee FROM course;
SELECT fee + 50.00 AS Fee_With_Registration FROM course;

SELECT course_name, credits * 10 AS Total_Hours FROM course;
SELECT course_name, credits * 25.00 AS Credit_Cost FROM course;
SELECT course_name, credits + 2 AS Bonus_Credits FROM course;

SELECT first_name, age, age - 5 AS Entry_Age FROM student_details;
SELECT first_name, age, age + 4 AS Graduation_Age FROM student_details;
SELECT first_name, age, age * 365 AS Approximate_Days_Old FROM student_details;

SELECT first_name, 'Enrolled' AS Roster_Status FROM student_details;
SELECT course_name, 'Open' AS Registration_Status FROM course;
SELECT enrollment_id, 'Fall 2026' AS Academic_Term FROM enrollment;
