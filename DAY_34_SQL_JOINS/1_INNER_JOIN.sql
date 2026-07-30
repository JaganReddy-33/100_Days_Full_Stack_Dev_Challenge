
-- INNER JOIN - returns only matching records from both tables.

USE product_db;


SELECT p.product_name, i.order_date 
FROM product_details p
INNER JOIN inventory_order i
ON p.product_id = i.product_id; 


SELECT p.product_name, s.company_name
FROM product_details p 
INNER JOIN inventory_order i ON p.product_id = i.product_id
INNER JOIN supplier s ON i.supplier_id = s.supplier_id;


SELECT p.product_name, i.quantity_ordered, i.unit_cost
FROM product_details p
INNER JOIN inventory_order i ON p.product_id = i.product_id;

SELECT i.order_id, p.product_name, s.company_name, s.country
FROM inventory_order i
INNER JOIN supplier s
ON i.supplier_id = s.supplier_id
INNER JOIN product_details p
ON i.product_id = p.product_id;


SELECT p.product_name, i.fulfillment_status, s.company_name
FROM product_details p 
INNER JOIN inventory_order i ON p.product_id = i.product_id
INNER JOIN supplier s ON i.supplier_id = s.supplier_id;
 

SELECT p.product_name 
FROM product_details p   
INNER JOIN inventory_order i ON p.product_id = i.product_id
INNER JOIN supplier s ON i.supplier_id = s.supplier_id WHERE s.country = "United States"; 

SELECT p.product_name, i.unit_cost
FROM product_details p
INNER JOIN inventory_order i ON p.product_id = i.product_id
WHERE i.unit_cost > 500; 


SELECT p.product_name, p.price AS selling_price, i.unit_cost AS purchase_cost, (p.price - i.unit_cost) AS profit_per_unit 
FROM product_details p
INNER JOIN inventory_order i ON p.product_id = i.product_id;