package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.config.PathVariableConfig;
import com.alumnione.ecommerce.entity.Shipment;
import com.alumnione.ecommerce.service.ShipmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE)
public class ShipmentController {

    private final ShipmentServiceImpl shipmentService;

    @PostMapping(path = PathVariableConfig.SHIPMENT_RESOURCE)
    ResponseEntity<String> createShipment(@RequestBody Shipment shipment){
        return shipmentService.create(shipment);
    }
    @GetMapping(path = PathVariableConfig.SHIPMENT_RESOURCE)
    ResponseEntity<List<Shipment>> findAllShipments(){
        return shipmentService.getAll();
    }
    @GetMapping(path = PathVariableConfig.SHIPMENT_RESOURCE+PathVariableConfig.RESOURCE_ID)
    ResponseEntity<Shipment> findShipmentById(@PathVariable Long id){
        return shipmentService.findById(id);
    }
    @PutMapping(path = PathVariableConfig.SHIPMENT_RESOURCE+PathVariableConfig.RESOURCE_ID)
    ResponseEntity<String> updateShipment(@PathVariable Long id, Shipment shipment){
        return shipmentService.update(id,shipment);
    }
    @DeleteMapping(path = PathVariableConfig.SHIPMENT_RESOURCE+PathVariableConfig.RESOURCE_ID)
    ResponseEntity<String> deleteShipment(@PathVariable Long id){
        return shipmentService.delete(id);
    }
}
