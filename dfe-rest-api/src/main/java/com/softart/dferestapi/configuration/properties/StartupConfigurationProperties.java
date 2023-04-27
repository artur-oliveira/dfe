package com.softart.dferestapi.configuration.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@ConfigurationProperties("dfe.startup.config")
public class StartupConfigurationProperties {
    private Boolean updateCertificateChain = Boolean.TRUE;
    private Boolean initializeServices = Boolean.TRUE;

    public void setUpdateCertificateChain(Boolean updateCertificateChain) {
        this.updateCertificateChain = updateCertificateChain;
    }

    public void setInitializeServices(Boolean initializeServices) {
        this.initializeServices = initializeServices;
    }
}
