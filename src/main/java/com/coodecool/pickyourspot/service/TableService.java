package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;
import com.coodecool.pickyourspot.storage.TableDao;
import com.coodecool.pickyourspot.storage.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TableService {

    private final TableDao tableDao;

    @Autowired
    public TableService(TableDao tableDao) {
        this.tableDao = tableDao;

        // TODO adding default tables, just for testing, delete later
        tableDao.addTable(new FoosballTable("Codecool-foosball table", "Budapest, Nagymező u. 44-1st Floor, 1065"));
    }

    public List<FoosballTable> getAllTables() {
        return tableDao.getAllTables();
    }

    public boolean addNewTable(FoosballTable foosballTable) {
        return tableDao.addTable(new FoosballTable(foosballTable.getName(), foosballTable.getAddress()));
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

    public List<FoosballTable> getReservedTablesByUser(String userId ){
        return tableDao.getReservedTablesByUser(UUID.fromString(userId));
    }

    public List<Reservation> getReservationsByTableIdAndUserId(String tableId, String userId){
        return tableDao.getReservationsByTableIdAndUserId(UUID.fromString(tableId), UUID.fromString(userId));
    }
}
