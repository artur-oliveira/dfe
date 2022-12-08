package com.softart.dfe.interfaces.sefaz.nf.nfe;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface NfeEpec {

    <T extends SefazRequest<TEnvEvento, TRetEnvEvento>> Pair<TEnvEvento, TRetEnvEvento> epec(T data) throws SecurityException, ValidationException, ProcessException;

}
