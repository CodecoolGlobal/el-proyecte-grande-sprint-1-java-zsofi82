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

    @GetMapping("/user/{userId}")
    public Optional<AppUser> getUserById(@PathVariable String userId){
        return productService.getUserById(userId);
    }

    @GetMapping("/user")
    public List<AppUser> getAllUsers(){
        return productService.getAllUsers();
    }

    @GetMapping("/table")
    public List<FoosballTable> getAllTable(){
        return productService.getAllTables();
    }

    @PostMapping("/table")
    public void addTable(@RequestBody FoosballTable foosballTable){
        productService.addNewTable(foosballTable);
    }

    @PostMapping("/table/{tableId}/reservation")
    public void addReservation(@RequestBody HashMap<String, String> reservation, @PathVariable String tableId) throws IllegalAccessException {
        productService.addReservation(tableId, reservation);
    }

    @DeleteMapping("/table/{tableId}/reservation")
    public void deleteReservation(@RequestBody HashMap<String, String> reservation, @PathVariable String tableId){
        productService.removeReservation(tableId,reservation);
    }

    @GetMapping("/table/free-tables/{dateTimeString}")
    public List<FoosballTable> getFreeTables(@PathVariable String dateTimeString){
        return productService.getFreeTables(dateTimeString);
    }




}
