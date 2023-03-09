package com.softart.dferestapi.models.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class ValidationError {

    private String error;
    private int errorCount;
    private List<FieldError> fields;

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

}
