package com.alumnione.ecommerce.dto;

import com.alumnione.ecommerce.entity.Cellphone;
import com.alumnione.ecommerce.entity.Invoice;
import com.alumnione.ecommerce.entity.User;
import com.alumnione.ecommerce.entity.enums.EOrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


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
