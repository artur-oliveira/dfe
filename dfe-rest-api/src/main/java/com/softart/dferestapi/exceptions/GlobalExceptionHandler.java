package com.softart.dferestapi.exceptions;

import com.softart.dferestapi.exceptions.entity.EntityAlreadyExistsException;
import com.softart.dferestapi.exceptions.entity.EntityNotFoundException;
import com.softart.dferestapi.models.response.error.CommonError;
import com.softart.dferestapi.models.response.error.ValidationError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.xml.sax.SAXParseException;

@RestControllerAdvice
public final class GlobalExceptionHandler {

    @ExceptionHandler(SAXParseException.class)
    public ResponseEntity<CommonError> handler(SAXParseException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName())
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(DfeRestException.class)
    public ResponseEntity<CommonError> handler(DfeRestException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName())
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CommonError> handler(EntityNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName())
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<CommonError> handler(EntityAlreadyExistsException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .header(HttpHeaders.LOCATION, e.getId().toString())
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName())
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> handler(MethodArgumentNotValidException e) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ValidationError(e));
    }
}
