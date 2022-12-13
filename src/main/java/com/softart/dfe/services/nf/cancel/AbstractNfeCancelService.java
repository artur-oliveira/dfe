package com.softart.dfe.services.nf.cancel;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.models.nf.cancel.ReturnNfeCancel;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractNfeCancelService implements NfCancelService {

    @Override
    public NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfeService(getConfig());
    }

    @Override
    public NfCommonValidator getValidator() {
        return getValidatorFactory().nfeValidator();
    }

    @Override
    public ReturnNfeCancel cancel(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, String.valueOf(getNfQueryProtocolService().queryProtocol(accessKey).getProtNFe().getInfProt().getNProt()));
    }

    protected abstract NfQueryProtocolService getNfQueryProtocolService();
}
