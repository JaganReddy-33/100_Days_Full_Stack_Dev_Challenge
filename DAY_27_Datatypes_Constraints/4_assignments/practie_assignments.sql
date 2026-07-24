
-- Table creation assignments

-- 1. student table
CREATE TABLE student (
    std_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    gpa DECIMAL(3, 2) CHECK(gap >= 0.00 AND gap <= 10.00)
);


-- 2. employee table
CREATE TABLE employee (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(30) NOT NULL UNIQUE,
    designation VARCHAR(50) DEFAULT "Trainee",
    salary DECIMAL(10, 2) CHECK(salary >= 25000.00)
);

-- 3. Bank account table
CREATE TABLE bank_account (
    acc_num BIGINT PRIMARY KEY,
    customer_id INT NOT NULL,
    acc_type VARCHAR(50) CHECK(acc_type IN ("savings", "Current")),
    balance DECIMAL(15, 2) DEFAULT 500.00 CHECK(balance >= 500.00)
);


-- 4. Hospital Patient table
CREATE TABLE hospital_patient (
    patient_id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    admit_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    discharge_date DATETIME CHECK(discharge_date >= admit_date)
);


-- 5. Library book table
CREATE TABLE library_book (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publication_year INT CHECK(publication_year BETWEEN 1800 AND 2026)
);


-- 6. Hotel room table
CREATE TABLE hotel_room (
    room_number INT PRIMARY KEY,
    room_type VARCHAR(20) CHECK(room_type IN ("single", "double", "suite")),
    base_price DECIMAL(8, 2) CHECK(base_price >= 0.00),
    is_occupied BOOLEAN DEFAULT FALSE
);


-- Movie database table
CREATE TABLE assignment_movie_db (
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    release_date DATE NOT NULL,
    imdb_rating DECIMAL(2,1) CHECK (imdb_rating BETWEEN 0.0 AND 10.0)
);