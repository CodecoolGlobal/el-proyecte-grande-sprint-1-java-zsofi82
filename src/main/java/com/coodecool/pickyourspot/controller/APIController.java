package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.User;
import com.coodecool.pickyourspot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class APIController {
    ProductService productService;

    @Autowired
    public APIController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable String id){
        return productService.getUserById(id);
    }

    @GetMapping("/user/all")
    public List<User> getAllUsers(){
        return productService.getAllUsers();
    }



}
