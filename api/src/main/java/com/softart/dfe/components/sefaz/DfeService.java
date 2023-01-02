package com.softart.dfe.components.sefaz;

import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.cte.CteService;
import com.softart.dfe.interfaces.sefaz.mdfe.MdfeService;
import com.softart.dfe.interfaces.sefaz.nf.nfce.NfceService;
import com.softart.dfe.interfaces.sefaz.nf.nfe.NfeService;

public abstract class DfeService {

    /**
     * If the DfeFactoryHolder class has not been loaded, load it. If the DfeFactoryHolder class has been loaded, but the
     * DFE_LOCATOR_IMPL field has not been initialized, initialize it. If the DFE_LOCATOR_IMPL field has been initialized,
     * return it.
     *
     * @return The DfeFactoryHolder.DFE_LOCATOR_IMPL is being returned.
     */
    public static DfeService getInstance() {
        return DfeFactoryHolder.DFE_LOCATOR_IMPL;
    }

    /**
     * > This function returns an instance of the NfeService class, which is the class that will be used to make the
     * requests to the webservice
     *
     * @param config NfConfig object
     * @return The NfeService object.
     */
    public abstract NfeService getNfeService(NfConfig config) throws NoProviderFound, SoapServiceGeneralException;

    /**
     * > This function returns an instance of the NFCe service
     *
     * @param config The configuration object that contains the information about the provider.
     * @return The NfceService object.
     */
    public abstract NfceService getNfceService(NfConfig config) throws NoProviderFound, SoapServiceGeneralException;

    /**
     * > This function returns a CteService object that can be used to make calls to the CteService web service
     *
     * @param config The configuration object that contains the information needed to connect to the service.
     * @return A CteService object.
     */
    public abstract CteService getCteService(CteConfig config) throws NoProviderFound, SoapServiceGeneralException;

    /**
     * > This function returns an instance of the MdfeService class, which is the class that will be used to make the
     * requests to the webservice
     *
     * @param config MdfeConfig object
     * @return An MdfeService object.
     */
    public abstract MdfeService getMdfeService(MdfeConfig config) throws NoProviderFound, SoapServiceGeneralException;

    private static class DfeFactoryHolder {
        static final DfeService DFE_LOCATOR_IMPL = new DefaultDfeServiceImpl();
    }

}
