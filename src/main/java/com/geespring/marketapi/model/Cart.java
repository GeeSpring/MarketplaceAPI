package com.geespring.marketapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "users_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Represents the user id this product belongs to
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * Represents the product id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * Represents the quantity of the product
     */
    private Integer quantity;
}
