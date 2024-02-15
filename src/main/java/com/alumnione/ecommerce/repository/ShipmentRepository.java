package com.alumnione.ecommerce.repository;

import com.alumnione.ecommerce.entity.Shipment;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment, Long> {
}
