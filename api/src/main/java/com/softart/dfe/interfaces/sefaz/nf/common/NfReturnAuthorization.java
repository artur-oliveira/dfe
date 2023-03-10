package com.softart.dfe.interfaces.sefaz.nf.common;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
import br.inf.portalfiscal.nfe.send.TRetConsReciNFe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface NfReturnAuthorization {

    /**
     * It takes a SefazRequest object, and returns a pair of objects, one of which is a SefazRequest object, and the other
     * is a SefazResponse object
     *
     * @param data The request object.
     * @return A pair of objects, the first one is the request object and the second one is the response object.
     */
    <T extends SefazRequest<TConsReciNFe, TRetConsReciNFe>> Pair<TConsReciNFe, TRetConsReciNFe> queryReceipt(T data) throws SecurityException, ValidationException, ProcessException;

}
