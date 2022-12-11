package com.softart.dfe.interfaces.sefaz.mdfe;


import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.classes.TRetConsMDFeNaoEnc;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface MdfeQueryUnclosed {

    <T extends SefazRequest<TConsMDFeNaoEnc, TRetConsMDFeNaoEnc>> Pair<TConsMDFeNaoEnc, TRetConsMDFeNaoEnc> queryUnclosed(T data) throws SecurityException, ValidationException, ProcessException;

}
