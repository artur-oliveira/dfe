package org.dfe.interfaces.sefaz.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsStatServ;
import br.inf.portalfiscal.mdfe.classes.TRetConsStatServ;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;

public interface MdfeStatusService {
    /**
     * It takes a SefazRequest object as a parameter, and returns a Pair object containing the request and response objects
     *
     * @param data The request object.
     * @return A pair of objects, the first is the request object and the second is the response object.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TConsStatServ, TRetConsStatServ>> Pair<TConsStatServ, TRetConsStatServ> statusService(T data) throws SecurityException, ValidationException, ProcessException;

}
