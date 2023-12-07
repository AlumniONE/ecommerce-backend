package com.alumnione.ecommerce.model.invoice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

public record InvoiceCreationDto(
        @NotNull(message = "Invoice date is required")
        LocalDateTime invoiceDate,
        @PositiveOrZero(message = "Total amount must be positive or zero")
        double totalAmount
) {
}
