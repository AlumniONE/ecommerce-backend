package com.alumnione.ecommerce.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<DataResponseProduct> createProduct(@RequestBody @Valid DataCreateProductDTO dataCreateProductDTO, UriComponentsBuilder uriComponentsBuilder) {
        Product product = productRepository.save(new Product(dataCreateProductDTO));
        URI url = uriComponentsBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(url).body(new DataResponseProduct(product));
    }

    @GetMapping
    public ResponseEntity<Page<DataListProduct>> listProducts(@PageableDefault(size=9) Pageable pagination) {
        return ResponseEntity.ok(productRepository.findAll(pagination).map(DataListProduct::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataResponseProduct> updateProduct(@RequestBody @Valid DataUpdateProductDTO dataUpdateProductDTO) {
        Product product = productRepository.getReferenceById(dataUpdateProductDTO.id());
        product.updateData(dataUpdateProductDTO);
        return ResponseEntity.ok(new DataResponseProduct(product));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        Product product = productRepository.getReferenceById(id);
        product.deleteProduct();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseProduct> getProduct(@PathVariable Long id) {
        Product product = productRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataResponseProduct(product));
    }
}
