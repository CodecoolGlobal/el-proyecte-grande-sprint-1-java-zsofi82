package com.coodecool.pickyourspot.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Reservation{
    @Id
//    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    private LocalDateTime reservationTime;
    private UUID userId;
}
