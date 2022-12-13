package com.softart.dfe.services.cte.status_service;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.status_service.CteReturnStatusService;
import com.softart.dfe.models.cte.status_service.CteStatusService;
import com.softart.dfe.models.cte.status_service.CteStatusServiceRequest;

public interface CteStatusServiceService extends CteSefazService {

    /**
     * A function that returns the status of the CTe.
     *
     * @param tConsStatServ The object that contains the data to be sent to the SEFAZ.
     * @return A CteReturnStatusService object.
     */
    default CteReturnStatusService statusService(TConsStatServ tConsStatServ) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return CteReturnStatusService
                .builder()
                .build()
                .fromObject(getProviderFactory().getCteService(getConfig())
                        .statusService(CteStatusServiceRequest
                                .builder()
                                .data(tConsStatServ)
                                .validators(getValidatorFactory().cteValidator().statusServiceValidators())
                                .afterRequest(getProcess().afterStatusService())
                                .beforeRequest(getProcess().beforeStatusService())
                                .configureProvider(getConfigureProviderFactory())
                                .config(getConfig())
                                .build()
                        ).second());
    }

    /**
     * It returns a CteReturnStatusService object, which is a wrapper for the CteStatusService object
     *
     * @return A CteReturnStatusService object.
     */
    default CteReturnStatusService statusService() throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return statusService(CteStatusService
                .builder()
                .tpAmb(getConfig().environment().getCode())
                .build()
                .toObject());
    }

}
