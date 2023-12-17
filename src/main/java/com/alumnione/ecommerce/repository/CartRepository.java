package com.alumnione.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alumnione.ecommerce.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> { 
}