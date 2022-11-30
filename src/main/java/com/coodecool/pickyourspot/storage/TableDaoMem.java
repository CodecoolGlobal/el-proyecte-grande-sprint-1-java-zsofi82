package com.coodecool.pickyourspot.storage;

import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TableDaoMem implements TableDao {
    private List<FoosballTable> foosballTables;

    private static TableDaoMem tableDaoMem = null;

    private TableDaoMem() {
        this.foosballTables = new ArrayList<>();
    }

    public static TableDaoMem getInstance() {
        if (tableDaoMem == null) {
            tableDaoMem = new TableDaoMem();
        }
        return tableDaoMem;
    }

    @Override
    public boolean addTable(FoosballTable foosballTable) {
        return foosballTables.add(foosballTable);
    }

    @Override
    public void deleteTable(FoosballTable foosballTable) {
        foosballTables.remove(foosballTable);
    }

    @Override
    public List<FoosballTable> getAllTables() {
        return foosballTables;
    }

    @Override
    public void updateTable(FoosballTable foosballTable) {
        foosballTables.set(foosballTables.indexOf(foosballTable), foosballTable);
    }

    @Override
    public Optional<FoosballTable> getTableById(UUID id) {
        return foosballTables.stream()
                .filter(u -> u.getId().compareTo(id) == 0)
                .findFirst();
    }

    @Override
    public List<FoosballTable> getReservedTablesByUser(UUID userId) {
        return foosballTables.stream().filter(foosballTable -> foosballTable.reservedByUser(userId)).collect(Collectors.toList());
    }

    @Override
    public List<Reservation> getReservationsByTableIdAndUserId(UUID tableId, UUID userId) {
        return getTableById(tableId).get().getReservationsByUserId(userId);
    }
}
