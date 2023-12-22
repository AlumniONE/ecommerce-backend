CREATE TABLE cart_cell (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cart_id BIGINT,
    cellphone_id BIGINT,
    FOREIGN KEY (cart_id) REFERENCES carts(id),
    FOREIGN KEY (cellphone_id) REFERENCES cellphones(id)
);