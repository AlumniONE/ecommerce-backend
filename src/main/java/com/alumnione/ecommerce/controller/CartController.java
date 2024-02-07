package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.constan.EcommerceConstant;
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

// TODO: agregar la validacion de los datos de entrada
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores
@RestController
@RequestMapping(path = EcommerceConstant.GENERIC_RESOURCE)
public class CartController {
    @Autowired
    private CartServiceImp service;

    @PostMapping(path = EcommerceConstant.CART_RESOURCE)
    public ResponseEntity<String> createCart() {
        //TODO: a cart will be create automatically when a user is created
        return null;
    }

    @GetMapping(path = EcommerceConstant.CART_RESOURCE+EcommerceConstant.RESOURCE_ID)
    public ResponseEntity<CartReturnDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }


    @PostMapping(path = EcommerceConstant.CART_RESOURCE+EcommerceConstant.RESOURCE_ID)
    public ResponseEntity<CartReturnDto> clean(@PathVariable Long id) {
        return ResponseEntity.ok(service.clean(id));
    }

    @PostMapping(path = EcommerceConstant.CART_RESOURCE+ EcommerceConstant.RESOURCE_ID+ EcommerceConstant.ITEM_RESOURCE+ EcommerceConstant.RESOURCE_ID_ITEM) //path = "{id}/item/{idItem}"
    public ResponseEntity<CartReturnDto> addItem(@PathVariable Long id, @PathVariable Long idItem) {
        return ResponseEntity.ok(service.addItem(id, idItem));
    }

    @DeleteMapping(path = EcommerceConstant.CART_RESOURCE+ EcommerceConstant.RESOURCE_ID+ EcommerceConstant.ITEM_RESOURCE+ EcommerceConstant.RESOURCE_ID_ITEM)
    public ResponseEntity<CartReturnDto> deleteItem(@PathVariable Long id, @PathVariable Long idItem) {
        return ResponseEntity.ok(service.deleteItem(id, idItem));
    }
}
