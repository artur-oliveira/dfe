package org.dfe.interfaces.sefaz.mdfe;


import br.inf.portalfiscal.mdfe.classes.TDistDFe;
import br.inf.portalfiscal.mdfe.classes.TRetDistDFe;
import br.inf.portalfiscal.mdfe.distribution.DistDFeInt;
import br.inf.portalfiscal.mdfe.distribution.RetDistDFeInt;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;


public interface MdfeDistribution {


    /**
     * It takes a SefazRequest object as a parameter, and returns a Pair object containing a TDistDFe object and a
     * TDistDFe object.
     *
     * @param data The request object.
     * @return A pair of objects, the first is the request object, the second is the response object.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TDistDFe, TRetDistDFe>> Pair<TDistDFe, TRetDistDFe> distribution(T data) throws SecurityException, ValidationException, ProcessException;

    <T extends SefazRequest<DistDFeInt, RetDistDFeInt>> Pair<DistDFeInt, RetDistDFeInt> distributionOld(T data) throws SecurityException, ValidationException, ProcessException;
}
