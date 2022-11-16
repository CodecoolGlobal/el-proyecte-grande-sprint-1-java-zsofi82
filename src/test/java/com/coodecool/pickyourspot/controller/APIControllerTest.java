package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.User;
import com.coodecool.pickyourspot.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class APIControllerTest {
    @Autowired
    ProductService productService;

    @Test
    void testGetUserByValidId() {
        User sentUser = new User("username", "email", "password");
        productService.addNewUser(sentUser);
        String userId = sentUser.getId().toString();

        User foundUser = productService.getUserById(userId).get();

        assertEquals(sentUser, foundUser);
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User("username1", "email1", "password1");
        User user2 = new User("username2", "email2", "password2");
        productService.addNewUser(user1);
        productService.addNewUser(user2);

        List<User> foundUser = productService.getAllUsers();

        assertTrue(foundUser.contains(user1));
        assertTrue(foundUser.contains(user2));
        assertEquals(2, foundUser.size());
    }

}