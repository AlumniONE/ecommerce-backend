package com.alumnione.ecommerce.repository;

import com.alumnione.ecommerce.dto.ProductDto;
import com.alumnione.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    public ProductDto findBySKU(String SKU);
}
