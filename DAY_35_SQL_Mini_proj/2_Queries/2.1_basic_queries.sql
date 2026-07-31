
SELECT * FROM customers;

SELECT * FROM categories;

SELECT * FROM suppliers;

SELECT * FROM products;

SELECT * FROM orders;

SELECT * FROM order_items;

SELECT product_name, price FROM products;

SELECT first_name, last_name, email FROM customers;

SELECT order_id, order_date, total_amount FROM orders;

SELECT company_name, supplier_rating FROM suppliers;

SELECT DISTINCT country FROM customers;

SELECT DISTINCT city FROM customers;

SELECT DISTINCT state FROM customers;

SELECT DISTINCT order_status FROM orders;

SELECT DISTINCT payment_method FROM orders;

SELECT * FROM orders WHERE order_status = 'Delivered';

SELECT * FROM customers WHERE state = 'Maharashtra';

SELECT * FROM products WHERE price > 5000.00;

SELECT * FROM products ORDER BY price DESC;

SELECT * FROM suppliers ORDER BY supplier_rating DESC;

SELECT * FROM customers ORDER BY registration_date ASC;

SELECT * FROM products LIMIT 10;

SELECT * FROM orders LIMIT 5;

SELECT * FROM customers LIMIT 5 OFFSET 5;

SELECT * FROM products LIMIT 10 OFFSET 20;

