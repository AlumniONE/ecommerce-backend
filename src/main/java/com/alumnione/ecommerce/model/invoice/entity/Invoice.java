package com.alumnione.ecommerce.model.invoice.entity;

import com.alumnione.ecommerce.model.order.entity.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "invoice")
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_date")
    private LocalDateTime invoiceDate;

    @Column(name = "total_amount")
    private double totalAmount;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Order order;
        /*
    TODO: Agregar relacion con Payments
    private Long idPayment;
    */
}
