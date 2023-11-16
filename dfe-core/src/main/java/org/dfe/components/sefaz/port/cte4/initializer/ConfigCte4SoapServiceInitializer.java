package org.dfe.components.sefaz.port.cte4.initializer;

import org.dfe.components.sefaz.port.SoapServiceInitializer;
import org.dfe.components.sefaz.port.cte4.AbstractCte4SoapService;
import org.dfe.exceptions.port.SoapServiceInitializationException;
import org.dfe.exceptions.security.SSLContextException;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public final class ConfigCte4SoapServiceInitializer extends SoapServiceInitializer<AbstractCte4SoapService> {

    private ConfigCte4SoapServiceInitializer next;

    @Override
    public void initialize(AbstractCte4SoapService soapService) throws SoapServiceInitializationException {
        try {
            soapService.initialize(soapService.getConfig());
        } catch (SSLContextException e) {
            throw new SoapServiceInitializationException(e);
        }
        initializeNext(soapService);
    }
}
