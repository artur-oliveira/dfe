package com.softart.dfe.interfaces.sefaz.mdfe;


import br.inf.portalfiscal.mdfe.classes.TDistDFe;
import br.inf.portalfiscal.mdfe.classes.TRetDistDFe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;


public interface MdfeDistribution {


    /**
     * It takes a SefazRequest object as a parameter, and returns a Pair object containing a TDistDFe object and a
     * TDistDFe object.
     *
     * @param data The request object.
     * @return A pair of objects, the first is the request object, the second is the response object.
     */
    <T extends SefazRequest<TDistDFe, TRetDistDFe>> Pair<TDistDFe, TRetDistDFe> distribution(T data) throws SecurityException, ValidationException, ProcessException;
}
