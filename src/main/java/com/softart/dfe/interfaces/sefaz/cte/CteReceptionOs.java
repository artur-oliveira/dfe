package com.softart.dfe.interfaces.sefaz.cte;


import br.inf.portalfiscal.cte.send.TCTeOS;
import br.inf.portalfiscal.cte.send.TRetCTeOS;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface CteReceptionOs {

    <T extends SefazRequest<TCTeOS, TRetCTeOS>> Pair<TCTeOS, TRetCTeOS> receptionOs(T data) throws SecurityException, ValidationException, ProcessException;

}
