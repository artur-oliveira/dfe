package com.softart.dferestapi.controllers;

import com.softart.dferestapi.models.error.CommonError;
import com.softart.dferestapi.models.auth.Account;
import com.softart.dferestapi.models.auth.request.LoginRequest;
import com.softart.dferestapi.models.auth.request.RegisterRequest;
import com.softart.dferestapi.models.auth.response.JwtResponse;
import com.softart.dferestapi.models.error.ValidationError;
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
@RequestMapping("/api/v1/auth")
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

    @Operation(summary = "JWT Token", tags = "Autenticação", description = "Endpoint de autenticação")
    @ApiResponses({
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = "200", description = "Ok", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = JwtResponse.class))})
    })
    @SecurityRequirements
    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<JwtResponse> authenticate(@Valid @RequestBody LoginRequest authRequest) {
        Authentication authentication = getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = getJwtService().generateToken(authentication);
        return ResponseEntity.ok(JwtResponse.builder().accessToken(jwt).build());
    }

    @Operation(summary = "Criar conta", tags = "Autenticação", description = "Endpoint de criação de conta")
    @ApiResponses({
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = "200", description = "Ok", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Account.class))})
    })
    @SecurityRequirements
    @PostMapping(value = "/register", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Account> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok().body(getAccountService().createAccount(request));
    }
}
