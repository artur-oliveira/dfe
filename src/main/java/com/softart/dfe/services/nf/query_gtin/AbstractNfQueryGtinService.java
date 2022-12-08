package com.softart.dfe.services.nf.query_gtin;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.nf.query_gtin.QueryGtinNf;
import com.softart.dfe.models.nf.query_gtin.QueryGtinRequest;
import com.softart.dfe.models.nf.query_gtin.ReturnQueryGtinNf;

public abstract class AbstractNfQueryGtinService implements NfQueryGtinService {

    @Override
    public ReturnQueryGtinNf queryGtin(String gtin) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return ReturnQueryGtinNf
                .builder()
                .build()
                .fromObject(
                        getProviderFactory().getNfeService(getConfig())
                                .queryGtin(QueryGtinRequest
                                        .builder()
                                        .data(QueryGtinNf.builder().gtin(gtin).build().toObject())
                                        .validators(getValidatorFactory().nfeValidator().queryGtinValidators())
                                        .afterRequest(getProcess().afterQueryGtin())
                                        .beforeRequest(getProcess().beforeQueryGtin())
                                        .config(getConfig())
                                        .configureProvider(getConfigureProviderFactory())
                                        .build())
                                .second()
                );
    }

}
