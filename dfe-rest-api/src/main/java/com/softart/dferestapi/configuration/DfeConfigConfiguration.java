package com.softart.dferestapi.configuration;

import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.components.internal.config.PfxMdfeConfigImpl;
import com.softart.dfe.components.internal.config.PfxNfConfigImpl;
import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.identification.MdfeEmissionType;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
@ConfigurationProperties("dfe.config")
@Getter
@Setter
public class DfeConfigConfiguration {

    private final KeyStoreInfo defaultKeyStore;

    private String defaultUf;
    private String defaultCnpj;
    private String defaultEnvironment;
    private String defaultCteEmissionType = "1";
    private String defaultNfeEmissionType = "1";
    private String defaultMdfeEmissionType = "1";
    private String defaultNfeSend = "1";
    private String csc;
    private String cscId;

    public DfeConfigConfiguration(@Qualifier("defaultKeyStore") KeyStoreInfo defaultKeyStore) {
        this.defaultKeyStore = defaultKeyStore;
    }

    @Bean("defaultCteConfig")
    public CteConfig defaultCteConfig() throws SSLContextException {
        return new PfxCteConfigImpl(UF.valueOfCode(getDefaultUf()), getDefaultCnpj(), Environment.valueOfCode(getDefaultEnvironment()), getDefaultKeyStore(), CteEmissionType.valueOfCode(getDefaultCteEmissionType()));
    }

    @Bean("defaultNfConfig")
    public NfConfig defaultNfeConfig() throws SSLContextException {
        return new PfxNfConfigImpl(UF.valueOfCode(getDefaultUf()), getDefaultCnpj(), Environment.valueOfCode(getDefaultEnvironment()), getDefaultKeyStore(), NFEmissionType.valueOfCode(getDefaultNfeEmissionType()), NFSend.valueOfCode(getDefaultNfeSend()), getCsc(), getCscId());
    }

    @Bean("defaultMdfeConfig")
    public MdfeConfig defaultMdfeConfig() throws SSLContextException {
        return new PfxMdfeConfigImpl(UF.valueOfCode(getDefaultUf()), getDefaultCnpj(), Environment.valueOfCode(getDefaultEnvironment()), getDefaultKeyStore(), MdfeEmissionType.valueOfCode(getDefaultMdfeEmissionType()));
    }

    @Bean
    @Scope("prototype")
    @Primary
    public CteConfig cteConfig() throws SSLContextException {
        return null;
    }

    @Bean
    @Scope("prototype")
    @Primary
    public NfConfig nfConfig() throws SSLContextException {
        return null;
    }

    @Bean
    @Scope("prototype")
    @Primary
    public MdfeConfig mdfeConfig() throws SSLContextException {
        return null;
    }
}
