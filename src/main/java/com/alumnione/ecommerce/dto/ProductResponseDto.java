package com.alumnione.ecommerce.dto;

import com.alumnione.ecommerce.entity.Category;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;

@Builder
public record ProductResponseDto(
        Long id,
        String SKU,
        String brand,
        String description,
        float price,
        int stock,
        Category category,
        JsonNode features,
        String image) {
}
