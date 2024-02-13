package com.alumnione.ecommerce.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alumnione.ecommerce.dto.CustomerDto;


@Service
public interface UserService {
	
	public ResponseEntity<String> createUser(CustomerDto customerDto);
	
	public ResponseEntity<?> getUser(Long id);
	
	public ResponseEntity<?> getAllUsers();
	
	public ResponseEntity<?> updateUser(Long id, CustomerDto customerDto);
	
	public ResponseEntity<String> deleteUser(Long id);
	
}
