package com.softart.dfe.interfaces.sefaz.cte4;


import br.inf.portalfiscal.cte.send400.TConsSitCTe;
import br.inf.portalfiscal.cte.send400.TRetConsSitCTe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface Cte4QuerySituation {

    /**
     * It takes a SefazRequest object as a parameter, and returns a pair of objects, one of which is a SefazRequest object,
     * and the other is a SefazResponse object
     *
     * @param data The request object.
     * @return A pair of objects, the first is the request object and the second is the response object.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TConsSitCTe, TRetConsSitCTe>> Pair<TConsSitCTe, TRetConsSitCTe> querySituation(T data) throws SecurityException, ValidationException, ProcessException;

}
