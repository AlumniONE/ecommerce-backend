package com.alumnione.ecommerce.dto;

import com.alumnione.ecommerce.entity.Invoice;
import com.alumnione.ecommerce.enumeration.EOrderStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


public record OrderCreationDto(
        @Getter
        Long orderId,
        @Getter @Setter
        @NotBlank(message = "Order status is required")
        EOrderStatus orderStatus,
        @Getter @Setter
        @NotBlank(message = "Order created at is required")
        String orderCreatedAt,
        @Getter @Setter
        @NotBlank(message = "The invoice is required")
        Invoice invoice
        //User user,
        //@Getter @Setter
        //List<Cellphone> productId
){ }
