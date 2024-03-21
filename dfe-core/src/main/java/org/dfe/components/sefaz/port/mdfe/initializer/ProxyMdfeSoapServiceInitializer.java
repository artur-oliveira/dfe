package org.dfe.components.sefaz.port.mdfe.initializer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dfe.components.sefaz.port.SoapServiceInitializer;
import org.dfe.components.sefaz.port.SoapServiceProxy;
import org.dfe.components.sefaz.port.mdfe.AbstractMdfeSoapService;
import org.dfe.exceptions.port.SoapServiceInitializationException;
import org.dfe.interfaces.sefaz.port.MdfeSoapService;

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
