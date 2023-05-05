package com.softart.dferestapi.models.response.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Response {
    private String message;

    public static Response ok() {
        return Response.builder().message(HttpStatus.OK.getReasonPhrase()).build();
    }
}