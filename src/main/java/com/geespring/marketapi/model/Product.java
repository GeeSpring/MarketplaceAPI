package com.geespring.marketapi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@RequiredArgsConstructor
public class Product {

    /**
     * Represents the Product Id
     */
    @Id
    @Getter
    private final Long id;

    /**
     * Represents the Product Name
     */
    @Getter
    @Column(name = "product_name")
    private final String name;

    /**
     * Represents the Product Description
     */
    @Getter
    private final String description;

    /**
     * Represents the Price of the Product
     */
    @Getter
    private final Float price;

}
