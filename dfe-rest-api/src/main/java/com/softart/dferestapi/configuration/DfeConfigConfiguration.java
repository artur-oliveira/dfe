package com.softart.dferestapi.configuration;

import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.components.internal.config.PfxMdfeConfigImpl;
import com.softart.dfe.components.internal.config.PfxNfceConfigImpl;
import com.softart.dfe.components.internal.config.PfxNfeConfigImpl;
import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.identification.MdfeEmissionType;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dferestapi.components.config.NoOpCteConfig;
import com.softart.dferestapi.components.config.NoOpMdfeConfig;
import com.softart.dferestapi.components.config.NoOpNfceConfig;
import com.softart.dferestapi.components.config.NoOpNfeConfig;
import com.softart.dferestapi.configuration.properties.DfeConfigConfigurationProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class DfeConfigConfiguration {

    private final KeyStoreInfo defaultKeyStore;
    private final DfeConfigConfigurationProperties dfeConfigConfigurationProperties;


    public DfeConfigConfiguration(
            @Qualifier("defaultKeyStore") KeyStoreInfo defaultKeyStore,
            DfeConfigConfigurationProperties dfeConfigConfigurationProperties
    ) {
        this.defaultKeyStore = defaultKeyStore;
        this.dfeConfigConfigurationProperties = dfeConfigConfigurationProperties;
    }

    @Bean("defaultCteConfig")
    public CteConfig defaultCteConfig() {
        try {
            return new PfxCteConfigImpl(
                    UF.valueOfCode(getDfeConfigConfigurationProperties().getDefaultUf()),
                    getDfeConfigConfigurationProperties().getDefaultCnpj(),
                    Environment.valueOfCode(getDfeConfigConfigurationProperties().getDefaultEnvironment()),
                    getDefaultKeyStore(),
                    CteEmissionType.valueOfCode(getDfeConfigConfigurationProperties().getDefaultCteEmissionType())
            );
        } catch (Exception e) {
            return new NoOpCteConfig();
        }
    }

    @Bean("defaultNfceConfig")
    public NfceConfig defaultNfceConfig() {
        try {
            return new PfxNfceConfigImpl(
                    UF.valueOfCode(getDfeConfigConfigurationProperties().getDefaultUf()),
                    getDfeConfigConfigurationProperties().getDefaultCnpj(),
                    Environment.valueOfCode(getDfeConfigConfigurationProperties().getDefaultEnvironment()),
                    getDefaultKeyStore(),
                    NFEmissionType.valueOfCode(getDfeConfigConfigurationProperties().getDefaultNfceEmissionType()),
                    NFSend.valueOfCode(getDfeConfigConfigurationProperties().getDefaultNfceSend()),
                    getDfeConfigConfigurationProperties().getDefaultCsc(),
                    getDfeConfigConfigurationProperties().getDefaultCscId()
            );
        } catch (Exception e) {
            return new NoOpNfceConfig();
        }
    }


    @Bean("defaultNfeConfig")
    public NfeConfig defaultNfeConfig() {
        try {
            return new PfxNfeConfigImpl(UF.valueOfCode(getDfeConfigConfigurationProperties().getDefaultUf()),
                    getDfeConfigConfigurationProperties().getDefaultCnpj(),
                    Environment.valueOfCode(getDfeConfigConfigurationProperties().getDefaultEnvironment()),
                    getDefaultKeyStore(),
                    NFEmissionType.valueOfCode(getDfeConfigConfigurationProperties().getDefaultNfeEmissionType()),
                    NFSend.valueOfCode(getDfeConfigConfigurationProperties().getDefaultNfeSend())
            );
        } catch (Exception e) {
            return new NoOpNfeConfig();
        }
    }

    @Bean("defaultMdfeConfig")
    public MdfeConfig defaultMdfeConfig() {
        try {
            return new PfxMdfeConfigImpl(
                    UF.valueOfCode(getDfeConfigConfigurationProperties().getDefaultUf()),
                    getDfeConfigConfigurationProperties().getDefaultCnpj(),
                    Environment.valueOfCode(getDfeConfigConfigurationProperties().getDefaultEnvironment()),
                    getDefaultKeyStore(),
                    MdfeEmissionType.valueOfCode(getDfeConfigConfigurationProperties().getDefaultMdfeEmissionType())
            );
        } catch (Exception e) {
            return new NoOpMdfeConfig();
        }
    }
}
