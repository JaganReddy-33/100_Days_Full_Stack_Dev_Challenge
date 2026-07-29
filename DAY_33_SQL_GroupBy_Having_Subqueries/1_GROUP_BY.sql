
-- GROUP_BY - is used to group rows that have the same value in one or more columns.

USE product_db;
SHOW TABLES;
SELECT * FROM product_details;
SELECT * FROM inventory_order;
SELECT * FROM supplier;


SELECT category, COUNT(*) AS total_products FROM product_details GROUP BY category;

SELECT category, AVG(price) AS average_price FROM product_details GROUP BY category;

SELECT warehouse_location, SUM(stock_quantity) AS total_stock FROM product_details GROUP BY warehouse_location;

SELECT supplier_id, COUNT(*) AS total_order FROM inventory_order GROUP BY supplier_id; 

SELECT category, SUM(price*stock_quantity) AS total_inventory_value FROM product_details GROUP BY category;

SELECT warehouse_location, ROUND(AVG(customer_rating), 2) AS avg_rating FROM product_details GROUP BY warehouse_location;

SELECT manufacturer, MIN(release_date) AS first_release FROM product_details GROUP BY manufacturer;

SELECT category, MAX(release_date) AS latest_release FROM product_details GROUP BY category;

SELECT supplier_id, ROUND(AVG(unit_cost), 2) AS avg_unit_cost FROM inventory_order GROUP BY supplier_id;

SELECT supplier_id, MIN(quantity_ordered) AS min_quantity FROM inventory_order GROUP BY supplier_id;

SELECT supplier_id, SUM(quantity_ordered) AS total_quantity FROM inventory_order GROUP BY supplier_id;

SELECT warehouse_location, COUNT(product_id) AS total_products FROM product_details GROUP BY warehouse_location;

SELECT warehouse_location, category, COUNT(product_id) AS total_products FROM product_details GROUP BY warehouse_location, category ORDER BY warehouse_location ASC;