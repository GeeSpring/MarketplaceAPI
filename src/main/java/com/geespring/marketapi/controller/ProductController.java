package com.geespring.marketapi.controller;

import com.geespring.marketapi.model.Product;
import com.geespring.marketapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "products")
@RequiredArgsConstructor
public class ProductController {

    /**
     * Represents the Product Service Provider
     */
    @Autowired
    private final ProductService service;

    /**
     * Fetches every {@link Product} from the database
     * @return a list of every {@link Product}
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    /**
     * Finds a {@link Product} with the associated product id
     * @param id
     * @return the {@link Product}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") final Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    /**
     * Adds a {@link Product} to the database
     * @param product
     * @return the product requested
     */
    @PostMapping("/")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        return new ResponseEntity<>(service.save(product), HttpStatus.OK);
    }

    /**
     * Updates the {@link Product} with the specified id details.
     * @param id
     * @param name
     * @param description
     * @param price
     */
    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") final Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String description, @RequestParam(required = false) Float price) {
        service.update(id, name, description, price);
    }

    /**
     * Deletes a {@link Product} from the database
     * @param id
     */
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") final Long id) {
        service.delete(id);
    }
}
