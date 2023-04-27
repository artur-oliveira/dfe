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
import lombok.extern.log4j.Log4j2;

import javax.net.ssl.HttpsURLConnection;
import java.util.Objects;

@Data
@SuppressWarnings("unchecked")
@Log4j2
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
    private Object prodQueryRegister;
    private Object homQueryRegister;
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
        try {
            this.config = cached.getConfig();
        } catch (Exception ignored) {
        }
        try {
            this.homAuthorization = cached.homAuthorization();
        } catch (Exception ignored) {
        }
        try {
            this.homReturnAuthorization = cached.homReturnAuthorization();
        } catch (Exception ignored) {
        }
        try {
            this.homCancel = cached.homCancel();
        } catch (Exception ignored) {
        }
        try {
            this.homInutilization = cached.homInutilization();
        } catch (Exception ignored) {
        }
        try {
            this.homQueryProtocol = cached.homQueryProtocol();
        } catch (Exception ignored) {
        }
        try {
            this.homQueryRegister = cached.homQueryRegister();
        } catch (Exception ignored) {
        }
        try {
            this.homQueryStatusService = cached.homQueryStatusService();
        } catch (Exception ignored) {
        }
        try {
            this.prodAuthorization = cached.prodAuthorization();
        } catch (Exception ignored) {
        }
        try {
            this.prodReturnAuthorization = cached.prodReturnAuthorization();
        } catch (Exception ignored) {
        }
        try {
            this.prodCancel = cached.prodCancel();
        } catch (Exception ignored) {
        }
        try {
            this.prodInutilization = cached.prodInutilization();
        } catch (Exception ignored) {
        }
        try {
            this.prodQueryStatusService = cached.prodQueryStatusService();
        } catch (Exception ignored) {
        }
        try {
            this.prodQueryRegister = cached.prodQueryRegister();
        } catch (Exception ignored) {
        }
        try {
            this.homDistribution = cached.homDistribution();
        } catch (Exception ignored) {
        }
        try {
            this.prodDistribution = cached.prodDistribution();
        } catch (Exception ignored) {
        }
        try {
            this.homEpec = cached.homEpec();
        } catch (Exception ignored) {
        }
        try {
            this.prodEpec = cached.prodEpec();
        } catch (Exception ignored) {
        }
        try {
            this.homInterestedActor = cached.homInterestedActor();
        } catch (Exception ignored) {
        }
        try {
            this.prodInterestedActor = cached.prodInterestedActor();
        } catch (Exception ignored) {
        }
        try {
            this.homCorrectionLetter = cached.homCorrectionLetter();
        } catch (Exception ignored) {
        }
        try {
            this.prodCorrectionLetter = cached.prodCorrectionLetter();
        } catch (Exception ignored) {
        }
        try {
            this.homManifestation = cached.homManifestation();
        } catch (Exception ignored) {
        }
        try {
            this.prodManifestation = cached.prodManifestation();
        } catch (Exception ignored) {
        }
        try {
            this.queryGtin = cached.queryGtin();
        } catch (Exception ignored) {
        }
        this.initialized = true;
    }

    public void initialize(Config config) throws SSLContextException {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(config).getSocketFactory());

        this.homAuthorization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.AUTHORIZATION).build()));
        this.homReturnAuthorization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.RETURN_AUTHORIZATION).build()));
        this.homCancel = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_CANCEL).build()));
        this.homInutilization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.INUTILIZATION).build()));
        this.homQueryProtocol = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.QUERY_PROTOCOL).build()));
        this.homQueryRegister = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.QUERY_REGISTER).build()));
        this.homQueryStatusService = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.STATUS_SERVICE).build()));
        this.prodAuthorization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.AUTHORIZATION).build()));
        this.prodReturnAuthorization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.RETURN_AUTHORIZATION).build()));
        this.prodCancel = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_CANCEL).build()));
        this.prodInutilization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.INUTILIZATION).build()));
        this.prodQueryStatusService = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.STATUS_SERVICE).build()));
        this.prodQueryProtocol = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.QUERY_PROTOCOL).build()));
        this.prodQueryRegister = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.QUERY_REGISTER).build()));
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

        SoapServiceProxy.getInstance().addNfeService(this);

        this.initialized = true;
    }

    @Override
    public <T> T homAuthorization() {
        if (Objects.nonNull(getHomAuthorization())) {
            return (T) getHomAuthorization();
        }
        setHomAuthorization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.AUTHORIZATION).build())));
        return (T) getHomAuthorization();
    }

    @Override
    public <T> T homCancel() {
        if (Objects.nonNull(getHomCancel())) {
            return (T) getHomCancel();
        }
        setHomCancel(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_CANCEL).build())));
        return (T) getHomCancel();
    }

    @Override
    public <T> T homInutilization() {
        if (Objects.nonNull(getHomInutilization())) {
            return (T) getHomInutilization();
        }
        setHomInutilization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.INUTILIZATION).build())));
        return (T) getHomInutilization();
    }

    @Override
    public <T> T homCorrectionLetter() {
        if (Objects.nonNull(getHomCorrectionLetter())) {
            return (T) getHomCorrectionLetter();
        }
        setHomCorrectionLetter(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_CORRECTION_LETTER).build())));
        return (T) getHomCorrectionLetter();
    }

    @Override
    public <T> T prodCorrectionLetter() {
        if (Objects.nonNull(getProdCorrectionLetter())) {
            return (T) getProdCorrectionLetter();
        }
        setProdCorrectionLetter(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_CORRECTION_LETTER).build())));
        return (T) getProdCorrectionLetter();
    }

    @Override
    public <T> T homQueryProtocol() {
        if (Objects.nonNull(getHomQueryProtocol())) {
            return (T) getHomQueryProtocol();
        }
        setHomQueryProtocol(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.QUERY_PROTOCOL).build())));
        return (T) getHomQueryProtocol();
    }

    @Override
    public <T> T homQueryStatusService() {
        if (Objects.nonNull(getHomQueryStatusService())) {
            return (T) getHomQueryStatusService();
        }
        setHomQueryStatusService(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.STATUS_SERVICE).build())));
        return (T) getHomQueryStatusService();
    }

    @Override
    public <T> T homReturnAuthorization() {
        if (Objects.nonNull(getHomReturnAuthorization())) {
            return (T) getHomReturnAuthorization();
        }
        setHomReturnAuthorization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.RETURN_AUTHORIZATION).build())));
        return (T) getHomReturnAuthorization();
    }

    @Override
    public <T> T prodAuthorization() {
        if (Objects.nonNull(getProdAuthorization())) {
            return (T) getProdAuthorization();
        }
        setProdAuthorization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.AUTHORIZATION).build())));
        return (T) getProdAuthorization();
    }

    @Override
    public <T> T prodReturnAuthorization() {
        if (Objects.nonNull(getProdReturnAuthorization())) {
            return (T) getProdReturnAuthorization();
        }
        setProdReturnAuthorization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.RETURN_AUTHORIZATION).build())));
        return (T) getProdReturnAuthorization();
    }

    @Override
    public <T> T prodCancel() {
        if (Objects.nonNull(getProdCancel())) {
            return (T) getProdCancel();
        }
        setProdCancel(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_CANCEL).build())));
        return (T) getProdCancel();
    }

    @Override
    public <T> T prodInutilization() {
        if (Objects.nonNull(getProdInutilization())) {
            return (T) getProdInutilization();
        }
        setProdInutilization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.INUTILIZATION).build())));
        return (T) getProdInutilization();
    }

    @Override
    public <T> T prodQueryStatusService() {
        if (Objects.nonNull(getProdQueryStatusService())) {
            return (T) getProdQueryStatusService();
        }
        setProdQueryStatusService(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.STATUS_SERVICE).build())));
        return (T) getProdQueryStatusService();
    }

    @Override
    public <T> T prodQueryProtocol() {
        if (Objects.nonNull(getProdQueryProtocol())) {
            return (T) getProdQueryProtocol();
        }
        setProdQueryProtocol(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.QUERY_PROTOCOL).build())));
        return (T) getProdQueryProtocol();
    }

    @Override
    public <T> T homDistribution() {
        if (Objects.nonNull(getHomDistribution())) {
            return (T) getHomDistribution();
        }
        setHomDistribution(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.DISTRIBUTION).build())));
        return (T) getHomDistribution();
    }

    @Override
    public <T> T prodDistribution() {
        if (Objects.nonNull(getProdDistribution())) {
            return (T) getProdDistribution();
        }
        setProdDistribution(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.DISTRIBUTION).build())));
        return (T) getProdDistribution();
    }

    @Override
    public <T> T homQueryRegister() {
        if (Objects.nonNull(getHomQueryRegister())) {
            return (T) getHomQueryRegister();
        }
        setHomQueryRegister(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.QUERY_REGISTER).build())));
        return (T) getHomQueryRegister();
    }

    @Override
    public <T> T prodQueryRegister() {
        if (Objects.nonNull(getProdQueryRegister())) {
            return (T) getProdQueryRegister();
        }
        setProdQueryRegister(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.QUERY_REGISTER).build())));
        return (T) getProdQueryRegister();
    }

    @Override
    public <T> T homEpec() {
        if (Objects.nonNull(getHomEpec())) {
            return (T) getHomEpec();
        }
        setHomEpec(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_EPEC).build())));
        return (T) getHomEpec();
    }

    @Override
    public <T> T prodEpec() {
        if (Objects.nonNull(getProdEpec())) {
            return (T) getProdEpec();
        }
        setProdEpec(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_EPEC).build())));
        return (T) getProdEpec();
    }

    @Override
    public <T> T homInterestedActor() {
        if (Objects.nonNull(getHomInterestedActor())) {
            return (T) getHomInterestedActor();
        }
        setHomInterestedActor(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_INTERESTED_ACTOR).build())));
        return (T) getHomInterestedActor();
    }

    @Override
    public <T> T prodInterestedActor() {
        if (Objects.nonNull(getProdInterestedActor())) {
            return (T) getProdInterestedActor();
        }
        setProdInterestedActor(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_INTERESTED_ACTOR).build())));
        return (T) getProdInterestedActor();
    }

    @Override
    public <T> T homManifestation() {
        if (Objects.nonNull(getHomManifestation())) {
            return (T) getHomManifestation();
        }
        setHomManifestation(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_MANIFESTATION).build())));
        return (T) getHomManifestation();
    }

    @Override
    public <T> T prodManifestation() {
        if (Objects.nonNull(getProdManifestation())) {
            return (T) getProdManifestation();
        }
        setProdManifestation(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_MANIFESTATION).build())));
        return (T) getProdManifestation();
    }

    @Override
    public <T> T queryGtin() {
        if (Objects.nonNull(getQueryGtin())) {
            return (T) getQueryGtin();
        }
        setQueryGtin(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.QUERY_GTIN).build())));
        return (T) getQueryGtin();
    }

    @Override
    public NfConfig getConfig() {
        return (NfConfig) super.getConfig();
    }

    public abstract NfeAuthorizer getAuthorizer();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractNfeSoapService)) return false;
        AbstractNfeSoapService that = (AbstractNfeSoapService) o;
        return Objects.equals(getAuthorizer(), that.getAuthorizer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorizer());
    }

}
