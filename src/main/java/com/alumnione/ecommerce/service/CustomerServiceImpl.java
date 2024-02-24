package com.alumnione.ecommerce.service;


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
                .address(customerDto.address())
                .phoneNumber(customerDto.phoneNumber())
                .build();
        customerRepository.save(newCustomer);

        return new ResponseEntity<>("Customer created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> update(Long id, CustomerDto customerDto) {
        /* var obj = customerRepository.getReferenceById(id);
        if (!id.equals(obj.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(obj.getFirstName().equalsIgnoreCase(customerDto.firstName())) obj.setFirstName(customerDto.firstName());
        if(obj.getLastName().equalsIgnoreCase(customerDto.lastName())) obj.setLastName(customerDto.lastName());
        if(obj.getEmail().equalsIgnoreCase(customerDto.email())) obj.setEmail(customerDto.email());
        if(obj.getPassword().equalsIgnoreCase(customerDto.password())) obj.setPassword(customerDto.password());
        if(obj.getAddress().equalsIgnoreCase(customerDto.address())) obj.setAddress(customerDto.address());
        if(obj.getPhoneNumber().equalsIgnoreCase(customerDto.phoneNumber())) obj.setPhoneNumber(customerDto.phoneNumber());
        customerRepository.save(obj);*/

        if(customerRepository.existsById(id)){

            Customer cstm = customerRepository.getReferenceById(id);
            cstm.setFirstName(customerDto.firstName());
            cstm.setLastName(customerDto.lastName());
            cstm.setEmail(customerDto.email());
            cstm.setPassword(customerDto.password());
            cstm.setAddress(customerDto.address());
            cstm.setPhoneNumber(customerDto.phoneNumber());
            customerRepository.save(cstm);

            return new ResponseEntity<>("Customer Updated", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Customer not found!", HttpStatus.NOT_FOUND );
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        if (customerRepository.existsById(id) && id > 0) {
            customerRepository.deleteById(id);
            return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("Customer can't be delete", HttpStatus.OK);

    }

    public ResponseEntity<Page<Customer>> getAll(Pageable pageable) {
        if (!customerRepository.findAll().isEmpty())
            return new ResponseEntity<>(customerRepository.findAll(pageable), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<CustomerDto> findById(Long id) {
        if (id != null && id > 0 && customerRepository.existsById(id)) {
            var customerReference = customerRepository.getReferenceById(id);
            CustomerDto customerDto = new CustomerDto(
                    customerReference.getId(),
                    customerReference.getFirstName(),
                    customerReference.getLastName(),
                    customerReference.getEmail(),
                    customerReference.getPassword(),
                    customerReference.getAddress(),
                    customerReference.getPhoneNumber()
            );
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
//            var customerDto = CustomerDto.builder()
//            .firstName(customerReference.getFirstName())
//            .lastName(customerReference.getLastName())
//            .email(customerReference.getEmail())
//            .password(customerReference.getPassword())
//            .phoneNumber(customerReference.getPhoneNumber())
//            .build();
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
