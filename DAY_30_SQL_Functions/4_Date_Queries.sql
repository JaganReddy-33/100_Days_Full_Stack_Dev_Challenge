
-- DATE QUERIES


-- DATEDIFF(date1, date2): Calculates the number of days between two dates (date1 - date2). A negative value is returned if date1 is earlier than date2.
SELECT e.student_id, s.admission_date, e.enrollment_date, 
       DATEDIFF(e.enrollment_date, s.admission_date) AS days_before_enrolling 
FROM enrollment e 
JOIN student_details s ON e.student_id = s.student_id;


SELECT first_name, admission_date, 
       DATEDIFF(CURDATE(), admission_date) AS days_since_admission 
FROM student_details;



-- DATE_ADD(date, INTERVAL expr unit): Adds a specific time interval (Days, Months, Years) to a date value.
SELECT first_name, admission_date, 
       DATE_ADD(admission_date, INTERVAL 1 YEAR) AS first_annual_review 
FROM student_details;

SELECT first_name, admission_date, 
       DATE_ADD(admission_date, INTERVAL -2 WEEK) AS orientation_deadline 
FROM student_details;


-- DATE_SUB(date, INTERVAL expr unit): Subtracts a specific time interval from a date value.
SELECT first_name, admission_date, 
       DATE_SUB(admission_date, INTERVAL 3 MONTH) AS docs_submission_date 
FROM student_details;

SELECT enrollment_id, enrollment_date, 
       DATE_SUB(enrollment_date, INTERVAL 10 DAY) AS billing_checkpoint 
FROM enrollment;


-- TIMESTAMPDIFF(unit, datetime1, datetime2): Calculates the time difference between two dates in a chosen unit (e.g., YEAR, MONTH, DAY, WEEK). It subtracts the second date from the third (datetime2 - datetime1).
SELECT e.enrollment_id, 
       TIMESTAMPDIFF(WEEK, s.admission_date, e.enrollment_date) AS weeks_to_enroll 
FROM enrollment e 
JOIN student_details s ON e.student_id = s.student_id;

SELECT first_name, age, 
       TIMESTAMPDIFF(MONTH, DATE_SUB(CURDATE(), INTERVAL age YEAR), CURDATE()) AS rough_age_in_months 
FROM student_details;
