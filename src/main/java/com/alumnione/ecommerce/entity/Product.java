package com.alumnione.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String SKU;
    private String brand;
    private String description;
    private float price;
    private int stock;

    @ManyToOne
    private Category category;

    @JsonRawValue
    @Column(name = "features", columnDefinition = "json")
    private String features; //Details and specifications of product

    private String image;
//    private String checkSum;
}
