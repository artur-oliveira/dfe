package com.softart.dferestapi.services.auth;

import com.softart.dfe.util.DateUtils;
import com.softart.dferestapi.models.auth.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
@ConfigurationProperties("dfe.jwt.auth")
@Getter
@Setter
@Log4j2
public final class JwtServiceImpl implements JwtService {
    private String secret;

    private Key getKey() {
        return Keys.hmacShaKeyFor(getSecret().getBytes(StandardCharsets.UTF_8));
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
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

}
