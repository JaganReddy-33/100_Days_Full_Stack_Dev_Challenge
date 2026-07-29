
-- Correlated subquery - it is a subquery that depends on the outer query!


USE product_db;

SELECT * FROM product_details p
WHERE price > 
(
    SELECT AVG(price) 
    FROM product_details 
    WHERE category = p.category
);

SELECT * FROM supplier s
WHERE reliability_rating > 
(
    SELECT AVG(reliability_rating) 
    FROM supplier 
    WHERE country = s.country
);

SELECT * FROM product_details p
WHERE stock_quantity < 
(
    SELECT MIN(quantity_ordered) 
    FROM inventory_order io 
    WHERE io.product_id = p.product_id
);

SELECT * FROM inventory_order io
WHERE unit_cost < 
(
    SELECT price 
    FROM product_details p 
    WHERE p.product_id = io.product_id
);

SELECT * FROM product_details p
WHERE release_date = 
(
    SELECT MAX(release_date) 
    FROM product_details 
    WHERE warehouse_location = p.warehouse_location
);

SELECT * FROM inventory_order io
WHERE quantity_ordered > 
(
    SELECT AVG(quantity_ordered) 
    FROM inventory_order 
    WHERE supplier_id = io.supplier_id
);

SELECT * FROM supplier s
WHERE EXISTS 
(
    SELECT 1 
    FROM inventory_order io 
    WHERE io.supplier_id = s.supplier_id 
    AND io.quantity_ordered > 50
);

SELECT * FROM product_details p
WHERE NOT EXISTS 
(
    SELECT 1 
    FROM inventory_order io 
    WHERE io.product_id = p.product_id
);

SELECT * FROM supplier s
WHERE reliability_rating = 
(
    SELECT MAX(reliability_rating) 
    FROM supplier 
    WHERE country = s.country
);

SELECT * FROM product_details p
WHERE customer_rating > 
(
    SELECT AVG(customer_rating) 
    FROM product_details 
    WHERE warehouse_location = p.warehouse_location
);

SELECT * FROM inventory_order io
WHERE order_date = 
(
    SELECT MIN(order_date) 
    FROM inventory_order 
    WHERE supplier_id = io.supplier_id
);

SELECT * FROM product_details p
WHERE price = 
(
    SELECT MAX(price) 
    FROM product_details 
    WHERE category = p.category
);

SELECT * FROM inventory_order io
WHERE io.fulfillment_status = 'Active' 
AND io.quantity_ordered > 
(
    SELECT stock_quantity 
    FROM product_details p 
    WHERE p.product_id = io.product_id
);

SELECT * FROM supplier s
WHERE EXISTS 
(
    SELECT 1 
    FROM inventory_order io 
    WHERE io.supplier_id = s.supplier_id 
    AND io.fulfillment_status = 'Dropped'
);

SELECT * FROM product_details p
WHERE stock_quantity > 
(
    SELECT SUM(quantity_ordered) 
    FROM inventory_order io 
    WHERE io.product_id = p.product_id
);

SELECT * FROM inventory_order io
WHERE unit_cost = 
(
    SELECT MAX(unit_cost) 
    FROM inventory_order 
    WHERE product_id = io.product_id
);

SELECT * FROM product_details p
WHERE customer_rating < 
(
    SELECT MIN(customer_rating) 
    FROM product_details 
    WHERE category = p.category
);

SELECT * FROM supplier s
WHERE reliability_rating < 
(
    SELECT AVG(reliability_rating) 
    FROM supplier
);

SELECT * FROM inventory_order io
WHERE quantity_ordered < 
(
    SELECT AVG(quantity_ordered) 
    FROM inventory_order 
    WHERE fulfillment_status = io.fulfillment_status
);

SELECT * FROM product_details p
WHERE price > 
(
    SELECT AVG(unit_cost) 
    FROM inventory_order io 
    WHERE io.product_id = p.product_id
);
