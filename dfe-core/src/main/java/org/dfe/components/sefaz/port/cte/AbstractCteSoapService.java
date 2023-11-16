package org.dfe.components.sefaz.port.cte;

import lombok.Data;
import org.dfe.components.security.socket.SocketFactory;
import org.dfe.components.sefaz.port.AbstractSoapService;
import org.dfe.components.sefaz.port.SoapServiceMapping;
import org.dfe.components.sefaz.port.SoapServiceProxy;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.cte.CteAuthorizer;
import org.dfe.enums.internal.cte.CtePathEndpoint;
import org.dfe.exceptions.security.SSLContextException;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.sefaz.port.CteSoapService;
import org.dfe.models.internal.port.CteServiceFinder;

import javax.net.ssl.HttpsURLConnection;
import java.util.Objects;
import java.util.Optional;

@Data
@SuppressWarnings("unchecked")
public abstract class AbstractCteSoapService extends AbstractSoapService implements CteSoapService {

    private Object prodDistribution;
    private Object homDistribution;
    private Object prodEvent;
    private Object homEvent;
    private Object prodInutilization;
    private Object homInutilization;
    private Object prodQueryReceipt;
    private Object homQueryReceipt;
    private Object prodQuerySituation;
    private Object homQuerySituation;
    private Object prodReception;
    private Object homReception;
    private Object prodReceptionGtve;
    private Object homReceptionGtve;
    private Object prodReceptionOs;
    private Object homReceptionOs;
    private Object prodReceptionSync;
    private Object homReceptionSync;
    private Object prodStatusService;
    private Object homStatusService;

    @Override
    public CteConfig getConfig() {
        return (CteConfig) super.getConfig();
    }

    void initializeDefault(AbstractCteSoapService abstractCteSoapService) {
        this.prodDistribution = Optional.ofNullable(abstractCteSoapService.prodDistribution).orElse(this.prodDistribution);
        this.homDistribution = Optional.ofNullable(abstractCteSoapService.homDistribution).orElse(this.homDistribution);
        this.prodEvent = Optional.ofNullable(abstractCteSoapService.prodEvent).orElse(this.prodEvent);
        this.homEvent = Optional.ofNullable(abstractCteSoapService.homEvent).orElse(this.homEvent);
        this.prodInutilization = Optional.ofNullable(abstractCteSoapService.prodInutilization).orElse(this.prodInutilization);
        this.homInutilization = Optional.ofNullable(abstractCteSoapService.homInutilization).orElse(this.homInutilization);
        this.prodQueryReceipt = Optional.ofNullable(abstractCteSoapService.prodQueryReceipt).orElse(this.prodQueryReceipt);
        this.homQueryReceipt = Optional.ofNullable(abstractCteSoapService.homQueryReceipt).orElse(this.homQueryReceipt);
        this.prodQuerySituation = Optional.ofNullable(abstractCteSoapService.prodQuerySituation).orElse(this.prodQuerySituation);
        this.homQuerySituation = Optional.ofNullable(abstractCteSoapService.homQuerySituation).orElse(this.homQuerySituation);
        this.prodReception = Optional.ofNullable(abstractCteSoapService.prodReception).orElse(this.prodReception);
        this.homReception = Optional.ofNullable(abstractCteSoapService.homReception).orElse(this.homReception);
        this.prodReceptionGtve = Optional.ofNullable(abstractCteSoapService.prodReceptionGtve).orElse(this.prodReceptionGtve);
        this.homReceptionGtve = Optional.ofNullable(abstractCteSoapService.homReceptionGtve).orElse(this.homReceptionGtve);
        this.prodReceptionOs = Optional.ofNullable(abstractCteSoapService.prodReceptionOs).orElse(this.prodReceptionOs);
        this.homReceptionOs = Optional.ofNullable(abstractCteSoapService.homReceptionOs).orElse(this.homReceptionOs);
        this.prodReceptionSync = Optional.ofNullable(abstractCteSoapService.prodReceptionSync).orElse(this.prodReceptionSync);
        this.homReceptionSync = Optional.ofNullable(abstractCteSoapService.homReceptionSync).orElse(this.homReceptionSync);
        this.prodStatusService = Optional.ofNullable(abstractCteSoapService.prodStatusService).orElse(this.prodStatusService);
        this.homStatusService = Optional.ofNullable(abstractCteSoapService.homStatusService).orElse(this.homStatusService);
    }

    public void initialize(CteSoapService o) {
        this.config = o.getConfig();

        if (o instanceof AbstractCteSoapService abstractCteSoapService) {
            initializeDefault(abstractCteSoapService);
        }

        if (!LAZY_INITIALIZATION) {
            try {
                o.prodDistribution();
            } catch (Exception ignored) {
            }
            try {
                o.homDistribution();
            } catch (Exception ignored) {
            }
            try {
                o.prodEvent();
            } catch (Exception ignored) {
            }
            try {
                o.homEvent();
            } catch (Exception ignored) {
            }
            try {
                o.prodInutilization();
            } catch (Exception ignored) {
            }
            try {
                o.homInutilization();
            } catch (Exception ignored) {
            }
            try {
                o.prodQueryReceipt();
            } catch (Exception ignored) {
            }
            try {
                o.homQueryReceipt();
            } catch (Exception ignored) {
            }
            try {
                o.prodQuerySituation();
            } catch (Exception ignored) {
            }
            try {
                o.homQuerySituation();
            } catch (Exception ignored) {
            }
            try {
                o.prodReception();
            } catch (Exception ignored) {
            }
            try {
                o.homReception();
            } catch (Exception ignored) {
            }
            try {
                o.prodReceptionGtve();
            } catch (Exception ignored) {
            }
            try {
                o.homReceptionGtve();
            } catch (Exception ignored) {
            }
            try {
                o.prodReceptionOs();
            } catch (Exception ignored) {
            }
            try {
                o.homReceptionOs();
            } catch (Exception ignored) {
            }
            try {
                o.prodReceptionSync();
            } catch (Exception ignored) {
            }
            try {
                o.homReceptionSync();
            } catch (Exception ignored) {
            }
            try {
                o.prodStatusService();
            } catch (Exception ignored) {
            }
            try {
                o.homStatusService();
            } catch (Exception ignored) {
            }
        }

        SoapServiceProxy.getInstance().addCteService(this);
        this.initialized = true;
    }

    public void initialize(Config config) throws SSLContextException {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(config).getSocketFactory());

        if (!LAZY_INITIALIZATION) {
            initialize(this);
        }

        SoapServiceProxy.getInstance().addCteService(this);
        this.initialized = true;
    }

    @Override
    public <T> T prodDistribution() {
        if (Objects.nonNull(getProdDistribution())) {
            return (T) getProdDistribution();
        }
        setProdDistribution(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.DISTRIBUTION).authorizer(CteAuthorizer.AN).environment(Environment.PRODUCTION).build())));
        return (T) getProdDistribution();
    }

    @Override
    public <T> T homDistribution() {
        if (Objects.nonNull(getHomDistribution())) {
            return (T) getHomDistribution();
        }
        setHomDistribution(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.DISTRIBUTION).authorizer(CteAuthorizer.AN).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomDistribution();
    }

    @Override
    public <T> T prodEvent() {
        if (Objects.nonNull(getProdEvent())) {
            return (T) getProdEvent();
        }
        setProdEvent(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdEvent();
    }

    @Override
    public <T> T homEvent() {
        if (Objects.nonNull(getHomEvent())) {
            return (T) getHomEvent();
        }
        setHomEvent(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomEvent();
    }

    @Override
    public <T> T prodInutilization() {
        if (Objects.nonNull(getProdInutilization())) {
            return (T) getProdInutilization();
        }
        setProdInutilization(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.INUTILIZATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdInutilization();
    }

    @Override
    public <T> T homInutilization() {
        if (Objects.nonNull(getHomInutilization())) {
            return (T) getHomInutilization();
        }
        setHomInutilization(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.INUTILIZATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomInutilization();
    }

    @Override
    public <T> T prodQueryReceipt() {
        if (Objects.nonNull(getProdQueryReceipt())) {
            return (T) getProdQueryReceipt();
        }
        setProdQueryReceipt(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdQueryReceipt();
    }

    @Override
    public <T> T homQueryReceipt() {
        if (Objects.nonNull(getHomQueryReceipt())) {
            return (T) getHomQueryReceipt();
        }
        setHomQueryReceipt(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomQueryReceipt();
    }

    @Override
    public <T> T prodQuerySituation() {
        if (Objects.nonNull(getProdQuerySituation())) {
            return (T) getProdQuerySituation();
        }
        setProdQuerySituation(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdQuerySituation();
    }

    @Override
    public <T> T homQuerySituation() {
        if (Objects.nonNull(getHomQuerySituation())) {
            return (T) getHomQuerySituation();
        }
        setHomQuerySituation(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomQuerySituation();
    }

    @Override
    public <T> T prodReception() {
        if (Objects.nonNull(getProdReception())) {
            return (T) getProdReception();
        }
        setProdReception(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdReception();
    }

    @Override
    public <T> T homReception() {
        if (Objects.nonNull(getHomReception())) {
            return (T) getHomReception();
        }
        setHomReception(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomReception();
    }

    @Override
    public <T> T prodReceptionGtve() {
        if (Objects.nonNull(getProdReceptionGtve())) {
            return (T) getProdReceptionGtve();
        }
        setProdReceptionGtve(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_GTVE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdReceptionGtve();
    }

    @Override
    public <T> T homReceptionGtve() {
        if (Objects.nonNull(getHomReceptionGtve())) {
            return (T) getHomReceptionGtve();
        }
        setHomReceptionGtve(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_GTVE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomReceptionGtve();
    }

    @Override
    public <T> T prodReceptionOs() {
        if (Objects.nonNull(getProdReceptionOs())) {
            return (T) getProdReceptionOs();
        }
        setProdReceptionOs(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_OS).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdReceptionOs();
    }

    @Override
    public <T> T homReceptionOs() {
        if (Objects.nonNull(getHomReceptionOs())) {
            return (T) getHomReceptionOs();
        }
        setHomReceptionOs(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_OS).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomReceptionOs();
    }

    @Override
    public <T> T prodReceptionSync() {
        if (Objects.nonNull(getProdReceptionSync())) {
            return (T) getProdReceptionSync();
        }
        setProdReceptionSync(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdReceptionSync();
    }

    @Override
    public <T> T homReceptionSync() {
        if (Objects.nonNull(getHomReceptionSync())) {
            return (T) getHomReceptionSync();
        }
        setHomReceptionSync(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomReceptionSync();
    }

    @Override
    public <T> T prodStatusService() {
        if (Objects.nonNull(getProdStatusService())) {
            return (T) getProdStatusService();
        }
        setProdStatusService(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdStatusService();
    }

    @Override
    public <T> T homStatusService() {
        if (Objects.nonNull(getHomStatusService())) {
            return (T) getHomStatusService();
        }
        setHomStatusService(newServiceInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomStatusService();
    }

    public abstract CteAuthorizer getAuthorizer();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCteSoapService that)) return false;
        return Objects.equals(getAuthorizer(), that.getAuthorizer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorizer());
    }
}
