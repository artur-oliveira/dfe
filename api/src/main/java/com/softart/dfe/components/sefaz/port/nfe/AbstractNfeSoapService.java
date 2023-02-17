package com.softart.dfe.components.sefaz.port.nfe;

import com.softart.dfe.components.security.socket.SocketFactory;
import com.softart.dfe.components.sefaz.port.AbstractSoapService;
import com.softart.dfe.components.sefaz.port.SoapServiceMapping;
import com.softart.dfe.components.sefaz.port.SoapServiceProxy;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.nf.NfeAuthorizer;
import com.softart.dfe.enums.internal.nf.NfePathEndpoint;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.port.NfeSoapService;
import com.softart.dfe.models.internal.port.NfeServiceFinder;
import com.softart.dfe.util.ReflectionUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.net.ssl.HttpsURLConnection;

@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("unchecked")
public abstract class AbstractNfeSoapService extends AbstractSoapService implements NfeSoapService {
    private Object homAuthorization;
    private Object homReturnAuthorization;
    private Object homCancel;
    private Object homInutilization;
    private Object homQueryProtocol;
    private Object homQueryStatusService;
    private Object prodAuthorization;
    private Object prodReturnAuthorization;
    private Object prodCancel;
    private Object prodInutilization;
    private Object prodQueryStatusService;
    private Object prodQueryProtocol;
    private Object homDistribution;
    private Object prodDistribution;
    private Object homEpec;
    private Object prodEpec;
    private Object homInterestedActor;
    private Object prodInterestedActor;
    private Object homCorrectionLetter;
    private Object prodCorrectionLetter;
    private Object homManifestation;
    private Object prodManifestation;
    private Object queryGtin;

    public AbstractNfeSoapService() {
        super();
    }

    public AbstractNfeSoapService(NfConfig config) {
        super(config);
    }

    public void initialize(NfeSoapService cached) {
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
        this.homDistribution = cached.homDistribution();
        this.prodDistribution = cached.prodDistribution();
        this.homEpec = cached.homEpec();
        this.prodEpec = cached.prodEpec();
        this.homInterestedActor = cached.homInterestedActor();
        this.prodInterestedActor = cached.prodInterestedActor();
        this.homCorrectionLetter = cached.homCorrectionLetter();
        this.prodCorrectionLetter = cached.prodCorrectionLetter();
        this.homManifestation = cached.homManifestation();
        this.prodManifestation = cached.prodManifestation();
        this.queryGtin = cached.queryGtin();
        this.initialized = true;
    }

    public void initialize(Config config) throws SSLContextException {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(config).getSocketFactory());

        this.homAuthorization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.AUTHORIZATION).build()));
        this.homReturnAuthorization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.RETURN_AUTHORIZATION).build()));
        this.homCancel = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_CANCEL).build()));
        this.homInutilization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.INUTILIZATION).build()));
        this.homQueryProtocol = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.QUERY_PROTOCOL).build()));
        this.homQueryStatusService = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.STATUS_SERVICE).build()));
        this.prodAuthorization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.AUTHORIZATION).build()));
        this.prodReturnAuthorization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.RETURN_AUTHORIZATION).build()));
        this.prodCancel = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_CANCEL).build()));
        this.prodInutilization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.INUTILIZATION).build()));
        this.prodQueryStatusService = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.STATUS_SERVICE).build()));
        this.prodQueryProtocol = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.QUERY_PROTOCOL).build()));
        this.homDistribution = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.DISTRIBUTION).build()));
        this.prodDistribution = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.DISTRIBUTION).build()));
        this.homEpec = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_EPEC).build()));
        this.prodEpec = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_EPEC).build()));
        this.homInterestedActor = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_INTERESTED_ACTOR).build()));
        this.prodInterestedActor = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_INTERESTED_ACTOR).build()));
        this.homManifestation = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_MANIFESTATION).build()));
        this.prodManifestation = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_MANIFESTATION).build()));
        this.homCorrectionLetter = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_CORRECTION_LETTER).build()));
        this.prodCorrectionLetter = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_CORRECTION_LETTER).build()));
        this.queryGtin = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.SVRS).endpoint(NfePathEndpoint.QUERY_GTIN).environment(Environment.PRODUCTION).build()));

        SoapServiceProxy.getInstance().addNfeService(getConfig(), this);

        this.initialized = true;
    }

    @Override
    public <T> T homAuthorization() {
        return (T) getHomAuthorization();
    }

    @Override
    public <T> T homCancel() {
        return (T) getHomCancel();
    }

    @Override
    public <T> T homInutilization() {
        return (T) getHomInutilization();
    }

    @Override
    public <T> T homCorrectionLetter() {
        return (T) homCorrectionLetter;
    }

    @Override
    public <T> T prodCorrectionLetter() {
        return (T) prodCorrectionLetter;
    }

    @Override
    public <T> T homQueryProtocol() {
        return (T) getHomQueryProtocol();
    }

    @Override
    public <T> T homQueryStatusService() {
        return (T) getHomQueryStatusService();
    }

    @Override
    public <T> T homReturnAuthorization() {
        return (T) getHomReturnAuthorization();
    }

    @Override
    public <T> T prodAuthorization() {
        return (T) getProdAuthorization();
    }

    @Override
    public <T> T prodReturnAuthorization() {
        return (T) getProdReturnAuthorization();
    }

    @Override
    public <T> T prodCancel() {
        return (T) getProdCancel();
    }

    @Override
    public <T> T prodInutilization() {
        return (T) getProdInutilization();
    }

    @Override
    public <T> T prodQueryStatusService() {
        return (T) getProdQueryStatusService();
    }

    @Override
    public <T> T prodQueryProtocol() {
        return (T) getProdQueryProtocol();
    }

    @Override
    public <T> T homDistribution() {
        return (T) getHomDistribution();
    }

    @Override
    public <T> T prodDistribution() {
        return (T) getProdDistribution();
    }

    @Override
    public <T> T homEpec() {
        return (T) getHomEpec();
    }

    @Override
    public <T> T prodEpec() {
        return (T) getProdEpec();
    }

    @Override
    public <T> T homInterestedActor() {
        return (T) getHomInterestedActor();
    }

    @Override
    public <T> T prodInterestedActor() {
        return (T) getProdInterestedActor();
    }

    @Override
    public <T> T homManifestation() {
        return (T) getHomManifestation();
    }

    @Override
    public <T> T prodManifestation() {
        return (T) getProdManifestation();
    }

    @Override
    public <T> T queryGtin() {
        return (T) getQueryGtin();
    }

    @Override
    public NfConfig getConfig() {
        return (NfConfig) super.getConfig();
    }

    public abstract NfeAuthorizer getAuthorizer();

}
