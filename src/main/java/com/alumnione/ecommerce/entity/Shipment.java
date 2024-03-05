package com.alumnione.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shipments")
@Builder
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipment_id;
    private LocalDate shipment_date = LocalDate.now();
    private String address;
    private String city;
    private String state;
    private String country;
    private String zip_code;
    private String checkSum;
}
