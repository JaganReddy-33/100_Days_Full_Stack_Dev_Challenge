

USE ecommerce_db;

SELECT p.product_name, c.category_name FROM products p INNER JOIN categories c ON p.category_id = c.category_id;

SELECT p.product_name, p.price, s.company_name FROM products p INNER JOIN suppliers s ON p.supplier_id = s.supplier_id;

SELECT c.first_name, c.last_name, o.order_date, o.total_amount FROM orders o INNER JOIN customers c ON o.customer_id = c.customer_id;

SELECT oi.order_id, p.product_name, oi.quantity, oi.unit_price FROM order_items oi INNER JOIN products p ON oi.product_id = p.product_id;

SELECT p.product_name, c.category_name, s.company_name FROM products p INNER JOIN categories c ON p.category_id = c.category_id INNER JOIN suppliers s ON p.supplier_id = s.supplier_id;

SELECT oi.order_id, c.first_name, c.last_name, p.product_name, oi.quantity FROM order_items oi INNER JOIN orders o ON oi.order_id = o.order_id INNER JOIN customers c ON o.customer_id = c.customer_id INNER JOIN products p ON oi.product_id = p.product_id;

SELECT c.city, p.product_name, s.company_name FROM order_items oi INNER JOIN orders o ON oi.order_id = o.order_id INNER JOIN customers c ON o.customer_id = c.customer_id INNER JOIN products p ON oi.product_id = p.product_id INNER JOIN suppliers s ON p.supplier_id = s.supplier_id;

SELECT o.order_id, o.order_date, p.product_name, c.category_name, oi.unit_price FROM order_items oi INNER JOIN orders o ON oi.order_id = o.order_id INNER JOIN products p ON oi.product_id = p.product_id INNER JOIN categories c ON p.category_id = c.category_id;

SELECT c.category_name, p.product_name FROM categories c LEFT JOIN products p ON c.category_id = p.category_id;

SELECT s.company_name, p.product_name FROM suppliers s LEFT JOIN products p ON s.supplier_id = p.supplier_id;

SELECT c.first_name, c.last_name, c.email FROM customers c LEFT JOIN orders o ON c.customer_id = o.customer_id WHERE o.order_id IS NULL;

SELECT p.product_id, p.product_name FROM order_items oi RIGHT JOIN products p ON oi.product_id = p.product_id WHERE oi.order_item_id IS NULL;

SELECT s.company_name, p.product_name FROM suppliers s LEFT JOIN products p ON s.supplier_id = p.supplier_id UNION SELECT s.company_name, p.product_name FROM suppliers s RIGHT JOIN products p ON s.supplier_id = p.supplier_id;

SELECT c.customer_id, c.first_name, o.order_id FROM customers c LEFT JOIN orders o ON c.customer_id = o.customer_id UNION SELECT c.customer_id, c.first_name, o.order_id FROM customers c RIGHT JOIN orders o ON c.customer_id = o.customer_id;

SELECT c1.customer_id AS c1_id, c1.first_name AS c1_name, c2.customer_id AS c2_id, c2.first_name AS c2_name, c1.city FROM customers c1 INNER JOIN customers c2 ON c1.city = c2.city WHERE c1.customer_id < c2.customer_id;

SELECT s1.supplier_id AS s1_id, s1.company_name AS s1_name, s2.supplier_id AS s2_id, s2.company_name AS s2_name, s1.country, s1.supplier_rating FROM suppliers s1 INNER JOIN suppliers s2 ON s1.country = s2.country AND s1.supplier_rating = s2.supplier_rating WHERE s1.supplier_id < s2.supplier_id;

SELECT c.first_name, c.last_name, cat.category_name FROM customers c CROSS JOIN categories cat;

SELECT p.product_name, s.company_name FROM products p CROSS JOIN suppliers s;

SELECT cat.category_name, SUM(oi.quantity * oi.unit_price) AS total_revenue FROM order_items oi INNER JOIN products p ON oi.product_id = p.product_id INNER JOIN categories cat ON p.category_id = cat.category_id GROUP BY cat.category_name;

SELECT c.first_name, c.last_name, SUM(o.total_amount) AS total_spent FROM orders o INNER JOIN customers c ON o.customer_id = c.customer_id WHERE o.order_status = 'Delivered' GROUP BY c.customer_id, c.first_name, c.last_name ORDER BY total_spent DESC;

SELECT s.company_name, SUM(oi.quantity) AS total_items_sold FROM order_items oi INNER JOIN products p ON oi.product_id = p.product_id INNER JOIN suppliers s ON p.supplier_id = s.supplier_id GROUP BY s.company_name;

SELECT cat.category_name, AVG(p.product_rating) AS avg_product_rating FROM products p INNER JOIN categories cat ON p.category_id = cat.category_id GROUP BY cat.category_name ORDER BY avg_product_rating DESC;

SELECT o.payment_method, COUNT(o.order_id) AS total_orders FROM orders o INNER JOIN customers c ON o.customer_id = c.customer_id WHERE c.state = 'Maharashtra' GROUP BY o.payment_method;

SELECT p.product_name, SUM(oi.quantity * oi.unit_price) AS total_sales FROM order_items oi INNER JOIN products p ON oi.product_id = p.product_id GROUP BY p.product_id, p.product_name ORDER BY total_sales DESC LIMIT 1;

SELECT c.email, SUM(oi.quantity) AS total_items_purchased FROM order_items oi INNER JOIN orders o ON oi.order_id = o.order_id INNER JOIN customers c ON o.customer_id = c.customer_id GROUP BY o.order_id, c.email HAVING COUNT(DISTINCT oi.product_id) > 3;
