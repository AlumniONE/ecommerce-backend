package com.alumnione.ecommerce.dto;

import lombok.Builder;

@Builder
public record ProductDto(String SKU, String descripion, float price, int stock) {
}
