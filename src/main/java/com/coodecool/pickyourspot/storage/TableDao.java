package com.coodecool.pickyourspot.storage;

import com.coodecool.pickyourspot.model.Table;

import java.util.List;
import java.util.UUID;

public interface TableDao {
    void addTable(Table table);
    void deleteTable(Table table);
    List<Table> getAllTables();
    void updateTable(Table table);
    Table getTableById(UUID id);
}
