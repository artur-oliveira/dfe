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

    void initializeDefault(AbstractNfeSoapService abstractNfeSoapService) {
        this.homAuthorization = Optional.ofNullable(abstractNfeSoapService.homAuthorization).orElse(this.homAuthorization);
        this.homReturnAuthorization = Optional.ofNullable(abstractNfeSoapService.homReturnAuthorization).orElse(this.homReturnAuthorization);
        this.homCancel = Optional.ofNullable(abstractNfeSoapService.homCancel).orElse(this.homCancel);
        this.homInutilization = Optional.ofNullable(abstractNfeSoapService.homInutilization).orElse(this.homInutilization);
        this.homQueryProtocol = Optional.ofNullable(abstractNfeSoapService.homQueryProtocol).orElse(this.homQueryProtocol);
        this.homQueryStatusService = Optional.ofNullable(abstractNfeSoapService.homQueryStatusService).orElse(this.homQueryStatusService);
        this.prodAuthorization = Optional.ofNullable(abstractNfeSoapService.prodAuthorization).orElse(this.prodAuthorization);
        this.prodReturnAuthorization = Optional.ofNullable(abstractNfeSoapService.prodReturnAuthorization).orElse(this.prodReturnAuthorization);
        this.prodCancel = Optional.ofNullable(abstractNfeSoapService.prodCancel).orElse(this.prodCancel);
        this.prodInutilization = Optional.ofNullable(abstractNfeSoapService.prodInutilization).orElse(this.prodInutilization);
        this.prodQueryStatusService = Optional.ofNullable(abstractNfeSoapService.prodQueryStatusService).orElse(this.prodQueryStatusService);
        this.prodQueryProtocol = Optional.ofNullable(abstractNfeSoapService.prodQueryProtocol).orElse(this.prodQueryProtocol);
        this.prodQueryRegister = Optional.ofNullable(abstractNfeSoapService.prodQueryRegister).orElse(this.prodQueryRegister);
        this.homQueryRegister = Optional.ofNullable(abstractNfeSoapService.homQueryRegister).orElse(this.homQueryRegister);
        this.homDistribution = Optional.ofNullable(abstractNfeSoapService.homDistribution).orElse(this.homDistribution);
        this.prodDistribution = Optional.ofNullable(abstractNfeSoapService.prodDistribution).orElse(this.prodDistribution);
        this.homEpec = Optional.ofNullable(abstractNfeSoapService.homEpec).orElse(this.homEpec);
        this.prodEpec = Optional.ofNullable(abstractNfeSoapService.prodEpec).orElse(this.prodEpec);
        this.homInterestedActor = Optional.ofNullable(abstractNfeSoapService.homInterestedActor).orElse(this.homInterestedActor);
        this.prodInterestedActor = Optional.ofNullable(abstractNfeSoapService.prodInterestedActor).orElse(this.prodInterestedActor);
        this.homCorrectionLetter = Optional.ofNullable(abstractNfeSoapService.homCorrectionLetter).orElse(this.homCorrectionLetter);
        this.prodCorrectionLetter = Optional.ofNullable(abstractNfeSoapService.prodCorrectionLetter).orElse(this.prodCorrectionLetter);
        this.homManifestation = Optional.ofNullable(abstractNfeSoapService.homManifestation).orElse(this.homManifestation);
        this.prodManifestation = Optional.ofNullable(abstractNfeSoapService.prodManifestation).orElse(this.prodManifestation);
        this.queryGtin = Optional.ofNullable(abstractNfeSoapService.queryGtin).orElse(this.queryGtin);
    }

    public void initialize(NfeSoapService o) {
        this.config = o.getConfig();

        if (o instanceof AbstractNfeSoapService abstractNfeSoapService) {
            initializeDefault(abstractNfeSoapService);
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
                o.homQueryRegister();
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
                o.prodQueryRegister();
            } catch (Exception ignored) {
            }
            try {
                o.homDistribution();
            } catch (Exception ignored) {
            }
            try {
                o.prodDistribution();
            } catch (Exception ignored) {
            }
            try {
                o.homEpec();
            } catch (Exception ignored) {
            }
            try {
                o.prodEpec();
            } catch (Exception ignored) {
            }
            try {
                o.homInterestedActor();
            } catch (Exception ignored) {
            }
            try {
                o.prodInterestedActor();
            } catch (Exception ignored) {
            }
            try {
                o.homCorrectionLetter();
            } catch (Exception ignored) {
            }
            try {
                o.prodCorrectionLetter();
            } catch (Exception ignored) {
            }
            try {
                o.homManifestation();
            } catch (Exception ignored) {
            }
            try {
                o.prodManifestation();
            } catch (Exception ignored) {
            }
            try {
                o.queryGtin();
            } catch (Exception ignored) {
            }
        }
        SoapServiceProxy.getInstance().addNfeService(this);
        this.initialized = true;
    }

    public void initialize(Config config) throws SSLContextException {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(config).getSocketFactory());

        if (!LAZY_INITIALIZATION) {
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
        setHomAuthorization(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.AUTHORIZATION).build())));
        return (T) getHomAuthorization();
    }

    @Override
    public <T> T homCancel() {
        if (Objects.nonNull(getHomCancel())) {
            return (T) getHomCancel();
        }
        setHomCancel(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_CANCEL).build())));
        return (T) getHomCancel();
    }

    @Override
    public <T> T homInutilization() {
        if (Objects.nonNull(getHomInutilization())) {
            return (T) getHomInutilization();
        }
        setHomInutilization(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.INUTILIZATION).build())));
        return (T) getHomInutilization();
    }

    @Override
    public <T> T homCorrectionLetter() {
        if (Objects.nonNull(getHomCorrectionLetter())) {
            return (T) getHomCorrectionLetter();
        }
        setHomCorrectionLetter(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_CORRECTION_LETTER).build())));
        return (T) getHomCorrectionLetter();
    }

    @Override
    public <T> T prodCorrectionLetter() {
        if (Objects.nonNull(getProdCorrectionLetter())) {
            return (T) getProdCorrectionLetter();
        }
        setProdCorrectionLetter(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_CORRECTION_LETTER).build())));
        return (T) getProdCorrectionLetter();
    }

    @Override
    public <T> T homQueryProtocol() {
        if (Objects.nonNull(getHomQueryProtocol())) {
            return (T) getHomQueryProtocol();
        }
        setHomQueryProtocol(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.QUERY_PROTOCOL).build())));
        return (T) getHomQueryProtocol();
    }

    @Override
    public <T> T homQueryStatusService() {
        if (Objects.nonNull(getHomQueryStatusService())) {
            return (T) getHomQueryStatusService();
        }
        setHomQueryStatusService(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.STATUS_SERVICE).build())));
        return (T) getHomQueryStatusService();
    }

    @Override
    public <T> T homReturnAuthorization() {
        if (Objects.nonNull(getHomReturnAuthorization())) {
            return (T) getHomReturnAuthorization();
        }
        setHomReturnAuthorization(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.RETURN_AUTHORIZATION).build())));
        return (T) getHomReturnAuthorization();
    }

    @Override
    public <T> T prodAuthorization() {
        if (Objects.nonNull(getProdAuthorization())) {
            return (T) getProdAuthorization();
        }
        setProdAuthorization(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.AUTHORIZATION).build())));
        return (T) getProdAuthorization();
    }

    @Override
    public <T> T prodReturnAuthorization() {
        if (Objects.nonNull(getProdReturnAuthorization())) {
            return (T) getProdReturnAuthorization();
        }
        setProdReturnAuthorization(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.RETURN_AUTHORIZATION).build())));
        return (T) getProdReturnAuthorization();
    }

    @Override
    public <T> T prodCancel() {
        if (Objects.nonNull(getProdCancel())) {
            return (T) getProdCancel();
        }
        setProdCancel(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_CANCEL).build())));
        return (T) getProdCancel();
    }

    @Override
    public <T> T prodInutilization() {
        if (Objects.nonNull(getProdInutilization())) {
            return (T) getProdInutilization();
        }
        setProdInutilization(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.INUTILIZATION).build())));
        return (T) getProdInutilization();
    }

    @Override
    public <T> T prodQueryStatusService() {
        if (Objects.nonNull(getProdQueryStatusService())) {
            return (T) getProdQueryStatusService();
        }
        setProdQueryStatusService(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.STATUS_SERVICE).build())));
        return (T) getProdQueryStatusService();
    }

    @Override
    public <T> T prodQueryProtocol() {
        if (Objects.nonNull(getProdQueryProtocol())) {
            return (T) getProdQueryProtocol();
        }
        setProdQueryProtocol(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.QUERY_PROTOCOL).build())));
        return (T) getProdQueryProtocol();
    }

    @Override
    public <T> T homDistribution() {
        if (Objects.nonNull(getHomDistribution())) {
            return (T) getHomDistribution();
        }
        setHomDistribution(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.DISTRIBUTION).build())));
        return (T) getHomDistribution();
    }

    @Override
    public <T> T prodDistribution() {
        if (Objects.nonNull(getProdDistribution())) {
            return (T) getProdDistribution();
        }
        setProdDistribution(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.DISTRIBUTION).build())));
        return (T) getProdDistribution();
    }

    @Override
    public <T> T homQueryRegister() {
        if (Objects.nonNull(getHomQueryRegister())) {
            return (T) getHomQueryRegister();
        }
        setHomQueryRegister(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.QUERY_REGISTER).build())));
        return (T) getHomQueryRegister();
    }

    @Override
    public <T> T prodQueryRegister() {
        if (Objects.nonNull(getProdQueryRegister())) {
            return (T) getProdQueryRegister();
        }
        setProdQueryRegister(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(getServiceFinderAuthorizer()).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.QUERY_REGISTER).build())));
        return (T) getProdQueryRegister();
    }

    @Override
    public <T> T homEpec() {
        if (Objects.nonNull(getHomEpec())) {
            return (T) getHomEpec();
        }
        setHomEpec(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_EPEC).build())));
        return (T) getHomEpec();
    }

    @Override
    public <T> T prodEpec() {
        if (Objects.nonNull(getProdEpec())) {
            return (T) getProdEpec();
        }
        setProdEpec(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_EPEC).build())));
        return (T) getProdEpec();
    }

    @Override
    public <T> T homInterestedActor() {
        if (Objects.nonNull(getHomInterestedActor())) {
            return (T) getHomInterestedActor();
        }
        setHomInterestedActor(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_INTERESTED_ACTOR).build())));
        return (T) getHomInterestedActor();
    }

    @Override
    public <T> T prodInterestedActor() {
        if (Objects.nonNull(getProdInterestedActor())) {
            return (T) getProdInterestedActor();
        }
        setProdInterestedActor(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_INTERESTED_ACTOR).build())));
        return (T) getProdInterestedActor();
    }

    @Override
    public <T> T homManifestation() {
        if (Objects.nonNull(getHomManifestation())) {
            return (T) getHomManifestation();
        }
        setHomManifestation(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.HOMOLOGATION).endpoint(NfePathEndpoint.EVENT_MANIFESTATION).build())));
        return (T) getHomManifestation();
    }

    @Override
    public <T> T prodManifestation() {
        if (Objects.nonNull(getProdManifestation())) {
            return (T) getProdManifestation();
        }
        setProdManifestation(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.AN).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.EVENT_MANIFESTATION).build())));
        return (T) getProdManifestation();
    }

    @Override
    public <T> T queryGtin() {
        if (Objects.nonNull(getQueryGtin())) {
            return (T) getQueryGtin();
        }
        setQueryGtin(newServiceInstance(SoapServiceMapping.getInstance().getNfeServiceClassFor(NfeServiceFinder.builder().authorizer(NfeAuthorizer.SVRS).environment(Environment.PRODUCTION).endpoint(NfePathEndpoint.QUERY_GTIN).build())));
        return (T) getQueryGtin();
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
