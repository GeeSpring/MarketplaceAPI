package com.geespring.marketapi.dto.cart;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CartProductDTO {

    /**
     * Represents the Cart Product ID
     */
    @Getter
    private final Long productId;

    /**
     * Represents the Cart Product Quantity
     */
    @Getter
    private final Integer quantity;
}
