package com.alumnione.ecommerce.service;

import java.util.List;
import com.alumnione.ecommerce.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.alumnione.ecommerce.dto.CustomerDto;
import com.alumnione.ecommerce.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CrudService<CustomerDto, Customer> {

    private final CustomerRepository customerRepository;

    public ResponseEntity<String> create(CustomerDto customerDto) {
        var newCustomer = Customer.builder()
        .firstName(customerDto.firstName())
        .lastName(customerDto.lastName())
        .email(customerDto.email())
        .password(customerDto.password())
        .phoneNumber(customerDto.phoneNumber())
        .build();
        customerRepository.save(newCustomer);

        return new ResponseEntity<>("Customer created", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> update(Long id, CustomerDto customerDto) {
        if (id > 0 && customerRepository.existsById(id)) {
            var customerUpdate = Customer.builder()
            .id(id)
            .firstName(customerDto.firstName())
            .lastName(customerDto.lastName())
            .email(customerDto.email())
            .password(customerDto.password())
            .phoneNumber(customerDto.phoneNumber())
            .build();
            customerRepository.save(customerUpdate);

            return new ResponseEntity<>("Customer Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        if (customerRepository.existsById(id) && id > 0) {
            customerRepository.deleteById(id);
            return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("Customer can't be delete", HttpStatus.OK);

    }

    public ResponseEntity<Page<Customer>> getAll(Pageable pageable) {
        if (!customerRepository.findAll().isEmpty()) return new ResponseEntity<>(customerRepository.findAll(pageable), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<CustomerDto> findById(Long id) {
        if (id != null && id > 0 && customerRepository.existsById(id)) {
            var customerReference = customerRepository.getReferenceById(id);

            var customerDto = CustomerDto.builder()
            .firstName(customerReference.getFirstName())
            .lastName(customerReference.getLastName())
            .email(customerReference.getEmail())
            .password(customerReference.getPassword())
            .phoneNumber(customerReference.getPhoneNumber())
            .build();

            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
