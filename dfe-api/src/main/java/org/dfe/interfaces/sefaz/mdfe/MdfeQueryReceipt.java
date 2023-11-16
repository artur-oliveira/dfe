package org.dfe.interfaces.sefaz.mdfe;


import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsReciMDFe;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;


public interface MdfeQueryReceipt {

    /**
     * It takes a SefazRequest object as input, and returns a pair of objects, one of which is a SefazRequest object, and
     * the other is a SefazResponse object
     *
     * @param data The request object.
     * @return A pair of objects, the first is the request object, the second is the response object.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TConsReciMDFe, TRetConsReciMDFe>> Pair<TConsReciMDFe, TRetConsReciMDFe> queryReceipt(T data) throws SecurityException, ValidationException, ProcessException;

}
