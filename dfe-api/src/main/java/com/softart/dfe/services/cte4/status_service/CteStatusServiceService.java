package com.softart.dfe.services.cte4.status_service;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.services.Cte4SefazService;
import com.softart.dfe.models.cte4.status_service.CteReturnStatusService;
import com.softart.dfe.models.cte4.status_service.CteStatusService;
import com.softart.dfe.models.cte4.status_service.CteStatusServiceRequest;

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
