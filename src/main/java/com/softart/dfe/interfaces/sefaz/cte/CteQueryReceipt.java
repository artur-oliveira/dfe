package com.softart.dfe.interfaces.sefaz.cte;


import br.inf.portalfiscal.cte.send.TConsReciCTe;
import br.inf.portalfiscal.cte.send.TRetConsReciCTe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface CteQueryReceipt {

    <T extends SefazRequest<TConsReciCTe, TRetConsReciCTe>> Pair<TConsReciCTe, TRetConsReciCTe> queryReceipt(T data) throws SecurityException, ValidationException, ProcessException;

}
