package com.alumnione.ecommerce.model.user.entity;

import java.util.HashSet;
import java.util.Set;

import com.alumnione.ecommerce.model.orders.entity.Order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long userId;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new HashSet<>();

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    private String address;

    @Column(name = "user_type")
    private String userType;

}
