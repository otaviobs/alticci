package com.alticci.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> resourceDuplicateException(NotFoundException ex, WebRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro(LocalDate.now(), ex.getMessage());
        return new ResponseEntity<>(detalhesErro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> serviceUnavailableException(BadRequestException ex, WebRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro(LocalDate.now(), ex.getMessage());
        return new ResponseEntity<>(detalhesErro, HttpStatus.BAD_REQUEST);
    }

}
