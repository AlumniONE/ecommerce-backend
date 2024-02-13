package com.alumnione.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import com.alumnione.ecommerce.entity.Customer;
import com.alumnione.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alumnione.ecommerce.dto.CustomerDto;
import com.alumnione.ecommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<String> createUser(CustomerDto customerDto){
		
		Customer customer = new Customer();
		customer.setFirstName(customerDto.firstName());
		customer.setLastName(customerDto.lastName());
		customer.setEmail(customerDto.email());
		customer.setPassword(customerDto.password());
		customer.setAddress(customerDto.address());
		customer.setUserType(null);
		
		userRepository.save(customer);

		return new ResponseEntity<String>("Registry Completed", HttpStatus.OK);
	}

	public ResponseEntity<?> getUser(Long id){
		
		if(userRepository.existsById(id))
			return new ResponseEntity<Optional<Customer>>(userRepository.findById(id), HttpStatus.OK);
		
		return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> getAllUsers(){
		List<Customer> customers = userRepository.findAll();
		
		HttpStatus status = customers.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		
		return new ResponseEntity<List<Customer>>(customers, status);
	}

	@Override
	public ResponseEntity<?> updateUser(Long id, CustomerDto customerDto) {
		Customer customer = userRepository.findById(id).orElse(null);
		
		if(customer == null)
			return new ResponseEntity<String>("User not exist", HttpStatus.NOT_FOUND);
				
		customer.setFirstName(customerDto.firstName());
		customer.setLastName(customerDto.lastName());
		customer.setEmail(customerDto.email());
		customer.setPassword(customerDto.password());
		customer.setAddress(customerDto.address());
		customer.setUserType(customerDto.userType());
		
		userRepository.save(customer);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<String> deleteUser(Long id) {
		if(!userRepository.existsById(id))
			return new ResponseEntity<String>("User not exist", HttpStatus.NOT_FOUND);
		
		userRepository.deleteById(id);
		return new ResponseEntity<String>("User delete", HttpStatus.OK);
	}
}
