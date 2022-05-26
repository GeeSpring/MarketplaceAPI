package com.geespring.marketapi.service;

import com.geespring.marketapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    /**
     * Fetches all the products from the database
     * @return list of every single {@link Product}
     */
    public List<Product> getAllProducts() {
        return List.of(
                new Product(1L, "Hellcat", "Should have kept it.", 14.30f),
                new Product(2L, "Tesla", "Sounds like a pissed off electric toothbrush.", 12.14f)
        );
    }

    /**
     * Creates a {@link Product} and stores it into the database
     * @param product
     */
    public void create(final Product product) {

    }

    /**
     * Finds the {@link Product} with the specified id
     * @param id
     * @return the product
     */
    public Product findById(final Long id) {
        return null;
    }

    /**
     * Deletes the {@link Product} with the specified id.
     * @param id
     */
    public void delete(final Long id) {

    }
}
