package com.softart.dfe.services.nf.epec;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.nf.epec.NfeEpecRequest;
import com.softart.dfe.models.nf.epec.ReturnNfeEpec;
import com.softart.dfe.models.nf.epec.SendNfeEpec;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractNfeEpecService implements NfeEpecService {

    @Override
    public ReturnNfeEpec epec(SendNfeEpec sendNfeEpec) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return ReturnNfeEpec.builder().build().fromObject(getProviderFactory()
                .getNfeService(getConfig())
                .epec(NfeEpecRequest
                        .builder()
                        .data(sendNfeEpec.toObject())
                        .config(getConfig())
                        .signer(getXmlSigner())
                        .validators(getValidatorFactory().nfeValidator().epecValidators())
                        .afterRequest(getProcess().afterEpec())
                        .beforeRequest(getProcess().beforeEpec())
                        .configureProvider(getConfigureProviderFactory())
                        .build()).second());
    }
}
