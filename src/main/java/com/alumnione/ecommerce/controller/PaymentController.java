package com.alumnione.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import com.alumnione.ecommerce.entity.Payment;
import com.alumnione.ecommerce.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/payments") // TODO: cambiar el nombre del recurso
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/createPayment")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Payment>> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePayment(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        return paymentService.deletePayment(id);
    }
    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllPayments() {
        return paymentService.getAllPayments();
    }
}
