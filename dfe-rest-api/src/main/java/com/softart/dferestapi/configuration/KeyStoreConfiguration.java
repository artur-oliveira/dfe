package com.softart.dferestapi.configuration;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.exceptions.security.CertificateException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class KeyStoreConfiguration {

    @Bean("defaultKeyStore")
    public KeyStoreInfo defaultKeyStore() throws CertificateException {
        return KeyStoreFactory.getInstance();
    }

}
