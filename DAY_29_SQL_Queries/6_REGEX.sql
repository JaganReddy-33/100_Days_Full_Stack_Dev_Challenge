
-- REGEX - Executes complex string structural validation using advanced regular expression patterns.

USE student_DB;

SELECT * FROM student_details WHERE first_name REGEXP '^[LN]';
SELECT * FROM student_details WHERE last_name REGEXP '^[JW]';
SELECT * FROM student_details WHERE hometown REGEXP '^[BC]';

SELECT * FROM student_details WHERE email REGEXP 'email\\.com$';
SELECT * FROM student_details WHERE email REGEXP 'j@email\\.com$';
SELECT * FROM student_details WHERE email REGEXP 'w@email\\.com$';

SELECT * FROM student_details WHERE phone REGEXP '[0-9]{4}$';
SELECT * FROM student_details WHERE phone REGEXP '010[1-5]$';
SELECT * FROM student_details WHERE phone REGEXP '9999$';

SELECT * FROM student_details WHERE hometown REGEXP '[aeiou]';
SELECT * FROM student_details WHERE first_name REGEXP '[aeiou]';
SELECT * FROM student_details WHERE last_name REGEXP '[aeiou]';

SELECT * FROM student_details WHERE blood_group REGEXP '[ABDFG]';
SELECT * FROM student_details WHERE blood_group REGEXP 'O-';
SELECT * FROM student_details WHERE blood_group REGEXP '\\+$';

SELECT * FROM student_details WHERE last_name REGEXP '^S|h$';
SELECT * FROM student_details WHERE first_name REGEXP '^O|a$';
SELECT * FROM student_details WHERE hometown REGEXP '^N|k$';
