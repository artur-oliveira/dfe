package com.softart.dfe.services.cte.reception_sync;

import br.inf.portalfiscal.cte.send.TCTe;
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

    default CteReturn receptionSync(Cte cte) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionSync(cte.toObject());
    }
}
