package com.geespring.marketapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "product")
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
