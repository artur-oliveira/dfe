package com.softart.dfe.models.cte4.status_service;

import br.inf.portalfiscal.cte.send400.TConsStatServ;
import br.inf.portalfiscal.cte.send400.TRetConsStatServ;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.cte4.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.cte4.status_service.BeforeStatusService;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.cte4.Cte4StatusServiceValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
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
