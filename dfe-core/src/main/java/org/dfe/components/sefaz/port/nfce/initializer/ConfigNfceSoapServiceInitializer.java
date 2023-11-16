package org.dfe.components.sefaz.port.nfce.initializer;

import org.dfe.components.sefaz.port.SoapServiceInitializer;
import org.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import org.dfe.exceptions.port.SoapServiceInitializationException;
import org.dfe.exceptions.security.SSLContextException;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public final class ConfigNfceSoapServiceInitializer extends SoapServiceInitializer<AbstractNfceSoapService> {

    private ConfigNfceSoapServiceInitializer next;

    @Override
    public void initialize(AbstractNfceSoapService soapService) throws SoapServiceInitializationException {
        try {
            soapService.initialize(soapService.getConfig());
        } catch (SSLContextException e) {
            throw new SoapServiceInitializationException(e);
        }
        initializeNext(soapService);
    }
}
