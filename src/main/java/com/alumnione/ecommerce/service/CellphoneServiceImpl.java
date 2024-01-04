package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.CellphoneCreationDto;
import com.alumnione.ecommerce.dto.CellphoneDataUpdateDto;
import com.alumnione.ecommerce.entity.Cellphone;
import com.alumnione.ecommerce.repository.CellphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class CellphoneServiceImpl implements CellphoneService {

    @Autowired
    private CellphoneRepository cellphoneRepository;

    @Override
    public ResponseEntity<Cellphone> createCellphone(CellphoneCreationDto cellphoneCreationDto, UriComponentsBuilder uriComponentsBuilder) {
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

        Cellphone cellphoneCreated = cellphoneRepository.save(cellphone);
        URI url = uriComponentsBuilder.path("/cellphones/{id}").buildAndExpand(cellphoneCreated.getId()).toUri();

        return ResponseEntity.created(url).body(cellphoneCreated);
    }

    @Override
    public ResponseEntity<Page<Cellphone>> findAllCellphones(Pageable pageable) {
        return ResponseEntity.ok(cellphoneRepository.findAll(pageable));
    }

    @Override
    public ResponseEntity<Object> findByIdCellphone(Long id) {
        Cellphone cellphone = cellphoneRepository.findById(id).orElse(null);
        if (cellphone != null) {
            return ResponseEntity.ok(cellphone);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No cellphone found with ID: " + id);
        }
    }


    @Override
    public ResponseEntity<Object> updateDataCellphone(Long id, CellphoneDataUpdateDto cellphoneDataUpdateDto) {

        Cellphone cellphone = cellphoneRepository.findById(id).orElse(null);

        if (cellphone != null) {

            if (!cellphoneDataUpdateDto.brand().isBlank()) {
                cellphone.setBrand(cellphoneDataUpdateDto.brand());
            }
            if (!cellphoneDataUpdateDto.model().isBlank()) {
                cellphone.setModel(cellphoneDataUpdateDto.model());
            }
            if (cellphoneDataUpdateDto.price() != 0.0) {
                cellphone.setPrice(cellphoneDataUpdateDto.price());
            }
            if (!cellphoneDataUpdateDto.internalStorage().isBlank()) {
                cellphone.setInternalStorage(cellphoneDataUpdateDto.internalStorage());
            }
            if (!cellphoneDataUpdateDto.ramMemory().isBlank()) {
                cellphone.setRamMemory(cellphoneDataUpdateDto.ramMemory());
            }
            if (!cellphoneDataUpdateDto.operatingSystem().isBlank()) {
                cellphone.setOperatingSystem(cellphoneDataUpdateDto.operatingSystem());
            }
            if (!cellphoneDataUpdateDto.screenSize().isBlank()) {
                cellphone.setScreenSize(cellphoneDataUpdateDto.screenSize());
            }
            if (!cellphoneDataUpdateDto.screenResolution().isBlank()) {
                cellphone.setScreenResolution(cellphoneDataUpdateDto.screenResolution());
            }
            if (!cellphoneDataUpdateDto.mainCamera().isBlank()) {
                cellphone.setMainCamera(cellphoneDataUpdateDto.mainCamera());
            }
            if (!cellphoneDataUpdateDto.frontCamera().isBlank()) {
                cellphone.setFrontCamera(cellphoneDataUpdateDto.frontCamera());
            }
            if (!cellphoneDataUpdateDto.battery().isBlank()) {
                cellphone.setBattery(cellphoneDataUpdateDto.battery());
            }
            if (!cellphoneDataUpdateDto.connectivity().isBlank()) {
                cellphone.setConnectivity(cellphoneDataUpdateDto.connectivity());
            }
            if (!cellphoneDataUpdateDto.color().isBlank()) {
                cellphone.setColor(cellphoneDataUpdateDto.color());
            }
//            if ( cellphoneDataUpdateDto.stock() != 0 ) {  //posiblemente este dato se debe de disminuir automaticamente pero comento esta parte para lograr meterle un 0
//                cellphone.setStock( cellphoneDataUpdateDto.stock() );
//            }
            cellphone.setStock(cellphoneDataUpdateDto.stock());

            if (!cellphoneDataUpdateDto.launchDate().isBlank()) {
                cellphone.setLaunchDate(cellphoneDataUpdateDto.launchDate());
            }
            if (!cellphoneDataUpdateDto.image().isBlank()) {
                cellphone.setImage(cellphoneDataUpdateDto.image());
            }

            return ResponseEntity.status(HttpStatus.OK).body(cellphoneRepository.save(cellphone));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No cellphone found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<String> deleteCellphone(Long id) {

        if (cellphoneRepository.existsById(id)) {
            Cellphone cellphone = cellphoneRepository.getReferenceById(id);
            cellphoneRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("The cellphone with model '" + cellphone.getModel() + "' and brand '" + cellphone.getBrand() + "' has been deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No cellphone found with ID: " + id);
        }
    }
}