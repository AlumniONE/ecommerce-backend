package com.alumnione.ecommerce.entity;

import java.util.HashSet;
import java.util.Set;

import com.alumnione.ecommerce.enumeration.UserType;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Table(name = "users")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email()
    private String email;

    private String password;

    private String address;

    private String phoneNumber;

}
