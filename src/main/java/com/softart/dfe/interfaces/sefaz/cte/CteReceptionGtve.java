package com.softart.dfe.interfaces.sefaz.cte;


import br.inf.portalfiscal.cte.send.TGTVe;
import br.inf.portalfiscal.cte.send.TRetGTVe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface CteReceptionGtve {

    <T extends SefazRequest<TGTVe, TRetGTVe>> Pair<TGTVe, TRetGTVe> receptionGtve(T data) throws SecurityException, ValidationException, ProcessException;

}
