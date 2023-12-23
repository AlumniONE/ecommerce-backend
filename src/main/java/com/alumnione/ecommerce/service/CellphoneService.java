package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.CellphoneCreationDto;
import com.alumnione.ecommerce.dto.CellphoneDataUpdateDto;
import com.alumnione.ecommerce.entity.Cellphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CellphoneService {

    Cellphone createCellphone(CellphoneCreationDto cellphoneCreationDto);
    Page<Cellphone>  findAllCellphones(Pageable pageable);

//    Page<CellphoneClosedView>  findAllCellphones(Pageable pageable);

//    CellphoneClosedView findByIdCellphone(Long id);
    Optional<Cellphone> findByIdCellphone(Long id);

    Cellphone updateDataCellphone(Long id, CellphoneDataUpdateDto cellphoneDataUpdateDto);

    void deleteCellphone(Long id);




}
