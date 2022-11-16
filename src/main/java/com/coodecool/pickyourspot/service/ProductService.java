package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.model.Table;
import com.coodecool.pickyourspot.model.User;
import com.coodecool.pickyourspot.storage.TableDao;
import com.coodecool.pickyourspot.storage.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductService {
    private final TableDao tableDao;
    private final UserDao userDao;

    @Autowired
    public ProductService(TableDao tableDao, UserDao userDao) {
        this.tableDao = tableDao;
        this.userDao = userDao;
    }
    
    public List<Table> getAllTables() {
        return tableDao.getAllTables();
    }

    public void addNewUser(User user) {
        //TODO: user validation (is username exists?), password hashing
        userDao.addUser(user);
    }

    public Optional<User> getUserById(String id){
        return userDao.getUserById(UUID.fromString(id));
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
