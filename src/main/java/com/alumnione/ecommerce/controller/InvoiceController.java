package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.constan.EcommerceConstant;
import com.alumnione.ecommerce.entity.Invoice;
import com.alumnione.ecommerce.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


import java.util.ArrayList;
import java.util.List;

// TODO: agregar la validacion de los datos de entrada
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores
@RestController
@RequestMapping(path = EcommerceConstant.GENERIC_RESOURCE)// TODO: cambiar el nombre del recurso
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(path = EcommerceConstant.INVOICE_RESOURCE)
    public ArrayList<Invoice> getInvoices(){
        return this.invoiceService.getInvoices();
    }

    @PostMapping(path = EcommerceConstant.INVOICE_RESOURCE)
    public Invoice saveInvoice(@RequestBody Invoice invoice){
        return this.invoiceService.saveInvoice(invoice);
    }

    @GetMapping(path = EcommerceConstant.INVOICE_RESOURCE+EcommerceConstant.RESOURCE_ID)
    public Optional<Invoice> getUserById(@PathVariable Long id){
        return this.invoiceService.getById(id);
    }

    @PutMapping(path = EcommerceConstant.INVOICE_RESOURCE+EcommerceConstant.RESOURCE_ID)
    public Invoice updateInvoiceById(@RequestBody Invoice request, @PathVariable("id") Long id){
        return this.invoiceService.updateById(request, id);
    }

    @DeleteMapping(path = EcommerceConstant.INVOICE_RESOURCE+EcommerceConstant.RESOURCE_ID)
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.invoiceService.deleteInvoice(id);

        if(ok){
           return "Invoice with id" + id + "deleted";
        } else {
            return "Error, we have a problem and can't delete Invoice with id" + id;
        }

    }
}
