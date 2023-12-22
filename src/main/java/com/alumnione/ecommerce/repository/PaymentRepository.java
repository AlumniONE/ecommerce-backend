package com.alumnione.ecommerce.repository;

import com.alumnione.ecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    public Long findById(long id);

}
