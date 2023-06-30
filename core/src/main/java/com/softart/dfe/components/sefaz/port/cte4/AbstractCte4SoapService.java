package com.softart.dfe.components.sefaz.port.cte4;

import com.softart.dfe.components.security.socket.SocketFactory;
import com.softart.dfe.components.sefaz.port.AbstractSoapService;
import com.softart.dfe.components.sefaz.port.SoapServiceMapping;
import com.softart.dfe.components.sefaz.port.SoapServiceProxy;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.cte.Cte4Authorizer;
import com.softart.dfe.enums.internal.cte.Cte4PathEndpoint;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.sefaz.port.Cte4SoapService;
import com.softart.dfe.interfaces.sefaz.port.CteSoapService;
import com.softart.dfe.models.internal.port.Cte4ServiceFinder;
import com.softart.dfe.util.ReflectionUtils;
import lombok.Data;

import javax.net.ssl.HttpsURLConnection;
import java.util.Objects;

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

    public void initialize(Cte4SoapService o) {
        this.config = o.getConfig();
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
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdDistribution(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.DISTRIBUTION).authorizer(Cte4Authorizer.AN).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getProdDistribution())) {
                break;
            }
        }
        if (Objects.isNull(getProdDistribution())) {
            setProdDistribution(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.DISTRIBUTION).authorizer(Cte4Authorizer.AN).environment(Environment.PRODUCTION).build())));
        }
        return (T) getProdDistribution();
    }

    @Override
    public <T> T homDistribution() {
        if (Objects.nonNull(getHomDistribution())) {
            return (T) getHomDistribution();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomDistribution(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.DISTRIBUTION).authorizer(Cte4Authorizer.AN).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getHomDistribution())) {
                break;
            }
        }
        if (Objects.isNull(getHomDistribution())) {
            setHomDistribution(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.DISTRIBUTION).authorizer(Cte4Authorizer.AN).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getHomDistribution();
    }

    @Override
    public <T> T prodEvent() {
        if (Objects.nonNull(getProdEvent())) {
            return (T) getProdEvent();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdEvent(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getProdEvent())) {
                break;
            }
        }
        if (Objects.isNull(getProdEvent())) {
            setProdEvent(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getProdEvent();
    }

    @Override
    public <T> T homEvent() {
        if (Objects.nonNull(getHomEvent())) {
            return (T) getHomEvent();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomEvent(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getHomEvent())) {
                break;
            }
        }
        if (Objects.isNull(getHomEvent())) {
            setHomEvent(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getHomEvent();
    }

    @Override
    public <T> T prodQuerySituation() {
        if (Objects.nonNull(getProdQuerySituation())) {
            return (T) getProdQuerySituation();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdQuerySituation(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getProdQuerySituation())) {
                break;
            }
        }
        if (Objects.isNull(getProdQuerySituation())) {
            setProdQuerySituation(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getProdQuerySituation();
    }

    @Override
    public <T> T homQuerySituation() {
        if (Objects.nonNull(getHomQuerySituation())) {
            return (T) getHomQuerySituation();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomQuerySituation(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getHomQuerySituation())) {
                break;
            }
        }
        if (Objects.isNull(getHomQuerySituation())) {
            setHomQuerySituation(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getHomQuerySituation();
    }

    @Override
    public <T> T prodReceptionGtve() {
        if (Objects.nonNull(getProdReceptionGtve())) {
            return (T) getProdReceptionGtve();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdReceptionGtve(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_GTVE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getProdReceptionGtve())) {
                break;
            }
        }
        if (Objects.isNull(getProdReceptionGtve())) {
            setProdReceptionGtve(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_GTVE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getProdReceptionGtve();
    }

    @Override
    public <T> T homReceptionGtve() {
        if (Objects.nonNull(getHomReceptionGtve())) {
            return (T) getHomReceptionGtve();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomReceptionGtve(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_GTVE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getHomReceptionGtve())) {
                break;
            }
        }
        if (Objects.isNull(getHomReceptionGtve())) {
            setHomReceptionGtve(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_GTVE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getHomReceptionGtve();
    }

    @Override
    public <T> T prodReceptionOs() {
        if (Objects.nonNull(getProdReceptionOs())) {
            return (T) getProdReceptionOs();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdReceptionOs(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_OS).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getProdReceptionOs())) {
                break;
            }
        }
        if (Objects.isNull(getProdReceptionOs())) {
            setProdReceptionOs(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_OS).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getProdReceptionOs();
    }

    @Override
    public <T> T homReceptionOs() {
        if (Objects.nonNull(getHomReceptionOs())) {
            return (T) getHomReceptionOs();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomReceptionOs(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_OS).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getHomReceptionOs())) {
                break;
            }
        }
        if (Objects.isNull(getHomReceptionOs())) {
            setHomReceptionOs(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_OS).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getHomReceptionOs();
    }

    @Override
    public <T> T prodReceptionSync() {
        if (Objects.nonNull(getProdReceptionSync())) {
            return (T) getProdReceptionSync();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdReceptionSync(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getProdReceptionSync())) {
                break;
            }
        }
        if (Objects.isNull(getProdReceptionSync())) {
            setProdReceptionSync(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getProdReceptionSync();
    }

    @Override
    public <T> T homReceptionSync() {
        if (Objects.nonNull(getHomReceptionSync())) {
            return (T) getHomReceptionSync();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomReceptionSync(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getHomReceptionSync())) {
                break;
            }
        }
        if (Objects.isNull(getHomReceptionSync())) {
            setHomReceptionSync(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getHomReceptionSync();
    }

    @Override
    public <T> T prodStatusService() {
        if (Objects.nonNull(getProdStatusService())) {
            return (T) getProdStatusService();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setProdStatusService(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getProdStatusService())) {
                break;
            }
        }
        if (Objects.isNull(getProdStatusService())) {
            setProdStatusService(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getProdStatusService();
    }

    @Override
    public <T> T homStatusService() {
        if (Objects.nonNull(getHomStatusService())) {
            return (T) getHomStatusService();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setHomStatusService(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getHomStatusService())) {
                break;
            }
        }
        if (Objects.isNull(getHomStatusService())) {
            setHomStatusService(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCte4ServiceClassFor(Cte4ServiceFinder.builder().endpoint(Cte4PathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
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
