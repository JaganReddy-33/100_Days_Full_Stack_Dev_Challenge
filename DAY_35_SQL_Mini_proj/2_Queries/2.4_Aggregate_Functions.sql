

SELECT COUNT(*) FROM customers;

SELECT COUNT(customer_id) FROM customers;

SELECT COUNT(DISTINCT city) FROM customers;

SELECT COUNT(*) FROM products WHERE stock_quantity = 0;

SELECT COUNT(*) FROM orders WHERE order_status = 'Cancelled';

SELECT SUM(stock_quantity) FROM products;

SELECT SUM(total_amount) FROM orders;

SELECT SUM(total_amount) FROM orders WHERE order_status = 'Delivered';

SELECT SUM(quantity) FROM order_items;

SELECT SUM(stock_quantity) FROM products WHERE category_id = 1;

SELECT AVG(price) FROM products;

SELECT AVG(supplier_rating) FROM suppliers;

SELECT AVG(total_amount) FROM orders WHERE payment_method = 'UPI';

SELECT AVG(product_rating) FROM products WHERE category_id = 2;

SELECT AVG(stock_quantity) FROM products;

SELECT MIN(price) FROM products;

SELECT MAX(price) FROM products;

SELECT MIN(order_date) FROM orders;

SELECT MAX(supplier_rating) FROM suppliers;

SELECT MAX(total_amount) FROM orders;
