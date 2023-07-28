package com.softart.dfe.interfaces.sefaz.cte4;


import br.inf.portalfiscal.cte.send400.TCTe;
import br.inf.portalfiscal.cte.send400.TRetCTe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface Cte4ReceptionSync {

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
