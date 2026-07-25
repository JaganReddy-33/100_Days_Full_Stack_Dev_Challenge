
-- REGEX Queries


USE student_DB;

SELECT * FROM student_details WHERE first_name REGEXP '^O';
SELECT * FROM student_details WHERE first_name REGEXP '^E';
SELECT * FROM student_details WHERE first_name REGEXP '^N';

SELECT * FROM student_details WHERE last_name REGEXP 's$';
SELECT * FROM student_details WHERE last_name REGEXP 'n$';
SELECT * FROM student_details WHERE last_name REGEXP 'h$';

SELECT * FROM student_details WHERE email REGEXP '@email\\.com$';
SELECT * FROM student_details WHERE email REGEXP '\\.j';
SELECT * FROM student_details WHERE email REGEXP 'smith';

SELECT * FROM student_details WHERE phone REGEXP '^\\+1';
SELECT * FROM student_details WHERE phone REGEXP '^\\+';
SELECT * FROM student_details WHERE phone REGEXP '-01';

SELECT * FROM student_details WHERE hometown REGEXP '^B';
SELECT * FROM student_details WHERE hometown REGEXP '^A';
SELECT * FROM student_details WHERE hometown REGEXP '^S';

SELECT * FROM student_details WHERE department REGEXP 'Science';
SELECT * FROM student_details WHERE department REGEXP 'Eng';
SELECT * FROM student_details WHERE department REGEXP 'Computer';

SELECT * FROM course WHERE course_name REGEXP '^I';
SELECT * FROM course WHERE course_name REGEXP '^A';
SELECT * FROM course WHERE course_name REGEXP '^M';

SELECT * FROM student_details WHERE email REGEXP 'j';
SELECT * FROM student_details WHERE email REGEXP 'w';
SELECT * FROM student_details WHERE email REGEXP 'o';

SELECT * FROM student_details WHERE first_name REGEXP '[aeiou]';
SELECT * FROM student_details WHERE last_name REGEXP '[aeiou]';
SELECT * FROM student_details WHERE hometown REGEXP '[aeiou]';

SELECT * FROM student_details WHERE last_name REGEXP '(.)\\1';
SELECT * FROM student_details WHERE first_name REGEXP '(.)\\1';
SELECT * FROM student_details WHERE hometown REGEXP '(.)\\1';

SELECT * FROM student_details WHERE first_name REGEXP '^.{4}$';
SELECT * FROM student_details WHERE last_name REGEXP '^.{5}$';
SELECT * FROM student_details WHERE hometown REGEXP '^.{6}$';

SELECT * FROM student_details WHERE first_name REGEXP '^[^aeiou]';
SELECT * FROM student_details WHERE last_name REGEXP '^[^aeiou]';
SELECT * FROM student_details WHERE hometown REGEXP '^[^aeiou]';

SELECT * FROM student_details WHERE phone REGEXP '9999$';
SELECT * FROM student_details WHERE phone REGEXP '0102$';
SELECT * FROM student_details WHERE phone REGEXP '0105$';

SELECT * FROM course WHERE course_name REGEXP '[0-9]';
SELECT * FROM student_details WHERE phone REGEXP '[0-9]';
SELECT * FROM course WHERE duration REGEXP '[0-9]';

SELECT * FROM student_details WHERE blood_group REGEXP '^[A-Z][+-]$';
SELECT * FROM student_details WHERE blood_group REGEXP '^AB';
SELECT * FROM student_details WHERE blood_group REGEXP '^O';

SELECT * FROM student_details WHERE hometown REGEXP ' ';
SELECT * FROM student_details WHERE department REGEXP ' ';
SELECT * FROM course WHERE course_name REGEXP ' ';

SELECT * FROM student_details WHERE first_name REGEXP '[aeiou]$';
SELECT * FROM student_details WHERE last_name REGEXP '[aeiou]$';
SELECT * FROM student_details WHERE hometown REGEXP '[aeiou]$';

SELECT * FROM student_details WHERE email REGEXP '\\.';
SELECT * FROM course WHERE fee REGEXP '\\.';
SELECT * FROM student_details WHERE phone REGEXP '-';

SELECT * FROM student_details WHERE department REGEXP '^[C-D]';
SELECT * FROM student_details WHERE hometown REGEXP '^[B-C]';
SELECT * FROM student_details WHERE first_name REGEXP '^[L-N]';

SELECT * FROM student_details WHERE last_name REGEXP '^[^0-9]+$';
SELECT * FROM student_details WHERE first_name REGEXP '^[^0-9]+$';
SELECT * FROM student_details WHERE hometown REGEXP '^[^0-9]+$';

