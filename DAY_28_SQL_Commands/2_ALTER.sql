
-- ALTER Command

ALTER TABLE student 
ADD cgpa DECIMAL(3, 2);

ALTER TABLE student 
ADD blood_group VARCHAR(5);

ALTER TABLE student 
MODIFY phone VARCHAR(20);

ALTER TABLE student
RENAME COLUMN city TO hometown;

ALTER TABLE student
DROP COLUMN gender;

ALTER TABLE student
RENAME TO student_details;

