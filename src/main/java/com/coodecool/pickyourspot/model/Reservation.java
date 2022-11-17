package com.coodecool.pickyourspot.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record Reservation (LocalDateTime reservationTime, UUID userId) {}
