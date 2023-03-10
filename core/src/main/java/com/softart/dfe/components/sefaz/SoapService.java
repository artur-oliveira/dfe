package com.softart.dfe.components.sefaz;

import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.port.CteSoapService;
import com.softart.dfe.interfaces.sefaz.port.MdfeSoapService;
import com.softart.dfe.interfaces.sefaz.port.NfceSoapService;
import com.softart.dfe.interfaces.sefaz.port.NfeSoapService;

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
     * > This function returns a NfeSoapService object, which is a SOAP client that can be used to send and receive
     * messages from the SEFAZ
     *
     * @param config NfConfig object
     * @return The NfeSoapService object.
     */
    public abstract NfeSoapService getNfeSoapService(NfConfig config) throws SoapServiceGeneralException;

    /**
     * > This function returns a NfceSoapService object, which is a SOAP client that can be used to communicate with the
     * webservice
     *
     * @param config The configuration object that contains the information about the webservice.
     * @return The NfceSoapService object.
     */
    public abstract NfceSoapService getNfceSoapService(NfConfig config) throws SoapServiceGeneralException;

    /**
     * > This function returns a CteSoapService object that can be used to make calls to the CteSoapService
     *
     * @param config The configuration object that contains the information needed to connect to the CTE service.
     * @return A CteSoapService object.
     */
    public abstract CteSoapService getCteSoapService(CteConfig config) throws SoapServiceGeneralException;

    /**
     * It returns a MdfeSoapService object, which is a class that implements the MdfeSoapService interface
     *
     * @param config MdfeConfig object
     * @return The MdfeSoapService object.
     */
    public abstract MdfeSoapService getMdfeSoapService(MdfeConfig config) throws SoapServiceGeneralException;

    private static class SoapServiceFactoryHolder {
        static final SoapService SOAP_LOCATOR_IMPL = new DefaultSoapServiceImpl();
    }

}
