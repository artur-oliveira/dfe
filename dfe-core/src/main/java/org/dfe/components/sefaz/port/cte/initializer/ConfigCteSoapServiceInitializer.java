package org.dfe.components.sefaz.port.cte.initializer;

import org.dfe.components.sefaz.port.SoapServiceInitializer;
import org.dfe.components.sefaz.port.cte.AbstractCteSoapService;
import org.dfe.exceptions.port.SoapServiceInitializationException;
import org.dfe.exceptions.security.SSLContextException;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public final class ConfigCteSoapServiceInitializer extends SoapServiceInitializer<AbstractCteSoapService> {

    private ConfigCteSoapServiceInitializer next;

    @Override
    public void initialize(AbstractCteSoapService soapService) throws SoapServiceInitializationException {
        try {
            soapService.initialize(soapService.getConfig());
        } catch (SSLContextException e) {
            throw new SoapServiceInitializationException(e);
        }
        initializeNext(soapService);
    }
}
