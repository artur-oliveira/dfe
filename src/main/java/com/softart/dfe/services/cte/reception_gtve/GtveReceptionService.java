package com.softart.dfe.services.cte.reception_gtve;

import br.inf.portalfiscal.cte.send.TGTVe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.reception_gtve.Gtve;
import com.softart.dfe.models.cte.reception_gtve.GtveRequest;
import com.softart.dfe.models.cte.reception_gtve.GtveReturn;

public interface GtveReceptionService extends CteSefazService {

    default GtveReturn receptionGtve(TGTVe tgtVe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return GtveReturn
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getCteService(getConfig())
                        .receptionGtve(GtveRequest
                                .builder()
                                .config(getConfig())
                                .signer(getXmlSigner())
                                .data(tgtVe)
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidatorFactory().cteValidator().receptionGtveValidators())
                                .beforeRequest(getProcess().beforeGtve())
                                .afterRequest(getProcess().afterGtve())
                                .build()));
    }

    default GtveReturn receptionGtve(Gtve gtve) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionGtve(gtve.toObject());
    }

}
