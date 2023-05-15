package com.softart.dfe.components.sefaz.port.cte;

import com.softart.dfe.components.security.socket.SocketFactory;
import com.softart.dfe.components.sefaz.port.AbstractSoapService;
import com.softart.dfe.components.sefaz.port.SoapServiceMapping;
import com.softart.dfe.components.sefaz.port.SoapServiceProxy;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.cte.CteAuthorizer;
import com.softart.dfe.enums.internal.cte.CtePathEndpoint;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.sefaz.port.CteSoapService;
import com.softart.dfe.models.internal.port.CteServiceFinder;
import com.softart.dfe.util.ReflectionUtils;
import lombok.Data;

import javax.net.ssl.HttpsURLConnection;
import java.util.Objects;

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

    public void initialize(CteSoapService cached) {
        this.config = cached.getConfig();

        try {
            this.prodDistribution = cached.prodDistribution();
        } catch (Exception ignored) {
        }
        try {
            this.homDistribution = cached.homDistribution();
        } catch (Exception ignored) {
        }
        try {
            this.prodEvent = cached.prodEvent();
        } catch (Exception ignored) {
        }
        try {
            this.homEvent = cached.homEvent();
        } catch (Exception ignored) {
        }
        try {
            this.prodInutilization = cached.prodInutilization();
        } catch (Exception ignored) {
        }
        try {
            this.homInutilization = cached.homInutilization();
        } catch (Exception ignored) {
        }
        try {
            this.prodQueryReceipt = cached.prodQueryReceipt();
        } catch (Exception ignored) {
        }
        try {
            this.homQueryReceipt = cached.homQueryReceipt();
        } catch (Exception ignored) {
        }
        try {
            this.prodQuerySituation = cached.prodQuerySituation();
        } catch (Exception ignored) {
        }
        try {
            this.homQuerySituation = cached.homQuerySituation();
        } catch (Exception ignored) {
        }
        try {
            this.prodReception = cached.prodReception();
        } catch (Exception ignored) {
        }
        try {
            this.homReception = cached.homReception();
        } catch (Exception ignored) {
        }
        try {
            this.prodReceptionGtve = cached.prodReceptionGtve();
        } catch (Exception ignored) {
        }
        try {
            this.homReceptionGtve = cached.homReceptionGtve();
        } catch (Exception ignored) {
        }
        try {
            this.prodReceptionOs = cached.prodReceptionOs();
        } catch (Exception ignored) {
        }
        try {
            this.homReceptionOs = cached.homReceptionOs();
        } catch (Exception ignored) {
        }
        try {
            this.prodReceptionSync = cached.prodReceptionSync();
        } catch (Exception ignored) {
        }
        try {
            this.homReceptionSync = cached.homReceptionSync();
        } catch (Exception ignored) {
        }
        try {
            this.prodStatusService = cached.prodStatusService();
        } catch (Exception ignored) {
        }
        try {
            this.homStatusService = cached.homStatusService();
        } catch (Exception ignored) {
        }

        this.initialized = true;
    }

    public void initialize(Config config) throws SSLContextException {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(config).getSocketFactory());

        this.prodDistribution = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.DISTRIBUTION).authorizer(CteAuthorizer.AN).environment(Environment.PRODUCTION).build()));
        this.homDistribution = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.DISTRIBUTION).authorizer(CteAuthorizer.AN).environment(Environment.HOMOLOGATION).build()));
        this.prodEvent = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.homEvent = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.prodInutilization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.INUTILIZATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.homInutilization = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.INUTILIZATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.prodQueryReceipt = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.homQueryReceipt = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.prodQuerySituation = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.homQuerySituation = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.prodReception = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.homReception = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.prodReceptionGtve = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_GTVE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.homReceptionGtve = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_GTVE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.prodReceptionOs = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_OS).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.homReceptionOs = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_OS).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.prodReceptionSync = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.homReceptionSync = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.prodStatusService = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.homStatusService = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));

        SoapServiceProxy.getInstance().addCteService(this);

        this.initialized = true;
    }

    @Override
    public <T> T prodDistribution() {
        if (Objects.nonNull(getProdDistribution())) {
            return (T) getProdDistribution();
        }
        setProdDistribution(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdDistribution();
    }

    @Override
    public <T> T homDistribution() {
        if (Objects.nonNull(getHomDistribution())) {
            return (T) getHomDistribution();
        }
        setHomDistribution(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomDistribution();
    }

    @Override
    public <T> T prodEvent() {
        if (Objects.nonNull(getProdEvent())) {
            return (T) getProdEvent();
        }
        setProdEvent(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdEvent();
    }

    @Override
    public <T> T homEvent() {
        if (Objects.nonNull(getHomEvent())) {
            return (T) getHomEvent();
        }
        setHomEvent(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomEvent();
    }

    @Override
    public <T> T prodInutilization() {
        if (Objects.nonNull(getProdInutilization())) {
            return (T) getProdInutilization();
        }
        setProdInutilization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.INUTILIZATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdInutilization();
    }

    @Override
    public <T> T homInutilization() {
        if (Objects.nonNull(getHomInutilization())) {
            return (T) getHomInutilization();
        }
        setHomInutilization(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.INUTILIZATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomInutilization();
    }

    @Override
    public <T> T prodQueryReceipt() {
        if (Objects.nonNull(getProdQueryReceipt())) {
            return (T) getProdQueryReceipt();
        }
        setProdQueryReceipt(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdQueryReceipt();
    }

    @Override
    public <T> T homQueryReceipt() {
        if (Objects.nonNull(getHomQueryReceipt())) {
            return (T) getHomQueryReceipt();
        }
        setHomQueryReceipt(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomQueryReceipt();
    }

    @Override
    public <T> T prodQuerySituation() {
        if (Objects.nonNull(getProdQuerySituation())) {
            return (T) getProdQuerySituation();
        }
        setProdQuerySituation(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdQuerySituation();
    }

    @Override
    public <T> T homQuerySituation() {
        if (Objects.nonNull(getHomQuerySituation())) {
            return (T) getHomQuerySituation();
        }
        setHomQuerySituation(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomQuerySituation();
    }

    @Override
    public <T> T prodReception() {
        if (Objects.nonNull(getProdReception())) {
            return (T) getProdReception();
        }
        setProdReception(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdReception();
    }

    @Override
    public <T> T homReception() {
        if (Objects.nonNull(getHomReception())) {
            return (T) getHomReception();
        }
        setHomReception(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomReception();
    }

    @Override
    public <T> T prodReceptionGtve() {
        if (Objects.nonNull(getProdReceptionGtve())) {
            return (T) getProdReceptionGtve();
        }
        setProdReceptionGtve(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_GTVE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdReceptionGtve();
    }

    @Override
    public <T> T homReceptionGtve() {
        if (Objects.nonNull(getHomReceptionGtve())) {
            return (T) getHomReceptionGtve();
        }
        setHomReceptionGtve(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_GTVE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomReceptionGtve();
    }

    @Override
    public <T> T prodReceptionOs() {
        if (Objects.nonNull(getProdReceptionOs())) {
            return (T) getProdReceptionOs();
        }
        setProdReceptionOs(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_OS).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdReceptionOs();
    }

    @Override
    public <T> T homReceptionOs() {
        if (Objects.nonNull(getHomReceptionOs())) {
            return (T) getHomReceptionOs();
        }
        setHomReceptionOs(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_OS).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomReceptionOs();
    }

    @Override
    public <T> T prodReceptionSync() {
        if (Objects.nonNull(getProdReceptionSync())) {
            return (T) getProdReceptionSync();
        }
        setProdReceptionSync(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdReceptionSync();
    }

    @Override
    public <T> T homReceptionSync() {
        if (Objects.nonNull(getHomReceptionSync())) {
            return (T) getHomReceptionSync();
        }
        setHomReceptionSync(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getHomReceptionSync();
    }

    @Override
    public <T> T prodStatusService() {
        if (Objects.nonNull(getProdStatusService())) {
            return (T) getProdStatusService();
        }
        setProdStatusService(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getProdStatusService();
    }

    @Override
    public <T> T homStatusService() {
        if (Objects.nonNull(getHomStatusService())) {
            return (T) getHomStatusService();
        }
        setHomStatusService(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getCteServiceClassFor(CteServiceFinder.builder().endpoint(CtePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
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
