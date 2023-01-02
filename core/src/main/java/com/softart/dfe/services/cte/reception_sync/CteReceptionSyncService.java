package com.softart.dfe.services.cte.reception_sync;

import br.inf.portalfiscal.cte.send.TCTe;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshaller;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.reception.Cte;
import com.softart.dfe.models.cte.reception_sync.CteReturn;
import com.softart.dfe.models.cte.reception_sync.CteSyncRequest;

public interface CteReceptionSyncService extends CteSefazService {
    /**
     * It receives a Cte object and returns a CteReturn object.
     *
     * @param tcTe The CTe object to be sent.
     * @return A CteReturn object.
     */
    default CteReturn receptionSync(TCTe tcTe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return CteReturn
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getCteService(getConfig())
                        .receptionSync(CteSyncRequest
                                .builder()
                                .config(getConfig())
                                .signer(getXmlSigner())
                                .data(tcTe)
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidatorFactory().cteValidator().receptionCteSyncValidators())
                                .beforeRequest(getProcess().beforeCteSync())
                                .afterRequest(getProcess().afterCteSync())
                                .build()));
    }

    /**
     * It converts the Cte object to a CteObject and then calls the function receptionSync(CteObject cte)
     *
     * @param cte The Cte object to be sent.
     * @return The CteReturn object.
     */
    default CteReturn receptionSync(Cte cte) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionSync(cte.toObject());
    }

    /**
     * It receives a CTe XML, unmarshalls it, and then calls the function that actually does the work
     *
     * @param xml XML string to be sent to the SEFAZ.
     * @return The CteReturn object.
     */
    default CteReturn receptionSync(String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionSync(CteUnmarshaller.receptionCteSync(xml).getValue());
    }
}
