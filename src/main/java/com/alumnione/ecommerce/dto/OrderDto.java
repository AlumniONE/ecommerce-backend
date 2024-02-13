package com.alumnione.ecommerce.dto;

import com.alumnione.ecommerce.entity.Invoice;
import com.alumnione.ecommerce.enumeration.EOrderStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public record OrderDto(
        Long orderId,
        @NotBlank(message = "Order status is required")
        EOrderStatus orderStatus,
        @NotBlank(message = "Order created at is required")
        String orderCreatedAt,
        @NotBlank(message = "The invoice is required")
        Invoice invoice

){ }
