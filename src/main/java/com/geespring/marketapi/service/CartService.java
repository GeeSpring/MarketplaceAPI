package com.geespring.marketapi.service;

import com.geespring.marketapi.dto.cart.CartProductDTO;
import com.geespring.marketapi.model.Cart;
import com.geespring.marketapi.repository.CartRepository;
import com.geespring.marketapi.util.exceptions.DataNotFoundException;
import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    //TODO replace static id '1' with session user id

    /**
     * Represents the Cart Repository
     */
    @Autowired
    private final CartRepository repository;

    /**
     * Fetches a list of all products in the users cart
     * @return the list of products
     */
    public List<Cart> getCartProducts(final Long userId) {
        return ImmutableList.copyOf(repository.findCartsByUserId(userId));
    }

    /**
     * Adds the specified product id into the users cart
     * @param product
     */
    public Cart add(final Long userId, final CartProductDTO product) {
        final Optional<Cart> existing = repository.findCartWithProductId(userId, product.getProductId());
        if (existing.isPresent()) {
            return update(userId, product.getProductId(), existing.get().getQuantity() + product.getQuantity());
        }
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setProductId(product.getProductId());
        cart.setQuantity(product.getQuantity());
        return repository.save(cart);
    }

    /**
     * Updates the quantity of the {@link com.geespring.marketapi.model.Product} within the user's cart
     * @param userId
     * @param productId
     * @param quantity
     * @return the updated cart
     */
    @Transactional
    public Cart update(final Long userId, final Long productId, final Integer quantity) {
        Cart existing = repository.findCartWithProductId(userId, productId).orElseThrow(DataNotFoundException::new);
        if (quantity != null && !existing.getQuantity().equals(quantity)) {
            existing.setQuantity(quantity);
        }
        return existing;
    }

    /**
     * Deletes the specified product id from the users cart
     * @param productId
     */
    public void delete(final Long userId, final Long productId) {
        Cart cart = repository.findCartWithProductId(userId, productId).orElseThrow(DataNotFoundException::new);
        repository.delete(cart);
    }
}
