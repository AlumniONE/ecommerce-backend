package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.InvoiceDto;
import com.alumnione.ecommerce.entity.Invoice;
import com.alumnione.ecommerce.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements CrudService<InvoiceDto, Invoice> {

    private final InvoiceRepository invoiceRepository;

    @Override
    public ResponseEntity<String> create(InvoiceDto invoiceDto) {
        if (invoiceDto != null) {
            var newInvoice = Invoice.builder()
            .invoiceDate(invoiceDto.invoiceDate())
            .totalAmount(invoiceDto.totalAmount())
            .build();

            invoiceRepository.save(newInvoice);

            return new ResponseEntity<>("Invoice Created", HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> update(Long id, InvoiceDto invoiceDto) {
        if (id > 0 && invoiceRepository.existsById(id)) {

            var invoiceUpdate = Invoice.builder()
            .id(id)
            .invoiceDate(invoiceDto.invoiceDate())
            .totalAmount(invoiceDto.totalAmount())
            .build();
            invoiceRepository.save(invoiceUpdate);

            return new ResponseEntity<>("Invoice Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invoice  can't be update", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        if (invoiceRepository.existsById(id) && id > 0) {
            invoiceRepository.deleteById(id);
            return new ResponseEntity<>("Invoice Deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("Does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Page<Invoice>> getAll(Pageable pageable) {
        if (!invoiceRepository.findAll().isEmpty()) return new ResponseEntity<>(invoiceRepository.findAll(pageable), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<InvoiceDto> findById(Long id) {
        if (id != null && id > 0 && invoiceRepository.existsById(id)) {
            var invoiceRefence = invoiceRepository.getReferenceById(id);

            var invoiceDto = InvoiceDto.builder()
            .invoiceDate(invoiceRefence.getInvoiceDate())
            .totalAmount(invoiceRefence.getTotalAmount())
            .build();

            return new ResponseEntity<>(invoiceDto, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
