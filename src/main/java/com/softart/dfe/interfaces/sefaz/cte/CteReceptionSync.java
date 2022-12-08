package com.softart.dfe.interfaces.sefaz.cte;


import br.inf.portalfiscal.cte.send.TCTe;
import br.inf.portalfiscal.cte.send.TRetCTe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface CteReceptionSync {

    <T extends SefazRequest<TCTe, TRetCTe>> Pair<TCTe, TRetCTe> receptionSync(T data) throws SecurityException, ValidationException, ProcessException;

}
