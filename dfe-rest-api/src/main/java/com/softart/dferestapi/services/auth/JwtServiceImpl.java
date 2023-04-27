package com.softart.dferestapi.services.auth;

import com.softart.dfe.util.DateUtils;
import com.softart.dferestapi.configuration.properties.JwtProperties;
import com.softart.dferestapi.models.auth.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
@Getter
@Setter
@Log4j2
public final class JwtServiceImpl implements JwtService {

    private final JwtProperties jwtProperties;

    public JwtServiceImpl(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(getJwtProperties().getSecret().getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String generateToken(Authentication authentication) {
        UserAccount userPrincipal = (UserAccount) authentication.getPrincipal();
        ZonedDateTime now = DateUtils.now();
        return Jwts
                .builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(Date.from(now.toInstant()))
                .setExpiration(Date.from(now.with(LocalTime.MAX).toInstant()))
                .signWith(getKey())
                .compact();
    }

    public Jws<Claims> claims(String authToken) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(authToken);
    }

    @Override
    public String subject(String authToken) {
        return claims(authToken).getBody().getSubject();
    }

    @Override
    public boolean isValid(String authToken) {
        try {
            claims(authToken);
            return true;
        } catch (SignatureException e) {
            log.warn("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.warn("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.warn("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.warn("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.warn("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

}
