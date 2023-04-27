package com.softart.dfe.interfaces.sefaz.nf.nfe;


import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TRetConsCad;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface NfeQueryRegister {

    <T extends SefazRequest<TConsCad, TRetConsCad>> Pair<TConsCad, TRetConsCad> queryRegister(T data) throws SecurityException, ValidationException, ProcessException;

}
