
-- LEFT OUTER JOIN - returns all records from left table matching records from  RIGHT table.

USE product_db;

-- Display all products with their order_id (if any).
SELECT p.product_name, i.order_id 
FROM product_details p
LEFT JOIN inventory_order i ON p.product_id = i.product_id;


-- Display all suppliers with their company_name and order_id.
SELECT s.supplier_id, s.company_name, i.order_id 
FROM supplier s 
LEFT JOIN inventory_order i ON s.supplier_id = i.supplier_id;


-- Find products that have never been ordered.
SELECT p.product_name 
FROM product_details p
LEFT JOIN inventory_order i ON p.product_id = i.product_id
WHERE i.order_id IS NULL;


-- Find suppliers that have never supplied any product.
SELECT s.contact_name, s.supplier_id 
FROM supplier s 
LEFT JOIN inventory_order i ON s.supplier_id = i.supplier_id
WHERE i.order_id IS NULL;


-- Display product name, order_id, and fulfillment_status for all products.
SELECT p.product_name, i.order_id, i.fulfillment_status
FROM product_details p 
LEFT JOIN inventory_order i ON p.product_id = i.product_id;


-- Display all products with their supplier name (show NULL where no supplier exists).
SELECT p.product_name, s.contact_name
FROM product_details p   
LEFT JOIN inventory_order i ON p.product_id = i.product_id
LEFT JOIN supplier s ON s.supplier_id = i.supplier_id;


-- Count how many orders each product has (include products with zero orders).
SELECT 
    p.product_name, 
    COUNT(i.order_id) AS total_orders
FROM product_details p
LEFT JOIN inventory_order i ON p.product_id = i.product_id
GROUP BY p.product_name
ORDER BY total_orders DESC;



-- Display warehouse_location, product_name, and order_id for every product.
SELECT 
    p.warehouse_location, 
    p.product_name, 
    i.order_id
FROM product_details p
LEFT JOIN inventory_order i ON p.product_id = i.product_id;
