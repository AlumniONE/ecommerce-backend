CREATE TABLE users(
    id_user BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    email VARCHAR(30),
    password VARCHAR(20),
    address VARCHAR(30),
    user_type VARCHAR(10)
);