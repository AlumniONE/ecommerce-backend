package com.alumnione.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "users")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private String checkSum;

}
