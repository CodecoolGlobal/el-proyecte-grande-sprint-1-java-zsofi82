package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;
import com.coodecool.pickyourspot.storage.repositories.ReservationRepository;
import com.coodecool.pickyourspot.storage.repositories.TableRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TableServiceTest {

    private TableService tableService;
    private final TableRepository tableRepository = Mockito.mock(TableRepository.class);
    private final ReservationRepository reservationRepository = Mockito.mock(ReservationRepository.class);
    private FoosballTable mockTable;
    private final String goodFakeID = "111111-1111-1111-1111-111111111111";
    private final String badFakeID = "00000000-0000-0000-0000-000000000000";

    @BeforeEach
    void initService() {
        tableService = new TableService(tableRepository, reservationRepository);
        mockTable = Mockito.mock(FoosballTable.class);
        when(tableRepository.save(mockTable)).thenReturn(mockTable);
    }

    @Test
    void testAddNewTable() {
        List<FoosballTable> mockList = new ArrayList<>();
        mockList.add(mockTable);
        assertEquals(0, tableService.getAllTables().size());
        when(tableRepository.findAll()).thenReturn(mockList);
        tableService.addNewTable(mockTable);
        assertEquals(1, tableService.getAllTables().size());
    }

    @Test
    void testGetTableById() {
        when(tableRepository.findById(UUID.fromString(goodFakeID))).thenReturn(Optional.ofNullable(mockTable));
        tableService.addNewTable(mockTable);
        assertTrue(tableService.getTableById(goodFakeID).isPresent());
    }

    @Test
    void testGetTableByIdNegative() {
        when(mockTable.getId()).thenReturn(UUID.fromString(goodFakeID));
        tableService.addNewTable(mockTable);
        assertTrue(tableService.getTableById(badFakeID).isEmpty());
    }

    @Test
    void testAddReservationToBadTable() {
        Reservation reservation = new Reservation();
        when(mockTable.getId()).thenReturn(UUID.fromString(badFakeID));
        tableService.addNewTable(mockTable);
        assertFalse(tableService.addReservation(goodFakeID, reservation));
    }

    @Test
    void testAddReservationToGoodTable() {
        Reservation reservation = new Reservation();
        when(tableRepository.findById(UUID.fromString(goodFakeID))).thenReturn(Optional.of(mockTable));
        tableService.addNewTable(mockTable);
        assertTrue(tableService.addReservation(goodFakeID, reservation));
    }

    @Test
    void testRemoveReservationToBadTable() {
        Reservation reservation = new Reservation();
        when(mockTable.getId()).thenReturn(UUID.fromString(badFakeID));
        tableService.addNewTable(mockTable);
        assertFalse(tableService.removeReservation(goodFakeID, reservation));
    }

    @Test
    void testRemoveReservation() {
        Reservation reservation = new Reservation();
        when(tableRepository.findById(UUID.fromString(goodFakeID))).thenReturn(Optional.of(mockTable));
        tableService.addNewTable(mockTable);
        assertTrue(tableService.removeReservation(goodFakeID, reservation));
    }

    @Test
    void testGetReservedTablesByUserBad() {
        when(tableRepository.getReservedTablesByUser(UUID.fromString(goodFakeID))).thenReturn(new ArrayList<>());
        assertEquals(new ArrayList<>(), tableService.getReservedTablesByUser(goodFakeID));
    }

    @Test
    void testGetReservedTablesByUserGood() {
        List<FoosballTable> mockList = new ArrayList<>();
        mockList.add(mockTable);
        when(tableRepository.getReservedTablesByUser(UUID.fromString(goodFakeID))).thenReturn(mockList);
        assertEquals(mockList, tableService.getReservedTablesByUser(goodFakeID));
    }
}