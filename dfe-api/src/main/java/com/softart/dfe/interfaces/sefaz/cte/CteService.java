package com.softart.dfe.interfaces.sefaz.cte;

import com.softart.dfe.interfaces.internal.allow.CteServiceAllow;
import com.softart.dfe.interfaces.sefaz.port.CteSoapService;

/**
 * This line of code is defining a Java interface named `CteService` that extends multiple other interfaces
 * (`CteDistribution`, `CteServiceAllow`, `CteEvent`, `CteInutilization`, `CteQuerySituation`, `CteReception`,
 * `CteReceptionGtve`, `CteReceptionOs`, `CteReceptionSync`, `CteQueryReceipt`, `CteStatusService`). By extending these
 * interfaces, `CteService` inherits their methods and can be used to implement functionality related to electronic
 * transportation documents (CT-e - Conhecimento de Transporte Eletrônico). The interface also includes two methods:
 * `getSoapService()` and `withSoapService(CteSoapService nfeSoapService)`, which are used to obtain and set a SOAP web
 * service client for communication with a CT-e web service.
 */
public interface CteService extends CteDistribution, CteServiceAllow, CteEvent, CteInutilization, CteQuerySituation, CteReception, CteReceptionGtve, CteReceptionOs, CteReceptionSync, CteQueryReceipt, CteStatusService {

    /**
     * The function returns a CteSoapService object.
     *
     * @return an instance of the CteSoapService class, which is likely a SOAP web service client that can be used to
     * communicate with a SOAP web service.
     */
    CteSoapService getSoapService();

    /**
     * This function takes a CteSoapService object and returns a CteService object with the SOAP service set.
     *
     * @param nfeSoapService nfeSoapService is an object of type CteSoapService that is being passed as a parameter to the
     *                       method withSoapService. It is likely that the method is using the nfeSoapService object to perform some operations
     *                       related to Cte (Conhecimento de Transporte Eletrônico
     * @return It is not specified what is being returned by this method. It seems to be a method that takes a parameter of
     * type CteSoapService and returns an object of type CteService, but without more information it is impossible to
     * determine what the method is actually doing and what it is returning.
     */
    CteService withSoapService(CteSoapService nfeSoapService);

}
