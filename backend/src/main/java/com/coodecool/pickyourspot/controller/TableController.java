package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;
import com.coodecool.pickyourspot.model.parse_helper_models.SearchFilters;
import com.coodecool.pickyourspot.service.TableService;
import com.coodecool.pickyourspot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class TableController {
    UserService userService;
    TableService tableService;

    @Autowired
    public TableController(UserService userService, TableService tableService) {
        this.userService = userService;
        this.tableService = tableService;
    }

    @PostMapping
    public ResponseEntity<String> addTable(@RequestBody FoosballTable foosballTable) {
        if (tableService.addNewTable(foosballTable)) {
            return ResponseEntity.ok("Added table");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid table data");
    }

    @PostMapping("/{tableId}/reservation")
    public ResponseEntity<String> addReservation(@RequestBody Reservation reservation, @PathVariable String tableId) throws IllegalAccessException {
        if (tableService.addReservation(tableId, reservation)) {
            return ResponseEntity.ok("Added reservation " + reservation + " to table");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Table reservation failed");
    }

    @DeleteMapping("/{tableId}/reservation")
    public ResponseEntity<String> deleteReservation(@RequestBody Reservation reservation, @PathVariable String tableId) {
        if (tableService.removeReservation(tableId, reservation)) {
            return ResponseEntity.ok("Removed reservation " + reservation + " from table");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Table reservation cancelling failed");
    }

    @PostMapping("/free-tables")
    public List<FoosballTable> getFreeTables(@RequestBody SearchFilters searchFilters) {
        return tableService.getFreeTables(searchFilters.getDateTime(), searchFilters.getLocation());
    }
}
