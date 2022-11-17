package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class APIControllerTest {
    @Autowired
    ProductService productService;

    @Test
    void testGetUserByValidId() {
        AppUser sentAppUser = new AppUser("username", "email", "password");
        productService.addNewUser(sentAppUser);
        String userId = sentAppUser.getId().toString();

        AppUser foundAppUser = productService.getUserById(userId).get();

        assertEquals(sentAppUser, foundAppUser);
    }

    @Test
    void testGetAllUsers() {
        AppUser appUser1 = new AppUser("username1", "email1", "password1");
        AppUser appUser2 = new AppUser("username2", "email2", "password2");
        productService.addNewUser(appUser1);
        productService.addNewUser(appUser2);

        List<AppUser> foundAppUser = productService.getAllUsers();

        assertTrue(foundAppUser.contains(appUser1));
        assertTrue(foundAppUser.contains(appUser2));
        assertEquals(2, foundAppUser.size());
    }

}