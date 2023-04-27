package com.softart.dfe.interfaces.sefaz.nf.nfe;

import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.sefaz.port.NfeSoapService;

public interface NfeService extends NfCommonService, NfeQueryRegister, NfeManifestation, NfeDistribution, NfeEpec, NfeCorrectionLetter, NfeInterestedActor, NfeQueryGtin {

    /**
     * It returns a NfeSoapService object.
     *
     * @return The SoapService is being returned.
     */
    NfeSoapService getSoapService();

    /**
     * It sets the SOAP service to be used by the NfeService.
     *
     * @param nfeSoapService The NfeSoapService object that will be used to make the requests.
     * @return The NfeService object.
     */
    NfeService withSoapService(NfeSoapService nfeSoapService);

}
