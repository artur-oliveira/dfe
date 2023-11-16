package org.dfe.interfaces.sefaz.mdfe;

import org.dfe.interfaces.internal.allow.MdfeServiceAllow;
import org.dfe.interfaces.sefaz.port.MdfeSoapService;

/**
 * This line of code is defining a Java interface named `MdfeService` that extends multiple other interfaces
 * (`MdfeServiceAllow`, `MdfeDistribution`, `MdfeEvent`, `MdfeQueryReceipt`, `MdfeQuerySituation`, `MdfeQueryUnclosed`,
 * `MdfeReception`, `MdfeReceptionSync`, `MdfeStatusService`). By extending these interfaces, `MdfeService` inherits their
 * methods and can be used to interact with a MDF-e (Manifesto Eletrônico de Documentos Fiscais) system.
 */
public interface MdfeService extends MdfeServiceAllow, MdfeDistribution, MdfeEvent, MdfeQueryReceipt, MdfeQuerySituation, MdfeQueryUnclosed, MdfeReception, MdfeReceptionSync, MdfeStatusService {

    /**
     * The function returns an instance of the MdfeSoapService class.
     *
     * @return an instance of the MdfeSoapService class, which is likely a SOAP web service client that can be used to
     * communicate with a MDF-e (Manifesto Eletrônico de Documentos Fiscais) system.
     */
    MdfeSoapService getSoapService();

    /**
     * The function `withSoapService` takes a `MdfeSoapService` object and returns a `MdfeService` object.
     *
     * @param soapService The `soapService` parameter is an instance of a class that implements the `MdfeSoapService`
     *                    interface. This interface defines the methods that are used to interact with a SOAP web service for the MDF-e
     *                    (Manifesto Eletrônico de Documentos Fiscais) protocol in
     * @return It is not returning anything, it is a method that takes an argument of type `MdfeSoapService` and returns an
     * instance of `MdfeService`.
     */
    MdfeService withSoapService(MdfeSoapService soapService);

}
