package com.alumnione.ecommerce.entity;

import java.util.HashSet;
import java.util.Set;

import com.alumnione.ecommerce.enumeration.UserType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email()
    private String email;

    private String password;

    private String address;

    @Column(name = "user_type")
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new HashSet<>();

//  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false, orphanRemoval = true, fetch = FetchType.LAZY)
    private Cart cart;
}
