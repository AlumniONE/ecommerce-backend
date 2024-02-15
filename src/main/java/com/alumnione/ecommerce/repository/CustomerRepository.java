package com.alumnione.ecommerce.repository;

import com.alumnione.ecommerce.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
