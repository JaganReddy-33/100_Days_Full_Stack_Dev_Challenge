

-- Data types practice

-- 1. Numeric types

--INT (standard whole numbers (-2 billion to 2 billion))
CREATE TABLE int_ex(id INT, score INT);
INSERT INTO int_ex VALUES (1, 95), (2, -40), (3, 0);


--BIGINT (stores very large integers)
CREATE TABLE bigInt_ex(id INT, global_id BIGINT);
INSERT INTO bigInt_ex VALUES(1, 9223372036854775807), (2, 4500100200300);


--SMALLINT (small ranges (-32,768 to 32,767)
CREATE TABLE smallInt_eX(id INT, age SMALLINT);
INSERT INTO smallInt_ex VALUES(1, 18), (2, 21), (3, 46);

-- DECIMAL(p, s) (stores exact fixed-point numbers.)
CREATE TABLE decimal_ex(id INT, weight_kg DECIMAL(10,2));
INSERT INTO decimal_ex VALUES (1, 19.99), (2, 1050.50), (3, 0.99);


-- FLOAT (stores inexact numbers)
CREATE TABLE float_ex (id INT, weight_kg FLOAT);
INSERT INTO float_ex VALUES (1, 65.45), (2, 120.01), (3, 4.50);

-- DOUBLE stores high-precision floating-point numbers
CREATE TABLE num_double_ex (id INT, gps_latitude DOUBLE);
INSERT INTO num_double_ex VALUES (1, 37.774929), (2, -122.419416);


-- 2. Character types

-- CHAR(N) - reserves fixed length space
CREATE TABLE char_ex (id INT, country_code CHAR(3));
INSERT INTO char_ex VALUES (1, 'IND'), (2, 'USA'), (3, 'CAN');

-- VARCHAR(N) - stores variable length text up to a maximum limit
CREATE TABLE varchar_ex(id INT, user_name VARCHAR(28));
INSERT INTO varchar_ex VALUES (1, "Jagan mohan"), (2, "lohith kumar"), (3, "Ajay Reddy"), (4, "Devi sree prasad");


-- TEXT - stores long-form body text like comments, descriptions, or essays
CREATE TABLE char_text_ex (id INT, product_review TEXT);
INSERT INTO char_text_ex VALUES (1, "Great product, highly recommend!"), (2, "Bad quality.");


-- 3. DATE & TIME TYPES

-- DATE (stores only calendar dates in YYYY-MM-DD format).
CREATE TABLE dt_date_ex (id INT, join_date DATE);
INSERT INTO dt_date_ex VALUES (1, '2026-01-15'), (2, '2026-07-23');

-- TIME (stores only time durations or clock times in HH:MM:SS format).
CREATE TABLE dt_time_ex (id INT, login_time TIME);
INSERT INTO dt_time_ex VALUES (1, '09:30:00'), (2, '18:15:45');

-- DATETIME (stores combined date and time independent of timezones).
CREATE TABLE dt_datetime_ex (id INT, system_log DATETIME);
INSERT INTO dt_datetime_ex VALUES (1, '2026-07-23 21:02:00'), (2, '2025-12-31 23:59:59');

-- TIMESTAMP (stores global epoch seconds, automatically converting to local timezone).
CREATE TABLE dt_timestamp_ex (id INT, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
INSERT INTO dt_timestamp_ex (id) VALUES (1), (2);


-- 4. OTHER TYPES

-- BOOLEAN (stores TRUE/FALSE or 1/0).
CREATE TABLE math_bool_ex (id INT, is_active BOOLEAN);
INSERT INTO math_bool_ex VALUES (1, TRUE), (2, FALSE), (3, 1);
