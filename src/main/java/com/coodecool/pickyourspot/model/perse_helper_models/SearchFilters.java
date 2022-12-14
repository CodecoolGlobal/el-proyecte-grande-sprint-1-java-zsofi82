package com.coodecool.pickyourspot.model.perse_helper_models;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class SearchFilters {
    private String location;
    private LocalDateTime dateTime;
}
