package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.entity.Shipment;
import com.alumnione.ecommerce.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ShipmentServiceImpl implements CrudService<Shipment, Shipment> {

    public final ShipmentRepository shipmentRepository;

    @Override
    public ResponseEntity<String> create(Shipment shipment) {
        if (shipment != null) {
            shipmentRepository.save(shipment);
            return new ResponseEntity<>("Shipment Created", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Shipment>> getAll() {
        return new ResponseEntity<>(shipmentRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> update(Long id, Shipment shipment) {
        if (id > 0 && shipmentRepository.existsById(id)) {
            var shipmentUpdate = Shipment.builder()
            .shipment_id(id)
            .shipment_date(shipment.getShipment_date())
            .address(shipment.getAddress())
            .city(shipment.getCity())
            .state(shipment.getState())
            .country(shipment.getCountry())
            .zip_code(shipment.getZip_code())
            .build();

            shipmentRepository.save(shipmentUpdate);

            return new ResponseEntity<>("Shipment Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Shipment can't be update", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        if (shipmentRepository.existsById(id)) {
            shipmentRepository.deleteById(id);
            return new ResponseEntity<>("Shipment deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("Shipment can't be delete", HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<Shipment> findById(Long id) {
        if (id != null && id > 0 && shipmentRepository.existsById(id)) {
            return new ResponseEntity<>(shipmentRepository.getReferenceById(id), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
