
-- assignment 

USE student_DB;

-- ### Students
-- * Display all student profiles.
SELECT * FROM student_details;


-- * Display only first and last names.
SELECT first_name, last_name FROM student_details;


-- * Find students older than 20.
SELECT * FROM student_details WHERE age > 20;


-- * Find students from Computer Science.
SELECT * FROM student_details WHERE department = "Computer science";


-- * Find students whose CGPA is above 3.50.
SELECT * FROM student_details WHERE cgpa > 3.50;


-- * Show unique hometowns.
SELECT DISTINCT hometown FROM student_details;

-- * Show unique departments.
SELECT DISTINCT department FROM student_details;

-- * Sort by age ascending.
SELECT age FROM student_details ORDER BY age ASC;

-- * Sort by CGPA descending.
SELECT cgpa FROM student_details ORDER BY cgpa DESC;

-- * Sort by department then by first name.
SELECT * FROM student_details ORDER BY department ASC, first_name DESC;

-- ### LIKE
-- * Names starting with O.
SELECT * FROM student_details WHERE first_name LIKE "O%";


-- * Names ending with m.
SELECT * FROM student_details WHERE last_name LIKE "%m";


-- * Names containing "ia".
SELECT * FROM student_details WHERE first_name LIKE "%ia%";

-- * Emails ending with email.com.
SELECT * FROM student_details WHERE email LIKE "%email.com";

-- * Hometowns containing "os".
SELECT * FROM student_details WHERE hometown LIKE "%os%";

-- ### REGEXP
-- Names beginning with N.
SELECT * FROM student_details WHERE first_name REGEXP '^N';
SELECT * FROM student_details WHERE last_name REGEXP '^N';
SELECT * FROM student_details WHERE hometown REGEXP '^N';


-- Names ending with a vowel.
SELECT * FROM student_details WHERE first_name REGEXP '[aeiou]$';
SELECT * FROM student_details WHERE last_name REGEXP '[aeiou]$';
SELECT * FROM student_details WHERE hometown REGEXP '[aeiou]$';


-- Phone numbers containing standard hyphens.
SELECT * FROM student_details WHERE phone REGEXP '-';
SELECT * FROM student_details WHERE phone REGEXP '[0-9]-[0-9]';
SELECT * FROM student_details WHERE phone REGEXP '^\\+[0-9]+-[0-9]+';


-- Emails with only lowercase letters.
SELECT * FROM student_details WHERE email REGEXP '^[a-z0-9\\.@]+$';
SELECT * FROM student_details WHERE first_name REGEXP '^[a-z]+$';
SELECT * FROM student_details WHERE last_name REGEXP '^[a-z]+$';


-- Blood groups containing a minus symbol.
SELECT * FROM student_details WHERE blood_group REGEXP '-';
SELECT * FROM student_details WHERE blood_group REGEXP '-$';
SELECT * FROM student_details WHERE blood_group REGEXP '[A-Z]-';

