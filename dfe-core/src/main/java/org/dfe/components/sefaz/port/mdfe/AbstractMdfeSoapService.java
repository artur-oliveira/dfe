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
        setReceptionHom(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getReceptionHom();
    }

    @Override
    public <T> T queryReceiptHom() {
        if (Objects.nonNull(getQueryReceiptHom())) {
            return (T) getQueryReceiptHom();
        }
        setQueryReceiptHom(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getQueryReceiptHom();
    }

    @Override
    public <T> T eventHom() {
        if (Objects.nonNull(getEventHom())) {
            return (T) getEventHom();
        }
        setEventHom(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getEventHom();
    }

    @Override
    public <T> T querySituationHom() {
        if (Objects.nonNull(getQuerySituationHom())) {
            return (T) getQuerySituationHom();
        }
        setQuerySituationHom(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getQuerySituationHom();
    }

    @Override
    public <T> T statusServiceHom() {
        if (Objects.nonNull(getStatusServiceHom())) {
            return (T) getStatusServiceHom();
        }
        setStatusServiceHom(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getStatusServiceHom();
    }

    @Override
    public <T> T queryUnclosedHom() {
        if (Objects.nonNull(getQueryUnclosedHom())) {
            return (T) getQueryUnclosedHom();
        }
        setQueryUnclosedHom(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_UNCLOSED).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getQueryUnclosedHom();
    }

    @Override
    public <T> T distributionHom() {
        if (Objects.nonNull(getDistributionHom())) {
            return (T) getDistributionHom();
        }
        setDistributionHom(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getDistributionHom();
    }

    @Override
    public <T> T distributionOldHom() {
        if (Objects.nonNull(getDistributionOldHom())) {
            return (T) getDistributionOldHom();
        }
        setDistributionOldHom(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION_OLD).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getDistributionOldHom();
    }

    @Override
    public <T> T receptionSyncHom() {
        if (Objects.nonNull(getReceptionSyncHom())) {
            return (T) getReceptionSyncHom();
        }
        setReceptionSyncHom(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.HOMOLOGATION).build())));
        return (T) getReceptionSyncHom();
    }

    @Override
    public <T> T receptionProd() {
        if (Objects.nonNull(getReceptionProd())) {
            return (T) getReceptionProd();
        }
        setReceptionProd(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getReceptionProd();
    }

    @Override
    public <T> T queryReceiptProd() {
        if (Objects.nonNull(getQueryReceiptProd())) {
            return (T) getQueryReceiptProd();
        }
        setQueryReceiptProd(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_RECEIPT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getQueryReceiptProd();
    }

    @Override
    public <T> T eventProd() {
        if (Objects.nonNull(getEventProd())) {
            return (T) getEventProd();
        }
        setEventProd(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.EVENT).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getEventProd();
    }

    @Override
    public <T> T querySituationProd() {
        if (Objects.nonNull(getQuerySituationProd())) {
            return (T) getQuerySituationProd();
        }
        setQuerySituationProd(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_SITUATION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getQuerySituationProd();
    }

    @Override
    public <T> T statusServiceProd() {
        if (Objects.nonNull(getStatusServiceProd())) {
            return (T) getStatusServiceProd();
        }
        setStatusServiceProd(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.STATUS_SERVICE).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getStatusServiceProd();
    }

    @Override
    public <T> T queryUnclosedProd() {
        if (Objects.nonNull(getQueryUnclosedProd())) {
            return (T) getQueryUnclosedProd();
        }
        setQueryUnclosedProd(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.QUERY_UNCLOSED).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getQueryUnclosedProd();
    }

    @Override
    public <T> T distributionProd() {
        if (Objects.nonNull(getDistributionProd())) {
            return (T) getDistributionProd();
        }
        setDistributionProd(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getDistributionProd();
    }

    @Override
    public <T> T distributionOldProd() {
        if (Objects.nonNull(getDistributionOldProd())) {
            return (T) getDistributionOldProd();
        }
        setDistributionOldProd(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.DISTRIBUTION_OLD).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
        return (T) getDistributionOldProd();
    }

    @Override
    public <T> T receptionSyncProd() {
        if (Objects.nonNull(getReceptionSyncProd())) {
            return (T) getReceptionSyncProd();
        }
        setReceptionSyncProd(newServiceInstance(SoapServiceMapping.getInstance().getMdfeServiceClassFor(MdfeServiceFinder.builder().endpoint(MdfePathEndpoint.RECEPTION_SYNC).authorizer(getAuthorizer()).environment(Environment.PRODUCTION).build())));
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
