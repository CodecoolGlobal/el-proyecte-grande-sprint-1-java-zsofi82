package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;
import com.coodecool.pickyourspot.storage.TableDao;
import com.coodecool.pickyourspot.storage.UserDao;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
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

        // TODO adding default tables, just for testing, delete later
        tableDao.addTable(new FoosballTable("Codecool-foosball table", "Budapest, Nagymező u. 44-1st Floor, 1065"));
    }

    public List<FoosballTable> getAllTables() {
        return tableDao.getAllTables();
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

    public boolean addNewTable(FoosballTable foosballTable) {
        if (tableDao.addTable(new FoosballTable(foosballTable.getName(), foosballTable.getAddress()))) {
            System.out.println(tableDao.getAllTables());
            return true;
        }
        return false;
    }

    public Optional<FoosballTable> getTableById(String id) {
        return tableDao.getTableById(UUID.fromString(id));
    }

    public boolean addReservation(String tableId, Reservation reservation) throws IllegalAccessException {
        Optional<FoosballTable> currentTable = getTableById(tableId);
        if (currentTable.isPresent()) {
            if (currentTable.get().reserve(reservation)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeReservation(String tableId, Reservation reservation) {
        Optional<FoosballTable> currentTable = getTableById(tableId);
        if (currentTable.isPresent()) {
            return currentTable.get().cancelReservation(reservation);
        }
        return false;

    }

    public List<FoosballTable> getFreeTables(String dateTimeString) {
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
        return tableDao.getAllTables().stream()
                .filter(table -> table.isFreeAt(dateTime))
                .collect(Collectors.toList());
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
        System.out.println("Fail! There is a " + appUser);
        return false;
    }

    public List<FoosballTable> getReservedTablesByUser(String userId ){
        return tableDao.getReservedTablesByUser(UUID.fromString(userId));
    }

    public List<Reservation> getReservationsByTableIdAndUserId(String tableId, String userId){
        return tableDao.getReservationsByTableIdAndUserId(UUID.fromString(tableId), UUID.fromString(userId));

    }

    public  Optional<AppUser> loginUser(AppUser appUser) {
        List<AppUser> allUsers = userDao.getAllUsers();
        return allUsers.stream()
                .filter(user -> user.getUsername().equals(appUser.getUsername()))
                .filter(user -> user.getPassword().equals(appUser.getPassword()))
                .findAny();
    }
}

