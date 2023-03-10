package com.softart.dfe.interfaces.sefaz.nf.nfe;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface NfeDistribution {

    /**
     * It takes a SefazRequest object as input, and returns a Pair object containing a TDistDFeInt object and a
     * TRetDistDFeInt object
     *
     * @param data The request object.
     * @return A pair of objects.
     */
    <T extends SefazRequest<TDistDFeInt, TRetDistDFeInt>> Pair<TDistDFeInt, TRetDistDFeInt> distribution(T data) throws SecurityException, ValidationException, ProcessException;

}
