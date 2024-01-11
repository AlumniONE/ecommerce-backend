package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.OrderCreationDto;
import com.alumnione.ecommerce.entity.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    public ResponseEntity<OrderCreationDto> createOrder(Order order);
    public ResponseEntity<List<OrderCreationDto>> getAllOrder();
    public ResponseEntity<OrderCreationDto> findOrderById(Long id);
    public ResponseEntity<String> updateOrder(Long id, OrderCreationDto orderCreationDto);
    public ResponseEntity<?> deleteOrder(Long id);
}
