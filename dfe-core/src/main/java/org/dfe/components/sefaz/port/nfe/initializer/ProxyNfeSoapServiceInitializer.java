package org.dfe.components.sefaz.port.nfe.initializer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dfe.components.sefaz.port.SoapServiceInitializer;
import org.dfe.components.sefaz.port.SoapServiceProxy;
import org.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import org.dfe.exceptions.port.SoapServiceInitializationException;
import org.dfe.interfaces.sefaz.port.NfeSoapService;

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
