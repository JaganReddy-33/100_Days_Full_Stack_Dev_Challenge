
-- LIKE  -  Performs basic string pattern matching using simple wildcard characters (%, _).


USE student_DB;

SELECT * FROM student_details WHERE first_name LIKE 'O%';
SELECT * FROM student_details WHERE last_name LIKE 'S%';
SELECT * FROM student_details WHERE hometown LIKE 'B%';

SELECT * FROM student_details WHERE last_name LIKE '%s';
SELECT * FROM student_details WHERE first_name LIKE '%a';
SELECT * FROM student_details WHERE hometown LIKE '%k';

SELECT * FROM student_details WHERE email LIKE '%@email.com';
SELECT * FROM student_details WHERE email LIKE '%smith%';
SELECT * FROM student_details WHERE email LIKE '%.j%';

SELECT * FROM student_details WHERE first_name LIKE '____';
SELECT * FROM student_details WHERE last_name LIKE '_____';
SELECT * FROM student_details WHERE hometown LIKE '______';

SELECT * FROM course WHERE course_name LIKE '%Data%';
SELECT * FROM course WHERE course_name LIKE '%SQL%';
SELECT * FROM course WHERE course_name LIKE '%Python%';

SELECT * FROM student_details WHERE phone LIKE '+1-555-%';
SELECT * FROM student_details WHERE phone LIKE '%-0103%';
SELECT * FROM student_details WHERE phone LIKE '%9999%';

SELECT * FROM student_details WHERE first_name LIKE '_i%';
SELECT * FROM student_details WHERE last_name LIKE '__m%';
SELECT * FROM student_details WHERE hometown LIKE '_e%';
