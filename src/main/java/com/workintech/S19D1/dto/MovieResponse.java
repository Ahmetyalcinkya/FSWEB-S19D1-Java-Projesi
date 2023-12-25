package com.workintech.S19D1.dto;

import java.time.LocalDate;

public record MovieResponse(String name, String directorName,
                            double rating, LocalDate releaseDate) {
}
