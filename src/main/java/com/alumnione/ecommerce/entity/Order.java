package com.alumnione.ecommerce.entity;

import java.util.List;

import com.alumnione.ecommerce.enumeration.EOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Orders")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(
    name = "order_cell",
        joinColumns = @JoinColumn(name = "cellphone_id"),
        inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Cellphone> cellphones;

}
