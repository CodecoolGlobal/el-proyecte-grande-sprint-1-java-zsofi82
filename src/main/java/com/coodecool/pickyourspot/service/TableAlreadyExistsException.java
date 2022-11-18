package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.model.FoosballTable;

public class TableAlreadyExistsException extends RuntimeException {

    public TableAlreadyExistsException(FoosballTable foosballTable) {
        super(String.format("%s is already created", foosballTable.getName()));
    }

}
