package com.alumnione.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import com.alumnione.ecommerce.dto.PaymentDto;
import com.alumnione.ecommerce.entity.Payment;
import com.alumnione.ecommerce.service.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO: agregar la validacion de los datos de entrada
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores


@RestController
@RequiredArgsConstructor
@RequestMapping("/payments") // TODO: cambiar el nombre del recurso
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    @PostMapping("/createPayment")
    public ResponseEntity<String> createPayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.createPayment(paymentDto);
    }

    @GetMapping("/findPayment/{id}")
    public ResponseEntity<String> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PutMapping("/updatePayment/{id}")
    public ResponseEntity<String> updatePayment(@PathVariable Long id, @RequestBody PaymentDto paymentDto) {
        return paymentService.updatePayment(id,paymentDto);
    }

    @DeleteMapping("/deletePayment/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        return paymentService.deletePayment(id);
    }
    @GetMapping("/getAllPayment")
    public ResponseEntity<List<String>> getAllPayments() {
        return paymentService.getAllPayments();
    }
}
