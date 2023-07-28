package com.softart.dfe.interfaces.sefaz.mdfe;


import br.inf.portalfiscal.mdfe.classes.TMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetMDFe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

public interface MdfeReceptionSync {

    /**
     * It receives a SefazRequest object, which is a generic type that extends the SefazRequest class, and returns a Pair
     * object, which is a generic type that extends the Pair class
     *
     * @param data The request object.
     * @return A pair of objects, the first is the request object and the second is the response object.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TMDFe, TRetMDFe>> Pair<TMDFe, TRetMDFe> receptionSync(T data) throws SecurityException, ValidationException, ProcessException;

}
