package com.alumnione.ecommerce.controller;

import java.util.List;

import com.alumnione.ecommerce.config.PathVariableConfig;
import com.alumnione.ecommerce.entity.Customer;
import com.alumnione.ecommerce.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alumnione.ecommerce.dto.CustomerDto;

// TODO: agregar la validacion de los datos de entrada
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores
// TODO: aplicar toda la logica de programación en la capa de Servicios

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE) // TODO: cambiar el nombre del recurso
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @PostMapping(path = PathVariableConfig.USER_RESOURCE)
    public ResponseEntity<String> createUser(@RequestBody CustomerDto customerDto) {
        return customerService.create(customerDto);
    }

    @GetMapping(path = PathVariableConfig.USER_RESOURCE + PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping(path = PathVariableConfig.USER_RESOURCE)
    public ResponseEntity<List<Customer>> getAllProduct(){
        return customerService.getAll();
    }

    @DeleteMapping(path = PathVariableConfig.USER_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return customerService.delete(id);
    }

    @PutMapping(path = PathVariableConfig.USER_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> updateProduct (@PathVariable Long id, @RequestBody CustomerDto customerDto){
        return customerService.update(id,customerDto);
    }




}
