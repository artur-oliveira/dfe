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
import java.util.Optional;

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
    private Object distributionOldHom;
    private Object receptionSyncHom;
    private Object receptionProd;
    private Object queryReceiptProd;
    private Object eventProd;
    private Object querySituationProd;
    private Object statusServiceProd;
    private Object queryUnclosedProd;
    private Object distributionProd;
    private Object distributionOldProd;
    private Object receptionSyncProd;

    @Override
    public MdfeConfig getConfig() {
        return (MdfeConfig) super.getConfig();
    }

    void initializeDefault(AbstractMdfeSoapService abstractMdfeSoapService) {
        this.receptionHom = Optional.ofNullable(abstractMdfeSoapService.receptionHom).orElse(this.receptionHom);
        this.queryReceiptHom = Optional.ofNullable(abstractMdfeSoapService.queryReceiptHom).orElse(this.queryReceiptHom);
        this.eventHom = Optional.ofNullable(abstractMdfeSoapService.eventHom).orElse(this.eventHom);
        this.querySituationHom = Optional.ofNullable(abstractMdfeSoapService.querySituationHom).orElse(this.querySituationHom);
        this.statusServiceHom = Optional.ofNullable(abstractMdfeSoapService.statusServiceHom).orElse(this.statusServiceHom);
        this.queryUnclosedHom = Optional.ofNullable(abstractMdfeSoapService.queryUnclosedHom).orElse(this.queryUnclosedHom);
        this.distributionHom = Optional.ofNullable(abstractMdfeSoapService.distributionHom).orElse(this.distributionHom);
        this.distributionOldHom = Optional.ofNullable(abstractMdfeSoapService.distributionOldHom).orElse(this.distributionOldHom);
        this.receptionSyncHom = Optional.ofNullable(abstractMdfeSoapService.receptionSyncHom).orElse(this.receptionSyncHom);
        this.receptionProd = Optional.ofNullable(abstractMdfeSoapService.receptionProd).orElse(this.receptionProd);
        this.queryReceiptProd = Optional.ofNullable(abstractMdfeSoapService.queryReceiptProd).orElse(this.queryReceiptProd);
        this.eventProd = Optional.ofNullable(abstractMdfeSoapService.eventProd).orElse(this.eventProd);
        this.querySituationProd = Optional.ofNullable(abstractMdfeSoapService.querySituationProd).orElse(this.querySituationProd);
        this.statusServiceProd = Optional.ofNullable(abstractMdfeSoapService.statusServiceProd).orElse(this.statusServiceProd);
        this.queryUnclosedProd = Optional.ofNullable(abstractMdfeSoapService.queryUnclosedProd).orElse(this.queryUnclosedProd);
        this.distributionProd = Optional.ofNullable(abstractMdfeSoapService.distributionProd).orElse(this.distributionProd);
        this.distributionOldProd = Optional.ofNullable(abstractMdfeSoapService.distributionOldProd).orElse(this.distributionOldProd);
        this.receptionSyncProd = Optional.ofNullable(abstractMdfeSoapService.receptionSyncProd).orElse(this.receptionSyncProd);
    }

    public void initialize(MdfeSoapService o) {
        this.config = o.getConfig();

        if (o instanceof AbstractMdfeSoapService abstractMdfeSoapService) {
            initializeDefault(abstractMdfeSoapService);
        }

        if (!LAZY_INITIALIZATION) {
            try {
                o.receptionHom();
            } catch (Exception ignored) {
            }
            try {
                o.queryReceiptHom();
            } catch (Exception ignored) {
            }
            try {
                o.eventHom();
            } catch (Exception ignored) {
            }
            try {
                o.querySituationHom();
            } catch (Exception ignored) {
            }
            try {
                o.statusServiceHom();
            } catch (Exception ignored) {
            }
            try {
                o.queryUnclosedHom();
            } catch (Exception ignored) {
            }
            try {
                o.distributionHom();
            } catch (Exception ignored) {
            }
            try {
                o.distributionOldHom();
            } catch (Exception ignored) {
            }
            try {
                o.receptionSyncHom();
            } catch (Exception ignored) {
            }
            try {
                o.receptionProd();
            } catch (Exception ignored) {
            }
            try {
                o.queryReceiptProd();
            } catch (Exception ignored) {
            }
            try {
                o.eventProd();
            } catch (Exception ignored) {
            }
            try {
                o.querySituationProd();
            } catch (Exception ignored) {
            }
            try {
                o.statusServiceProd();
            } catch (Exception ignored) {
            }
            try {
                o.queryUnclosedProd();
            } catch (Exception ignored) {
            }
            try {
                o.distributionProd();
            } catch (Exception ignored) {
            }
            try {
                o.distributionOldProd();
            } catch (Exception ignored) {
            }
            try {
                o.receptionSyncProd();
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

        SoapServiceProxy.getInstance().addMdfeService(this);
        this.initialized = true;
    }

    @Override
    public <T> T receptionHom() {
        if (Objects.nonNull(getReceptionHom())) {
            return (T) getReceptionHom();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setReceptionHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getReceptionHom())) {
                break;
            }
        }
        if (Objects.isNull(getReceptionHom())) {
            setReceptionHom(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getReceptionHom();
    }

    @Override
    public <T> T queryReceiptHom() {
        if (Objects.nonNull(getQueryReceiptHom())) {
            return (T) getQueryReceiptHom();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setQueryReceiptHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getQueryReceiptHom())) {
                break;
            }
        }
        if (Objects.isNull(getQueryReceiptHom())) {
            setQueryReceiptHom(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getQueryReceiptHom();
    }

    @Override
    public <T> T eventHom() {
        if (Objects.nonNull(getEventHom())) {
            return (T) getEventHom();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setEventHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getEventHom())) {
                break;
            }
        }
        if (Objects.isNull(getEventHom())) {
            setEventHom(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getEventHom();
    }

    @Override
    public <T> T querySituationHom() {
        if (Objects.nonNull(getQuerySituationHom())) {
            return (T) getQuerySituationHom();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setQuerySituationHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getQuerySituationHom())) {
                break;
            }
        }
        if (Objects.isNull(getQuerySituationHom())) {
            setQuerySituationHom(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getQuerySituationHom();
    }

    @Override
    public <T> T statusServiceHom() {
        if (Objects.nonNull(getStatusServiceHom())) {
            return (T) getStatusServiceHom();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setStatusServiceHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getStatusServiceHom())) {
                break;
            }
        }
        if (Objects.isNull(getStatusServiceHom())) {
            setStatusServiceHom(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getStatusServiceHom();
    }

    @Override
    public <T> T queryUnclosedHom() {
        if (Objects.nonNull(getQueryUnclosedHom())) {
            return (T) getQueryUnclosedHom();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setQueryUnclosedHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_UNCLOSED).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getQueryUnclosedHom())) {
                break;
            }
        }
        if (Objects.isNull(getQueryUnclosedHom())) {
            setQueryUnclosedHom(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_UNCLOSED).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getQueryUnclosedHom();
    }

    @Override
    public <T> T distributionHom() {
        if (Objects.nonNull(getDistributionHom())) {
            return (T) getDistributionHom();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setDistributionHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getDistributionHom())) {
                break;
            }
        }
        if (Objects.isNull(getDistributionHom())) {
            setDistributionHom(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getDistributionHom();
    }

    @Override
    public <T> T distributionOldHom() {
        if (Objects.nonNull(getDistributionOldHom())) {
            return (T) getDistributionOldHom();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setDistributionOldHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION_OLD).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getDistributionOldHom())) {
                break;
            }
        }
        if (Objects.isNull(getDistributionOldHom())) {
            setDistributionOldHom(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION_OLD).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getDistributionOldHom();
    }

    @Override
    public <T> T receptionSyncHom() {
        if (Objects.nonNull(getReceptionSyncHom())) {
            return (T) getReceptionSyncHom();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setReceptionSyncHom(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
            if (Objects.nonNull(getReceptionSyncHom())) {
                break;
            }
        }
        if (Objects.isNull(getReceptionSyncHom())) {
            setReceptionSyncHom(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        }
        return (T) getReceptionSyncHom();
    }

    @Override
    public <T> T receptionProd() {
        if (Objects.nonNull(getReceptionProd())) {
            return (T) getReceptionProd();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setReceptionProd(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getReceptionProd())) {
                break;
            }
        }
        if (Objects.isNull(getReceptionProd())) {
            setReceptionProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getReceptionProd();
    }

    @Override
    public <T> T queryReceiptProd() {
        if (Objects.nonNull(getQueryReceiptProd())) {
            return (T) getQueryReceiptProd();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setQueryReceiptProd(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getQueryReceiptProd())) {
                break;
            }
        }
        if (Objects.isNull(getQueryReceiptProd())) {
            setQueryReceiptProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getQueryReceiptProd();
    }

    @Override
    public <T> T eventProd() {
        if (Objects.nonNull(getEventProd())) {
            return (T) getEventProd();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setEventProd(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getEventProd())) {
                break;
            }
        }
        if (Objects.isNull(getEventProd())) {
            setEventProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getEventProd();
    }

    @Override
    public <T> T querySituationProd() {
        if (Objects.nonNull(getQuerySituationProd())) {
            return (T) getQuerySituationProd();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setQuerySituationProd(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getQuerySituationProd())) {
                break;
            }
        }
        if (Objects.isNull(getQuerySituationProd())) {
            setQuerySituationProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getQuerySituationProd();
    }

    @Override
    public <T> T statusServiceProd() {
        if (Objects.nonNull(getStatusServiceProd())) {
            return (T) getStatusServiceProd();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setStatusServiceProd(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getStatusServiceProd())) {
                break;
            }
        }
        if (Objects.isNull(getStatusServiceProd())) {
            setStatusServiceProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getStatusServiceProd();
    }

    @Override
    public <T> T queryUnclosedProd() {
        if (Objects.nonNull(getQueryUnclosedProd())) {
            return (T) getQueryUnclosedProd();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setQueryUnclosedProd(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_UNCLOSED).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getQueryUnclosedProd())) {
                break;
            }
        }
        if (Objects.isNull(getQueryUnclosedProd())) {
            setQueryUnclosedProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_UNCLOSED).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getQueryUnclosedProd();
    }

    @Override
    public <T> T distributionProd() {
        if (Objects.nonNull(getDistributionProd())) {
            return (T) getDistributionProd();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setDistributionProd(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getDistributionProd())) {
                break;
            }
        }
        if (Objects.isNull(getDistributionProd())) {
            setDistributionProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getDistributionProd();
    }

    @Override
    public <T> T distributionOldProd() {
        if (Objects.nonNull(getDistributionOldProd())) {
            return (T) getDistributionOldProd();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setDistributionOldProd(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION_OLD).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getDistributionOldProd())) {
                break;
            }
        }
        if (Objects.isNull(getDistributionOldProd())) {
            setDistributionOldProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION_OLD).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
        return (T) getDistributionOldProd();
    }

    @Override
    public <T> T receptionSyncProd() {
        if (Objects.nonNull(getReceptionSyncProd())) {
            return (T) getReceptionSyncProd();
        }
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            setReceptionSyncProd(ReflectionUtils.safeNewInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
            if (Objects.nonNull(getReceptionSyncProd())) {
                break;
            }
        }
        if (Objects.isNull(getReceptionSyncProd())) {
            setReceptionSyncProd(ReflectionUtils.newInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        }
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
