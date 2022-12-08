package com.softart.dfe.interfaces.sefaz.nf.common;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import br.inf.portalfiscal.nfe.send.TRetConsStatServ;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface NfQueryStatusService {

    <T extends SefazRequest<TConsStatServ, TRetConsStatServ>> Pair<TConsStatServ, TRetConsStatServ> queryStatusService(T data) throws SecurityException, ValidationException, ProcessException;

}
