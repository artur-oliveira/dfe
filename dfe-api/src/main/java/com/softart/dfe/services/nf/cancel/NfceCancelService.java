package com.softart.dfe.services.nf.cancel;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.services.nf.query_protocol.NfceQueryProtocolService;


public interface NfceCancelService extends NfCancelService {

    @Override
    default NfCommonService getService(Environment environment) throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfceService(getConfig().withEnviroment(environment));
    }

    @Override
    default NfCommonValidator getValidator() {
        return getValidatorFactory().nfeValidator();
    }

    @Override
    NfceQueryProtocolService getNfQueryProtocolService();

    @Override
    NfceConfig getConfig();

}
