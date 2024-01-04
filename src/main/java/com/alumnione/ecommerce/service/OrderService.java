package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.OrderCreationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    public ResponseEntity<String> createOrder(OrderCreationDto orderCreationDto);
    public ResponseEntity<List<String>> getAllOrder();

    public ResponseEntity<String> findOrderById(Long id);

    public ResponseEntity<String> updateOrder(Long id, OrderCreationDto orderCreationDto);

    public ResponseEntity<?> deleteOrder(Long id);
}
