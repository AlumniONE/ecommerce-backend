package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.PaymentDto;
import com.alumnione.ecommerce.entity.Payment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IPaymentService {

    public ResponseEntity<Payment> createPayment(Payment paymentDto);
    public ResponseEntity<String> getPayment(Long id);
    public ResponseEntity<PaymentDto> updatePayment(PaymentDto paymentDto);
    public ResponseEntity<?> deletePayment(Long id);
    public ResponseEntity<List<String>> getAllPayments();
    public ResponseEntity<Optional<Payment>> getPaymentById(Long id);


}
