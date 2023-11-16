package org.dfe.components.sefaz.port.cte.initializer;

import org.dfe.components.sefaz.port.SoapServiceInitializer;
import org.dfe.components.sefaz.port.SoapServiceProxy;
import org.dfe.components.sefaz.port.cte.AbstractCteSoapService;
import org.dfe.exceptions.port.SoapServiceInitializationException;
import org.dfe.interfaces.sefaz.port.CteSoapService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public final class ProxyCteSoapServiceInitializer extends SoapServiceInitializer<AbstractCteSoapService> {

    @Override
    public void initialize(AbstractCteSoapService soapService) throws SoapServiceInitializationException {
        CteSoapService cteService = SoapServiceProxy.getInstance().getCteService(soapService.getAuthorizer());
        if (Objects.nonNull(cteService)) {
            soapService.initialize(cteService);
        }
        initializeNext(soapService);
    }
}
