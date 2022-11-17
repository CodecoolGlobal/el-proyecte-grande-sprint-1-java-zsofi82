package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    ProductService productService;

    @Autowired
    public UserController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/user/{userId}")
    public Optional<AppUser> getUserById(@PathVariable String userId){
        return productService.getUserById(userId);
    }

    @GetMapping("/user")
    public List<AppUser> getAllUsers(){
        return productService.getAllUsers();
    }
}
