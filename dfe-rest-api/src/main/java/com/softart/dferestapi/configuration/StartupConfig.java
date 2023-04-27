package com.softart.dferestapi.configuration;

import com.softart.dfe.components.security.chain.CertificateChainFactory;
import com.softart.dfe.components.sefaz.SoapService;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dfe.models.internal.security.Certificate;
import com.softart.dferestapi.configuration.properties.StartupConfigurationProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@Log4j2
@Getter
@Setter
public class StartupConfig {

    private final NfceConfig nfceConfig;
    private final NfeConfig nfeConfig;
    private final CteConfig cteConfig;
    private final MdfeConfig mdfeConfig;
    private final StartupConfigurationProperties startupConfigurationProperties;

    public StartupConfig(
            @Qualifier("defaultNfceConfig") NfceConfig nfceConfig,
            @Qualifier("defaultNfeConfig") NfeConfig nfeConfig,
            @Qualifier("defaultCteConfig") CteConfig cteConfig,
            @Qualifier("defaultMdfeConfig") MdfeConfig mdfeConfig,
            StartupConfigurationProperties startupConfigurationProperties
    ) {
        this.nfceConfig = nfceConfig;
        this.nfeConfig = nfeConfig;
        this.cteConfig = cteConfig;
        this.mdfeConfig = mdfeConfig;
        this.startupConfigurationProperties = startupConfigurationProperties;
    }

    @PostConstruct
    public void startupCertificateChain() {
        if (getStartupConfigurationProperties().getUpdateCertificateChain()) {
            log.info("generating certificate chain");
            CertificateChainFactory.getInstance().generate(Certificate.builder().build());
            log.info("generated certificate chain");
        }
    }

    @PostConstruct
    public void startupSoapService() throws SoapServiceGeneralException {
        if (getStartupConfigurationProperties().getInitializeServices()) {
            log.info("initializing soap services");
            ExecutorService service = Executors.newFixedThreadPool(4);
            service.submit(() -> {
                try {
                    SoapService.getInstance().getAllMdfeSoapService(getMdfeConfig());
                    log.info("finished mdfe soap services");
                } catch (SoapServiceGeneralException e) {
                    throw new RuntimeException(e);
                }
            });
            service.submit(() -> {
                try {
                    SoapService.getInstance().getAllCteSoapService(getCteConfig());
                    log.info("finished cte soap services");
                } catch (SoapServiceGeneralException e) {
                    throw new RuntimeException(e);
                }
            });
            service.submit(() -> {
                try {
                    SoapService.getInstance().getAllNfeSoapService(getNfeConfig());
                    log.info("finished nfe soap services");
                } catch (SoapServiceGeneralException e) {
                    throw new RuntimeException(e);
                }
            });
            service.submit(() -> {
                try {
                    SoapService.getInstance().getAllNfceSoapService(getNfceConfig());
                    log.info("finished nfce soap services");
                } catch (SoapServiceGeneralException e) {
                    throw new RuntimeException(e);
                }
            });
            service.shutdown();
        }
    }

}
