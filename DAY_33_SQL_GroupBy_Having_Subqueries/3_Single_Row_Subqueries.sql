
-- subquery - is simply a query inside another query

-- single row subqueries - A Single Row Subquery is a subquery that returns exactly one value (one row).


USE product_db;
SHOW TABLES;
SELECT * FROM product_details;
SELECT * FROM inventory_order;
SELECT * FROM supplier;

SELECT * FROM product_details
WHERE price > 
(
    SELECT AVG(price) FROM product_details
);

SELECT * FROM product_details
WHERE price = 
(
    SELECT MAX(price) FROM product_details
);

SELECT * FROM product_details
WHERE price = 
(
    SELECT MIN(price) 
    FROM product_details
);



SELECT *
FROM product_details
WHERE release_date =
(
    SELECT MAX(release_date)
    FROM product_details
);

SELECT *
FROM product_details
WHERE release_date =
(
    SELECT MAX(release_date)
    FROM product_details
);

SELECT *
FROM product_details
WHERE customer_rating = (
    SELECT MAX(customer_rating)
    FROM product_details
);


SELECT *
FROM supplier
WHERE reliability_rating > (
    SELECT AVG(reliability_rating)
    FROM supplier
);


SELECT *
FROM inventory_order
WHERE unit_cost > (
    SELECT AVG(unit_cost)
    FROM inventory_order
);


SELECT *
FROM product_details
WHERE stock_quantity < (
    SELECT AVG(stock_quantity)
    FROM product_details
);

SELECT *
FROM inventory_order
WHERE order_date = (
    SELECT MIN(order_date)
    FROM inventory_order
);

SELECT *
FROM product_details
WHERE price = (
    SELECT MAX(price)
    FROM product_details
    WHERE price < (SELECT MAX(price) FROM product_details)
);


SELECT * 
FROM product_details
WHERE stock_quantity > (
    SELECT stock_quantity 
    FROM product_details 
    WHERE product_id = 101
);

SELECT * 
FROM inventory_order
WHERE (quantity_ordered * unit_cost) = (
    SELECT MAX(quantity_ordered * unit_cost) 
    FROM inventory_order
);

SELECT * 
FROM supplier
WHERE reliability_rating = (
    SELECT MIN(reliability_rating) 
    FROM supplier 
    WHERE reliability_rating > (SELECT MIN(reliability_rating) FROM supplier)
);
