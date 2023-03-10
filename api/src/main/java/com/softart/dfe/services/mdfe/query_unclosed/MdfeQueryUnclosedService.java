package com.softart.dfe.services.mdfe.query_unclosed;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.MdfeSefazService;
import com.softart.dfe.models.mdfe.query_unclosed.MdfeQueryUnclosed;
import com.softart.dfe.models.mdfe.query_unclosed.MdfeQueryUnclosedRequest;
import com.softart.dfe.models.mdfe.query_unclosed.MdfeReturnQueryUnclosed;

public interface MdfeQueryUnclosedService extends MdfeSefazService {

    /**
     * It queries the unclosed MDF-e.
     *
     * @param tConsMDFeNaoEnc The object that contains the parameters for the query.
     * @return A MdfeReturnQueryUnclosed object.
     */
    default MdfeReturnQueryUnclosed queryUnclosed(TConsMDFeNaoEnc tConsMDFeNaoEnc) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return MdfeReturnQueryUnclosed
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(getConfig())
                        .queryUnclosed(MdfeQueryUnclosedRequest
                                .builder()
                                .data(tConsMDFeNaoEnc)
                                .config(getConfig())
                                .signer(getXmlSigner())
                                .validators(getValidatorFactory().mdfeValidator().queryUnclosedValidators())
                                .afterRequest(getProcess().afterQueryUnclosed())
                                .beforeRequest(getProcess().beforeQueryUnclosed())
                                .configureProvider(getConfigureProviderFactory())
                                .build()));
    }

    /**
     * It queries the unclosed MDF-e's
     *
     * @param queryUnclosed The queryUnclosed object.
     * @return The return is a MdfeReturnQueryUnclosed object.
     */
    default MdfeReturnQueryUnclosed queryUnclosed(MdfeQueryUnclosed queryUnclosed) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryUnclosed(queryUnclosed.toObject());
    }

    /**
     * It queries the MDF-e's that are not closed
     *
     * @return The return is a MdfeReturnQueryUnclosed object.
     */
    default MdfeReturnQueryUnclosed queryUnclosed() throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryUnclosed(MdfeQueryUnclosed.build(getConfig()));
    }

}
