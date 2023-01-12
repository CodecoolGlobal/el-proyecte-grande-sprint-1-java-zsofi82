package com.coodecool.pickyourspot.storage.repositories;

import com.coodecool.pickyourspot.model.FoosballTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface TableRepository extends JpaRepository<FoosballTable, UUID> {
    @Query(value = "select f from FoosballTable f join f.reservations as r where r.user.username = :username group by f")
    List<FoosballTable> getReservedTablesByUser(@Param("username") String username);

    @Query("SELECT f " +
            "FROM FoosballTable f " +
            "WHERE not exists(select 1 from f.reservations r where r.reservationTime = :reservationTime) " +
            "AND f.address LIKE :location")
    List<FoosballTable> getFreeTablesByLocationAndDate(@Param("location") String locationString, @Param("reservationTime") LocalDateTime dateTime);

}
