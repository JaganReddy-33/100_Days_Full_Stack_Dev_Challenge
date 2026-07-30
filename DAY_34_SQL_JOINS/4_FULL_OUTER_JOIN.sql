

-- FULL OUTER JOIN - Returns All records from the LEFT table, All records from the RIGHT table, Matching records from both tables.


USE product_db;


-- Display all products and all inventory orders.
SELECT
    p.product_id,
    p.product_name,
    i.order_id
FROM product_details p
LEFT JOIN inventory_order i
ON p.product_id = i.product_id

UNION

SELECT
    p.product_id,
    p.product_name,
    i.order_id
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id;


-- Display all suppliers and all inventory orders.
SELECT
    s.supplier_id,
    s.company_name,
    i.order_id
FROM supplier s
LEFT JOIN inventory_order i
ON s.supplier_id = i.supplier_id

UNION

SELECT
    s.supplier_id,
    s.company_name,
    i.order_id
FROM supplier s
RIGHT JOIN inventory_order i
ON s.supplier_id = i.supplier_id;


-- Display product name and order ID even if either side has no match.
SELECT
    p.product_name,
    i.order_id
FROM product_details p
LEFT JOIN inventory_order i
ON p.product_id = i.product_id

UNION

SELECT
    p.product_name,
    i.order_id
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id;


-- Display supplier company and order date including unmatched rows.
SELECT
    s.company_name,
    i.order_date
FROM supplier s
LEFT JOIN inventory_order i
ON s.supplier_id = i.supplier_id

UNION

SELECT
    s.company_name,
    i.order_date
FROM supplier s
RIGHT JOIN inventory_order i
ON s.supplier_id = i.supplier_id;


-- Display every supplier and every product (through inventory orders).
SELECT
    s.company_name,
    p.product_name
FROM supplier s
LEFT JOIN inventory_order i
ON s.supplier_id = i.supplier_id
LEFT JOIN product_details p
ON p.product_id = i.product_id

UNION

SELECT
    s.company_name,
    p.product_name
FROM supplier s
RIGHT JOIN inventory_order i
ON s.supplier_id = i.supplier_id
RIGHT JOIN product_details p
ON p.product_id = i.product_id;


-- Display product name, supplier company and order ID.
SELECT
    p.product_name,
    s.company_name,
    i.order_id
FROM product_details p
LEFT JOIN inventory_order i
ON p.product_id = i.product_id
LEFT JOIN supplier s
ON s.supplier_id = i.supplier_id

UNION

SELECT
    p.product_name,
    s.company_name,
    i.order_id
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id
RIGHT JOIN supplier s
ON s.supplier_id = i.supplier_id;


-- Display warehouse location and supplier company.
SELECT
    p.warehouse_location,
    s.company_name
FROM product_details p
LEFT JOIN inventory_order i
ON p.product_id = i.product_id
LEFT JOIN supplier s
ON s.supplier_id = i.supplier_id

UNION

SELECT
    p.warehouse_location,
    s.company_name
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id
RIGHT JOIN supplier s
ON s.supplier_id = i.supplier_id;


-- Display all products with fulfillment status.
SELECT
    p.product_name,
    i.fulfillment_status
FROM product_details p
LEFT JOIN inventory_order i
ON p.product_id = i.product_id

UNION

SELECT
    p.product_name,
    i.fulfillment_status
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id;


-- Display supplier country with ordered products.
SELECT
    s.country,
    p.product_name
FROM supplier s
LEFT JOIN inventory_order i
ON s.supplier_id = i.supplier_id
LEFT JOIN product_details p
ON p.product_id = i.product_id

UNION

SELECT
    s.country,
    p.product_name
FROM supplier s
RIGHT JOIN inventory_order i
ON s.supplier_id = i.supplier_id
RIGHT JOIN product_details p
ON p.product_id = i.product_id;


-- Display order ID, product name and quantity ordered.
SELECT
    i.order_id,
    p.product_name,
    i.quantity_ordered
FROM product_details p
LEFT JOIN inventory_order i
ON p.product_id = i.product_id

UNION

SELECT
    i.order_id,
    p.product_name,
    i.quantity_ordered
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id;