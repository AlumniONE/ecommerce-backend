package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.entity.Invoice;
import com.alumnione.ecommerce.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public ArrayList<Invoice> getInvoices(){
        return (ArrayList<Invoice>) invoiceRepository.findAll();
    }

    public Invoice saveInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }

    public Optional<Invoice> getById(Long id){
        return invoiceRepository.findById(id);
    }

    public Invoice updateById(Invoice request, Long id){
        Invoice invoice = invoiceRepository.findById(id).get();

        invoice.setInvoiceDate(request.getInvoiceDate());
        invoice.setTotalAmount(request.getTotalAmount());
        invoice.setOrder(request.getOrder());

        return invoice;
    }

    public Boolean deleteInvoice(Long id){
        try{
            invoiceRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }




}
