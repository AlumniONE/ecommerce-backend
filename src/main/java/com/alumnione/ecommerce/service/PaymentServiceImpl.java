package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.PaymentDto;
import com.alumnione.ecommerce.entity.Payment;
import com.alumnione.ecommerce.repository.PaymentRepository;
import com.alumnione.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<String> createPayment(PaymentDto paymentDto) {
        if (!paymentDto.paymentType().isBlank()) {
            Payment payment = new Payment();
            payment.setPaymentType(paymentDto.paymentType());
            paymentRepository.save(payment);
            return new ResponseEntity<>("Payment Created", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Payment can't be blank", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<String> updatePayment(PaymentDto paymentDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> deletePayment(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return new ResponseEntity<>("Payment method deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Bad Request, payment method not found", HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<List<String>> getAllPayments() {
        return new ResponseEntity<>(paymentRepository.findAll().stream().map(Payment::getPaymentType).toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getPaymentById(Long id) {
        if (paymentRepository.existsById(id)) {
            var payment = paymentRepository.getReferenceById(id);
            return new ResponseEntity<>(payment.getPaymentType(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bad Request, payment method not found", HttpStatus.BAD_REQUEST);
        }
    }
}
