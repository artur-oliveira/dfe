package com.softart.dfe.components.sefaz.port;

import com.softart.dfe.components.sefaz.port.cte.AbstractCteSoapService;
import com.softart.dfe.components.sefaz.port.mdfe.AbstractMdfeSoapService;
import com.softart.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import com.softart.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.port.CteSoapService;
import com.softart.dfe.interfaces.sefaz.port.MdfeSoapService;
import com.softart.dfe.interfaces.sefaz.port.NfceSoapService;
import com.softart.dfe.interfaces.sefaz.port.NfeSoapService;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Getter(AccessLevel.PRIVATE)
public final class SoapServiceProxy {
    private final static Integer DEFAULT_NFE_SERVICE_MAP_CAPACITY = Integer.parseInt(System.getProperty("com.softart.sefaz.port.map.capacity.nfe", "100"));
    private final static Integer DEFAULT_NFCE_SERVICE_MAP_CAPACITY = Integer.parseInt(System.getProperty("com.softart.sefaz.port.map.capacity.nfce", "100"));
    private final static Integer DEFAULT_CTE_SERVICE_MAP_CAPACITY = Integer.parseInt(System.getProperty("com.softart.sefaz.port.map.capacity.cte", "100"));
    private final static Integer DEFAULT_MDFE_SERVICE_MAP_CAPACITY = Integer.parseInt(System.getProperty("com.softart.sefaz.port.map.capacity.mdfe", "100"));
    private final Map<NfConfig, NfeSoapService> nfeServiceMap = new ConcurrentHashMap<>(DEFAULT_NFE_SERVICE_MAP_CAPACITY);
    private final Map<NfConfig, NfceSoapService> nfceServiceMap = new ConcurrentHashMap<>(DEFAULT_NFCE_SERVICE_MAP_CAPACITY);
    private final Map<CteConfig, CteSoapService> cteServiceMap = new ConcurrentHashMap<>(DEFAULT_CTE_SERVICE_MAP_CAPACITY);
    private final Map<MdfeConfig, MdfeSoapService> mdfeServiceMap = new ConcurrentHashMap<>(DEFAULT_MDFE_SERVICE_MAP_CAPACITY);

    private SoapServiceProxy() {
    }

    public static SoapServiceProxy getInstance() {
        return SoapServiceProxyHolder.INSTANCE;
    }

    public synchronized NfeSoapService getNfeService(NfConfig config) {
        NfeSoapService soapService = getInstance().getNfeServiceMap().get(config);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    public synchronized void addNfeService(NfConfig config, AbstractNfeSoapService soapService) {
        getInstance().getNfeServiceMap().put(config, soapService);
    }


    public synchronized NfceSoapService getNfceService(NfConfig config) {
        NfceSoapService soapService = getInstance().getNfceServiceMap().get(config);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    public synchronized void addNfceService(NfConfig config, AbstractNfceSoapService soapService) {
        getInstance().getNfceServiceMap().put(config, soapService);
    }

    public synchronized CteSoapService getCteService(CteConfig config) {
        CteSoapService soapService = getInstance().getCteServiceMap().get(config);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    public synchronized void addCteService(CteConfig config, AbstractCteSoapService soapService) {
        getInstance().getCteServiceMap().put(config, soapService);
    }

    public synchronized MdfeSoapService getMdfeService(MdfeConfig config) {
        MdfeSoapService soapService = getInstance().getMdfeServiceMap().get(config);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    public synchronized void addMdfeService(MdfeConfig config, AbstractMdfeSoapService soapService) {
        getInstance().getMdfeServiceMap().put(config, soapService);
    }

    private final static class SoapServiceProxyHolder {
        private static final SoapServiceProxy INSTANCE = new SoapServiceProxy();
    }
}
