package com.softart.dfe.interfaces.sefaz.nf.nfce;

import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.sefaz.port.NfceSoapService;

/**
 * This code is defining a Java interface called `NfceService` that extends two other interfaces: `NfCommonService` and
 * `NfceSubstituteCancel`. This means that any class that implements `NfceService` must also implement all the methods
 * defined in `NfCommonService` and `NfceSubstituteCancel`, in addition to any methods defined in `NfceService` itself. The
 * interface also declares two methods: `getSoapService()` and `withSoapService()`, which any class implementing
 * `NfceService` must provide implementations for.
 */
public interface NfceService extends NfCommonService, NfceSubstituteCancel {


    /**
     * The function returns an instance of the NfceSoapService class.
     *
     * @return an instance of the `NfceSoapService` class that provides a SOAP service.
     */
    NfceSoapService getSoapService();


    /**
     * This function takes a parameter of type NfceSoapService and returns an object of type NfceService.
     *
     * @param soapService The parameter `soapService` is an instance of the `NfceSoapService` class that is being passed as
     *                    an argument to the `withSoapService` method of the `NfceService` class. This method is likely used to set the
     *                    `soapService` instance variable of the `N
     * @return It is not clear what is being returned from this method as the return type is not specified. It could be
     * void or it could return an object of a certain type.
     */
    NfceService withSoapService(NfceSoapService soapService);

}
