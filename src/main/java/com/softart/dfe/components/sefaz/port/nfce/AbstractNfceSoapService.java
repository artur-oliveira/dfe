package com.softart.dfe.components.sefaz.port.nfce;

import com.softart.dfe.components.security.SocketFactory;
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
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import javax.net.ssl.HttpsURLConnection;

@EqualsAndHashCode(callSuper = true)
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

        SoapServiceProxy.getInstance().addNfceService(getConfig(), this);

        this.initialized = true;
    }

    @Override
    public <T> T prodAuthorization() {
        return (T) prodAuthorization;
    }

    @Override
    public <T> T homAuthorization() {
        return (T) homAuthorization;
    }

    @Override
    public <T> T prodCancel() {
        return (T) prodCancel;
    }

    @Override
    public <T> T homCancel() {
        return (T) homCancel;
    }

    @Override
    public <T> T prodInutilization() {
        return (T) prodInutilization;
    }

    @Override
    public <T> T homInutilization() {
        return (T) homInutilization;
    }

    @Override
    public <T> T prodQueryProtocol() {
        return (T) prodQueryProtocol;
    }

    @Override
    public <T> T homQueryProtocol() {
        return (T) homQueryProtocol;
    }

    @Override
    public <T> T prodQueryStatusService() {
        return (T) prodQueryStatusService;
    }

    @Override
    public <T> T homQueryStatusService() {
        return (T) homQueryStatusService;
    }

    @Override
    public <T> T prodReturnAuthorization() {
        return (T) prodReturnAuthorization;
    }

    @Override
    public <T> T homReturnAuthorization() {
        return (T) homReturnAuthorization;
    }

    @Override
    public <T> T prodSubstituteCancel() {
        return (T) prodSubstituteCancel;
    }

    @Override
    public <T> T homSubstituteCancel() {
        return (T) homSubstituteCancel;
    }

    public abstract NfceAuthorizer getAuthorizer();

    @Override
    public NfConfig getConfig() {
        return (NfConfig) super.getConfig();
    }
}
