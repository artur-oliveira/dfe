package com.softart.dferestapi.controllers;

import com.softart.dferestapi.constants.HealthCheckControllerConstants;
import com.softart.dferestapi.models.response.common.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(HealthCheckControllerConstants.BASE_PATH)
public class HealthController {

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Response> health() {
        return ResponseEntity.ok(Response.ok());
    }

}
