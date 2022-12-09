package com.softart.dfe.services.cte.reception_os;

import br.inf.portalfiscal.cte.send.TCTeOS;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.reception_os.CteOs;
import com.softart.dfe.models.cte.reception_os.CteOsRequest;
import com.softart.dfe.models.cte.reception_os.CteOsReturn;

public interface CteOsReceptionService extends CteSefazService {

    default CteOsReturn receptionOs(TCTeOS tcTeOS) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return CteOsReturn
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getCteService(getConfig())
                        .receptionOs(CteOsRequest
                                .builder()
                                .config(getConfig())
                                .signer(getXmlSigner())
                                .data(tcTeOS)
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidatorFactory().cteValidator().receptionCteOsValidators())
                                .beforeRequest(getProcess().beforeCteOs())
                                .afterRequest(getProcess().afterCteOs())
                                .build()));
    }

    default CteOsReturn receptionOs(CteOs cteOs) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionOs(cteOs.toObject());
    }

}
