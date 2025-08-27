package com.ecom.controller;

import com.ecom.entity.User;
import com.ecom.repository.UserRepository;
import com.ecom.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.security.Principal;

@Controller
public class CartController {
    @Autowired private UserRepository userRepo;
    @Autowired private CartService cartService;

    @GetMapping("/addCart/{productId}")
    // Yahan Integer ko String se badal diya hai
    public String addCart(@PathVariable String productId, Principal p) {
        if (p == null) {
            return "redirect:/login";
        }
        User user = userRepo.findByEmail(p.getName());

        // Ab dono IDs (productId aur user.getId()) String hain
        cartService.addCart(productId, user.getId());

        return "redirect:/";
    }
}
