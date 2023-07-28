package com.softart.dfe.interfaces.sefaz.cte;


import br.inf.portalfiscal.cte.send.TInutCTe;
import br.inf.portalfiscal.cte.send.TRetInutCTe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface CteInutilization {

    /**
     * It takes a SefazRequest object as a parameter, and returns a pair of objects, one of type TInutCTe and the other of
     * type TRetInutCTe
     *
     * @param data The request object.
     * @return A pair of objects, the first is the request and the second is the response.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TInutCTe, TRetInutCTe>> Pair<TInutCTe, TRetInutCTe> inutilization(T data) throws SecurityException, ValidationException, ProcessException;

}
