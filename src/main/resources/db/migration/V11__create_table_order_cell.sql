CREATE TABLE order_cell (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT,
    cellphone_id BIGINT,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (cellphone_id) REFERENCES cellphones(id)
);
