package com.example.demo.controllers;

import com.example.demo.models.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity ExceptionHandler(IllegalArgumentException ex) {
        var message = ex.getMessage();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, message);
        if (message.contains("found")) {
            apiError.setStatus(HttpStatus.NOT_FOUND);
        }
        if (message.contains("already")) {
            apiError.setStatus(HttpStatus.CONFLICT);
        }
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }
}
