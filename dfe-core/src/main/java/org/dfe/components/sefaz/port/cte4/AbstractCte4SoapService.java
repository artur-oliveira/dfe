package org.dfe.components.sefaz.port.cte4;

import lombok.Data;
import org.dfe.components.security.socket.SocketFactory;
import org.dfe.components.sefaz.port.AbstractSoapService;
import org.dfe.components.sefaz.port.SoapServiceMapping;
import org.dfe.components.sefaz.port.SoapServiceProxy;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.cte.Cte4Authorizer;
import org.dfe.enums.internal.cte.Cte4PathEndpoint;
import org.dfe.exceptions.security.SSLContextException;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.sefaz.port.Cte4SoapService;
import org.dfe.models.internal.port.Cte4ServiceFinder;

import javax.net.ssl.HttpsURLConnection;
import java.util.Objects;
import java.util.Optional;

@Data
@SuppressWarnings("unchecked")
public abstract class AbstractCte4SoapService extends AbstractSoapService implements Cte4SoapService {

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

    void initializeDefault(AbstractCte4SoapService abstractCte4SoapService) {
        this.prodDistribution = Optional.ofNullable(abstractCte4SoapService.prodDistribution).orElse(this.prodDistribution);
        this.homDistribution = Optional.ofNullable(abstractCte4SoapService.homDistribution).orElse(this.homDistribution);
        this.prodEvent = Optional.ofNullable(abstractCte4SoapService.prodEvent).orElse(this.prodEvent);
        this.homEvent = Optional.ofNullable(abstractCte4SoapService.homEvent).orElse(this.homEvent);
        this.prodInutilization = Optional.ofNullable(abstractCte4SoapService.prodInutilization).orElse(this.prodInutilization);
        this.homInutilization = Optional.ofNullable(abstractCte4SoapService.homInutilization).orElse(this.homInutilization);
        this.prodQueryReceipt = Optional.ofNullable(abstractCte4SoapService.prodQueryReceipt).orElse(this.prodQueryReceipt);
        this.homQueryReceipt = Optional.ofNullable(abstractCte4SoapService.homQueryReceipt).orElse(this.homQueryReceipt);
        this.prodQuerySituation = Optional.ofNullable(abstractCte4SoapService.prodQuerySituation).orElse(this.prodQuerySituation);
        this.homQuerySituation = Optional.ofNullable(abstractCte4SoapService.homQuerySituation).orElse(this.homQuerySituation);
        this.prodReceptionGtve = Optional.ofNullable(abstractCte4SoapService.prodReceptionGtve).orElse(this.prodReceptionGtve);
        this.homReceptionGtve = Optional.ofNullable(abstractCte4SoapService.homReceptionGtve).orElse(this.homReceptionGtve);
        this.prodReceptionOs = Optional.ofNullable(abstractCte4SoapService.prodReceptionOs).orElse(this.prodReceptionOs);
        this.homReceptionOs = Optional.ofNullable(abstractCte4SoapService.homReceptionOs).orElse(this.homReceptionOs);
        this.prodReceptionSync = Optional.ofNullable(abstractCte4SoapService.prodReceptionSync).orElse(this.prodReceptionSync);
        this.homReceptionSync = Optional.ofNullable(abstractCte4SoapService.homReceptionSync).orElse(this.homReceptionSync);
        this.prodStatusService = Optional.ofNullable(abstractCte4SoapService.prodStatusService).orElse(this.prodStatusService);
        this.homStatusService = Optional.ofNullable(abstractCte4SoapService.homStatusService).orElse(this.homStatusService);
    }

    public void initialize(Cte4SoapService o) {
        this.config = o.getConfig();

        if (o instanceof AbstractCte4SoapService abstractCte4SoapService) {
            initializeDefault(abstractCte4SoapService);
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
                o.prodQuerySituation();
            } catch (Exception ignored) {
            }
            try {
                o.homQuerySituation();
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

        SoapServiceProxy.getInstance().addCte4Service(this);
        this.initialized = true;
    }

    public void initialize(Config config) throws SSLContextException {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(config).getSocketFactory());

        if (!LAZY_INITIALIZATION) {
            initialize(this);
        }

        SoapServiceProxy.getInstance().addCte4Service(this);
        this.initialized = true;
    }

    @Override
    public <T> T prodDistribution() {
        if (Objects.nonNull(getProdDistribution())) {
            return (T) getProdDistribution();
        }
        setProdDistribution(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.DISTRIBUTION).authorizer(Cte4Authorizer.AN).environment(Environment.PRODUCTION).build())));
        return (T) getProdDistribution();
    }

    @Override
    public <T> T homDistribution() {
        if (Objects.nonNull(getHomDistribution())) {
            return (T) getHomDistribution();
        }
        setHomDistribution(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.DISTRIBUTION).authorizer(Cte4Authorizer.AN).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomDistribution();
    }

    @Override
    public <T> T prodEvent() {
        if (Objects.nonNull(getProdEvent())) {
            return (T) getProdEvent();
        }
        setProdEvent(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdEvent();
    }

    @Override
    public <T> T homEvent() {
        if (Objects.nonNull(getHomEvent())) {
            return (T) getHomEvent();
        }
        setHomEvent(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomEvent();
    }

    @Override
    public <T> T prodQuerySituation() {
        if (Objects.nonNull(getProdQuerySituation())) {
            return (T) getProdQuerySituation();
        }
        setProdQuerySituation(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdQuerySituation();
    }

    @Override
    public <T> T homQuerySituation() {
        if (Objects.nonNull(getHomQuerySituation())) {
            return (T) getHomQuerySituation();
        }
        setHomQuerySituation(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomQuerySituation();
    }

    @Override
    public <T> T prodReceptionGtve() {
        if (Objects.nonNull(getProdReceptionGtve())) {
            return (T) getProdReceptionGtve();
        }
        setProdReceptionGtve(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_GTVE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdReceptionGtve();
    }

    @Override
    public <T> T homReceptionGtve() {
        if (Objects.nonNull(getHomReceptionGtve())) {
            return (T) getHomReceptionGtve();
        }
        setHomReceptionGtve(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_GTVE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomReceptionGtve();
    }

    @Override
    public <T> T prodReceptionOs() {
        if (Objects.nonNull(getProdReceptionOs())) {
            return (T) getProdReceptionOs();
        }
        setProdReceptionOs(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_OS).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdReceptionOs();
    }

    @Override
    public <T> T homReceptionOs() {
        if (Objects.nonNull(getHomReceptionOs())) {
            return (T) getHomReceptionOs();
        }
        setHomReceptionOs(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_OS).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomReceptionOs();
    }

    @Override
    public <T> T prodReceptionSync() {
        if (Objects.nonNull(getProdReceptionSync())) {
            return (T) getProdReceptionSync();
        }
        setProdReceptionSync(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdReceptionSync();
    }

    @Override
    public <T> T homReceptionSync() {
        if (Objects.nonNull(getHomReceptionSync())) {
            return (T) getHomReceptionSync();
        }
        setHomReceptionSync(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomReceptionSync();
    }

    @Override
    public <T> T prodStatusService() {
        if (Objects.nonNull(getProdStatusService())) {
            return (T) getProdStatusService();
        }
        setProdStatusService(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdStatusService();
    }

    @Override
    public <T> T homStatusService() {
        if (Objects.nonNull(getHomStatusService())) {
            return (T) getHomStatusService();
        }
        setHomStatusService(newServiceInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomStatusService();
    }

    public abstract Cte4Authorizer getAuthorizer();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCte4SoapService that)) return false;
        return Objects.equals(getAuthorizer(), that.getAuthorizer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorizer());
    }
}
