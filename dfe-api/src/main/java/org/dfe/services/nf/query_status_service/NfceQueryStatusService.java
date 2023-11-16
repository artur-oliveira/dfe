package org.dfe.services.nf.query_status_service;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.NfceConfig;
import org.dfe.interfaces.sefaz.nf.common.NfCommonService;
import org.dfe.interfaces.validation.nf.common.NfCommonValidator;

public interface NfceQueryStatusService extends NfQueryStatusService {

    @Override
    default NfCommonValidator getValidator() {
        return getValidatorFactory().nfceValidator();
    }

    @Override
    default NfCommonService getService(UF uf, Environment environment) throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfceService(getConfig().withWebServiceUf(uf).withEnviroment(environment));
    }

    @Override
    NfceConfig getConfig();
}
