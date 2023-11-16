package org.dfe.interfaces.sefaz.cte4;


import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;

public interface CteDistribution {

    /**
     * It takes a SefazRequest object as a parameter, and returns a Pair object containing a DistDFeInt object and a
     * RetDistDFeInt object.
     *
     * @param data The request object.
     * @return A pair of objects, the first is the request object, the second is the response object.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<DistDFeInt, RetDistDFeInt>> Pair<DistDFeInt, RetDistDFeInt> distribution(T data) throws SecurityException, ValidationException, ProcessException;

}
