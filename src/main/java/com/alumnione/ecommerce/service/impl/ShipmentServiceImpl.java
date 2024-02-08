package com.alumnione.ecommerce.service.impl;

import com.alumnione.ecommerce.entity.Shipment;
import com.alumnione.ecommerce.repository.ShipmentRepository;
import com.alumnione.ecommerce.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class ShipmentServiceImpl implements ShipmentService {

    public ShipmentRepository shipmentRepository;
    @Override
    public Shipment createShipment(Shipment shipment) {
        if(shipment != null){
            return shipmentRepository.save(shipment);
        }
        return new Shipment();
    }

    @Override
    public List<Shipment> findAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment updateShipment(Long id, Shipment shipment) {
        if(shipmentRepository.existsById(id)){
            Shipment updShipment = shipmentRepository.getReferenceById(id);
            updShipment.setShipment_date(shipment.getShipment_date());
            updShipment.setAddress(shipment.getAddress());
            updShipment.setCity(shipment.getCity());
            updShipment.setState(shipment.getState());
            updShipment.setCountry(shipment.getCountry());
            updShipment.setZip_code(shipment.getZip_code());
            return shipmentRepository.save(updShipment);
        }
        return null;
    }

    @Override
    public void deleteShipment(Long id) {
        if (shipmentRepository.existsById(id))
            shipmentRepository.deleteById(id);
    }

    @Override
    public Shipment findShipmentById(Long id) {
        return shipmentRepository.findById(id).get();
    }
}
