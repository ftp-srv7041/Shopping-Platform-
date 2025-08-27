
// controller/HomeController.java
package com.ecom.controller;
import com.ecom.entity.User;
import com.ecom.service.ProductService;
import com.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class HomeController {
    @Autowired private UserService userService;
    @Autowired private ProductService productService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }
    @GetMapping("/login") public String login() { return "login"; }
    @GetMapping("/register") public String register() { return "register"; }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/register?success";
    }
}

// Add other services and controllers similarly, changing Integer IDs to String IDs.
