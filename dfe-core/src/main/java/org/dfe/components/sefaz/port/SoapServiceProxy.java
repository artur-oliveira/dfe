package org.dfe.components.sefaz.port;

import org.dfe.components.sefaz.port.cte.AbstractCteSoapService;
import org.dfe.components.sefaz.port.cte4.AbstractCte4SoapService;
import org.dfe.components.sefaz.port.mdfe.AbstractMdfeSoapService;
import org.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import org.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import org.dfe.enums.internal.cte.Cte4Authorizer;
import org.dfe.enums.internal.cte.CteAuthorizer;
import org.dfe.enums.internal.mdfe.MdfeAuthorizer;
import org.dfe.enums.internal.nf.NfceAuthorizer;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.interfaces.sefaz.port.*;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Getter(AccessLevel.PRIVATE)
public final class SoapServiceProxy {
    private final static int DEFAULT_NFE_SERVICE_MAP_CAPACITY = Integer.parseInt(System.getProperty("org.dfe.sefaz.port.proxy.map.capacity.nfe", "100"));
    private final static int DEFAULT_NFCE_SERVICE_MAP_CAPACITY = Integer.parseInt(System.getProperty("org.dfe.sefaz.port.proxy.map.capacity.nfce", "100"));
    private final static int DEFAULT_CTE_SERVICE_MAP_CAPACITY = Integer.parseInt(System.getProperty("org.dfe.sefaz.port.proxy.map.capacity.cte", "100"));
    private final static int DEFAULT_MDFE_SERVICE_MAP_CAPACITY = Integer.parseInt(System.getProperty("org.dfe.sefaz.port.proxy.map.capacity.mdfe", "100"));
    private final Map<NfeAuthorizer, NfeSoapService> nfeServiceMap = new ConcurrentHashMap<>(DEFAULT_NFE_SERVICE_MAP_CAPACITY);
    private final Map<NfceAuthorizer, NfceSoapService> nfceServiceMap = new ConcurrentHashMap<>(DEFAULT_NFCE_SERVICE_MAP_CAPACITY);
    private final Map<CteAuthorizer, CteSoapService> cteServiceMap = new ConcurrentHashMap<>(DEFAULT_CTE_SERVICE_MAP_CAPACITY);
    private final Map<Cte4Authorizer, Cte4SoapService> cte4ServiceMap = new ConcurrentHashMap<>(DEFAULT_CTE_SERVICE_MAP_CAPACITY);
    private final Map<MdfeAuthorizer, MdfeSoapService> mdfeServiceMap = new ConcurrentHashMap<>(DEFAULT_MDFE_SERVICE_MAP_CAPACITY);

    private SoapServiceProxy() {
    }

    /**
     * The function returns a static instance of the class
     *
     * @return A singleton instance of the SoapServiceProxy class.
     */
    public static SoapServiceProxy getInstance() {
        return SoapServiceProxyHolder.INSTANCE;
    }

    /**
     * If the authorizer is not null, then return the soapService
     *
     * @param authorizer NfeAuthorizer object
     * @return A NfeSoapService object.
     */
    public synchronized NfeSoapService getNfeService(NfeAuthorizer authorizer) {
        NfeSoapService soapService = getInstance().getNfeServiceMap().get(authorizer);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    /**
     * This function adds a new NfeSoapService to the NfeServiceMap
     *
     * @param soapService The SOAP service that will be added to the map.
     */
    public synchronized void addNfeService(AbstractNfeSoapService soapService) {
        getInstance().getNfeServiceMap().put(soapService.getAuthorizer(), soapService);
    }


    /**
     * If the authorizer is not null, then return the soapService
     *
     * @param authorizer The authorizer object that contains the access token and the URL of the webservice.
     * @return A NfceSoapService object.
     */
    public synchronized NfceSoapService getNfceService(NfceAuthorizer authorizer) {
        NfceSoapService soapService = getInstance().getNfceServiceMap().get(authorizer);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    /**
     * This function adds a new NFCe service to the list of services that are available to the application
     *
     * @param soapService The SOAP service that will be added to the list of services.
     */
    public synchronized void addNfceService(AbstractNfceSoapService soapService) {
        getInstance().getNfceServiceMap().put(soapService.getAuthorizer(), soapService);
    }

    /**
     * If the authorizer is already in the map, return the soap service. Otherwise, return null
     *
     * @param authorizer The authorizer object that contains the credentials to access the CteSoapService.
     * @return A CteSoapService object.
     */
    public synchronized CteSoapService getCteService(CteAuthorizer authorizer) {
        CteSoapService soapService = getInstance().getCteServiceMap().get(authorizer);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    /**
     * This function adds a new CteSoapService to the CteServiceMap
     *
     * @param soapService The SOAP service to be added to the list of services.
     */
    public synchronized void addCteService(AbstractCteSoapService soapService) {
        getInstance().getCteServiceMap().put(soapService.getAuthorizer(), soapService);
    }

    /**
     * If the authorizer is already in the map, return the soap service. Otherwise, return null
     *
     * @param authorizer The authorizer object that contains the credentials to access the CteSoapService.
     * @return A CteSoapService object.
     */
    public synchronized Cte4SoapService getCte4Service(Cte4Authorizer authorizer) {
        Cte4SoapService soapService = getInstance().getCte4ServiceMap().get(authorizer);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    /**
     * This function adds a new CteSoapService to the CteServiceMap
     *
     * @param soapService The SOAP service to be added to the list of services.
     */
    public synchronized void addCte4Service(AbstractCte4SoapService soapService) {
        getInstance().getCte4ServiceMap().put(soapService.getAuthorizer(), soapService);
    }

    /**
     * If the MdfeSoapService object is not null, return it. Otherwise, return null
     *
     * @param authorizer The authorizer object that contains the credentials to access the webservice.
     * @return A MdfeSoapService object.
     */
    public synchronized MdfeSoapService getMdfeService(MdfeAuthorizer authorizer) {
        MdfeSoapService soapService = getInstance().getMdfeServiceMap().get(authorizer);
        if (Objects.nonNull(soapService)) {
            return soapService;
        }
        return null;
    }

    /**
     * Adds a new MDF-e SOAP service to the list of available services
     *
     * @param soapService The SOAP service that will be added to the list of available services.
     */
    public synchronized void addMdfeService(AbstractMdfeSoapService soapService) {
        getInstance().getMdfeServiceMap().put(soapService.getAuthorizer(), soapService);
    }

    private final static class SoapServiceProxyHolder {
        private static final SoapServiceProxy INSTANCE = new SoapServiceProxy();
    }
}
