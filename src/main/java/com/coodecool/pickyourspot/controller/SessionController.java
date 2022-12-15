package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SessionController {

    UserService userService;

    @Autowired
    public SessionController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@RequestBody AppUser appuser) {
        // TODO validate if username exists
        // TODO hash password
        // TODO implement storing user data
        if (appuser == null || appuser.getUsername().equals("")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user data!");
        }
        if (userService.registerUser(appuser)){
            return ResponseEntity.ok("User is registered");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AppUser appUser) {

        // TODO implement logging in
        if (appUser == null || appUser.getUsername().equals("") || appUser.getPassword().equals("")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid username or password!");
        }

        Optional<AppUser> potentialUser = userService.checkIfUserInDatabase(appUser);
        if (potentialUser.isPresent()) {
            AppUser user = potentialUser.get();
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid username or password!");
    }

}
