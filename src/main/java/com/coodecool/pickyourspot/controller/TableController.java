package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;
import com.coodecool.pickyourspot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<FoosballTable> getAllTable(){
        return productService.getAllTables();
    }

    @PostMapping("/table")
    public void addTable(@RequestBody FoosballTable foosballTable){
        productService.addNewTable(foosballTable);
    }

    @PostMapping("/table/{tableId}/reservation")
    public void addReservation(@RequestBody Reservation reservation, @PathVariable String tableId) throws IllegalAccessException {
        productService.addReservation(tableId, reservation);
    }

    @DeleteMapping("/table/{tableId}/reservation")
    public void deleteReservation(@RequestBody Reservation reservation, @PathVariable String tableId){
        productService.removeReservation(tableId, reservation);
    }

    @GetMapping("/table/free-tables/{dateTimeString}")
    public List<FoosballTable> getFreeTables(@PathVariable String dateTimeString){
        return productService.getFreeTables(dateTimeString);
    }
}
