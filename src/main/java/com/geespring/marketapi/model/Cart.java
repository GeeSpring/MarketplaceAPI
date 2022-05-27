package com.geespring.marketapi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
public class Cart {

    /**
     * Represents the user id this product belongs to
     */
    @Id
    @Getter
    private final Long userId;

    /**
     * Represents the product id
     */
    @Getter
    private final Long productId;

    /**
     * Represents the quantity of the product
     */
    @Getter
    private Integer quantity;
}
