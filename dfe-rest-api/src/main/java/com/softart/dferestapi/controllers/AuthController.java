package com.softart.dferestapi.controllers;

import com.softart.dferestapi.constants.AuthControllerConstants;
import com.softart.dferestapi.constants.HttpStatusCode;
import com.softart.dferestapi.models.auth.Account;
import com.softart.dferestapi.models.auth.request.LoginRequest;
import com.softart.dferestapi.models.auth.request.RegisterRequest;
import com.softart.dferestapi.models.auth.response.JwtResponse;
import com.softart.dferestapi.models.response.error.CommonError;
import com.softart.dferestapi.models.response.error.ValidationError;
import com.softart.dferestapi.services.auth.AccountService;
import com.softart.dferestapi.services.auth.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(AuthControllerConstants.BASE_PATH)
@Getter
public final class AuthController {

    private final AccountService accountService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Autowired
    public AuthController(AccountService accountService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.accountService = accountService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Operation(summary = AuthControllerConstants.OPENAPI_LOGIN_SUMMARY, tags = AuthControllerConstants.OPEN_API_TAG, description = AuthControllerConstants.OPENAPI_LOGIN_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = JwtResponse.class))})
    })
    @SecurityRequirements
    @PostMapping(value = AuthControllerConstants.LOGIN_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JwtResponse> authenticate(@Valid @RequestBody LoginRequest authRequest) {
        Authentication authentication = getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = getJwtService().generateToken(authentication);
        return ResponseEntity.ok(JwtResponse.builder().accessToken(jwt).build());
    }

    @Operation(summary = AuthControllerConstants.OPENAPI_REGISTER_SUMMARY, tags = AuthControllerConstants.OPEN_API_TAG, description = AuthControllerConstants.OPENAPI_REGISTER_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CREATED, description = HttpStatusCode.CREATED_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Account.class))})
    })
    @SecurityRequirements
    @PostMapping(value = AuthControllerConstants.REGISTER_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Account> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(getAccountService().createAccount(request));
    }
}
