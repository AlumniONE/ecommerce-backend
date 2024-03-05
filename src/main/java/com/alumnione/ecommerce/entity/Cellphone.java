package com.alumnione.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "cellphones")
@Entity@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cellphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private Double price;

    @Column(name = "internal_storage")
    private String internalStorage;

    @Column(name = "ram_memory")
    private String ramMemory;

    @Column(name = "operating_system")
    private String operatingSystem;

    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "screen_resolution")
    private String screenResolution;

    @Column(name = "main_camera")
    private String mainCamera;

    @Column(name = "front_camera")
    private String frontCamera;

    @Column(name = "battery")
    private String battery;

    @Column(name = "connectivity")
    private String connectivity;

    @Column(name = "color")
    private String color;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "launch_date")
    private String launchDate;

    @Column(name = "image")
    private String image;

    private String checkSum;
}
