package com.workintech.S19D1.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class HollywoodExceptions extends RuntimeException {
    private HttpStatus status;

    public HollywoodExceptions(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
