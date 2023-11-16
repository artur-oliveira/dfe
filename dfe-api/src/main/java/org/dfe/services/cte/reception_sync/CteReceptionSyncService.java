package org.dfe.services.cte.reception_sync;

import br.inf.portalfiscal.cte.send.TCTe;
import org.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.services.CteSefazService;
import org.dfe.models.cte.reception.Cte;
import org.dfe.models.cte.reception_sync.CteReturn;
import org.dfe.models.cte.reception_sync.CteSyncRequest;

public interface CteReceptionSyncService extends CteSefazService {
    /**
     * It receives a Cte object and returns a CteReturn object.
     *
     * @param tcTe The CTe object to be sent.
     * @return A CteReturn object.
     */
    default CteReturn receptionSync(TCTe tcTe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteConfig config = getConfig()
                .withEnviroment(tcTe.getInfCte().getIde().getTpAmb())
                .withWebServiceUf(tcTe.getInfCte().getIde().getCUF())
                .withEmissionType(tcTe.getInfCte().getIde().getTpEmis());
        return CteReturn
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getCteService(config)
                        .receptionSync(CteSyncRequest
                                .builder()
                                .config(config)
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
        return receptionSync(CteUnmarshallerFactory.getInstance().receptionCteSync(xml).getValue());
    }
}
