package com.coodecool.pickyourspot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoosballTable {
    @Id
//    @Type(type = "uuid-char")
    UUID id = UUID.randomUUID();
    String name;
    String address;
    @OneToMany
    List<Reservation> reservations;

    /*
        public Table(UUID id, String name, String address, Map<LocalDateTime, UUID> reservations) {
            this.id = id;
            this.name = name;
            this.address = address;
            this.reservations = reservations;
        }
    */
    public FoosballTable(String name, String address) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.reservations = new ArrayList<>();
    }

    public boolean reserve(Reservation reservation) {
        if (isTimeTaken(reservation)) {
            return false;
        } else {
            return reservations.add(reservation);
        }
    }

    private boolean isTimeTaken(Reservation reservation) {
        return reservations.stream()
                .anyMatch(res -> res.getReservationTime().equals(reservation.getReservationTime()));
    }

    public boolean cancelReservation(Reservation reservation) {
        return reservations.remove(reservation);
    }

    public boolean reservedByUser(UUID userId){
        return reservations.stream().filter(reservation -> reservation.getUserId().equals(userId)).collect(Collectors.toSet()).size() > 0;
    }
    public List<Reservation> getReservationsByUserId(UUID userId){
        return reservations.stream().filter(reservation -> reservation.getUserId().equals(userId)).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoosballTable foosballTable = (FoosballTable) o;
        return Objects.equals(id, foosballTable.id);
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

    public UUID getId() {
        return id;
    }

    public boolean isFreeAt(LocalDateTime dateTime) {
        return reservations.stream()
                .noneMatch(res -> res.getReservationTime().equals(dateTime));
    }


}
