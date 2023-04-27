package com.softart.dferestapi.models.response.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class ValidationError {

    private String error;
    private int errorCount;
    private List<FieldError> fields;


    public ValidationError(MethodArgumentNotValidException e) {
        setErrorCount(e.getErrorCount());
        setFields(e.getBindingResult().getFieldErrors().stream().map(it -> FieldError
                .builder()
                .field(it.getField())
                .originalValue(it.getRejectedValue())
                .code(it.getCode())
                .message(it.getDefaultMessage())
                .build()).collect(Collectors.toList()));
    }

    public ValidationError(MethodArgumentTypeMismatchException e) {
        setErrorCount(1);
        setFields(Collections.singletonList(FieldError.builder().field(e.getName()).originalValue(e.getValue()).message(e.getMessage()).build()));
    }

    public ValidationError(MissingServletRequestParameterException e) {
        setErrorCount(1);
        setError(e.getMessage());
        setFields(Collections.singletonList(FieldError.builder().field(e.getParameterName()).originalValue(e.getParameterType()).build()));
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class FieldError {
        private String field;
        private Object originalValue;
        private String message;
        private String code;
    }

}
