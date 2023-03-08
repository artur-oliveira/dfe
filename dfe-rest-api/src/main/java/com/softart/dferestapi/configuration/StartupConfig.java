package com.softart.dferestapi.configuration;

import com.softart.dfe.components.security.chain.CertificateChainFactory;
import com.softart.dfe.components.sefaz.SoapService;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.models.internal.security.Certificate;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Log4j2
@Getter
@Setter
public class StartupConfig {

    private final NfConfig nfConfig;
    private final CteConfig cteConfig;
    private final MdfeConfig mdfeConfig;

    public StartupConfig(
            @Qualifier("defaultNfConfig") NfConfig nfConfig,
            @Qualifier("defaultCteConfig") CteConfig cteConfig,
            @Qualifier("defaultMdfeConfig") MdfeConfig mdfeConfig
    ) {
        this.nfConfig = nfConfig;
        this.cteConfig = cteConfig;
        this.mdfeConfig = mdfeConfig;
    }

    @PostConstruct
    public void startupCertificateChain() {
        log.info("generating certificate chain");
        CertificateChainFactory.getInstance().generate(Certificate.builder().build());
        log.info("generated certificate chain");
    }

    @PostConstruct
    public void startupSoapService() throws SoapServiceGeneralException {
        log.info("initializing soap services");
        SoapService.getInstance().getCteSoapService(getCteConfig());
        SoapService.getInstance().getNfceSoapService(getNfConfig());
        SoapService.getInstance().getNfeSoapService(getNfConfig());
        SoapService.getInstance().getMdfeSoapService(getMdfeConfig());
        log.info("finishing soap services");
    }

}
