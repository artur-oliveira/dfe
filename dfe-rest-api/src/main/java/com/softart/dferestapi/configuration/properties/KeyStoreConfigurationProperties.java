package com.softart.dferestapi.configuration.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@ConfigurationProperties("dfe.keystore.config")
public class KeyStoreConfigurationProperties {
    private String certificateKey;
    private String certificatePassword;
    private String baseCertificatePath;

    public void setCertificateKey(String certificateKey) {
        this.certificateKey = certificateKey;
    }

    public void setCertificatePassword(String certificatePassword) {
        this.certificatePassword = certificatePassword;
    }

    public void setBaseCertificatePath(String baseCertificatePath) {
        this.baseCertificatePath = baseCertificatePath;
    }
}
