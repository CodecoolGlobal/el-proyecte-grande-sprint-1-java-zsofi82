package com.coodecool.pickyourspot.storage;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.storage.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserDaoDatabase implements UserDao{
    UserRepository userRepository;

    @Autowired
    public UserDaoDatabase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(AppUser appUser) {
        userRepository.save(appUser);
    }

    @Override
    public void deleteUser(AppUser appUser) {
        userRepository.delete(appUser);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(AppUser appUser) {
        userRepository.save(appUser);
    }

    @Override
    public Optional<AppUser> getUserById(UUID id) {
        return userRepository.findById(id);
    }
}
