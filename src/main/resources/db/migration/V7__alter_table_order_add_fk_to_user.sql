ALTER TABLE orders
ADD CONSTRAINT orders_users_id_fk
FOREIGN KEY (user_id) REFERENCES users (id_user);