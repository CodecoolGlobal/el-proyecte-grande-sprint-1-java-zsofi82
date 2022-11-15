package com.coodecool.pickyourspot.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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

    public void reserve(LocalDateTime time, UUID id) throws IllegalAccessException {
        if (reservations.containsKey(time)){
            throw new IllegalAccessException("This time is already reserved!");
        } else{
            reservations.put(time, id);
        }
    }

    public void cancelReservation(LocalDateTime time, UUID id){
        reservations.remove(time, id);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Map<LocalDateTime, UUID> getReservations() {
        return reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equals(id, table.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", reservations=" + reservations +
                '}';
    }
}
