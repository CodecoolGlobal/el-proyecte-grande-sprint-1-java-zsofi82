package com.coodecool.pickyourspot.storage.repositories;

import com.coodecool.pickyourspot.model.FoosballTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TableRepository extends JpaRepository<FoosballTable, UUID> {
    @Query(value = "SELECT * FROM foosball_table\n" +
            "JOIN foosball_table_reservations ftr on foosball_table.id = ftr.foosball_table_id\n" +
            "JOIN reservation r on ftr.reservations_id = r.id\n" +
            "JOIN app_user au on au.id = r.user_id\n" +
            "WHERE au.id = :user_id", nativeQuery = true)
    List<FoosballTable> getReservedTablesByUser(@Param("user_id") UUID userId);

    // TODO
//    List<FoosballTable> findAllByReservationsContaining(UUID userId);
}
