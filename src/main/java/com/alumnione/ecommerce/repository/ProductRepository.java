package com.alumnione.ecommerce.repository;

import com.alumnione.ecommerce.dto.ProductDto;
import com.alumnione.ecommerce.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends IGenericRepo<Product,Long> {

    ProductDto findBySKU(String SKU);
}
