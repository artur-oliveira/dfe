package com.softart.dfe.interfaces.services;

import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dfe.interfaces.sefaz.cte.CteService;
import com.softart.dfe.interfaces.sefaz.mdfe.MdfeService;
import com.softart.dfe.interfaces.sefaz.nf.nfce.NfceService;
import com.softart.dfe.interfaces.sefaz.nf.nfe.NfeService;

public interface DfeService {
    /**
     * > This function returns an instance of the NfeService class, which is the class that will be used to make the
     * requests to the webservice
     *
     * @param config NfConfig object
     * @return The NfeService object.
     */
    NfeService getNfeService(NfeConfig config) throws NoProviderFound, SoapServiceGeneralException;

    /**
     * > This function returns an instance of the NFCe service
     *
     * @param config The configuration object that contains the information about the provider.
     * @return The NfceService object.
     */
    NfceService getNfceService(NfceConfig config) throws NoProviderFound, SoapServiceGeneralException;

    /**
     * > This function returns a CteService object that can be used to make calls to the CteService web service
     *
     * @param config The configuration object that contains the information needed to connect to the service.
     * @return A CteService object.
     */
    CteService getCteService(CteConfig config) throws NoProviderFound, SoapServiceGeneralException;

    /**
     * > This function returns an instance of the MdfeService class, which is the class that will be used to make the
     * requests to the webservice
     *
     * @param config MdfeConfig object
     * @return An MdfeService object.
     */
    MdfeService getMdfeService(MdfeConfig config) throws NoProviderFound, SoapServiceGeneralException;
}
