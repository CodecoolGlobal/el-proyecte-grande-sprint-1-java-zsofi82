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
    @Query(value = "select f from FoosballTable f join f.reservations as r where r.user.id = :user_id group by f")
    List<FoosballTable> getReservedTablesByUser(@Param("user_id") UUID userId);

    @Query("select f " +
            "from FoosballTable f " +
            "where not exists(select 1 from f.reservations r where r.reservationTime = :reservationTime) " +
            "AND f.address like :location")
//    f.address like :location and r.reservationTime <> :date
    List<FoosballTable> getFreeTablesByLocationAndDate(@Param("location") String locationString, @Param("reservationTime") LocalDateTime dateTime);

}
