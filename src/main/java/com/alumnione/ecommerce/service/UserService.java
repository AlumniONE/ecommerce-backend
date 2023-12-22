package com.alumnione.ecommerce.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alumnione.ecommerce.dto.UserCreationDto;
import com.alumnione.ecommerce.entity.User;
import com.alumnione.ecommerce.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public ResponseEntity<String> createUser(UserCreationDto userCreationDto){
		
		User user = new User();
		
		user.setFirstName(userCreationDto.firstName());
		user.setLastName(userCreationDto.lastName());
		user.setEmail(userCreationDto.email());
		user.setPassword(userCreationDto.password());
		user.setAddress(userCreationDto.address());
		user.setUserType(userCreationDto.userType());
		
		userRepository.save(user);
		
		return new ResponseEntity<String>("Registry Completed", HttpStatus.OK);
	}
	
	

}
