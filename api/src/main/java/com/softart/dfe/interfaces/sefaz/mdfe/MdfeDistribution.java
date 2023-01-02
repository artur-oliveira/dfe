package com.softart.dfe.interfaces.sefaz.mdfe;


import br.inf.portalfiscal.mdfe.classes.DistDFeInt;
import br.inf.portalfiscal.mdfe.classes.RetDistDFeInt;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;import com.softart.dfe.exceptions.security.SecurityException;


public interface MdfeDistribution {

    /**
     * It takes a SefazRequest object as a parameter, and returns a Pair object containing a DistDFeInt object and a
     * RetDistDFeInt object.
     *
     * @param data The request object.
     * @return A pair of objects, the first is the request object, the second is the response object.
     */
    <T extends SefazRequest<DistDFeInt, RetDistDFeInt>> Pair<DistDFeInt, RetDistDFeInt> distribution(T data) throws SecurityException, ValidationException, ProcessException;

}
