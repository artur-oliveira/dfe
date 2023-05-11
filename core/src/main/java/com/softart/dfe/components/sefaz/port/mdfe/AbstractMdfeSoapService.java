package com.softart.dfe.components.sefaz.port.mdfe;

import com.softart.dfe.components.security.socket.SocketFactory;
import com.softart.dfe.components.sefaz.port.AbstractSoapService;
import com.softart.dfe.components.sefaz.port.SoapServiceMapping;
import com.softart.dfe.components.sefaz.port.SoapServiceProxy;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.mdfe.MdfeAuthorizer;
import com.softart.dfe.enums.internal.mdfe.MdfePathEndpoint;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.sefaz.port.MdfeSoapService;
import com.softart.dfe.models.internal.port.MdfeServiceFinder;
import com.softart.dfe.util.ReflectionUtils;
import lombok.Data;

import javax.net.ssl.HttpsURLConnection;
import java.util.Objects;

@Data
@SuppressWarnings("unchecked")
public abstract class AbstractMdfeSoapService extends AbstractSoapService implements MdfeSoapService {
    private Object receptionHom;
    private Object queryReceiptHom;
    private Object eventHom;
    private Object querySituationHom;
    private Object statusServiceHom;
    private Object queryUnclosedHom;
    private Object distributionHom;
    private Object receptionSyncHom;
    private Object receptionProd;
    private Object queryReceiptProd;
    private Object eventProd;
    private Object querySituationProd;
    private Object statusServiceProd;
    private Object queryUnclosedProd;
    private Object distributionProd;
    private Object receptionSyncProd;

    @Override
    public MdfeConfig getConfig() {
        return (MdfeConfig) super.getConfig();
    }

    public void initialize(MdfeSoapService service) {
        this.config = service.getConfig();

        this.receptionHom = service.receptionHom();
        this.queryReceiptHom = service.queryReceiptHom();
        this.eventHom = service.eventHom();
        this.querySituationHom = service.querySituationHom();
        this.statusServiceHom = service.statusServiceHom();
        this.queryUnclosedHom = service.queryUnclosedHom();
        this.distributionHom = service.distributionHom();
        this.receptionSyncHom = service.receptionSyncHom();
        this.receptionProd = service.receptionProd();
        this.queryReceiptProd = service.queryReceiptProd();
        this.eventProd = service.eventProd();
        this.querySituationProd = service.querySituationProd();
        this.statusServiceProd = service.statusServiceProd();
        this.queryUnclosedProd = service.queryUnclosedProd();
        this.distributionProd = service.distributionProd();
        this.receptionSyncProd = service.receptionSyncProd();

        this.initialized = true;
    }

    public void initialize(Config config) throws SSLContextException {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(config).getSocketFactory());

        this.receptionHom = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.queryReceiptHom = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.eventHom = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.querySituationHom = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.statusServiceHom = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.queryUnclosedHom = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_UNCLOSED).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.distributionHom = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.receptionSyncHom = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        this.receptionProd = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.queryReceiptProd = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.eventProd = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.querySituationProd = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.statusServiceProd = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.queryUnclosedProd = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_UNCLOSED).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.distributionProd = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        this.receptionSyncProd = ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));

        SoapServiceProxy.getInstance().addMdfeService(this);

        this.initialized = true;
    }

    @Override
    public <T> T receptionHom() {
        if (Objects.nonNull(getReceptionHom())) {
            return (T) getReceptionHom();
        }
        setReceptionHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getReceptionHom();
    }

    @Override
    public <T> T queryReceiptHom() {
        if (Objects.nonNull(getQueryReceiptHom())) {
            return (T) getQueryReceiptHom();
        }
        setQueryReceiptHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getQueryReceiptHom();
    }

    @Override
    public <T> T eventHom() {
        if (Objects.nonNull(getEventHom())) {
            return (T) getEventHom();
        }
        setEventHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getEventHom();
    }

    @Override
    public <T> T querySituationHom() {
        if (Objects.nonNull(getQuerySituationHom())) {
            return (T) getQuerySituationHom();
        }
        setQuerySituationHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getQuerySituationHom();
    }

    @Override
    public <T> T statusServiceHom() {
        if (Objects.nonNull(getStatusServiceHom())) {
            return (T) getStatusServiceHom();
        }
        setStatusServiceHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getStatusServiceHom();
    }

    @Override
    public <T> T queryUnclosedHom() {
        if (Objects.nonNull(getQueryUnclosedHom())) {
            return (T) getQueryUnclosedHom();
        }
        setQueryUnclosedHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_UNCLOSED).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getQueryUnclosedHom();
    }

    @Override
    public <T> T distributionHom() {
        if (Objects.nonNull(getDistributionHom())) {
            return (T) getDistributionHom();
        }
        setDistributionHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getDistributionHom();
    }

    @Override
    public <T> T receptionSyncHom() {
        if (Objects.nonNull(getReceptionSyncHom())) {
            return (T) getReceptionSyncHom();
        }
        setReceptionSyncHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getReceptionSyncHom();
    }

    @Override
    public <T> T receptionProd() {
        if (Objects.nonNull(getReceptionProd())) {
            return (T) getReceptionProd();
        }
        setReceptionProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getReceptionProd();
    }

    @Override
    public <T> T queryReceiptProd() {
        if (Objects.nonNull(getQueryReceiptProd())) {
            return (T) getQueryReceiptProd();
        }
        setQueryReceiptProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getQueryReceiptProd();
    }

    @Override
    public <T> T eventProd() {
        if (Objects.nonNull(getEventProd())) {
            return (T) getEventProd();
        }
        setEventProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getEventProd();
    }

    @Override
    public <T> T querySituationProd() {
        if (Objects.nonNull(getQuerySituationProd())) {
            return (T) getQuerySituationProd();
        }
        setQuerySituationProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getQuerySituationProd();
    }

    @Override
    public <T> T statusServiceProd() {
        if (Objects.nonNull(getStatusServiceProd())) {
            return (T) getStatusServiceProd();
        }
        setStatusServiceProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getStatusServiceProd();
    }

    @Override
    public <T> T queryUnclosedProd() {
        if (Objects.nonNull(getQueryUnclosedProd())) {
            return (T) getQueryUnclosedProd();
        }
        setQueryUnclosedProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_UNCLOSED).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getQueryUnclosedProd();
    }

    @Override
    public <T> T distributionProd() {
        if (Objects.nonNull(getDistributionProd())) {
            return (T) getDistributionProd();
        }
        setDistributionProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getDistributionProd();
    }

    @Override
    public <T> T receptionSyncProd() {
        if (Objects.nonNull(getReceptionSyncProd())) {
            return (T) getReceptionSyncProd();
        }
        setReceptionSyncProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getReceptionSyncProd();
    }

    public abstract MdfeAuthorizer getAuthorizer();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractMdfeSoapService that)) return false;
        return Objects.equals(getAuthorizer(), that.getAuthorizer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorizer());
    }
}
