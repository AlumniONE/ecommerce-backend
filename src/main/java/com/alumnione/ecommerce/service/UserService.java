package com.alumnione.ecommerce.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alumnione.ecommerce.dto.UserCreationDto;
import com.alumnione.ecommerce.entity.User;


@Service
public interface UserService {
	
	public ResponseEntity<String> createUser(UserCreationDto userCreationDto);
	
	public ResponseEntity<?> getUser(Long id);
	
	public ResponseEntity<?> getAllUsers();
	
	public ResponseEntity<?> updateUser(Long id, UserCreationDto userCreationDto);
	
	public ResponseEntity<String> deleteUser(Long id);
	
}
