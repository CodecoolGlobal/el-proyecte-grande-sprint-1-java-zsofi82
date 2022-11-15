package com.coodecool.pickyourspot.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Table {
    UUID id;
    String name;
    String address;
    Map<LocalDateTime,UUID> reservations;

    public Table(UUID id, String name, String address, Map<LocalDateTime, UUID> reservations) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.reservations = reservations;
    }

    public Table(String name, String address) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.reservations = new HashMap<>();
    }

}
