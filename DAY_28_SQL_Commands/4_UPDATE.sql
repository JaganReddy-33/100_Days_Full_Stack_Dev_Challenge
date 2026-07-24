
-- UPDATE Command

UPDATE student_details 
SET phone = '+1-555-9999', cgpa = 3.90 
WHERE student_id = 101;


UPDATE course 
SET fee = 475.00 
WHERE course_id = 202;


UPDATE enrollment 
SET status = 'Completed' 
WHERE student_id = 102 AND course_id = 202;
