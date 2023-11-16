package org.dfe.services.cte4.status_service;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.services.Cte4SefazService;
import org.dfe.models.cte4.status_service.CteReturnStatusService;
import org.dfe.models.cte4.status_service.CteStatusService;
import org.dfe.models.cte4.status_service.CteStatusServiceRequest;

public interface CteStatusServiceService extends Cte4SefazService {


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
                .fromObject(getProviderFactory().getCte4Service(config)
                        .statusService(CteStatusServiceRequest
                                .builder()
                                .data(CteStatusService.builder().cuf(uf.getCode()).tpAmb(environment.getCode()).build().toObject())
                                .validators(getValidatorFactory().cte4Validator().statusServiceValidators())
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
