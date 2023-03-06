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
    private final static int DEFAULT_NFE_SERVICE_MAP_CAPACITY = Integer.parseInt(System.getProperty("com.softart.dfe.sefaz.port.proxy.map.capacity.nfe", "100"));
    private final static int DEFAULT_NFCE_SERVICE_MAP_CAPACITY = Integer.parseInt(System.getProperty("com.softart.dfe.sefaz.port.proxy.map.capacity.nfce", "100"));
    private final static int DEFAULT_CTE_SERVICE_MAP_CAPACITY = Integer.parseInt(System.getProperty("com.softart.dfe.sefaz.port.proxy.map.capacity.cte", "100"));
    private final static int DEFAULT_MDFE_SERVICE_MAP_CAPACITY = Integer.parseInt(System.getProperty("com.softart.dfe.sefaz.port.proxy.map.capacity.mdfe", "100"));
    private final Map<NfConfig, NfeSoapService> nfeServiceMap = new ConcurrentHashMap<>(DEFAULT_NFE_SERVICE_MAP_CAPACITY);
    private final Map<NfConfig, NfceSoapService> nfceServiceMap = new ConcurrentHashMap<>(DEFAULT_NFCE_SERVICE_MAP_CAPACITY);
    private final Map<CteConfig, CteSoapService> cteServiceMap = new ConcurrentHashMap<>(DEFAULT_CTE_SERVICE_MAP_CAPACITY);
    private final Map<MdfeConfig, MdfeSoapService> mdfeServiceMap = new ConcurrentHashMap<>(DEFAULT_MDFE_SERVICE_MAP_CAPACITY);

    private SoapServiceProxy() {
    }

    /**
     * > The function returns a static instance of the class
     *
     * @return A singleton instance of the SoapServiceProxy class.
     */
    public static SoapServiceProxy getInstance() {
        return SoapServiceProxyHolder.INSTANCE;
    }

    /**
     * > If the service is already in the map, return it. Otherwise, return null
     *
     * @param config NfConfig object
     * @return The NfeSoapService object.
     */
    public synchronized NfeSoapService getNfeService(NfConfig config) {
        NfeSoapService soapService = getInstance().getNfeServiceMap().get(config);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    /**
     * > This function adds a new NfeSoapService to the NfeServiceMap
     *
     * @param config      The configuration object that contains the information about the webservice.
     * @param soapService The SOAP service that will be used to send the XML to the Sefaz.
     */
    public synchronized void addNfeService(NfConfig config, AbstractNfeSoapService soapService) {
        getInstance().getNfeServiceMap().put(config, soapService);
    }


    /**
     * > If the service is already in the map, return it. Otherwise, return null
     *
     * @param config NfConfig object
     * @return A NfceSoapService object.
     */
    public synchronized NfceSoapService getNfceService(NfConfig config) {
        NfceSoapService soapService = getInstance().getNfceServiceMap().get(config);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    /**
     * > This function adds a NFCe service to the list of NFCe services
     *
     * @param config      The configuration object that contains the information about the NFC-e service.
     * @param soapService The SOAP service that will be used to communicate with the webservice.
     */
    public synchronized void addNfceService(NfConfig config, AbstractNfceSoapService soapService) {
        getInstance().getNfceServiceMap().put(config, soapService);
    }

    /**
     * > If the service is already in the map, return it. Otherwise, return null
     *
     * @param config CteConfig object
     * @return A CteSoapService object.
     */
    public synchronized CteSoapService getCteService(CteConfig config) {
        CteSoapService soapService = getInstance().getCteServiceMap().get(config);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    /**
     * > This function adds a CteConfig object and a CteSoapService object to a HashMap
     *
     * @param config      The configuration object for the CteConfig class.
     * @param soapService The SOAP service that will be used to send the CTe.
     */
    public synchronized void addCteService(CteConfig config, AbstractCteSoapService soapService) {
        getInstance().getCteServiceMap().put(config, soapService);
    }

    /**
     * If the service is already in the map, return it. Otherwise, return null
     *
     * @param config MdfeConfig
     * @return A MdfeSoapService object.
     */
    public synchronized MdfeSoapService getMdfeService(MdfeConfig config) {
        MdfeSoapService soapService = getInstance().getMdfeServiceMap().get(config);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    /**
     * > Adds a new MDF-e service to the list of available services
     *
     * @param config      MdfeConfig object
     * @param soapService The SOAP service that will be used to send the MDF-e.
     */
    public synchronized void addMdfeService(MdfeConfig config, AbstractMdfeSoapService soapService) {
        getInstance().getMdfeServiceMap().put(config, soapService);
    }

    private final static class SoapServiceProxyHolder {
        private static final SoapServiceProxy INSTANCE = new SoapServiceProxy();
    }
}
