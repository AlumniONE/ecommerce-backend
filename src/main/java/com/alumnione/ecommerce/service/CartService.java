package com.alumnione.ecommerce.service;

import com.alumnione.ecommerce.dto.CartReturnDto;

public interface CartService {
    CartReturnDto get(long id);
    CartReturnDto clean(long id);
    CartReturnDto addItem(long cartId, long cellId);
    CartReturnDto deleteItem(long cartId, long cellId);
}
