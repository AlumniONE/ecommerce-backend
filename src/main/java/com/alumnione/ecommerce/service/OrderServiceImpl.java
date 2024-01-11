package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.OrderCreationDto;
import com.alumnione.ecommerce.entity.Order;
import com.alumnione.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public ResponseEntity<OrderCreationDto> createOrder(Order order) {
        if(order != null){
            OrderCreationDto orderCreationDto = OrderMapper.convertEntityToDto(order);
            orderRepository.save(order);
            return new ResponseEntity<>(orderCreationDto, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<OrderCreationDto>> getAllOrder() {

        return null;
    }


    @Override
    public ResponseEntity<OrderCreationDto> findOrderById(Long id) {
        if(orderRepository.existsById(id)){
            Order order = orderRepository.getReferenceById(id);
            return new ResponseEntity<>(new OrderCreationDto(
                    order.getOrderStatus(),
                    order.getOrderCreatedAt(),
                    order.getInvoice()
            ), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> updateOrder(Long id, OrderCreationDto orderCreationDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteOrder(Long id) {
        return null;
    }
}

