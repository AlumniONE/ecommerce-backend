package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.config.PathVariableConfig;
import com.alumnione.ecommerce.dto.CartDto;
import com.alumnione.ecommerce.entity.Cart;
import com.alumnione.ecommerce.service.CartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE)
public class CartController {

    private final CartServiceImpl cartService;

    @PostMapping(path = PathVariableConfig.CART_RESOURCE)
    public ResponseEntity<String> createCart(@RequestBody CartDto cartDto) {
        return cartService.create(cartDto);
    }

    @GetMapping(path = PathVariableConfig.CART_RESOURCE + PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<CartDto> findbyId(@PathVariable Long id) {
        return cartService.findById(id);
    }

    @GetMapping(path = PathVariableConfig.CART_RESOURCE)
    public ResponseEntity<List<Cart>> getAllProducts() {
        return cartService.getAll();
    }

    @DeleteMapping(path = PathVariableConfig.CART_RESOURCE + PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> deleteCart(@PathVariable Long id) {
        return cartService.delete(id);
    }

    @PutMapping(path = PathVariableConfig.CART_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> updateCart (@PathVariable Long id, @RequestBody CartDto cartDto){
        return cartService.update(id, cartDto);
    }

}
