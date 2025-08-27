package com.ecom.repository;

import com.ecom.entity.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository; // JpaRepository ki jagah MongoRepository
import java.util.List;

public interface CartItemRepository extends MongoRepository<CartItem, String> { // ID ab String hai

    // Hum user object ke andar uski ID se search karenge
    List<CartItem> findByUserId(String userId);

    // Hum product aur user dono ki ID se search karenge
    CartItem findByProductIdAndUserId(String productId, String userId);
}
