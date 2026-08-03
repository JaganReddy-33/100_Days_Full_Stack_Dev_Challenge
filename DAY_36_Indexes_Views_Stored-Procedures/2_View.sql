-- View  - A view is a virtual table that contains the result of a query. It does not store data physically but provides a way to simplify complex queries or restrict access to certain data.

use ecommerce_db;

CREATE VIEW all_products AS
SELECT
    product_id,
    product_name,
    category_id,
    supplier_id,
    price,
    stock_quantity
FROM products;

select * from all_products;

CREATE VIEW low_stock_products AS
SELECT
    product_id,
    product_name,
    stock_quantity
FROM products
WHERE
    stock_quantity < 10;

select * from low_stock_products;

CREATE VIEW premium_products AS
SELECT product_name, price
FROM products
WHERE
    price > 20000;

select * from premium_products;

CREATE VIEW customer_contacts AS
SELECT first_name, email, phone
FROM customers;

CREATE VIEW delivered_orders AS
SELECT
    order_id,
    customer_id,
    order_date,
    order_status
FROM orders
WHERE
    order_status = 'Delivered';

CREATE VIEW high_rated_products AS
SELECT product_name, product_rating
FROM products
WHERE
    product_rating >= 4.5;

CREATE VIEW product_category_view AS
SELECT p.product_name, c.category_name, p.price
FROM products p
JOIN categories c ON p.category_id = c.category_id;

CREATE VIEW product_supplier_view AS
SELECT p.product_name, s.supplier_id, p.price
FROM products p
    JOIN suppliers s ON p.supplier_id = s.supplier_id;

CREATE VIEW customer_orders_view AS
SELECT c.first_name, o.order_id, o.order_date, o.order_status
FROM customers c
    JOIN orders o ON c.customer_id = o.customer_id;

CREATE VIEW sales_report AS
SELECT o.order_id, c.first_name, p.product_name, oi.quantity, oi.unit_price
FROM
    orders o
    JOIN customers c ON o.customer_id = c.customer_id
    JOIN order_items oi ON o.order_id = oi.order_id
    JOIN products p ON oi.product_id = p.product_id;

-- Query Views
SELECT * FROM low_stock_products;

SELECT * FROM sales_report;

-- Show Views
SHOW FULL TABLES WHERE Table_type = 'VIEW';

SHOW CREATE VIEW sales_report;

-- Delete Example
DROP VIEW premium_products;

show FULL TABLES WHERE Table_type = 'VIEW';