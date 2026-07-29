-- Create and Use the Product Database
CREATE DATABASE IF NOT EXISTS product_db;
USE product_db;

-- 1. Create Tables with Foreign Key Constraints
CREATE TABLE supplier (
    supplier_id INT PRIMARY KEY,
    company_name VARCHAR(100) NOT NULL,
    contact_name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    country VARCHAR(50),
    reliability_rating DECIMAL(3,2)
);

CREATE TABLE product_details (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    stock_quantity INT,
    price DECIMAL(10,2),
    sku VARCHAR(20) UNIQUE,
    manufacturer VARCHAR(50),
    warehouse_location VARCHAR(50),
    release_date DATE,
    customer_rating DECIMAL(3,2),
    energy_label VARCHAR(5)
);

CREATE TABLE inventory_order (
    order_id INT PRIMARY KEY,
    product_id INT,
    supplier_id INT,
    order_date DATE,
    quantity_ordered INT,
    unit_cost DECIMAL(10,2),
    fulfillment_status VARCHAR(20),
    FOREIGN KEY (product_id) REFERENCES product_details(product_id),
    FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id)
);

-- 2. Populate Supplier Data (8 Rows)
INSERT INTO supplier (supplier_id, company_name, contact_name, email, phone, country, reliability_rating) VALUES
(201, 'Apex Electronics Corp', 'John Tech', 'orders@apex.com', '+1-555-0201', 'United States', 4.85),
(202, 'Global Logistics Solutions', 'Sarah Zhang', 'szhang@gls.com', '+86-555-0202', 'China', 4.92),
(203, 'EuroComponent GmbH', 'Hans Muller', 'h.muller@eurocomp.de', '+49-555-0203', 'Germany', 4.40),
(204, 'Pacific Logistics Networks', 'Emily Brown', 'ebrown@pacificlog.com', '+1-555-0204', 'United States', 4.65),
(205, 'Nordic Retail Supplies', 'Olav Jones', 'olav.j@nordic.se', '+46-555-0205', 'Sweden', 4.15),
(206, 'Asiatic Tech Manufacturing', 'Sophia Miller', 'sophia.m@asiatech.tw', '+886-555-0206', 'Taiwan', 4.78),
(207, 'Britannia Industrial Ltd', 'Jackson Davis', 'j.davis@britind.co.uk', '+44-555-0207', 'United Kingdom', 4.55),
(208, 'LatAm Distribution Services', 'Mia Garcia', 'mia.g@latamdist.br', '+55-555-0208', 'Brazil', 4.20);

-- 3. Populate Product Details Data (20 Rows)
INSERT INTO product_details (product_id, product_name, category, stock_quantity, price, sku, manufacturer, warehouse_location, release_date, customer_rating, energy_label) VALUES
(101, 'Quantum X1 Laptop', 'Computer Hardware', 45, 1299.99, 'SKU-LAP-101', 'QuantumTech', 'New York', '2025-09-01', 4.85, 'A+'),
(102, 'Zeta Vision Monitor', 'Computer Hardware', 120, 349.50, 'SKU-MON-102', 'ZetaCorp', 'Boston', '2025-09-01', 4.92, 'O-'),
(103, 'VoltStream Power Unit', 'Electrical Component', 350, 89.99, 'SKU-PWR-103', 'VoltStream', 'Chicago', '2024-09-01', 4.40, 'B+'),
(104, 'AeroCore i7 Processor', 'Computer Hardware', 85, 419.99, 'SKU-CPU-104', 'Intelis', 'Austin', '2026-01-15', 4.65, 'AB+'),
(105, 'Titanium Solid State Drive', 'Computer Hardware', 210, 189.00, 'SKU-SSD-105', 'TitanStorage', 'Seattle', '2024-09-01', 4.15, 'A-'),
(106, 'Apex Wireless Router', 'Computer Hardware', 65, 149.99, 'SKU-NET-106', 'ApexNet', 'New York', '2025-09-01', 4.78, 'O+'),
(107, 'Matrix Graphics Card', 'Computer Hardware', 30, 799.00, 'SKU-GPU-107', 'MatrixLabs', 'Boston', '2024-09-01', 4.55, 'A+'),
(108, 'Flux Capacitance Sensor', 'Electrical Component', 150, 45.50, 'SKU-SEN-108', 'FluxSystems', 'Austin', '2025-09-01', 4.20, 'B-'),
(109, 'Nova RGB Mechanical Keyboard', 'Computer Hardware', 140, 125.00, 'SKU-KEY-109', 'NovaPeripherals', 'Chicago', '2026-01-15', 4.90, 'AB-'),
(110, 'Aura Noise Cancelling Headset', 'Computer Hardware', 95, 249.99, 'SKU-AUD-110', 'AuraSound', 'New York', '2024-09-01', 4.45, 'O-'),
(111, 'Omni Ergonomic Desk Chair', 'Office Furniture', 25, 389.99, 'SKU-FUR-111', 'OmniComfort', 'Seattle', '2025-09-01', 3.98, 'B+'),
(112, 'Stratus Cloud Storage Node', 'Computer Hardware', 15, 2450.00, 'SKU-SRV-112', 'StratusTech', 'Boston', '2025-09-01', 4.60, 'A-'),
(113, 'Ampere Digital Multimeter', 'Electrical Component', 110, 75.25, 'SKU-TL-113', 'AmpereTools', 'Chicago', '2024-09-01', 4.10, 'O+'),
(114, 'Pulse Smart Fitness Tracker', 'Wearable Electronics', 180, 159.95, 'SKU-WR-114', 'PulseLabs', 'Austin', '2025-09-01', 4.88, 'AB+'),
(115, 'Vortex Industrial Exhaust Fan', 'Mechanical Machinery', 12, 899.00, 'SKU-MCH-115', 'VortexInd', 'Seattle', '2023-09-01', 4.35, 'A+'),
(116, 'Pixel Ultra Web Camera', 'Computer Hardware', 135, 99.00, 'SKU-CAM-116', 'PixelMedia', 'Austin', '2026-01-15', 4.42, 'O-'),
(117, 'Solaria Mono Solar Panel', 'Electrical Component', 40, 299.99, 'SKU-SOL-117', 'SolariaEnergy', 'New York', '2024-09-01', 4.67, 'B+'),
(118, 'Synapse Braided Ethernet Pack', 'Electrical Component', 500, 15.99, 'SKU-CAB-118', 'SynapseCables', 'Boston', '2025-09-01', 4.72, 'A+'),
(119, 'Kinetix Hydraulic Valve', 'Mechanical Machinery', 8, 450.00, 'SKU-VAL-119', 'KinetixFluid', 'Chicago', '2025-09-01', 3.85, 'AB-'),
(120, 'Helix Water Cooling Block', 'Computer Hardware', 50, 115.00, 'SKU-CLR-120', 'HelixCooling', 'Seattle', '2024-09-01', 4.95, 'O+');

-- 4. Populate Inventory Order Transaction Data (25 Rows)
INSERT INTO inventory_order (order_id, product_id, supplier_id, order_date, quantity_ordered, unit_cost, fulfillment_status) VALUES
(301, 101, 201, '2025-09-05', 20, 1100.00, 'Completed'),
(302, 101, 203, '2025-09-05', 10, 1150.00, 'Active'),
(303, 102, 202, '2025-09-06', 50, 280.00, 'Active'),
(304, 102, 204, '2025-09-10', 30, 290.00, 'Active'),
(305, 103, 201, '2024-09-10', 100, 65.00, 'Completed'),
(306, 104, 201, '2026-01-20', 25, 350.00, 'Active'),
(307, 105, 202, '2024-09-12', 40, 140.00, 'Dropped'),
(308, 106, 201, '2025-09-03', 30, 110.00, 'Completed'),
(309, 106, 205, '2025-09-05', 15, 115.00, 'Active'),
(310, 107, 202, '2024-09-05', 15, 680.00, 'Completed'),
(311, 107, 204, '2025-02-10', 10, 700.00, 'Completed'),
(312, 107, 206, '2025-09-12', 20, 675.00, 'Active'),
(313, 108, 208, '2025-09-06', 75, 32.00, 'Active'),
(314, 109, 201, '2026-01-18', 40, 90.00, 'Active'),
(315, 109, 205, '2026-01-22', 20, 95.00, 'Active'),
(316, 110, 202, '2024-09-10', 35, 190.00, 'Completed'),
(317, 110, 204, '2025-09-05', 25, 200.00, 'Active'),
(318, 112, 201, '2025-09-02', 5, 2100.00, 'Completed'),
(319, 112, 207, '2025-09-05', 3, 2150.00, 'Active'),
(320, 113, 201, '2024-09-15', 50, 52.00, 'Completed'),
(321, 114, 202, '2025-09-06', 60, 118.00, 'Active'),
(322, 114, 206, '2025-09-10', 40, 120.00, 'Active'),
(323, 116, 205, '2026-01-20', 45, 72.00, 'Active'),
(324, 117, 202, '2024-09-08', 20, 230.00, 'Completed'),
(325, 117, 204, '2025-09-04', 15, 240.00, 'Dropped');

SELECT * FROM product_details;