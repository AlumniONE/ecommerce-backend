package com.alumnione.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cellphones")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cellphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    private String brand;

    private String model;

    private double price;

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

    private String battery;

    private String connectivity;

    private String color;

    private int stock;

    @Column(name = "launch_date")
    private String launchDate;

    private String image;
}
