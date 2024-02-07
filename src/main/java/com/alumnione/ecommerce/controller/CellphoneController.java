package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.constan.EcommerceConstant;
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

// TODO: agregar la validacion de los datos de entrada
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = EcommerceConstant.GENERIC_RESOURCE)
public class CellphoneController {

    @Autowired
    CellphoneService cellphoneService;

    @PostMapping(path = EcommerceConstant.CELLPHONE_RESOURCE)
    public ResponseEntity<Cellphone> createCellphone(@RequestBody @Valid CellphoneCreationDto cellphoneCreationDto, UriComponentsBuilder uriComponentsBuilder) {
        return cellphoneService.createCellphone(cellphoneCreationDto, uriComponentsBuilder);
    }

    @GetMapping(path = EcommerceConstant.CELLPHONE_RESOURCE+EcommerceConstant.RESOURCE_ID)
    public ResponseEntity<Object> getCellphoneById(@PathVariable Long id) {
        return cellphoneService.findByIdCellphone(id);
    }

    @PutMapping(path = EcommerceConstant.CELLPHONE_RESOURCE+EcommerceConstant.RESOURCE_ID)
    @Transactional
    public ResponseEntity<Object> updateCellphone(@PathVariable Long id, @RequestBody @Valid CellphoneDataUpdateDto cellphoneDataUpdateDto) {
        return cellphoneService.updateDataCellphone(id, cellphoneDataUpdateDto);
    }

    @DeleteMapping(path = EcommerceConstant.CELLPHONE_RESOURCE+EcommerceConstant.RESOURCE_ID)
    @Transactional
    public ResponseEntity<String> deleteCellphone(@PathVariable Long id) {
        return cellphoneService.deleteCellphone(id);
    }

    @GetMapping(path = EcommerceConstant.CELLPHONE_RESOURCE)
    public ResponseEntity<Page<Cellphone>> getAllCellphones(@PageableDefault(size = 10) Pageable pageable) {
        return cellphoneService.findAllCellphones(pageable);
    }
}
