package com.geespring.marketapi.repository;

import com.geespring.marketapi.model.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    @Query(value = "SELECT * FROM users_cart WHERE user_id = ?", nativeQuery = true)
    Iterable<Cart> findCartsByUserId(final Long userId);

    @Query(value = "SELECT * FROM users_cart WHERE user_id = ? AND product_id = ?", nativeQuery = true)
    Optional<Cart> findCartWithProductId(final Long userId, final Long productId);
}
