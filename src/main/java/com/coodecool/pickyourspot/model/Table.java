package com.coodecool.pickyourspot.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class Table {
    UUID id;
    String name;
    String address;
    Map<LocalDateTime,UUID> reservations;

}
