package com.softart.dfe.components.sefaz.port.cte.initializer;

import com.softart.dfe.components.sefaz.port.SoapServiceInitializer;
import com.softart.dfe.components.sefaz.port.SoapServiceProxy;
import com.softart.dfe.components.sefaz.port.cte.AbstractCteSoapService;
import com.softart.dfe.exceptions.port.SoapServiceInitializationException;
import com.softart.dfe.interfaces.sefaz.port.CteSoapService;
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
