package com.geespring.marketapi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    /**
     * Represents the Product Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Represents the Product Name
     */
    @Column(name = "product_name")
    private String name;

    /**
     * Represents the Product Description
     */
    private String description;

    /**
     * Represents the Price of the Product
     */
    private Float price;

}
