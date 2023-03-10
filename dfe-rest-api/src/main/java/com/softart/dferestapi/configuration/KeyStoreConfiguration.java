package com.softart.dferestapi.configuration;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.exceptions.security.CertificateException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dferestapi.components.certificate.S3PfxKeyStoreInfoImpl;
import com.softart.dferestapi.services.auth.AccountService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
@Getter
@Setter
@ConfigurationProperties("dfe.keystore")
public class KeyStoreConfiguration {

    private String bucket;
    private String baseCertificatePath;

    @Bean("defaultKeyStore")
    public KeyStoreInfo defaultKeyStore() throws CertificateException {
        return KeyStoreFactory.getInstance();
    }

}
