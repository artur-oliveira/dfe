package com.softart.dfe.interfaces.sefaz.cte;


import br.inf.portalfiscal.cte.send.TConsStatServ;
import br.inf.portalfiscal.cte.send.TRetConsStatServ;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface CteStatusService {

    <T extends SefazRequest<TConsStatServ, TRetConsStatServ>> Pair<TConsStatServ, TRetConsStatServ> statusService(T data) throws SecurityException, ValidationException, ProcessException;

}
