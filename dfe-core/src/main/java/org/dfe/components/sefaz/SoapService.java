package org.dfe.components.sefaz;

import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.internal.config.NfConfig;
import org.dfe.interfaces.sefaz.port.Cte4SoapService;
import org.dfe.interfaces.sefaz.port.MdfeSoapService;
import org.dfe.interfaces.sefaz.port.NfceSoapService;
import org.dfe.interfaces.sefaz.port.NfeSoapService;

import java.util.Collection;

public abstract class SoapService {

    /**
     * If the SOAP_LOCATOR_IMPL is null, create a new SoapServiceImpl and assign it to SOAP_LOCATOR_IMPL. Then return
     * SOAP_LOCATOR_IMPL.
     *
     * @return A singleton instance of the SoapService class.
     */
    public static SoapService getInstance() {
        return SoapServiceFactoryHolder.SOAP_LOCATOR_IMPL;
    }

    /**
     * This function returns a NfeSoapService object, which is a SOAP client that can be used to send and receive
     * messages from the SEFAZ
     *
     * @param config NfConfig object
     * @return The NfeSoapService object.
     */
    public abstract NfeSoapService getNfeSoapService(NfConfig config) throws SoapServiceGeneralException;

    /**
     * This function returns a collection of all the NfeSoapService objects that are available for the given NfConfig
     *
     * @param config NfConfig object
     * @return A collection of NfeSoapService
     */
    public abstract Collection<? extends NfeSoapService> getAllNfeSoapService(NfConfig config) throws SoapServiceGeneralException;


    /**
     * This function returns a NfceSoapService object, which is a SOAP client that can be used to communicate with the
     * webservice
     *
     * @param config The configuration object that contains the information about the webservice.
     * @return The NfceSoapService object.
     */
    public abstract NfceSoapService getNfceSoapService(NfConfig config) throws SoapServiceGeneralException;

    /**
     * This function returns a collection of all the NFCe Soap Services that are available for the given configuration
     *
     * @param config The configuration object that contains the information about the connection to the server.
     * @return A collection of NfceSoapService
     */
    public abstract Collection<? extends NfceSoapService> getAllNfceSoapService(NfConfig config) throws SoapServiceGeneralException;

    public abstract Collection<? extends Cte4SoapService> getAllCte4SoapService(CteConfig config) throws SoapServiceGeneralException;

    public abstract Cte4SoapService getCte4SoapService(CteConfig config) throws SoapServiceGeneralException;

    /**
     * It returns a MdfeSoapService object, which is a class that implements the MdfeSoapService interface
     *
     * @param config MdfeConfig object
     * @return The MdfeSoapService object.
     */
    public abstract MdfeSoapService getMdfeSoapService(MdfeConfig config) throws SoapServiceGeneralException;

    /**
     * This function returns a collection of all the MDF-e SOAP services that are available for the given configuration
     *
     * @param config The configuration object that contains the information about the NF-e service.
     * @return A collection of MdfeSoapService
     */
    public abstract Collection<? extends MdfeSoapService> getAllMdfeSoapService(MdfeConfig config) throws SoapServiceGeneralException;


    private static class SoapServiceFactoryHolder {
        static final SoapService SOAP_LOCATOR_IMPL = new DefaultSoapServiceImpl();
    }

}
