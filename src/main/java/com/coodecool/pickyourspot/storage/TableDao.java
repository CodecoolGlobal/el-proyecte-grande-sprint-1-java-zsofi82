package com.coodecool.pickyourspot.storage;

import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TableDao {
    boolean addTable(FoosballTable foosballTable);
    void deleteTable(FoosballTable foosballTable);
    List<FoosballTable> getAllTables();
    void updateTable(FoosballTable foosballTable);
    Optional<FoosballTable> getTableById(UUID id);
    List<FoosballTable> getReservedTablesByUser(UUID userId);
    List<Reservation> getReservationsByTableIdAndUserId(UUID tableId, UUID userId);
}
