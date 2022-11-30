package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    ProductService productService;

    private static final Gson gson = new Gson();

    @Autowired
    public ApiController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registerUser(@RequestBody AppUser appuser) {
        // TODO validate if username exists
        // TODO hash password
        // TODO implement storing user data
        if (appuser == null || appuser.getUsername().equals("")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gson.toJson("Invalid user data!"));
        }
        if (productService.registerUser(appuser)){
            return ResponseEntity.ok(gson.toJson("User is registered"));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(gson.toJson("User already exists!"));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody AppUser appUser) {

        // TODO implement logging in
        if (appUser == null || appUser.getUsername().equals("") || appUser.getPassword().equals("")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gson.toJson("Invalid username or password!"));
        }

        Optional<AppUser> potentialUser = productService.loginUser(appUser);
        if (potentialUser.isPresent()) {
            AppUser user = potentialUser.get();
            return ResponseEntity.ok(gson.toJson(user));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gson.toJson("Invalid username or password!"));
    }

}
