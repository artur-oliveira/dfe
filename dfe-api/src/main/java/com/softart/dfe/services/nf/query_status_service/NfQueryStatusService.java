package com.softart.dfe.services.nf.query_status_service;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.models.nf.query_status_service.QueryStatusServiceNf;
import com.softart.dfe.models.nf.query_status_service.QueryStatusServiceRequest;
import com.softart.dfe.models.nf.query_status_service.ReturnQueryStatusServiceNf;

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
