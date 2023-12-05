package com.alumnione.ecommerce.model.orders.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record OrderCreationDto(
  @NotNull(message = "productId is required")
  Long productId,

  @NotNull(message = "userId is required")
  Long userId,

  @NotBlank(message = "orderStatus is required")
  @Size(max = 20, message = "Order status must not exceed 20 characters") 
  String orderStatus,

  @NotNull(message = "orderCreatedAt is required")
  String orderCreatedAt
) {}
