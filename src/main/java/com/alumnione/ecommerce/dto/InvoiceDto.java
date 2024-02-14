package com.alumnione.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record InvoiceDto(
        @NotNull(message = "Invoice date is required")
        LocalDateTime invoiceDate,
        @PositiveOrZero(message = "Total amount must be positive or zero")
        double totalAmount
) {
}
