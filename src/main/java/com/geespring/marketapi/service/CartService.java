package com.geespring.marketapi.service;

import com.geespring.marketapi.dto.cart.CartEntryDTO;
import com.geespring.marketapi.model.CartEntry;
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
    public Iterable<CartEntry> getAllProducts(final Long userId) {
        return repository.findCartsByUserId(userId);
    }

    /**
     * Adds the specified product id into the users cart
     * @param entry
     */
    public CartEntry addProduct(final Long userId, final CartEntryDTO entry) {
        final Optional<CartEntry> existing = repository.findCartWithProductId(userId, entry.getProductId());
        if (existing.isPresent()) {
            return updateQuantity(userId, entry);
        }
        CartEntry cartEntry = new CartEntry();
        cartEntry.setUserId(userId);
        cartEntry.setProductId(entry.getProductId());
        cartEntry.setQuantity(entry.getQuantity());
        return repository.save(cartEntry);
    }

    /**
     * Updates the quantity of the {@link com.geespring.marketapi.model.Product} within the user's cart
     * @param userId
     * @param entry
     * @return the updated cart
     */
    @Transactional
    public CartEntry updateQuantity(final Long userId, final CartEntryDTO entry) {
        CartEntry existing = repository.findCartWithProductId(userId, entry.getProductId()).orElseThrow(IllegalAccessError::new);
        existing.setQuantity(entry.getQuantity());
        return existing;
    }

    /**
     * Deletes the specified product id from the users cart
     * @param productId
     */
    public void removeProduct(final Long userId, final Long productId) {
        CartEntry cartEntry = repository.findCartWithProductId(userId, productId).orElseThrow(DataNotFoundException::new);
        repository.delete(cartEntry);
    }
}
