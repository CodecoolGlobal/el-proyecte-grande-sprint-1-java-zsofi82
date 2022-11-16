package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.model.Table;
import com.coodecool.pickyourspot.model.User;
import com.coodecool.pickyourspot.storage.TableDao;
import com.coodecool.pickyourspot.storage.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public void addNewTable(Table table){
        tableDao.addTable(new Table(table.getName(), table.getAddress()));
        System.out.println(tableDao.getAllTables());
    }

    public Optional<Table> getTableById(String id){
        return tableDao.getTableById(UUID.fromString(id));
    }

    public void addReservation(String id, HashMap<String, String> reservation) throws IllegalAccessException {
        Optional<Table> currentTable = getTableById(id);
        if(currentTable.isPresent()){
            String key = reservation.keySet().stream().findFirst().get();
            currentTable.get().reserve(LocalDateTime.parse(key) , UUID.fromString(reservation.get(key)));
            System.out.println(currentTable);
        }
    }

    public void removeReservation(String id, HashMap<String, String> reservation){
        Optional<Table> currentTable = getTableById(id);
        if(currentTable.isPresent()){
            String key = reservation.keySet().stream().findFirst().get();
            currentTable.get().cancelReservation(LocalDateTime.parse(key) , UUID.fromString(reservation.get(key)));
            System.out.println(currentTable);
        }
    }

    public List<Table> getFreeTables(String dateTimeString) {
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
        return tableDao.getAllTables().stream()
                .filter(table -> !table.getReservations().containsKey(dateTime))
                .collect(Collectors.toList());
    }
}
