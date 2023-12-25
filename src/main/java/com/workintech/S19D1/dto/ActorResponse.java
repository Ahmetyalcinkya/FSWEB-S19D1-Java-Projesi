package com.workintech.S19D1.dto;

import com.workintech.S19D1.entity.enums.Gender;

import java.time.LocalDate;

public record ActorResponse(String firstName, String lastName,
                            Gender gender, LocalDate birthDate) {
}
