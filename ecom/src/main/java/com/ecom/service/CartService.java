package com.ecom.service;

import com.ecom.entity.CartItem; // 'Cart' ko 'CartItem' se badal diya
import java.util.List;

public interface CartService {
    CartItem addCart(String productId, String userId); // 'Cart' ko 'CartItem' se badal diya
    List<CartItem> getCartByUserId(String userId); // 'Cart' ko 'CartItem' se badal diya
}
