package com.coodecool.pickyourspot.storage;

import com.coodecool.pickyourspot.model.Table;
import com.coodecool.pickyourspot.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    void addUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();
    void updateUser(User user);
    Optional<User> getUserById(UUID id);
}
