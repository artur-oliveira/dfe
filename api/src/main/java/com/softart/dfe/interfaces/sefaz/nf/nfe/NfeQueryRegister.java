package com.softart.dfe.interfaces.sefaz.nf.nfe;


import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TRetConsCad;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface NfeQueryRegister {

    /**
     * This function queries a register using a SefazRequest object and returns a Pair object containing TConsCad and
     * TRetConsCad.
     *
     * @param data The parameter "data" is of type T, which is a generic type that extends the SefazRequest interface with
     *             two type parameters: TConsCad and TRetConsCad. This means that "data" must be an object that implements the
     *             SefazRequest interface and specifies the types T
     * @return The method is returning a Pair object containing two generic types TConsCad and TRetConsCad, which are
     * defined by the input parameter T extending SefazRequest<TConsCad, TRetConsCad>. The method is also throwing three
     * exceptions: SecurityException, ValidationException, and ProcessException.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TConsCad, TRetConsCad>> Pair<TConsCad, TRetConsCad> queryRegister(T data) throws SecurityException, ValidationException, ProcessException;

}
