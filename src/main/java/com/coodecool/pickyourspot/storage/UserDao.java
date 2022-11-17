package com.coodecool.pickyourspot.storage;

import com.coodecool.pickyourspot.model.AppUser;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    void addUser(AppUser appUser);
    void deleteUser(AppUser appUser);
    List<AppUser> getAllUsers();
    void updateUser(AppUser appUser);
    Optional<AppUser> getUserById(UUID id);
}
