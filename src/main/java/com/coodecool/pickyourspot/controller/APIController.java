package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.model.FoosballTable;
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
    public Optional<AppUser> getUserById(@PathVariable String id){
        return productService.getUserById(id);
    }

    @GetMapping("/user/all")
    public List<AppUser> getAllUsers(){
        return productService.getAllUsers();
    }


    @PostMapping("/table/add")
    public void addTable(@RequestBody FoosballTable foosballTable){
        productService.addNewTable(foosballTable);
    }

    @PutMapping("/table/{id}/reservation/add")
    public void addReservation(@RequestBody HashMap<String, String> reservation, @PathVariable String id) throws IllegalAccessException {
        productService.addReservation(id, reservation);
    }

    @PutMapping("/table/{id}/reservation/delete")
    public void deleteReservation(@RequestBody HashMap<String, String> reservation, @PathVariable String id){
        productService.removeReservation(id,reservation);
    }

    @GetMapping("/table/free-tables/{dateTimeString}")
    public List<FoosballTable> getFreeTables(@PathVariable String dateTimeString){
        return productService.getFreeTables(dateTimeString);
    }




}
