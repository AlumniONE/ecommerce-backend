package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.constan.EcommerceConstant;
import com.alumnione.ecommerce.dto.OrderCreationDto;
import com.alumnione.ecommerce.entity.Order;
import com.alumnione.ecommerce.service.impl.OrderServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO: cambiar el valor de retorno por el valor correcto (DTO)
// TODO: agregar la validacion de los datos de entrada
// TODO: implementar la logica de negocio (crear un usuario) 
// TODO: implementar la logica de persistencia (guardar el usuario en la base de datos)
// TODO: implementar la logica de respuesta (retornar el usuario creado)
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores


@RestController
@RequiredArgsConstructor
@RequestMapping(path = EcommerceConstant.GENERIC_RESOURCE) // TODO: cambiar el nombre del recurso
public class OrderController {

    private final OrderServiceImpl orderService;

    @PostMapping(path = EcommerceConstant.ORDER_RESOURCE)
    public ResponseEntity<OrderCreationDto> createOrder(@RequestBody @Valid Order order) {

        return orderService.createOrder(order);
    }

    @GetMapping(path = EcommerceConstant.ORDER_RESOURCE+EcommerceConstant.RESOURCE_ID)
    public ResponseEntity<OrderCreationDto> getOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @PutMapping(path = EcommerceConstant.ORDER_RESOURCE+EcommerceConstant.RESOURCE_ID)
    public ResponseEntity<String> updateOrder(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping(path = EcommerceConstant.ORDER_RESOURCE+EcommerceConstant.RESOURCE_ID)
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        return null;
    }

    @GetMapping(path = EcommerceConstant.ORDER_RESOURCE)
    public ResponseEntity<?> getAllOrders() {
        return orderService.getAllOrder();
    }
}
