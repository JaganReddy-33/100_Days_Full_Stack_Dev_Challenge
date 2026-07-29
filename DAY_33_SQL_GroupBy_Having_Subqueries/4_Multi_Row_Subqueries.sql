
-- multi row subquery -  A Multi-Row Subquery is a subquery that returns more than one row (multiple values). 
-- here you must use these operators only 
-- IN, NOT IN, ANY, ALL, EXISTS.

USE product_db;

-- IN Operator - checks whether a values exists in a list.

SELECT * FROM inventory_order
WHERE supplier_id IN 
(
    SELECT supplier_id FROM supplier
    WHERE country = "United States"
);


-- NOT IN - returns whose suppliers are not from the United States.

SELECT *
FROM inventory_order
WHERE supplier_id NOT IN
(
    SELECT supplier_id
    FROM supplier
    WHERE country = 'United States'
);

-- ANY - compare with at least one value returned by the subquery

SELECT * FROM product_details
WHERE price > ANY 
(
    SELECT price FROM product_details
    WHERE category = "Electrical Component"
);

-- ALL - compare with every value returned by subquery
SELECT *
FROM product_details
WHERE price > ALL
(
    SELECT price
    FROM product_details
    WHERE category = 'Electrical Component'
);

-- exist - check whether the subquery returns any row

SELECT *
FROM supplier s
WHERE EXISTS
(
    SELECT *
    FROM inventory_order io
    WHERE io.supplier_id = s.supplier_id
);


SELECT * FROM product_details
WHERE product_id IN 
(
    SELECT DISTINCT product_id 
    FROM inventory_order 
    WHERE fulfillment_status = 'Completed'
);

SELECT * FROM supplier
WHERE supplier_id IN
(
    SELECT supplier_id 
    FROM inventory_order 
    WHERE quantity_ordered > 50
);

SELECT * FROM inventory_order
WHERE product_id NOT IN
(
    SELECT product_id 
    FROM product_details 
    WHERE warehouse_location = 'Boston'
);

SELECT * FROM product_details
WHERE product_id NOT IN
(
    SELECT DISTINCT product_id 
    FROM inventory_order
);

SELECT * FROM inventory_order
WHERE quantity_ordered > ANY
(
    SELECT stock_quantity 
    FROM product_details 
    WHERE warehouse_location = 'New York'
);

SELECT * FROM supplier
WHERE reliability_rating < ANY
(
    SELECT customer_rating 
    FROM product_details 
    WHERE category = 'Electrical Component'
);

SELECT * FROM product_details
WHERE customer_rating > ALL
(
    SELECT customer_rating 
    FROM product_details 
    WHERE warehouse_location = 'Chicago'
);

SELECT * FROM inventory_order
WHERE unit_cost < ALL
(
    SELECT price 
    FROM product_details 
    WHERE category = 'Computer Hardware'
);

SELECT * FROM product_details p
WHERE EXISTS
(
    SELECT 1 
    FROM inventory_order io 
    WHERE io.product_id = p.product_id 
    AND io.fulfillment_status = 'Active'
);

SELECT * FROM supplier s
WHERE EXISTS
(
    SELECT 1 
    FROM inventory_order io 
    JOIN product_details p ON io.product_id = p.product_id
    WHERE io.supplier_id = s.supplier_id 
    AND p.category = 'Mechanical Machinery'
);