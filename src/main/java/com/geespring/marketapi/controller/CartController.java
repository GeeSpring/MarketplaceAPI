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
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(service.getCartProducts(), HttpStatus.OK);
    }

    /**
     * Adds the {@link Product} to the users cart
     * @param productDTO
     * @return http status ok
     */
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody final CartProductDTO productDTO) {
        service.add(productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes the {@link Product} from the users cart
     * @param productId
     * @return http status ok
     */
    @GetMapping("/remove/{productId}")
    public ResponseEntity<?> delete(@PathVariable("productId") final Long productId) {
        service.delete(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
