package org.dfe.components.sefaz.port.nfce.initializer;

import org.dfe.components.sefaz.port.SoapServiceInitializer;
import org.dfe.components.sefaz.port.SoapServiceProxy;
import org.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import org.dfe.exceptions.port.SoapServiceInitializationException;
import org.dfe.interfaces.sefaz.port.NfceSoapService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public final class ProxyNfceSoapServiceInitializer extends SoapServiceInitializer<AbstractNfceSoapService> {

    @Override
    public void initialize(AbstractNfceSoapService soapService) throws SoapServiceInitializationException {
        NfceSoapService nfeSoapService = SoapServiceProxy.getInstance().getNfceService(soapService.getAuthorizer());
        if (Objects.nonNull(nfeSoapService)) {
            soapService.initialize(nfeSoapService);
        }
        initializeNext(soapService);
    }
}
