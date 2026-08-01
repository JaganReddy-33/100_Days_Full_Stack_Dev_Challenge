

USE ecommerce_db;

SELECT c.customer_id, c.first_name, c.last_name, SUM(o.total_amount) AS customer_lifetime_value FROM orders o INNER JOIN customers c ON o.customer_id = c.customer_id WHERE o.order_status != 'Cancelled' GROUP BY c.customer_id, c.first_name, c.last_name ORDER BY customer_lifetime_value DESC LIMIT 5;

SELECT cat.category_name, SUM(oi.quantity * oi.unit_price) AS global_sales_volume FROM order_items oi INNER JOIN products p ON oi.product_id = p.product_id INNER JOIN categories cat ON p.category_id = cat.category_id INNER JOIN orders o ON oi.order_id = o.order_id WHERE o.order_status = 'Delivered' GROUP BY cat.category_name ORDER BY global_sales_volume DESC;

SELECT s.company_name, SUM(oi.quantity * oi.unit_price) AS pipeline_fulfilled_revenue FROM order_items oi INNER JOIN products p ON oi.product_id = p.product_id INNER JOIN suppliers s ON p.supplier_id = s.supplier_id INNER JOIN orders o ON oi.order_id = o.order_id WHERE o.order_status != 'Cancelled' GROUP BY s.company_name ORDER BY pipeline_fulfilled_revenue DESC;

SELECT p.product_name, SUM(oi.quantity) AS units_moved_count FROM order_items oi INNER JOIN products p ON oi.product_id = p.product_id INNER JOIN orders o ON oi.order_id = o.order_id WHERE o.order_status = 'Delivered' GROUP BY p.product_id, p.product_name ORDER BY units_moved_count DESC LIMIT 5;

SELECT p.product_id, p.product_name, p.price FROM products p LEFT JOIN order_items oi ON p.product_id = oi.product_id WHERE oi.order_item_id IS NULL;

SELECT c.customer_id, c.first_name, c.last_name, c.email FROM customers c LEFT JOIN orders o ON c.customer_id = o.customer_id WHERE o.order_id IS NULL;

SELECT DATE_FORMAT(order_date, '%Y-%m') AS sales_month, COUNT(order_id) AS total_orders, SUM(total_amount) AS monthly_gross_revenue FROM orders WHERE order_status != 'Cancelled' GROUP BY DATE_FORMAT(order_date, '%Y-%m') ORDER BY sales_month ASC;

SELECT o.order_id, c.first_name, c.last_name, o.total_amount, o.order_status FROM orders o INNER JOIN customers c ON o.customer_id = c.customer_id ORDER BY o.total_amount DESC LIMIT 5;

SELECT p.product_name, p.stock_quantity, s.company_name, s.phone FROM products p INNER JOIN suppliers s ON p.supplier_id = s.supplier_id WHERE p.stock_quantity <= 15 ORDER BY p.stock_quantity ASC;

SELECT cat.category_name, COUNT(DISTINCT oi.order_id) AS processing_frequency, SUM(oi.quantity) AS physical_units_sold FROM order_items oi INNER JOIN products p ON oi.product_id = p.product_id INNER JOIN categories cat ON p.category_id = cat.category_id GROUP BY cat.category_name;

SELECT s.company_name, s.supplier_rating, AVG(p.product_rating) AS average_catalog_rating, COUNT(p.product_id) AS total_items_provided FROM suppliers s LEFT JOIN products p ON s.supplier_id = p.supplier_id GROUP BY s.supplier_id, s.company_name, s.supplier_rating;

SELECT COUNT(DISTINCT customer_id) AS active_purchasers, COUNT(order_id) AS cumulative_transactions, SUM(total_amount) AS overall_gross_turnover, AVG(total_amount) AS platform_basket_mean FROM orders WHERE order_status = 'Delivered';

SELECT c.state, COUNT(o.order_id) AS state_order_count, SUM(o.total_amount) AS state_revenue FROM orders o INNER JOIN customers c ON o.customer_id = c.customer_id WHERE o.order_status != 'Cancelled' GROUP BY c.state ORDER BY state_revenue DESC;

SELECT payment_method, COUNT(order_id) AS billing_frequency, SUM(total_amount) AS transaction_gross_value FROM orders GROUP BY payment_method ORDER BY billing_frequency DESC;

SELECT o.order_status, COUNT(o.order_id) AS status_count, SUM(o.total_amount) AS locked_equity_valuation FROM orders GROUP BY o.order_status;

SELECT c.city, COUNT(DISTINCT o.order_id) AS completed_orders, SUM(o.total_amount) AS urban_gross_revenue FROM orders o INNER JOIN customers c ON o.customer_id = c.customer_id WHERE o.order_status = 'Delivered' GROUP BY c.city ORDER BY urban_gross_revenue DESC;

SELECT p.product_name, p.product_rating, p.stock_quantity FROM products p WHERE p.product_rating >= 4.50 AND p.stock_quantity > 0 ORDER BY p.product_rating DESC;

SELECT p.product_name, s.company_name, p.price FROM products p INNER JOIN suppliers s ON p.supplier_id = s.supplier_id WHERE p.price > 10000.00 ORDER BY p.price DESC;

SELECT c.customer_id, c.first_name, c.last_name, COUNT(o.order_id) AS total_orders_placed FROM orders o INNER JOIN customers c ON o.customer_id = c.customer_id GROUP BY c.customer_id, c.first_name, c.last_name HAVING COUNT(o.order_id) > 1 ORDER BY total_orders_placed DESC;

SELECT p.product_name, cat.category_name, p.stock_quantity FROM products p INNER JOIN categories cat ON p.category_id = cat.category_id WHERE p.stock_quantity = 0;

SELECT s.country, COUNT(s.supplier_id) AS total_vendors FROM suppliers s GROUP BY s.country;

SELECT o.order_id, COUNT(oi.order_item_id) AS unique_line_items, SUM(oi.quantity) AS total_pieces_shipped FROM order_items oi GROUP BY o.order_id ORDER BY unique_line_items DESC LIMIT 5;
