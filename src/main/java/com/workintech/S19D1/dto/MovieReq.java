package com.workintech.S19D1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MovieReq {
    private long id;
    private String name;
    private String directorName;
    private double rating;
    private LocalDate releaseDate;
}
