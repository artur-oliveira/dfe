package org.dfe.components.sefaz.port.nfe;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.dfe.components.security.socket.SocketFactory;
import org.dfe.components.sefaz.port.AbstractSoapService;
import org.dfe.components.sefaz.port.SoapServiceMapping;
import org.dfe.components.sefaz.port.SoapServiceProxy;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.enums.internal.nf.NfePathEndpoint;
import org.dfe.exceptions.security.SSLContextException;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.internal.config.NfConfig;
import org.dfe.interfaces.sefaz.port.NfeSoapService;
import org.dfe.models.internal.port.NfeServiceFinder;

import javax.net.ssl.HttpsURLConnection;
import java.util.Objects;
import java.util.Optional;

@Data
@SuppressWarnings("unchecked")
@Log4j2
public abstract class AbstractNfeSoapService extends AbstractSoapService implements NfeSoapService {
    private Object homAuthorization;
    private Object homReturnAuthorization;
    private Object homEvent;
    private Object homInutilization;
    private Object homQueryProtocol;
    private Object homQueryStatusService;
    private Object prodAuthorization;
    private Object prodReturnAuthorization;
    private Object prodEvent;
    private Object prodInutilization;
    private Object prodQueryStatusService;
    private Object prodQueryProtocol;
    private Object prodQueryRegister;
    private Object homQueryRegister;
    private Object homDistribution;
    private Object prodDistribution;
    private Object queryGtin;

    public AbstractNfeSoapService() {
        super();
    }

    public AbstractNfeSoapService(NfConfig config) {
        super(config);
    }

    void initializeDefault(AbstractNfeSoapService abstractNfeSoapService) {
        this.homAuthorization = Optional.ofNullable(abstractNfeSoapService.homAuthorization).orElse(this.homAuthorization);
        this.homReturnAuthorization = Optional.ofNullable(abstractNfeSoapService.homReturnAuthorization).orElse(this.homReturnAuthorization);
        this.homEvent = Optional.ofNullable(abstractNfeSoapService.homEvent).orElse(this.homEvent);
        this.homInutilization = Optional.ofNullable(abstractNfeSoapService.homInutilization).orElse(this.homInutilization);
        this.homQueryProtocol = Optional.ofNullable(abstractNfeSoapService.homQueryProtocol).orElse(this.homQueryProtocol);
        this.homQueryStatusService = Optional.ofNullable(abstractNfeSoapService.homQueryStatusService).orElse(this.homQueryStatusService);
        this.prodAuthorization = Optional.ofNullable(abstractNfeSoapService.prodAuthorization).orElse(this.prodAuthorization);
        this.prodReturnAuthorization = Optional.ofNullable(abstractNfeSoapService.prodReturnAuthorization).orElse(this.prodReturnAuthorization);
        this.prodEvent = Optional.ofNullable(abstractNfeSoapService.prodEvent).orElse(this.prodEvent);
        this.prodInutilization = Optional.ofNullable(abstractNfeSoapService.prodInutilization).orElse(this.prodInutilization);
        this.prodQueryStatusService = Optional.ofNullable(abstractNfeSoapService.prodQueryStatusService).orElse(this.prodQueryStatusService);
        this.prodQueryProtocol = Optional.ofNullable(abstractNfeSoapService.prodQueryProtocol).orElse(this.prodQueryProtocol);
        this.prodQueryRegister = Optional.ofNullable(abstractNfeSoapService.prodQueryRegister).orElse(this.prodQueryRegister);
        this.homQueryRegister = Optional.ofNullable(abstractNfeSoapService.homQueryRegister).orElse(this.homQueryRegister);
        this.homDistribution = Optional.ofNullable(abstractNfeSoapService.homDistribution).orElse(this.homDistribution);
        this.prodDistribution = Optional.ofNullable(abstractNfeSoapService.prodDistribution).orElse(this.prodDistribution);
        this.queryGtin = Optional.ofNullable(abstractNfeSoapService.queryGtin).orElse(this.queryGtin);
    }

    void fullInitialization(NfeSoapService o) {
        // Initialize homologation services
        safeInititialization(o::homAuthorization);
        safeInititialization(o::homReturnAuthorization);
        safeInititialization(o::homEvent);
        safeInititialization(o::homInutilization);
        safeInititialization(o::homQueryProtocol);
        safeInititialization(o::homQueryRegister);
        safeInititialization(o::homQueryStatusService);
        safeInititialization(o::homDistribution);

        // Initialize production services
        safeInititialization(o::prodAuthorization);
        safeInititialization(o::prodReturnAuthorization);
        safeInititialization(o::prodEvent);
        safeInititialization(o::prodInutilization);
        safeInititialization(o::prodQueryStatusService);
        safeInititialization(o::prodQueryRegister);
        safeInititialization(o::prodDistribution);
        safeInititialization(o::queryGtin);
    }

    public void initialize(NfeSoapService o) {
        this.config = o.getConfig();

        if (o instanceof AbstractNfeSoapService abstractNfeSoapService) {
            initializeDefault(abstractNfeSoapService);
        }

        if (!NfeSoapConfigurationProperties.LAZY_INITIALIZATION) {
            fullInitialization(o);
        }
        SoapServiceProxy.getInstance().addNfeService(this);
        this.initialized = true;
    }

    public void initialize(Config config) throws SSLContextException {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(config).getSocketFactory());

        if (!NfeSoapConfigurationProperties.LAZY_INITIALIZATION) {
            initialize(this);
        }

        SoapServiceProxy.getInstance().addNfeService(this);
        this.initialized = true;
    }

    @Override
    public <T> T homAuthorization() {
        if (Objects.nonNull(getHomAuthorization())) {
            return (T) getHomAuthorization();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.AUTHORIZATION).build()));
        if (NfeSoapConfigurationProperties.CACHE_HOM_AUTHORIZATION) {
            setHomAuthorization(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homEvent() {
        if (Objects.nonNull(getHomEvent())) {
            return (T) getHomEvent();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT).build()));
        if (NfeSoapConfigurationProperties.CACHE_PROD_EVENT) {
            setHomEvent(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homInutilization() {
        if (Objects.nonNull(getHomInutilization())) {
            return (T) getHomInutilization();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.INUTILIZATION).build()));
        if (NfeSoapConfigurationProperties.CACHE_HOM_INUTILIZATION) {
            setHomInutilization(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homQueryProtocol() {
        if (Objects.nonNull(getHomQueryProtocol())) {
            return (T) getHomQueryProtocol();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.QUERY_PROTOCOL).build()));
        if (NfeSoapConfigurationProperties.CACHE_HOM_QUERY_PROTOCOL) {
            setHomQueryProtocol(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homQueryStatusService() {
        if (Objects.nonNull(getHomQueryStatusService())) {
            return (T) getHomQueryStatusService();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.STATUS_SERVICE).build()));
        if (NfeSoapConfigurationProperties.CACHE_HOM_QUERY_STATUS_SERVICE) {
            setHomQueryStatusService(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homReturnAuthorization() {
        if (Objects.nonNull(getHomReturnAuthorization())) {
            return (T) getHomReturnAuthorization();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.RETURN_AUTHORIZATION).build()));
        if (NfeSoapConfigurationProperties.CACHE_HOM_RETURN_AUTHORIZATION) {
            setHomReturnAuthorization(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodAuthorization() {
        if (Objects.nonNull(getProdAuthorization())) {
            return (T) getProdAuthorization();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.AUTHORIZATION).build()));
        if (NfeSoapConfigurationProperties.CACHE_PROD_AUTHORIZATION) {
            setProdAuthorization(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodReturnAuthorization() {
        if (Objects.nonNull(getProdReturnAuthorization())) {
            return (T) getProdReturnAuthorization();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.RETURN_AUTHORIZATION).build()));
        if (NfeSoapConfigurationProperties.CACHE_PROD_RETURN_AUTHORIZATION) {
            setProdReturnAuthorization(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodEvent() {
        if (Objects.nonNull(getProdEvent())) {
            return (T) getProdEvent();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT).build()));
        if (NfeSoapConfigurationProperties.CACHE_PROD_EVENT) {
            setProdEvent(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodInutilization() {
        if (Objects.nonNull(getProdInutilization())) {
            return (T) getProdInutilization();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.INUTILIZATION).build()));
        if (NfeSoapConfigurationProperties.CACHE_PROD_INUTILIZATION) {
            setProdInutilization(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodQueryStatusService() {
        if (Objects.nonNull(getProdQueryStatusService())) {
            return (T) getProdQueryStatusService();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.STATUS_SERVICE).build()));
        if (NfeSoapConfigurationProperties.CACHE_PROD_QUERY_STATUS_SERVICE) {
            setProdQueryStatusService(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodQueryProtocol() {
        if (Objects.nonNull(getProdQueryProtocol())) {
            return (T) getProdQueryProtocol();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.QUERY_PROTOCOL).build()));
        if (NfeSoapConfigurationProperties.CACHE_PROD_QUERY_PROTOCOL) {
            setProdQueryProtocol(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homDistribution() {
        if (Objects.nonNull(getHomDistribution())) {
            return (T) getHomDistribution();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.DISTRIBUTION).build()));
        if (NfeSoapConfigurationProperties.CACHE_HOM_DISTRIBUTION) {
            setHomDistribution(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodDistribution() {
        if (Objects.nonNull(getProdDistribution())) {
            return (T) getProdDistribution();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.DISTRIBUTION).build()));
        if (NfeSoapConfigurationProperties.CACHE_PROD_DISTRIBUTION) {
            setProdDistribution(o);
        }
        return (T) o;
    }

    @Override
    public <T> T homQueryRegister() {
        if (Objects.nonNull(getHomQueryRegister())) {
            return (T) getHomQueryRegister();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.QUERY_REGISTER).build()));
        if (NfeSoapConfigurationProperties.CACHE_HOM_QUERY_REGISTER) {
            setHomQueryRegister(o);
        }
        return (T) o;
    }

    @Override
    public <T> T prodQueryRegister() {
        if (Objects.nonNull(getProdQueryRegister())) {
            return (T) getProdQueryRegister();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.QUERY_REGISTER).build()));
        if (NfeSoapConfigurationProperties.CACHE_PROD_QUERY_REGISTER) {
            setProdQueryRegister(o);
        }
        return (T) o;
    }

    @Override
    public <T> T queryGtin() {
        if (Objects.nonNull(getQueryGtin())) {
            return (T) getQueryGtin();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.SVRS).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.QUERY_GTIN).build()));
        if (NfeSoapConfigurationProperties.CACHE_QUERY_GTIN) {
            setQueryGtin(o);
        }
        return (T) o;
    }

    @Override
    public NfConfig getConfig() {
        return (NfConfig) super.getConfig();
    }

    public abstract NfeAuthorizer getAuthorizer();

    public NfeAuthorizer getServiceFinderAuthorizer() {
        return getAuthorizer();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractNfeSoapService that)) return false;
        return Objects.equals(getAuthorizer(), that.getAuthorizer()) && Objects.equals(getServiceFinderAuthorizer(), that.getServiceFinderAuthorizer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorizer(), getServiceFinderAuthorizer());
    }

}
