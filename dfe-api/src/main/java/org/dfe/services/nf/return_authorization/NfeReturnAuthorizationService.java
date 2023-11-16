package org.dfe.services.nf.return_authorization;

import org.dfe.enums.internal.Environment;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.NfeConfig;
import org.dfe.interfaces.sefaz.nf.common.NfCommonService;
import org.dfe.interfaces.validation.nf.common.NfCommonValidator;

public interface NfeReturnAuthorizationService extends NfReturnAuthorizationService {

    @Override
    default NfCommonValidator getValidator() {
        return getValidatorFactory().nfeValidator();
    }

    @Override
    default NfCommonService getService(Environment environment) throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfeService(getConfig());
    }

    @Override
    NfeConfig getConfig();
}
