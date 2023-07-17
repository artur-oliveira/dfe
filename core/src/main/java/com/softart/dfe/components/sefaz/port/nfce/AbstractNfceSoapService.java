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

    public void initializeDefault(AbstractNfceSoapService abstractNfceSoapService) {
        this.prodAuthorization = abstractNfceSoapService.prodAuthorization;
        this.homAuthorization = abstractNfceSoapService.homAuthorization;
        this.prodCancel = abstractNfceSoapService.prodCancel;
        this.homCancel = abstractNfceSoapService.homCancel;
        this.prodInutilization = abstractNfceSoapService.prodInutilization;
        this.homInutilization = abstractNfceSoapService.homInutilization;
        this.prodQueryProtocol = abstractNfceSoapService.prodQueryProtocol;
        this.homQueryProtocol = abstractNfceSoapService.homQueryProtocol;
        this.prodQueryStatusService = abstractNfceSoapService.prodQueryStatusService;
        this.homQueryStatusService = abstractNfceSoapService.homQueryStatusService;
        this.prodReturnAuthorization = abstractNfceSoapService.prodReturnAuthorization;
        this.homReturnAuthorization = abstractNfceSoapService.homReturnAuthorization;
        this.prodSubstituteCancel = abstractNfceSoapService.prodSubstituteCancel;
        this.homSubstituteCancel = abstractNfceSoapService.homSubstituteCancel;
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
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdAuthorization(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.AUTHORIZATION).build())));
            if (Objects.nonNull(getProdAuthorization())) break;
        }
        if (Objects.isNull(getProdAuthorization())) {
            setProdAuthorization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.AUTHORIZATION).build())));
        }
        return (T) getProdAuthorization();
    }

    @Override
    public <T> T homAuthorization() {
        if (Objects.nonNull(getHomAuthorization())) {
            return (T) getHomAuthorization();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomAuthorization(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.AUTHORIZATION).build())));
            if (Objects.nonNull(getHomAuthorization())) break;
        }
        if (Objects.isNull(getHomAuthorization())) {
            setHomAuthorization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.AUTHORIZATION).build())));
        }
        return (T) getHomAuthorization();
    }

    @Override
    public <T> T prodCancel() {
        if (Objects.nonNull(getProdCancel())) {
            return (T) getProdCancel();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdCancel(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.EVENT_CANCEL).build())));
            if (Objects.nonNull(getProdCancel())) break;
        }
        if (Objects.isNull(getProdCancel())) {
            setProdCancel(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.EVENT_CANCEL).build())));
        }
        return (T) getProdCancel();
    }

    @Override
    public <T> T homCancel() {
        if (Objects.nonNull(getHomCancel())) {
            return (T) getHomCancel();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomCancel(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.EVENT_CANCEL).build())));
            if (Objects.nonNull(getHomCancel())) break;
        }
        if (Objects.isNull(getHomCancel())) {
            setHomCancel(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.EVENT_CANCEL).build())));
        }
        return (T) getHomCancel();
    }

    @Override
    public <T> T prodInutilization() {
        if (Objects.nonNull(getProdInutilization())) {
            return (T) getProdInutilization();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdInutilization(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.INUTILIZATION).build())));
            if (Objects.nonNull(getProdInutilization())) break;
        }
        if (Objects.isNull(getProdInutilization())) {
            setProdInutilization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.INUTILIZATION).build())));
        }
        return (T) getProdInutilization();
    }

    @Override
    public <T> T homInutilization() {
        if (Objects.nonNull(getHomInutilization())) {
            return (T) getHomInutilization();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomInutilization(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.INUTILIZATION).build())));
            if (Objects.nonNull(getHomInutilization())) break;
        }
        if (Objects.isNull(getHomInutilization())) {
            setHomInutilization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.INUTILIZATION).build())));
        }
        return (T) getHomInutilization();
    }

    @Override
    public <T> T prodQueryProtocol() {
        if (Objects.nonNull(getProdQueryProtocol())) {
            return (T) getProdQueryProtocol();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdQueryProtocol(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.QUERY_PROTOCOL).build())));
            if (Objects.nonNull(getProdQueryProtocol())) break;
        }
        if (Objects.isNull(getProdQueryProtocol())) {
            setProdQueryProtocol(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.QUERY_PROTOCOL).build())));
        }
        return (T) getProdQueryProtocol();
    }

    @Override
    public <T> T homQueryProtocol() {
        if (Objects.nonNull(getHomQueryProtocol())) {
            return (T) getHomQueryProtocol();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomQueryProtocol(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.QUERY_PROTOCOL).build())));
            if (Objects.nonNull(getHomQueryProtocol())) break;
        }
        if (Objects.isNull(getHomQueryProtocol())) {
            setHomQueryProtocol(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.QUERY_PROTOCOL).build())));
        }
        return (T) getHomQueryProtocol();
    }

    @Override
    public <T> T prodQueryStatusService() {
        if (Objects.nonNull(getProdQueryStatusService())) {
            return (T) getProdQueryStatusService();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdQueryStatusService(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.STATUS_SERVICE).build())));
            if (Objects.nonNull(getProdQueryStatusService())) break;
        }
        if (Objects.isNull(getProdQueryStatusService())) {
            setProdQueryStatusService(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.STATUS_SERVICE).build())));
        }
        return (T) getProdQueryStatusService();
    }

    @Override
    public <T> T homQueryStatusService() {
        if (Objects.nonNull(getHomQueryStatusService())) {
            return (T) getHomQueryStatusService();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomQueryStatusService(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.STATUS_SERVICE).build())));
            if (Objects.nonNull(getHomQueryStatusService())) break;
        }
        if (Objects.isNull(getHomQueryStatusService())) {
            setHomQueryStatusService(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.STATUS_SERVICE).build())));
        }
        return (T) getHomQueryStatusService();
    }

    @Override
    public <T> T prodReturnAuthorization() {
        if (Objects.nonNull(getProdReturnAuthorization())) {
            return (T) getProdReturnAuthorization();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdReturnAuthorization(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.RETURN_AUTHORIZATION).build())));
            if (Objects.nonNull(getProdReturnAuthorization())) break;
        }
        if (Objects.isNull(getProdReturnAuthorization())) {
            setProdReturnAuthorization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.RETURN_AUTHORIZATION).build())));
        }
        return (T) getProdReturnAuthorization();
    }

    @Override
    public <T> T homReturnAuthorization() {
        if (Objects.nonNull(getHomReturnAuthorization())) {
            return (T) getHomReturnAuthorization();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomReturnAuthorization(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.RETURN_AUTHORIZATION).build())));
            if (Objects.nonNull(getHomReturnAuthorization())) break;
        }
        if (Objects.isNull(getHomReturnAuthorization())) {
            setHomReturnAuthorization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.RETURN_AUTHORIZATION).build())));
        }
        return (T) getHomReturnAuthorization();
    }

    @Override
    public <T> T prodSubstituteCancel() {
        if (Objects.nonNull(getProdSubstituteCancel())) {
            return (T) getProdSubstituteCancel();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdSubstituteCancel(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.EVENT_SUBSTITUTE_CANCEL).build())));
            if (Objects.nonNull(getProdSubstituteCancel())) break;
        }
        if (Objects.isNull(getProdSubstituteCancel())) {
            setProdSubstituteCancel(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfcePathEndpoint.EVENT_SUBSTITUTE_CANCEL).build())));
        }
        return (T) getProdSubstituteCancel();
    }

    @Override
    public <T> T homSubstituteCancel() {
        if (Objects.nonNull(getHomSubstituteCancel())) {
            return (T) getHomSubstituteCancel();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomSubstituteCancel(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.EVENT_SUBSTITUTE_CANCEL).build())));
            if (Objects.nonNull(getHomSubstituteCancel())) break;
        }
        if (Objects.isNull(getHomSubstituteCancel())) {
            setHomSubstituteCancel(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfceServiceClassFor(NfceServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfcePathEndpoint.EVENT_SUBSTITUTE_CANCEL).build())));
        }
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
