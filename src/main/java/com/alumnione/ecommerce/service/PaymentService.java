package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.PaymentDto;
import com.alumnione.ecommerce.entity.Payment;
import com.alumnione.ecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public ResponseEntity<Payment> createPayment(Payment payment) {
        return new ResponseEntity<>(paymentRepository.save(payment), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getPayment(Long id) {
        return null;

    }

    @Override
    public ResponseEntity<PaymentDto> updatePayment(PaymentDto paymentDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> deletePayment(Long id) {
        paymentRepository.deleteById(id);
        return new ResponseEntity<>("Object Deleted", HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<String>> getAllPayments() {
        return new ResponseEntity<>(paymentRepository.findAll().stream().map(Payment::getPaymentType).toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Optional<Payment>> getPaymentById(Long id) {
        return new ResponseEntity<>(paymentRepository.findById(id), HttpStatus.OK);
    }
}
