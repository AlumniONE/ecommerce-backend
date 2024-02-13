package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.config.PathVariableConfig;
import com.alumnione.ecommerce.dto.OrderDto;
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
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE) // TODO: cambiar el nombre del recurso
public class OrderController {

    private final OrderServiceImpl orderService;

    @PostMapping(path = PathVariableConfig.ORDER_RESOURCE)
    public ResponseEntity<OrderDto> createOrder(@RequestBody @Valid Order order) {

        return orderService.createOrder(order);
    }

    @GetMapping(path = PathVariableConfig.ORDER_RESOURCE+PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @PutMapping(path = PathVariableConfig.ORDER_RESOURCE+PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> updateOrder(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping(path = PathVariableConfig.ORDER_RESOURCE+PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        return null;
    }

    @GetMapping(path = PathVariableConfig.ORDER_RESOURCE)
    public ResponseEntity<?> getAllOrders() {
        return orderService.getAllOrder();
    }
}
