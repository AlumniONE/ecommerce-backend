package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.dto.CellphoneCreationDto;
import com.alumnione.ecommerce.dto.CellphoneDataUpdateDto;
import com.alumnione.ecommerce.entity.Cellphone;
import com.alumnione.ecommerce.service.CellphoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

// TODO: cambiar el valor de retorno por el valor correcto (DTO)
// TODO: agregar la validacion de los datos de entrada
// TODO: implementar la logica de negocio (crear un usuario) 
// TODO: implementar la logica de persistencia (guardar el usuario en la base de datos)
// TODO: implementar la logica de respuesta (retornar el usuario creado)
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores


@RestController
@RequestMapping("/cellphones")
public class CellphoneController {

    @Autowired
    CellphoneService cellphoneService;

    @PostMapping
    public ResponseEntity<Cellphone> createCellphone(@RequestBody @Valid CellphoneCreationDto cellphoneCreationDto, UriComponentsBuilder uriComponentsBuilder) {
        return cellphoneService.createCellphone(cellphoneCreationDto, uriComponentsBuilder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCellphoneById(@PathVariable Long id) {
        return cellphoneService.findByIdCellphone(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> updateCellphone(@PathVariable Long id, @RequestBody @Valid CellphoneDataUpdateDto cellphoneDataUpdateDto) {
        return cellphoneService.updateDataCellphone(id, cellphoneDataUpdateDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteCellphone(@PathVariable Long id) {
        return cellphoneService.deleteCellphone(id);
    }

    @GetMapping("/allCellphones")
    public ResponseEntity<Page<Cellphone>> getAllCellphones(@PageableDefault(size = 10) Pageable pageable) {
        return cellphoneService.findAllCellphones(pageable);
    }
}
