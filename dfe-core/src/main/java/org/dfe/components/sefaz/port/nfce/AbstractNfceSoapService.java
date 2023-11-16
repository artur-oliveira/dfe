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
    private Object prodCancel;
    private Object homCancel;
    private Object prodInutilization;
    private Object homInutilization;
    private Object prodQueryProtocol;
    private Object homQueryProtocol;
    private Object prodQueryStatusService;
    private Object homQueryStatusService;
    private Object prodReturnAuthorization;
    private Object homReturnAuthorization;
    private Object prodSubstituteCancel;
    private Object homSubstituteCancel;

    public AbstractNfceSoapService() {
    }

    @SneakyThrows
    public AbstractNfceSoapService(NfConfig config) {
        this.config = config;
    }

    public void initializeDefault(AbstractNfceSoapService abstractNfceSoapService) {
        this.prodAuthorization = Optional.ofNullable(abstractNfceSoapService.prodAuthorization).orElse(this.prodAuthorization);
        this.homAuthorization = Optional.ofNullable(abstractNfceSoapService.homAuthorization).orElse(this.homAuthorization);
        this.prodCancel = Optional.ofNullable(abstractNfceSoapService.prodCancel).orElse(this.prodCancel);
        this.homCancel = Optional.ofNullable(abstractNfceSoapService.homCancel).orElse(this.homCancel);
        this.prodInutilization = Optional.ofNullable(abstractNfceSoapService.prodInutilization).orElse(this.prodInutilization);
        this.homInutilization = Optional.ofNullable(abstractNfceSoapService.homInutilization).orElse(this.homInutilization);
        this.prodQueryProtocol = Optional.ofNullable(abstractNfceSoapService.prodQueryProtocol).orElse(this.prodQueryProtocol);
        this.homQueryProtocol = Optional.ofNullable(abstractNfceSoapService.homQueryProtocol).orElse(this.homQueryProtocol);
        this.prodQueryStatusService = Optional.ofNullable(abstractNfceSoapService.prodQueryStatusService).orElse(this.prodQueryStatusService);
        this.homQueryStatusService = Optional.ofNullable(abstractNfceSoapService.homQueryStatusService).orElse(this.homQueryStatusService);
        this.prodReturnAuthorization = Optional.ofNullable(abstractNfceSoapService.prodReturnAuthorization).orElse(this.prodReturnAuthorization);
        this.homReturnAuthorization = Optional.ofNullable(abstractNfceSoapService.homReturnAuthorization).orElse(this.homReturnAuthorization);
        this.prodSubstituteCancel = Optional.ofNullable(abstractNfceSoapService.prodSubstituteCancel).orElse(this.prodSubstituteCancel);
        this.homSubstituteCancel = Optional.ofNullable(abstractNfceSoapService.homSubstituteCancel).orElse(this.homSubstituteCancel);
    }

    public void initialize(NfceSoapService o) {
        this.config = o.getConfig();

        if (o instanceof AbstractNfceSoapService abstractNfceSoapService) {
            initializeDefault(abstractNfceSoapService);
        }

        if (!LAZY_INITIALIZATION) {
            try {
                o.homAuthorization();
            } catch (Exception ignored) {
            }
            try {
                o.homReturnAuthorization();
            } catch (Exception ignored) {
            }
            try {
                o.homCancel();
            } catch (Exception ignored) {
            }
            try {
                o.homInutilization();
            } catch (Exception ignored) {
            }
            try {
                o.homQueryProtocol();
            } catch (Exception ignored) {
            }
            try {
                o.homQueryStatusService();
            } catch (Exception ignored) {
            }
            try {
                o.prodAuthorization();
            } catch (Exception ignored) {
            }
            try {
                o.prodReturnAuthorization();
            } catch (Exception ignored) {
            }
            try {
                o.prodCancel();
            } catch (Exception ignored) {
            }
            try {
                o.prodInutilization();
            } catch (Exception ignored) {
            }
            try {
                o.prodQueryStatusService();
            } catch (Exception ignored) {
            }
            try {
                o.prodQueryProtocol();
            } catch (Exception ignored) {
            }
            try {
                o.homSubstituteCancel();
            } catch (Exception ignored) {
            }
            try {
                o.prodSubstituteCancel();
            } catch (Exception ignored) {
            }
        }
        SoapServiceProxy.getInstance().addNfceService(this);
        this.initialized = true;
    }

    public void initialize(Config config) throws SSLContextException {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(config).getSocketFactory());
        if (!LAZY_INITIALIZATION) {
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
        setProdAuthorization(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.AUTHORIZATION).build())));
        return (T) getProdAuthorization();
    }

    @Override
    public <T> T homAuthorization() {
        if (Objects.nonNull(getHomAuthorization())) {
            return (T) getHomAuthorization();
        }
        setHomAuthorization(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.AUTHORIZATION).build())));
        return (T) getHomAuthorization();
    }

    @Override
    public <T> T prodCancel() {
        if (Objects.nonNull(getProdCancel())) {
            return (T) getProdCancel();
        }
        setProdCancel(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.EVENT_CANCEL).build())));
        return (T) getProdCancel();
    }

    @Override
    public <T> T homCancel() {
        if (Objects.nonNull(getHomCancel())) {
            return (T) getHomCancel();
        }
        setHomCancel(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.EVENT_CANCEL).build())));
        return (T) getHomCancel();
    }

    @Override
    public <T> T prodInutilization() {
        if (Objects.nonNull(getProdInutilization())) {
            return (T) getProdInutilization();
        }
        setProdInutilization(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.INUTILIZATION).build())));
        return (T) getProdInutilization();
    }

    @Override
    public <T> T homInutilization() {
        if (Objects.nonNull(getHomInutilization())) {
            return (T) getHomInutilization();
        }
        setHomInutilization(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.INUTILIZATION).build())));
        return (T) getHomInutilization();
    }

    @Override
    public <T> T prodQueryProtocol() {
        if (Objects.nonNull(getProdQueryProtocol())) {
            return (T) getProdQueryProtocol();
        }
        setProdQueryProtocol(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.QUERY_PROTOCOL).build())));
        return (T) getProdQueryProtocol();
    }

    @Override
    public <T> T homQueryProtocol() {
        if (Objects.nonNull(getHomQueryProtocol())) {
            return (T) getHomQueryProtocol();
        }
        setHomQueryProtocol(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.QUERY_PROTOCOL).build())));
        return (T) getHomQueryProtocol();
    }

    @Override
    public <T> T prodQueryStatusService() {
        if (Objects.nonNull(getProdQueryStatusService())) {
            return (T) getProdQueryStatusService();
        }
        setProdQueryStatusService(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.STATUS_SERVICE).build())));
        return (T) getProdQueryStatusService();
    }

    @Override
    public <T> T homQueryStatusService() {
        if (Objects.nonNull(getHomQueryStatusService())) {
            return (T) getHomQueryStatusService();
        }
        setHomQueryStatusService(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.STATUS_SERVICE).build())));
        return (T) getHomQueryStatusService();
    }

    @Override
    public <T> T prodReturnAuthorization() {
        if (Objects.nonNull(getProdReturnAuthorization())) {
            return (T) getProdReturnAuthorization();
        }
        setProdReturnAuthorization(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.RETURN_AUTHORIZATION).build())));
        return (T) getProdReturnAuthorization();
    }

    @Override
    public <T> T homReturnAuthorization() {
        if (Objects.nonNull(getHomReturnAuthorization())) {
            return (T) getHomReturnAuthorization();
        }
        setHomReturnAuthorization(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.RETURN_AUTHORIZATION).build())));
        return (T) getHomReturnAuthorization();
    }

    @Override
    public <T> T prodSubstituteCancel() {
        if (Objects.nonNull(getProdSubstituteCancel())) {
            return (T) getProdSubstituteCancel();
        }
        setProdSubstituteCancel(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.EVENT_SUBSTITUTE_CANCEL).build())));
        return (T) getProdSubstituteCancel();
    }

    @Override
    public <T> T homSubstituteCancel() {
        if (Objects.nonNull(getHomSubstituteCancel())) {
            return (T) getHomSubstituteCancel();
        }
        setHomSubstituteCancel(newServiceInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.EVENT_SUBSTITUTE_CANCEL).build())));
        return (T) getHomSubstituteCancel();
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
