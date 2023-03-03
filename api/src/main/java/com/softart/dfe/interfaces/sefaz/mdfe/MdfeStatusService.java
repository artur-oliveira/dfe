package com.softart.dfe.interfaces.sefaz.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsStatServ;
import br.inf.portalfiscal.mdfe.classes.TRetConsStatServ;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface MdfeStatusService {
    /**
     * It takes a SefazRequest object as a parameter, and returns a Pair object containing the request and response objects
     *
     * @param data The request object.
     * @return A pair of objects, the first is the request object and the second is the response object.
     */
    <T extends SefazRequest<TConsStatServ, TRetConsStatServ>> Pair<TConsStatServ, TRetConsStatServ> statusService(T data) throws SecurityException, ValidationException, ProcessException;

}
