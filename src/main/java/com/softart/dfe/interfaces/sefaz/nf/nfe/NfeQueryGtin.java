package com.softart.dfe.interfaces.sefaz.nf.nfe;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface NfeQueryGtin {

    <T extends SefazRequest<TConsGTIN, TRetConsGTIN>> Pair<TConsGTIN, TRetConsGTIN> queryGtin(T data) throws SecurityException, ValidationException, ProcessException;

}
