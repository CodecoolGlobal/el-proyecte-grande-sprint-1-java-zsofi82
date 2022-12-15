package com.coodecool.pickyourspot.model.parse_helper_models;

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
