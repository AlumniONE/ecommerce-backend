package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.dto.CartReturnDto;
import com.alumnione.ecommerce.service.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "cart")
public class CartController {
    @Autowired
    private CartServiceImp service;

    @PostMapping
    public ResponseEntity<String> createCart() {
        //TODO: a cart will be create automatically when a user is created
        return null;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<CartReturnDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<CartReturnDto> clean(@PathVariable Long id) {
        return ResponseEntity.ok(service.clean(id));
    }

    @PostMapping(path = "{id}/item/{idItem}")
    public ResponseEntity<CartReturnDto> addItem(@PathVariable Long id, @PathVariable Long idItem) {
        return ResponseEntity.ok(service.addItem(id, idItem));
    }

    @DeleteMapping(path = "{id}/item/{idItem}")
    public ResponseEntity<CartReturnDto> deleteItem(@PathVariable Long id, @PathVariable Long idItem) {
        return ResponseEntity.ok(service.deleteItem(id, idItem));
    }
}
