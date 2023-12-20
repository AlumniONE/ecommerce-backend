package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPaymentService {
    public ResponseEntity<List<Payment>> getAllPayments();
    public void savePayment(Payment payment);
    public ResponseEntity<Payment> getPayment(long id);
    public void deletePayment(long id);
    public ResponseEntity<Payment> updatePayment(Payment payment);
    Page<Payment> listByPage(long pageNum);
}
