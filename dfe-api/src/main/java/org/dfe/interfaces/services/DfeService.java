package org.dfe.interfaces.services;

import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.internal.config.NfceConfig;
import org.dfe.interfaces.internal.config.NfeConfig;
import org.dfe.interfaces.sefaz.cte.CteService;
import org.dfe.interfaces.sefaz.cte4.Cte4Service;
import org.dfe.interfaces.sefaz.mdfe.MdfeService;
import org.dfe.interfaces.sefaz.nf.nfce.NfceService;
import org.dfe.interfaces.sefaz.nf.nfe.NfeService;

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

    Cte4Service getCte4Service(CteConfig config) throws NoProviderFound, SoapServiceGeneralException;

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
