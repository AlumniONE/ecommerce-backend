package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.CellphoneCreationDto;
import com.alumnione.ecommerce.dto.CellphoneDataUpdateDto;
import com.alumnione.ecommerce.entity.Cellphone;
import com.alumnione.ecommerce.repository.CellphoneRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CellphoneServiceImpl implements CellphoneService{

    @Autowired
    private CellphoneRepository cellphoneRepository;

    @Override
    public Cellphone createCellphone(CellphoneCreationDto cellphoneCreationDto) {
        Cellphone cellphone = new Cellphone();
        cellphone.setBrand(cellphoneCreationDto.brand());
        cellphone.setModel(cellphoneCreationDto.model());
        cellphone.setPrice(cellphoneCreationDto.price());
        cellphone.setInternalStorage(cellphoneCreationDto.internalStorage());
        cellphone.setRamMemory(cellphoneCreationDto.ramMemory());
        cellphone.setOperatingSystem(cellphoneCreationDto.operatingSystem());
        cellphone.setScreenSize(cellphoneCreationDto.screenSize());
        cellphone.setScreenResolution(cellphoneCreationDto.screenResolution());
        cellphone.setMainCamera(cellphoneCreationDto.mainCamera());
        cellphone.setFrontCamera(cellphoneCreationDto.frontCamera());
        cellphone.setBattery(cellphoneCreationDto.battery());
        cellphone.setConnectivity(cellphoneCreationDto.connectivity());
        cellphone.setColor(cellphoneCreationDto.color());
        cellphone.setStock(cellphoneCreationDto.stock());
        cellphone.setLaunchDate(cellphoneCreationDto.launchDate());
        cellphone.setImage(cellphoneCreationDto.image());
        return cellphoneRepository.save(cellphone);
    }

    @Override
    public Page<Cellphone> findAllCellphones(Pageable pageable) {
        return cellphoneRepository.findAll(pageable);
    }

    @Override
    public Optional<Cellphone> findByIdCellphone(Long id) {
        return cellphoneRepository.findById(id);
    }


    @Override
    public Cellphone updateDataCellphone(Long id, CellphoneDataUpdateDto cellphoneDataUpdateDto) {
        return cellphoneRepository.findById(id).map(cellphone -> {
            if (StringUtils.isNotBlank( cellphoneDataUpdateDto.brand())) {
                cellphone.setBrand( cellphoneDataUpdateDto.brand() );
            }
            if (StringUtils.isNotBlank( cellphoneDataUpdateDto.model())) {
                cellphone.setModel( cellphoneDataUpdateDto.model() );
            }
            if (cellphoneDataUpdateDto.price()  != 0.0 ) {
                cellphone.setPrice( cellphoneDataUpdateDto.price() );
            }
            if (StringUtils.isNotBlank( cellphoneDataUpdateDto.internalStorage())) {
                cellphone.setInternalStorage( cellphoneDataUpdateDto.internalStorage() );
            }
            if ( StringUtils.isNotBlank( cellphoneDataUpdateDto.ramMemory())) {
                cellphone.setRamMemory( cellphoneDataUpdateDto.ramMemory() );
            }
            if (StringUtils.isNotBlank( cellphoneDataUpdateDto.operatingSystem())) {
                cellphone.setOperatingSystem( cellphoneDataUpdateDto.operatingSystem() );
            }
            if ( StringUtils.isNotBlank( cellphoneDataUpdateDto.screenSize())) {
                cellphone.setScreenSize( cellphoneDataUpdateDto.screenSize() );
            }
            if ( StringUtils.isNotBlank( cellphoneDataUpdateDto.screenResolution())) {
                cellphone.setScreenResolution( cellphoneDataUpdateDto.screenResolution() );
            }
            if ( StringUtils.isNotBlank( cellphoneDataUpdateDto.mainCamera())) {
                cellphone.setMainCamera( cellphoneDataUpdateDto.mainCamera() );
            }
            if ( StringUtils.isNotBlank( cellphoneDataUpdateDto.frontCamera())) {
                cellphone.setFrontCamera( cellphoneDataUpdateDto.frontCamera() );
            }
            if (  StringUtils.isNotBlank( cellphoneDataUpdateDto.battery())) {
                cellphone.setBattery( cellphoneDataUpdateDto.battery() );
            }
            if (  StringUtils.isNotBlank( cellphoneDataUpdateDto.connectivity())) {
                cellphone.setConnectivity( cellphoneDataUpdateDto.connectivity() );
            }
            if (  StringUtils.isNotBlank( cellphoneDataUpdateDto.color()) ) {
                cellphone.setColor( cellphoneDataUpdateDto.color() );
            }
//            if ( cellphoneDataUpdateDto.stock() != 0 ) {  // problema de logica ya q no se si se resta automaticamente cuando se compra un telefono o uno hay q actualizar ese dato por lo comento esta parte para q logre ser 0
//                cellphone.setStock( cellphoneDataUpdateDto.stock() );
//            }
            cellphone.setStock( cellphoneDataUpdateDto.stock() );

            if (  StringUtils.isNotBlank( cellphoneDataUpdateDto.launchDate())) {
                cellphone.setLaunchDate( cellphoneDataUpdateDto.launchDate() );
            }
            if (  StringUtils.isNotBlank( cellphoneDataUpdateDto.image())) {
                cellphone.setImage( cellphoneDataUpdateDto.image() );
            }

            return cellphoneRepository.save(cellphone);
        }).orElseThrow();
    }
    @Override
    public void deleteCellphone(Long id) {
        cellphoneRepository.deleteById(id);
    }
}