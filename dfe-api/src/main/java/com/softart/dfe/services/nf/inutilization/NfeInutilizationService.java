package com.softart.dfe.services.nf.inutilization;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;

public interface NfeInutilizationService extends NfInutilizationService {

    @Override
    default NfCommonValidator getValidator() {
        return getValidatorFactory().nfeValidator();
    }

    @Override
    default NfCommonService getService(Environment environment) throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfeService(getConfig().withEnviroment(environment));
    }

    @Override
    NfeConfig getConfig();

    @Override
    default Model getModel() {
        return Model.NFE;
    }
}
