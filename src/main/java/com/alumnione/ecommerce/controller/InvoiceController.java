package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.config.PathVariableConfig;
import com.alumnione.ecommerce.dto.InvoiceDto;
import com.alumnione.ecommerce.entity.Invoice;
import com.alumnione.ecommerce.service.InvoiceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE)
public class InvoiceController {

    private final InvoiceServiceImpl invoiceService;

    @PostMapping(path = PathVariableConfig.INVOICE_RESOURCE)
    public ResponseEntity<String> createInvoice(@RequestBody InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto);
    }

    @GetMapping(path = PathVariableConfig.INVOICE_RESOURCE + PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<InvoiceDto> findById(@PathVariable Long id) {
        return invoiceService.findById(id);
    }

    @GetMapping(path = PathVariableConfig.INVOICE_RESOURCE)
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return this.invoiceService.getAll();
    }

    @DeleteMapping(path = PathVariableConfig.INVOICE_RESOURCE + PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> deleteInvoice(@PathVariable Long id) {
        return invoiceService.delete(id);
    }

    @PutMapping(path = PathVariableConfig.INVOICE_RESOURCE + PathVariableConfig.RESOURCE_ID)
    public ResponseEntity<String> updateInvoiceById(@RequestBody InvoiceDto invoiceDto, @PathVariable Long id) {
        return invoiceService.update(id, invoiceDto);
    }
}
