package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.AppUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/registration")
    public void registerUser(@RequestBody AppUser appuser) {

        // TODO validate if username exists
        // TODO hash password
        // TODO implement storing user data

        System.out.println(appuser);
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody AppUser appuser) {

        // TODO implement storing user data
        // TODO implement logging in
        System.out.println(appuser);
    }



}
