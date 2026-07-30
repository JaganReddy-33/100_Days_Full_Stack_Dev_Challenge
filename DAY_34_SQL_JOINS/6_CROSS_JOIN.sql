

-- CROSS JOIN - returns every possible combinations.


USE product_db;

SELECT * FROM product_details;
SELECT * FROM supplier;


-- 1. Display every product with every supplier.
SELECT
    p.product_name,
    s.company_name
FROM product_details p
CROSS JOIN supplier s;



-- 2. Display product name and supplier country.
SELECT
    p.product_name,
    s.country
FROM product_details p
CROSS JOIN supplier s;



-- 3. Display product name, supplier name and supplier rating.
SELECT
    p.product_name,
    s.company_name,
    s.reliability_rating
FROM product_details p
CROSS JOIN supplier s;



-- 4. Count total combinations.
SELECT COUNT(*) AS total_combinations
FROM product_details p
CROSS JOIN supplier s;



-- 5. Display only the first 20 combinations.
SELECT
    p.product_name,
    s.company_name
FROM product_details p
CROSS JOIN supplier s
LIMIT 20;



-- 6. Display all products with suppliers from the United States.
SELECT
    p.product_name,
    s.company_name,
    s.country
FROM product_details p
CROSS JOIN supplier s
WHERE s.country = 'United States';



-- 7. Display products costing more than 500 with every supplier.
SELECT
    p.product_name,
    p.price,
    s.company_name
FROM product_details p
CROSS JOIN supplier s
WHERE p.price > 500;



-- 8. Display Computer Hardware products with every supplier.
SELECT
    p.product_name,
    p.category,
    s.company_name
FROM product_details p
CROSS JOIN supplier s
WHERE p.category = 'Computer Hardware';



-- 9. Display supplier name, product name, and warehouse location.
SELECT
    s.company_name,
    p.product_name,
    p.warehouse_location
FROM supplier s
CROSS JOIN product_details p;



-- 10. Display supplier name and product name sorted by supplier.
SELECT
    s.company_name,
    p.product_name
FROM supplier s
CROSS JOIN product_details p
ORDER BY s.company_name, p.product_name;



-- 11. Display products released in 2025 with every supplier.
SELECT
    p.product_name,
    p.release_date,
    s.company_name
FROM product_details p
CROSS JOIN supplier s
WHERE YEAR(p.release_date) = 2025;



-- 12. Display every supplier with every warehouse location.
SELECT DISTINCT
    s.company_name,
    p.warehouse_location
FROM supplier s
CROSS JOIN product_details p;



-- 13. Count combinations for Computer Hardware products only.
SELECT COUNT(*) AS total_combinations
FROM product_details p
CROSS JOIN supplier s
WHERE p.category = 'Computer Hardware';



-- 14. Display combinations where supplier rating is greater than 4.5.
SELECT
    p.product_name,
    s.company_name,
    s.reliability_rating
FROM product_details p
CROSS JOIN supplier s
WHERE s.reliability_rating > 4.50;



-- 15. Display all product-supplier combinations sorted by product price.
SELECT
    p.product_name,
    p.price,
    s.company_name
FROM product_details p
CROSS JOIN supplier s
ORDER BY p.price DESC;