package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.entity.Shipment;

import java.util.List;

public interface ShipmentService {

    public Shipment createShipment(Shipment shipment);
    public List<Shipment> findAllShipments();
    public Shipment updateShipment(Long id, Shipment shipment);
    public void deleteShipment(Long id);
    public Shipment findShipmentById(Long id);
}
