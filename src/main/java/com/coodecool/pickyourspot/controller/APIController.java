package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {
    @GetMapping("/get-user/{id}")
    public User getUserById(@PathVariable String id){
        return null;
    }
}
