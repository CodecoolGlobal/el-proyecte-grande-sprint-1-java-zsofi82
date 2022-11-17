package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping(value = "map")
    public String displayMap() {
        return "map";
    }

    @GetMapping(value = "registration")
    public String displayRegistration() {
        return "registration";
    }

    @PostMapping(value = "registration")
    public String handleRegistration(@ModelAttribute("user") AppUser appUser) {
        productService.addNewUser(appUser);
        return "redirect:";
    }

    @GetMapping(value= "login")
    public String displayLogin() {
        return "login";
    }

    //TODO: login user create session
    @PostMapping(value = "login")
    public String handleLogin(@RequestBody AppUser appUser) {
        return "redirect:";
    }

}
