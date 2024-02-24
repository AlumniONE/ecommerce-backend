package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.CellphoneDto;
import com.alumnione.ecommerce.entity.Cellphone;
import com.alumnione.ecommerce.repository.CellphoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CellphoneServiceImpl implements CrudService<CellphoneDto, Cellphone> {

    private final CellphoneRepository cellphoneRepository;

    @Override
    public ResponseEntity<String> create(CellphoneDto cellphoneDto) {
        if (cellphoneDto != null) {
            var newCellphone = Cellphone.builder()
            .brand(cellphoneDto.brand())
            .model(cellphoneDto.model())
            .price(cellphoneDto.price())
            .internalStorage(cellphoneDto.internalStorage())
            .ramMemory(cellphoneDto.ramMemory())
            .operatingSystem(cellphoneDto.operatingSystem())
            .screenSize(cellphoneDto.screenSize())
            .screenResolution(cellphoneDto.screenResolution())
            .mainCamera(cellphoneDto.mainCamera())
            .frontCamera(cellphoneDto.frontCamera())
            .battery(cellphoneDto.battery())
            .connectivity(cellphoneDto.connectivity())
            .color(cellphoneDto.color())
            .stock(cellphoneDto.stock())
            .launchDate(cellphoneDto.launchDate())
            .image(cellphoneDto.image())
            .build();

            cellphoneRepository.save(newCellphone);

            return new ResponseEntity<>("Cellphone Created", HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<String> update(Long id, CellphoneDto cellphoneDto) {
        if (id > 0 && cellphoneRepository.existsById(id)) {
            var cellphoneUpdate = Cellphone.builder()
            .id(id)
            .brand(cellphoneDto.brand())
            .model(cellphoneDto.model())
            .price(cellphoneDto.price())
            .internalStorage(cellphoneDto.internalStorage())
            .ramMemory(cellphoneDto.ramMemory())
            .operatingSystem(cellphoneDto.operatingSystem())
            .screenSize(cellphoneDto.screenSize())
            .screenResolution(cellphoneDto.screenResolution())
            .mainCamera(cellphoneDto.mainCamera())
            .frontCamera(cellphoneDto.frontCamera())
            .battery(cellphoneDto.battery())
            .connectivity(cellphoneDto.connectivity())
            .color(cellphoneDto.color())
            .stock(cellphoneDto.stock())
            .launchDate(cellphoneDto.launchDate())
            .image(cellphoneDto.image())
            .build();

            cellphoneRepository.save(cellphoneUpdate);

            return new ResponseEntity<>("Cellphone Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Cellphone can't be update", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        if (cellphoneRepository.existsById(id) && id > 0) {
            cellphoneRepository.deleteById(id);
            return new ResponseEntity<>("Cellphone Deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("Does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Page<Cellphone>> getAll(Pageable pageable){
        if (!cellphoneRepository.findAll().isEmpty()){
            return new ResponseEntity<>(cellphoneRepository.findAll(pageable), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<CellphoneDto> findById(Long id) {
        if (id != null && id > 0 && cellphoneRepository.existsById(id)) {
            var cellphoneRefence = cellphoneRepository.getReferenceById(id);

            var cellphoneDto = CellphoneDto.builder()
            .brand(cellphoneRefence.getBrand())
            .model(cellphoneRefence.getModel())
            .price(cellphoneRefence.getPrice())
            .internalStorage(cellphoneRefence.getInternalStorage())
            .ramMemory(cellphoneRefence.getRamMemory())
            .operatingSystem(cellphoneRefence.getOperatingSystem())
            .screenSize(cellphoneRefence.getScreenSize())
            .screenResolution(cellphoneRefence.getScreenResolution())
            .mainCamera(cellphoneRefence.getMainCamera())
            .frontCamera(cellphoneRefence.getFrontCamera())
            .battery(cellphoneRefence.getBattery())
            .connectivity(cellphoneRefence.getConnectivity())
            .color(cellphoneRefence.getColor())
            .stock(cellphoneRefence.getStock())
            .launchDate(cellphoneRefence.getLaunchDate())
            .image(cellphoneRefence.getImage())
            .build();

            return new ResponseEntity<>(cellphoneDto, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Cellphone> getCellphoneById(Long id) {
        if (id != null && id > 0 && cellphoneRepository.existsById(id)) return new ResponseEntity<>(cellphoneRepository.findById(id).orElse(null), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}