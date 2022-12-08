package com.softart.dfe.interfaces.sefaz.nf.nfe;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface NfeDistribution {

    <T extends SefazRequest<TDistDFeInt, TRetDistDFeInt>> Pair<TDistDFeInt, TRetDistDFeInt> distribution(T data) throws SecurityException, ValidationException, ProcessException;

}
