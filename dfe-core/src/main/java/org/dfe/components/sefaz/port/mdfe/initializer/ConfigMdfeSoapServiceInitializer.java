package org.dfe.components.sefaz.port.mdfe.initializer;

import org.dfe.components.sefaz.port.SoapServiceInitializer;
import org.dfe.components.sefaz.port.mdfe.AbstractMdfeSoapService;
import org.dfe.exceptions.port.SoapServiceInitializationException;
import org.dfe.exceptions.security.SSLContextException;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public final class ConfigMdfeSoapServiceInitializer extends SoapServiceInitializer<AbstractMdfeSoapService> {
    @Override
    public void initialize(AbstractMdfeSoapService soapService) throws SoapServiceInitializationException {
        try {
            soapService.initialize(soapService.getConfig());
        } catch (SSLContextException e) {
            throw new SoapServiceInitializationException(e);
        }
        initializeNext(soapService);
    }
}
