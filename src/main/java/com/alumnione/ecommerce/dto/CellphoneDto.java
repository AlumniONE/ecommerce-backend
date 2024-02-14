package com.alumnione.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder

public record CellphoneDto(
    @NotBlank(message = "Brand is required")
    @Size(max = 50, message = "Brand must not exceed 50 characters")
    String brand,

    @NotBlank(message = "Model is required")
    @Size(max = 100, message = "Model must not exceed 100 characters")
    String model,

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be positive or zero")
    Double price,
    
    @Size(max = 100, message = "Internal storage must not exceed 100 characters")
    String internalStorage,
    
    @Size(max = 100, message = "RAM memory must not exceed 100 characters")
    String ramMemory,

    @Size(max = 100, message = "Operating system must not exceed 100 characters")
    String operatingSystem,

    @Size(max = 50, message = "Screen size must not exceed 50 characters")
    String screenSize,

    @Size(max = 50, message = "Screen resolution must not exceed 50 characters")
    String screenResolution,

    @Size(max = 100, message = "Main camera description must not exceed 100 characters")
    String mainCamera,

    @Size(max = 100, message = "Front camera description must not exceed 100 characters")
    String frontCamera,

    @Size(max = 100, message = "Battery description must not exceed 100 characters")
    String battery,

    @Size(max = 100, message = "Connectivity description must not exceed 100 characters")
    String connectivity,

    @Size(max = 50, message = "Color must not exceed 50 characters")
    String color,

    @NotNull(message = "Stock is required")
    @PositiveOrZero(message = "Stock must be positive or zero")
    Integer stock,

    @Size(max = 20, message = "Launch date must not exceed 20 characters")
    String launchDate,

    @Size(max = 255, message = "Image URL must not exceed 255 characters")
    String image
) {}