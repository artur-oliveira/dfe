package org.dfe.interfaces.sefaz.cte4;


import br.inf.portalfiscal.cte.send400.TGTVe;
import br.inf.portalfiscal.cte.send400.TRetGTVe;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;

public interface Cte4ReceptionGtve {

    /**
     * It receives a SefazRequest object, which is a generic type, and returns a Pair object, which is a generic type.
     *
     * @param data The object that will be sent to the SEFAZ.
     * @return A pair of objects, one of type TGTVe and the other of type TRetGTVe.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TGTVe, TRetGTVe>> Pair<TGTVe, TRetGTVe> receptionGtve(T data) throws SecurityException, ValidationException, ProcessException;

}
