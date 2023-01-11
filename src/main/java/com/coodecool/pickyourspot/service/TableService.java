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
//        tableRepository.save(FoosballTable.builder()
//                .name("Codecool")
//                .address("Budapest, Nagymező utca 44.")
//                .build());
//        tableRepository.save(FoosballTable.builder()
//                .name("Vault 51")
//                .address("Budapest, Ó utca 51.")
//                .build());
//        tableRepository.save(FoosballTable.builder()
//                .name("Füge udvar")
//                .address("Budapest, Klauzál utca 19.")
//                .build());
//        tableRepository.save(FoosballTable.builder()
//                .name("Noiret bar")
//                .address("Budapest, Dessewffy utca 8.")
//                .build());
//        tableRepository.save(FoosballTable.builder()
//                .name("Petz söröző")
//                .address("Székesfehérvár, Bőrgyár utca 23.")
//                .build());
//        tableRepository.save(FoosballTable.builder()
//                .name("Kaiser Retro Club")
//                .address("Székesfehérvár, Távirda utca 14.")
//                .build());

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

    public List<FoosballTable> getReservedTablesByUser(String username) {
        return tableRepository.getReservedTablesByUser(username);
    }
}
