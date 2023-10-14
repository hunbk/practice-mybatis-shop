package com.hunbk.shop.dto.item;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartItemQuantityRequest {
    private Integer quantity;

    public CartItemQuantityRequest(Integer quantity) {
        this.quantity = quantity;
    }
}
