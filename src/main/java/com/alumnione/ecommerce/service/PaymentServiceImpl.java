package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.PaymentDto;
import com.alumnione.ecommerce.entity.Payment;
import com.alumnione.ecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements CrudService<PaymentDto, Payment> {

    private final PaymentRepository paymentRepository;

    @Override
    public ResponseEntity<String> create(PaymentDto paymentDto) {
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
    public ResponseEntity<String> update(Long id, PaymentDto paymentDto) {
        if (paymentRepository.existsById(id)) {
            Payment payment = paymentRepository.getReferenceById(id);
            payment.setPaymentType(paymentDto.paymentType());
            paymentRepository.save(payment);
            return new ResponseEntity<>("Payment method was updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Payment method not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return new ResponseEntity<>("Payment method deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Bad Request, payment method not found", HttpStatus.NOT_FOUND);

    }

    @Override
    public ResponseEntity<Page<Payment>> getAll(Pageable pageable) {
        return new ResponseEntity<>(paymentRepository.findAll(pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PaymentDto> findById(Long id) {
        if (id > 0 && paymentRepository.existsById(id)) {
            var payment = paymentRepository.getReferenceById(id);
            var paymentDto = PaymentDto.builder()
            .paymentType(payment.getPaymentType())
            .build();

            return new ResponseEntity<>(paymentDto, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
