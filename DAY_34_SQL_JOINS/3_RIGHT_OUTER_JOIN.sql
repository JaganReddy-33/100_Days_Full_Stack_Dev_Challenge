
-- RIGHT OUTER JOIN - returns all records from right table matching records from left table. 


USE product_db;

-- Display all inventory orders with their product names.
SELECT
    i.order_id,
    p.product_name
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id;


-- Display all inventory orders with their supplier company names.
SELECT
    i.order_id,
    s.company_name
FROM supplier s
RIGHT JOIN inventory_order i
ON s.supplier_id = i.supplier_id;


-- Display order ID, product name and supplier company name.
SELECT
    i.order_id,
    p.product_name,
    s.company_name
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id
RIGHT JOIN supplier s
ON s.supplier_id = i.supplier_id;


-- Display all orders with their warehouse location.
SELECT
    i.order_id,
    p.product_name,
    p.warehouse_location
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id;


-- Find inventory orders whose product details are missing.
SELECT
    i.order_id,
    i.product_id
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id
WHERE p.product_id IS NULL;


-- Find inventory orders whose supplier details are missing.
SELECT
    i.order_id,
    i.supplier_id
FROM supplier s
RIGHT JOIN inventory_order i
ON s.supplier_id = i.supplier_id
WHERE s.supplier_id IS NULL;


-- Display order date, supplier company and fulfillment status.
SELECT
    i.order_date,
    s.company_name,
    i.fulfillment_status
FROM supplier s
RIGHT JOIN inventory_order i
ON s.supplier_id = i.supplier_id;


-- Display order ID, product name, selling price and unit cost.
SELECT
    i.order_id,
    p.product_name,
    p.price AS selling_price,
    i.unit_cost
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id;


-- Calculate profit per unit for every inventory order.
SELECT
    i.order_id,
    p.product_name,
    p.price AS selling_price,
    i.unit_cost,
    (p.price - i.unit_cost) AS profit_per_unit
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id;


-- Display supplier company, country and ordered product.
SELECT
    s.company_name,
    s.country,
    p.product_name
FROM supplier s
RIGHT JOIN inventory_order i
ON s.supplier_id = i.supplier_id
RIGHT JOIN product_details p
ON p.product_id = i.product_id;


-- Count total inventory orders for each supplier.
SELECT
    s.company_name,
    COUNT(i.order_id) AS total_orders
FROM supplier s
RIGHT JOIN inventory_order i
ON s.supplier_id = i.supplier_id
GROUP BY s.company_name
ORDER BY total_orders DESC;


-- Display all inventory orders with quantity ordered and product stock.
SELECT
    i.order_id,
    p.product_name,
    i.quantity_ordered,
    p.stock_quantity
FROM product_details p
RIGHT JOIN inventory_order i
ON p.product_id = i.product_id;

