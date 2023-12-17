package com.alumnione.ecommerce.model.payment.repository;

import com.alumnione.ecommerce.model.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
