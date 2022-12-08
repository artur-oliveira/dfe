package com.softart.dfe.interfaces.sefaz.cte;


import br.inf.portalfiscal.cte.send.TEvento;
import br.inf.portalfiscal.cte.send.TRetEvento;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface CteEvent {

    <T extends SefazRequest<TEvento, TRetEvento>> Pair<TEvento, TRetEvento> event(T data) throws SecurityException, ValidationException, ProcessException;

}
