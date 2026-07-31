
SELECT * FROM customers WHERE city = 'Mumbai';

SELECT * FROM products WHERE price = 4500.00;

SELECT * FROM orders WHERE total_amount >= 10000.00;

SELECT * FROM suppliers WHERE supplier_rating < 4.00;

SELECT * FROM products WHERE stock_quantity <= 15;

SELECT * FROM customers WHERE registration_date > '2025-03-01';

SELECT * FROM products WHERE price BETWEEN 500.00 AND 2000.00;

SELECT * FROM orders WHERE order_date BETWEEN '2025-02-01' AND '2025-02-28';

SELECT * FROM suppliers WHERE supplier_rating BETWEEN 4.20 AND 4.70;

SELECT * FROM customers WHERE city IN ('Mumbai', 'Delhi', 'Bengaluru');

SELECT * FROM orders WHERE order_status IN ('Pending', 'Processing', 'Shipped');

SELECT * FROM products WHERE category_id IN (1, 4, 5);

SELECT * FROM customers WHERE city NOT IN ('Mumbai', 'Delhi');

SELECT * FROM orders WHERE order_status NOT IN ('Delivered', 'Cancelled');

SELECT * FROM products WHERE category_id NOT IN (2, 7);

SELECT * FROM products WHERE product_name LIKE 'OnePlus%';

SELECT * FROM products WHERE product_name LIKE '%Watch%';

SELECT * FROM customers WHERE email LIKE '%@email.in';

SELECT * FROM customers WHERE phone LIKE '987%';

SELECT * FROM products WHERE product_name REGEXP 'Pro|Max';

SELECT * FROM customers WHERE first_name REGEXP '^[A-E]';

SELECT * FROM suppliers WHERE company_name REGEXP 'Ltd|Corp|Ventures';

SELECT * FROM customers WHERE phone IS NULL;

SELECT * FROM suppliers WHERE contact_name IS NOT NULL;

SELECT * FROM products WHERE release_date IS NULL;

SELECT * FROM products WHERE price > 1000.00 AND stock_quantity > 50;

SELECT * FROM orders WHERE order_status = 'Pending' OR payment_method = 'Cash on Delivery';

SELECT * FROM customers WHERE state = 'Maharashtra' AND registration_date >= '2025-03-01';

SELECT * FROM products WHERE (price < 500.00 OR product_rating > 4.5) AND stock_quantity > 0;
