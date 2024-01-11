package com.alumnione.ecommerce.dto;

import com.alumnione.ecommerce.entity.Cellphone;
import com.alumnione.ecommerce.entity.Invoice;
import com.alumnione.ecommerce.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreationDto{
        @NotBlank(message = "Order status is required")
        String orderStatus;
        @NotBlank(message = "Order created at is required")
        String orderCreatedAt;
        @NotBlank(message = "The invoice is required")
        Invoice invoice;
        //User user,
        //List<Cellphone> productId
}
