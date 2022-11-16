package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.User;
import com.coodecool.pickyourspot.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class APIControllerTest {
    @Autowired
    ProductService productService;

    @Test
    void getUserByValidId() {
        User sentUser = new User("username", "email", "password");
        productService.addNewUser(sentUser);
        String userId = sentUser.getId().toString();

        User foundUser = productService.getUserById(userId).get();

        assertEquals(sentUser, foundUser);
    }

    @Test
    void getUserByInvalidId() {
        User sentUser = new User("username", "email", "password");
        productService.addNewUser(sentUser);
        sentUser.setId(UUID.randomUUID());
        String userId = sentUser.getId().toString();

        User foundUser = productService.getUserById(userId).get();

        assertNotEquals(sentUser, foundUser);
    }

}