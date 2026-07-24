
-- CREATE Command

CREATE DATABASE student_DB;

USE student_DB;

CREATE TABLE student (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(15) NOT NULL,
    gender VARCHAR(10),
    age INT,
    email VARCHAR(60) UNIQUE,
    phone VARCHAR(15) UNIQUE,
    department VARCHAR(20),
    city VARCHAR(50),
    admission_date DATE
);


CREATE TABLE course (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    duration VARCHAR(20),
    credits INT,
    fee DECIMAL(10, 2)
);

CREATE TABLE enrollment (
    enrollment_id INT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    status VARCHAR(20),

    FOREIGN KEY(student_id) REFERENCES student(student_id),

    FOREIGN KEY(course_id) REFERENCES course(course_id)
);

