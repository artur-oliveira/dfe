package org.dfe.models.cte4.status_service;

import br.inf.portalfiscal.cte.send400.TConsStatServ;
import br.inf.portalfiscal.cte.send400.TRetConsStatServ;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte4.status_service.AfterStatusService;
import org.dfe.interfaces.process.cte4.status_service.BeforeStatusService;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte4.Cte4StatusServiceValidator;
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
        Collection<Cte4StatusServiceValidator> validators,
        Collection<BeforeStatusService> beforeRequest,
        Collection<AfterStatusService> afterRequest
) implements SefazRequest<TConsStatServ, TRetConsStatServ> {


}
