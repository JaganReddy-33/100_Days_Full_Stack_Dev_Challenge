
-- HAVING is used to filter grouped data.

-- diff : 
-- WHERE- filters rows (before grouping).
-- HAVING- filters groups (after grouping).


USE product_db;
SHOW TABLES;
SELECT * FROM product_details;
SELECT * FROM inventory_order;
SELECT * FROM supplier;


SELECT category, COUNT(product_id) AS total_products FROM product_details 
GROUP BY category 
HAVING COUNT(product_id) > 2;

SELECT warehouse_location, SUM(stock_quantity) AS total_stock 
FROM product_details 
GROUP BY warehouse_location 
HAVING SUM(stock_quantity) > 200;

SELECT manufacturer, ROUND(AVG(price), 2) AS avg_price FROM product_details 
GROUP BY manufacturer 
HAVING AVG(price) > 300; 

SELECT supplier_id, COUNT(*) AS total_orders
FROM inventory_order
GROUP BY supplier_id
HAVING COUNT(*) > 3;


SELECT category, MAX(price) AS highest_price
FROM product_details
GROUP BY category
HAVING MAX(price) > 500;

SELECT supplier_id, MIN(unit_cost) AS minimum_cost
FROM inventory_order
GROUP BY supplier_id
HAVING MIN(unit_cost) < 100;

SELECT warehouse_location, AVG(customer_rating) AS average_rating
FROM product_details
GROUP BY warehouse_location
HAVING AVG(customer_rating) > 4.5;


SELECT fulfillment_status, COUNT(*) AS total_orders
FROM inventory_order
GROUP BY fulfillment_status
HAVING COUNT(*) > 5;

SELECT energy_label, ROUND(AVG(customer_rating), 2) AS average_rating
FROM product_details
GROUP BY energy_label
HAVING AVG(customer_rating) > 4.5;


SELECT category, SUM(stock_quantity) AS total_stock, AVG(price) AS average_price
FROM product_details
GROUP BY category
HAVING SUM(stock_quantity) > 300 AND AVG(price) > 150;


SELECT category, ROUND(AVG(price), 2) AS avg_price
FROM product_details
WHERE stock_quantity > 50
GROUP BY category
HAVING AVG(price) > 200;