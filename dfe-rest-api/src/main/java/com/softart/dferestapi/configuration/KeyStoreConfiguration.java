package com.softart.dferestapi.configuration;

import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dferestapi.components.certificate.NoOpKeyStore;
import com.softart.dferestapi.configuration.properties.KeyStoreConfigurationProperties;
import com.softart.dferestapi.services.certificate.KeyStoreService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class KeyStoreConfiguration {

    private final KeyStoreService keyStoreService;
    private final KeyStoreConfigurationProperties keyStoreConfigurationProperties;

    public KeyStoreConfiguration(
            KeyStoreService keyStoreService,
            KeyStoreConfigurationProperties keyStoreConfigurationProperties
    ) {
        this.keyStoreService = keyStoreService;
        this.keyStoreConfigurationProperties = keyStoreConfigurationProperties;
    }

    @Bean("defaultKeyStore")
    public KeyStoreInfo defaultKeyStore() {
        try {
            return getKeyStoreService().getKeyStore(
                    getKeyStoreConfigurationProperties().getCertificateKey(),
                    getKeyStoreConfigurationProperties().getCertificatePassword()
            );
        } catch (Exception e) {
            return new NoOpKeyStore();
        }
    }

}
