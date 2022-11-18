package com.coodecool.pickyourspot.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.storage.TableDao;

public class MockTableDao implements TableDao {

    @Override
    public boolean addTable(FoosballTable foosballTable) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void deleteTable(FoosballTable foosballTable) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<FoosballTable> getAllTables() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<FoosballTable> getTableById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateTable(FoosballTable foosballTable) {
        // TODO Auto-generated method stub

    }

    public void clear() {
        // TODO
    }

}
