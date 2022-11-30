package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;
import com.coodecool.pickyourspot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    ProductService productService;

    @Autowired
    public UserController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<AppUser> getUserById(@PathVariable String userId){
        Optional<AppUser> user = productService.getUserById(userId);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/user")
    public List<AppUser> getAllUsers(){
        return productService.getAllUsers();
    }

    @GetMapping("/user/{userId}/reservation")
    public List<FoosballTable> getReservedTables(@PathVariable String userId){
        return productService.getReservedTablesByUser(userId);
    }

    @GetMapping("/user/{userId}/reservation/{tableId}")
    public List<Reservation> getReservationsByTableIdAndUserId(@PathVariable String tableId, @PathVariable String userId){
        return productService.getReservationsByTableIdAndUserId(tableId,userId);
    }
}
