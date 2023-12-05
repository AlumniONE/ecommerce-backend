package com.alumnione.ecommerce.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<DataResponseUser> registerUser(@RequestBody @Valid DataRegisterUserDTO dataRegisterUserDTO, UriComponentsBuilder uriComponentsBuilder) {
        User user = userRepository.save(new User(dataRegisterUserDTO));
        URI url = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(url).body(new DataResponseUser(user));
    }

    @GetMapping
    public ResponseEntity<Page<DataListUser>> listUsers(@PageableDefault(size=2) Pageable pagination) {
        return ResponseEntity.ok(userRepository.findByActiveTrue(pagination).map(DataListUser::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataResponseUser> updateUser(@RequestBody @Valid DataUpdateUserDTO dataUpdateUserDTO) {
        User user = userRepository.getReferenceById(dataUpdateUserDTO.id());
        user.updateData(dataUpdateUserDTO);
        return ResponseEntity.ok(new DataResponseUser(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUser(@PathVariable Long id) {
        User user = userRepository.getReferenceById(id);
        user.disableUser();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseUser> getUser(@PathVariable Long id) {
        User user = userRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataResponseUser(user));
    }

}