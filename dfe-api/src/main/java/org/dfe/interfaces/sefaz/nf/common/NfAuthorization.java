package org.dfe.interfaces.sefaz.nf.common;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;

public interface NfAuthorization {

    /**
     * It takes a SefazRequest object, and returns a pair of objects, one of type TEnviNFe and the other of type
     * TRetEnviNFe
     *
     * @param data The request object.
     * @return A pair of objects, the first one is the request object and the second one is the response object.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TEnviNFe, TRetEnviNFe>> Pair<TEnviNFe, TRetEnviNFe> authorize(T data) throws SecurityException, ValidationException, ProcessException;

}
