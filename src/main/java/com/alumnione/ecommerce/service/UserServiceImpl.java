package com.alumnione.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alumnione.ecommerce.dto.UserCreationDto;
import com.alumnione.ecommerce.entity.User;
import com.alumnione.ecommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<String> createUser(UserCreationDto userCreationDto){
		
		User user = new User();		
		user.setFirstName(userCreationDto.firstName());
		user.setLastName(userCreationDto.lastName());
		user.setEmail(userCreationDto.email());
		user.setPassword(userCreationDto.password());
		user.setAddress(userCreationDto.address());
		user.setUserType(null);
		
		userRepository.save(user);

		return new ResponseEntity<String>("Registry Completed", HttpStatus.OK);
	}

	public ResponseEntity<?> getUser(Long id){
		
		if(userRepository.existsById(id))
			return new ResponseEntity<Optional<User>>(userRepository.findById(id), HttpStatus.OK);
		
		return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> getAllUsers(){
		List<User> users = userRepository.findAll();
		
		HttpStatus status = users.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		
		return new ResponseEntity<List<User>>(users, status);
	}

	@Override
	public ResponseEntity<?> updateUser(Long id, UserCreationDto userCreationDto) {
		User user = userRepository.findById(id).orElse(null);
		
		if(user == null)
			return new ResponseEntity<String>("User not exist", HttpStatus.NOT_FOUND);
				
		user.setFirstName(userCreationDto.firstName());
		user.setLastName(userCreationDto.lastName());
		user.setEmail(userCreationDto.email());
		user.setPassword(userCreationDto.password());
		user.setAddress(userCreationDto.address());
		user.setUserType(userCreationDto.userType());
		
		userRepository.save(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<String> deleteUser(Long id) {
		if(!userRepository.existsById(id))
			return new ResponseEntity<String>("User not exist", HttpStatus.NOT_FOUND);
		
		userRepository.deleteById(id);
		return new ResponseEntity<String>("User delete", HttpStatus.OK);
	}
}
