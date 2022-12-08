package com.softart.dfe.services.nf.inutilization;

import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractNfeInutilizationService implements NfInutilizationService {

    @Override
    public NfCommonValidator getValidator() {
        return getValidatorFactory().nfeValidator();
    }

    @Override
    public NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfeService(getConfig());
    }

    @Override
    public Model getModel() {
        return Model.NFE;
    }
}
