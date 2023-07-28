package com.softart.dfe.services.nf.authorization;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;

public interface NfeAuthorizationService extends NfAuthorizationService {
    @Override
    default NfCommonService getService(Environment environment) throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfeService(getConfig().withEnviroment(environment));
    }

    @Override
    default NfCommonValidator getValidator() {
        return getValidatorFactory().nfeValidator();
    }

    @Override
    NfeConfig getConfig();
}
