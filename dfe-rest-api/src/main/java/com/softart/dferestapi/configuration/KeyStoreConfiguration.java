package com.softart.dferestapi.configuration;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.exceptions.security.CertificateException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dferestapi.components.certificate.NoOpKeyStore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties("dfe.keystore")
public class KeyStoreConfiguration {

    private String bucket;
    private String baseCertificatePath;

    @Bean("defaultKeyStore")
    public KeyStoreInfo defaultKeyStore() throws CertificateException {
        try {
            return KeyStoreFactory.getInstance();
        } catch (CertificateException e) {
            throw e;
        } catch (Exception e) {
            return new NoOpKeyStore();
        }
    }

}
