package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.service.UserService;
import com.coodecool.pickyourspot.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    UserService userService;

    TableService tableService;

    @Autowired
    public UserController(UserService userService, TableService tableService) {
        this.userService = userService;
        this.tableService = tableService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<AppUser> getUserByUsername(@PathVariable String username){
        Optional<AppUser> user = userService.getUserByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping
    public List<AppUser> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{username}/reservation")
    public List<FoosballTable> getReservedTables(@PathVariable String username){
        return tableService.getReservedTablesByUser(username);
    }
}
