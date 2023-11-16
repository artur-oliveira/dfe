package org.dfe.interfaces.sefaz.nf.nfe;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;

public interface NfeDistribution {

    /**
     * It takes a SefazRequest object as input, and returns a Pair object containing a TDistDFeInt object and a
     * TRetDistDFeInt object
     *
     * @param data The request object.
     * @return A pair of objects.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TDistDFeInt, TRetDistDFeInt>> Pair<TDistDFeInt, TRetDistDFeInt> distribution(T data) throws SecurityException, ValidationException, ProcessException;

}
