
-- Assignment 

CREATE DATABASE IF NOT EXISTS BookStore_DB;
USE BookStore_DB;

DROP TABLE IF EXISTS order_details;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

CREATE TABLE authors (
    author_id INT PRIMARY KEY,
    author_name VARCHAR(100) NOT NULL,
    country VARCHAR(50)
);

INSERT INTO authors (author_id, author_name, country) VALUES
(1, 'J.K. Rowling', 'United Kingdom'),
(2, 'George R.R. Martin', 'United States'),
(3, 'Haruki Murakami', 'Japan'),
(4, 'Agatha Christie', 'United Kingdom'),
(5, 'Stephen King', 'United States');

CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    author_id INT,
    genre VARCHAR(50),
    price DECIMAL(8, 2),
    published_year INT,
    stock_quantity INT,
    FOREIGN KEY (author_id) REFERENCES authors(author_id)
);

INSERT INTO books (book_id, title, author_id, genre, price, published_year, stock_quantity) VALUES
(101, 'Harry Potter and the Philosophers Stone', 1, 'Fantasy', 24.99, 1997, 50),
(102, 'A Game of Thrones', 2, 'Fantasy', 29.99, 1996, 35),
(103, 'Norwegian Wood', 3, 'Fiction', 18.50, 1987, 20),
(104, 'Murder on the Orient Express', 4, 'Mystery', 14.99, 1934, 15),
(105, 'The Shining', 5, 'Horror', 19.99, 1977, 40);

CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_name VARCHAR(100),
    order_date DATE,
    total_amount DECIMAL(10, 2)
);

INSERT INTO orders (order_id, customer_name, order_date, total_amount) VALUES
(501, 'Alice Johnson', '2026-07-20', 49.98),
(502, 'Bob Smith', '2026-07-22', 14.99),
(503, 'Charlie Brown', '2026-07-25', 68.48),
(504, 'Diana Prince', '2026-07-26', 19.99),
(505, 'Evan Wright', '2026-07-28', 29.99);

CREATE TABLE order_details (
    detail_id INT PRIMARY KEY,
    order_id INT,
    book_id INT,
    quantity INT,
    price_per_unit DECIMAL(8, 2),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id)
);

INSERT INTO order_details (detail_id, order_id, book_id, quantity, price_per_unit) VALUES
(1001, 501, 101, 2, 24.99),
(1002, 502, 104, 1, 14.99),
(1003, 503, 102, 1, 29.99),
(1004, 503, 103, 1, 18.50),
(1005, 503, 105, 1, 19.99);


SELECT * FROM books WHERE price > 25.00;

SELECT * FROM books WHERE published_year < 1990;

SELECT * FROM books WHERE stock_quantity >= 40;

SELECT * FROM books WHERE published_year <= 1980;

SELECT * FROM books WHERE author_id = 1;

SELECT * FROM books WHERE genre != 'Fantasy';

SELECT * FROM authors WHERE country <> 'United Kingdom';

SELECT * FROM books WHERE price BETWEEN 15.00 AND 25.00;

SELECT * FROM books WHERE genre IN ('Fantasy', 'Mystery');

SELECT * FROM authors WHERE country NOT IN ('United States');

SELECT * FROM books LIMIT 3;

SELECT * FROM books LIMIT 2 OFFSET 2;

SELECT COUNT(*) FROM books;

SELECT SUM(stock_quantity) FROM books;

SELECT ROUND(AVG(price), 2) FROM books;

SELECT MAX(price) FROM books;

SELECT MIN(published_year) FROM books;
