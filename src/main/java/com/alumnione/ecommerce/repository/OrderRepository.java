package com.alumnione.ecommerce.repository;

import com.alumnione.ecommerce.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
