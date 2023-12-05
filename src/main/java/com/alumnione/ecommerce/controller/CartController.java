package com.alumnione.ecommerce.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @PostMapping
    public ResponseEntity<DataResponseCart> createCart(@RequestBody @Valid DataRegisterCartDTO dataRegisterCartDTO, UriComponentsBuilder uriComponentsBuilder) {
        Cart cart = cartRepository.save(new Cart(dataRegisterCartDTO));
        URI url = uriComponentsBuilder.path("/carts/{id}").buildAndExpand(cart.getId()).toUri();
        return ResponseEntity.created(url).body(new DataResponseCart(cart));
    }

    @GetMapping
    public ResponseEntity<Page<DataListCart>> listCarts(@PageableDefault(size=9) Pageable pagination) {
        return ResponseEntity.ok(cartRepository.findAll(pagination).map(DataListCart::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataResponseCart> updateCart(@RequestBody @Valid DataUpdateCartDTO dataUpdateCartDTO) {
        Cart cart = cartRepository.getReferenceById(dataUpdateCartDTO.id());
        cart.updateData(dataUpdateCartDTO);
        return ResponseEntity.ok(new DataResponseCart(cart));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCart(@PathVariable Long id) {
        Cart cart = cartRepository.getReferenceById(id);
        cart.deleteCart();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseCart> getCart(@PathVariable Long id) {
        Cart cart = cartRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataResponseCart(cart));
    }
}
