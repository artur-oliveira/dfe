package com.softart.dferestapi.configuration.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@ConfigurationProperties("dfe.jwt.auth")
public class JwtProperties {
    private String secret;

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
