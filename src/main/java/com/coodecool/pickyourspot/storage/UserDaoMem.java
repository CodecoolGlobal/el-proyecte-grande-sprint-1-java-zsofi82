package com.coodecool.pickyourspot.storage;

import com.coodecool.pickyourspot.model.AppUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Component
public class UserDaoMem implements UserDao {
    private final List<AppUser> appUsers = new ArrayList<>();
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
    public void addUser(AppUser appUser) {
        appUsers.add(appUser);
    }

    @Override
    public void deleteUser(AppUser appUser) {
        appUsers.remove(appUser);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUsers;
    }

    @Override
    public void updateUser(AppUser appUser) {
        appUsers.set(appUsers.indexOf(appUser), appUser);
    }

    @Override
    public Optional<AppUser> getUserById(UUID id) {
        return appUsers.stream()
                .filter(u -> u.getId().compareTo(id) == 0)
                .findFirst();
    }
}
