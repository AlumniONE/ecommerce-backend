package com.alumnione.ecommerce.dto;

import com.alumnione.ecommerce.entity.Cart;
import com.alumnione.ecommerce.entity.Cellphone;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public record CartReturnDto(LocalDateTime lastUpdated, List<Cellphone> cellphones) {

    public CartReturnDto(Cart cart) {
        this(cart.getLastUpdated(), cart.getCellphones());
    }
}
