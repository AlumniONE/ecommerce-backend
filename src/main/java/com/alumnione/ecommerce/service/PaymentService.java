package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.PaymentDto;
import com.alumnione.ecommerce.entity.Payment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    public ResponseEntity<String> createPayment(PaymentDto paymentDto);
    public ResponseEntity<String> updatePayment(Long id, PaymentDto paymentDto);
    public ResponseEntity<?> deletePayment(Long id);
    public ResponseEntity<List<String>> getAllPayments();
    public ResponseEntity<String> getPaymentById(Long id);


}
