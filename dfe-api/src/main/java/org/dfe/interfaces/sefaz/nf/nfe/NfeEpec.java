package org.dfe.interfaces.sefaz.nf.nfe;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;

public interface NfeEpec {

    /**
     * A function that takes a generic type T that extends SefazRequest and returns a pair of TEnvEvento and TRetEnvEvento.
     *
     * @param data The request object.
     * @return Pair<TEnvEvento, TRetEnvEvento>
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TEnvEvento, TRetEnvEvento>> Pair<TEnvEvento, TRetEnvEvento> epec(T data) throws SecurityException, ValidationException, ProcessException;

}
