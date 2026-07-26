--  String Functions


-- 1. LENGTH(str) - Returns string length in bytes.
SELECT first_name, LENGTH(first_name) FROM student_details;

-- 2. CHAR_LENGTH(str) -  Returns string length in characters.
SELECT first_name, CHAR_LENGTH(first_name) FROM student_details;

-- 3. UPPER(str) - Converts all text to uppercase.
SELECT hometown, UPPER(hometown) FROM student_details;

-- 4. LOWER(str): Converts all text to lowercase.
SELECT course_name, LOWER(course_name) FROM course;

-- 5. CONCAT(s1, s2, ...): Joins multiple strings together without spaces.
SELECT CONCAT(first_name, last_name) FROM student_details;

--6. CONCAT_WS(separator, s1, s2, ...): Joins strings using a custom separator (e.g., space or hyphen).
SELECT CONCAT_WS(' ', first_name, last_name) FROM student_details;

-- 7. LEFT(str, len): Extracts a specific number of characters from the start (left side).
SELECT first_name, LEFT(phone, 2) AS country_code FROM student_details;

-- 8. RIGHT(str, len): Extracts a specific number of characters from the end (right side).
SELECT first_name, RIGHT(phone, 4) AS short_phone FROM student_details;

-- 9. SUBSTRING(str, start, len): Extracts a smaller string starting at a specific position.
SELECT SUBSTRING(department, 1, 10) FROM student_details;

-- 10. REPLACE(str, old, new): Finds a specific word or letter and swaps it with another. 
SELECT REPLACE(status, "Completed", "COMPLETED STAGE") FROM enrollment;
SELECT REPLACE(status, "Active", "ACTIVE STAGE") FROM enrollment;

-- 11. TRIM(str): Strips spaces from both ends of a string.
SELECT TRIM(course_name) FROM course;

-- 12. LTRIM(str): Strips spaces from the left end only.
SELECT LTRIM(course_name) FROM course;

-- 13. RTRIM(str): Strips spaces from the right end only.
SELECT RTRIM(course_name) FROM course;

-- 14. REVERSE(str): Flips the text backwards.
SELECT REVERSE(last_name) FROM student_details;

-- 15. LOCATE(substr, str): Finds the starting position of a word inside a string (returns 0 if not found).
SELECT email, LOCATE('@', email) AS at_symbol_position FROM student_details;

SELECT hometown, LOCATE('o', hometown) AS letter_o_index FROM student_details;


-- 16. INSTR(str, substr): Similar to LOCATE, searches for a substring and returns its numeric position.
SELECT course_name, INSTR(course_name, 'Data') AS word_index FROM course;
