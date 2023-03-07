package com.softart.dferestapi.exceptions;

import com.softart.dferestapi.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.xml.sax.SAXParseException;

@RestControllerAdvice
public final class GlobalExceptionHandler {

    @ExceptionHandler(SAXParseException.class)
    public ResponseEntity<Error> handler(SAXParseException e) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Error
                        .builder()
                        .error(e.getClass().getName())
                        .message(e.getMessage())
                        .build());
    }
}
