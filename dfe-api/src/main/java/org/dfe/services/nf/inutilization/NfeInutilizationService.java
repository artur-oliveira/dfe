package org.dfe.services.nf.inutilization;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.Model;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.NfeConfig;
import org.dfe.interfaces.sefaz.nf.common.NfCommonService;
import org.dfe.interfaces.validation.nf.common.NfCommonValidator;

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
