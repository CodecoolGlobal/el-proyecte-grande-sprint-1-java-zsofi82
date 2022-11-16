package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.User;
import com.coodecool.pickyourspot.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class APIControllerTest {
    @Autowired
    ProductService productService;

    @Test
    void getUserByValidId() {

        User sentUser = new User("username", "email", "password");
        String userId = sentUser.getId().toString();
        productService.addNewUser(sentUser);

        User foundUser = productService.getUserById(userId).get();
        System.out.println(foundUser);

        assertEquals(sentUser, foundUser);

    }

}