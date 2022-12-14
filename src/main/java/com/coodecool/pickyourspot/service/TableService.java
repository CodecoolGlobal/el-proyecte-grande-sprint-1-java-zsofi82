package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;
import com.coodecool.pickyourspot.storage.TableDao;
import com.coodecool.pickyourspot.storage.UserDao;
import com.coodecool.pickyourspot.storage.repositories.ReservationRepository;
import com.coodecool.pickyourspot.storage.repositories.TableRepository;
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
    private final ReservationRepository reservationRepository;

    @Autowired
    public TableService(TableDao tableDao,
                        ReservationRepository reservationRepository) {
        this.tableDao = tableDao;

        // TODO adding default tables, just for testing, delete later
//        tableDao.addTable(new FoosballTable("Codecool", "Budapest, Nagymező utca 44."));
//        tableDao.addTable(new FoosballTable("Vault 51", "Budapest, Ó utca 51."));
//        tableDao.addTable(new FoosballTable("Füge udvar", "Budapest, Klauzál utca 19."));
//        tableDao.addTable(new FoosballTable("Noiret bar", "Budapest, Dessewffy utca 8."));
        this.reservationRepository = reservationRepository;
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
            FoosballTable table = currentTable.get();
            reservationRepository.save(reservation);
            table.reserve(reservation);
            tableDao.updateTable(table);
            return true;
        }
        return false;
    }

    public boolean removeReservation(String tableId, Reservation reservation) {
        Optional<FoosballTable> currentTable = getTableById(tableId);
        if (currentTable.isPresent()) {
            FoosballTable foosballTable = currentTable.get();
            foosballTable.cancelReservation(reservation);
            tableDao.updateTable(foosballTable);
            return true;
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
