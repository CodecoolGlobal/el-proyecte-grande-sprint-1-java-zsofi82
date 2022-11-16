package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.User;
import com.coodecool.pickyourspot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    ProductService productService;
    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable String id){
        return productService.getUserById(id);
    }



}
