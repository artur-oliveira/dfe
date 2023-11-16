package org.dfe.services.nf.authorization;

import org.dfe.enums.internal.Environment;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.NfceConfig;
import org.dfe.interfaces.sefaz.nf.common.NfCommonService;
import org.dfe.interfaces.validation.nf.common.NfCommonValidator;

public interface NfceAuthorizationService extends NfAuthorizationService {
    @Override
    default NfCommonService getService(Environment environment) throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfceService(getConfig().withEnviroment(environment));
    }

    @Override
    default NfCommonValidator getValidator() {
        return getValidatorFactory().nfceValidator();
    }

    @Override
    NfceConfig getConfig();
}
