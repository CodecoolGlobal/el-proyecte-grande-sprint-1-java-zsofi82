package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.storage.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addNewUser(AppUser appUser) {
        //TODO: user validation (is username exists?), password hashing
        userDao.addUser(appUser);
    }

    public Optional<AppUser> getUserById(String id) {
        return userDao.getUserById(UUID.fromString(id));
    }

    public List<AppUser> getAllUsers() {
        return userDao.getAllUsers();
    }

    public boolean registerUser(AppUser appUser) {
        List<AppUser> allUsers = userDao.getAllUsers();
        long numberOfUsersWithSameName = allUsers.stream()
                .filter(user -> user.getUsername().equals(appUser.getUsername()))
                .count();
        if (numberOfUsersWithSameName == 0) {
            userDao.addUser(appUser);
            return true;
        }
        return false;
    }

    public  Optional<AppUser> loginUser(AppUser appUser) {
        List<AppUser> allUsers = userDao.getAllUsers();
        return allUsers.stream()
                .filter(user -> user.getUsername().equals(appUser.getUsername()))
                .filter(user -> user.getPassword().equals(appUser.getPassword()))
                .findAny();
    }
}

