package com.alumnione.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "carts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(
            name="cart_cell",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "cellphone_id")
    )
    private Set<Cellphone> cellphones;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @JsonIgnore //error (user -> order -> invoice) SQL Error: 1146, SQLState: 42S02, Table 'ecommerce_backend_local.invoice' doesn't exist
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;

}