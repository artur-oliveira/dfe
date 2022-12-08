package com.softart.dfe.services.nf.cancel;

import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractNfceCancelService extends AbstractNfeCancelService {

    @Override
    public NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfceService(getConfig());
    }

    @Override
    public NfCommonValidator getValidator() {
        return getValidatorFactory().nfceValidator();
    }
}
