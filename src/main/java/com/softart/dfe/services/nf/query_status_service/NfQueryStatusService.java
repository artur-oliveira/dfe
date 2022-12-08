package com.softart.dfe.services.nf.query_status_service;

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

    default ReturnQueryStatusServiceNf queryStatusService() throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return ReturnQueryStatusServiceNf
                .builder()
                .build()
                .fromObject(getService()
                        .queryStatusService(QueryStatusServiceRequest
                                .builder()
                                .data(QueryStatusServiceNf
                                        .builder()
                                        .cuf(getConfig().uf().getCode())
                                        .tpAmb(getConfig().environment().getCode()).build().toObject())
                                .validators(getValidator().queryStatusServiceValidators())
                                .afterRequest(getProcess().afterQueryStatusService())
                                .beforeRequest(getProcess().beforeQueryStatusService())
                                .configureProvider(getConfigureProviderFactory())
                                .config(getConfig())
                                .build()
                        ).second());
    }

    NfCommonValidator getValidator();

    NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException;
}
