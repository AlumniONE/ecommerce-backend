package com.alumnione.ecommerce.service.impl;

import com.alumnione.ecommerce.dto.PaymentDto;
import com.alumnione.ecommerce.entity.Payment;
import com.alumnione.ecommerce.repository.PaymentRepository;
import com.alumnione.ecommerce.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

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
    public ResponseEntity<String> updatePayment(Long id, PaymentDto paymentDto) {
        if(paymentRepository.existsById(id)){
            Payment payment = paymentRepository.getReferenceById(id);
            payment.setPaymentType(paymentDto.paymentType());
            paymentRepository.save(payment);
            return new ResponseEntity<>("Payment method was updated", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Payment method not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deletePayment(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return new ResponseEntity<>("Payment method deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Bad Request, payment method not found", HttpStatus.NOT_FOUND);

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
            return new ResponseEntity<>("Bad Request, payment method not found", HttpStatus.NOT_FOUND);
        }
    }
}
