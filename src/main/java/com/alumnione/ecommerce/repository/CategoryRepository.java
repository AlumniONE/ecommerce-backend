package com.alumnione.ecommerce.repository;

import com.alumnione.ecommerce.entity.Category;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends IGenericRepo<Category, Long> {
    Category findByName(String name);
}