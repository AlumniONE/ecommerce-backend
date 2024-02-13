package com.alumnione.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alumnione.ecommerce.config.PathVariableConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alumnione.ecommerce.dto.CustomerDto;
import com.alumnione.ecommerce.service.UserService;

import jakarta.validation.Valid;

// TODO: agregar la validacion de los datos de entrada
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores
// TODO: aplicar toda la logica de programación en la capa de Servicios

@RestController
@RequiredArgsConstructor
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE) // TODO: cambiar el nombre del recurso
public class UserController {
	
	private final UserService userService;

    @PostMapping(path = PathVariableConfig.USER_RESOURCE)
    public ResponseEntity<String> createUser(@RequestBody @Valid CustomerDto customerDto, BindingResult bindingResult){
    	
    	if(bindingResult.hasErrors()) {
    		
    		List<ObjectError> errors = bindingResult.getAllErrors();
    		
    		Map<String, String> messages = new HashMap<>();
            for (ObjectError error : errors) {
                messages.put(error.getCode(), error.getDefaultMessage());
            }
            
    		return ResponseEntity.badRequest().body(messages.toString());
    	}
    	
    	return userService.createUser(customerDto);
    }

    @GetMapping(path = PathVariableConfig.USER_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping(path = PathVariableConfig.USER_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<?> updateUser(@PathVariable Long id,
    									@RequestBody @Valid CustomerDto customerDto,
    									BindingResult bindingResult) {
    		
    	if(bindingResult.hasErrors()) {
    		
    		List<ObjectError> errors = bindingResult.getAllErrors();
    		
    		Map<String, String> messages = new HashMap<>();
            for (ObjectError error : errors) {
                messages.put(error.getCode(), error.getDefaultMessage());
            }
            
    		return ResponseEntity.badRequest().body(messages.toString());
    	}
        return userService.updateUser(id, customerDto);
    }

    @DeleteMapping(path = PathVariableConfig.USER_RESOURCE+ PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping(path = PathVariableConfig.USER_RESOURCE)
    public ResponseEntity<?> getAllUsers() { // TODO: logicamente no es String V:
        return userService.getAllUsers();
    }

}
