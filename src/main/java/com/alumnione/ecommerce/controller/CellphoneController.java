package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.config.PathVariableConfig;
import com.alumnione.ecommerce.dto.CellphoneDto;
import com.alumnione.ecommerce.entity.Cellphone;
import com.alumnione.ecommerce.service.CellphoneServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE)
public class CellphoneController {

    private final CellphoneServiceImpl cellphoneService;

    @PostMapping(path = PathVariableConfig.CELLPHONE_RESOURCE)
    public ResponseEntity<String> createCellphone(@RequestBody @Valid CellphoneDto cellphoneDto) {
        return cellphoneService.create(cellphoneDto);
    }

    @GetMapping(path = PathVariableConfig.CELLPHONE_RESOURCE + PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<CellphoneDto> findById(@PathVariable Long id) {
        return cellphoneService.findById(id);
    }

    @GetMapping(path = PathVariableConfig.CELLPHONE_RESOURCE + "/getCellphoneById" + PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<Cellphone> getCellphoneById(@PathVariable Long id) {
        return cellphoneService.getCellphoneById(id);
    }

//    @GetMapping(path = PathVariableConfig.CELLPHONE_RESOURCE)
//    public ResponseEntity<List<Cellphone>> getAllCellphones() {
//        return cellphoneService.getAll();
//    }

    @PutMapping(path = PathVariableConfig.CELLPHONE_RESOURCE + PathVariableConfig.RESOURCE_ID)
    @Transactional
    public ResponseEntity<String> updateCellphone(@PathVariable Long id, @RequestBody @Valid CellphoneDto cellphoneDto) {
        return cellphoneService.update(id, cellphoneDto);
    }

    @DeleteMapping(path = PathVariableConfig.CELLPHONE_RESOURCE + PathVariableConfig.RESOURCE_ID)
    @Transactional
    public ResponseEntity<String> deleteCellphone(@PathVariable Long id) {
        return cellphoneService.delete(id);
    }

    @GetMapping(path = PathVariableConfig.CELLPHONE_RESOURCE + "/allCellphones")
    public ResponseEntity<Page<Cellphone>> getAllCellphones(@PageableDefault(size = 10) Pageable pageable) {
        return cellphoneService.findAllCellphones(pageable);
    }
}
