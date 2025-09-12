package org.dfe.interfaces.sefaz.nf.nfe;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.sefaz.nf.common.NfCommonService;
import org.dfe.interfaces.sefaz.port.NfeSoapService;

/**
 * This code is defining a Java interface called `NfeService` that extends several other interfaces (`NfCommonService`,
 * `NfeQueryRegister`, `NfeManifestation`, `NfeDistribution`, `NfeEpec`, `NfeCorrectionLetter`, `NfeInterestedActor`,
 * `NfeQueryGtin`). This means that any class that implements `NfeService` must also implement all the methods defined in
 * those other interfaces. Additionally, the interface defines two methods: `getSoapService()` and
 * `withSoapService(NfeSoapService nfeSoapService)`.
 */
public interface NfeService extends NfCommonService, NfeQueryRegister, NfeDistribution, NfeQueryGtin {

    <T extends SefazRequest<TEnvEvento, TRetEnvEvento>> Pair<TEnvEvento, TRetEnvEvento> eventAN(T data) throws SecurityException, ValidationException, ProcessException;

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
