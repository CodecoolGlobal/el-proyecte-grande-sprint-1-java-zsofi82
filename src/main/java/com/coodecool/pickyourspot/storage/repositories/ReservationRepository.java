package com.coodecool.pickyourspot.storage.repositories;

import com.coodecool.pickyourspot.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {


}
