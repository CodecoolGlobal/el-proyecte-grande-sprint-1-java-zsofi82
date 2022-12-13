package com.coodecool.pickyourspot.storage.repositories;

import com.coodecool.pickyourspot.model.FoosballTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TableRepository extends JpaRepository<FoosballTable, UUID> {

    // TODO
//    List<FoosballTable> findAllByReservationsContaining(UUID userId);
}
