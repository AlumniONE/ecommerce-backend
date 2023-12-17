package com.alumnione.ecommerce.repository;

import com.alumnione.ecommerce.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
