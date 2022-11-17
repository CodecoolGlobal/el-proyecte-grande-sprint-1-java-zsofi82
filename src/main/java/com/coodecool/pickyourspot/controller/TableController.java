package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;
import com.coodecool.pickyourspot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TableController {
    ProductService productService;

    @Autowired
    public TableController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/table")
    public List<FoosballTable> getAllTable() {
        return productService.getAllTables();
    }

    @PostMapping("/table")
    public ResponseEntity<String> addTable(@RequestBody FoosballTable foosballTable) {
        if (productService.addNewTable(foosballTable)) {
            return ResponseEntity.ok("Added table");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid table data");

    }

    @PostMapping("/table/{tableId}/reservation")
    public ResponseEntity<String> addReservation(@RequestBody Reservation reservation, @PathVariable String tableId) throws IllegalAccessException {
        if (productService.addReservation(tableId, reservation)) {
            return ResponseEntity.ok("Added reservation " + reservation + " to table");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Table reservation failed");
    }

    @DeleteMapping("/table/{tableId}/reservation")
    public ResponseEntity<String> deleteReservation(@RequestBody Reservation reservation, @PathVariable String tableId) {
        if (productService.removeReservation(tableId, reservation)){
            return ResponseEntity.ok("Removed reservation " + reservation + " from table");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Table reservation cancelling failed");
    }

    @GetMapping("/table/free-tables/{dateTimeString}")
    public List<FoosballTable> getFreeTables(@PathVariable String dateTimeString) {
        return productService.getFreeTables(dateTimeString);
    }
}
