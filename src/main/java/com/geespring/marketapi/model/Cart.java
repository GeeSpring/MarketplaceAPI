package com.geespring.marketapi.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cart {

    /**
     * Represents the user id this product belongs to
     */
    private final Long userId;

    /**
     * Represents the product id
     */
    private final Long productId;

    /**
     * Represents the quantity of the product
     */
    private Integer quantity;
}
