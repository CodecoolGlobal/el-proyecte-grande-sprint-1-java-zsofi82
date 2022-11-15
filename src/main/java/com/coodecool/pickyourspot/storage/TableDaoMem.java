package com.coodecool.pickyourspot.storage;

import com.coodecool.pickyourspot.model.Table;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
public class TableDaoMem implements TableDao {
    private List<Table> tables;

    private static TableDaoMem tableDaoMem = null;

    private TableDaoMem() {
        this.tables = new ArrayList<>();
    }

    public static TableDaoMem getInstance() {
        if (tableDaoMem == null) {
            tableDaoMem = new TableDaoMem();
        }
        return tableDaoMem;
    }

    @Override
    public void addTable(Table table) {
        tables.add(table);
    }

    @Override
    public void deleteTable(Table table) {
        tables.remove(table);
    }

    @Override
    public List<Table> getAllTables() {
        return tables;
    }

    @Override
    public void updateTable(Table table) {
        tables.set(tables.indexOf(table), table);
    }

    @Override
    public Table getTableById(UUID id) {
        return tables.stream()
                .filter(table -> table.getId().equals(id))
                .findFirst()
                .get();
    }
}
