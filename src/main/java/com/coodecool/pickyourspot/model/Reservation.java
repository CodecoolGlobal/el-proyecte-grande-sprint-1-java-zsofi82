package com.coodecool.pickyourspot.model;

import lombok.*;
import org.apache.catalina.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode
public class Reservation{
    @Id
//    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDateTime reservationTime;
    @ManyToOne
    private AppUser user;
}
