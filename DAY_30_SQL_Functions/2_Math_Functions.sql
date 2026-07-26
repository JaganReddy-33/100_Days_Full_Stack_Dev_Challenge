
-- MATH FUNCTION


-- ABS(X): Returns the absolute (positive) value of a number by stripping its negative sign.
SELECT first_name, cgpa, ABS(cgpa - 4.0) AS points_from_perfect FROM student_details;



-- ROUND(X, D): Rounds a number to D decimal places. If D is omitted, it rounds to the nearest whole integer.
SELECT course_name, fee, ROUND(fee) AS rounded_fee FROM course;

SELECT first_name, cgpa, ROUND(cgpa, 1) AS short_cgpa FROM student_details;


-- CEIL(X): Rounds a number up to the next nearest integer, no matter the decimal value.
SELECT course_name, fee, CEIL(fee) AS ceiling_price FROM course;



-- FLOOR(X): Rounds a number down to the previous nearest integer, ignoring the decimal value.
SELECT course_name, fee, FLOOR(fee) AS floor_price FROM course;



-- MOD(N, M): Returns the remainder of N divided by M (modulo operation).
SELECT first_name, student_id, MOD(student_id, 2) AS is_odd FROM student_details;

SELECT course_name, credits, MOD(credits, 2) AS leftover_credits FROM course;


-- POWER(X, Y) / POW(X, Y): Raises X to the power of Y (\(X^{Y}\)).
SELECT course_name, credits, POWER(credits, 3) AS cubed_weight FROM course;

SELECT first_name, cgpa, POWER(cgpa, 2) AS squared_cgpa FROM student_details;


-- SQRT(X): Calculates the square root of a non-negative number.
SELECT course_name, course_id, SQRT(course_id) AS root_id FROM course;
SELECT course_name, course_id, ROUND(SQRT(course_id)) AS root_id FROM course;


-- RAND(): Generates a random decimal number between 0 (inclusive) and 1 (exclusive).
SELECT first_name, RAND() AS random_index FROM student_details;

SELECT first_name, last_name FROM student_details ORDER BY RAND();

SELECT course_name FROM course ORDER BY RAND() LIMIT 1;

SELECT first_name, FLOOR(1 + (RAND() * 100)) AS mock_score FROM student_details;

SELECT enrollment_id, FLOOR(10 + (RAND() * 41)) AS token_id FROM enrollment;
