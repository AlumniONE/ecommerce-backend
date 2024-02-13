package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.ProductDto;
import com.alumnione.ecommerce.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public ResponseEntity<String> create(ProductDto productDto);

    public ResponseEntity<Product> update(Long id, ProductDto productDto);

    public ResponseEntity<String> delete(Long id);

    public ResponseEntity<List<Product>> getAll();

    public ResponseEntity<ProductDto> findById(Long id);
}
