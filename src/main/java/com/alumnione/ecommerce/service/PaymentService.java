package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.entity.Payment;
import com.alumnione.ecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public ResponseEntity<List<Payment>> getAllPayments() {
        return new ResponseEntity<>(paymentRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public ResponseEntity<Payment> getPayment(long id) {
        if (!paymentRepository.existsById(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(paymentRepository.getReferenceById(id), HttpStatus.OK);
    }

    @Override
    public void deletePayment(long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Payment> updatePayment(Payment payment) {
        return null;
    }

    @Override
    public Page<Payment> listByPage(long pageNum) {
        return null;
    }
}
