package com.alumnione.ecommerce.entity;

import java.util.List;

import com.alumnione.ecommerce.entity.enums.EOrderStatus;
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
    private Long orderId;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private EOrderStatus orderStatus;

    @Column(name = "order_created_at")
    private String orderCreatedAt;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(
    name = "cellphones",
        joinColumns = @JoinColumn(name = "cellphoneId"),
        inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Cellphone> cellphonesId;

}
