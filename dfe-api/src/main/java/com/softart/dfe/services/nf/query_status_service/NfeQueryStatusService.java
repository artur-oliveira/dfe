package com.softart.dfe.services.nf.query_status_service;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;

public interface NfeQueryStatusService extends NfQueryStatusService {

    @Override
    default NfCommonValidator getValidator() {
        return getValidatorFactory().nfeValidator();
    }

    @Override
    default NfCommonService getService(UF uf, Environment environment) throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfeService(getConfig().withWebServiceUf(uf).withEnviroment(environment));
    }

    @Override
    NfeConfig getConfig();
}
