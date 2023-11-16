package org.dfe.interfaces.sefaz.nf.nfe;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;

public interface NfeManifestation {

    /**
     * It takes a SefazRequest object, and returns a Pair of TEnvEvento and TRetEnvEvento objects
     *
     * @param data The object that contains the data to be sent to the Sefaz.
     * @return Pair<TEnvEvento, TRetEnvEvento>
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TEnvEvento, TRetEnvEvento>> Pair<TEnvEvento, TRetEnvEvento> manifestation(T data) throws SecurityException, ValidationException, ProcessException;


}
