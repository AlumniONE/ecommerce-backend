package com.alumnione.ecommerce.repository;

import com.alumnione.ecommerce.entity.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends IGenericRepo<Cart, Long> {
}