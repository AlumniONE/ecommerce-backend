package com.alumnione.ecommerce.controller;

import com.alumnione.ecommerce.entity.Invoice;
import com.alumnione.ecommerce.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


import java.util.ArrayList;
import java.util.List;


// TODO: cambiar el valor de retorno por el valor correcto (DTO)
// TODO: agregar la validacion de los datos de entrada
// TODO: implementar la logica de negocio (crear un usuario)
// TODO: implementar la logica de persistencia (guardar el usuario en la base de datos)
// TODO: implementar la logica de respuesta (retornar el usuario creado)
// TODO: agregar el manejo de excepciones
// TODO: agregar el manejo de errores



@RestController
@RequestMapping("/invoice")// TODO: cambiar el nombre del recurso
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public ArrayList<Invoice> getInvoices(){
        return this.invoiceService.getInvoices();
    }

    @PostMapping
    public Invoice saveInvoice(@RequestBody Invoice invoice){
        return this.invoiceService.saveInvoice(invoice);
    }

    @GetMapping(path = "/{id}")
    public Optional<Invoice> getUserById(@PathVariable Long id){
        return this.invoiceService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Invoice updateInvoiceById(@RequestBody Invoice request, @PathVariable("id") Long id){
        return this.invoiceService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.invoiceService.deleteInvoice(id);

        if(ok){
           return "Invoice with id" + id + "deleted";
        } else {
            return "Error, we have a problem and can't delete Invoice with id" + id;
        }

    }
}
