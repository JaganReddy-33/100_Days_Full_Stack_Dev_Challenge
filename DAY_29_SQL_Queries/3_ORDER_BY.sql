
-- ORDER BY - Sorts the returned query results in ascending or descending sequence.


USE student_DB;

SELECT * FROM student_details ORDER BY last_name ASC;
SELECT * FROM student_details ORDER BY first_name ASC;
SELECT * FROM student_details ORDER BY hometown ASC;

SELECT * FROM student_details ORDER BY cgpa DESC;
SELECT * FROM student_details ORDER BY age DESC;
SELECT * FROM student_details ORDER BY admission_date DESC;

SELECT * FROM student_details ORDER BY department ASC, age DESC;
SELECT * FROM student_details ORDER BY hometown DESC, cgpa ASC;
SELECT * FROM student_details ORDER BY admission_date ASC, last_name ASC;

SELECT first_name, cgpa AS Score FROM student_details ORDER BY Score DESC;
SELECT last_name, age AS Years FROM student_details ORDER BY Years ASC;
SELECT course_name, fee AS Price FROM course ORDER BY Price DESC;

SELECT * FROM course ORDER BY fee ASC;
SELECT * FROM course ORDER BY credits ASC;
SELECT * FROM course ORDER BY course_name ASC;

SELECT * FROM enrollment ORDER BY enrollment_date DESC;
SELECT * FROM enrollment ORDER BY status DESC;
SELECT * FROM enrollment ORDER BY student_id ASC;
