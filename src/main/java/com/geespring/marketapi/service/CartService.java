package com.geespring.marketapi.service;

import com.geespring.marketapi.dto.cart.CartProductDTO;
import com.geespring.marketapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    /**
     * Fetches all of the products from the database
     * @return the list of products
     */
    public List<Product> getCartProducts(final Long userId) {
        return List.of(
                new Product(1L, "Tesla", "Sounds like a pissed off electric toothbrush.", 14.0f)
        );
    }

    /**
     * Adds the specified product id into the users cart
     * @param product
     */
    public void add(final Long userId, final CartProductDTO product) {

    }

    /**
     * Deletes the specified product id from the users cart
     * @param productId
     */
    public void delete(final Long userId, final Long productId) {

    }
}
