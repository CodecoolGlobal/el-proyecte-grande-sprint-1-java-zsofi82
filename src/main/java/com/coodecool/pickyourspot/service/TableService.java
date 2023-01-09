package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;
import com.coodecool.pickyourspot.storage.repositories.ReservationRepository;
import com.coodecool.pickyourspot.storage.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TableService {

    private final TableRepository tableRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public TableService(TableRepository tableRepository,
                        ReservationRepository reservationRepository) {
        this.tableRepository = tableRepository;
        // TODO adding default tables, just for testing, delete later
//        tableDao.addTable(new FoosballTable("Codecool", "Budapest, Nagymező utca 44."));
//        tableDao.addTable(new FoosballTable("Vault 51", "Budapest, Ó utca 51."));
//        tableDao.addTable(new FoosballTable("Füge udvar", "Budapest, Klauzál utca 19."));
//        tableDao.addTable(new FoosballTable("Noiret bar", "Budapest, Dessewffy utca 8."));
//        tableDao.addTable(new FoosballTable("Petz söröző", "Székesfehérvár, Bőrgyár utca 23."));
//        tableDao.addTable(new FoosballTable("Kaiser Retro Club", "Székesfehérvár, Távirda utca 14."));


        this.reservationRepository = reservationRepository;
    }

    public List<FoosballTable> getAllTables() {
        return tableRepository.findAll();
    }

    public boolean addNewTable(FoosballTable foosballTable) {
        FoosballTable savedTable = tableRepository.save(foosballTable);
        return savedTable != null;
    }

    public Optional<FoosballTable> getTableById(String id) {
        return tableRepository.findById(UUID.fromString(id));
    }

    public boolean addReservation(String tableId, Reservation reservation) {
        Optional<FoosballTable> currentTable = getTableById(tableId);
        if (currentTable.isPresent()) {
            boolean isTimeReserved = currentTable.get()
                    .getReservations()
                    .stream()
                    .anyMatch(r -> r.getReservationTime().equals(reservation.getReservationTime()));
            if (!isTimeReserved) {
                FoosballTable table = currentTable.get();
                reservationRepository.save(reservation);
                table.reserve(reservation);
                tableRepository.save(table);
                return true;
            }
        }
        return false;
    }

    public boolean removeReservation(String tableId, Reservation reservation) {
        Optional<FoosballTable> currentTable = getTableById(tableId);
        if (currentTable.isPresent()) {
            FoosballTable foosballTable = currentTable.get();
            foosballTable.cancelReservation(reservation);
            tableRepository.save(foosballTable);
            return true;
        }
        return false;

    }

    public List<FoosballTable> getFreeTables(LocalDateTime dateTime, String locationString) {
        dateTime = dateTime.truncatedTo(ChronoUnit.HOURS);
        locationString = "%" + locationString + "%";
        return tableRepository.getFreeTablesByLocationAndDate(locationString, dateTime);
    }

    public List<FoosballTable> getReservedTablesByUser(String userId) {
        return tableRepository.getReservedTablesByUser(UUID.fromString(userId));
    }
}
