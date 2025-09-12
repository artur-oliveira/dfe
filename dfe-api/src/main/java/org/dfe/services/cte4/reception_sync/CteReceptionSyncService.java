package org.dfe.services.cte4.reception_sync;

import br.inf.portalfiscal.cte.send400.TCTe;
import br.inf.portalfiscal.cte.send400.TRetCTe;
import org.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import org.dfe.enums.internal.Model;
import org.dfe.exceptions.CircuitBreakerException;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.circuitbreaker.DfeOperation;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.sefaz.cte4.Cte4Service;
import org.dfe.interfaces.services.Cte4SefazService;
import org.dfe.models.cte4.reception_sync.Cte;
import org.dfe.models.cte4.reception_sync.CteReturn;
import org.dfe.models.cte4.reception_sync.CteSyncRequest;

public interface CteReceptionSyncService extends Cte4SefazService {
    /**
     * It receives a Cte object and returns a CteReturn object.
     *
     * @param tcTe The CTe object to be sent.
     * @return A CteReturn object.
     */
    default CteReturn receptionSync(TCTe tcTe) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteConfig config = getConfig()
                .withEnviroment(tcTe.getInfCte().getIde().getTpAmb())
                .withWebServiceUf(tcTe.getInfCte().getIde().getCUF())
                .withEmissionType(tcTe.getInfCte().getIde().getTpEmis());

        Cte4Service service = getProviderFactory().getCte4Service(config);
        Pair<?, TRetCTe> res = getCircuitBreakerRegistry().get(
                config.environment(),
                Model.CTE,
                config.webServiceUF(),
                DfeOperation.AUTHORIZATION
        ).execute(() -> service.receptionSync(CteSyncRequest
                .builder()
                .config(config)
                .signer(getXmlSigner())
                .data(tcTe)
                .configureProvider(getConfigureProviderFactory())
                .validators(getValidatorFactory().cte4Validator().receptionCteSyncValidators())
                .beforeRequest(getProcess().beforeCteSync())
                .afterRequest(getProcess().afterCteSync())
                .build()));

        return new CteReturn().fromObject(res);
    }

    /**
     * It converts the Cte object to a CteObject and then calls the function receptionSync(CteObject cte)
     *
     * @param cte The Cte object to be sent.
     * @return The CteReturn object.
     */
    default CteReturn receptionSync(Cte cte) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionSync(cte.toObject());
    }

    /**
     * It receives a CTe XML, unmarshalls it, and then calls the function that actually does the work
     *
     * @param xml XML string to be sent to the SEFAZ.
     * @return The CteReturn object.
     */
    default CteReturn receptionSync(String xml) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionSync(CteUnmarshallerFactory.getInstance().receptionCteSync400(xml).getValue());
    }
}
