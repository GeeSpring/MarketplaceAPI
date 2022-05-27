package com.geespring.marketapi.service;

import com.geespring.marketapi.model.Product;
import com.geespring.marketapi.repository.ProductRepository;
import com.geespring.marketapi.util.exceptions.DataNotFoundException;
import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    /**
     * Represents the {@link Product} repository
     */
    @Autowired
    private final ProductRepository repository;

    /**
     * Fetches all the products from the database
     * @return list of every single {@link Product}
     */
    public List<Product> getAllProducts() {
        return ImmutableList.copyOf(repository.findAll().iterator());
    }

    /**
     * Creates a {@link Product} and stores it into the database
     * @param product
     */
    public Product save(final Product product) {
        return repository.save(product);
    }

    /**
     * Finds the {@link Product} with the specified id
     * @param id
     * @return the product
     */
    public Product findById(final Long id) {
        return repository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    /**
     * Deletes the {@link Product} with the specified id.
     * @param id
     */
    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
