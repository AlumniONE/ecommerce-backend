package com.alumnione.ecommerce.model.invoice.repository;

import com.alumnione.ecommerce.model.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
