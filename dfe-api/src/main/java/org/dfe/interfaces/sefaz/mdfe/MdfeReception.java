package org.dfe.interfaces.sefaz.mdfe;


import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetEnviMDFe;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.sefaz.SefazRequest;


public interface MdfeReception {

    /**
     * It receives a SefazRequest object, which is a generic type that extends the SefazRequest class, and returns a pair
     * of objects, one of type TEnviMDFe and the other of type TRetEnviMDFe
     *
     * @param data The request object.
     * @return A pair of objects, one of type TEnviMDFe and the other of type TRetEnviMDFe.
     * @throws SecurityException   SecurityException
     * @throws ValidationException ValidationException
     * @throws ProcessException    ProcessException
     */
    <T extends SefazRequest<TEnviMDFe, TRetEnviMDFe>> Pair<TEnviMDFe, TRetEnviMDFe> reception(T data) throws SecurityException, ValidationException, ProcessException;

}
