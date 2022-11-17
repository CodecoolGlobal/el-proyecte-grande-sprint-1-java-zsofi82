package com.coodecool.pickyourspot.storage;

import com.coodecool.pickyourspot.model.FoosballTable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TableDao {
    boolean addTable(FoosballTable foosballTable);
    void deleteTable(FoosballTable foosballTable);
    List<FoosballTable> getAllTables();
    void updateTable(FoosballTable foosballTable);
    Optional<FoosballTable> getTableById(UUID id);
}
