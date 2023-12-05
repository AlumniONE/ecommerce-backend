CREATE TABLE cellphones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(50),
    model VARCHAR(100),
    price DECIMAL(10, 2),
    internal_storage VARCHAR(100),
    ram_memory VARCHAR(100),
    operating_system VARCHAR(100),
    screen_size VARCHAR(50),
    screen_resolution VARCHAR(50),
    main_camera VARCHAR(100),
    front_camera VARCHAR(100),
    battery VARCHAR(100),
    connectivity VARCHAR(100),
    color VARCHAR(50),
    stock INT,
    launch_date VARCHAR(20),
    image VARCHAR(255)
);
