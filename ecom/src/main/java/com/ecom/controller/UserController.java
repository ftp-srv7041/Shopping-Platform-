// controller/UserController.java
package com.ecom.controller;
import com.ecom.entity.User;
import com.ecom.repository.UserRepository;
import com.ecom.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired private UserRepository userRepo;
    @Autowired private CartService cartService;

    @ModelAttribute
    public void commonData(Model model, Principal p) {
        if (p != null) {
            User user = userRepo.findByEmail(p.getName());
            model.addAttribute("user", user);
        }
    }

    @GetMapping("/cart")
    public String cart(Model model, Principal p) {
        User user = userRepo.findByEmail(p.getName());
        model.addAttribute("cartItems", cartService.getCartByUserId(user.getId()));
        return "user/cart";
    }
}