package com.softart.dfe.components.sefaz.port.cte;

import com.softart.dfe.components.security.socket.SocketFactory;
import com.softart.dfe.components.sefaz.port.AbstractSoapService;
import com.softart.dfe.components.sefaz.port.SoapServiceMapping;
import com.softart.dfe.components.sefaz.port.SoapServiceProxy;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.cte.CteAuthorizer;
import com.softart.dfe.enums.internal.cte.CtePathEndpoint;
import com.softart.dfe.exceptions.RequiredException;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.sefaz.port.CteSoapService;
import com.softart.dfe.models.internal.port.CteServiceFinder;
import com.softart.dfe.util.ReflectionUtils;
import com.softart.dfe.util.RequireUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.net.ssl.HttpsURLConnection;

@Data
@EqualsAndHashCode(callSuper = true)
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
        } catch (RequiredException ignored) {
        }
        try {
            this.homDistribution = cached.homDistribution();
        } catch (RequiredException ignored) {
        }
        try {
            this.prodEvent = cached.prodEvent();
        } catch (RequiredException ignored) {
        }
        try {
            this.homEvent = cached.homEvent();
        } catch (RequiredException ignored) {
        }
        try {
            this.prodInutilization = cached.prodInutilization();
        } catch (RequiredException ignored) {
        }
        try {
            this.homInutilization = cached.homInutilization();
        } catch (RequiredException ignored) {
        }
        try {
            this.prodQueryReceipt = cached.prodQueryReceipt();
        } catch (RequiredException ignored) {
        }
        try {
            this.homQueryReceipt = cached.homQueryReceipt();
        } catch (RequiredException ignored) {
        }
        try {
            this.prodQuerySituation = cached.prodQuerySituation();
        } catch (RequiredException ignored) {
        }
        try {
            this.homQuerySituation = cached.homQuerySituation();
        } catch (RequiredException ignored) {
        }
        try {
            this.prodReception = cached.prodReception();
        } catch (RequiredException ignored) {
        }
        try {
            this.homReception = cached.homReception();
        } catch (RequiredException ignored) {
        }
        try {
            this.prodReceptionGtve = cached.prodReceptionGtve();
        } catch (RequiredException ignored) {
        }
        try {
            this.homReceptionGtve = cached.homReceptionGtve();
        } catch (RequiredException ignored) {
        }
        try {
            this.prodReceptionOs = cached.prodReceptionOs();
        } catch (RequiredException ignored) {
        }
        try {
            this.homReceptionOs = cached.homReceptionOs();
        } catch (RequiredException ignored) {
        }
        try {
            this.prodReceptionSync = cached.prodReceptionSync();
        } catch (RequiredException ignored) {
        }
        try {
            this.homReceptionSync = cached.homReceptionSync();
        } catch (RequiredException ignored) {
        }
        try {
            this.prodStatusService = cached.prodStatusService();
        } catch (RequiredException ignored) {
        }
        try {
            this.homStatusService = cached.homStatusService();
        } catch (RequiredException ignored) {
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

        SoapServiceProxy.getInstance().addCteService(getConfig(), this);

        this.initialized = true;
    }

    @Override
    public <T> T prodDistribution() {
        return (T) RequireUtils.nonNull(this.prodDistribution, "prodDistribution() cannot be null");
    }

    @Override
    public <T> T homDistribution() {
        return (T) RequireUtils.nonNull(this.homDistribution, "homDistribution() cannot be null");
    }

    @Override
    public <T> T prodEvent() {
        return (T) RequireUtils.nonNull(this.prodEvent, "prodEvent() cannot be null");
    }

    @Override
    public <T> T homEvent() {
        return (T) RequireUtils.nonNull(this.homEvent, "homEvent() cannot be null");
    }

    @Override
    public <T> T prodInutilization() {
        return (T) RequireUtils.nonNull(this.prodInutilization, "prodInutilization() cannot be null");
    }

    @Override
    public <T> T homInutilization() {
        return (T) RequireUtils.nonNull(this.homInutilization, "homInutilization() cannot be null");
    }

    @Override
    public <T> T prodQueryReceipt() {
        return (T) RequireUtils.nonNull(this.prodQueryReceipt, "prodQueryReceipt() cannot be null");
    }

    @Override
    public <T> T homQueryReceipt() {
        return (T) RequireUtils.nonNull(this.homQueryReceipt, "homQueryReceipt() cannot be null");
    }

    @Override
    public <T> T prodQuerySituation() {
        return (T) RequireUtils.nonNull(this.prodQuerySituation, "prodQuerySituation() cannot be null");
    }

    @Override
    public <T> T homQuerySituation() {
        return (T) RequireUtils.nonNull(this.homQuerySituation, "homQuerySituation() cannot be null");
    }

    @Override
    public <T> T prodReception() {
        return (T) RequireUtils.nonNull(this.prodReception, "prodReception() cannot be null");
    }

    @Override
    public <T> T homReception() {
        return (T) RequireUtils.nonNull(this.homReception, "homReception() cannot be null");
    }

    @Override
    public <T> T prodReceptionGtve() {
        return (T) RequireUtils.nonNull(this.prodReceptionGtve, "prodReceptionGtve() cannot be null");
    }

    @Override
    public <T> T homReceptionGtve() {
        return (T) RequireUtils.nonNull(this.homReceptionGtve, "homReceptionGtve() cannot be null");
    }

    @Override
    public <T> T prodReceptionOs() {
        return (T) RequireUtils.nonNull(this.prodReceptionOs, "prodReceptionOs() cannot be null");
    }

    @Override
    public <T> T homReceptionOs() {
        return (T) RequireUtils.nonNull(this.homReceptionOs, "homReceptionOs() cannot be null");
    }

    @Override
    public <T> T prodReceptionSync() {
        return (T) RequireUtils.nonNull(this.prodReceptionSync, "prodReceptionSync() cannot be null");
    }

    @Override
    public <T> T homReceptionSync() {
        return (T) RequireUtils.nonNull(this.homReceptionSync, "homReceptionSync() cannot be null");
    }

    @Override
    public <T> T prodStatusService() {
        return (T) RequireUtils.nonNull(this.prodStatusService, "prodStatusService() cannot be null");
    }

    @Override
    public <T> T homStatusService() {
        return (T) RequireUtils.nonNull(this.homStatusService, "homStatusService() cannot be null");
    }

    public abstract CteAuthorizer getAuthorizer();
}
