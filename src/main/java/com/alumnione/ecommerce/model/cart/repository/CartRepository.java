package com.alumnione.ecommerce.model.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alumnione.ecommerce.model.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> { 
}