package com.softart.dfe.interfaces.sefaz.nf.nfce;

import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.sefaz.port.NfceSoapService;

public interface NfceService extends NfCommonService, NfceSubstituteCancel {

    /**
     * It returns a NfceSoapService object.
     *
     * @return The SoapService is being returned.
     */
    NfceSoapService getSoapService();

    /**
     * It sets the soap service.
     *
     * @param soapService The SOAP service that will be used to communicate with the webservice.
     * @return The NfceService object.
     */
    NfceService withSoapService(NfceSoapService soapService);

}
