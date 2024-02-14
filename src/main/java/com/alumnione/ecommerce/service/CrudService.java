package com.alumnione.ecommerce.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudService<T,S> {
    public ResponseEntity<String> create(T classDto);

    public ResponseEntity<String> update(Long id, T classDto);

    public ResponseEntity<String> delete(Long id);

    //TODO: Implement Pageable for all Service.
    public ResponseEntity<List<S>> getAll();

    public ResponseEntity<T> findById(Long id);
}
