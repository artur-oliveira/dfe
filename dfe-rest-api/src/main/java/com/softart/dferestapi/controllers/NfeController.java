package com.softart.dferestapi.controllers;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.nf.authorization.NfProtocol;
import com.softart.dfe.models.nf.authorization.ReturnSendNf;
import com.softart.dfe.models.nf.authorization.SendNf;
import com.softart.dferestapi.models.Error;
import com.softart.dferestapi.services.nfe.NfeService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/nfe")
@Getter
public final class NfeController {

    private final NfeService nfeService;

    @Autowired
    public NfeController(NfeService nfeService) {
        this.nfeService = nfeService;
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class)
                            ),
                    }
            ),
            @ApiResponse(
                    responseCode = "200",
                    description = "Ok",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ReturnSendNf.class)
                            )
                    }
            )
    })
    @PostMapping(value = "", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<ReturnSendNf> authorization(@RequestBody SendNf nf) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getNfeService().authorization(nf));
    }

}
