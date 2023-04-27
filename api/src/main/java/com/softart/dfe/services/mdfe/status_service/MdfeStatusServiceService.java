package com.softart.dfe.services.mdfe.status_service;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.services.MdfeSefazService;
import com.softart.dfe.models.mdfe.status_service.MdfeReturnStatusService;
import com.softart.dfe.models.mdfe.status_service.MdfeStatusService;
import com.softart.dfe.models.mdfe.status_service.MdfeStatusServiceRequest;

public interface MdfeStatusServiceService extends MdfeSefazService {

    /**
     * It returns the status of the MDFe.
     *
     * @param uf          The state where the MDFe will be issued.
     * @param environment Environment.PRODUCTION or Environment.HOMOLOGATION
     * @return A MdfeReturnStatusService object.
     */
    default MdfeReturnStatusService statusService(UF uf, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeConfig config = getConfig().withWebServiceUf(uf).withEnviroment(environment);
        return MdfeReturnStatusService
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(config)
                        .statusService(MdfeStatusServiceRequest
                                .builder()
                                .data(MdfeStatusService.builder().tpAmb(environment.getCode()).build().toObject())
                                .config(config)
                                .signer(getXmlSigner())
                                .validators(getValidatorFactory().mdfeValidator().statusServiceValidators())
                                .afterRequest(getProcess().afterStatusService())
                                .beforeRequest(getProcess().beforeStatusService())
                                .configureProvider(getConfigureProviderFactory())
                                .build()));
    }

    /**
     * It returns a service that can be used to query the status of a MDF-e
     *
     * @return A service that can be used to query the status of a MDFe.
     */
    default MdfeReturnStatusService statusService() throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return statusService(getConfig().uf(), getConfig().environment());
    }

}
