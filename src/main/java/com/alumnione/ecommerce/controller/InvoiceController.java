package com.alumnione.ecommerce.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @PostMapping
    public ResponseEntity<DataResponseInvoice> createInvoice(@RequestBody @Valid DataCreateInvoiceDTO dataCreateInvoiceDTO, UriComponentsBuilder uriComponentsBuilder) {
        Invoice invoice = invoiceRepository.save(new Invoice(dataCreateInvoiceDTO));
        URI url = uriComponentsBuilder.path("/invoices/{id}").buildAndExpand(invoice.getId()).toUri();
        return ResponseEntity.created(url).body(new DataResponseInvoice(invoice));
    }

    @GetMapping
    public ResponseEntity<Page<DataListInvoice>> listInvoices(@PageableDefault(size=9) Pageable pagination) {
        return ResponseEntity.ok(invoiceRepository.findAll(pagination).map(DataListInvoice::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataResponseInvoice> updateInvoice(@RequestBody @Valid DataUpdateInvoiceDTO dataUpdateInvoiceDTO) {
        Invoice invoice = invoiceRepository.getReferenceById(dataUpdateInvoiceDTO.id());
        invoice.updateData(dataUpdateInvoiceDTO);
        return ResponseEntity.ok(new DataResponseInvoice(invoice));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteInvoice(@PathVariable Long id) {
        Invoice invoice = invoiceRepository.getReferenceById(id);
        invoice.deleteInvoice();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseInvoice> getInvoice(@PathVariable Long id) {
        Invoice invoice = invoiceRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataResponseInvoice(invoice));
    }
}
