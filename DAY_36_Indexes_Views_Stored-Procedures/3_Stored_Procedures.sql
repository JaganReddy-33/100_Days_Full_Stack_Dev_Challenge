-- Stored Procedure - A Stored Procedure is a named block of SQL statements that is stored inside the database and can be executed whenever needed.

-- Think of it as a function in programming.

-- Instead of writing the same SQL queries repeatedly, you write them once, save them in the database, and execute them by name.

USE ecommerce_db;

DELIMITER $$

CREATE PROCEDURE GetAllProducts()
BEGIN
    SELECT * FROM products;
END $$

CREATE PROCEDURE GetProductById(IN p_product_id INT)
BEGIN
    SELECT *
    FROM products
    WHERE product_id = p_product_id;
END $$

CREATE PROCEDURE GetProductsByCategory(IN p_category_id INT)
BEGIN
    SELECT *
    FROM products
    WHERE category_id = p_category_id;
END $$

CREATE PROCEDURE GetLowStockProducts(IN p_stock_limit INT)
BEGIN
    SELECT *
    FROM products
    WHERE stock_quantity <= p_stock_limit;
END $$

CREATE PROCEDURE GetProductsBySupplier(IN p_supplier_id INT)
BEGIN
    SELECT *
    FROM products
    WHERE supplier_id = p_supplier_id;
END $$

CREATE PROCEDURE GetProductsAbovePrice(IN p_price DECIMAL(10,2))
BEGIN
    SELECT *
    FROM products
    WHERE price > p_price;
END $$

CREATE PROCEDURE GetCustomerOrders(IN p_customer_id INT)
BEGIN
    SELECT *
    FROM orders
    WHERE customer_id = p_customer_id;
END $$

CREATE PROCEDURE GetOrdersByStatus(IN p_status VARCHAR(30))
BEGIN
    SELECT *
    FROM orders
    WHERE order_status = p_status;
END $$

CREATE PROCEDURE AddProduct(
    IN p_product_name VARCHAR(100),
    IN p_category_id INT,
    IN p_supplier_id INT,
    IN p_price DECIMAL(10,2),
    IN p_stock_quantity INT,
    IN p_product_rating DECIMAL(3,2),
    IN p_release_date DATE
)
BEGIN
    INSERT INTO products
    (
        product_name,
        category_id,
        supplier_id,
        price,
        stock_quantity,
        product_rating,
        release_date
    )
    VALUES
    (
        p_product_name,
        p_category_id,
        p_supplier_id,
        p_price,
        p_stock_quantity,
        p_product_rating,
        p_release_date
    );
END $$

CREATE PROCEDURE UpdateProductStock(
    IN p_product_id INT,
    IN p_new_stock INT
)
BEGIN
    UPDATE products
    SET stock_quantity = p_new_stock
    WHERE product_id = p_product_id;
END $$

CREATE PROCEDURE UpdateProductPrice(
    IN p_product_id INT,
    IN p_new_price DECIMAL(10,2)
)
BEGIN
    UPDATE products
    SET price = p_new_price
    WHERE product_id = p_product_id;
END $$

CREATE PROCEDURE DeleteProduct(IN p_product_id INT)
BEGIN
    DELETE FROM products
    WHERE product_id = p_product_id;
END $$

CREATE PROCEDURE TotalProducts()
BEGIN
    SELECT COUNT(*) AS total_products
    FROM products;
END $$

CREATE PROCEDURE TotalCustomers()
BEGIN
    SELECT COUNT(*) AS total_customers
    FROM customers;
END $$

CREATE PROCEDURE TotalRevenue()
BEGIN
    SELECT SUM(total_amount) AS total_revenue
    FROM orders;
END $$

DELIMITER;

CALL GetAllProducts ();

CALL GetProductById (5);

CALL GetProductsByCategory (1);

CALL GetLowStockProducts (20);

CALL GetProductsBySupplier (4);

CALL GetProductsAbovePrice (5000);

CALL GetCustomerOrders (1);

CALL GetOrdersByStatus ('Delivered');

CALL AddProduct (
    'Demo Product',
    1,
    1,
    999.00,
    50,
    4.50,
    '2025-06-01'
);

CALL UpdateProductStock (41, 100);

CALL UpdateProductPrice (41, 1299.00);

CALL TotalProducts ();

CALL TotalCustomers ();

CALL TotalRevenue ();

CALL DeleteProduct (41);