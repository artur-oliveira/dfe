package org.dfe.components.sefaz.port.nfe.initializer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dfe.components.sefaz.port.SoapServiceInitializer;
import org.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import org.dfe.exceptions.port.SoapServiceInitializationException;
import org.dfe.exceptions.security.SSLContextException;

@EqualsAndHashCode(callSuper = true)
@Data
public final class ConfigNfeSoapServiceInitializer extends SoapServiceInitializer<AbstractNfeSoapService> {

    private ConfigNfeSoapServiceInitializer next;

    @Override
    public void initialize(AbstractNfeSoapService soapService) throws SoapServiceInitializationException {
        try {
            soapService.initialize(soapService.getConfig());
        } catch (SSLContextException e) {
            throw new SoapServiceInitializationException(e);
        }
        initializeNext(soapService);
    }
}
