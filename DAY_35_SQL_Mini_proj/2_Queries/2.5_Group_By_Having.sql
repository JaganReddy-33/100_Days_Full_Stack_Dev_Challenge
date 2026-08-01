

USE ecommerce_db;

SELECT city, COUNT(*) AS total_customers FROM customers GROUP BY city;

SELECT state, COUNT(*) AS total_customers FROM customers GROUP BY state; 

SELECT category_id, COUNT(DISTINCT product_id) AS total_unique_products FROM products GROUP BY category_id; 

SELECT category_id, SUM(stock_quantity) AS total_stock FROM products GROUP BY category_id;


SELECT category_id, AVG(price) AS average_price FROM products GROUP BY category_id;

SELECT supplier_id, MIN(price) AS min_price, MAX(price) AS max_price FROM products GROUP BY supplier_id;

SELECT supplier_id, AVG(product_rating) AS average_product_rating FROM products GROUP BY supplier_id;

SELECT order_status, COUNT(*) AS total_orders FROM orders GROUP BY order_status;


SELECT payment_method, SUM(total_amount) AS total_revenue FROM orders GROUP BY payment_method;


SELECT payment_method, AVG(total_amount) AS average_order_amount FROM orders GROUP BY payment_method;


SELECT order_id, SUM(quantity) AS total_items FROM order_items GROUP BY order_id;


SELECT order_id, COUNT(DISTINCT product_id) AS unique_products FROM order_items GROUP BY order_id;


SELECT product_id, SUM(quantity * unit_price) AS gross_revenue FROM order_items GROUP BY product_id; 


SELECT city, COUNT(*) AS total_customers FROM customers GROUP BY city HAVING COUNT(*) > 2; 

SELECT category_id, COUNT(DISTINCT product_id) AS total_products FROM products GROUP BY category_id HAVING COUNT(DISTINCT product_id) > 4;


SELECT category_id, AVG(price) AS average_price FROM products GROUP BY category_id HAVING AVG(price) > 2000.00;


SELECT supplier_id, SUM(stock_quantity) AS total_stock FROM products GROUP BY supplier_id HAVING SUM(stock_quantity) < 50;


SELECT supplier_id, AVG(product_rating) AS average_rating FROM products GROUP BY supplier_id HAVING AVG(product_rating) > 4.30;


SELECT supplier_id, MIN(price) AS min_price FROM products GROUP BY supplier_id HAVING MIN(price) > 1000.00;


SELECT customer_id, COUNT() AS total_orders FROM orders GROUP BY customer_id HAVING COUNT() > 2;


SELECT customer_id, SUM(total_amount) AS total_spent FROM orders GROUP BY customer_id HAVING SUM(total_amount) > 15000.00; 


SELECT payment_method, COUNT() AS total_orders FROM orders GROUP BY payment_method HAVING COUNT() > 5; 


SELECT payment_method, AVG(total_amount) AS average_amount FROM orders GROUP BY payment_method HAVING AVG(total_amount) > 4000.00; 

SELECT order_id, SUM(quantity) AS total_quantity FROM order_items GROUP BY order_id HAVING SUM(quantity) > 4;


SELECT order_id, SUM(quantity * unit_price) AS total_valuation FROM order_items GROUP BY order_id HAVING SUM(quantity * unit_price) > 25000.00;
