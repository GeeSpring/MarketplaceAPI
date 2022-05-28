package com.geespring.marketapi.repository;

import com.geespring.marketapi.model.CartEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<CartEntry, Long> {

    @Query(value = "SELECT * FROM users_cart WHERE user_id = ?", nativeQuery = true)
    Iterable<CartEntry> findCartsByUserId(final Long userId);

    @Query(value = "SELECT * FROM users_cart WHERE user_id = ? AND product_id = ?", nativeQuery = true)
    Optional<CartEntry> findCartWithProductId(final Long userId, final Long productId);
}
