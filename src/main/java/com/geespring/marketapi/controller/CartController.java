package com.geespring.marketapi.controller;

import com.geespring.marketapi.dto.cart.CartEntryDTO;
import com.geespring.marketapi.model.CartEntry;
import com.geespring.marketapi.model.Product;
import com.geespring.marketapi.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cart")
@RequiredArgsConstructor
public class CartController {

    //TODO replace magic 1L userid with a session id

    /**
     * Represents the Cart Service Provider
     */
    @Autowired
    private final CartService service;

    /**
     * Retrieves every {@link Product} in the users cart
     * @return the list of products
     */
    @GetMapping
    public ResponseEntity<Iterable<CartEntry>> getProducts() {//TODO find the user by session token and append it to the service.
        return new ResponseEntity<>(service.getAllProducts(1L), HttpStatus.OK);
    }

    /**
     * Adds the {@link Product} to the users cart
     * @param productDTO
     * @return {@link HttpStatus#OK}
     */
    @PostMapping
    public ResponseEntity<?> add(@RequestBody final CartEntryDTO productDTO) {//TODO find the user by session token and append it to the service
        service.addProduct(1L, productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Updates the quantity of the {@link Product} within the users cart
     * @param productId
     * @param entry
     * @return {@link HttpStatus#OK}
     */
    @PutMapping(value = "{productId}")
    public ResponseEntity<?> update(@PathVariable("productId") final Long productId, @RequestBody final CartEntryDTO entry) {
        service.updateQuantity(1L, entry);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes the {@link Product} from the users cart
     * @param productId
     * @return {@link HttpStatus#OK}
     */
    @DeleteMapping("{productId}")
    public ResponseEntity<?> delete(@PathVariable("productId") final Long productId) {//TODO find the user by session token and append it to service
        service.removeProduct(1L, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
