package com.softart.dfe.services.cte.reception;

import br.inf.portalfiscal.cte.send.TEnviCTe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.reception.Cte;
import com.softart.dfe.models.cte.reception.CteRequest;
import com.softart.dfe.models.cte.reception.CteReturnSend;
import com.softart.dfe.models.cte.reception.CteSend;

import java.util.Collections;

public interface CteReceptionService extends CteSefazService {

    default CteReturnSend reception(TEnviCTe enviCTe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return CteReturnSend
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getCteService(getConfig())
                        .reception(CteRequest
                                .builder()
                                .config(getConfig())
                                .signer(getXmlSigner())
                                .data(enviCTe)
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidatorFactory().cteValidator().receptionCteValidators())
                                .beforeRequest(getProcess().beforeReception())
                                .afterRequest(getProcess().afterReception())
                                .build()));
    }

    default CteReturnSend reception(CteSend cteSend) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return reception(cteSend.toObject());
    }

    default CteReturnSend reception(Cte cte) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return reception(CteSend.builder().cTe(Collections.singletonList(cte)).build());
    }
}
