package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.CellphoneCreationDto;
import com.alumnione.ecommerce.dto.CellphoneDataUpdateDto;
import com.alumnione.ecommerce.entity.Cellphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;


public interface CellphoneService {

    ResponseEntity<Cellphone> createCellphone(CellphoneCreationDto cellphoneCreationDto, UriComponentsBuilder uriComponentsBuilder);

    ResponseEntity<Page<Cellphone>> findAllCellphones(Pageable pageable);

//    Page<CellphoneClosedView>  findAllCellphones(Pageable pageable);

    //    CellphoneClosedView findByIdCellphone(Long id);
    ResponseEntity<Object> findByIdCellphone(Long id);

    ResponseEntity<Object> updateDataCellphone(Long id, CellphoneDataUpdateDto cellphoneDataUpdateDto);

    ResponseEntity<String> deleteCellphone(Long id);
}
