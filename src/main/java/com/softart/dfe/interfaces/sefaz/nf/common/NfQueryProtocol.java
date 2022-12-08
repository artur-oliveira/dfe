package com.softart.dfe.interfaces.sefaz.nf.common;

import br.inf.portalfiscal.nfe.send.TConsSitNFe;
import br.inf.portalfiscal.nfe.send.TRetConsSitNFe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface NfQueryProtocol {

    <T extends SefazRequest<TConsSitNFe, TRetConsSitNFe>> Pair<TConsSitNFe, TRetConsSitNFe> queryProtocol(T data) throws SecurityException, ValidationException, ProcessException;

}
