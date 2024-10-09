package org.dfe.components.sefaz.port.mdfe;

import lombok.Data;
import org.dfe.components.security.socket.SocketFactory;
import org.dfe.components.sefaz.port.AbstractSoapService;
import org.dfe.components.sefaz.port.SoapServiceMapping;
import org.dfe.components.sefaz.port.SoapServiceProxy;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.mdfe.MdfeAuthorizer;
import org.dfe.enums.internal.mdfe.MdfePathEndpoint;
import org.dfe.exceptions.security.SSLContextException;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.sefaz.port.MdfeSoapService;
import org.dfe.models.internal.port.MdfeServiceFinder;

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

    void fullInitialization(MdfeSoapService o) {
        safeInititialization(o::receptionHom);
        safeInititialization(o::queryReceiptHom);
        safeInititialization(o::eventHom);
        safeInititialization(o::querySituationHom);
        safeInititialization(o::statusServiceHom);
        safeInititialization(o::queryUnclosedHom);
        safeInititialization(o::distributionHom);
        safeInititialization(o::distributionOldHom);
        safeInititialization(o::receptionSyncHom);
        safeInititialization(o::receptionProd);
        safeInititialization(o::queryReceiptProd);
        safeInititialization(o::eventProd);
        safeInititialization(o::querySituationProd);
        safeInititialization(o::statusServiceProd);
        safeInititialization(o::queryUnclosedProd);
        safeInititialization(o::distributionProd);
        safeInititialization(o::distributionOldProd);
        safeInititialization(o::receptionSyncProd);
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

        if (!MdfeSoapConfigurationProperties.LAZY_INITIALIZATION) {
            fullInitialization(o);
        }

        this.initialized = true;
    }

    public void initialize(Config config) throws SSLContextException {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(config).getSocketFactory());

        if (!MdfeSoapConfigurationProperties.LAZY_INITIALIZATION) {
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
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_HOM_RECEPTION) {
            setReceptionHom(o);
        }
        return (T) o;
    }

    @Override
    public <T> T queryReceiptHom() {
        if (Objects.nonNull(getQueryReceiptHom())) {
            return (T) getQueryReceiptHom();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_HOM_QUERY_RECEIPT) {
            setQueryReceiptHom(o);
        }
        return (T) o;
    }

    @Override
    public <T> T eventHom() {
        if (Objects.nonNull(getEventHom())) {
            return (T) getEventHom();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_HOM_EVENT) {
            setEventHom(o);
        }
        return (T) o;
    }

    @Override
    public <T> T querySituationHom() {
        if (Objects.nonNull(getQuerySituationHom())) {
            return (T) getQuerySituationHom();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_HOM_QUERY_SITUATION) {
            setQuerySituationHom(o);
        }
        return (T) o;
    }

    @Override
    public <T> T statusServiceHom() {
        if (Objects.nonNull(getStatusServiceHom())) {
            return (T) getStatusServiceHom();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_HOM_STATUS_SERVICE) {
            setStatusServiceHom(o);
        }
        return (T) o;
    }

    @Override
    public <T> T queryUnclosedHom() {
        if (Objects.nonNull(getQueryUnclosedHom())) {
            return (T) getQueryUnclosedHom();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_UNCLOSED).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_HOM_QUERY_UNCLOSED) {
            setQueryUnclosedHom(o);
        }
        return (T) o;
    }

    @Override
    public <T> T distributionHom() {
        if (Objects.nonNull(getDistributionHom())) {
            return (T) getDistributionHom();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_HOM_DISTRIBUTION) {
            setDistributionHom(o);
        }
        return (T) o;
    }

    @Override
    public <T> T distributionOldHom() {
        if (Objects.nonNull(getDistributionOldHom())) {
            return (T) getDistributionOldHom();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION_OLD).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_HOM_DISTRIBUTION_OLD) {
            setDistributionOldHom(o);
        }
        return (T) o;
    }

    @Override
    public <T> T receptionSyncHom() {
        if (Objects.nonNull(getReceptionSyncHom())) {
            return (T) getReceptionSyncHom();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_HOM_RECEPTION_SYNC) {
            setReceptionSyncHom(o);
        }
        return (T) o;
    }

    @Override
    public <T> T receptionProd() {
        if (Objects.nonNull(getReceptionProd())) {
            return (T) getReceptionProd();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_PROD_RECEPTION) {
            setReceptionProd(o);
        }
        return (T) o;
    }

    @Override
    public <T> T queryReceiptProd() {
        if (Objects.nonNull(getQueryReceiptProd())) {
            return (T) getQueryReceiptProd();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_PROD_QUERY_RECEIPT) {
            setQueryReceiptProd(o);
        }
        return (T) o;
    }

    @Override
    public <T> T eventProd() {
        if (Objects.nonNull(getEventProd())) {
            return (T) getEventProd();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_PROD_EVENT) {
            setEventProd(o);
        }
        return (T) o;
    }

    @Override
    public <T> T querySituationProd() {
        if (Objects.nonNull(getQuerySituationProd())) {
            return (T) getQuerySituationProd();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_PROD_QUERY_SITUATION) {
            setQuerySituationProd(o);
        }
        return (T) o;
    }

    @Override
    public <T> T statusServiceProd() {
        if (Objects.nonNull(getStatusServiceProd())) {
            return (T) getStatusServiceProd();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_PROD_STATUS_SERVICE) {
            setStatusServiceProd(o);
        }
        return (T) o;
    }

    @Override
    public <T> T queryUnclosedProd() {
        if (Objects.nonNull(getQueryUnclosedProd())) {
            return (T) getQueryUnclosedProd();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_UNCLOSED).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_PROD_QUERY_UNCLOSED) {
            setQueryUnclosedProd(o);
        }
        return (T) o;
    }

    @Override
    public <T> T distributionProd() {
        if (Objects.nonNull(getDistributionProd())) {
            return (T) getDistributionProd();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_PROD_DISTRIBUTION) {
            setDistributionProd(o);
        }
        return (T) o;
    }

    @Override
    public <T> T distributionOldProd() {
        if (Objects.nonNull(getDistributionOldProd())) {
            return (T) getDistributionOldProd();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION_OLD).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_PROD_DISTRIBUTION_OLD) {
            setDistributionOldProd(o);
        }
        return (T) o;
    }

    @Override
    public <T> T receptionSyncProd() {
        if (Objects.nonNull(getReceptionSyncProd())) {
            return (T) getReceptionSyncProd();
        }
        Object o = newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build()));
        if (MdfeSoapConfigurationProperties.CACHE_PROD_RECEPTION_SYNC) {
            setReceptionSyncProd(o);
        }
        return (T) o;
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
