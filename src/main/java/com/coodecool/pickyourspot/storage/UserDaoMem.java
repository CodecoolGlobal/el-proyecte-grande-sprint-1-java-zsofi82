package com.coodecool.pickyourspot.storage;

import com.coodecool.pickyourspot.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Component
public class UserDaoMem implements UserDao {
    private final List<User> users = new ArrayList<>();
    private static UserDaoMem userDaoMem = null;

    private UserDaoMem() {
    }

    public static UserDaoMem getInstance() {
        if(userDaoMem == null) {
            userDaoMem = new UserDaoMem();
        }
        return userDaoMem;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void updateUser(User user) {
        users.set(users.indexOf(user), user);
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return users.stream()
                .filter(u -> u.getId().compareTo(id) == 0)
                .findFirst();
    }
}
