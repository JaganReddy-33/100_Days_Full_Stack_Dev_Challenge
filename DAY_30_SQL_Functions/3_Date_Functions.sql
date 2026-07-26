
-- DATE FUNCTIONS

-- CURDATE() / CURRENT_DATE(): Returns the current system date in 'YYYY-MM-DD' format.
SELECT CURDATE() AS today_date, CURRENT_DATE() AS alt_today;


-- CURTIME(): Returns the current system time in 'HH:MM:SS' format.
SELECT CURTIME() AS system_time;


-- NOW(): Returns the current date and time together in 'YYYY-MM-DD HH:MM:SS' format.
SELECT NOW() AS precise_timestamp;


-- YEAR(date): Extracts the 4-digit year from a date value.
SELECT first_name, admission_date, YEAR(admission_date) AS admission_year FROM student_details;

SELECT enrollment_id, enrollment_date, YEAR(enrollment_date) AS active_year FROM enrollment;


-- MONTH(date): Extracts the numeric month (1 to 12) from a date value.
SELECT first_name, admission_date, MONTH(admission_date) AS admission_month_num FROM student_details;

SELECT enrollment_id, enrollment_date, MONTH(enrollment_date) AS active_month FROM enrollment;


-- DAY(date) / DAYOFMONTH(date): Extracts the day number (1 to 31) from a date value.
SELECT first_name, admission_date, DAY(admission_date) AS admission_day_num FROM student_details;



-- DAYNAME(date): Returns the full name of the weekday (e.g., 'Monday', 'Friday').
SELECT first_name, admission_date, DAYNAME(admission_date) AS weekday_joined FROM student_details;

SELECT enrollment_id, enrollment_date, DAYNAME(enrollment_date) AS weekday_enrolled FROM enrollment;



-- MONTHNAME(date): Returns the full name of the month (e.g., 'January', 'September').
SELECT first_name, admission_date, MONTHNAME(admission_date) AS month_joined FROM student_details;

SELECT enrollment_id, enrollment_date, MONTHNAME(enrollment_date) AS month_enrolled FROM enrollment;

SELECT hometown, MONTHNAME(admission_date) AS native_month FROM student_details;

SELECT first_name, admission_date FROM student_details WHERE MONTHNAME(admission_date) = 'September';


SELECT enrollment_id, CONCAT(YEAR(enrollment_date), ' - ', DAYNAME(enrollment_date)) AS year_day_log FROM enrollment;
