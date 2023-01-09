package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.storage.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public void addNewUser(AppUser appUser) {
        //TODO: user validation (is username exists?), password hashing
        userRepository.save(appUser);
    }

    public Optional<AppUser> getUserById(String id) {
        return userRepository.findById(UUID.fromString(id));
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean registerUser(AppUser appUser) {
        List<AppUser> allUsers = userRepository.findAll();
        long numberOfUsersWithSameName = allUsers.stream()
                .filter(user -> user.getUsername().equals(appUser.getUsername()))
                .count();
        if (numberOfUsersWithSameName == 0) {
            userRepository.save(appUser);
            return true;
        }
        return false;
    }

    public  Optional<AppUser> checkIfUserInDatabase(AppUser appUser) {
        List<AppUser> allUsers = userRepository.findAll();
        return allUsers.stream()
                .filter(user -> user.getUsername().equals(appUser.getUsername()))
                .filter(user -> user.getPassword().equals(appUser.getPassword()))
                .findAny();
    }
}

