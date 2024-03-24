package com.alumnione.ecommerce.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;

@Builder
public record ProductDto(
        String SKU,
        String brand,
        String description,
        float price,
        int stock,
        String category,
        JsonNode features,
        String image
        /*String checkSum*/) {
}
