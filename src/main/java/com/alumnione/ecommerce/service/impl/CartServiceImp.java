package com.alumnione.ecommerce.service.impl;

import com.alumnione.ecommerce.dto.CartReturnDto;
import com.alumnione.ecommerce.entity.Cart;
import com.alumnione.ecommerce.entity.Cellphone;
import com.alumnione.ecommerce.repository.CartRepository;
import com.alumnione.ecommerce.repository.CellphoneRepository;
import com.alumnione.ecommerce.service.CartService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CellphoneRepository cellRepository;

    @Override
    public CartReturnDto get(long id) {
        Cart cart = validateId(id);
        return new CartReturnDto(cart);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public CartReturnDto clean(long id) {
        Cart cart = validateId(id);
        cart.getCellphones().clear();
        cartRepository.save(cart);
        return new CartReturnDto(cart);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public CartReturnDto addItem(long cartId, long cellId) {
        Cart cart = validateId(cartId);
        Cellphone cell = validateIdCell(cellId);
        cart.getCellphones().add(cell);
        cartRepository.save(cart);
        return new CartReturnDto(cart);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public CartReturnDto deleteItem(long cartId, long cellId) {
        Cart cart = validateId(cartId);
        Cellphone cell = validateIdCell(cellId);
        cart.getCellphones().remove(cell);
        cartRepository.save(cart);
        return new CartReturnDto(cart);
    }

    private Cart validateId(Long id){
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("no entity id found"));
    }

    private Cellphone validateIdCell(Long id){
        return cellRepository.findById(id).orElseThrow(() -> new RuntimeException("no entity id found"));
    }
}
