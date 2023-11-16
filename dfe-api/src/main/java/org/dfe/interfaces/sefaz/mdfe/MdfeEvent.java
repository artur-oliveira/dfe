package org.dfe.interfaces.sefaz.mdfe;


import br.inf.portalfiscal.mdfe.classes.TEvento;
import br.inf.portalfiscal.mdfe.classes.TRetEvento;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;


public interface MdfeEvent {

    /**
     * A generic function that takes a SefazRequest object and returns a pair of objects.
     *
     * @param data The request object.
     * @return A pair of objects.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TEvento, TRetEvento>> Pair<TEvento, TRetEvento> event(T data) throws SecurityException, ValidationException, ProcessException;

}
