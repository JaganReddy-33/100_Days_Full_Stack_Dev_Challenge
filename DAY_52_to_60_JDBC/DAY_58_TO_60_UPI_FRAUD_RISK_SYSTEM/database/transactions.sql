
USE upi_fraud_system;

CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    transaction_reference VARCHAR(100) NOT NULL UNIQUE,
    transaction_type VARCHAR(20) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    recipient_upi_id VARCHAR(100),
    transaction_status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    risk_score INT DEFAULT 0,
    transaction_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);

ALTER TABLE transactions
ADD COLUMN idempotency_key VARCHAR(100) NOT NULL UNIQUE
AFTER transaction_reference;