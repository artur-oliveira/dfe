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
import lombok.EqualsAndHashCode;

import javax.net.ssl.HttpsURLConnection;

@EqualsAndHashCode(callSuper = true)
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

        SoapServiceProxy.getInstance().addMdfeService(getConfig(), this);

        this.initialized = true;
    }

    @Override
    public <T> T receptionHom() {
        return (T) this.receptionHom;
    }

    @Override
    public <T> T queryReceiptHom() {
        return (T) this.queryReceiptHom;
    }

    @Override
    public <T> T eventHom() {
        return (T) this.eventHom;
    }

    @Override
    public <T> T querySituationHom() {
        return (T) this.querySituationHom;
    }

    @Override
    public <T> T statusServiceHom() {
        return (T) this.statusServiceHom;
    }

    @Override
    public <T> T queryUnclosedHom() {
        return (T) this.queryUnclosedHom;
    }

    @Override
    public <T> T distributionHom() {
        return (T) this.distributionHom;
    }

    @Override
    public <T> T receptionSyncHom() {
        return (T) this.receptionSyncHom;
    }

    @Override
    public <T> T receptionProd() {
        return (T) this.receptionProd;
    }

    @Override
    public <T> T queryReceiptProd() {
        return (T) this.queryReceiptProd;
    }

    @Override
    public <T> T eventProd() {
        return (T) this.eventProd;
    }

    @Override
    public <T> T querySituationProd() {
        return (T) this.querySituationProd;
    }

    @Override
    public <T> T statusServiceProd() {
        return (T) this.statusServiceProd;
    }

    @Override
    public <T> T queryUnclosedProd() {
        return (T) this.queryUnclosedProd;
    }

    @Override
    public <T> T distributionProd() {
        return (T) this.distributionProd;
    }

    @Override
    public <T> T receptionSyncProd() {
        return (T) this.receptionSyncProd;
    }

    public abstract MdfeAuthorizer getAuthorizer();
}
