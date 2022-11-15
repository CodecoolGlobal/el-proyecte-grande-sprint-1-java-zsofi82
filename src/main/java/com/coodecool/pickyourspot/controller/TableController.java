package com.coodecool.pickyourspot.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TableController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping(value = "map")
    public String displayMap() {
        return "map";
    }

    @GetMapping(value= "registration")
    public String displayRegistration() {
        return "registration";
    }

    //TODO: add user
    @PostMapping(value = "registration")
    public String handleRegistration(@RequestBody User user) {
        return "redirect:";
    }

    @GetMapping(value= "login")
    public String displayLogin() {
        return "login";
    }

    //TODO: login user create session
    @PostMapping(value = "login")
    public String handleLogin(@RequestBody User user) {
        return "redirect:";
    }



}
