package com.softart.dfe.interfaces.sefaz.nf.common;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
import br.inf.portalfiscal.nfe.send.TRetConsReciNFe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface NfReturnAuthorization {

    <T extends SefazRequest<TConsReciNFe, TRetConsReciNFe>> Pair<TConsReciNFe, TRetConsReciNFe> queryReceipt(T data) throws SecurityException, ValidationException, ProcessException;

}
