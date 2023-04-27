package com.softart.dferestapi.configuration.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties("dfe.config")
public class DfeConfigConfigurationProperties {
    private String defaultUf;
    private String defaultCnpj;
    private String defaultEnvironment;
    private String defaultCteEmissionType = "1";
    private String defaultMdfeEmissionType = "1";
    private String defaultNfeEmissionType = "1";
    private String defaultNfceEmissionType = "1";
    private String defaultNfeSend = "1";
    private String defaultNfceSend = "1";
    private String defaultCsc;
    private String defaultCscId;

    public void setDefaultUf(String defaultUf) {
        this.defaultUf = defaultUf;
    }

    public void setDefaultCnpj(String defaultCnpj) {
        this.defaultCnpj = defaultCnpj;
    }

    public void setDefaultEnvironment(String defaultEnvironment) {
        this.defaultEnvironment = defaultEnvironment;
    }

    public void setDefaultCteEmissionType(String defaultCteEmissionType) {
        this.defaultCteEmissionType = defaultCteEmissionType;
    }

    public void setDefaultMdfeEmissionType(String defaultMdfeEmissionType) {
        this.defaultMdfeEmissionType = defaultMdfeEmissionType;
    }

    public void setDefaultNfeEmissionType(String defaultNfeEmissionType) {
        this.defaultNfeEmissionType = defaultNfeEmissionType;
    }

    public void setDefaultNfceEmissionType(String defaultNfceEmissionType) {
        this.defaultNfceEmissionType = defaultNfceEmissionType;
    }

    public void setDefaultNfeSend(String defaultNfeSend) {
        this.defaultNfeSend = defaultNfeSend;
    }

    public void setDefaultNfceSend(String defaultNfceSend) {
        this.defaultNfceSend = defaultNfceSend;
    }

    public void setDefaultCsc(String defaultCsc) {
        this.defaultCsc = defaultCsc;
    }

    public void setDefaultCscId(String defaultCscId) {
        this.defaultCscId = defaultCscId;
    }
}
