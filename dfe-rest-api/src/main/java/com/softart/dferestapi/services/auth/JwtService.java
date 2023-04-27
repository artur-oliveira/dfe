package com.softart.dferestapi.services.auth;

import org.springframework.security.core.Authentication;

public interface JwtService {

    String generateToken(Authentication authentication);

    String subject(String authToken);

    boolean isValid(String authToken);

}
