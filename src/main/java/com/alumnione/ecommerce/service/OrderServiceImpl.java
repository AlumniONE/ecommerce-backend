package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.OrderDto;
import com.alumnione.ecommerce.entity.Order;
import com.alumnione.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements CrudService<OrderDto, Order> {

    private final OrderRepository orderRepository;

    @Override
    public ResponseEntity<String> create(OrderDto orderDto) {
        if (orderDto != null) {
            var newOrder = Order.builder()
            .orderStatus(orderDto.orderStatus())
            .orderCreatedAt(orderDto.orderCreatedAt())
            .build();

            orderRepository.save(newOrder);

            return new ResponseEntity<>("Order Created", HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> update(Long id, OrderDto orderDto) {
        if (id > 0 && orderRepository.existsById(id)) {

            var orderUpdate = Order.builder()
            .id(id)
            .orderStatus(orderDto.orderStatus())
            .orderCreatedAt(orderDto.orderCreatedAt())
            .build();
            orderRepository.save(orderUpdate);

            return new ResponseEntity<>("Order Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Order can't be update", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        if (orderRepository.existsById(id) && id > 0) {
            orderRepository.deleteById(id);
            return new ResponseEntity<>("Order Deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("Does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Page<Order>> getAll(Pageable pageable) {
        if (!orderRepository.findAll().isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(orderRepository.findAll(pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDto> findById(Long id) {
        if (id != null && id > 0 && orderRepository.existsById(id)) {
            var orderReference = orderRepository.getReferenceById(id);

            var orderDto = OrderDto.builder()
            .orderStatus(orderReference.getOrderStatus())
            .orderCreatedAt(orderReference.getOrderCreatedAt())
            .build();

            return new ResponseEntity<>(orderDto, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}

