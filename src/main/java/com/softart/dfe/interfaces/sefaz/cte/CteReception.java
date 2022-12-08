package com.softart.dfe.interfaces.sefaz.cte;


import br.inf.portalfiscal.cte.send.TEnviCTe;
import br.inf.portalfiscal.cte.send.TRetEnviCTe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface CteReception {

    <T extends SefazRequest<TEnviCTe, TRetEnviCTe>> Pair<TEnviCTe, TRetEnviCTe> reception(T data) throws SecurityException, ValidationException, ProcessException;

}
