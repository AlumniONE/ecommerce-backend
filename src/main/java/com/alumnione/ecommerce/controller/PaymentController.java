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
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping
    public ResponseEntity<DataResponsePayment> createPayment(@RequestBody @Valid DataCreatePaymentDTO dataCreatePaymentDTO, UriComponentsBuilder uriComponentsBuilder) {
        Payment payment = paymentRepository.save(new Payment(dataCreatePaymentDTO));
        URI url = uriComponentsBuilder.path("/payments/{id}").buildAndExpand(payment.getId()).toUri();
        return ResponseEntity.created(url).body(new DataResponsePayment(payment));
    }

    @GetMapping
    public ResponseEntity<Page<DataListPayment>> listPayments(@PageableDefault(size=9) Pageable pagination) {
        return ResponseEntity.ok(paymentRepository.findAll(pagination).map(DataListPayment::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataResponsePayment> updatePayment(@RequestBody @Valid DataUpdatePaymentDTO dataUpdatePaymentDTO) {
        Payment payment = paymentRepository.getReferenceById(dataUpdatePaymentDTO.id());
        payment.updateData(dataUpdatePaymentDTO);
        return ResponseEntity.ok(new DataResponsePayment(payment));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePayment(@PathVariable Long id) {
        Payment payment = paymentRepository.getReferenceById(id);
        payment.deletePayment();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponsePayment> getPayment(@PathVariable Long id) {
        Payment payment = paymentRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataResponsePayment(payment));
    }
}
