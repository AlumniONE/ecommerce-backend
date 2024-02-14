package com.alumnione.ecommerce.entity;

import java.util.List;

import com.alumnione.ecommerce.enumeration.EOrderStatus;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Orders")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private EOrderStatus orderStatus;

    @Column(name = "order_created_at")
    private String orderCreatedAt;

}
