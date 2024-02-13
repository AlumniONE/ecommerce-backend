package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.CartDto;
import com.alumnione.ecommerce.dto.ProductDto;
import com.alumnione.ecommerce.entity.Cart;
import com.alumnione.ecommerce.entity.Cellphone;
import com.alumnione.ecommerce.entity.Product;
import com.alumnione.ecommerce.repository.CartRepository;
import com.alumnione.ecommerce.repository.CellphoneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CrudService<CartDto, Cart> {

    private final CartRepository cartRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<String> create(CartDto cartDto) {
        if (cartDto != null) {
            var newCart = Cart.builder()
            .lastUpdated(cartDto.lastUpdated())
            .build();
            cartRepository.save(newCart);

            return new ResponseEntity<>("Cart Created", HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<String> update(Long id, CartDto cartDto) {
        if (id > 0 && cartRepository.existsById(id)) {

            var cartUpdate = Cart.builder()
            .id(id)
            .lastUpdated(cartDto.lastUpdated())
            .build();
            cartRepository.save(cartUpdate);

            return new ResponseEntity<>("Cart Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("cart can't be update", HttpStatus.BAD_REQUEST);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<String> delete(Long id) {
        if (cartRepository.existsById(id) && id > 0) {
            cartRepository.deleteById(id);
            return new ResponseEntity<>("Cart Deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("Does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Cart>> getAll() {
        if (!cartRepository.findAll().isEmpty()) return new ResponseEntity<>(cartRepository.findAll(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<CartDto> findById(Long id) {
        if (id != null && id > 0 && cartRepository.existsById(id)) {
            var cartReference = cartRepository.getReferenceById(id);

            var cartDto = CartDto.builder()
            .lastUpdated(cartReference.getLastUpdated())
            .build();

            return new ResponseEntity<>(cartDto, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}


