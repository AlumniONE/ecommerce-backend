package com.alumnione.ecommerce.service;


import com.alumnione.ecommerce.dto.CategoryDto;
import com.alumnione.ecommerce.entity.Category;
import com.alumnione.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CrudService<CategoryDto, Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<String> create(CategoryDto categoryDto) {
        if (categoryDto != null) {
            Category newCategory = Category.builder()
                    .name(categoryDto.name())
                    .build();

            categoryRepository.save(newCategory);
            return new ResponseEntity<>("Category created", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error: Don't created", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> update(Long id, CategoryDto categoryDto) {
        if (id > 0 && categoryRepository.existsById(id)) {

            var categoryUpdate = Category.builder()
                    .id(id)
                    .name(categoryDto.name())
                    .build();
            categoryRepository.save(categoryUpdate);

            return new ResponseEntity<>("Category Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Category can't be update", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        if (categoryRepository.existsById(id) && id > 0) {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>("Category Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Page<Category>> getAll(Pageable pageable) {
        if (!categoryRepository.findAll().isEmpty()) {
            return new ResponseEntity<>(categoryRepository.findAll(pageable), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<CategoryDto> findById(Long id) {
        if (id != null && id > 0 && categoryRepository.existsById(id)) {
            var categoryReference = categoryRepository.getReferenceById(id);
            var categoryDto = CategoryDto.builder()
                    .name(categoryReference.getName())
                    .build();

            return new ResponseEntity<>(categoryDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
