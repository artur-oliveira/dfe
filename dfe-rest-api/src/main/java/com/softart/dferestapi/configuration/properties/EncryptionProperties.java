package com.softart.dferestapi.configuration.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@ConfigurationProperties("dfe.encrypt")
public class EncryptionProperties {
    private String key;

    public void setKey(String key) {
        this.key = key;
    }
}
