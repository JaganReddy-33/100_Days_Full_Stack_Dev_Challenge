

USE ecommerce_db;

SELECT * FROM products WHERE price > (SELECT AVG(price) FROM products);

SELECT * FROM products WHERE product_rating = (SELECT MAX(product_rating) FROM products);

SELECT * FROM orders WHERE total_amount < (SELECT AVG(total_amount) FROM orders);

SELECT * FROM suppliers WHERE country = (SELECT country FROM suppliers WHERE company_name = 'Bajaj Electricals Ltd');

SELECT * FROM products WHERE release_date > (SELECT release_date FROM products WHERE product_name = 'Redmi Note 13 Pro');

SELECT first_name, last_name, email FROM customers WHERE customer_id = (SELECT customer_id FROM orders WHERE total_amount = (SELECT MAX(total_amount) FROM orders) LIMIT 1);

SELECT * FROM products WHERE category_id IN (SELECT category_id FROM categories WHERE category_name LIKE '%Wear%' OR description LIKE '%Wear%' OR category_name LIKE '%Fashion%' OR description LIKE '%Fashion%');

SELECT * FROM suppliers WHERE supplier_id IN (SELECT DISTINCT supplier_id FROM products WHERE stock_quantity = 0);

SELECT * FROM customers WHERE customer_id NOT IN (SELECT DISTINCT customer_id FROM orders);

SELECT * FROM products WHERE price > ALL (SELECT price FROM products WHERE category_id = 3);

SELECT * FROM orders WHERE order_id IN (SELECT DISTINCT order_id FROM order_items WHERE product_id = (SELECT product_id FROM products WHERE product_name = 'OnePlus Nord CE4'));

SELECT * FROM customers WHERE city IN (SELECT DISTINCT country FROM suppliers);

SELECT * FROM products p WHERE price > (SELECT AVG(price) FROM products WHERE category_id = p.category_id);

SELECT * FROM products p WHERE stock_quantity < (SELECT AVG(stock_quantity) FROM products WHERE supplier_id = p.supplier_id);

SELECT * FROM customers c WHERE EXISTS (SELECT 1 FROM orders WHERE customer_id = c.customer_id AND order_status = 'Delivered');

SELECT * FROM suppliers s WHERE NOT EXISTS (SELECT 1 FROM products WHERE supplier_id = s.supplier_id);

SELECT * FROM orders o WHERE total_amount != (SELECT SUM(quantity * unit_price) FROM order_items WHERE order_id = o.order_id);

SELECT * FROM orders o WHERE total_amount > (SELECT COALESCE(MAX(total_amount), 0) FROM orders WHERE customer_id = o.customer_id AND order_date < o.order_date);

SELECT * FROM categories c WHERE (SELECT AVG(product_rating) FROM products WHERE category_id = c.category_id) > (SELECT AVG(product_rating) FROM products);

SELECT * FROM orders o WHERE order_date = (SELECT MAX(order_date) FROM orders WHERE customer_id = o.customer_id);
