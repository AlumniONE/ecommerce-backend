package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.ProductDto;
import com.alumnione.ecommerce.dto.ProductResponseDto;
import com.alumnione.ecommerce.entity.Category;
import com.alumnione.ecommerce.entity.Product;
import com.alumnione.ecommerce.repository.CategoryRepository;
import com.alumnione.ecommerce.repository.ProductRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements CrudService<ProductDto, ProductResponseDto> {

    private final ProductRepository productRepository;

    private final ObjectMapper objectMapper;

    private final CategoryRepository categoryRepository;

    @SneakyThrows
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> create(ProductDto productDto) {
        if (productDto != null) {
//            ObjectMapper objectMapper = new ObjectMapper();
            String featureString = objectMapper.writeValueAsString(productDto.features());
            Category category = categoryRepository.findByName(productDto.category());

            if (category != null) {
                var newProduct = Product.builder()
                        .SKU(productDto.SKU())
                        .description(productDto.description())
                        .price(productDto.price())
                        .stock(productDto.stock())
                        .category(category)
                        .features(featureString)
                        .build();

                productRepository.save(newProduct);

                return new ResponseEntity<>("Product Created", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Error: Category not found", HttpStatus.BAD_REQUEST);
            }
        } else return new ResponseEntity<>("Error: Don't created", HttpStatus.BAD_REQUEST);
    }

    @SneakyThrows
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> update(Long id, ProductDto productDto) {
        if (id > 0 && productRepository.existsById(id)) {

//            ObjectMapper objectMapper = new ObjectMapper();
            String featureString = objectMapper.writeValueAsString(productDto.features());
            Category category = categoryRepository.findByName(productDto.category());
            if (category != null) {

                var productUpdate = Product.builder()
                        .id(id)
                        .SKU(productDto.SKU())
                        .description(productDto.description())
                        .price(productDto.price())
                        .stock(productDto.stock())
                        .category(category)
                        .features(featureString)
                        .build();
                productRepository.save(productUpdate);

                return new ResponseEntity<>("Product Updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Error: Category not found", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("Product can't be update", HttpStatus.BAD_REQUEST);
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
    public ResponseEntity<Page<ProductResponseDto>> getAll(Pageable pageable) {
        if (!productRepository.findAll().isEmpty()) {
            Page<ProductResponseDto> products = productRepository.findAll(pageable).map(this::mapDataAndJsonToDto);

            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @SneakyThrows
    @Override
    public ResponseEntity<ProductDto> findById(Long id) {
        if (id != null && id > 0 && productRepository.existsById(id)) {
            var productReference = productRepository.getReferenceById(id);
//            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode featureJson = objectMapper.readTree(productReference.getFeatures());
            var productDto = ProductDto.builder()
                    .SKU(productReference.getSKU())
                    .description(productReference.getDescription())
                    .price(productReference.getPrice())
                    .stock(productReference.getStock())
                    .category(productReference.getCategory().getName())
                    .features(featureJson)
                    .build();

            return new ResponseEntity<>(productDto, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @SneakyThrows
    private ProductResponseDto mapDataAndJsonToDto(Product product) {
//        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode featuresJson = objectMapper.readTree(product.getFeatures());

        return ProductResponseDto.builder()
                .id(product.getId())
                .SKU(product.getSKU())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .features(featuresJson)
                .category(product.getCategory())
                .build();
    }
}
