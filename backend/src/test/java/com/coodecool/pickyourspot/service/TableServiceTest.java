package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.model.FoosballTable;
import com.coodecool.pickyourspot.model.Reservation;
import com.coodecool.pickyourspot.model.Role;
import com.coodecool.pickyourspot.storage.repositories.ReservationRepository;
import com.coodecool.pickyourspot.storage.repositories.TableRepository;
import com.coodecool.pickyourspot.storage.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TableServiceTest {

    private TableService tableService;
    private final TableRepository tableRepository = Mockito.mock(TableRepository.class);
    private final ReservationRepository reservationRepository = Mockito.mock(ReservationRepository.class);
    private final UserRepository userRepository = Mockito.mock((UserRepository.class));
    private FoosballTable mockTable;
    private final String goodUsername = "Béla";
    private final String badUsername = "Péter";
    private AppUser user;
    private final String goodFakeID = "111111-1111-1111-1111-111111111111";
    private final String badFakeID = "00000000-0000-0000-0000-000000000000";

    @BeforeEach
    void initService() {
        user = new AppUser(UUID.randomUUID(), goodUsername, "email", "password", Role.USER);
        tableService = new TableService(tableRepository, reservationRepository, userRepository);
        mockTable = Mockito.mock(FoosballTable.class);
        when(mockTable.getId()).thenReturn(UUID.fromString(goodFakeID));
        when(tableRepository.save(mockTable)).thenReturn(mockTable);
        when(userRepository.findByUsername(goodUsername)).thenReturn(Optional.ofNullable(user));
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
        Reservation reservation = new Reservation(UUID.fromString(goodFakeID), LocalDateTime.now(), user);
        when(mockTable.getId()).thenReturn(UUID.fromString(badFakeID));
        tableService.addNewTable(mockTable);
        assertFalse(tableService.addReservation(goodFakeID, reservation));
    }

    @Test
    void testAddReservationToGoodTable() {
        Reservation reservation = new Reservation(UUID.fromString(goodFakeID), LocalDateTime.now(), user);
        when(tableRepository.findById(UUID.fromString(goodFakeID))).thenReturn(Optional.of(mockTable));
        tableService.addNewTable(mockTable);
        assertTrue(tableService.addReservation(goodFakeID, reservation));
    }

    @Test
    void testRemoveReservationToBadTable() {
        Reservation reservation = new Reservation(UUID.fromString(goodFakeID), LocalDateTime.now(), user);
        when(mockTable.getId()).thenReturn(UUID.fromString(badFakeID));
        tableService.addNewTable(mockTable);
        assertFalse(tableService.removeReservation(goodFakeID, reservation));
    }

    @Test
    void testRemoveReservation() {
        Reservation reservation = new Reservation(UUID.fromString(goodFakeID), LocalDateTime.now(), user);
        when(tableRepository.findById(UUID.fromString(goodFakeID))).thenReturn(Optional.of(mockTable));
        tableService.addNewTable(mockTable);
        assertTrue(tableService.removeReservation(goodFakeID, reservation));
    }

    @Test
    void testGetReservedTablesByUserBad() {
        when(tableRepository.getReservedTablesByUser(badUsername)).thenReturn(new ArrayList<>());
        assertEquals(new ArrayList<>(), tableService.getReservedTablesByUser(goodUsername));
    }

    @Test
    void testGetReservedTablesByUserGood() {
        List<FoosballTable> mockList = new ArrayList<>();
        mockList.add(mockTable);
        when(tableRepository.getReservedTablesByUser(goodUsername)).thenReturn(mockList);
        assertEquals(mockList, tableService.getReservedTablesByUser(goodUsername));
    }
}