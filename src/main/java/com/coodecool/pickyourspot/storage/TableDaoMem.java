package com.coodecool.pickyourspot.storage;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import com.coodecool.pickyourspot.model.FoosballTable;

import org.springframework.stereotype.Component;
@Component
public class TableDaoMem implements TableDao {
    private Set<FoosballTable> foosballTables;

    private static TableDaoMem tableDaoMem = null;

    private TableDaoMem() {
        this.foosballTables = new LinkedHashSet<>();
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
        return List.copyOf(this.foosballTables);
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
}
