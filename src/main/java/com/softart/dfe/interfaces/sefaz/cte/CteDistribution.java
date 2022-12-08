package com.softart.dfe.interfaces.sefaz.cte;


import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface CteDistribution {

    <T extends SefazRequest<DistDFeInt, RetDistDFeInt>> Pair<DistDFeInt, RetDistDFeInt> distribution(T data) throws SecurityException, ValidationException, ProcessException;

}
