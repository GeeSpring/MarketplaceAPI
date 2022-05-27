package com.geespring.marketapi.service;

import com.geespring.marketapi.model.Product;
import com.geespring.marketapi.model.User;
import com.geespring.marketapi.repository.ProductRepository;
import com.geespring.marketapi.util.exceptions.DataNotFoundException;
import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public List<Product> getAll() {
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
     *
     * @param id
     * @param name
     * @param description
     * @param price
     */
    @Transactional
    public void update(final Long id, String name, String description, Float price) {
        Product existing = repository.findById(id).orElseThrow(DataNotFoundException::new);

        if (name != null && name.length() > 0 && !name.equalsIgnoreCase(existing.getName())) {
            existing.setName(name);
        }

        if (description != null && description.length() > 0 && !description.equalsIgnoreCase(existing.getDescription())) {
            existing.setDescription(description);
        }

        if (price != null && !existing.getPrice().equals(price)) {
            existing.setPrice(price);
        }
    }

    /**
     * Deletes the {@link Product} with the specified id.
     * @param id
     */
    public void delete(final Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else throw new IllegalStateException("Product with id " + id + " does not exist.");
    }
}
