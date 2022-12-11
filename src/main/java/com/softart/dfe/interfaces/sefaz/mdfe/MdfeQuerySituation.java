package com.softart.dfe.interfaces.sefaz.mdfe;


import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsSitMDFe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface MdfeQuerySituation {

    <T extends SefazRequest<TConsSitMDFe, TRetConsSitMDFe>> Pair<TConsSitMDFe, TRetConsSitMDFe> querySituation(T data) throws SecurityException, ValidationException, ProcessException;

}
