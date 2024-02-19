package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.config.PathVariableConfig;
import com.alumnione.ecommerce.dto.OrderDto;
import com.alumnione.ecommerce.entity.Order;
import com.alumnione.ecommerce.service.OrderServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: cambiar el valor de retorno por el valor correcto (DTO)
// TODO: agregar la validacion de los datos de entrada
// TODO: implementar la logica de negocio (crear un usuario) 
// TODO: implementar la logica de persistencia (guardar el usuario en la base de datos)
// TODO: implementar la logica de respuesta (retornar el usuario creado)
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE) // TODO: cambiar el nombre del recurso
public class OrderController {

    private final OrderServiceImpl orderService;

    @PostMapping(path = PathVariableConfig.ORDER_RESOURCE)
    public ResponseEntity<String> createOrder(@RequestBody @Valid OrderDto orderDto) {
        return orderService.create(orderDto);
    }

    @GetMapping(path = PathVariableConfig.ORDER_RESOURCE+PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @GetMapping(path = PathVariableConfig.ORDER_RESOURCE)
    public ResponseEntity<Page<Order>> getAllOrders(@PageableDefault(size = 10) Pageable pageable) {
        return orderService.getAll(pageable);
    }

    @DeleteMapping(path = PathVariableConfig.ORDER_RESOURCE+PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        return orderService.delete(id);
    }

    @PutMapping(path = PathVariableConfig.ORDER_RESOURCE+PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        return orderService.update(id,orderDto);
    }
}
