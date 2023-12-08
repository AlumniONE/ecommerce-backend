CREATE TABLE orders(
  id_order INT AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  product_id INT NULL,
  order_created_at DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
  order_status JSON NULL
);
