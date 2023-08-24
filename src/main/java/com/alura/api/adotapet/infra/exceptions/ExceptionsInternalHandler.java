package com.alura.api.adotapet.infra.exceptions;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsInternalHandler {

    @ExceptionHandler(NotFoundHandlerException.class)
    public ResponseEntity<ExceptionResponse> handleTestimonyNotFoundException(NotFoundHandlerException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    private record ExceptionResponse(Integer status, String message, OffsetDateTime timestamp) {
        public ExceptionResponse(Integer status, String message) {
            this(status, message, OffsetDateTime.now());
        }
    }
}
