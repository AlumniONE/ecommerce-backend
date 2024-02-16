package com.alumnione.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudService<T,S> {
    public ResponseEntity<String> create(T classDto);

    public ResponseEntity<String> update(Long id, T classDto);

    public ResponseEntity<String> delete(Long id);

    public ResponseEntity<Page<S>> getAll(Pageable pageable);

    public ResponseEntity<T> findById(Long id);
}
