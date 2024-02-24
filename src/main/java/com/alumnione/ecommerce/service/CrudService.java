package com.alumnione.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface CrudService<T,S> {
    ResponseEntity<String> create(T classDto)    ;

    ResponseEntity<String> update(Long id, T classDto);

    ResponseEntity<String> delete(Long id);

    ResponseEntity<Page<S>> getAll(Pageable pageable);

    ResponseEntity<T> findById(Long id);
}
