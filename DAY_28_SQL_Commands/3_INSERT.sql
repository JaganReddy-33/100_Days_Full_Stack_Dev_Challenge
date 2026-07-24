
--  INSERT Command

USE student_DB;

-- Insert into student_details
INSERT INTO student_details (student_id, first_name, last_name, age, email, phone, department, hometown, admission_date, cgpa, blood_group) VALUES
(101, 'Liam', 'Smith', 20, 'liam.smith@email.com', '+1-555-0101', 'Computer Science', 'New York', '2025-09-01', 3.85, 'A+'),
(102, 'Olivia', 'Johnson', 21, 'olivia.j@email.com', '+1-555-0102', 'Data Science', 'Boston', '2025-09-01', 3.92, 'O-'),
(103, 'Noah', 'Williams', 22, 'noah.w@email.com', '+1-555-0103', 'Electrical Eng', 'Chicago', '2024-09-01', 3.40, 'B+'),
(104, 'Emma', 'Brown', 19, 'emma.brown@email.com', '+1-555-0104', 'Computer Science', 'Austin', '2026-01-15', 3.65, 'AB+'),
(105, 'Oliver', 'Jones', 23, 'oliver.j@email.com', '+1-555-0105', 'Data Science', 'Seattle', '2024-09-01', 3.15, 'A-');




-- Insert into course
INSERT INTO course (course_id, course_name, duration, credits, fee) VALUES
(201, 'Introduction to SQL', '8 Weeks', '3', 299.99),
(202, 'Advanced Python Coding', '12 Weeks', '4', 450.00),
(203, 'Data Structures & Algorithms', '16 Weeks', '4', 599.99),
(204, 'Machine Learning Basics', '12 Weeks', '3', 499.99);



-- Insert into enrollment
INSERT INTO enrollment (enrollment_id, student_id, course_id, enrollment_date, status) VALUES
(301, 101, 201, '2025-09-05', 'Completed'),
(302, 101, 203, '2025-09-05', 'Active'),
(303, 102, 202, '2025-09-06', 'Active'),
(304, 102, 204, '2025-09-10', 'Active'),
(305, 103, 201, '2024-09-10', 'Completed'),
(306, 104, 201, '2026-01-20', 'Active'),
(307, 105, 202, '2024-09-12', 'Dropped');
