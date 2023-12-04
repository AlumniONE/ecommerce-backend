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
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<DataResponseOrder> createOrder(@RequestBody @Valid DataCreateOrderDTO dataCreateOrderDTO, UriComponentsBuilder uriComponentsBuilder) {
        Order order = orderRepository.save(new Order(dataCreateOrderDTO));
        URI url = uriComponentsBuilder.path("/orders/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(url).body(new DataResponseOrder(order));
    }

    @GetMapping
    public ResponseEntity<Page<DataListOrder>> listOrders(@PageableDefault(size=9) Pageable pagination) {
        return ResponseEntity.ok(orderRepository.findAll(pagination).map(DataListOrder::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataResponseOrder> updateOrder(@RequestBody @Valid DataUpdateOrderDTO dataUpdateOrderDTO) {
        Order order = orderRepository.getReferenceById(dataUpdateOrderDTO.id());
        order.updateData(dataUpdateOrderDTO);
        return ResponseEntity.ok(new DataResponseOrder(order));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteOrder(@PathVariable Long id) {
        Order order = orderRepository.getReferenceById(id);
        order.deleteOrder();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseOrder> getOrder(@PathVariable Long id) {
        Order order = orderRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataResponseOrder(order));
    }
}
