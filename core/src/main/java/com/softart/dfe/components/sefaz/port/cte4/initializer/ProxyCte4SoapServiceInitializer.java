package com.softart.dfe.components.sefaz.port.cte4.initializer;

import com.softart.dfe.components.sefaz.port.SoapServiceInitializer;
import com.softart.dfe.components.sefaz.port.SoapServiceProxy;
import com.softart.dfe.components.sefaz.port.cte4.AbstractCte4SoapService;
import com.softart.dfe.exceptions.port.SoapServiceInitializationException;
import com.softart.dfe.interfaces.sefaz.port.CteSoapService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public final class ProxyCte4SoapServiceInitializer extends SoapServiceInitializer<AbstractCte4SoapService> {

    @Override
    public void initialize(AbstractCte4SoapService soapService) throws SoapServiceInitializationException {
        CteSoapService cteService = SoapServiceProxy.getInstance().getCteService(soapService.getAuthorizer());
        if (Objects.nonNull(cteService)) {
            soapService.initialize(cteService);
        }
        initializeNext(soapService);
    }
}
