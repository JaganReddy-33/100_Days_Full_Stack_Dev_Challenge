
-- assignment

SELECT 
    -- 1. Full name in uppercase
    UPPER(CONCAT_WS(' ', s.first_name, s.last_name)) AS Student_Identifier,
    
    -- 2. Extract domain after the '@' symbol
    SUBSTRING(s.email, LOCATE('@', s.email) + 1) AS Email_Provider,
    
    -- 3. Custom text code using text conversion
    CONCAT('CRSE-', CAST(c.course_id AS CHAR)) AS Course_Code,
    
    -- 4. Strip text and convert weeks to an integer data type
    CAST(LEFT(c.duration, LOCATE(' ', c.duration) - 1) AS SIGNED) AS Clean_Duration_Weeks,
    
    -- 5. Calculate weekly fee and round up to whole dollars
    CEIL(c.fee / CAST(LEFT(c.duration, LOCATE(' ', c.duration) - 1) AS SIGNED)) AS Tuition_Breakdown,
    
    -- 6. Date difference calculation
    DATEDIFF(e.enrollment_date, s.admission_date) AS Days_To_Enroll,
    
    -- 7. Add a 6-month timeline interval
    DATE_ADD(e.enrollment_date, INTERVAL 6 MONTH) AS Milestone_Date,
    
    -- 8. Random integer token generation between 1 and 100
    FLOOR(1 + (RAND() * 100)) AS Lucky_Token

FROM enrollment e
JOIN student_details s ON e.student_id = s.student_id
JOIN course c ON e.course_id = c.course_id
WHERE e.status = 'Active'
ORDER BY s.cgpa DESC;
