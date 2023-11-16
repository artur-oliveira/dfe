package org.dfe.services.nf.query_status_service;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.sefaz.nf.common.NfCommonService;
import org.dfe.interfaces.services.NfSefazService;
import org.dfe.interfaces.validation.nf.common.NfCommonValidator;
import org.dfe.models.nf.query_status_service.QueryStatusServiceNf;
import org.dfe.models.nf.query_status_service.QueryStatusServiceRequest;
import org.dfe.models.nf.query_status_service.ReturnQueryStatusServiceNf;

public interface NfQueryStatusService extends NfSefazService {

    /**
     * A function that returns the status of the NF-e.
     *
     * @return A ReturnQueryStatusServiceNf object.
     */
    default ReturnQueryStatusServiceNf queryStatusService() throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryStatusService(getConfig().uf(), getConfig().environment());
    }

    default ReturnQueryStatusServiceNf queryStatusService(UF uf, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return ReturnQueryStatusServiceNf
                .builder()
                .build()
                .fromObject(getService(uf, environment)
                        .queryStatusService(QueryStatusServiceRequest
                                .builder()
                                .data(QueryStatusServiceNf
                                        .builder()
                                        .cuf(uf.getCode())
                                        .tpAmb(environment.getCode()).build().toObject())
                                .validators(getValidator().queryStatusServiceValidators())
                                .afterRequest(getProcess().afterQueryStatusService())
                                .beforeRequest(getProcess().beforeQueryStatusService())
                                .configureProvider(getConfigureProviderFactory())
                                .config(getConfig().withWebServiceUf(uf).withEnviroment(environment))
                                .build()
                        ).second());
    }

    /**
     * Returns the validator used by this class
     *
     * @return The validator object.
     */
    NfCommonValidator getValidator();

    /**
     * * If the service is already instantiated, return it.
     * * If the service is not instantiated, try to instantiate it.
     * * If the service cannot be instantiated, throw an exception
     *
     * @return The service object.
     */
    NfCommonService getService(UF uf, Environment environment) throws NoProviderFound, SoapServiceGeneralException;
}
