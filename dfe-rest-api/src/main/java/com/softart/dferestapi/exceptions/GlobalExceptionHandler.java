package com.softart.dferestapi.exceptions;

import com.softart.dfe.exceptions.DfeException;
import com.softart.dfe.exceptions.DfeUncheckedException;
import com.softart.dferestapi.exceptions.entity.EntityAlreadyExistsException;
import com.softart.dferestapi.exceptions.entity.EntityNotFoundException;
import com.softart.dferestapi.models.response.error.CommonError;
import com.softart.dferestapi.models.response.error.ValidationError;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.xml.sax.SAXParseException;

@RestControllerAdvice
@Log4j2
public final class GlobalExceptionHandler {

    @ExceptionHandler(SAXParseException.class)
    public ResponseEntity<CommonError> handler(SAXParseException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName().replace("Exception", ""))
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonError> handler(Exception e) {
        log.error(e.getClass().getSimpleName(), e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName().replace("Exception", ""))
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<CommonError> handler(HttpRequestMethodNotSupportedException e) {
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName().replace("Exception", ""))
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CommonError> handler(HttpMessageNotReadableException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName().replace("Exception", ""))
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(DfeRestApiException.class)
    public ResponseEntity<CommonError> handler(DfeRestApiException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName().replace("Exception", ""))
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CommonError> handler(EntityNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName().replace("Exception", ""))
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
                        .error(e.getClass().getSimpleName().replace("Exception", ""))
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> handler(MethodArgumentNotValidException e) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ValidationError(e));
    }

    @ExceptionHandler(java.net.SocketTimeoutException.class)
    public ResponseEntity<CommonError> handler(java.net.SocketTimeoutException e) {
        return ResponseEntity
                .status(HttpStatus.REQUEST_TIMEOUT)
                .header(HttpHeaders.CONNECTION, "close")
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName().replace("Exception", ""))
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(java.net.SocketException.class)
    public ResponseEntity<CommonError> handler(java.net.SocketException e) {
        return ResponseEntity
                .status(HttpStatus.REQUEST_TIMEOUT)
                .header(HttpHeaders.CONNECTION, "close")
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName().replace("Exception", ""))
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ValidationError> handler(MethodArgumentTypeMismatchException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ValidationError(e));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ValidationError> handler(MissingServletRequestParameterException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ValidationError(e));
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<CommonError> handler(UnsupportedOperationException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName().replace("Exception", ""))
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(DfeUncheckedException.class)
    public ResponseEntity<CommonError> handler(DfeUncheckedException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName().replace("Exception", ""))
                        .message(e.getMessage())
                        .build());
    }


    @ExceptionHandler(DfeException.class)
    public ResponseEntity<CommonError> handler(DfeException e) {
        log.error(e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(CommonError
                        .builder()
                        .error(e.getClass().getSimpleName().replace("Exception", ""))
                        .message(e.getMessage())
                        .build());
    }
}
