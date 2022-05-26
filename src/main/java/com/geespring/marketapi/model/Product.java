package com.geespring.marketapi.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Product {

    /**
     * Represents the Product Id
     */
    private final Long id;

    /**
     * Represents the Product Name
     */
    private final String name;

    /**
     * Represents the Product Description
     */
    private final String description;

    /**
     * Represents the Price of the Product
     */
    private final Float price;

}
