package com.alumnione.ecommerce.controller;

import java.util.Objects;
import java.util.Optional;

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
    public ResponseEntity<Cellphone> createCellphone(@RequestBody @Valid CellphoneCreationDto cellphoneCreationDto) {
        return ResponseEntity.ok(cellphoneService.createCellphone(cellphoneCreationDto));
    }

    @GetMapping("/{idCellphone}")
    public ResponseEntity<Optional<Cellphone>> getCellphoneById(@PathVariable Long idCellphone) {
        return  ResponseEntity.ok(cellphoneService.findByIdCellphone(idCellphone));

    }

    @PutMapping("/{idCellphone}")
    @Transactional
    public ResponseEntity<Cellphone> updateCellphone(@PathVariable Long idCellphone, @RequestBody @Valid CellphoneDataUpdateDto cellphoneDataUpdateDto) {
        Cellphone updatedCellphone = cellphoneService.updateDataCellphone(idCellphone, cellphoneDataUpdateDto);

        if (!Objects.isNull(updatedCellphone)) {
            return ResponseEntity.ok(updatedCellphone);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idCellphone}")
    @Transactional
    public void deleteCellphone(@PathVariable Long idCellphone) {
        cellphoneService.deleteCellphone(idCellphone);
    }

    @GetMapping("/allCellphone")
    public ResponseEntity<Page<Cellphone>> getAllCellphones(@PageableDefault(size=10) Pageable pageable) {
        return ResponseEntity.ok(cellphoneService.findAllCellphones(pageable));
    }
}
