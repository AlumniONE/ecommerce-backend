package com.alumnione.ecommerce.controller;

import java.util.List;

import com.alumnione.ecommerce.config.PathVariableConfig;
import com.alumnione.ecommerce.dto.PaymentDto;
import com.alumnione.ecommerce.entity.Payment;
import com.alumnione.ecommerce.service.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO: agregar la validacion de los datos de entrada
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE) // TODO: cambiar el nombre del recurso
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    @PostMapping(path = PathVariableConfig.PAYMENT_RESOURCE)
    public ResponseEntity<String> createPayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.create(paymentDto);
    }

    @GetMapping(path = PathVariableConfig.PAYMENT_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<PaymentDto> findById(@PathVariable Long id) {
        return paymentService.findById(id);
    }

    @PutMapping(path = PathVariableConfig.PAYMENT_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody PaymentDto paymentDto) {
        return paymentService.update(id,paymentDto);
    }

    @DeleteMapping(path = PathVariableConfig.PAYMENT_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        return paymentService.delete(id);
    }
    @GetMapping(path = PathVariableConfig.PAYMENT_RESOURCE)
    public ResponseEntity<Page<Payment>> getAllPayments(@PageableDefault(size = 10) Pageable pageable) {
        return paymentService.getAll(pageable);
    }
}
