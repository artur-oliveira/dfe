package org.dfe.components.sefaz.port.cte4.initializer;

import org.dfe.components.sefaz.port.SoapServiceInitializer;
import org.dfe.components.sefaz.port.SoapServiceProxy;
import org.dfe.components.sefaz.port.cte4.AbstractCte4SoapService;
import org.dfe.exceptions.port.SoapServiceInitializationException;
import org.dfe.interfaces.sefaz.port.Cte4SoapService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public final class ProxyCte4SoapServiceInitializer extends SoapServiceInitializer<AbstractCte4SoapService> {

    @Override
    public void initialize(AbstractCte4SoapService soapService) throws SoapServiceInitializationException {
        Cte4SoapService cteService = SoapServiceProxy.getInstance().getCte4Service(soapService.getAuthorizer());
        if (Objects.nonNull(cteService)) {
            soapService.initialize(cteService);
        }
        initializeNext(soapService);
    }
}
