package com.coodecool.pickyourspot.storage;

import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;
import com.coodecool.pickyourspot.storage.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TableDaoDatabase implements TableDao {
    TableRepository tableRepository;

    @Autowired
    public TableDaoDatabase(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public boolean addTable(FoosballTable foosballTable) {
        FoosballTable savedTable = tableRepository.save(foosballTable);
        return savedTable.getId() != null; //TODO
    }

    @Override
    public void deleteTable(FoosballTable foosballTable) {
        tableRepository.delete(foosballTable);
    }

    @Override
    public List<FoosballTable> getAllTables() {
        return tableRepository.findAll();
    }

    @Override
    public void updateTable(FoosballTable foosballTable) {
        tableRepository.save(foosballTable);
    }

    @Override
    public Optional<FoosballTable> getTableById(UUID id) {
        return tableRepository.findById(id);
    }

    @Override
    public List<FoosballTable> getReservedTablesByUser(UUID userId) {
        return null;
    }

    @Override
    public List<Reservation> getReservationsByTableIdAndUserId(UUID tableId, UUID userId) {
        return null;
    }
}
