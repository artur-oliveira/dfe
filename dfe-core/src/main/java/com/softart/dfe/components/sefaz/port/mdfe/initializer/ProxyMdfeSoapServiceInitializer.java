package com.softart.dfe.components.sefaz.port.mdfe.initializer;

import com.softart.dfe.components.sefaz.port.SoapServiceInitializer;
import com.softart.dfe.components.sefaz.port.SoapServiceProxy;
import com.softart.dfe.components.sefaz.port.mdfe.AbstractMdfeSoapService;
import com.softart.dfe.exceptions.port.SoapServiceInitializationException;
import com.softart.dfe.interfaces.sefaz.port.MdfeSoapService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public final class ProxyMdfeSoapServiceInitializer extends SoapServiceInitializer<AbstractMdfeSoapService> {

    @Override
    public void initialize(AbstractMdfeSoapService soapService) throws SoapServiceInitializationException {
        MdfeSoapService service = SoapServiceProxy.getInstance().getMdfeService(soapService.getAuthorizer());
        if (Objects.nonNull(service)) {
            soapService.initialize(service);
        }
        initializeNext(soapService);
    }
}
