

SELECT UPPER(first_name), UPPER(last_name) FROM customers;

SELECT LOWER(email) FROM customers;

SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM customers;

SELECT CONCAT(city, ', ', state) AS location FROM customers;

SELECT product_name, LENGTH(product_name) FROM products;

SELECT company_name, LEFT(company_name, 5) FROM suppliers;

SELECT phone, RIGHT(phone, 5) FROM customers;

SELECT email, SUBSTRING(email, 1, 4) FROM customers;

SELECT REPLACE(order_status, 'Processing', 'In Progress') FROM orders;

SELECT LOWER(REPLACE(company_name, ' ', '_')) FROM suppliers;

SELECT price, ROUND(price, 0) FROM products;

SELECT price, CEIL(price) FROM products;

SELECT price, FLOOR(price) FROM products;

SELECT supplier_rating - 5.00, ABS(supplier_rating - 5.00) FROM suppliers;

SELECT ROUND(AVG(price), 2) FROM products;

SELECT ROUND(supplier_rating, 1) FROM suppliers;

SELECT order_id, YEAR(order_date) FROM orders;

SELECT order_id, MONTH(order_date) FROM orders;

SELECT order_id, DAY(order_date) FROM orders;

SELECT customer_id, DATEDIFF('2026-07-31', registration_date) FROM customers;

SELECT order_id, DATEDIFF('2025-06-01', order_date) FROM orders;

SELECT EXTRACT(YEAR_MONTH FROM order_date) FROM orders;

SELECT LAST_DAY(order_date) FROM orders;

SELECT DATE_ADD(order_date, INTERVAL 7 DAY) FROM orders;

SELECT CAST(price AS SIGNED) FROM products;

SELECT CAST(registration_date AS CHAR) FROM customers;

SELECT CONVERT(total_amount, DECIMAL(10,0)) FROM orders;

SELECT IF(stock_quantity > 0, 'In Stock', 'Out of Stock') FROM products;

SELECT IF(supplier_rating >= 4.5, 'Elite', 'Standard') FROM suppliers;

SELECT order_id, IF(order_status = 'Delivered', 'Closed', 'Active') FROM orders;

SELECT product_name,
       CASE 
           WHEN price < 1000 THEN 'Budget'
           WHEN price BETWEEN 1000 AND 10000 THEN 'Mid-Range'
           ELSE 'Premium'
       END AS price_tier
FROM products;

SELECT order_id,
       CASE order_status
           WHEN 'Delivered' THEN 'Success'
           WHEN 'Cancelled' THEN 'Failed'
           ELSE 'Pending Execution'
       END AS status_group
FROM orders;

SELECT company_name,
       CASE 
           WHEN supplier_rating >= 4.5 THEN 'Top Tier'
           WHEN supplier_rating >= 4.0 THEN 'Average Tier'
           ELSE 'Low Tier'
       END AS performance
FROM suppliers;

SELECT first_name,
       CASE country
           WHEN 'India' THEN 'Domestic'
           ELSE 'International'
       END AS customer_type
FROM customers;
