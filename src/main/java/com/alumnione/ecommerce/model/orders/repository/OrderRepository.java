package com.alumnione.ecommerce.model.orders.repository;

import com.alumnione.ecommerce.model.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
