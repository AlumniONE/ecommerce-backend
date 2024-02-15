package com.alumnione.ecommerce.repository;

import com.alumnione.ecommerce.entity.Payment;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    Long findById(long id);

}
