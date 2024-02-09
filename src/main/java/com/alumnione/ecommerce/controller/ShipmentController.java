package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.constan.EcommerceConstant;
import com.alumnione.ecommerce.entity.Shipment;
import com.alumnione.ecommerce.service.impl.ShipmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = EcommerceConstant.GENERIC_RESOURCE)
public class ShipmentController {

    private final ShipmentServiceImpl shipmentService;

    @PostMapping(path = EcommerceConstant.SHIPMENT_RESOURCE)
    ResponseEntity<Shipment> createShipment(@RequestBody Shipment shipment){
        return new ResponseEntity<>(shipmentService.createShipment(shipment), HttpStatus.CREATED);
    }
    @GetMapping(path = EcommerceConstant.SHIPMENT_RESOURCE)
    ResponseEntity<List<Shipment>> findAllShipments(){
        return new ResponseEntity<>(shipmentService.findAllShipments(), HttpStatus.OK);
    }
    @GetMapping(path = EcommerceConstant.SHIPMENT_RESOURCE+EcommerceConstant.RESOURCE_ID)
    ResponseEntity<Shipment> findShipmentById(@PathVariable Long id){
        return new ResponseEntity<>(shipmentService.findShipmentById(id), HttpStatus.FOUND);
    }
    @PutMapping(path = EcommerceConstant.SHIPMENT_RESOURCE+EcommerceConstant.RESOURCE_ID)
    ResponseEntity<Shipment> updateShipment(@PathVariable Long id, Shipment shipment){
        return new ResponseEntity<>(shipmentService.updateShipment(id, shipment), HttpStatus.OK);
    }
    @DeleteMapping(path = EcommerceConstant.SHIPMENT_RESOURCE+EcommerceConstant.RESOURCE_ID)
    ResponseEntity<String> deleteShipment(@PathVariable Long id){
        shipmentService.deleteShipment(id);
        return new ResponseEntity<>("Shipment deleted!", HttpStatus.NO_CONTENT);
    }
}
