package org.dfe.services.cte.status_service;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.services.CteSefazService;
import org.dfe.models.cte.status_service.CteReturnStatusService;
import org.dfe.models.cte.status_service.CteStatusService;
import org.dfe.models.cte.status_service.CteStatusServiceRequest;

public interface CteStatusServiceService extends CteSefazService {


    /**
     * It returns the status of the CTe service.
     *
     * @param uf          The state of the CTe.
     * @param environment Environment.HOMOLOGATION or Environment.PRODUCTION
     * @return A CteReturnStatusService object.
     */
    default CteReturnStatusService statusService(UF uf, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteConfig config = getConfig().withEnviroment(environment).withWebServiceUf(uf);
        return CteReturnStatusService
                .builder()
                .build()
                .fromObject(getProviderFactory().getCteService(config)
                        .statusService(CteStatusServiceRequest
                                .builder()
                                .data(CteStatusService.builder().tpAmb(environment.getCode()).build().toObject())
                                .validators(getValidatorFactory().cteValidator().statusServiceValidators())
                                .afterRequest(getProcess().afterStatusService())
                                .beforeRequest(getProcess().beforeStatusService())
                                .configureProvider(getConfigureProviderFactory())
                                .config(config)
                                .build()
                        ).second());
    }


    /**
     * It returns the status of the CTe service.
     *
     * @return A CteReturnStatusService object.
     */
    default CteReturnStatusService statusService() throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return statusService(getConfig().uf(), getConfig().environment());
    }

}
