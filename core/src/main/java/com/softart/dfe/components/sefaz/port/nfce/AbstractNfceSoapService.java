package com.softart.dfe.components.sefaz.port.nfce;

import com.softart.dfe.components.security.socket.SocketFactory;
import com.softart.dfe.components.sefaz.port.AbstractSoapService;
import com.softart.dfe.components.sefaz.port.SoapServiceMapping;
import com.softart.dfe.components.sefaz.port.SoapServiceProxy;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.nf.NfceAuthorizer;
import com.softart.dfe.enums.internal.nf.NfcePathEndpoint;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.port.NfceSoapService;
import com.softart.dfe.models.internal.port.NfceServiceFinder;
import com.softart.dfe.util.ReflectionUtils;
import lombok.Data;
import lombok.SneakyThrows;

import javax.net.ssl.HttpsURLConnection;
import java.util.Objects;

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

    public void initialize(NfceSoapService cached) {
        this.config = cached.getConfig();
        this.homAuthorization = cached.homAuthorization();
        this.homReturnAuthorization = cached.homReturnAuthorization();
        this.homCancel = cached.homCancel();
        this.homInutilization = cached.homInutilization();
        this.homQueryProtocol = cached.homQueryProtocol();
        this.homQueryStatusService = cached.homQueryStatusService();
        this.prodAuthorization = cached.prodAuthorization();
        this.prodReturnAuthorization = cached.prodReturnAuthorization();
        this.prodCancel = cached.prodCancel();
        this.prodInutilization = cached.prodInutilization();
        this.prodQueryStatusService = cached.prodQueryStatusService();
        this.prodQueryProtocol = cached.prodQueryProtocol();
        this.homSubstituteCancel = cached.homSubstituteCancel();
        this.prodSubstituteCancel = cached.prodSubstituteCancel();
        this.initialized = true;
    }

    public void initialize(Config config) throws SSLContextException {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(config).getSocketFactory());
        this.homAuthorization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.AUTHORIZATION).build()));
        this.homReturnAuthorization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.RETURN_AUTHORIZATION).build()));
        this.homCancel = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.EVENT_CANCEL).build()));
        this.homInutilization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.INUTILIZATION).build()));
        this.homQueryProtocol = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.QUERY_PROTOCOL).build()));
        this.homQueryStatusService = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.STATUS_SERVICE).build()));
        this.prodAuthorization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.AUTHORIZATION).build()));
        this.prodReturnAuthorization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.RETURN_AUTHORIZATION).build()));
        this.prodCancel = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.EVENT_CANCEL).build()));
        this.prodInutilization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.INUTILIZATION).build()));
        this.prodQueryStatusService = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.STATUS_SERVICE).build()));
        this.prodQueryProtocol = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.QUERY_PROTOCOL).build()));
        this.homSubstituteCancel = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.EVENT_SUBSTITUTE_CANCEL).build()));
        this.prodSubstituteCancel = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.EVENT_SUBSTITUTE_CANCEL).build()));

        SoapServiceProxy.getInstance().addNfceService(this);

        this.initialized = true;
    }

    @Override
    public <T> T prodAuthorization() {
        if (Objects.nonNull(getProdAuthorization())) {
            return (T) getProdAuthorization();
        }
        setProdAuthorization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.AUTHORIZATION).build())));
        return (T) getProdAuthorization();
    }

    @Override
    public <T> T homAuthorization() {
        if (Objects.nonNull(getHomAuthorization())) {
            return (T) getHomAuthorization();
        }
        setHomAuthorization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.AUTHORIZATION).build())));
        return (T) getHomAuthorization();
    }

    @Override
    public <T> T prodCancel() {
        if (Objects.nonNull(getProdCancel())) {
            return (T) getProdCancel();
        }
        setProdCancel(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.EVENT_CANCEL).build())));
        return (T) getProdCancel();
    }

    @Override
    public <T> T homCancel() {
        if (Objects.nonNull(getHomCancel())) {
            return (T) getHomCancel();
        }
        setHomCancel(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.EVENT_CANCEL).build())));
        return (T) getHomCancel();
    }

    @Override
    public <T> T prodInutilization() {
        if (Objects.nonNull(getProdInutilization())) {
            return (T) getProdInutilization();
        }
        setProdInutilization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.INUTILIZATION).build())));
        return (T) getProdInutilization();
    }

    @Override
    public <T> T homInutilization() {
        if (Objects.nonNull(getHomInutilization())) {
            return (T) getHomInutilization();
        }
        setHomInutilization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.INUTILIZATION).build())));
        return (T) getHomInutilization();
    }

    @Override
    public <T> T prodQueryProtocol() {
        if (Objects.nonNull(getProdQueryProtocol())) {
            return (T) getProdQueryProtocol();
        }
        setProdQueryProtocol(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.QUERY_PROTOCOL).build())));
        return (T) getProdQueryProtocol();
    }

    @Override
    public <T> T homQueryProtocol() {
        if (Objects.nonNull(getHomQueryProtocol())) {
            return (T) getHomQueryProtocol();
        }
        setHomQueryProtocol(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.QUERY_PROTOCOL).build())));
        return (T) getHomQueryProtocol();
    }

    @Override
    public <T> T prodQueryStatusService() {
        if (Objects.nonNull(getProdQueryStatusService())) {
            return (T) getProdQueryStatusService();
        }
        setProdQueryStatusService(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.STATUS_SERVICE).build())));
        return (T) getProdQueryStatusService();
    }

    @Override
    public <T> T homQueryStatusService() {
        if (Objects.nonNull(getHomQueryStatusService())) {
            return (T) getHomQueryStatusService();
        }
        setHomQueryStatusService(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.STATUS_SERVICE).build())));
        return (T) getHomQueryStatusService();
    }

    @Override
    public <T> T prodReturnAuthorization() {
        if (Objects.nonNull(getProdReturnAuthorization())) {
            return (T) getProdReturnAuthorization();
        }
        setProdReturnAuthorization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.RETURN_AUTHORIZATION).build())));
        return (T) getProdReturnAuthorization();
    }

    @Override
    public <T> T homReturnAuthorization() {
        if (Objects.nonNull(getHomReturnAuthorization())) {
            return (T) getHomReturnAuthorization();
        }
        setHomReturnAuthorization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.RETURN_AUTHORIZATION).build())));
        return (T) getHomReturnAuthorization();
    }

    @Override
    public <T> T prodSubstituteCancel() {
        if (Objects.nonNull(getProdSubstituteCancel())) {
            return (T) getProdSubstituteCancel();
        }
        setProdSubstituteCancel(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.EVENT_SUBSTITUTE_CANCEL).build())));
        return (T) getProdSubstituteCancel();
    }

    @Override
    public <T> T homSubstituteCancel() {
        if (Objects.nonNull(getHomSubstituteCancel())) {
            return (T) getHomSubstituteCancel();
        }
        setHomSubstituteCancel(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.EVENT_SUBSTITUTE_CANCEL).build())));
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
