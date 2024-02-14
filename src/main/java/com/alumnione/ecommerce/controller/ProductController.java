package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.config.PathVariableConfig;
import com.alumnione.ecommerce.dto.ProductDto;
import com.alumnione.ecommerce.entity.Product;
import com.alumnione.ecommerce.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE)
public class ProductController {

    private final ProductServiceImpl productService;
    @PostMapping(path = PathVariableConfig.PRODUCT_RESOURCE)
    public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto){
        return productService.create(productDto);
    }

    @GetMapping(path = PathVariableConfig.PRODUCT_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<ProductDto> findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping(path = PathVariableConfig.PRODUCT_RESOURCE)
    public ResponseEntity<List<Product>> getAllProducts(){
        return productService.getAll();
    }

    @DeleteMapping(path = PathVariableConfig.PRODUCT_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return productService.delete(id);
    }

    @PutMapping(path = PathVariableConfig.PRODUCT_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> updateProduct (@PathVariable Long id, @RequestBody ProductDto productDto){
        return productService.update(id,productDto);
    }


}
