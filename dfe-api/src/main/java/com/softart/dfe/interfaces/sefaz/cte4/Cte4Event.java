package com.softart.dfe.interfaces.sefaz.cte4;


import br.inf.portalfiscal.cte.send400.TEvento;
import br.inf.portalfiscal.cte.send400.TRetEvento;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface Cte4Event {

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
