package com.softart.dferestapi.exceptions;

import com.softart.dferestapi.models.error.CommonError;
import com.softart.dferestapi.models.error.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> handler(MethodArgumentNotValidException e) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ValidationError(e));
    }
}
