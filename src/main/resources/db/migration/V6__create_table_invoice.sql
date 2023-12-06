CREATE TABLE invoice(
    id_invoice BIGINT AUTO_INCREMENT PRIMARY KEY,
    invoice_date TIMESTAMP,
    total_amount DECIMAL(10, 2)
);