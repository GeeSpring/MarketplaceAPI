package com.geespring.marketapi.controller;

import com.geespring.marketapi.dto.cart.CartProductDTO;
import com.geespring.marketapi.model.Cart;
import com.geespring.marketapi.model.Product;
import com.geespring.marketapi.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
@RequiredArgsConstructor
public class CartController {

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
    public ResponseEntity<List<Product>> getProducts() {//TODO find the user by session token and append it to the service.
        return new ResponseEntity<>(service.getCartProducts(1L), HttpStatus.OK);
    }

    /**
     * Adds the {@link Product} to the users cart
     * @param productDTO
     * @return {@link HttpStatus#OK}
     */
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody final CartProductDTO productDTO) {//TODO find the user by session token and append it to the service
        service.add(1L, productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes the {@link Product} from the users cart
     * @param productId
     * @return {@link HttpStatus#OK}
     */
    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<?> delete(@PathVariable("productId") final Long productId) {//TODO find the user by session token and append it to service
        service.delete(1L, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
