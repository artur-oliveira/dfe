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

/**
 * Declaring a public interface named `DfeService`. This interface defines four methods that return instances of different
 * service classes used to make requests to web services related to electronic documents in Brazil, such as NFe, NFCe, CTe,
 * and MDFe. These methods take configuration objects as parameters and may throw exceptions if no provider is found or if
 * there is a general SOAP service exception.
 */
public interface DfeService {
    /**
     * This function returns an instance of the NfeService class, which is the class that will be used to make the
     * requests to the webservice
     *
     * @param config NfConfig object
     * @return The NfeService object.
     * @throws NoProviderFound             NoProviderFound
     * @throws SoapServiceGeneralException SoapServiceGeneralException
     */
    NfeService getNfeService(NfeConfig config) throws NoProviderFound, SoapServiceGeneralException;

    /**
     * This function returns an instance of the NFCe service
     *
     * @param config The configuration object that contains the information about the provider.
     * @return The NfceService object.
     * @throws NoProviderFound             NoProviderFound
     * @throws SoapServiceGeneralException SoapServiceGeneralException
     */
    NfceService getNfceService(NfceConfig config) throws NoProviderFound, SoapServiceGeneralException;

    /**
     * This function returns a CteService object that can be used to make calls to the CteService web service
     *
     * @param config The configuration object that contains the information needed to connect to the service.
     * @return A CteService object.
     * @throws NoProviderFound             NoProviderFound
     * @throws SoapServiceGeneralException SoapServiceGeneralException
     */
    CteService getCteService(CteConfig config) throws NoProviderFound, SoapServiceGeneralException;

    /**
     * This function returns an instance of the MdfeService class, which is the class that will be used to make the
     * requests to the webservice
     *
     * @param config MdfeConfig object
     * @return An MdfeService object.
     * @throws NoProviderFound             NoProviderFound
     * @throws SoapServiceGeneralException SoapServiceGeneralException
     */
    MdfeService getMdfeService(MdfeConfig config) throws NoProviderFound, SoapServiceGeneralException;
}
