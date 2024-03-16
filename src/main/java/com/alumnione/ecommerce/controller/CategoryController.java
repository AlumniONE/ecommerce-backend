package com.alumnione.ecommerce.controller;


import com.alumnione.ecommerce.config.PathVariableConfig;
import com.alumnione.ecommerce.dto.CategoryDto;
import com.alumnione.ecommerce.entity.Category;
import com.alumnione.ecommerce.service.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE)
public class CategoryController {

    private final CategoryServiceImpl categoryService;


    @PostMapping(path = PathVariableConfig.CATEGORY_RESOURCE)
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.create(categoryDto);
    }

    @GetMapping(path = PathVariableConfig.CATEGORY_RESOURCE + PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping(path = PathVariableConfig.CATEGORY_RESOURCE)
    public ResponseEntity<Page<Category>> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return categoryService.getAll(pageable);
    }

    @DeleteMapping(path = PathVariableConfig.CATEGORY_RESOURCE + PathVariableConfig.RESOURCE_ID)
    @Transactional
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        return categoryService.delete(id);
    }

    @PutMapping(path = PathVariableConfig.CATEGORY_RESOURCE + PathVariableConfig.RESOURCE_ID)
    @Transactional
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        return categoryService.update(id, categoryDto);
    }

}

