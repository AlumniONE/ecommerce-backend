package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.config.PathVariableConfig;
import com.alumnione.ecommerce.entity.Invoice;
import com.alumnione.ecommerce.service.InvoiceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

// TODO: agregar la validacion de los datos de entrada
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores
@RestController
@RequiredArgsConstructor
@RequestMapping(path = PathVariableConfig.GENERIC_RESOURCE)// TODO: cambiar el nombre del recurso
public class InvoiceController {

    private final InvoiceServiceImpl invoiceServiceImpl;

    @GetMapping(path = PathVariableConfig.INVOICE_RESOURCE)
    public ArrayList<Invoice> getInvoices(){
        return this.invoiceServiceImpl.getInvoices();
    }

    @PostMapping(path = PathVariableConfig.INVOICE_RESOURCE)
    public Invoice saveInvoice(@RequestBody Invoice invoice){
        return this.invoiceServiceImpl.saveInvoice(invoice);
    }

    @GetMapping(path = PathVariableConfig.INVOICE_RESOURCE+PathVariableConfig.RESOURCE_ID)
    public Optional<Invoice> getUserById(@PathVariable Long id){
        return this.invoiceServiceImpl.getById(id);
    }

    @PutMapping(path = PathVariableConfig.INVOICE_RESOURCE+PathVariableConfig.RESOURCE_ID)
    public Invoice updateInvoiceById(@RequestBody Invoice request, @PathVariable("id") Long id){
        return this.invoiceServiceImpl.updateById(request, id);
    }

    @DeleteMapping(path = PathVariableConfig.INVOICE_RESOURCE+PathVariableConfig.RESOURCE_ID)
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.invoiceServiceImpl.deleteInvoice(id);

        if(ok){
           return "Invoice with id" + id + "deleted";
        } else {
            return "Error, we have a problem and can't delete Invoice with id" + id;
        }

    }
}
