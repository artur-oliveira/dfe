package com.softart.dfe.interfaces.sefaz.mdfe;


import br.inf.portalfiscal.mdfe.classes.TMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetMDFe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface MdfeReceptionSync {

    <T extends SefazRequest<TMDFe, TRetMDFe>> Pair<TMDFe, TRetMDFe> receptionSync(T data) throws SecurityException, ValidationException, ProcessException;

}
