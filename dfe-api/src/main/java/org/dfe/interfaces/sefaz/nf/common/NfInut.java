package org.dfe.interfaces.sefaz.nf.common;

import br.inf.portalfiscal.nfe.send.TInutNFe;
import br.inf.portalfiscal.nfe.send.TRetInutNFe;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;

public interface NfInut {

    /**
     * A function that takes a generic type T that extends SefazRequest and returns a pair of TInutNFe and TRetInutNFe.
     *
     * @param data The request object.
     * @return A pair of objects, the first is the request object and the second is the response object.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TInutNFe, TRetInutNFe>> Pair<TInutNFe, TRetInutNFe> inutilization(T data) throws SecurityException, ValidationException, ProcessException;

}
