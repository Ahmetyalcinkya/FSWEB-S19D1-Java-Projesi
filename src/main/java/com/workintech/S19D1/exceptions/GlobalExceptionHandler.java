package com.workintech.S19D1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<ErrorResponse> handleException(HollywoodExceptions hollywoodExceptions){
        ErrorResponse errorResponse = new ErrorResponse(hollywoodExceptions.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, hollywoodExceptions.getStatus());
    }
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
