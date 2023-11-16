package org.dfe.interfaces.sefaz.nf.common;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;

public interface NfCancel {

    /**
     * It cancels the event.
     *
     * @param data The request object.
     * @return Pair<TEnvEvento, TRetEnvEvento>
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TEnvEvento, TRetEnvEvento>> Pair<TEnvEvento, TRetEnvEvento> cancel(T data) throws SecurityException, ValidationException, ProcessException;

}
