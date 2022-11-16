package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.Table;
import com.coodecool.pickyourspot.model.User;
import com.coodecool.pickyourspot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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


    @PostMapping("/table/add")
    public void addTable(@RequestBody Table table){
        productService.addNewTable(table);
    }

    @PutMapping("/table/{id}/reservation/add")
    public void addReservation(@RequestBody HashMap<String, String> reservation, @PathVariable String id) throws IllegalAccessException {
        productService.addReservation(id, reservation);
    }





}
