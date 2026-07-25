
-- DISTINCT - Eliminates duplicate rows from the output display to return unique values.


USE student_DB;

SELECT DISTINCT department FROM student_details;
SELECT DISTINCT hometown FROM student_details;
SELECT DISTINCT blood_group FROM student_details;
SELECT DISTINCT status FROM enrollment;
SELECT DISTINCT duration FROM course;
SELECT DISTINCT credits FROM course;

SELECT DISTINCT department, hometown FROM student_details;
SELECT DISTINCT hometown, blood_group FROM student_details;
SELECT DISTINCT department, age FROM student_details;
