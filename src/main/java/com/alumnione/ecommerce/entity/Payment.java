package com.alumnione.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "payments")
@Entity(name = "Payment")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "payment_type")
    private String paymentType;

    @OneToOne(mappedBy = "payment")
    private Invoice invoice;
}
