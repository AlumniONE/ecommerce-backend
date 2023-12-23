package com.alumnione.ecommerce.dto;

public record CellphoneDataUpdateDto(
        String brand,
        String model,
        Double price,
        String internalStorage,
        String ramMemory,
        String operatingSystem,
        String screenSize,
        String screenResolution,
        String mainCamera,
        String frontCamera,
        String battery,
        String connectivity,
        String color,
        Integer stock,
        String launchDate,
        String image
) {
}
