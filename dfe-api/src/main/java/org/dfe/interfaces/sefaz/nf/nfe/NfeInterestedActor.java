package org.dfe.interfaces.sefaz.nf.nfe;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;

public interface NfeInterestedActor {

    /**
     * It takes a SefazRequest object, and returns a Pair of TEnvEvento and TRetEnvEvento objects
     *
     * @param data The request object that will be sent to the Sefaz.
     * @return Pair<TEnvEvento, TRetEnvEvento>
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TEnvEvento, TRetEnvEvento>> Pair<TEnvEvento, TRetEnvEvento> interestedActor(T data) throws SecurityException, ValidationException, ProcessException;

}
