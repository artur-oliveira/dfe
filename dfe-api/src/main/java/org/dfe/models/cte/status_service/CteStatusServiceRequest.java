package org.dfe.models.cte.status_service;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import br.inf.portalfiscal.cte.send.TRetConsStatServ;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte.status_service.AfterStatusService;
import org.dfe.interfaces.process.cte.status_service.BeforeStatusService;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte.CteStatusServiceValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record CteStatusServiceRequest(
        TConsStatServ data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<CteStatusServiceValidator> validators,
        Collection<BeforeStatusService> beforeRequest,
        Collection<AfterStatusService> afterRequest
) implements SefazRequest<TConsStatServ, TRetConsStatServ> {


}
