-- Indexes sql - Indexes is a special data Structure in a database that helps MySQL find rows much faster without scanning the entire table.

use ecommerce_db;

show tables;

CREATE INDEX idx_product_name ON products (product_name);

CREATE INDEX idx_category_id ON products (category_id);

CREATE INDEX idx_supplier ON products (supplier_id);

CREATE INDEX idx_customer ON orders (customer_id);

CREATE INDEX idx_order_date ON orders (order_date);

-- Unique Indexes
CREATE UNIQUE INDEX idx_customer_email ON customers (email);


-- Composite Index
CREATE INDEX idx_category_supplier ON products (category_id, supplier_id);

-- View Indexes
SHOW INDEX FROM customers;

SHOW INDEX FROM products;

SHOW INDEX FROM orders;

-- Drop Index Examples
DROP INDEX idx_category_supplier ON products;