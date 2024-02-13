package com.alumnione.ecommerce.controller;

import java.util.List;

import com.alumnione.ecommerce.config.PathVariableConfig;
import com.alumnione.ecommerce.dto.PaymentDto;
import com.alumnione.ecommerce.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO: agregar la validacion de los datos de entrada
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores
@RestController
@RequiredArgsConstructor
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE) // TODO: cambiar el nombre del recurso
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    @PostMapping(path = PathVariableConfig.PAYMENT_RESOURCE)
    public ResponseEntity<String> createPayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.createPayment(paymentDto);
    }

    @GetMapping(path = PathVariableConfig.PAYMENT_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PutMapping(path = PathVariableConfig.PAYMENT_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> updatePayment(@PathVariable Long id, @RequestBody PaymentDto paymentDto) {
        return paymentService.updatePayment(id,paymentDto);
    }

    @DeleteMapping(path = PathVariableConfig.PAYMENT_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        return paymentService.deletePayment(id);
    }
    @GetMapping(path = PathVariableConfig.PAYMENT_RESOURCE)
    public ResponseEntity<List<String>> getAllPayments() {
        return paymentService.getAllPayments();
    }
}
