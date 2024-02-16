package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.ProductDto;
import com.alumnione.ecommerce.entity.Product;
import com.alumnione.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements CrudService<ProductDto,Product> {

    private final ProductRepository productRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> create(ProductDto productDto) {
        if (productDto != null) {
            var newProduct = Product.builder()
            .SKU(productDto.SKU())
            .descripion(productDto.descripion())
            .price(productDto.price())
            .stock(productDto.stock())
            .build();

            productRepository.save(newProduct);

            return new ResponseEntity<>("Product Created", HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> update(Long id, ProductDto productDto) {
        if (id > 0 && productRepository.existsById(id)) {

            var productUpdate = Product.builder()
            .id(id)
            .SKU(productDto.SKU())
            .descripion(productDto.descripion())
            .price(productDto.price())
            .stock(productDto.stock())
            .build();
            productRepository.save(productUpdate);

            return new ResponseEntity<>("Product Updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("Product can't be update",HttpStatus.BAD_REQUEST);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> delete(Long id) {
        if (productRepository.existsById(id) && id > 0) {
            productRepository.deleteById(id);
            return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("Does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Page<Product>> getAll(Pageable pageable) {
        if(!productRepository.findAll().isEmpty()) return new ResponseEntity<>(productRepository.findAll(pageable), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<ProductDto> findById(Long id) {
        if (id != null && id > 0 && productRepository.existsById(id)) {
            var productReference = productRepository.getReferenceById(id);

            var productDto = ProductDto.builder()
            .SKU(productReference.getSKU())
            .descripion(productReference.getDescripion())
            .price(productReference.getPrice())
            .stock(productReference.getStock())
            .build();

            return new ResponseEntity<>(productDto, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
