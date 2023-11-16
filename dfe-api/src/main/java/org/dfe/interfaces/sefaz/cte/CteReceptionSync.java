package org.dfe.interfaces.sefaz.cte;


import br.inf.portalfiscal.cte.send.TCTe;
import br.inf.portalfiscal.cte.send.TRetCTe;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;

public interface CteReceptionSync {

    /**
     * It receives a SefazRequest object, which is a generic type that extends the SefazRequest class, and returns a pair
     * of objects, one of which is a TCTe object and the other is a TRetCTe object
     *
     * @param data The request object.
     * @return A pair of objects, the first is the request object, the second is the response object.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TCTe, TRetCTe>> Pair<TCTe, TRetCTe> receptionSync(T data) throws SecurityException, ValidationException, ProcessException;

}
