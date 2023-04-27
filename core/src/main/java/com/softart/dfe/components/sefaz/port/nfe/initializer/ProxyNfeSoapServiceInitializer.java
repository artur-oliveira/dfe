package com.softart.dfe.components.sefaz.port.nfe.initializer;

import com.softart.dfe.components.sefaz.port.SoapServiceInitializer;
import com.softart.dfe.components.sefaz.port.SoapServiceProxy;
import com.softart.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import com.softart.dfe.exceptions.port.SoapServiceInitializationException;
import com.softart.dfe.interfaces.sefaz.port.NfeSoapService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public final class ProxyNfeSoapServiceInitializer extends SoapServiceInitializer<AbstractNfeSoapService> {

    @Override
    public void initialize(AbstractNfeSoapService soapService) throws SoapServiceInitializationException {
        NfeSoapService nfeSoapService = SoapServiceProxy.getInstance().getNfeService(soapService.getAuthorizer());
        if (Objects.nonNull(nfeSoapService)) {
            soapService.initialize(nfeSoapService);
        }
        initializeNext(soapService);
    }
}
