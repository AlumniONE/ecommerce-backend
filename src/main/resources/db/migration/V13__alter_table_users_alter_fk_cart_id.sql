ALTER TABLE users
               DROP FOREIGN KEY users_carts_id_cart_fk;
ALTER TABLE users
               DROP COLUMN cart_id;

