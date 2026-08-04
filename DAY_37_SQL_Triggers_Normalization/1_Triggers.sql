

-- Triggers :
-- A Trigger is SQL code that runs automatically.
-- It is attached to a specific table.
-- It runs on INSERT, UPDATE, or DELETE each event can happens after or before the event occurs.
-- It is commonly used for validation, auditing, logging, and maintaining data consistency.


USE ecommerce_db;

-- 1. BEFORE INSERT TRIGGERS

DELIMITER //
CREATE TRIGGER trg_bi_order_items_set_price
BEFORE INSERT ON order_items
FOR EACH ROW
BEGIN
    IF NEW.unit_price IS NULL OR NEW.unit_price <= 0 THEN
        SELECT price INTO @prod_price FROM products WHERE product_id = NEW.product_id;
        SET NEW.unit_price = @prod_price;
    END IF;
END;
//

CREATE TRIGGER trg_bi_customers_clean_email
BEFORE INSERT ON customers
FOR EACH ROW
BEGIN
    SET NEW.email = LOWER(TRIM(NEW.email));
END;
//

CREATE TRIGGER trg_bi_products_default_stock
BEFORE INSERT ON products
FOR EACH ROW
BEGIN
    IF NEW.stock_quantity IS NULL THEN
        SET NEW.stock_quantity = 0;
    END IF;
END;
//

CREATE TRIGGER trg_bi_suppliers_format_phone
BEFORE INSERT ON suppliers
FOR EACH ROW
BEGIN
    SET NEW.phone = REGEXP_REPLACE(NEW.phone, '[^0-9]', '');
END;
//

CREATE TRIGGER trg_bi_orders_check_status
BEFORE INSERT ON orders
FOR EACH ROW
BEGIN
    IF NEW.order_status IS NULL THEN
        SET NEW.order_status = 'Pending';
    END IF;
END;
//
DELIMITER ;


-- 2. AFTER INSERT TRIGGERS

DELIMITER //
CREATE TRIGGER trg_ai_order_items_reduce_stock
AFTER INSERT ON order_items
FOR EACH ROW
BEGIN
    UPDATE products 
    SET stock_quantity = stock_quantity - NEW.quantity
    WHERE product_id = NEW.product_id;
END;
//

CREATE TRIGGER trg_ai_order_items_update_order_total
AFTER INSERT ON order_items
FOR EACH ROW
BEGIN
    UPDATE orders
    SET total_amount = total_amount + (NEW.quantity * NEW.unit_price)
    WHERE order_id = NEW.order_id;
END;
//

CREATE TRIGGER trg_ai_orders_log_initial_status
AFTER INSERT ON orders
FOR EACH ROW
BEGIN
    INSERT INTO categories (category_name, description) 
    VALUES (CONCAT('Audit Order ', NEW.order_id), CONCAT('Created with status: ', NEW.order_status));
END;
//

CREATE TRIGGER trg_ai_products_notify_low_stock
AFTER INSERT ON products
FOR EACH ROW
BEGIN
    IF NEW.stock_quantity < 5 THEN
        SET @alert = CONCAT('Low stock warning for product: ', NEW.product_name);
    END IF;
END;
//

CREATE TRIGGER trg_ai_customers_welcome_note
AFTER INSERT ON customers
FOR EACH ROW
BEGIN
    SET @welcome_msg = CONCAT('Welcome ', NEW.first_name, ' ', NEW.last_name);
END;
//
DELIMITER ;


-- 3. BEFORE UPDATE TRIGGERS

DELIMITER //
CREATE TRIGGER trg_bu_orders_prevent_delivered_edit
BEFORE UPDATE ON orders
FOR EACH ROW
BEGIN
    IF OLD.order_status IN ('Delivered', 'Cancelled') AND NEW.order_status != OLD.order_status THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot modify status of completed or cancelled orders.';
    END IF;
END;
//

CREATE TRIGGER trg_bu_products_prevent_negative_price
BEFORE UPDATE ON products
FOR EACH ROW
BEGIN
    IF NEW.price < 0 THEN
        SET NEW.price = OLD.price;
    END IF;
END;
//

CREATE TRIGGER trg_bu_customers_prevent_email_change
BEFORE UPDATE ON customers
FOR EACH ROW
BEGIN
    IF OLD.email != NEW.email THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Email address cannot be modified once created.';
    END IF;
END;
//

CREATE TRIGGER trg_bu_suppliers_validate_rating
BEFORE UPDATE ON suppliers
FOR EACH ROW
BEGIN
    IF NEW.supplier_rating > 5.00 THEN
        SET NEW.supplier_rating = 5.00;
    ELSEIF NEW.supplier_rating < 0.00 THEN
        SET NEW.supplier_rating = 0.00;
    END IF;
END;
//

CREATE TRIGGER trg_bu_order_items_recalculate_unit_price
BEFORE UPDATE ON order_items
FOR EACH ROW
BEGIN
    IF NEW.product_id != OLD.product_id THEN
        SELECT price INTO @new_price FROM products WHERE product_id = NEW.product_id;
        SET NEW.unit_price = @new_price;
    END IF;
END;
//
DELIMITER ;


-- 4. AFTER UPDATE TRIGGERS

DELIMITER //
CREATE TRIGGER trg_au_orders_restore_stock_on_cancel
AFTER UPDATE ON orders
FOR EACH ROW
BEGIN
    IF OLD.order_status != 'Cancelled' AND NEW.order_status = 'Cancelled' THEN
        UPDATE products p
        JOIN order_items oi ON p.product_id = oi.product_id
        SET p.stock_quantity = p.stock_quantity + oi.quantity
        WHERE oi.order_id = NEW.order_id;
    END IF;
END;
//

CREATE TRIGGER trg_au_order_items_readjust_stock
AFTER UPDATE ON order_items
FOR EACH ROW
BEGIN
    IF OLD.quantity != NEW.quantity THEN
        UPDATE products 
        SET stock_quantity = stock_quantity + (OLD.quantity - NEW.quantity)
        WHERE product_id = NEW.product_id;
    END IF;
END;
//

CREATE TRIGGER trg_au_order_items_recalculate_order_total
AFTER UPDATE ON order_items
FOR EACH ROW
BEGIN
    UPDATE orders 
    SET total_amount = (
        SELECT COALESCE(SUM(quantity * unit_price), 0.00) 
        FROM order_items 
        WHERE order_id = NEW.order_id
    )
    WHERE order_id = NEW.order_id;
END;
//

CREATE TRIGGER trg_au_products_track_price_change
AFTER UPDATE ON products
FOR EACH ROW
BEGIN
    IF OLD.price != NEW.price THEN
        SET @price_log = CONCAT('Product ', NEW.product_id, ' price changed from ', OLD.price, ' to ', NEW.price);
    END IF;
END;
//

CREATE TRIGGER trg_au_suppliers_sync_rating_alert
AFTER UPDATE ON suppliers
FOR EACH ROW
BEGIN
    IF NEW.supplier_rating < 2.00 THEN
        SET @supplier_alert = CONCAT('Supplier ', NEW.company_name, ' rating dropped below threshold.');
    END IF;
END;
//
DELIMITER ;


-- 5. BEFORE DELETE TRIGGERS

DELIMITER //
CREATE TRIGGER trg_bd_customers_prevent_delete_active
BEFORE DELETE ON customers
FOR EACH ROW
BEGIN
    DECLARE order_count INT;
    SELECT COUNT(*) INTO order_count 
    FROM orders 
    WHERE customer_id = OLD.customer_id AND order_status != 'Cancelled';
    
    IF order_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot delete customer with active or completed orders.';
    END IF;
END;
//

CREATE TRIGGER trg_bd_categories_prevent_delete_used
BEFORE DELETE ON categories
FOR EACH ROW
BEGIN
    DECLARE prod_count INT;
    SELECT COUNT(*) INTO prod_count FROM products WHERE category_id = OLD.category_id;
    IF prod_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot delete category containing existing products.';
    END IF;
END;
//

CREATE TRIGGER trg_bd_suppliers_prevent_delete_active
BEFORE DELETE ON suppliers
FOR EACH ROW
BEGIN
    DECLARE prod_count INT;
    SELECT COUNT(*) INTO prod_count FROM products WHERE supplier_id = OLD.supplier_id;
    IF prod_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot delete supplier supplying active products.';
    END IF;
END;
//

CREATE TRIGGER trg_bd_products_prevent_delete_in_orders
BEFORE DELETE ON products
FOR EACH ROW
BEGIN
    DECLARE item_count INT;
    SELECT COUNT(*) INTO item_count FROM order_items WHERE product_id = OLD.product_id;
    IF item_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot delete product linked to historical orders.';
    END IF;
END;
//

CREATE TRIGGER trg_bd_orders_prevent_delete_shipped
BEFORE DELETE ON orders
FOR EACH ROW
BEGIN
    IF OLD.order_status IN ('Shipped', 'Delivered') THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot delete orders that are already shipped or delivered.';
    END IF;
END;
//
DELIMITER ;


-- 6. AFTER DELETE TRIGGERS

DELIMITER //
CREATE TRIGGER trg_ad_order_items_recalculate_total
AFTER DELETE ON order_items
FOR EACH ROW
BEGIN
    UPDATE orders 
    SET total_amount = (
        SELECT COALESCE(SUM(quantity * unit_price), 0.00) 
        FROM order_items 
        WHERE order_id = OLD.order_id
    )
    WHERE order_id = OLD.order_id;
END;
//

CREATE TRIGGER trg_ad_order_items_restore_stock
AFTER DELETE ON order_items
FOR EACH ROW
BEGIN
    UPDATE products 
    SET stock_quantity = stock_quantity + OLD.quantity
    WHERE product_id = OLD.product_id;
END;
//

CREATE TRIGGER trg_ad_customers_log_deletion
AFTER DELETE ON customers
FOR EACH ROW
BEGIN
    SET @deleted_customer_log = CONCAT('Customer deleted: ', OLD.first_name, ' ', OLD.last_name, ' (ID: ', OLD.customer_id, ')');
END;
//

CREATE TRIGGER trg_ad_products_log_deletion
AFTER DELETE ON products
FOR EACH ROW
BEGIN
    SET @deleted_product_log = CONCAT('Product removed: ', OLD.product_name, ' Price: ', OLD.price);
END;
//

CREATE TRIGGER trg_ad_orders_log_deletion
AFTER DELETE ON orders
FOR EACH ROW
BEGIN
    SET @deleted_order_log = CONCAT('Order ID ', OLD.order_id, ' removed. Total was: ', OLD.total_amount);
END;
//
DELIMITER ;

SHOW TRIGGERS FROM ecommerce_db;

SHOW TRIGGERS LIKE 'orders';
