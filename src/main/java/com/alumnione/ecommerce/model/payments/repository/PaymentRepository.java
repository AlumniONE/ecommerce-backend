package com.alumnione.ecommerce.model.payments.repository;

import com.alumnione.ecommerce.model.payments.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
