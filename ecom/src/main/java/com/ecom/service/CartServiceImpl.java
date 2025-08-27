package com.ecom.service;

import com.ecom.entity.CartItem; // 'Cart' ko 'CartItem' se badal diya
import com.ecom.entity.Product;
import com.ecom.entity.User;
import com.ecom.repository.CartItemRepository;
import com.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired private ProductRepository productRepo;
    @Autowired private CartItemRepository cartItemRepo;

    @Override
    public CartItem addCart(String productId, String userId) {
        Product product = productRepo.findById(productId).orElse(null);
        User user = new User();
        user.setId(userId);

        if (product != null) {
            CartItem existingCartItem = cartItemRepo.findByProductIdAndUserId(productId, userId);
            if (existingCartItem != null) {
                existingCartItem.setQuantity(existingCartItem.getQuantity() + 1);
                return cartItemRepo.save(existingCartItem);
            } else {
                CartItem newCartItem = new CartItem();
                newCartItem.setProduct(product);
                newCartItem.setUser(user);
                newCartItem.setQuantity(1);
                return cartItemRepo.save(newCartItem);
            }
        }
        return null;
    }

    @Override
    public List<CartItem> getCartByUserId(String userId) {
        return cartItemRepo.findByUserId(userId);
    }
}
