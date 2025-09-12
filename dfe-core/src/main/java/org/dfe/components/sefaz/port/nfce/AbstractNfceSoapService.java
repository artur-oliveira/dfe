package org.dfe.components.sefaz.port.nfce;

import lombok.Data;
import lombok.SneakyThrows;
import org.dfe.components.security.socket.SocketFactory;
import org.dfe.components.sefaz.port.AbstractSoapService;
import org.dfe.components.sefaz.port.SoapServiceMapping;
import org.dfe.components.sefaz.port.SoapServiceProxy;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.nf.NfceAuthorizer;
import org.dfe.enums.internal.nf.NfcePathEndpoint;
import org.dfe.exceptions.security.SSLContextException;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.internal.config.NfConfig;
import org.dfe.interfaces.sefaz.port.NfceSoapService;
import org.dfe.models.internal.port.NfceServiceFinder;

import javax.net.ssl.HttpsURLConnection;
import java.util.Objects;
import java.util.Optional;

@Data
@SuppressWarnings("unchecked")
public abstract class AbstractNfceSoapService extends AbstractSoapService implements NfceSoapService {
    private Object prodAuthorization;
    private Object homAuthorization;
    private Object prodEvent;
    private Object homEvent;
    private Object prodInutilization;
    private Object homInutilization;
    private Object prodQueryProtocol;
    private Object homQueryProtocol;
    private Object prodQueryStatusService;
    private Object homQueryStatusService;
    private Object prodReturnAuthorization;
    private Object homReturnAuthorization;

    public AbstractNfceSoapService() {
    }

    @SneakyThrows
    public AbstractNfceSoapService(NfConfig config) {
        this.config = config;
    }

    public void initializeDefault(AbstractNfceSoapService abstractNfceSoapService) {
        this.prodAuthorization = Optional.ofNullable(abstractNfceSoapService.prodAuthorization).orElse(this.prodAuthorization);
        this.homAuthorization = Optional.ofNullable(abstractNfceSoapService.homAuthorization).orElse(this.homAuthorization);
        this.prodEvent = Optional.ofNullable(abstractNfceSoapService.prodEvent).orElse(this.prodEvent);
        this.homEvent = Optional.ofNullable(abstractNfceSoapService.homEvent).orElse(this.homEvent);
        this.prodInutilization = Optional.ofNullable(abstractNfceSoapService.prodInutilization).orElse(this.prodInutilization);
        this.homInutilization = Optional.ofNullable(abstractNfceSoapService.homInutilization).orElse(this.homInutilization);
        this.prodQueryProtocol = Optional.ofNullable(abstractNfceSoapService.prodQueryProtocol).orElse(this.prodQueryProtocol);
        this.homQueryProtocol = Optional.ofNullable(abstractNfceSoapService.homQueryProtocol).orElse(this.homQueryProtocol);
        this.prodQueryStatusService = Optional.ofNullable(abstractNfceSoapService.prodQueryStatusService).orElse(this.prodQueryStatusService);
        this.homQueryStatusService = Optional.ofNullable(abstractNfceSoapService.homQueryStatusService).orElse(this.homQueryStatusService);
        this.prodReturnAuthorization = Optional.ofNullable(abstractNfceSoapService.prodReturnAuthorization).orElse(this.prodReturnAuthorization);
        this.homReturnAuthorization = Optional.ofNullable(abstractNfceSoapService.homReturnAuthorization).orElse(this.homReturnAuthorization);
    }

    void fullInitialization(NfceSoapService o) {
        safeInititialization(o::homAuthorization);
        safeInititialization(o::homReturnAuthorization);
        safeInititialization(o::homEvent);
        safeInititialization(o::homInutilization);
        safeInititialization(o::homQueryProtocol);
        safeInititialization(o::homQueryStatusService);
        safeInititialization(o::prodAuthorization);
        safeInititialization(o::prodReturnAuthorization);
        safeInititialization(o::prodEvent);
        safeInititialization(o::prodInutilization);
        safeInititialization(o::prodQueryStatusService);
        safeInititialization(o::prodQueryProtocol);
    }

    public void initialize(NfceSoapService o) {
        this.config = o.getConfig();

        if (o instanceof AbstractNfceSoapService abstractNfceSoapService) {
            initializeDefault(abstractNfceSoapService);
        }

        if (!NfceSoapConfigurationProperties.LAZY_INITIALIZATION) {
            fullInitialization(o);
        }
        SoapServiceProxy.getInstance().addNfceService(this);
        this.initialized = true;
    }

    public void initialize(Config config) throws SSLContextException {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(config).getSocketFactory());
        if (!NfceSoapConfigurationProperties.LAZY_INITIALIZATION) {
            initialize(this);
        }
        SoapServiceProxy.getInstance().addNfceService(this);
        this.initialized = true;
    }

    @Override
    public <T> T prodAuthorization() {
        if (Objects.nonNull(getProdAuthorization())) {
            return (T) getProdAuthorization();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.AUTHORIZATION).build()));
        if (NfceSoapConfigurationProperties.CACHE_PROD_AUTHORIZATION) {
            setProdAuthorization(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homAuthorization() {
        if (Objects.nonNull(getHomAuthorization())) {
            return (T) getHomAuthorization();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.AUTHORIZATION).build()));
        if (NfceSoapConfigurationProperties.CACHE_HOM_AUTHORIZATION) {
            setHomAuthorization(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodEvent() {
        if (Objects.nonNull(getProdEvent())) {
            return (T) getProdEvent();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.EVENT).build()));
        if (NfceSoapConfigurationProperties.CACHE_PROD_EVENT) {
            setProdEvent(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homEvent() {
        if (Objects.nonNull(getHomEvent())) {
            return (T) getHomEvent();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.EVENT).build()));
        if (NfceSoapConfigurationProperties.CACHE_HOM_EVENT) {
            setHomEvent(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodInutilization() {
        if (Objects.nonNull(getProdInutilization())) {
            return (T) getProdInutilization();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.INUTILIZATION).build()));
        if (NfceSoapConfigurationProperties.CACHE_PROD_INUTILIZATION) {
            setProdInutilization(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homInutilization() {
        if (Objects.nonNull(getHomInutilization())) {
            return (T) getHomInutilization();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.INUTILIZATION).build()));
        if (NfceSoapConfigurationProperties.CACHE_HOM_INUTILIZATION) {
            setHomInutilization(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodQueryProtocol() {
        if (Objects.nonNull(getProdQueryProtocol())) {
            return (T) getProdQueryProtocol();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.QUERY_PROTOCOL).build()));
        if (NfceSoapConfigurationProperties.CACHE_PROD_QUERY_PROTOCOL) {
            setProdQueryProtocol(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homQueryProtocol() {
        if (Objects.nonNull(getHomQueryProtocol())) {
            return (T) getHomQueryProtocol();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.QUERY_PROTOCOL).build()));
        if (NfceSoapConfigurationProperties.CACHE_HOM_QUERY_PROTOCOL) {
            setHomQueryProtocol(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodQueryStatusService() {
        if (Objects.nonNull(getProdQueryStatusService())) {
            return (T) getProdQueryStatusService();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.STATUS_SERVICE).build()));
        if (NfceSoapConfigurationProperties.CACHE_PROD_QUERY_STATUS_SERVICE) {
            setProdQueryStatusService(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homQueryStatusService() {
        if (Objects.nonNull(getHomQueryStatusService())) {
            return (T) getHomQueryStatusService();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.STATUS_SERVICE).build()));
        if (NfceSoapConfigurationProperties.CACHE_HOM_QUERY_STATUS_SERVICE) {
            setHomQueryStatusService(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodReturnAuthorization() {
        if (Objects.nonNull(getProdReturnAuthorization())) {
            return (T) getProdReturnAuthorization();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.RETURN_AUTHORIZATION).build()));
        if (NfceSoapConfigurationProperties.CACHE_PROD_RETURN_AUTHORIZATION) {
            setProdReturnAuthorization(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homReturnAuthorization() {
        if (Objects.nonNull(getHomReturnAuthorization())) {
            return (T) getHomReturnAuthorization();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.RETURN_AUTHORIZATION).build()));
        if (NfceSoapConfigurationProperties.CACHE_HOM_RETURN_AUTHORIZATION) {
            setHomReturnAuthorization(o);
        }
        return (T) o;
    }

    public abstract NfceAuthorizer getAuthorizer();

    @Override
    public NfConfig getConfig() {
        return (NfConfig) super.getConfig();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractNfceSoapService that)) return false;
        return Objects.equals(getAuthorizer(), that.getAuthorizer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorizer());
    }

}
